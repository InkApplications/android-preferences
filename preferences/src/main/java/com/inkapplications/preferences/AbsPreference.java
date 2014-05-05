package com.inkapplications.preferences;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

import static android.content.SharedPreferences.Editor;

/**
 * An abstract preference designed to be a convenient super class to concrete Preferences. This
 * class handles most preference functionality.
 * <p/>
 * Subclasses are free to override the implementation and specification of any of the methods in
 * this class as long as the general Preference contract for that method is obeyed.
 *
 * @param <T>
 */
public abstract class AbsPreference<T> implements Preference<T> {
  private final SharedPreferences preferences;
  private final String key;
  private final T defaultValue;

  interface PrefSaver {
    void save(Editor editor);
  }

  static class PrefSaverDefault implements PrefSaver {
    @Override public void save(Editor editor) {
      editor.commit();
    }
  }

  static class PrefSaverGingerbread implements PrefSaver {
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override public void save(Editor editor) {
      editor.apply();
    }
  }

  /**
   * Wrapper for saving the preference. Switches between
   * {@link android.content.SharedPreferences.Editor#commit()}, and
   * {@link android.content.SharedPreferences.Editor#apply()} based of of the api level
   */
  static final PrefSaver PREF_SAVER;

  static {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
      PREF_SAVER = new PrefSaverGingerbread();
    } else {
      PREF_SAVER = new PrefSaverDefault();
    }
  }

  /**
   * Constructor for subclasses to call.
   *
   * @param preferences  The SharedPreferences where the value the {@link Preference} implementation
   *                     will be stored.
   * @param key          The name of this preference.
   * @param defaultValue The value to return if {@link Preference#get()} is called and
   *                     {@link Preference#set(Object)} has not been called. This value maybe null
   *                     if the generic type the implementing subclass provides does not have a
   *                     corresponding primitive.
   */
  public AbsPreference(SharedPreferences preferences, String key, T defaultValue) {
    if (preferences == null) throw new NullPointerException("preferences");
    if (key == null) throw new NullPointerException("key");

    this.preferences = preferences;
    this.key = key;
    this.defaultValue = defaultValue;
  }

  /** {@inheritDoc} */
  @Override public boolean isSet() {
    return getPreferences().contains(key);
  }

  /** {@inheritDoc} */
  @Override public void delete() {
    Editor editor = getPreferences().edit().remove(key);
    PREF_SAVER.save(editor);
  }

  /** Get the underlying SharedPreference */
  protected SharedPreferences getPreferences() {
    return preferences;
  }

  /** Get the key/name of the preference */
  protected String getKey() {
    return key;
  }

  /** Get the default value of the preference */
  protected T getDefaultValue() {
    return defaultValue;
  }

  /** Get the implementation to save shared prefereneces based on api level */
  protected PrefSaver getPrefSaver() {
    return PREF_SAVER;
  }
}

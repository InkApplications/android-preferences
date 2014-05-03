package com.inkapplications.preferences;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

import static android.content.SharedPreferences.Editor;

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

  protected static final PrefSaver PREF_SAVER;
  static {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
      PREF_SAVER = new PrefSaverGingerbread();
    } else {
      PREF_SAVER = new PrefSaverDefault();
    }
  }

  public AbsPreference(SharedPreferences preferences, String key, T defaultValue) {
    if (preferences == null) throw new NullPointerException("preferences");
    if (key == null) throw new NullPointerException("key");

    this.preferences = preferences;
    this.key = key;
    this.defaultValue = defaultValue;
  }

  @Override public boolean isSet() {
    return getPreferences().contains(key);
  }

  @Override public void delete() {
    Editor editor = getPreferences().edit().remove(key);
    PREF_SAVER.save(editor);
  }

  protected SharedPreferences getPreferences() {
    return preferences;
  }

  protected String getKey() {
    return key;
  }

  T getDefaultValue() {
    return defaultValue;
  }
}

package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

/** Preference for a Boolean */
public class BooleanPreference extends AbsPreference<Boolean> {

  /**
   * Constructs a new {@link BooleanPreference} with the default value of false
   *
   * @param preferences SharedPreferences that this class will write to.
   * @param key         The key/name to refer to this preference as.
   */
  public BooleanPreference(SharedPreferences preferences, String key) {
    this(preferences, key, false);
  }

  /**
   * Constructs a new {@link BooleanPreference}
   *
   * @param preferences  SharedPreferences that this class will write to.
   * @param key          The key/name to refer to this preference as.
   * @param defaultValue The value to return if {@link #get()} is called and this
   *                     preference {@link #set(Boolean)} method has not been called.
   */
  public BooleanPreference(SharedPreferences preferences, String key, boolean defaultValue) {
    super(preferences, key, defaultValue);
  }

  /** Get the value the preference */
  @Override public Boolean get() {
    return getPreferences().getBoolean(getKey(), getDefaultValue());
  }

  /** Set the value for the preference */
  @Override public void set(Boolean value) {
    if (value == null) throw new NullPointerException("value");
    this.set((boolean) value);
  }

  /** Set the value for the preference */
  public void set(boolean value) {
    // Method created in an attempt to avoid unnecessary autoboxing
    Editor editor = getPreferences().edit().putBoolean(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

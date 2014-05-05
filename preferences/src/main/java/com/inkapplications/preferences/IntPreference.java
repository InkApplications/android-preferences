package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

/** Preference for a Integer */
public class IntPreference extends AbsPreference<Integer> {

  /**
   * Constructs a new {@link IntPreference} with the default value of 0
   *
   * @param preferences SharedPreferences that this class will write to.
   * @param key         The key/name to refer to this preference as.
   */
  public IntPreference(SharedPreferences preferences, String key) {
    this(preferences, key, 0);
  }

  /**
   * Constructs a new {@link IntPreference}
   *
   * @param preferences  SharedPreferences that this class will write to.
   * @param key          The key/name to refer to this preference as.
   * @param defaultValue The value to return if {@link #get()} is called and this
   *                     preference {@link #set(Integer)} method has not been called.
   */
  public IntPreference(SharedPreferences preferences, String key, int defaultValue) {
    super(preferences, key, defaultValue);
  }

  /** Get the value the preference */
  @Override public Integer get() {
    return getPreferences().getInt(getKey(), getDefaultValue());
  }

  /** Set the value for the preference */
  @Override public void set(Integer value) {
    if (value == null) throw new NullPointerException("value");
    this.set((int)value);
  }

  /** Set the value for the preference */
  public void set(int value) {
    // Method created in an attempt to avoid unnecessary autoboxing
    Editor editor = getPreferences().edit().putInt(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

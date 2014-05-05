package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

/** Preference for a Long */
public class LongPreference extends AbsPreference<Long> {

  /**
   * Constructs a new {@link LongPreference} with the default value of 0
   *
   * @param preferences SharedPreferences that this class will write to.
   * @param key         The key/name to refer to this preference as.
   */
  public LongPreference(SharedPreferences preferences, String key) {
    this(preferences, key, 0);
  }

  /**
   * Constructs a new {@link LongPreference}
   *
   * @param preferences  SharedPreferences that this class will write to.
   * @param key          The key/name to refer to this preference as.
   * @param defaultValue The value to return if {@link #get()} is called and this
   *                     preference {@link #set(Long)} method has not been called.
   */
  public LongPreference(SharedPreferences preferences, String key, long defaultValue) {
    super(preferences, key, defaultValue);
  }

  /** Get the value the preference */
  @Override public Long get() {
    return getPreferences().getLong(getKey(), getDefaultValue());
  }

  /** Set the value for the preference */
  @Override public void set(Long value) {
    if (value == null) throw new NullPointerException("value");
    this.set((long) value);
  }

  /** Set the value for the preference */
  public void set(long value) {
    Editor editor = getPreferences().edit().putLong(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

public class LongPreference extends AbsPreference<Long> {
  public LongPreference(SharedPreferences preferences, String key) {
    this(preferences, key, 0);
  }

  public LongPreference(SharedPreferences preferences, String key, long defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override public Long get() {
    return getPreferences().getLong(getKey(), getDefaultValue());
  }

  @Override public void set(Long value) {
    if (value == null) throw new NullPointerException("value");

    Editor editor = getPreferences().edit().putLong(getKey(), value);
    PREF_SAVER.save(editor);
  }

  public void set(long value) {
    Editor editor = getPreferences().edit().putLong(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

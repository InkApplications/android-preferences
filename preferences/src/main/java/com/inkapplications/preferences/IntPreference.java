package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

public class IntPreference extends AbsPreference<Integer> {
  public IntPreference(SharedPreferences preferences, String key) {
    this(preferences, key, 0);
  }

  public IntPreference(SharedPreferences preferences, String key, int defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override public Integer get() {
    return getPreferences().getInt(getKey(), getDefaultValue());
  }

  @Override public void set(Integer value) {
    if (value == null) throw new NullPointerException("value");

    Editor editor = getPreferences().edit().putInt(getKey(), value);
    PREF_SAVER.save(editor);
  }

  public void set(int value) {
    Editor editor = getPreferences().edit().putInt(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

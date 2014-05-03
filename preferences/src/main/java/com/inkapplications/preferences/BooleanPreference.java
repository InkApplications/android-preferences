package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

public class BooleanPreference extends AbsPreference<Boolean> {
  public BooleanPreference(SharedPreferences preferences, String key) {
    this(preferences, key, false);
  }

  public BooleanPreference(SharedPreferences preferences, String key, boolean defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override
  public Boolean get() {
    return getPreferences().getBoolean(getKey(), getDefaultValue());
  }

  @Override
  public void set(Boolean value) {
    if (value == null) throw new NullPointerException("value");

    Editor editor = getPreferences().edit().putBoolean(getKey(), value);
    PREF_SAVER.save(editor);
  }

  public void set(boolean value) {
    Editor editor = getPreferences().edit().putBoolean(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

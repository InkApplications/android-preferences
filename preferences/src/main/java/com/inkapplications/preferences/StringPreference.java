package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

public class StringPreference extends AbsPreference<String> {
  public StringPreference(SharedPreferences preferences, String key) {
    this(preferences, key, null);
  }

  public StringPreference(SharedPreferences preferences, String key, String defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override public String get() {
    return getPreferences().getString(getKey(), getDefaultValue());
  }

  @Override public void set(String value) {
    Editor editor = getPreferences().edit().putString(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

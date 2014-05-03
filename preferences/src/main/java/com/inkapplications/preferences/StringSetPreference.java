package com.inkapplications.preferences;

import android.content.SharedPreferences;

import java.util.Set;

import static android.content.SharedPreferences.Editor;

public class StringSetPreference extends AbsPreference<Set<String>> {
  public StringSetPreference(SharedPreferences preferences, String key) {
    this(preferences, key, null);
  }

  public StringSetPreference(SharedPreferences preferences, String key, Set<String> defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override public Set<String> get() {
    return getPreferences().getStringSet(getKey(), getDefaultValue());
  }

  @Override public void set(Set<String> value) {
    Editor editor = getPreferences().edit().putStringSet(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

package com.inkapplications.preferences;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

import java.util.Set;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
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
    getPreferences().edit().putStringSet(getKey(), value).apply();
  }
}

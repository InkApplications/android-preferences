package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

public class FloatPreference extends AbsPreference<Float> {
  public FloatPreference(SharedPreferences preferences, String key) {
    this(preferences, key, 0);
  }

  public FloatPreference(SharedPreferences preferences, String key, float defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override public Float get() {
    return getPreferences().getFloat(getKey(), getDefaultValue());
  }

  @Override public void set(Float value) {
    if (value == null) throw new NullPointerException("value");

    Editor editor = getPreferences().edit().putFloat(getKey(), value);
    PREF_SAVER.save(editor);
  }

  public void set(float value) {
    Editor editor = getPreferences().edit().putFloat(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

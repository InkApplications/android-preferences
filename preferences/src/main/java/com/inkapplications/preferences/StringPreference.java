/*
 * Copyright (C) 2014 Andrew Reitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * Limitations under the License.
 */

package com.inkapplications.preferences;

import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

/** Preference for a String */
public class StringPreference extends AbsPreference<String> {

  /**
   * Constructs a new {@link StringPreference} with the default value of null
   *
   * @param preferences SharedPreferences that this class will write to.
   * @param key         The key/name to refer to this preference as.
   */
  public StringPreference(SharedPreferences preferences, String key) {
    this(preferences, key, null);
  }

  /**
   * Constructs a new {@link StringPreference}
   *
   * @param preferences  SharedPreferences that this class will write to.
   * @param key          The key/name to refer to this preference as.
   * @param defaultValue The value to return if {@link #get()} is called and this
   *                     preference {@link #set(String)} method has not been called.
   */
  public StringPreference(SharedPreferences preferences, String key, String defaultValue) {
    super(preferences, key, defaultValue);
  }

  /** Get the value the preference */
  @Override public String get() {
    return getPreferences().getString(getKey(), getDefaultValue());
  }

  /** Set the value for the preference */
  @Override public void set(String value) {
    Editor editor = getPreferences().edit().putString(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

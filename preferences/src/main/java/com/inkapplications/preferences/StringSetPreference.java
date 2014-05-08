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

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

import java.util.Set;

/**
 * Preference for Set<String>
 * <p/>
 * Only Works on API 11+
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class StringSetPreference extends AbsPreference<Set<String>> {

  /**
   * Constructs a new {@link StringSetPreference} with the default value of null
   *
   * @param preferences SharedPreferences that this class will write to.
   * @param key         The key/name to refer to this preference as.
   */
  public StringSetPreference(SharedPreferences preferences, String key) {
    this(preferences, key, null);
  }

  /**
   * Constructs a new {@link StringSetPreference}
   *
   * @param preferences  SharedPreferences that this class will write to.
   * @param key          The key/name to refer to this preference as.
   * @param defaultValue The value to return if {@link #get()} is called and this
   *                     preference {@link #set(Set)} method has not been called.
   */
  public StringSetPreference(SharedPreferences preferences, String key, Set<String> defaultValue) {
    super(preferences, key, defaultValue);
  }

  /** Get the value the preference */
  @Override public Set<String> get() {
    return getPreferences().getStringSet(getKey(), getDefaultValue());
  }

  /** Set the value for the preference */
  @Override public void set(Set<String> value) {
    getPreferences().edit().putStringSet(getKey(), value).apply();
  }
}

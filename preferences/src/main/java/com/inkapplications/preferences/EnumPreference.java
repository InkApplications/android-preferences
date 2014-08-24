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

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import static android.content.SharedPreferences.Editor;

/**
 * Preference for Enums.
 *
 * Unlike other preferences in this library you must supply a default value as there is no
 * way to easily get the enum value due to type erasure. So rather than having a default class
 * type be passed in or do some funky stuff reflection, you must pass in a default.
 */
public class EnumPreference<E extends Enum<E>> extends AbsPreference<E> {

  private final Enum[] enumValues;

  /**
   * Constructs a new {@link com.inkapplications.preferences.EnumPreference}
   *
   * @param preferences  SharedPreferences that this class will write to.
   * @param key          The key/name to refer to this preference as.
   * @param defaultValue The value to return if {@link #get()} is called and this
   *                     preference {@link #set(Enum)} method has not been called.
   */
  public EnumPreference(SharedPreferences preferences, String key, E defaultValue) {
    super(preferences, key, defaultValue);
    enumValues = getDefaultValue().getClass().getEnumConstants();
  }

  /** Get the value the preference */
  @SuppressWarnings("unchecked")
  @Override public E get() {
    if (getPreferences().contains(getKey())) {
      return (E) enumValues[getPreferences().getInt(getKey(), 0)];
    } else {
      return getDefaultValue();
    }
  }

  /** Set the value for the preference */
  @Override public void set(E value) {
    if (value == null) throw new NullPointerException("value");
    this.set(value.ordinal());
  }

  @SuppressLint("CommitPrefEdits")
  private void set(int value) {
    Editor editor = getPreferences().edit().putInt(getKey(), value);
    PREF_SAVER.save(editor);
  }
}

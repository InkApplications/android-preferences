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
import android.preference.PreferenceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.Assertions.assertThat;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class FloatPreferenceTest {

  SharedPreferences preferences;

  @Before
  public void setup() {
    preferences = PreferenceManager
        .getDefaultSharedPreferences(Robolectric.application);
  }

  @Test
  public void saveFloat() {
    // Arrange
    float expected = 10f;
    String key = "testKey";
    FloatPreference preference = new FloatPreference(preferences, key);

    // Act
    preference.set(expected);

    // Assert
    assertThat(preferences.getFloat(key, 0)).isEqualTo(expected);
  }

  @Test
  public void throwWhenSetWithNull() {
    // Arrange
    String key = "testKey1";
    FloatPreference preference = new FloatPreference(preferences, key);


    // Act
    try {
      preference.set(null);
    } catch (NullPointerException e) {
      return;
    }

    // Assert
    throw new AssertionError("Calling 'set' with null did not throw");
  }

  @Test
  public void getValue() {
    // Arrange
    float expected = 2f;
    String key = "testKey2";
    preferences.edit().putFloat(key, expected).commit();
    FloatPreference preference = new FloatPreference(preferences, key);

    // Act
    float result = preference.get();

    // Assert
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void isSetTrue() {
    // Arrange
    String key = "testKey3";
    preferences.edit().putFloat(key, 1.5f).commit();
    FloatPreference preference = new FloatPreference(preferences, key);

    // Act
    boolean result = preference.isSet();

    // Assert
    assertThat(result).isTrue();
  }

  @Test
  public void isSetFalse() {
    // Arrange
    String key = "testKey4";
    FloatPreference preference = new FloatPreference(preferences, key);

    // Act
    boolean result = preference.isSet();

    // Assert
    assertThat(result).isFalse();
  }

  @Test
  public void deletePreference() {
    // Arrange
    String key = "testKey5";
    preferences.edit().putFloat(key, 1).commit();
    FloatPreference preference = new FloatPreference(preferences, key);

    // Act
    preference.delete();

    // Assert
    assertThat(preferences.contains(key)).isFalse();
  }
}

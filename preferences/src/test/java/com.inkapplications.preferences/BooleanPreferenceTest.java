package com.inkapplications.preferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class BooleanPreferenceTest {

  SharedPreferences preferences;

  @Before
  public void setup() {
    preferences = PreferenceManager
        .getDefaultSharedPreferences(Robolectric.application);
  }

  @Test
  public void should_save_boolean_when_calling_set() {
    // Arrange
    boolean expected = true;
    String key = "testKey";
    BooleanPreference booleanPreference = new BooleanPreference(preferences, key);


    // Act
    booleanPreference.set(expected);

    // Assert
    assertThat(preferences.getBoolean(key, false)).isTrue();
  }

  @Test
  public void should_throw_exception_when_calling_set_with_null() {
    // Arrange
    String key = "testKey1";
    BooleanPreference booleanPreference = new BooleanPreference(preferences, key);


    // Act
    try {
      booleanPreference.set(null);
    } catch (NullPointerException e) {
      return;
    }

    // Assert
    throw new AssertionError("Calling 'set' with null did not throw");
  }

  @Test
  public void should_get_value_when_calling_get() {
    // Arrange
    boolean expected = false;
    String key = "testKey2";
    preferences.edit().putBoolean(key, expected).commit();
    BooleanPreference booleanPreference = new BooleanPreference(preferences, key);

    // Act
    boolean result = booleanPreference.get();

    // Assert
    assertThat(result).isFalse();
  }

  @Test
  public void should_return_true_when_isSet_is_called_and_value_is_set() {
    // Arrange
    String key = "testKey3";
    preferences.edit().putBoolean(key, true).commit();
    BooleanPreference booleanPreference = new BooleanPreference(preferences, key);

    // Act
    boolean result = booleanPreference.isSet();

    // Assert
    assertThat(result).isTrue();
  }

  @Test
  public void should_return_false_when_isSet_is_called_and_value_is_not_set() {
    // Arrange
    String key = "testKey4";
    BooleanPreference booleanPreference = new BooleanPreference(preferences, key);

    // Act
    boolean result = booleanPreference.isSet();

    // Assert
    assertThat(result).isFalse();
  }

  @Test
  public void should_delete_preference() {
    // Arrange
    String key = "testKey5";
    preferences.edit().putBoolean(key, true).commit();
    BooleanPreference booleanPreference = new BooleanPreference(preferences, key);

    // Act
    booleanPreference.delete();

    // Assert
    assertThat(preferences.contains(key)).isFalse();
  }
}

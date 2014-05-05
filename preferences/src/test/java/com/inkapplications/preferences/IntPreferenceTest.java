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
public class IntPreferenceTest {

  SharedPreferences preferences;

  @Before
  public void setup() {
    preferences = PreferenceManager
        .getDefaultSharedPreferences(Robolectric.application);
  }

  @Test
  public void should_save_int_when_calling_set() {
    // Arrange
    int expected = 5;
    String key = "testKey";
    IntPreference preference = new IntPreference(preferences, key);

    // Act
    preference.set(expected);

    // Assert
    assertThat(preferences.getInt(key, 0)).isEqualTo(expected);
  }

  @Test
  public void should_throw_exception_when_calling_set_with_null() {
    // Arrange
    String key = "testKey1";
    IntPreference preference = new IntPreference(preferences, key);


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
  public void should_get_value_when_calling_get() {
    // Arrange
    int expected = 2;
    String key = "testKey2";
    preferences.edit().putInt(key, expected).commit();
    IntPreference preference = new IntPreference(preferences, key);

    // Act
    int result = preference.get();

    // Assert
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void should_return_true_when_isSet_is_called_and_value_is_set() {
    // Arrange
    String key = "testKey3";
    preferences.edit().putInt(key, 1).commit();
    IntPreference preference = new IntPreference(preferences, key);

    // Act
    boolean result = preference.isSet();

    // Assert
    assertThat(result).isTrue();
  }

  @Test
  public void should_return_false_when_isSet_is_called_and_value_is_not_set() {
    // Arrange
    String key = "testKey4";
    IntPreference preference = new IntPreference(preferences, key);

    // Act
    boolean result = preference.isSet();

    // Assert
    assertThat(result).isFalse();
  }

  @Test
  public void should_delete_preference() {
    // Arrange
    String key = "testKey5";
    preferences.edit().putInt(key, 9).commit();
    IntPreference preference = new IntPreference(preferences, key);

    // Act
    preference.delete();

    // Assert
    assertThat(preferences.contains(key)).isFalse();
  }
}

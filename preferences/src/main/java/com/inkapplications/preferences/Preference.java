package com.inkapplications.preferences;

interface Preference<T> {
  /** Get the value the preference */
  T get();

  /**
   * Checks if the preference is set.
   *
   * @return Returns true if the preference has ben set, otherwise false.
   */
  boolean isSet();

  /** Set the value for the preference */
  void set(T value);

  /** Deletes the preference. */
  void delete();
}
package com.inkapplications.preferences;

interface Preference<T> {
  T get();
  boolean isSet();
  void set(T value);
  void delete();
}
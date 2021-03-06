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

public interface Preference<T> {
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
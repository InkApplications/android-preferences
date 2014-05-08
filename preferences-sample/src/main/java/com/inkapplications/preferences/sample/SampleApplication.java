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

package com.inkapplications.preferences.sample;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.inkapplications.preferences.BooleanPreference;
import com.inkapplications.preferences.StringPreference;

public class SampleApplication extends Application {

  private BooleanPreference hasUserOpenAppBefore;
  private StringPreference userSetMessage;

  @Override public void onCreate() {
    super.onCreate();

    /** This looks a lot sexier if you use Dagger to wire this all up  and inject into activities*/
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    hasUserOpenAppBefore = new BooleanPreference(preferences, "SeenAppBefore");
    userSetMessage = new StringPreference(preferences, "UserSetMessage");
  }

  public static SampleApplication get(Context context) {
    return (SampleApplication) context.getApplicationContext();
  }

  public BooleanPreference getHasUserOpenAppBefore() {
    return hasUserOpenAppBefore;
  }

  public StringPreference getUserSetMessage() {
    return userSetMessage;
  }
}

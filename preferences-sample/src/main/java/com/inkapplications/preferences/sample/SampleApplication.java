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

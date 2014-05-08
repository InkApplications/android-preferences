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

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.inkapplications.preferences.BooleanPreference;
import com.inkapplications.preferences.StringPreference;


public class MainActivity extends Activity {

  private TextView userSeenAppTextView;
  private EditText userInputEditText;

  private BooleanPreference hasUserOpenAppBefore;
  private StringPreference userSetMessage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SampleApplication app = SampleApplication.get(this);
    hasUserOpenAppBefore = app.getHasUserOpenAppBefore();
    userSetMessage = app.getUserSetMessage();

    userInputEditText = (EditText) findViewById(R.id.user_input);
    userSeenAppTextView = (TextView) findViewById(R.id.seen_app);
    if (!hasUserOpenAppBefore.get()) {
      userSeenAppTextView.setText(getString(R.string.first_run_text));
      hasUserOpenAppBefore.set(true);
    }
  }

  @Override protected void onResume() {
    super.onResume();

    if (userSetMessage.isSet()) {
      userInputEditText.setText(userSetMessage.get());
    }
  }

  @Override protected void onPause() {
    super.onPause();

    String userInputString = userInputEditText.getText().toString();
    userSetMessage.set(userInputString);
  }
}

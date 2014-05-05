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

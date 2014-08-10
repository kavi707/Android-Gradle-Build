package com.kavi.android.module.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.kavi.android.module.java.JavaSupport;

/**
 * AndroidSupportActivity.java
 *
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class AndroidSupportActivity extends Activity {

    private EditText supportText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        setUpViews();
    }

    private void setUpViews() {
        supportText = (EditText) findViewById(R.id.supportText);

        JavaSupport javaSupport = new JavaSupport();

        String support = javaSupport.supportMethod();
        supportText.setText(support);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.support, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

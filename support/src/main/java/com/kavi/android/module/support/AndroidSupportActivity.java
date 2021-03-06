package com.kavi.android.module.support;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kavi.android.module.java.JavaSupport;

/**
 * AndroidSupportActivity.java
 *
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class AndroidSupportActivity extends Activity {

    private EditText supportEditText;
    private Button squareRootBtn;
    private TextView rootTextView;
    private JavaSupport javaSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        Log.d("support:AndroidSupportActivity/onCreate", "Method Called");
        setUpViews();
    }

    private void setUpViews() {
        Log.d("support:AndroidSupportActivity/setUpViews", "Method Called");
        supportEditText = (EditText) findViewById(R.id.supportText);
        squareRootBtn = (Button) findViewById(R.id.sqrtBtn);
        rootTextView = (TextView) findViewById(R.id.rootTextView);

        Log.d("support:AndroidSupportActivity/setUpViews", "Create a object to JavaSupport class in java-support module");
        javaSupport = new JavaSupport();

        Log.d("support:AndroidSupportActivity/setUpViews", "Get the hint from getHint method in java-support module");
        String hint = javaSupport.getHint();
        supportEditText.setHint(hint);

        squareRootBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = supportEditText.getText().toString();
                Double doubleNumber = Double.parseDouble(number);

                Log.d("support:AndroidSupportActivity/setUpViews", "Get the SquareRoot from getSquareRoot method in java-support module");
                Double root = javaSupport.getSquareRoot(doubleNumber);
                rootTextView.setText(root.toString());
            }
        });
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

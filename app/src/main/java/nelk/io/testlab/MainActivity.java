package nelk.io.testlab;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private Button buttonLeft;
    private Button buttonRight;

    private ButtonsOnClickListener btnListener;
    private ButtonsOnLongClickListener btnLongListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "in onCreate");

        btnListener = new ButtonsOnClickListener();
        btnLongListener = new ButtonsOnLongClickListener();

        buttonLeft = (Button) findViewById(R.id.btnLeft);
        buttonLeft.setOnClickListener(btnListener);
        buttonLeft.setOnLongClickListener(btnLongListener);

        buttonRight = (Button) findViewById(R.id.btnRight);
        buttonRight.setOnClickListener(btnListener);
        buttonRight.setOnLongClickListener(btnLongListener);
    }

    public class ButtonsOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            if (v.getId() == R.id.btnLeft) {
                buttonLeft.setText(context.getString(R.string.btnNoText));
                buttonRight.setText(context.getString(R.string.btnClickMe));
            } else {
                buttonRight.setText(context.getString(R.string.btnNoText));
                buttonLeft.setText(context.getString(R.string.btnClickMe));
            }
        }
    }

    public class ButtonsOnLongClickListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {
            Context context = v.getContext();
            String hint = context.getString(R.string.hint);
            Toast.makeText(context, hint, Toast.LENGTH_SHORT).show();

            //Return true so that it doesn't call the onClick as well.
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

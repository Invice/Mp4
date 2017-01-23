package mp4.com.mp4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mp4.com.mp4.R;
import mp4.com.mp4.applications.AppContainer;
import mp4.com.mp4.applications.SelectedOptions;

public class RoomDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_description);
        AppContainer appCon = (AppContainer) getApplicationContext();

        TextView descr_txt = (TextView) findViewById(R.id.txt_room_descriptor);
        Button continue_to_map = (Button) findViewById(R.id.btn_continue_to_map);

        descr_txt.setText(appCon.getSelectedOptions().
                getSelectedRoom().getDescription());



        continue_to_map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(RoomDescription.this, Map.class));
            }
        });

        if (appCon.getSelectedOptions().getSelectedRoom().isDefault_room()){
            continue_to_map.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_room_description, menu);
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

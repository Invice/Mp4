package mp4.com.mp4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mp4.com.mp4.applications.AppContainer;
import mp4.com.mp4.applications.RegisteredRooms;
import mp4.com.mp4.applications.SelectedOptions;
import mp4.com.mp4.R;
import mp4.com.mp4.classes.Room;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppContainer appCon = ((AppContainer)getApplicationContext());

        //Button options = (Button) findViewById(R.id.btn_options);
        Button room = (Button) findViewById(R.id.btn_roomSearch);
        Button place = (Button) findViewById(R.id.btn_placeSearch);
        ListView favos = (ListView) findViewById(R.id.favList);


        final EditText adText = (EditText) findViewById(R.id.txt_roomSearch);


        place.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlaceSearch.class));
            }
        });

        room.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                appCon.getSelectedOptions().setAddress(adText.getText().toString());
                startActivity(new Intent(MainActivity.this, RoomSearch.class));
            }
        });



        List<String> favs = new ArrayList<>();
        for (Room rm: appCon.getRegisteredRooms().getRooms()){
            if (rm.getCount() > 0){
                favs.add(rm.roomToString());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_expandable_list_item_1, favs);

        favos.setAdapter(adapter);

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

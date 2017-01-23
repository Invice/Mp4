package mp4.com.mp4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mp4.com.mp4.applications.AppContainer;
import mp4.com.mp4.applications.SelectedOptions;
import mp4.com.mp4.R;
import mp4.com.mp4.classes.Room;

public class RoomSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_search);

        final AppContainer appCon = ((AppContainer)getApplicationContext());

        TextView searched = (TextView) findViewById(R.id.txt_searched);
        ListView roomSuggestion = (ListView) findViewById(R.id.preferedRooms);

        searched.setText(appCon.getSelectedOptions().getAddress());

        List<String> prefRooms = new ArrayList<>();

        Room room = appCon.getRegisteredRooms()
                .getRoomByName(appCon.getSelectedOptions().getAddress());
        prefRooms.add(room.roomToString());

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_expandable_list_item_1, prefRooms);

        roomSuggestion.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_room_search, menu);
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

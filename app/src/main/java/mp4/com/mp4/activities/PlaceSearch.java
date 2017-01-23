package mp4.com.mp4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mp4.com.mp4.applications.AppContainer;
import mp4.com.mp4.applications.RegisteredRooms;
import mp4.com.mp4.applications.SelectedOptions;
import mp4.com.mp4.R;
import mp4.com.mp4.classes.Option;
import mp4.com.mp4.classes.Room;

public class PlaceSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_search);


        final AppContainer appCon = ((AppContainer)getApplicationContext());

        ListView optionList = (ListView) findViewById(R.id.listView);
        final ListView prefRooms = (ListView) findViewById(R.id.prefRooms);
        Button search_param = (Button) findViewById(R.id.btn_search_param);


        search_param.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(PlaceSearch.this, Options.class));
            }
        });


        List<String> items = new ArrayList<>();

        for (Option option : appCon.getSelectedOptions().getOptions()){
            if (option.isState()){
                items.add(lookUpString(option.getName()));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_expandable_list_item_1, items);

        optionList.setAdapter(adapter);




        //Initialisiere Vorschläge
        List<Option> selOps = appCon.getSelectedOptions().getOptions();
        int selOpNum = appCon.getSelectedOptions().getSelOpNum();

        List<String> roomList = new ArrayList<>();

        for (Room room : appCon.getRegisteredRooms().getRooms()){
            int i = 0;
            if (room.getAvailableResources().size() > 0 && selOpNum > 0) {
                for (Option roomOp : room.getAvailableResources()){
                    for (Option selOp : selOps){
                        if (roomOp.getName().equals(selOp.getName()) && selOp.isState()){
                            i++;
                        }
                    }
                }
                if (i == selOpNum){
                    roomList.add(room.roomToString());
                }
            }

        }

        ArrayAdapter<String> roomAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_expandable_list_item_1, roomList);

        prefRooms.setAdapter(roomAdapter);
        prefRooms.setClickable(true);
        prefRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Object o = prefRooms.getItemAtPosition(position);
                String str = (String) o;//As you are using Default String Adapter
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private String lookUpString(String name){
        switch (name){
            case "power" :
                return getString(R.string.power);
            case "computer" :
                return getString(R.string.computer);
            case "wifi" :
                return getString(R.string.wifi);
            case "seat" :
                return getString(R.string.seat);
            case "board" :
                return getString(R.string.board);
            case "toilet" :
                return getString(R.string.toilet);
            case "first_aid" :
                return getString(R.string.first_aid);
            case "locker" :
                return getString(R.string.locker);
            default :
                return "NaN";
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_place_search, menu);
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

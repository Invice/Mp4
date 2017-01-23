package mp4.com.mp4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import mp4.com.mp4.applications.AppContainer;
import mp4.com.mp4.applications.SelectedOptions;
import mp4.com.mp4.R;
import mp4.com.mp4.classes.Option;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        final AppContainer appCon = ((AppContainer)getApplicationContext());
        appCon.getSelectedOptions().resetOptions();

        CheckBox pwr = (CheckBox)findViewById(R.id.checkBox_power);
        CheckBox comp = (CheckBox)findViewById(R.id.checkBox_computer);
        CheckBox wifi = (CheckBox)findViewById(R.id.checkBox_wifi);
        CheckBox board = (CheckBox)findViewById(R.id.checkBox_board);
        CheckBox seat = (CheckBox)findViewById(R.id.checkBox_seat);
        CheckBox locker = (CheckBox)findViewById(R.id.checkBox_locker);
        CheckBox first_aid = (CheckBox)findViewById(R.id.checkBox_first_aid);
        CheckBox toilet = (CheckBox)findViewById(R.id.checkBox_toilet);

        Button ok = (Button) findViewById(R.id.btn_ok);


        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Options.this, PlaceSearch.class));
            }
        });




        pwr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    appCon.getSelectedOptions().setOption("power", true);
                } else {
                    appCon.getSelectedOptions().setOption("power", false);
                }
            }
        });

        comp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appCon.getSelectedOptions().setOption("computer", true);
                } else {
                    appCon.getSelectedOptions().setOption("computer", false);
                }
            }
        });

        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appCon.getSelectedOptions().setOption("wifi", true);
                } else {
                    appCon.getSelectedOptions().setOption("wifi", false);
                }
            }
        });

        board.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appCon.getSelectedOptions().setOption("board", true);
                } else {
                    appCon.getSelectedOptions().setOption("board", false);
                }
            }
        });

        locker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appCon.getSelectedOptions().setOption("locker", true);
                } else {
                    appCon.getSelectedOptions().setOption("locker", false);
                }
            }
        });

        seat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appCon.getSelectedOptions().setOption("seat", true);
                } else {
                    appCon.getSelectedOptions().setOption("seat", false);
                }
            }
        });

        first_aid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appCon.getSelectedOptions().setOption("first_aid", true);
                } else {
                    appCon.getSelectedOptions().setOption("first_aid", false);
                }
            }
        });

        toilet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appCon.getSelectedOptions().setOption("toilet", true);
                } else {
                    appCon.getSelectedOptions().setOption("toilet", false);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
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

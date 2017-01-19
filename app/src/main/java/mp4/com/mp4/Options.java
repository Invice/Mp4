package mp4.com.mp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        final SelectedOptions selOps = ((SelectedOptions)getApplicationContext());

        CheckBox pwr = (CheckBox)findViewById(R.id.checkBox_power);
        CheckBox comp = (CheckBox)findViewById(R.id.checkBox_computer);
        CheckBox wifi = (CheckBox)findViewById(R.id.checkBox_wifi);
        CheckBox board = (CheckBox)findViewById(R.id.checkBox_board);
        CheckBox seat = (CheckBox)findViewById(R.id.checkBox_seat);
        CheckBox locker = (CheckBox)findViewById(R.id.checkBox_locker);
        CheckBox firstaid = (CheckBox)findViewById(R.id.checkBox_first_aid);



        pwr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    selOps.setPwr(true);
                } else {
                    selOps.setPwr(false);
                }
            }
        });

        comp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selOps.setComp(true);
                } else {
                    selOps.setComp(false);
                }
            }
        });

        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selOps.setWifi(true);
                } else {
                    selOps.setWifi(false);
                }
            }
        });

        board.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selOps.setBoard(true);
                } else {
                    selOps.setBoard(false);
                }
            }
        });

        locker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selOps.setLocker(true);
                } else {
                    selOps.setLocker(false);
                }
            }
        });

        seat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selOps.setSeat(true);
                } else {
                    selOps.setSeat(false);
                }
            }
        });

        firstaid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selOps.setFirstaid(true);
                } else {
                    selOps.setFirstaid(false);
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

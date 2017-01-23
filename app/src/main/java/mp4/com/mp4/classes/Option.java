package mp4.com.mp4.classes;

import android.util.Log;

/**
 * Created by froog on 19.01.17.
 */
public class Option {

    public Option(String name){
            this.state = false;
            this.name=name;
    }

    private Option(){

    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        Log.d("FlagSwitch", "Changed " + name + " from: " + this.state + " to " + state + ".");
        this.state = state;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private boolean state;
    private String name = "unset";

}

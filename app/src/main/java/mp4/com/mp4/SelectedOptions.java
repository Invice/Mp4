package mp4.com.mp4;

import android.app.Application;
import android.util.Log;

/**
 * Created by froog on 19.01.17.
 */
public class SelectedOptions extends Application {

    boolean pwr=false, comp=false, wifi=false, board=false, seat=false, locker=false, firstaid=false;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address = "";

    public boolean isPwr() {
        return pwr;
    }

    public void setPwr(boolean pwr) {
        Log.d("VarChange", "pwr changed from " +this.pwr+ " to " + pwr);
        this.pwr = pwr;
    }

    public boolean isComp() {
        return comp;
    }

    public void setComp(boolean comp) {
        this.comp = comp;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isBoard() {
        return board;
    }

    public void setBoard(boolean board) {
        this.board = board;
    }

    public boolean isSeat() {
        return seat;
    }

    public void setSeat(boolean seat) {
        this.seat = seat;
    }

    public boolean isLocker() {
        return locker;
    }

    public void setLocker(boolean locker) {
        this.locker = locker;
    }

    public boolean isFirstaid() {
        return firstaid;
    }

    public void setFirstaid(boolean firstaid) {
        this.firstaid = firstaid;
    }
}

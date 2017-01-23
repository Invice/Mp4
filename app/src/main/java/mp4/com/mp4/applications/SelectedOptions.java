package mp4.com.mp4.applications;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mp4.com.mp4.classes.Option;
import mp4.com.mp4.classes.Room;

/**
 * Created by froog on 19.01.17.
 * k
 */
public class SelectedOptions {

    private Option pwr = new Option("power");
    private Option comp = new Option("computer");
    private Option wifi = new Option("wifi");
    private Option board = new Option("board");
    private Option seat = new Option("seat");
    private Option locker = new Option("locker");
    private Option first_aid = new Option("first_aid");
    private Option toilet = new Option("toilet");

    public Room getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

    private Room selectedRoom = new Room("null", "null");

    public List<Option> options = new ArrayList<>();
    public List<Room> rooms = new ArrayList<>();

    public List<Room> getRooms(){
        return this.rooms;
    }


    public List<Option> getOptions(){
        return options;
    }

    public void setOption(int i, boolean state){

        options.get(i).setState(state);

    }

    public void setOption(String name, boolean state){

        if (options.size()  < 1) {
            Log.e("No Options", "Found no options to be modified.");
        }
        for (Option option : options) {
            if(option.getName().equals(name)){
               option.setState(state);
            }
        }

    }

    public SelectedOptions(){
        options.add(pwr);
        options.add(comp);
        options.add(wifi);
        options.add(board);
        options.add(seat);
        options.add(locker);
        options.add(first_aid);
        options.add(toilet);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address = "";

    public int getSelOpNum(){
        int i = 0;

        for (Option option : options){
            if (option.isState()){
                i++;
            }
        }

        return i;
    }

    public void resetOptions() {
        for (Option option : options){
            if(option.isState()){
                option.setState(false);
            }
        }
    }

}

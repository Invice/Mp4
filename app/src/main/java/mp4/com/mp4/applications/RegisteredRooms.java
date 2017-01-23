package mp4.com.mp4.applications;

import java.util.ArrayList;
import java.util.List;

import mp4.com.mp4.classes.Option;
import mp4.com.mp4.classes.Room;

/**
 * Created by froog on 21.01.17.
 * k
 */
public class RegisteredRooms {

    public RegisteredRooms(){
        registeredRooms.add(new Room("Hebbel Hörsaal", "OS40, R.104"));
        registeredRooms.add((new Room("", "CAP4, R.709")).increaseVisitCount());
        registeredRooms.add(new Room("", "CAP3, 1.OG"));
        registeredRooms.add(new Room("Grundausbildungspool", "HRS3, R.012"));

        ArrayList<Option> ops = new ArrayList<>();
        ops.add(new Option("power"));
        ops.add(new Option("board"));
        ops.add(new Option("computer"));
        ops.add(new Option("wifi"));
        ops.add(new Option("seat"));

        registeredRooms.add(new Room("Seminar 1", "OS75, R.506", ops).increaseVisitCount());
        registeredRooms.add(new Room("Belegt", "OS75, R.514", ops));


    }

    private List<Room> registeredRooms = new ArrayList<>();

    private Room nullRoom = new Room("null", "null", new ArrayList<Option>());

    public void addRoom (Room room){
        this.registeredRooms.add(room);
    }

    public List<Room> getRooms(){
        return registeredRooms;
    }

    public Room getRoomByName(String name){
        for (Room room : registeredRooms){
            if (room.getAddress().equals(name) || room.getName().equals(name)){
                return room;
            }
        }
        return nullRoom;
    }

}

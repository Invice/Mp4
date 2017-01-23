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
        registeredRooms.add((new Room("Belegt", "CAP4, R.709")).increaseVisitCount()
                .addOption(new Option("power")).addOption(new Option("seat"))
                .addOption(new Option("computer")).addOption(new Option("wifi")));
        registeredRooms.add(new Room("Belegt", "CAP3, 1.OG").addOption(new Option("power"))
                .addOption(new Option("wifi")).addOption(new Option("seat")));
        registeredRooms.add(new Room("Grundausbildungspool", "HRS3, R.012").increaseVisitCount());

        ArrayList<Option> ops = new ArrayList<>();
        ops.add(new Option("power"));
        ops.add(new Option("board"));
        ops.add(new Option("computer"));
        ops.add(new Option("wifi"));
        ops.add(new Option("seat"));

        Room seminar1 = new Room("Seminar 1", "OS75, R.506", ops);
        seminar1.setDescription("" +
                "- Gehe vom Haupteingang nach rechts, bis du zu den treppen kommst\n" +
                "\n- Dann gehe die Treppen hoch bis zum 5.OG oder nehme den Aufzug hinter den Treppen.\n" +
                "\n- Oben angekommen gehe um die Treppe herum. Raum 506 befindet sich direkt vor dir.");

        registeredRooms.add(seminar1);
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
            if (room.getAddress().equals(name)
                    || room.getName().equals(name)
                    || (room.getAddress() + " (" + room.getName() + ")").equals(name)){
                return room;
            }
        }
        return nullRoom;
    }

}

package mp4.com.mp4.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by froog on 19.01.17.
 */
public class Room {

    public Room(String name, String address, List<Option> resources){

        this.name = name;
        this.address = address;
        this.availableResources = resources;
        visitCount = 0;
    }

    public Room(String name, String address){
        this.name = name;
        this.address = address;
        this.availableResources = new ArrayList<>();
        visitCount = 0;
    }

    private Room(){

    }

    private List<Option> availableResources;
    private String name;
    private String address;
    private String description = "Dieser Raum ist leider nicht der richtige.\n\n" +
            "Bitte versuche es erneut.";
    private int visitCount;
    private boolean default_room = true;

    public boolean isDefault_room(){
        return this.default_room;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public List<Option> getAvailableResources() {
        return this.availableResources;
    }

    public Room increaseVisitCount(){
        visitCount++;
        return this;
    }

    public int getCount(){
        return this.visitCount;
    }


    public String getDescription() {
        return description;
    }

    public Room setDescription(String description) {
        this.description = description;
        this.default_room =false;
        return this;
    }

    public Room addOption(Option option){
        availableResources.add(option);
        return this;
    }

    public String roomToString(){
        if (name.equals("")){
            return address;
        }
        return (address + " (" + name + ")");
    }

}

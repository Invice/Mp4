package mp4.com.mp4.applications;

import android.app.Application;

/**
 * Created by froog on 21.01.17. ...
 * k
 */
public class AppContainer extends Application {

    RegisteredRooms registeredRooms = new RegisteredRooms();
    SelectedOptions selectedOptions = new SelectedOptions();

    public SelectedOptions getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(SelectedOptions selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public RegisteredRooms getRegisteredRooms() {
        return registeredRooms;
    }

    public void setRegisteredRooms(RegisteredRooms registeredRooms) {
        this.registeredRooms = registeredRooms;
    }
}

package Model.Skills.RangedSkills;

import Model.Map.Location;

import java.util.ArrayList;

/**
 * Created by AndyZhu on 16/4/2016.
 */
public class ObservationInfo {
    private Location location;
    private ArrayList<String> observedMsg;

    public ObservationInfo (Location location, ArrayList<String> observedMsg) {
        this.location = location;
        this.observedMsg = observedMsg;
    }

    public ObservationInfo (ArrayList<String> observedMsg) {
        this.location = null;
        this.observedMsg = observedMsg;
    }

    public Location getLocation() {
        return location;
    }

    public ArrayList<String> getObservedMsg() {
        return observedMsg;
    }
}

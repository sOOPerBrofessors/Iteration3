package Model.Skills.RangedSkills;

import Model.Map.Location;

/**
 * Created by AndyZhu on 16/4/2016.
 */
public class ObservationInfo {
    private Location location;
    private String observedMsg;

    public ObservationInfo (Location location, String observedMsg) {
        this.location = location;
        this.observedMsg = observedMsg;
    }

    public Location getLocation() {
        return location;
    }

    public String getObservedMsg() {
        return observedMsg;
    }
}

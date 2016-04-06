package Utilities;

/**
 * Created by broskj on 4/5/16.
 *
 * Observer interface to be implemented by classes wishing to be notified
 *  of changes to subjects
 */
public interface Observer {
    public void update(); // method called when alerted by a subject
    public void remove(); // remove a subject from observers
} // end interface Observer

package Utilities.Observers;

/**
 * Created by broskj on 4/5/16.
 *
 * Observer interface to be implemented by classes wishing to be notified
 *  of changes to subjects
 */
public interface Observer {
    void update(); // method called when alerted by a subject
    void remove(); // remove a subject from observers
} // end interface Observer

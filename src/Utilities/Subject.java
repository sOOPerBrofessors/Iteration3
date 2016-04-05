package Utilities;

/**
 * Created by broskj on 4/5/16.
 *
 * Subject interface to be implemented by classes wishing to notify observers
 *  of changes to self
 */
public interface Subject {
    public void addObserver(Observer o); // add an observer to this class
    public void removeObserver(Observer o); // remove an observer from this class
    public void alert(); // alert all observers
} // end interface Subject

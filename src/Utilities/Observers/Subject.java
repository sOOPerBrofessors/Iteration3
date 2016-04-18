package Utilities.Observers;

import Utilities.Observers.Observer;

/**
 * Created by broskj on 4/5/16.
 *
 * Observables interface to be implemented by classes wishing to notify observers
 *  of changes to self
 */
public interface Subject {
    void addObserver(Observer o); // add an observer to this class
    void removeObserver(Observer o); // remove an observer from this class
    void alert(); // alert all observers
} // end interface Observables

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michał
 */
public class SaveEventToFile {
    
    private String event, category;
    int priority;
    
    SaveEventToFile(String newEvent, String category, int priority) {
        this.event = newEvent;
        this.category = category;
        this.priority = priority;
    }
        
   public void recordEvents(){
       ArrayList<Event> eventContent = this.readEventsFromFile();
       this.addNewEventToLists(event, category, priority, eventContent);
       //this.sortEventsByHighestPriority(eventContent);
       this.writeEventsToFile(eventContent);
   }
        
    public ArrayList<Event> readEventsFromFile(){
        
        ArrayList<Event> eventContent = new ArrayList();
        ObjectInputStream eventsSavedInFile=null ;
        
            try {
                eventsSavedInFile = new ObjectInputStream(new FileInputStream("Event.dat"));
            } catch (FileNotFoundException e) {
                    } catch (IOException ex) {
                        Logger.getLogger(SaveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
            try {
                eventContent = (ArrayList<Event>) eventsSavedInFile.readObject();
            } catch (NullPointerException e) {
                } catch (ClassNotFoundException | IOException ex) {
                        Logger.getLogger(SaveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return eventContent;
    }
    
    public void writeEventsToFile(ArrayList<Event> eventContent) {
        ObjectOutputStream saveNewEvents = null;
        try {
            saveNewEvents = new ObjectOutputStream(new FileOutputStream("Event.dat"));
        } catch (IOException ex) {
            Logger.getLogger(SaveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            saveNewEvents.writeObject(eventContent);
        } catch (IOException ex) {
            Logger.getLogger(SaveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void addNewEventToLists(String newEvent, String category, int priority, ArrayList<Event> eventContent){
        Event saveEvent = new Event(newEvent, category, priority);
        eventContent.add(saveEvent);
    }
    
    public void sortEventsByHighestPriority(ArrayList<Event> eventContent) {
            Collections.sort(eventContent, new SortEventsAscending());
    }
   
}

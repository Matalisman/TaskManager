/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Michał
 */
public class PickEvents {
    
 
    private String category;
    private String priority;
    private boolean status;
    private String showByStatus;
    private ArrayList<Event> eventsToDelete = new ArrayList();
    
    PickEvents(String category, String priority, String showByStatus) {
     this.category = category;
     this.priority = priority;
     
     if ( showByStatus == "Zakończone") {
         status = true;
        } else if (showByStatus == "Niezakończone") {
          status = false;
        }
    
    this.showByStatus = showByStatus;
        
    }
    
    ArrayList<Event> sort() {
       
        EventManager reader = new EventManager();
        ArrayList<Event> eventList = reader.readEventsFromFile();
        
        for (int i=0; i<eventList.size() ; i++) {
            if (!"Wszystkie".equals(category)) {
                if (!eventList.get(i).getCategory().equals(category)) {
                    
                    eventsToDelete.add(eventList.get(i));
                }
            }
            
            if (!"Wszystkie".equals(showByStatus)) {
                    if (eventList.get(i).isDone() != status) {
                        eventsToDelete.add(eventList.get(i));
                    }
                }
        }    
            
        for (int i=0; i<eventsToDelete.size() ; i++) {
            eventList.remove(eventsToDelete.get(i));
      
        }
        
        if (priority == "Od najwyższego priorytetu"){
            reader.sortEventsByHighestPriority(eventList);
        }
        
        if (priority == "Od najniższego priorytetu"){
            reader.sortEventsByLowestPriority(eventList);
        }
            
     return eventList;
    }
    
}
    


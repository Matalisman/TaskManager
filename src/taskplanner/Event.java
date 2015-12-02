/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.io.Serializable;

/**
 *
 * @author Michał
 */
public class Event implements Serializable {
    
    private String eventDescription, category;
    int priority;
    private boolean done;
    
    Event(String event, String category, int priority){
        this.eventDescription = event;
        this.category = category;
        this.priority = priority;
        this.done = false;
        
        System.out.println(this);
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

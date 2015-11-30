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
public class event implements Serializable {
    
    private String event, category;
    private boolean done;
    
    event(String event, String category){
        this.event = event;
        this.category = category;
        this.done = false;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
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
    
}

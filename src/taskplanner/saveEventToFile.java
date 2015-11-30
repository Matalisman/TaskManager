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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michał
 */
public class saveEventToFile {
    
    saveEventToFile(String newEvent, String category) {
        
        event saveEvent = new event( newEvent, category); 
        
        ArrayList<event> eventContent = new ArrayList();
        ObjectInputStream event=null ;
        ObjectOutputStream save = null;
        try{
            event = new ObjectInputStream(new FileInputStream("Event.dat"));
        } catch(FileNotFoundException e){
        } catch (IOException ex) {
            Logger.getLogger(saveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
        eventContent = (ArrayList<event>) event.readObject();
        }catch (NullPointerException e){
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(saveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        eventContent.add(saveEvent);
        
        try {
            save = new ObjectOutputStream(new FileOutputStream("Event.dat"));
        } catch (IOException ex) {
            Logger.getLogger(saveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            save.writeObject(saveEvent);
        } catch (IOException ex) {
            Logger.getLogger(saveEventToFile.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}

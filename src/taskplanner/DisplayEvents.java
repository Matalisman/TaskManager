/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Mateusz Borysewicz
 */
public class DisplayEvents {
    
        JPanel displayPanel;
        ArrayList<Event> eventsToDisplay = new ArrayList();
    
    DisplayEvents(JPanel displayPanel)
    {
        
        SaveEventToFile reader = new SaveEventToFile();
        eventsToDisplay = reader.readEventsFromFile();
        
        this.displayPanel = displayPanel;
        this.showMainWindow();
    }
    
    DisplayEvents(JPanel displayPanel, ArrayList<Event> eventsToDisplay)
    {
        this.displayPanel = displayPanel;
        this.eventsToDisplay = eventsToDisplay;
        
        this.showMainWindow();
    }
    
    private void showMainWindow(){
        
        displayPanel.removeAll();
        for (int i=0; i<eventsToDisplay.size(); i++) {
            JButton eventButton = new JButton();
            displayPanel.add(eventButton);
            eventButton.setText(eventsToDisplay.get(i).getTite());
            eventButton.setPreferredSize(new Dimension (100, 50));
            eventButton.addActionListener(new ShowEvent(eventsToDisplay.get(i), displayPanel, eventsToDisplay));
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }
}

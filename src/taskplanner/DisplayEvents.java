/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Michał
 */
public class DisplayEvents {
    
    DisplayEvents(JPanel displayPanel)
    {
        displayPanel.removeAll();
        ArrayList<Event> eventsToDisplay;
        SaveEventToFile reader = new SaveEventToFile();
        eventsToDisplay = reader.readEventsFromFile();
        System.out.print(eventsToDisplay);
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

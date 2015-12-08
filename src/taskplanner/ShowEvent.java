/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Michał
 */
public class ShowEvent implements ActionListener {
    
       private Event event;
       private JFrame eventFrame = new JFrame("Edytuj wydarzenie");
       private JPanel displayPanel;
       private JLabel title = new JLabel(); 
       private JTextArea description = new JTextArea();
       private JPanel editButtons = new JPanel();
       private JButton delete = new JButton("Usuń zadanie");      
       private JButton editStatus = new JButton("Zakończ zadanie");
       private final ArrayList<Event> eventContent;
       private EventManager reader = new EventManager();
        
        ShowEvent(Event event, JPanel displayPanel, ArrayList<Event> eventContent){
            this.displayPanel = displayPanel;
            this.event = event;
            this.eventContent = eventContent;
        }    
            


    @Override
    public void actionPerformed(ActionEvent e) {
        eventFrame.setSize(300, 300);
        eventFrame.setResizable(false);
        
        title.setText(event.getTite());
        title.setFont(new Font("Courier New", Font.HANGING_BASELINE, 30));
       
        eventFrame.getContentPane().add(title, BorderLayout.NORTH);
        
        eventFrame.add(editButtons, BorderLayout.SOUTH);
        editButtons.setLayout(new BorderLayout());
        
        if (!event.isDone()){
        editButtons.add(editStatus, BorderLayout.WEST);
        
        }
        
        editStatus.addActionListener(new Status());
        
        editButtons.add(delete);
        delete.addActionListener(new DeleteEvent());
        
        description.setText(event.getEventDescription());
        description.setFont(new Font("Courier New", Font.PLAIN, 12));
        description.setEditable(false);
        description.setLineWrap(true);
        description.setBackground(Color.DARK_GRAY);
        
        description.setForeground(Color.RED);
        
        eventFrame.add(description);
              
        eventFrame.setVisible(true);
    }
    
    class Status implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            event.setDone(true);
            editButtons.remove(editStatus);
            editButtons.revalidate();
            editButtons.repaint();
            reader.writeEventsToFile(eventContent);
            eventFrame.setVisible(false);
            
        }
    }
    
    class DeleteEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                        
            System.out.println();
            System.out.println(eventContent);
            System.out.println(event);
            eventContent.remove(event);
            reader.writeEventsToFile(eventContent);
            DisplayEvents refresh = new DisplayEvents(displayPanel);
            
            eventFrame.setVisible(false);
        }
    }
        
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taskplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author Michał
 */
public class AddEventForm  implements ActionListener  {
    
    JPanel displayPanel;
    JFrame addEventForm = new JFrame();
    
    ArrayList<String> categoriesFromFile = this.readCategories();
    String[] categories = this.convertCategories(categoriesFromFile);
    
    String[] priorities = { "Wysoki", "Średni", "Niski" };
    
    JComboBox category = new JComboBox(categories);
    JComboBox priority = new JComboBox(priorities);
    JEditorPane description = new JEditorPane();
    JButton accept = new JButton("Ok");
    
    AddEventForm(JPanel displayPanel)
    {
        
        RefineryUtilities.positionFrameOnScreen(addEventForm, 0.1, 0.25);
        this.displayPanel = displayPanel;
        
        addEventForm.setTitle("Dodaj wydarzenie");
        addEventForm.setResizable(false);
        addEventForm.setSize(700,150);
        
        addEventForm.setVisible(true);
        addEventForm.setLayout(new FlowLayout());
        
        addEventForm.add(category);
        category.setPreferredSize(new Dimension(100, 100));
        
        addEventForm.add(priority);
        priority.setPreferredSize(new Dimension(100, 100));
        
     
        addEventForm.add(description);
        description.setPreferredSize(new Dimension(300,100));
        description.setForeground(Color.red);
        Color bgColor = Color.LIGHT_GRAY;
        UIDefaults defaults = new UIDefaults();
        defaults.put("EditorPane[Enabled].backgroundPainter", bgColor);
        description.putClientProperty("Nimbus.Overrides", defaults);
        description.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        description.setBackground(bgColor);
        
  
        addEventForm.add(accept);
        accept.setPreferredSize(new Dimension(100,100));
        accept.addActionListener(this);
        
        addEventForm.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
    }

    private ArrayList<String> readCategories(){
        ObjectInputStream content=null ;
        ArrayList<String> categoryContent= new ArrayList();
        try{
            content = new ObjectInputStream(new FileInputStream("Category.dat"));
            } catch(FileNotFoundException e){
                } catch (IOException ex) {
                    Logger.getLogger(SaveCategoryToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
        try{
        categoryContent = (ArrayList<String>) content.readObject();
            }catch (NullPointerException e){
                } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(SaveCategoryToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        return categoryContent;
    }
    
    private String[] convertCategories(ArrayList<String> categories)
    {
        Object[] objectCategories = categories.toArray();
        String[] stringCategories = Arrays.copyOf(objectCategories, objectCategories.length, String[].class);
        
        return stringCategories;
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        int priorityValue;
        boolean canBeSaved = true;
        
        String newEvent = description.getText();
        
        String validate = newEvent;
        validate = newEvent.replaceAll(" ", "");
        validate = validate.replaceAll("\t", "");
        
        if(validate.toCharArray().length<1) {
        JOptionPane.showMessageDialog(addEventForm,
        "Wydarzenie musi posiadać opis!",
        "Pomyśl, co wpisujesz",
        JOptionPane.ERROR_MESSAGE);
        canBeSaved = false;
        }
        
        
        if (canBeSaved) {
        String categoryPicked = (String)category.getSelectedItem();
        String priorityPicked = (String)priority.getSelectedItem();
        
        if ( priorityPicked == "Wysoki") {
            priorityValue = 3;
        } else if (priorityPicked == "Średni") {
            priorityValue = 2;
        } else {
            priorityValue = 1;
        }
        
        System.out.print(categoryPicked);
        System.out.print(priorityValue);
        SaveEventToFile saveEvent = new SaveEventToFile(newEvent, categoryPicked, priorityValue);
        saveEvent.recordEvents();
        DisplayEvents refresher = new DisplayEvents(displayPanel);
        addEventForm.dispose();
        
    }
    }
}

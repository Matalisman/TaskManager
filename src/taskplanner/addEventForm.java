/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taskplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


/**
 *
 * @author Michał
 */
public class addEventForm implements ActionListener {
    JFrame addEventForm = new JFrame();
    
    ArrayList<String> categoriesFromFile = this.readCategories();
    String[] categories = this.convertCategories(categoriesFromFile);
    
    String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    JComboBox category = new JComboBox(categories);
    JEditorPane description = new JEditorPane();
    
    
    
    
    JButton accept = new JButton("Ok");
    
    
    addEventForm()
    {
        addEventForm.setResizable(false);
        addEventForm.setSize(500,100);
        addEventForm.setVisible(true);
        addEventForm.getContentPane().add(BorderLayout.WEST, category);
        category.setPreferredSize(new Dimension(100, 100));

        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        accept.addActionListener(this);
        
        addEventForm.add(description, BorderLayout.CENTER);
        description.setPreferredSize(new Dimension(300,100));
        description.setForeground(Color.red);
        
        Color bgColor = Color.LIGHT_GRAY;
        UIDefaults defaults = new UIDefaults();
        defaults.put("EditorPane[Enabled].backgroundPainter", bgColor);
        description.putClientProperty("Nimbus.Overrides", defaults);
        description.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        description.setBackground(bgColor);
  
        addEventForm.add(accept, BorderLayout.EAST);
        accept.setPreferredSize(new Dimension(100,100));
    }

    private ArrayList<String> readCategories(){
        ObjectInputStream content=null ;
        ArrayList<String> categoryContent= new ArrayList();
        try{
            content = new ObjectInputStream(new FileInputStream("Category.dat"));
            } catch(FileNotFoundException e){
                } catch (IOException ex) {
                    Logger.getLogger(saveCategoryToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
        try{
        categoryContent = (ArrayList<String>) content.readObject();
            }catch (NullPointerException e){
                } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(saveCategoryToFile.class.getName()).log(Level.SEVERE, null, ex);
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
        String newEvent = description.getText();
        String categoryPicked = (String)category.getSelectedItem();
        System.out.print(categoryPicked);
        saveEventToFile saveEvent = new saveEventToFile(newEvent, categoryPicked );
        addEventForm.setVisible(false);
    }
    
}

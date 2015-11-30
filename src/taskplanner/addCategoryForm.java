/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

/**
 *
 * @author Michał
 */
public class addCategoryForm implements ActionListener  {
    JFrame addCategoryForm = new JFrame();
    JEditorPane category = new JEditorPane();
    
    
    JButton accept = new JButton("Ok");

    addCategoryForm(){
        addCategoryForm.setResizable(false);
        addCategoryForm.setSize(500,100);
        addCategoryForm.setVisible(true);
        addCategoryForm.getContentPane().add(BorderLayout.EAST, accept);
                
        addCategoryForm.add(category);
        accept.setPreferredSize(new Dimension(100,100));
        
        accept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newCategory = category.getText();
        saveCategoryToFile saveCategory = new saveCategoryToFile(newCategory);
        addCategoryForm.setVisible(false);
        
    }
    
}



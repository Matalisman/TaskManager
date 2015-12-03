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
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Michał
 */
public class AddCategoryForm implements ActionListener  {
    JFrame addCategoryForm = new JFrame();
    JEditorPane category = new JEditorPane();
    JComboBox selectCategory;
    
    JButton accept = new JButton("Ok");

    AddCategoryForm(JComboBox selectCategory){
        this.selectCategory = selectCategory;
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
        SaveCategoryToFile saveCategory = new SaveCategoryToFile(newCategory);
        selectCategory.addItem(newCategory);
        selectCategory.revalidate();
        selectCategory.repaint();
        addCategoryForm.setVisible(false);
        
    }
    
}

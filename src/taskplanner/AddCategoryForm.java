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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Mateusz Borysewicz
 */
public class AddCategoryForm implements ActionListener  {
    
    private final JFrame addCategoryForm = new JFrame();
    private final JEditorPane category = new JEditorPane();
    
    private final JComboBox selectCategory;
    
    private final JButton accept = new JButton("Ok");

    AddCategoryForm(JComboBox selectCategory){
        this.selectCategory = selectCategory;
        
        addCategoryForm.setTitle("Dodaj kategorię");
        RefineryUtilities.positionFrameOnScreen(addCategoryForm, 0.15, 0.59);
        addCategoryForm.setResizable(false);
        addCategoryForm.setSize(500,100);
        addCategoryForm.setVisible(true);
        addCategoryForm.getContentPane().add(BorderLayout.EAST, accept);
                
        addCategoryForm.add(category);
        category.setPreferredSize(new Dimension(300,100));
        category.setForeground(Color.red);
        Color bgColor = Color.darkGray;
        UIDefaults defaults = new UIDefaults();
        defaults.put("EditorPane[Enabled].backgroundPainter", bgColor);
        category.putClientProperty("Nimbus.Overrides", defaults);
        category.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        category.setBackground(bgColor);
        
        accept.setPreferredSize(new Dimension(100,100));
        
        accept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        boolean canBeSaved = true;
        
        
        String newCategory = category.getText();
        
        String validate = newCategory;
        
        validate = newCategory.replaceAll(" ", "");
        validate = validate.replaceAll("\t", "");
        
        if(validate.toCharArray().length<1) {
        JOptionPane.showMessageDialog(addCategoryForm,
        "Kategoria nie może być pusta!",
        "Pomyśl, co wpisujesz",
        JOptionPane.ERROR_MESSAGE);
        canBeSaved = false;
        }
        
        if(canBeSaved) {
        
        SaveCategoryToFile saveCategory = new SaveCategoryToFile(newCategory);
        selectCategory.addItem(newCategory);
        selectCategory.revalidate();
        selectCategory.repaint();
        addCategoryForm.setVisible(false);
        }
    }
    
}

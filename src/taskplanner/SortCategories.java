/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michał
 */
public class SortCategories {
    
    String[] getCategories(){
    ArrayList<String> categoriesFromFile = this.readCategories();
    String[] categories = this.convertCategories(categoriesFromFile);
    String wszystkie = "Wszystkie";
    
    String[] all = new String[categories.length+1];
    all[0] = wszystkie;
    
    for ( int i=1; i<all.length; i++) {
        all[i] = categories[i-1];
    }
    
    return all;
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
}

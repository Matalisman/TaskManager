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
public class saveCategoryToFile {
    
    saveCategoryToFile(String newCategory) {
        
        ArrayList<String> categoryContent = new ArrayList();
        ObjectInputStream content=null ;
        ObjectOutputStream save = null;
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
        categoryContent.add(newCategory);
        
        try {
            save = new ObjectOutputStream(new FileOutputStream("Category.dat"));
        } catch (IOException ex) {
            Logger.getLogger(saveCategoryToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            save.writeObject(categoryContent);
        } catch (IOException ex) {
            Logger.getLogger(saveCategoryToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

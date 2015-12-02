/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mateusz Borysewicz
 */
public class TaskPlanner extends javax.swing.JFrame {

    /**
     * Creates new form TaskPlanner
     */
    public TaskPlanner() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundImage = new javax.swing.JLabel();
        addEvent = new javax.swing.JButton();
        addCategory = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();

        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/taskplanner/xwing.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("TaskPlanner"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addEvent.setLabel("Dodaj wydarzenie");
        addEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventActionPerformed(evt);
            }
        });
        getContentPane().add(addEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        addCategory.setText("Add Category");
        addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(addCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 377, -1, 25));
        DisplayEvents eventsDisplayer = new DisplayEvents(displayPanel);
        getContentPane().add(displayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 710, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventActionPerformed
              AddEventForm addEventForm = new AddEventForm(displayPanel);
    }//GEN-LAST:event_addEventActionPerformed

    private void addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryActionPerformed
            AddCategoryForm addCategoryForm = new AddCategoryForm();
    }//GEN-LAST:event_addCategoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskPlanner().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCategory;
    private javax.swing.JButton addEvent;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JPanel displayPanel;
    // End of variables declaration//GEN-END:variables
}

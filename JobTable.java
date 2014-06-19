/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;
import mgcproject.Job;
import mgcproject.ProductTable;
import mgcproject.Query;
import mgcproject.SQLStatements;

/**
 *
 * @author 3106909413
 */
public class JobTable extends javax.swing.JFrame {

    ArrayList<Job> jobsList = new ArrayList<Job>();
    
    /**
     * Creates new form NewJFrame
     */
    public JobTable() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        for (int i = 0; i < jobsList.size(); i++) {
            if (jTable1.isRowSelected(i)) {
                ProductTable pt = new ProductTable(i);
                pt.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
        CachedRowSet crs = new CachedRowSetImpl();
        crs = Query.readFromTable(SQLStatements.selectJobListStmt());
            while (crs.next())
            {
                int jobID = crs.getInt("job_id");
                String jobStatus = crs.getString("job_status");
                double taxPercent = crs.getDouble("tax_percent");
                double discountPercent = crs.getDouble("discount_percent");
                int quantityUsed = crs.getInt("job_qty_used");
                String customerABN = crs.getString("customer_cust_abn");
                String custFirstName = crs.getString("cust_first_name");
                String custLastName = crs.getString("cust_last_name");
                Job newJob = new Job(jobID, jobStatus, taxPercent,
                discountPercent, quantityUsed, customerABN, custFirstName,
                custLastName);
                jobsList.add(newJob);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        DefaultTableModel amodel = new DefaultTableModel();
        Object[] tableColumnNames = new Object[8]; // two columns in kart table
        tableColumnNames[0] = "Job Id";
        tableColumnNames[1] = "Status";
        tableColumnNames[2] = "Tax (%)";
        tableColumnNames[3] = "Discount (%)";
        tableColumnNames[4] = "Number of Jobs";
        tableColumnNames[5] = "Customer ABN";
        tableColumnNames[6] = "First Name";
        tableColumnNames[7] = "Last Name";
        amodel.setColumnIdentifiers(tableColumnNames); // important step model won't be visible 
        
        Object[] objects = new Object[8];
        if(jobsList.size() > 0) {
            for(int i = 0; i < jobsList.size(); i++ ) { // build the model
                Job someJob = jobsList.get(i);
                objects[0] = someJob.getJobID();
                objects[1] = someJob.getJobStatus();
                objects[2] = someJob.getTaxPercent();
                objects[3] = someJob.getDiscountPercent();
                objects[4] = someJob.getQuantityUsed();
                objects[5] = someJob.getCustomerABN();
                objects[6] = someJob.getCustFirstName();
                objects[7] = someJob.getCustLastName();
                
                amodel.addRow(objects);
            }
            
            this.jTable1.setModel(amodel);
        
        }//end of if
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(JobTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

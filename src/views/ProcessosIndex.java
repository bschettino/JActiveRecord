/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClientesIndex.java
 *
 * Created on 25/09/2012, 15:43:11
 */
package views;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import helpers.ButtonColumnDetalhar;

/**
 *
 * @author Schettino
 */
public class ProcessosIndex extends javax.swing.JFrame {
    
    public static final int COLUNA_ID = 0;
    public static final int COLUNA_NOME = 1;
    public static final int COLUNA_CPF = 2;
    public static final int COLUNA_RG = 3;
    public static final int COLUNA_PROCESSOS = 4;

    /** Creates new form ClientesIndex */
    public ProcessosIndex() {
        initComponents();
        
        ButtonColumnDetalhar buttonColumn = new ButtonColumnDetalhar(tableProcessos, COLUNA_PROCESSOS);
        //        tableClientes.setValueAt(buttonProcessos, 1, 3);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProcessos = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        buttonNovoCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {new Integer(1), "Thiago Neves", "121", "20/07/2012", null},
                {new Integer(2), "Thais Cunha", "157", "15/04/1997", null}
            },
            new String [] {
                "#", "Cliente", "Artigo", "Data", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProcessos.setRowHeight(20);
        jScrollPane1.setViewportView(tableProcessos);
        tableProcessos.getColumnModel().getColumn(0).setMinWidth(25);
        tableProcessos.getColumnModel().getColumn(0).setPreferredWidth(25);
        tableProcessos.getColumnModel().getColumn(0).setMaxWidth(40);

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 30));
        labelTitulo.setText("Processos");

        buttonNovoCliente.setText("Novo Processo");
        buttonNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonNovoCliente)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(333, 333, 333))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(buttonNovoCliente)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonNovoClienteActionPerformed

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
            java.util.logging.Logger.getLogger(ClientesIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new ProcessosIndex().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNovoCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tableProcessos;
    // End of variables declaration//GEN-END:variables
}

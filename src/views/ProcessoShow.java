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
public class ProcessoShow extends javax.swing.JFrame {
    
    public static final int COLUNA_ID = 0;
    public static final int COLUNA_NOME = 1;
    public static final int COLUNA_CPF = 2;
    public static final int COLUNA_RG = 3;
    public static final int COLUNA_PROCESSOS = 4;

    /** Creates new form ClientesIndex */
    public ProcessoShow() {
        initComponents();
        
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

        labelSituacao = new javax.swing.JLabel();
        textTelefone = new javax.swing.JLabel();
        labelTelefone = new javax.swing.JLabel();
        textSituacao = new javax.swing.JLabel();
        textDataNascimento = new javax.swing.JLabel();
        buttonAtualizarDados = new javax.swing.JButton();
        buttonAtualizarProcesso = new javax.swing.JButton();
        textRG = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelDataProcesso = new javax.swing.JLabel();
        labelRG = new javax.swing.JLabel();
        labelArtigo = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        textArtigo = new javax.swing.JLabel();
        labelDataNascimento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textCPF = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelSituacao.setText("Situação:");

        textTelefone.setText("87221228");

        labelTelefone.setText("Telefone:");

        textSituacao.setText("Em julgamento");

        textDataNascimento.setText("28/08/1989");

        buttonAtualizarDados.setText("Atualizar Dados");
        buttonAtualizarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarDadosActionPerformed(evt);
            }
        });

        buttonAtualizarProcesso.setText("Atualizar Processo");
        buttonAtualizarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarProcessoActionPerformed(evt);
            }
        });

        textRG.setText("11111111-1");

        jLabel1.setText("___________________________________________________________________________________");

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 25));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Thiago Neves");

        labelDataProcesso.setText("Data:");

        labelRG.setText("RG:");

        labelArtigo.setText("Artigo:");

        labelCPF.setText("CPF:");

        textArtigo.setText("121");

        labelDataNascimento.setText("Data de Nascimento:");

        jLabel2.setText("20/07/2012");

        textCPF.setText("11111111111");

        textTexto.setColumns(20);
        textTexto.setRows(5);
        textTexto.setText("Entrou no cinema vestido de Bane e metralhou todo mundo.");
        jScrollPane1.setViewportView(textTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(labelTitulo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAtualizarProcesso))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonAtualizarDados))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelArtigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textArtigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                .addComponent(labelDataProcesso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(92, 92, 92)
                                .addComponent(labelSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textSituacao))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCPF)
                                    .addComponent(labelRG))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textCPF)
                                    .addComponent(textRG))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDataNascimento)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelTelefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textTelefone)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDataNascimento)
                                .addGap(4, 4, 4)))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCPF)
                            .addComponent(textCPF))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRG)
                            .addComponent(textRG)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTelefone)
                            .addComponent(textTelefone))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDataNascimento)
                            .addComponent(textDataNascimento))))
                .addGap(31, 31, 31)
                .addComponent(buttonAtualizarDados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArtigo)
                    .addComponent(textArtigo)
                    .addComponent(labelSituacao)
                    .addComponent(textSituacao)
                    .addComponent(labelDataProcesso)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonAtualizarProcesso)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAtualizarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarDadosActionPerformed
    }
        // TODO add your handling code here:}//GEN-LAST:event_buttonAtualizarDadosActionPerformed

        private void buttonAtualizarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarProcessoActionPerformed
        }
        // TODO add your handling code here:}//GEN-LAST:event_buttonAtualizarProcessoActionPerformed

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
                new ProcessoShow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtualizarDados;
    private javax.swing.JButton buttonAtualizarProcesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelArtigo;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelDataProcesso;
    private javax.swing.JLabel labelRG;
    private javax.swing.JLabel labelSituacao;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel textArtigo;
    private javax.swing.JLabel textCPF;
    private javax.swing.JLabel textDataNascimento;
    private javax.swing.JLabel textRG;
    private javax.swing.JLabel textSituacao;
    private javax.swing.JLabel textTelefone;
    private javax.swing.JTextArea textTexto;
    // End of variables declaration//GEN-END:variables
}

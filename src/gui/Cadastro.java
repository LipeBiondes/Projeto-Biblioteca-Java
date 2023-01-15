/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import beans.Adm;
import dao.BibliotecaDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alefe Filipe
 */
public class Cadastro extends javax.swing.JFrame {
    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        initComponents();
        Cadastro.this.setExtendedState(MAXIMIZED_BOTH);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JToggleButton();
        txtConfSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Cadastro");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 40, 80, 40);

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail);
        txtEmail.setBounds(240, 80, 180, 40);

        jLabel2.setText("Email:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 90, 70, 40);

        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 130, 70, 40);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(240, 130, 180, 40);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(320, 230, 120, 50);
        getContentPane().add(txtConfSenha);
        txtConfSenha.setBounds(240, 180, 180, 40);

        jLabel4.setText("Confirmar Senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 170, 130, 40);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(200, 230, 100, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());
        String confSenha = new String(txtConfSenha.getPassword());
        
        if ("".equals(email) || "".equals(senha ) || "".equals(confSenha)) {
            JOptionPane.showMessageDialog(null, "Campos em branco, preencha");
            txtEmail.setText("");
            txtSenha.setText("");
            txtConfSenha.setText("");
        } else {
            System.out.println(senha.equals(confSenha));
            if (senha.equals(confSenha)) {
                Adm adm = new Adm();
                adm.setLogin(email);
                adm.setSenha(senha);

                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                bibliotecaDAO.inserirAdm(adm);

                txtEmail.setText("");
                txtSenha.setText("");
                txtConfSenha.setText("");
                
                Home home = new Home();
                home.setVisible(true);
                Cadastro.this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "Senhas não conferem");
                txtSenha.setText("");
                txtConfSenha.setText("");
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        Cadastro.this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCadastrar;
    private javax.swing.JToggleButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}

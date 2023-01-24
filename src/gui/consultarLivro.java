/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import beans.LivroBeans;
import beans.livroTableModel;
import dao.ConsultaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author thiago
 */
public class ConsultarLivro extends javax.swing.JFrame {

    /**
     * Creates new form consultarLivro
     */
    livroTableModel livro = new livroTableModel();

    public ConsultarLivro() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) txtTabela.getModel();
        txtTabela.setRowSorter(new TableRowSorter(modelo));
        ConsultarLivro.this.setLocationRelativeTo(null);

    }

    public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) txtTabela.getModel();
        modelo.setNumRows(0);
        ConsultaDAO consulta = new ConsultaDAO();
        for (LivroBeans e : consulta.read()) {

            modelo.addRow(new Object[]{
                e.getId(),
                e.getTitulo(),
                e.getAutor(),
                e.getGenero(),
                e.getQtd()

            });

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTabela = new javax.swing.JTable();
        btnConsulta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnApagarLivro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIDLivro = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Autor", "Genero", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        txtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTabelaMouseClicked(evt);
            }
        });
        txtTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTabelaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTabelaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtTabela);

        btnConsulta.setText("Consultar Livros");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Livro:");

        jLabel2.setText("Autor:");

        txtNomeAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAutorActionPerformed(evt);
            }
        });

        jLabel3.setText("Genero:");

        jLabel4.setText("Quantidade:");

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        btnEditar.setText("Salvar Edição");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnApagarLivro.setText("Apagar Livro");
        btnApagarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarLivroActionPerformed(evt);
            }
        });

        jLabel5.setText("ID do Livro");

        txtIDLivro.setEditable(false);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(jLabel2))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)))
                    .addComponent(txtIDLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApagarLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIDLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsulta)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        readJtable();
        txtNomeLivro.setText("");
        txtNomeAutor.setText("");
        txtQuantidade.setText("");
        txtGenero.setText("");
        txtIDLivro.setText("");

    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nomeLivro, nomeAutor, genero;
        int quantidade, id;
        nomeLivro = txtNomeLivro.getText();
        nomeAutor = txtNomeAutor.getText();
        genero = txtGenero.getText();
        quantidade = Integer.parseInt(txtQuantidade.getText());
        id = Integer.parseInt(txtIDLivro.getText());

        LivroBeans livro = new LivroBeans();
        livro.setTitulo(nomeLivro);
        livro.setAutor(nomeAutor);
        livro.setGenero(genero);
        livro.setQtd(quantidade);
        livro.setId(id);

        ConsultaDAO atualizar = new ConsultaDAO();
        atualizar.atualizarLivro(livro);
        readJtable();
        txtNomeLivro.setText("");
        txtNomeAutor.setText("");
        txtQuantidade.setText("");
        txtGenero.setText("");
        txtIDLivro.setText("");


    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNomeAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAutorActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void txtTabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTabelaKeyReleased
        if (txtTabela.getSelectedRow() != -1) {
            txtNomeLivro.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 1).toString());
            txtNomeAutor.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 2).toString());
            txtGenero.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 3).toString());
            txtQuantidade.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 4).toString());
        }

    }//GEN-LAST:event_txtTabelaKeyReleased

    private void txtTabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTabelaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTabelaKeyPressed

    private void txtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTabelaMouseClicked
        if (txtTabela.getSelectedRow() != -1) {
            txtNomeLivro.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 1).toString());
            txtNomeAutor.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 2).toString());
            txtGenero.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 3).toString());
            txtQuantidade.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 4).toString());
            txtIDLivro.setText(txtTabela.getValueAt(txtTabela.getSelectedRow(), 0).toString());

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTabelaMouseClicked

    private void btnApagarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarLivroActionPerformed
        int resposta;
        Object[] opcoes = {"SIM", "NÂO"};
       
      resposta = JOptionPane.showOptionDialog(
                           null
                         , "Deseja mesmo apagar o livro?"        // Mensagem
                         , "ATENÇÂO"               // Titulo
                         , JOptionPane.YES_NO_OPTION
                         , JOptionPane.PLAIN_MESSAGE                               
                         , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência
                         , opcoes // Array de strings com os valores de cada botão. Veja o exemplo abaixo **
                         , "Botao 3"    // Label do botão Default
                       );
        if (resposta== JOptionPane.YES_OPTION) {
            int id;
            id = Integer.parseInt(txtIDLivro.getText());
            ConsultaDAO apagar = new ConsultaDAO();
            apagar.apagarLivro(id);
            readJtable();
            txtNomeLivro.setText("");
            txtNomeAutor.setText("");
            txtQuantidade.setText("");
            txtGenero.setText("");
            txtIDLivro.setText("");

            
        } else {
            txtNomeLivro.setText("");
            txtNomeAutor.setText("");
            txtQuantidade.setText("");
            txtGenero.setText("");
            txtIDLivro.setText("");
            }

    }//GEN-LAST:event_btnApagarLivroActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Livro livro = new Livro();
        livro.setVisible(true);
        ConsultarLivro.this.setVisible(false);
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
            java.util.logging.Logger.getLogger(ConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagarLivro;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIDLivro;
    private javax.swing.JTextField txtNomeAutor;
    private javax.swing.JTextField txtNomeLivro;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTable txtTabela;
    // End of variables declaration//GEN-END:variables
}

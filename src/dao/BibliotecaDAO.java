package dao;

import beans.Adm;
import beans.Aluno;
import beans.Livro;
import beans.Emprestimo;
import conexao.Conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alefe Filipe
 */
public class BibliotecaDAO {
  private final Conexao conexao;
  private final Connection conn;

  public BibliotecaDAO() {
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
  }

  public void inserirAluno(Aluno aluno) {
    String sql = "INSERT INTO aluno(nome,endereco,telefone,sexo) VALUES" + "(?, ?, ?, ?)";
    try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, aluno.getNome());
      stmt.setString(2, aluno.getEndereco());
      stmt.setString(3, aluno.getTelefone());
      stmt.setString(4, aluno.getSexo());
      stmt.execute();
      JOptionPane.showMessageDialog(null, "Sucesso ao inserir dados!");
    } catch (HeadlessException | SQLException e) {
      System.out.println("Erro ao inserir Aluno: " + e);
      JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
    }
  }

  public void inserirLivro(Livro livro) {
    String sql = "INSERT INTO livro(titulo,genero,autor,status,qtd) VALUES" + "(?, ?, ?, ?,?)";
    try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, livro.getTitulo());
      stmt.setString(2, livro.getGenero());
      stmt.setString(3, livro.getAutor());
      stmt.setInt(4, livro.getStatus());
      stmt.setInt(5, livro.getQtd());
      stmt.execute();
      JOptionPane.showMessageDialog(null, "Sucesso ao inserir dados!");
    } catch (HeadlessException | SQLException e) {
      System.out.println("Erro ao inserir Livro: " + e);
      JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
    }
  }

  public void inserirEmprestimo(Emprestimo emprestimo) {
    String sql = "INSERT INTO emprestimo(id_aluno, id_livro, id_adm, dataP, dataD, status) VALUES" + "(?, ?, ?, ?, ?, ?)";
    try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setInt(1, emprestimo.getId_aluno());
      stmt.setInt(2, emprestimo.getId_livro());
      stmt.setInt(3, emprestimo.getId_adm());
      stmt.setString(4, emprestimo.getDataP());
      stmt.setString(5, emprestimo.getDataD());
      stmt.setInt(6, emprestimo.getStatus());
      stmt.execute();
      JOptionPane.showMessageDialog(null, "Sucesso ao inserir dados!");
    } catch (HeadlessException | SQLException e) {
      System.out.println("Erro ao inserir Emprestimo: " + e);
      JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
    }
  }
  
 public void inserirAdm(Adm adm) {
    String sql = "INSERT INTO adm(login, senha) VALUES" + "(?, ?)";
        try {
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setString(1, adm.getLogin());
         stmt.setString(2, adm.getSenha());
         stmt.execute();
         JOptionPane.showMessageDialog(null, "Sucesso ao inserir dados!");
     } catch (HeadlessException | SQLException e) {
         System.out.println("Erro ao inserir Emprestimo: " + e);
         JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
     }
    }
 
 public Adm auntenticarUsuario(String login, String senha){
     String sql = "SELECT * FROM `adm` WHERE login = ? AND senha = ?";
     try {
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setString(1, login);
         stmt.setString(2, senha);
         ResultSet rs = stmt.executeQuery();
         Adm adm = new Adm();
         
         rs.first();
         adm.setLogin(rs.getString("login"));
         adm.setSenha(rs.getString("senha"));
         return adm;
     } catch (SQLException e) {
         System.out.println("Erro ao consultar adm" + e);
         return null;
     }
 }
}

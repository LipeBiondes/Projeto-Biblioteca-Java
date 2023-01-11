package dao;

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
    String sql = "INSERT INTO emprestimo(id_aluno,id_livro,dataP,dataD) VALUES" + "(?, ?, ?, ?)";
    try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setInt(1, emprestimo.getId_aluno());
      stmt.setInt(2, emprestimo.getId_livro());
      stmt.setString(3, emprestimo.getDataP());
      stmt.setString(4, emprestimo.getDataD());
      stmt.execute();
      JOptionPane.showMessageDialog(null, "Sucesso ao inserir dados!");
    } catch (HeadlessException | SQLException e) {
      System.out.println("Erro ao inserir Emprestimo: " + e);
      JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
    }
  }

}

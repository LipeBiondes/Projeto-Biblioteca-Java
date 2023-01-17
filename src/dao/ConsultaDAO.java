/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.LivroBeans;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiag
 */
public class ConsultaDAO {

    private final Conexao conexao;
    private final Connection conn;

    public ConsultaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public List<LivroBeans> read() {
        String sql = "SELECT * FROM `livro`";

        List<LivroBeans> livros = new ArrayList<>();
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // rs.first();

            while (rs.next()) {
                LivroBeans livro = new LivroBeans();

                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setGenero(rs.getString("genero"));
                livro.setQtd(rs.getInt("qtd"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar Livros: " + e);
            return null;
        }
        return livros;
    }

    public void atualizarLivro(LivroBeans livro) {
        String sql = "UPDATE livro SET titulo=?, genero=?, autor=?, qtd=? WHERE id=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getGenero());
            stmt.setString(3, livro.getAutor());
            stmt.setInt(4, livro.getQtd());
            stmt.setInt(5, livro.getId());
            stmt.execute();

            JOptionPane.showMessageDialog(null, "Livro atualizado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "atualizarLivro " + e);
        }
    }

    public void apagarLivro(int id) {
        String sql = "DELETE FROM livro WHERE id=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Livro deletado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error no apagarLivro");
        }
    }
}

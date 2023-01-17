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

/**
 *
 * @author Alefe Filipe
 */
public class CriaEmprestimoDAO {

    private final Conexao conexao;
    private final Connection conn;

    public CriaEmprestimoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public List<LivroBeans> read() {
        String sql = "SELECT * FROM `livro` WHERE `qtd` > 0;";

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

}

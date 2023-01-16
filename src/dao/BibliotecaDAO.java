package dao;

import beans.Adm;
import beans.Aluno;
import beans.Data;
import beans.LivroBeans;
import beans.Emprestimo;
import conexao.Conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
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
        String sql = "INSERT INTO aluno(nome,endereco,telefone,cpf, livros_pegados) VALUES" + "(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getCpf());
            stmt.setInt(5, 0);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir dados!");
        } catch (HeadlessException | SQLException e) {
            System.out.println("Erro ao inserir Aluno: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
        }
    }

    public void cadastrarLivro(LivroBeans livro) {
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

    public Adm auntenticarUsuario(String login, String senha) {
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

    public Data gerarData() {
//     Método para gerar a data atual e a de devolução
        Data dataGerada = new Data();
        Calendar calendar = Calendar.getInstance();
        Date data = calendar.getTime();

        DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
//    Setando a data atual gerada pelo Date
        dataGerada.setData_hoje(f.format(data));
//    Adicionando 15 dias na data gerada
        calendar.add(Calendar.DAY_OF_MONTH, 15);

        data = calendar.getTime();
        dataGerada.setData_devolver(f.format(data));
//    Retornando a classe Data com a variavel dataGerdad
        return dataGerada;

        /*    Instaciar dessa forma quando for usar:
    
    BibliotecaDAO metodo = new BibliotecaDAO();
    Data data = metodo.gerarData();
    
    ex:
    
    String data_hoje = data.getData_hoje();
    String data_devolver = data.getData_devolver();
    
         */
    }

    public Aluno consultarCpf(String cpF) {
        String sql = "SELECT * FROM `aluno` WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpF);
            ResultSet rs = stmt.executeQuery();

            Aluno aluno = new Aluno();
            rs.first();
            aluno.setCpf(rs.getString("cpf"));
            aluno.setEndereco(rs.getString("endereco"));
            aluno.setNome(rs.getString("nome"));
            aluno.setTelefone(rs.getString("telefone"));
            aluno.setLivros_pegados(rs.getInt("livros_pegados"));
            return aluno;
        } catch (SQLException e) {
            System.out.println("Erro ao consultar cpf" + e);
            return null;
        }
    }
}

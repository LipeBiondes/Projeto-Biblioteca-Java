package biblioteca;

import beans.Aluno;
import beans.Emprestimo;
import beans.Livro;
import dao.BibliotecaDAO;
import gui.Home;
import javax.swing.JFrame;

/**
 *
 * @author Alefe Filipe
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Home telaInicial = new Home();
        telaInicial.setExtendedState(JFrame. MAXIMIZED_BOTH);
        //telaInicial.setVisible(true);
        
        Livro livro = new Livro();
        livro.setAutor("Ismael Henrique");
        livro.setGenero("Educação");
        livro.setQtd(1);
        livro.setTitulo("Como programar em python");
        livro.setStatus(1);
        
        Aluno aluno = new Aluno();
        aluno.setNome("Thiago");
        aluno.setSexo("M");
        aluno.setEndereco("Rua Nova Prata");
        aluno.setTelefone("9499140028922");
        
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataD("09/02/2023");
        emprestimo.setDataP("11/01/2023");
        emprestimo.setId_aluno(1);
        emprestimo.setId_livro(1);
        
        BibliotecaDAO inserirLivro = new BibliotecaDAO();
        inserirLivro.inserirEmprestimo(emprestimo);
    }
}

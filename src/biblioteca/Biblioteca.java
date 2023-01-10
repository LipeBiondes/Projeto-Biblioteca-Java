package biblioteca;

import conexao.Conexao;

/**
 *
 * @author Alefe Filipe
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        conexao.getConexao();
    }

}

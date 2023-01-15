package beans;

/**
 * @author Alefe Filipe
 */
public class Aluno {
    private int id, livros_pegados;
    private String nome, endereco, telefone, cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivros_pegados() {
        return livros_pegados;
    }

    public void setLivros_pegados(int livros_pegados) {
        this.livros_pegados = livros_pegados;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

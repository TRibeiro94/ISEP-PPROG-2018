package model;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Utilizador {
    
    /**
     * Nome do Utilizador
     */
    private String nome;
    /**
     * e-mail do Utilizador
     ^ 
     */
    private String email;
    /**
     * password do Utilizador
     */
    private String password;
    /**
     * Nome do Utilizador por omissão
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    /**
     * E-mail do utilizador por omissão
     */
    private static final String EMAIL_POR_OMISSAO = "sem email";
    /**
     * password do utilizador por omissão
     */
    private static final String PASS_POR_OMISSAO = "sem password";
    
    /**
     * Constrói uma instância de Utilizador que recebe nome, email e password
     * @param nome nome do Utilizador
     * @param email e-mail do Utilizador
     * @param password password do Utilizador
     */
    public Utilizador(String nome, String email, String password){
        this.nome = nome;
        this.email = email;
        this.password = password;
    }
    /**
     * Constrói uma instância de Utilizador que é 'cópia' da instância de Utilizador passada por parâmetro
     * @param outroUtilizador Utilizador que vai ser 'copiado'
     */
    public Utilizador(Utilizador outroUtilizador){
        this.nome = outroUtilizador.nome;
        this.email = outroUtilizador.email;
        this.password = outroUtilizador.email;
    }
    /**
     * Constrói uma instância de Utilizador com os valores por omissão
     */
    public Utilizador(){
        nome = NOME_POR_OMISSAO;
        email = EMAIL_POR_OMISSAO;
        password = PASS_POR_OMISSAO;
    }
    /**
     * Devolve o nome do Utilizador
     * @return nome do Utilizador
     */
    public String getNome(){
        return nome;
    }
    /**
     * Devolve o email do Utilizador
     * @return email do Utilizador
     */
    public String getEmail(){
        return email;
    }
    /**
     * Devolve a password do Utilizador
     * @return password do Utilizador
     */
    public String getPassword(){
        return password;
    }
    /**
     * Modifica o nome do Utilizador
     * @param nome nome do Utilizador
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    /**
     * Modifica o e-mail do Utilizador
     * @param email e-mail do Utilizador
     */
    public void setEmail(String email){
        this.email = email;
    }
    /**
     * Modifica a password do Utilizador
     * @param password password do Utilizador
     */
    public void setPassword(String password){
        this.password = password;
    }
    /**
     * Devolve as características gerais do Utilizador (nome e e-mail)
     * @return 
     */
    @Override
    public String toString(){
        return String.format("Nome: %s\nE-mail: %s",nome,email);
    }
}

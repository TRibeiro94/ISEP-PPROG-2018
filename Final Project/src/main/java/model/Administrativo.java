package model;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Administrativo extends Utilizador{
    
    /**
     * Constrói uma instância de Administrativo que recebe nome, email, password
     * @param nome nome do Utilizador
     * @param email e-mail do Utilizador
     * @param password password do Utilizador
     */
    public Administrativo(String nome, String email, String password) {
        super(nome, email, password);
    }
    /**
     * Constrói uma instância de Administrativo com os valores por omissão
     */
    public Administrativo(){
        super();
    }
}

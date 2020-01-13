package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Cliente extends Utilizador{
    /**
     * NIF de um cliente
     */
    private String NIF;
    /**
     * contacto telefónico de um cliente
     */
    private String telefone;
    /**
     * Contentor que irá armazenar os endereços postal de um cliente
     */
    private List<EnderecoPostal> listaEnderecos = new ArrayList<EnderecoPostal>();
    
    /**
     * NIF de um cliente por omissão
     */
    private static final String NIF_POR_OMISSAO = "sem NIF definido";
    /**
     * contacto telefónico de um cliente por omissão
     */
    private static final String TEL_POR_OMISSAO = "sem contacto telefónico";
    /**
     * Constrói uma instância de Cliente que recebe nome, email, password, NIF, telefone, enderecoPostal
     * @param nome Nome de um Cliente
     * @param email e-mail de um Cliente
     * @param password password de um Cliente
     * @param NIF NIF de um Cliente
     * @param telefone telefone de um Cliente
     * @param enderecoPostal endereço postal de um Cliente
     */
    public Cliente(String nome, String email, String password, String NIF, String telefone, EnderecoPostal enderecoPostal){
        super(nome, email, password);
        this.NIF = NIF;
        this.telefone = telefone;
        listaEnderecos.add(enderecoPostal);
    }
    
    /**
     * Constrói uma instância de Cliente que é cópia de uma instância Cliente passada por parâmetro
     * @param outroCliente Cliente que vai ser 'copiado'
     */
    public Cliente(Cliente outroCliente){
        super(outroCliente);
        this.NIF = outroCliente.NIF;
        this.telefone = outroCliente.telefone;
        this.listaEnderecos = outroCliente.listaEnderecos;
    }
    
    /**
     * Constrói uma instância de Cliente com os valores por omissão
     */
    public Cliente(){
        super();
        NIF = NIF_POR_OMISSAO;
        telefone = TEL_POR_OMISSAO;
    }
    
    /**
     * Devolve o NIF do Cliente
     * @return NIF do Cliente
     */
    public String getNIF(){
        return NIF;
    }
    
    /**
     * Devolve o contacto telefónico do Cliente
     * @return contacto telefónico do Cliente
     */
    public String getTelefone(){
        return telefone;
    }
    
    /**
     * Devolve a lista de endereços postais do Cliente
     * @return lista de endereços postais do Cliente
     */
    public List<EnderecoPostal> getListaEnderecos(){
        return listaEnderecos;
    }
    
    /**
     * Modifica o NIF do Cliente
     * @param NIF NIF do Cliente
     */
    public void setNIF(String NIF){
        if(NIF == null || NIF.isEmpty())
            throw new IllegalArgumentException("O argumento 'NIF' não deve estar vazio ou ser nulo");
        this.NIF = NIF;
    }
    
    /**
     * Modifica o contacto telefónico do Cliente
     * @param telefone contacto telefónico do Cliente
     */
    public void setTelefone(String telefone){
        if(telefone == null || telefone.isEmpty())
            throw new IllegalArgumentException("O argumento 'telefone' não deve estar vazio ou ser nulo");
        this.telefone = telefone;
    }
    
    /**
     * Modifica a lista de endereços postais do Cliente
     * @param listaEnderecos lista de endereços postais do Cliente
     */
    public void setListaEnderecos(List<EnderecoPostal> listaEnderecos){
        if(listaEnderecos == null || listaEnderecos.isEmpty())
            throw new IllegalArgumentException("O argumento 'lista de endereços' não deve estar vazio ou ser nulo");
        this.listaEnderecos = listaEnderecos;
    }
    
    /**
     * Adiciona um endereço postal ao contentor de endereços da instância Cliente
     * @param novoEndereco endereço que vai ser adicionado à lista
     */
    public void adicionarEndereco(EnderecoPostal novoEndereco){
        if(novoEndereco == null)
            throw new IllegalArgumentException("O argumento 'endereço' a ser adicionado ser nulo");
        listaEnderecos.add(novoEndereco);
    }
    
    /**
     * Imprime a lista com os endereços do Cliente
     */
    public void listarEnderecos() {
        for (EnderecoPostal endereco : listaEnderecos) {
            if(endereco != null){
                System.out.println("("+ (listaEnderecos.indexOf(endereco)+1) +")\n" + endereco.toString());
            }
        }
    }
    
    /**
     * Remove um determinado endereço postal do contentor de endereços do Cliente
     * @param endereco endereco que vai ser removido do contentor
     * @return false, se o endereço passado por parâmetro não existir no contentor
     */
    public boolean removerEndereco(EnderecoPostal endereco){
        return listaEnderecos.remove(endereco);
    }
    
    /**
     * Devolve um endereço baseado numa escolha feita, escolha essa passada por parâmetro
     * @param numero escolha feita que vai ser comparada com o index do endereço desejado
     * @return endereço postal com index igual ao passado por parâmetro
     */
    public EnderecoPostal getEnderecoByNumero(int numero){
        for(EnderecoPostal endPostal: listaEnderecos){
            if(listaEnderecos.indexOf(endPostal)+1 == numero){
                return endPostal;
            }
        }
        return null;
    }    
  
    /**
     * Compara dois objectos Cliente através do NIF e contacto telefónico
     * sendo os objectos considerados iguais apenas quando estas 2 características forem iguais
     * @param outroObjecto objecto que vai ser comparado com o objecto que chama o método
     * @return true, se as referências dos objectos a ser comparados apontam para o mesmo objecto
     *         false, se o objecto comparado for nulo ou as classes dos dois objectos forem diferentes
     *         true, se o NIF e telefone dos dois objectos forem iguais
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }
        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        Cliente outroCliente = (Cliente) outroObjecto;
            return this.NIF.equalsIgnoreCase(outroCliente.NIF)
                && this.getNome().equalsIgnoreCase(outroCliente.getNome())
                && this.getPassword().equalsIgnoreCase(outroCliente.getPassword())
                && this.telefone.equalsIgnoreCase(outroCliente.telefone);
    }    
    
    /**
     * Devolve as características do Cliente (nome,NIF,contacto)
     * @return características do Cliente (nome,NIF,contacto)
     */
    @Override
    public String toString(){
        return String.format("Cliente: %s , detentor do NIF nº %s.\nContacto: %s",this.getNome(),NIF,telefone);
    }
}

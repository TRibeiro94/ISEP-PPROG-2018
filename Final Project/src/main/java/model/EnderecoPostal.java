package model;

import java.io.Serializable;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class EnderecoPostal implements Serializable{
    
    /**
     * Morada de um determinado Endereço Postal
     */
    private String endereco;
    /**
     * Localidade de um determinado Endereço Postal
     */
    private String localidade;
    /**
     * Código-Postal de um determinado Endereço Postal
     */
    private CodigoPostal codPostal;
    /**
     * Morada do Endereço Postal por omissão
     */
    private static final String ENDERECO_POR_OMISSAO = "sem endereço";
    /**
     * Localidade do Endereço Postal por omissão
     */
    private static final String LOCALIDADE_POR_OMISSAO = "localidade não definida";
    /**
     * Código-postal do Endereço por omissão
     */
    private static final CodigoPostal CODIGO_POSTAL_POR_OMISSAO = new CodigoPostal();
    
    /**
     * Constrói uma instância de EnderecoPostal que recebe endereço, localidade e código-postal
     * 
     * @param endereco Morada de um determinado Endereço Postal
     * @param localidade Localidade de um determinado Endereço Postal
     * @param codPostal Código-Postal de um determinado Endereço Postal
     */
    public EnderecoPostal(String endereco, String localidade, CodigoPostal codPostal){
        if ( (endereco == null) || (localidade == null) || (endereco.isEmpty()) || (localidade.isEmpty()) || (codPostal == null))
            throw new IllegalArgumentException("Nenhum dos argumentos deve estar vazio ou ser nulo.");
        this.endereco = endereco;
        this.localidade = localidade;
        this.codPostal = new CodigoPostal(codPostal);
    }

    /**
     * Constrói uma instância de EnderecoPostal que é cópia de uma instância EnderecoPostal passada por parâmetro
     *
     * @param outroEndereco Endereço que vai ser 'copiado'
     */
    public EnderecoPostal(EnderecoPostal outroEndereco) {
        this.endereco = outroEndereco.getEndereco();
        this.localidade = outroEndereco.getLocalidade();
        this.codPostal = new CodigoPostal(outroEndereco.getCodPostal());
    }
    
    /**
     * Constrói uma instância de EnderecoPostal com os valores por omissão
     */
    public EnderecoPostal(){
        endereco = ENDERECO_POR_OMISSAO;
        localidade = LOCALIDADE_POR_OMISSAO;
        codPostal = CODIGO_POSTAL_POR_OMISSAO;
    }
    /**
     * Devolve a morada do endereço postal 
     * @return morada do endereço postal
     */
    public String getEndereco(){
        return endereco;
    }
    /**
     * Devolve a localidade do endereço postal
     * @return localidade do endereço postal
     */
    public String getLocalidade(){
        return localidade;
    }
    /**
     * Devolve o código postal do endereço
     * @return código postal do endereço
     */
    public CodigoPostal getCodPostal() {
        return new CodigoPostal(codPostal);
    }
    /**
     * Modifica a morada do endereço postal
     * @param endereco morada do endereço postal
     */
    public void setEndereco(String endereco){
        if(endereco == null || endereco.isEmpty())
            throw new IllegalArgumentException("O argumento 'endereço' não deve estar vazio ou ser nulo.");
        this.endereco = endereco;
    }
    /**
     * Modifica a localidade do endereço postal
     * @param localidade localidade do endereço postal
     */
    public void setLocalidade(String localidade){
        if(localidade == null || localidade.isEmpty())
            throw new IllegalArgumentException("O argumento 'localidade' não deve estar vazio ou ser nulo");
        this.localidade = localidade;
    }
    /**
     * Modifica o código-postal do endereço postal
     * @param codPostal 
     */
    public void setCodigoPostal(CodigoPostal codPostal){
        if (codPostal == null)
            throw new IllegalArgumentException("O argumento do tipo'CodigoPostal' não deve ser nulo");
        this.codPostal.setCodigoPostal(codPostal.getCodPostal(), codPostal.getLatitude(), codPostal.getLongitude());
    }
    /**
     * Modifica o código-postal do endereço postal
     * @param codPostal código-postal do endereço postal
     * @param latitude latitude referente ao código-postal
     * @param longitude longitude referente ao código-postal
     */
    public void setCodigoPostal(String codPostal, String latitude, String longitude){
        if (codPostal.isEmpty() || codPostal == null) throw new IllegalArgumentException("O argumento 'código postal' não deve estar vazio.");
        this.codPostal.setCodigoPostal(codPostal, latitude, longitude);
    }
    /**
     * Compara dois objectos EnderecoPostal através do endereço, localidade e código-postal,
     * sendo os objectos considerados iguais apenas quando estas 3 características forem iguais
     * @param outroObjecto objecto que vai ser comparado com o objecto que chama o método
     * @return true, se as referências dos objectos a ser comparados apontam para o mesmo objecto
     *         false, se o objecto comparado for nulo ou as classes dos dois objectos forem diferentes
     *         true, se endereço, localidade e código-postal de dois objectos forem iguais
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }
        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        EnderecoPostal outroEndereco = (EnderecoPostal) outroObjecto;
            return this.endereco.equalsIgnoreCase(outroEndereco.endereco)
                && this.localidade.equalsIgnoreCase(outroEndereco.localidade)
                && this.codPostal.equals(outroEndereco.codPostal);
    }
    /**
     * Devolve as características do endereço-postal em texto
     * @return características do endereço-postal em texto
     */
    @Override
    public String toString(){
        return String.format("%s, Localidade: %s, Código-Postal: %s",endereco,localidade,this.codPostal);
    }
}

package model;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class AreaGeografica {
    
    /**
     * Designação da área geográfica (distrito)
     */
    private String designacao;
    /**
     * custo de Deslocação
     */
    private double custoDeslocacao;
    /**
     * código-postal central da área geográfica
     */
    private CodigoPostal codPostal;
    
    /**
     * Designação da área geográfica (distrito) por omissão
     */
    private static final String DESIGNACAO_POR_OMISSAO = "sem designação";
    /**
     * custo de Deslocação por omissão
     */
    private static final double CUSTO_DESLOC_POR_OMISSAO = 0;
    /**
     * código-postal central da área geográfica por omissão
     */
    private static final CodigoPostal COD_POST_POR_OMISSAO = new CodigoPostal();
    
    /**
     * Constrói uma instância de AreaGeografica que recebe designacao, custo de deslocacao e codigoPostal
     * @param designacao Designação da área geográfica (distrito)
     * @param custoDeslocacao custo de Deslocação
     * @param codPostal código-postal central da área geográfica
     */
    public AreaGeografica(String designacao, double custoDeslocacao, CodigoPostal codPostal){
        this.designacao = designacao;
        this.custoDeslocacao = custoDeslocacao;
        this.codPostal = new CodigoPostal(codPostal);
    }
    /**
     * Constrói uma instância de AreaGeografica que é cópia de uma instância AreaGeografica passada por parâmetro
     * @param area AreaGeografica que vai ser 'copiada'
     */
    public AreaGeografica(AreaGeografica area){
        this.designacao = area.designacao;
        this.custoDeslocacao = area.custoDeslocacao;
        this.codPostal = new CodigoPostal(area.codPostal);
    }
    /**
     * Constrói uma instância de AreaGeografica com os valores por omissão
     */
    public AreaGeografica(){
        designacao = DESIGNACAO_POR_OMISSAO;
        custoDeslocacao = CUSTO_DESLOC_POR_OMISSAO;
        codPostal = COD_POST_POR_OMISSAO;
    }
    /**
     * Devolve a designação(distrito) da AreaGeografica
     * @return designação(distrito) da AreaGeografica
     */
    public String getDesignacao(){
        return designacao;
    }
    /**
     * Devolve o custo de Deslocacao adjacente à AreaGeografica
     * @return custo de Deslocacao adjacente à AreaGeografica
     */
    public double getCustoDeslocacao(){
        return custoDeslocacao;
    }
    /**
     * Devolve o codigo-postal central da AreaGeografica
     * @return codigo-postal central da AreaGeografica
     */
    public CodigoPostal getCodigoPostal(){
        return codPostal;
    }
    /**
     * Modifica a designação(distrito) da AreaGeografica
     * @param designacao designação(distrito) da AreaGeografica
     */
    public void setDesignacao(String designacao){
        if(designacao == null || designacao.isEmpty())
            throw new IllegalArgumentException("O argumento 'designação(distrito) da área geográfica' não deve estar vazio ou ser nulo");
        this.designacao = designacao;
    }
    /**
     * Modifica o custo de Deslocacao adjacente à AreaGeografica
     * @param custoDeslocacao custo de Deslocacao adjacente à AreaGeografica
     */
    public void setCustoDeslocacao(double custoDeslocacao){
        if(custoDeslocacao == 0)
            throw new IllegalArgumentException("O argumento 'custo de deslocação' não deve ser nulo");
        this.custoDeslocacao = custoDeslocacao;
    }
    /**
     * Modifica o codigo-postal central da AreaGeografica
     * @param codPostal codigo-postal central da AreaGeografica
     */
    public void setCodigoPostal(CodigoPostal codPostal){
        if(codPostal == null)
            throw new IllegalArgumentException("O argumento 'código-postal' não deve ser nulo");
        this.codPostal = codPostal;
    }
    
    /**
     * Devolve as característas da AreaGeografica
     * @return característas da AreaGeografica
     */
    @Override
    public String toString(){
        return String.format("Designação : %s , Custo de Deslocação: %.2f ",designacao, custoDeslocacao);
    }
}

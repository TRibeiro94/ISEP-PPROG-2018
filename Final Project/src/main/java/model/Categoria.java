package model;

/**
 * @author Tiago Ribeiro (1181444)
 */
class Categoria {
    /**
     * Código único da categoria
     */
    private String catID;
    /**
     * descrição da Categoria
     */
    private String descricao;
    /**
     * Código único da categoria por omissão
     */
    private static final String ID_POR_OMISSAO = "cat0";
    /**
     * Descrição da Categoria por omissão
     */
    private static final String DESC_POR_OMISSAO = "sem descrição";
    /**
     * Constrói uma instância de Categoria que recebe o seu código/identificador único e a sua descrição
     * 
     * @param catID Código único da categoria
     * @param descricao descrição da Categoria
     */
    public Categoria(String catID, String descricao){
        this.catID = catID;
        this.descricao = descricao;
    }
    /**
     * Constrói uma instância de Categoria que é cópia de uma instância Categoria passada por parâmetro
     * @param outraCategoria categoria que vai ser copiada
     */
    public Categoria(Categoria outraCategoria){
        this.catID = outraCategoria.catID;
        this.descricao = outraCategoria.descricao;
    }
    /**
     * Constrói uma instância de Categoria com os valores por omissão
     */
    public Categoria(){
        catID = ID_POR_OMISSAO;
        descricao = DESC_POR_OMISSAO;
    }
    /**
     * Devolve o código único da Categoria
     * @return código único da Categoria
     */
    public String getCatID(){
        return catID;
    }
    /**
     * Devolve a descrição da Categoria
     * @return descrição da Categoria
     */
    public String getDescricao(){
        return descricao;
    }
    /**
     * Modifica o código único da Categoria
     * @param catID código único da Categoria
     */
    public void setCatID(String catID){
        if(catID == null || catID.isEmpty())
            throw new IllegalArgumentException("O argumento 'ID da categoria' não deve estar vazio ou ser nulo");
        this.catID = catID;
    }
    /**
     * Modifica a descrição da Categoria
     * @param descricao descrição da Categoria
     */
    public void setCatDescricao(String descricao){
        if(descricao == null || descricao.isEmpty())
            throw new IllegalArgumentException("O argumento 'descrição da categoria' não deve estar vazio ou ser nulo");
        this.descricao = descricao;
    }
    
    /**
     * Compara dois objectos Categoria através do código único da mesma e da sua descrição
     * sendo os objectos considerados iguais apenas quando estas 2 características forem iguais
     * @param outroObjecto objecto que vai ser comparado com o objecto que chama o método
     * @return true, se as referências dos objectos a ser comparados apontam para o mesmo objecto
     *         false, se o objecto comparado for nulo ou as classes dos dois objectos forem diferentes
     *         true, se o ID e a descrição dos dois objectos forem iguais
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }
        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        Categoria outraCategoria = (Categoria) outroObjecto;
            return this.catID.equalsIgnoreCase(outraCategoria.catID)
                && this.descricao.equalsIgnoreCase(outraCategoria.descricao);
    }    
    
    /**
     * Devolve as características da Categoria(ID,descrição)
     * @return Devolve as características da Categoria(ID,descrição)
     */
    @Override
    public String toString(){
        return String.format("Categoria: %s",descricao);
    }
}

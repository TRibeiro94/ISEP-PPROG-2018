package model;

import java.io.Serializable;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Servico implements Serializable{
    
    private String catID;
    /**
     * ID único do Serviço
     */
    private String servID;
    /**
     * Descrição breve do serviço
     */
    private String descBreve;
    /**
     * Descrição completa do serviço
     */
    private String descComp;
    /**
     * custo p/hora do Serviço
     */
    private double custoHora;
    /**
     * ID único do Serviço por omissão
     */
    private static final String ID_POR_OMISSAO = "sem ID";
    /**
     * Descrição breve do serviço por omissão
     */
    private static final String DESC_BREVE_POR_OMISSAO = "sem descrição breve";
    /**
     * Descrição completa do serviço por omissão
     */
    private static final String DESC_COMP_POR_OMISSAO = "sem descrição completa";
    /**
     * custo p/hora do serviço por omissão
     */
    private static final double CUSTO_POR_OMISSAO = 0;
    
    /**
     * Constrói uma instância de Serviço que recebe ID, descrição breve, descrição completa e custo por hora
     * @param servID ID único do serviço
     * @param descBreve descrição breve do serviço
     * @param descComp descrição completa do serviço
     * @param custoHora custo p/ hora do serviço
     */
    public Servico(String catID, String servID, String descBreve, String descComp, double custoHora){
        this.catID = catID;
        this.servID = servID;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.custoHora = custoHora;
    }
    /**
     * Constrói uma instância de Servico que é 'cópia' de uma instância Servico passada por parâmetro
     * @param outroServico Servico que vai ser 'copiado'
     */
    public Servico(Servico outroServico){
        this.servID = outroServico.servID;
        this.descBreve = outroServico.descBreve;
        this.descComp = outroServico.descComp;
        this.custoHora = outroServico.custoHora;
    }
    /**
     * Constrói uma instância de Servico com os valores por omissão
     */
    public Servico(){
        servID = ID_POR_OMISSAO;
        descBreve = DESC_BREVE_POR_OMISSAO;
        descComp = DESC_COMP_POR_OMISSAO;
        custoHora = CUSTO_POR_OMISSAO;
    }
    
    /**
     * Devolve o ID da categoria
     * Usado para confirmar os serviços de determinada Categoria
     * @return ID da categoria
     */
    public String getCatID(){
        return catID;
    }
    
    /**
     * Devolve o ID único do serviço
     * @return ID único do serviço
     */
    public String getServID(){
        return servID;
    }
    /**
     * Devolve a descrição breve do serviço
     * @return descrição breve do serviço
     */
    public String getDescBreve(){
        return descBreve;
    }
    /**
     * Devolve a descrição completa do serviço
     * @return descrição completa do serviço
     */
    public String getDescComp(){
        return descComp;
    }
    /**
     * Devolve o custo por hora do serviço
     * @return custo por hora do serviço
     */
    public double getCustoHora(){
        return custoHora;
    }
    /**
     * Modifica o ID único do serviço
     * @param servID ID único do serviço
     */
    public void setServID(String servID){
        if(servID == null || servID.isEmpty())
            throw new IllegalArgumentException("O argumento 'ID de serviço' não deve estar vazio ou ser nulo.");
        this.servID = servID;
    }
    /**
     * Modifica a descrição breve do serviço
     * @param descBreve descrição breve do serviço
     */
    public void setDescBreve(String descBreve){
        if(descBreve == null || descBreve.isEmpty())
            throw new IllegalArgumentException("O argumento 'descrição breve' não deve estar vazio ou ser nulo.");
        this.descBreve = descBreve;
    }
    /**
     * Modifica a descrição completa do serviço
     * @param descComp descrição completa do serviço
     */
    public void setDescComp(String descComp){
        if(descComp == null || descComp.isEmpty())
            throw new IllegalArgumentException("O argumento 'descrição completa' não deve estar vazio ou ser nulo.");
        this.descComp = descComp;
    }
    /**
     * Modifica o custo p/hora do serviço
     * @param custoHora custo p/hora do serviço
     */
    public void setCustoHora(double custoHora){
        if(custoHora == 0)
            throw new IllegalArgumentException("O argumento 'custo por hora' não deve ser nulo.");
        this.custoHora = custoHora;
    }
    /**
     * Devolve as características do Serviço (descrição breve e o seu custo por hora)
     * @return características do Serviço (descrição breve e o seu custo por hora)
     */
    @Override
    public String toString(){
        return String.format("Serviço: %s\nCusto p/ hora: %.2f", descBreve, custoHora);
    }
    /**
     * Compara dois objectos Servico através do seu ID único
     * Os dois apenas são considerados iguais quando esta característica é igual
     * @param outroObjecto objecto que vai ser comparado com o objecto que chama o método
     * @return true, se as referências dos objectos a ser comparados apontam para o mesmo objecto
     *         false, se o objecto comparado for nulo ou as classes dos dois objectos forem diferentes
     *         true, se o ID dos dois objectos forem iguais
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }
        if (outroObjecto == null || getClass() != outroObjecto.getClass()) {
            return false;
        }
        Servico outroServico = (Servico) outroObjecto;
        
        return this.servID.equalsIgnoreCase(outroServico.servID);
    }
}

package Project1;
/**
 *
 * @author Tiago Ribeiro (1181444)
 * @author Pedro Água (1180809)
 */
public abstract class AtletaNaoPro extends Atleta{
    /**
     * Antiguidade do atleta no clube desportivo ("anos de casa")
     */
    private int antiguidade;
    /**
     * Antiguidade do atleta no clube desportivo por omissão
     */
    private static final int ANTIGUIDADE_POR_OMISSAO = 0;
    /**
     * Contador para consultar o número de instâncias de AtletaNaoPro
     */
    private static int contadorNaoPro = 0;
    
    /**
     * Constrói uma instância de AtletaNaoPro que recebe nome, número de identificação civil, género, idade
     * atividade desportiva, FCR,valor arrecadado em prémios e antiguidade do atleta no clube
     * 
     * @param nome Nome do atleta
     * @param numCC Número de Identificação civil do atleta
     * @param genero Género do atleta
     * @param idade Idade do atleta
     * @param atividade Atividade desportiva do atleta
     * @param FCR Frequência Cardíaca em Repouso do atleta
     * @param valorMensal Valor arrecadado em prémios pelo Atleta
     * @param antiguidade Antiguidade no clube do atleta
     */
    public AtletaNaoPro(String nome, int numCC, String genero, int idade, String atividade, int FCR, double valorMensal, int antiguidade){
        super(nome, numCC, genero, idade, atividade, FCR, valorMensal);
        this.antiguidade = antiguidade;
        contadorNaoPro++;
    }
    /**
     * Constrói uma instância de AtletaNaoPro com valores por omissão
     */
    public AtletaNaoPro(){
        super();
        antiguidade = ANTIGUIDADE_POR_OMISSAO;
        contadorNaoPro++;
    }
    
    /**
     * Devolve a antiguidade do atleta no clube
     * 
     * @return antiguidade do atleta no clube
     */
    public int getAntiguidade(){
        return antiguidade;
    }
    /**
     * Modifica a antiguidade do atleta no clube
     * 
     * @param antiguidade antiguidade do atleta no clube
     */
    public void setAntiguidade (int antiguidade){
        this.antiguidade = antiguidade;
    }
    /**
     * Devolve as características do atleta não profissional, assim como a sua antiguidade no clube
     * 
     * @return características do atleta não profissional, assim como a sua antiguidade no clube
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Não Profissional com %d anos de antiguidade no Clube Desportivo", super.toString(), antiguidade);
    }
    /**
     * Calcula o valor a pagar ao atleta
     * Método abstrato, apenas identificado, a ser implementado pelas subclasses
     * @return valor a pagar ao atleta
     */
    @Override
    public abstract double calcularPagamento();
    /**
     * Calcula o valor da parcela variável do vencimento
     * Método abstrato, apenas identificado, para ser implementado pelas subclasses
     * @return valor da parcela variável de vencimento
     */
    @Override
    public abstract double calcularParcelaVariavel();
    /**
     * Devolve o número de instâncias de AtletaNaoPro
     * 
     * @return número de instâncias de AtletaNaoPro
     */
    public int getContadorNaoPro(){
        return contadorNaoPro;
    }
}

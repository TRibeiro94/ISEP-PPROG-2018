package Project1;
/**
 *
 * @author Tiago Ribeiro (1181444)
 * @author Pedro Água (1180809)
 */
public class AtletaPro extends Atleta{
    /**
     * parcela fixa de vencimento atribuída a atletas profissionais
     */
    private double parcelaFixa;
    
    /**
     * parcela fixa de vencimento atribuída a atletas profissionais por omissão
     */
    private static final double PARCELA_FIXA_POR_OMISSAO = 0;
    
    /**
     * percentagem dos valores em prémios arrecadados (20%)
     */
    private static double valorPercentagem = 0.2;
    /**
     * Contador para consultar o número de instâncias de AtletaPro
     */
    private static int contadorPro = 0;
    
    /**
     * Constrói uma instância de AtletaPro que recebe nome, número de identificação civil, género, idade
     * atividade desportiva, parcela fixa de vencimento, FCR e valor arrecadado em prémios
     * 
     * @param nome Nome do atleta
     * @param numCC Número de Identificação civil do atleta
     * @param genero Género do atleta
     * @param idade Idade do atleta
     * @param atividade Atividade desportiva do atleta
     * @param parcelaFixa parcela fixa de vencimento do atleta
     * @param FCR Frequência Cardíaca em Repouso do atleta
     * @param valorMensal Valor arrecadado em prémios pelo Atleta
     */
    public AtletaPro(String nome, int numCC, String genero, int idade, String atividade, int FCR, double parcelaFixa, double valorMensal){
        super(nome, numCC, genero, idade, atividade, FCR, valorMensal);
        this.parcelaFixa = parcelaFixa;
        setParcelaVariavel(calcularParcelaVariavel());
        contadorPro++;
    }
    
    /**
     * Constrói uma instância de AtletaPro com valores por omissão
     */
    public AtletaPro(){
        super();
        parcelaFixa = PARCELA_FIXA_POR_OMISSAO;
        contadorPro++;
    }
    /**
     * Devolve o valor da parcela fixa de vencimento do atleta
     * 
     * @return valor do vencimento fixo do atleta
     */
    public double getParcelaFixa(){
        return parcelaFixa;
    }
    /**
     * Modifica o valor da parcela fixa de vencimento do atleta
     * 
     * @param parcelaFixa valor do vencimento fixo do atleta
     */
    public void setParcelaFixa(double parcelaFixa){
        this.parcelaFixa = parcelaFixa;
    }
    /**
     * Devolve as características do atleta profissional, assim como o seu vencimento
     * 
     * @return características do atleta profissional, assim como o seu vencimento
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Profissional, que aufere de .2f €", super.toString(), calcularParcelaVariavel());
    }
    /**
     * Calcula o valor a pagar a atleta
     * 
     * @return valor a pagar ao atleta
     */
    @Override
    public double calcularPagamento() {
        return calcularParcelaVariavel() + parcelaFixa; 
    }
    /**
     * Calcula a parcela variável de vencimento do atleta
     * 
     * @return parcela variável de vencimento
     */
    @Override
    public double calcularParcelaVariavel(){
        return getValorMensal()*valorPercentagem;
    }
    /**
     * Devolve o número de instâncias de AtletaPro
     * 
     * @return número de instâncias de AtletaPro
     */
    public int getContadorPro(){
        return contadorPro;
    }
    /**
     * Devolve a percentagem de valores em prémios
     * 
     * @return valor da percentagem de valores em prémios
     */
    public double getValorPercentagem(){
        return valorPercentagem;
    }
    /**
     * Modifica a percentagem
     * 
     * @param valorPercentagem valor da percentagem de valores em prémios
     */
    public void setValorPercentagem(double valorPercentagem){
        this.valorPercentagem = valorPercentagem;
    }
}

package project2;

/**
 *
 * @author Tiago Soares (1181444)
 */
public class AtletaPro extends Atleta implements DescontoIRS {

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
    private static double VALORPERCENTAGEM = 0.2;

    /**
     * Constrói uma instância de AtletaPro que recebe nome, número de
     * identificação civil, género, idade atividade desportiva, parcela fixa de
     * vencimento, FCR e valor arrecadado em prémios
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
    public AtletaPro(String nome, int numCC, String genero, int idade, String atividade, int FCR, int parcelaFixa, double valorMensal) {
        super(nome, numCC, genero, idade, atividade, FCR, valorMensal);
        this.parcelaFixa = parcelaFixa;
    }
    /**
     * Constrói uma instância de AtletaPro que é cópia de uma instância AtletaPro passada por parâmetro
     *
     * @param outroAtletaPro AtletaPro que vai ser 'copiado'
     */
    public AtletaPro(AtletaPro outroAtletaPro) {
        super(outroAtletaPro);
        parcelaFixa = outroAtletaPro.parcelaFixa;
    }

    /**
     * Constrói uma instância de AtletaPro com valores por omissão
     */
    public AtletaPro() {
        super();
        parcelaFixa = PARCELA_FIXA_POR_OMISSAO;
    }

    /**
     * Devolve o valor da parcela fixa de vencimento do atleta
     *
     * @return valor do vencimento fixo do atleta
     */
    public double getParcelaFixa() {
        return parcelaFixa;
    }

    /**
     * Modifica o valor da parcela fixa de vencimento do atleta
     *
     * @param parcelaFixa valor do vencimento fixo do atleta
     */
    public void setParcelaFixa(double parcelaFixa) {
        this.parcelaFixa = parcelaFixa;
    }

    /**
     * Devolve as características do atleta profissional, assim como o seu
     * vencimento
     *
     * @return características do atleta profissional, assim como o seu
     * vencimento
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Profissional",super.toString());
    }

    /**
     * Calcula o valor a pagar a atleta
     *
     * @return valor a pagar ao atleta
     */
    @Override
    public double calcularPagamento() {
        return calcularParcelaVariavel() + parcelaFixa - valorDoDesconto();
    }

    /**
     * Calcula a parcela variável de vencimento do atleta
     *
     * @return parcela variável de vencimento
     */
    public double calcularParcelaVariavel() {
        return getValorMensal() * VALORPERCENTAGEM;
    }

    /**
     * Calcula o valor do doesconto, incidente sobre a parcela fixa, destinado ao IRS
     *
     * @return valor do doesconto destinado ao IRS
     */
    @Override
    public double valorDoDesconto() {
        return parcelaFixa * taxaImutavelIRS;
    }

    /**
     * Devolve a percentagem de valores em prémios
     *
     * @return valor da percentagem de valores em prémios
     */
    public double getValorPercentagem() {
        return VALORPERCENTAGEM;
    }
    /**
     * Modifica o valor da percentagem da aplicar sobre o valor mensal do atleta
     *
     * @param VALORPERCENTAGEM valor da percentagem a aplicar sobre um valor mensal
     */
    public void setValorPercentagem(double VALORPERCENTAGEM) {
        this.VALORPERCENTAGEM = VALORPERCENTAGEM;
    }
}

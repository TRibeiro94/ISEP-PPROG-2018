package project2;

/**
 *
 * @author Tiago Soares (1181444)
 */
public abstract class AtletaNaoPro extends Atleta {

    /**
     * Antiguidade do atleta no clube desportivo ("anos de casa")
     */
    private int antiguidade;
    /**
     * Antiguidade do atleta no clube desportivo por omissão
     */
    private static final int ANTIGUIDADE_POR_OMISSAO = 0;
    /**
     * Antiguidade de 5 anos do Atleta no Clube Desportivo
     */
    private static final int ANTIGUIDADE_CINCO = 5;
    /**
     * Antiguidade de 10 anos do Atleta no Clube Desportivo
     */
    private static final int ANTIGUIDADE_DEZ = 10;
    /**
     * Antiguidade de 20 anos do Atleta no Clube Desportivo
     */
    private static final int ANTIGUIDADE_VINTE = 20;

    /**
     * Constrói uma instância de AtletaNaoPro que recebe nome, número de
     * identificação civil, género, idade atividade desportiva, FCR,valor
     * arrecadado em prémios e antiguidade do atleta no clube
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
    public AtletaNaoPro(String nome, int numCC, String genero, int idade, String atividade, int FCR, double valorMensal, int antiguidade) {
        super(nome, numCC, genero, idade, atividade, FCR, valorMensal);
        this.antiguidade = antiguidade;
    }
    /**
     * Constrói uma instância de AtletaNaoPro que é cópia de uma instância AtletaNaoPro passada por parâmetro
     *
     * @param outroAtletaNaoPro AtletaNaoPro que vai ser 'copiado'
     */
    public AtletaNaoPro(AtletaNaoPro outroAtletaNaoPro) {
        super(outroAtletaNaoPro);
        antiguidade = outroAtletaNaoPro.antiguidade;
    }

    /**
     * Constrói uma instância de AtletaNaoPro com valores por omissão
     */
    public AtletaNaoPro() {
        super();
        antiguidade = ANTIGUIDADE_POR_OMISSAO;
    }

    /**
     * Devolve a antiguidade do atleta no clube
     *
     * @return antiguidade do atleta no clube
     */
    public int getAntiguidade() {
        return antiguidade;
    }

    /**
     * Modifica a antiguidade do atleta no clube
     *
     * @param antiguidade antiguidade do atleta no clube
     */
    public void setAntiguidade(int antiguidade) {
        this.antiguidade = antiguidade;
    }

    /**
     * Devolve as características do atleta não profissional, assim como a sua
     * antiguidade no clube
     *
     * @return características do atleta não profissional, assim como a sua
     * antiguidade no clube
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Não Profissional com %d anos de casa.",super.toString(), antiguidade);
    }

    /**
     * Calcula o valor a pagar ao atleta Método abstrato, apenas identificado, a
     * ser implementado pelas subclasses
     *
     * @return valor a pagar ao atleta
     */
    @Override
    public abstract double calcularPagamento();

    /**
     * Calcula a parcela variável de vencimento do atleta
     *
     * @return parcela variável de vencimento
     */
    public double calcularParcelaVariavel() {
        if (getAntiguidade() >= ANTIGUIDADE_CINCO && getAntiguidade() <= ANTIGUIDADE_DEZ) {
            return getValorMensal() * 0.02;
        } else if (getAntiguidade() > ANTIGUIDADE_DEZ && getAntiguidade() <= ANTIGUIDADE_VINTE) {
            return getValorMensal() * 0.08;
        } else if (getAntiguidade() > ANTIGUIDADE_VINTE) {
            return getValorMensal() * 0.2;
        } else {
            System.out.println("Antiguidade não está nos devidos parâmetros.");
        }
        return 0;
    }

}

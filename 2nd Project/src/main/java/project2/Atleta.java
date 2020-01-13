package project2;

/**
 * Representa um Atleta de um Clube Desportivo
 *
 * @author Pedro Água (1180809)
 */
public abstract class Atleta implements Comparable<Atleta> {

    /**
     * Nome do Atleta
     */
    private String nome;
    /**
     * Número de Identificação Civil do Atleta
     */
    private int numCC;
    /**
     * Género do Atleta
     */
    private String genero;
    /**
     * Idade do Atleta
     */
    private int idade;
    /**
     * Atividade desportiva do Atleta
     */
    private String atividade;
    /**
     * Frequência Cardíaca em Repouso do Atleta
     */
    private int FCR;
    /**
     * Valor arrecadado em prémios pelo Atleta
     */
    private double valorMensal;

    /**
     * Nome do Atleta por omissão
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    /**
     * Número de Identificação Civil do Atleta por omissão
     */
    private static final int NUMCC_POR_OMISSAO = 0;
    /**
     * Género do Atleta por omissão
     */
    private static final String GENERO_POR_OMISSAO = "sem género";
    /**
     * Idade do Atleta por omissão
     */
    private static final int IDADE_POR_OMISSAO = 0;
    /**
     * Atividade desportiva do Atleta por omissão
     */
    private static final String ATIVIDADE_POR_OMISSAO = "sem atividade definida";
    /**
     * Frequência Cardíaca em Repouso do Atleta por omissão
     */
    private static final int FCR_POR_OMISSAO = 1;
    /**
     * Valor arrecadado em prémios pelo Atleta por omissão
     */
    private static final int VALOR_MENSAL_POR_OMISSAO = 0;

    /**
     * Intensidade de Treino (Objectivo: queima de gordura)
     */
    private static final double ITQUEIMA = 0.6;
    /**
     * Intensidade de Treino (Objectivo: trabalhar capacidade
     * cardiorespiratória)
     */
    private static final double ITCARDIO = 0.75;
    /**
     * Atividade associada a um atleta: caminhada
     */
    private static final String CAMINHADA = "caminhada";
    /**
     * Atividade associada a um atleta: corrida
     */
    private static final String CORRIDA = "corrida";
    /**
     * Atividade associada a um atleta: natação
     */
    private static final String NATACAO = "natação";
    /**
     * Atividade associada a um atleta: ciclismo
     */
    private static final String CICLISMO = "ciclismo";
    /**
     * género masculino
     */
    private static final String MASCULINO = "masculino";
    /**
     * género feminino
     */
    private static final String FEMININO = "feminino";
    /**
     * Constrói uma instância de Atleta que recebe nome, número de identificação
     * civil, género, idade atividade desportiva, FCR e valor arrecadado em
     * prémios
     *
     * @param nome Nome do atleta
     * @param numCC Número de Identificação civil do atleta
     * @param genero Género do atleta
     * @param idade Idade do atleta
     * @param atividade Atividade desportiva do atleta
     * @param FCR Frequência Cardíaca em Repouso do atleta
     * @param valorMensal Valor arrecadado em prémios pelo Atleta
     */
    public Atleta(String nome, int numCC, String genero, int idade, String atividade, int FCR, double valorMensal) {
        this.nome = nome;
        this.numCC = numCC;
        this.genero = genero;
        this.idade = idade;
        this.atividade = atividade;
        this.FCR = FCR;
        this.valorMensal = valorMensal;
    }
    /**
     * Constrói uma instância de Atleta que é cópia de uma instância Atleta passada por parâmetro
     *
     * @param outroAtleta Atleta que vai ser 'copiado'
     */
    public Atleta(Atleta outroAtleta) {
      nome = outroAtleta.nome;
      numCC = outroAtleta.numCC;
      genero = outroAtleta.genero;
      idade = outroAtleta.idade;
      atividade = outroAtleta.atividade;
      FCR = outroAtleta.FCR;
      valorMensal = outroAtleta.valorMensal;
    }

    /**
     * Constrói uma instância de Atleta com valores por omissão
     */
    public Atleta() {
        nome = NOME_POR_OMISSAO;
        numCC = NUMCC_POR_OMISSAO;
        genero = GENERO_POR_OMISSAO;
        idade = IDADE_POR_OMISSAO;
        atividade = ATIVIDADE_POR_OMISSAO;
        FCR = FCR_POR_OMISSAO;
        valorMensal = VALOR_MENSAL_POR_OMISSAO;
    }

    /**
     * Devolve o nome do atleta
     *
     * @return nome do atleta
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o número de identificação civil do atleta
     *
     * @return número de identificação civil do atleta
     */
    public int getNumCC() {
        return numCC;
    }

    /**
     * Devolve o género do atleta
     *
     * @return género do atleta
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Devolve a idade atleta
     *
     * @return idade do atleta
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Devolve a atividade desportiva do atleta
     *
     * @return atividade do atleta
     */
    public String getAtividade() {
        return atividade;
    }

    /**
     * Devolve a frequência cardíaca em repouso do atleta
     *
     * @return FCR do atleta
     */
    public int getFCR() {
        return FCR;
    }

    /**
     * Devolve o valor em prémios arrecadados pelo atleta
     *
     * @return valor em prémios do atleta
     */
    public double getValorMensal() {
        return valorMensal;
    }

    /**
     * Modifica o nome do atleta
     *
     * @param nome nome do atleta
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o número de identificação civil do atleta
     *
     * @param numCC número de identificação civil do atleta
     */
    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    /**
     * Modifica o género do atleta
     *
     * @param genero género do atleta
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Modifica a idade do atleta
     *
     * @param idade idade do atleta
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Modifica a atividade desportiva do atleta
     *
     * @param atividade atividade desportiva do atleta
     */
    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    /**
     * Modifica a frequência cardíaca em repouso do atleta
     *
     * @param FCR frequência cardíaca em repouso
     */
    public void setFCR(int FCR) {
        this.FCR = FCR;
    }

    /**
     * Modifica o valor mensal em prémios arrecadado pelo atleta
     *
     * @param valorMensal valor arrecadado em prémios
     */
    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    /**
     * Devolve as características do atleta
     *
     * @return características do atleta
     */
    @Override
    public String toString() {
        return String.format("Atleta: %s ; Número Identificação: %d ; Sexo: %s ; "
                + "Idade: %d ; Atividade Desportiva: %s", nome, numCC, genero, idade, atividade);
    }

    /**
     * Calcula o valor a pagar ao atleta Método abstrato, apenas identificado, a
     * ser implementado pelas subclasses
     *
     * @return valor a pagar ao atleta
     */
    public abstract double calcularPagamento();

    /**
     * Calcula a frequência cardíaca máxima do atleta
     *
     * @return valor da frequência cardíaca máxima
     */
     public double calcularFCM() {
         if (atividade.equalsIgnoreCase(CAMINHADA) || atividade.equalsIgnoreCase(CORRIDA)) {
             return 208.75 - (0.73 * (idade));
         } else if (atividade.equalsIgnoreCase(CICLISMO) && genero.equalsIgnoreCase(MASCULINO)) {
             return 189 - (0.56 * (idade));
         } else if (atividade.equalsIgnoreCase(CICLISMO) && genero.equalsIgnoreCase(FEMININO)) {
             return 202 - (0.72 * (idade));
         } else if (atividade.equalsIgnoreCase(NATACAO)) {
             return 204 - (1.7 * (idade));
         }
         return 0;
     }

    /**
     * Calcula a frequência cardíaca de trabalho do atleta (Objectivo: queima de
     * gordura)
     *
     * @return valor da FCT caso o objectivo seja queima de gordura
     */
    public double calcularFCTQueima() {
        return FCR + (ITQUEIMA * (calcularFCM() - FCR));
    }

    /**
     * Calcula a frequência cardíaca de trabalho do atleta (Objectivo: trabalhar
     * capacidade cardiorespiratória)
     *
     * @return valor da FCT caso o objectivo seja trabalhar capacidade
     * cardiorespiratória
     */
    public double calcularFCTcapCardio() {
        return FCR + (ITCARDIO * (calcularFCM() - FCR));
    }

    /**
     * Devolve o valor da percentagem de intensidade do treino para queima de
     * gordura
     *
     * @return percentagem de intensidade do treino para queima de gordura
     */
    public double getITQUEIMA() {
        return ITQUEIMA;
    }

    /**
     * Devolve o valor da percentagem de intensidade do treino para trabalhar
     * capacidade cardiorespiratória
     *
     * @return percentagem de intensidade do treino para trabalhar capacidade
     * cardiorespiratória
     */
    public double getITCARDIO() {
        return ITCARDIO;
    }

    /**
     * Ordena alfabeticamente os atletas, comparando os seus nomes.
     *
     * @param outroAtleta Segundo atleta ao qual o primeir vai ser comparado.
     * @return int positivo caso um seja maior, 0 se for igual ou negativo se
     * for menor.
     */
    @Override
    public int compareTo(Atleta outroAtleta) {
      return this.nome.compareToIgnoreCase(outroAtleta.nome);
     }

}

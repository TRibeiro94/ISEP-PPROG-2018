package Project1;
/**
 * Representa um Atleta de um Clube Desportivo
 * 
 * @author Tiago Soares (1181444)
 * @author Pedro Água (1180809)
 */
public abstract class Atleta {
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
    * valor de vencimento variavél 
    */
    private double parcelaVariavel;
    
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
    * valor de vencimento variavél por omissão
    */
    private static final double PARCELA_VARIAVEL_POR_OMISSAO = 0;
    
    /**
     * Intensidade de Treino (Objectivo: queima de gordura)
     */
    private static double ITqueima = 0.6;
    /**
     * Intensidade de Treino (Objectivo: trabalhar capacidade cardiorespiratória)
     */
    private static double ITcardio = 0.75;
    /**
     * Contador para consultar o número de instâncias de Atleta
     */
    private static int contador = 0;
    /**
     * Constrói uma instância de Atleta que recebe nome, número de identificação civil, género, idade
     * atividade desportiva, FCR e valor arrecadado em prémios
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
        parcelaVariavel = PARCELA_VARIAVEL_POR_OMISSAO;
        contador++;
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
        parcelaVariavel = PARCELA_VARIAVEL_POR_OMISSAO;
        contador++;
    }
    
    /**
     * Devolve o nome do atleta
     * @return nome do atleta
     */
    public String getNome() {
        return nome;
    }
    /**
     * Devolve o número de identificação civil do atleta
     * @return número de identificação civil do atleta
     */
    public long getNumCC() {
        return numCC;
    }
    /**
     * Devolve o género do atleta
     * @return género do atleta
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Devolve a idade atleta
     * @return idade do atleta
     */
    public int getIdade() {
        return idade;
    }
    /**
     * Devolve a atividade desportiva do atleta
     * @return atividade do atleta
     */
    public String getAtividade() {
        return atividade;
    }
    /**
     * Devolve a frequência cardíaca em repouso do atleta
     * @return FCR do atleta
     */
    public int getFCR(){
        return FCR;
    }
    /**
     * Devolve o valor em prémios arrecadados pelo atleta
     * @return valor em prémios do atleta
     */
    public double getValorMensal(){
        return valorMensal;
    }
    /**
     * Devolve a parcela de vencimento variável atleta
     * @return parcela de vencimento variável atleta
     */
    public double getParcelaVariavel(){
        return parcelaVariavel;
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
    public void setFCR (int FCR){
        this.FCR = FCR;
    }
    /**
     * Modifica o valor mensal em prémios arrecadado pelo atleta
     * 
     * @param valorMensal valor arrecadado em prémios
     */
    public void setValorMensal(double valorMensal){
        this.valorMensal = valorMensal;
    }
    /**
     * Modifica a parcela variável de vencimento
     * 
     * @param parcelaVariavel parcela variável de vencimento
     */
    public void setParcelaVariavel(double parcelaVariavel){            
        this.parcelaVariavel = parcelaVariavel;
    }
    /**
     * Devolve as características do atleta
     * 
     * @return características do atleta
     */
    @Override
    public String toString() {
        return String.format("Atleta: %s ; Número Identificação: %L ; Sexo: %s ; "
                + "Idade: %d ; Atividade Desportiva: %s", nome, numCC, genero, idade, atividade);
    }
    /**
     * Calcula o valor a pagar ao atleta
     * Método abstrato, apenas identificado, a ser implementado pelas subclasses
     * @return valor a pagar ao atleta
     */
    public abstract double calcularPagamento();
    /**
     * Calcula o valor da parcela variável do vencimento
     * Método abstrato, apenas identificado, para ser implementado pelas subclasses
     * @return valor da parcela variável de vencimento
     */
    public abstract double calcularParcelaVariavel();
    /**
     * Calcula a frequência cardíaca máxima do atleta
     * 
     * @return valor da frequência cardíaca máxima
     */
    public double calcularFCM() {
        if (atividade.equalsIgnoreCase("caminhada") || atividade.equalsIgnoreCase("corrida")) {
            return 208.75 - (0.73 * (idade));
        } else if (atividade.equalsIgnoreCase("ciclismo") && genero.equalsIgnoreCase("masculino")) {
            return 189 - (0.56 * (idade));
        } else if (atividade.equalsIgnoreCase("ciclismo") && genero.equalsIgnoreCase("feminino")) {
            return 202 - (0.72 * (idade));
        } else if (atividade.equalsIgnoreCase("natação")) {
            return 204 - (1.7 * (idade));
        }
        return -0;
    }
    /**
     * Calcula a frequência cardíaca de trabalho do atleta (Objectivo: queima de gordura)
     * 
     * @return valor da FCT caso o objectivo seja queima de gordura
     */
    public double calcularFCTQueima(){
        return FCR +(ITqueima*(calcularFCM() - FCR));
    }
    /**
     * Calcula a frequência cardíaca de trabalho do atleta (Objectivo: trabalhar capacidade cardiorespiratória)
     * 
     * @return valor da FCT caso o objectivo seja trabalhar capacidade cardiorespiratória
     */
    public double calcularFCTcapCardio(){
        return FCR +(ITcardio * (calcularFCM() - FCR));
    }
    /**
     * Devolve o valor da percentagem de intensidade do treino para queima de gordura
     * 
     * @return percentagem de intensidade do treino para queima de gordura
     */
    public double getITqueima(){
        return ITqueima;
    }
    /**
     * Devolve o valor da percentagem de intensidade do treino para trabalhar capacidade cardiorespiratória
     * 
     * @return percentagem de intensidade do treino para trabalhar capacidade cardiorespiratória
     */
    public double getITcardio(){
        return ITcardio;
    }
    /**
     * Devolve o número de instâncias de Atleta
     * 
     * @return número de instâncias de Atleta 
     */
    public int getContador(){
        return contador;
    }
    /**
     * Modifica a percentagem associada à intensidade do treino para queima de gordura
     * 
     * @param ITqueima percentagem de intensidade do treino(Objectivo: queima de gordura)
     */
    public void setITqueima(double ITqueima){
        this.ITqueima = ITqueima;
    }
    /**
     * Modifica a percentagem associada à intensidade do treino para trabalhar capacidade cardiorespiratória
     * 
     * @param ITcardio percentagem de intensidade do treino(Objectivo: trabalhar capacidade cardiorespiratória)
     */
    public void setITcardio(double ITcardio){
        this.ITcardio = ITcardio;
    }
}

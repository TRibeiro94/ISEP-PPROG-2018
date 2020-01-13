package model;

import Utils.Data;
import Utils.Tempo;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class PedidoPrestacaoServico implements Serializable{
    
    /**
     * número atribuido ao pedido ("senha")
     */
    private int numeroAtribuido;
    /**
     * serviço solicitado pelo pedido
     */
    private Servico servico;
    /**
     * Data solicitada para execução do serviço
     */
    private Data data;
    /**
     * hora de início do serviço
     */
    private Tempo horaInicio;
    /**
     * hora de fim do serviço
     */
    private Tempo horaFim;
    /**
     * descrição da tarefa a ser executada
     */
    private String descTarefa;
    /**
     * Valor(€) a pagar no total pelo pedido efetuado
     */
    private double valorTotal;
    /**
     * endereço postal onde o pedido deve ser executado
     */
    private EnderecoPostal endPostal;
    
    /**
     * serviço solicitado pelo pedido por omissão
     */
    private static final Servico SERVICO_POR_OMISSAO = new Servico();
    /**
     * Data solicitada para execução do serviço por omissão
     */
    private static final Data DATA_POR_OMISSAO = new Data();
    /**
     * hora de início do serviço por omissão
     */
    private static final Tempo HORA_INICIO_POR_OMISSAO = new Tempo();
    /**
     * hora de fim do serviço por omissão
     */
    private static final Tempo HORA_FIM_POR_OMISSAO = new Tempo();
    /**
     * descrição da tarefa a ser executada por omissão
     */
    private static final String DESC_TAREFA_POR_OMISSAO = "sem descrição disponível";
    /**
     * Valor(€) a pagar no total pelo pedido efetuado por omissão
     */
    private static final double VALOR_TOTAL_POR_OMISSAO = 0;
    /**
     * endereço postal onde o pedido deve ser executado por omissão
     */
    private static final EnderecoPostal ENDERECO_POR_OMISSAO = new EnderecoPostal();
    
    /**
     * número atribuido ao pedido ("senha")
     */
    private static int numeroSequencial = 0;
    
    /**
     * Constrói uma instância de PedidoPrestacaoServico que recebe o serviço, a data, a hora de início e de fim, descrição da tarefa e número atribuido
     * @param servico Serviço solicitado pelo pedido
     * @param data Data solicitada para execução do serviço
     * @param horaInicio hora de início do serviço
     * @param horaFim hora de fim do serviço
     * @param descTarefa descrição da tarefa a ser executada
     */
    public PedidoPrestacaoServico(Servico servico, Data data, Tempo horaInicio, Tempo horaFim, String descTarefa, double valorTotal, EnderecoPostal endPostal){
        numeroSequencial++;
        this.servico = new Servico(servico);
        this.data = new Data(data);
        this.horaInicio = new Tempo(horaInicio);
        this.horaFim = new Tempo(horaFim);
        this.descTarefa = descTarefa;
        this.valorTotal = valorTotal;
        numeroAtribuido = numeroSequencial;
        this.endPostal = new EnderecoPostal(endPostal);
    }
    
    /**
     * Constrói uma instância de PedidoPrestacaoServico que é cópia de uma instância de pedido que é passada por parâmetro
     * @param pedidoPrestacaoServico instância PedidoPrestacaoServico que vai ser 'copiada'
     */
    public PedidoPrestacaoServico(PedidoPrestacaoServico pedidoPrestacaoServico){
        this.servico = pedidoPrestacaoServico.servico;
        this.data = pedidoPrestacaoServico.data;
        this.horaInicio = pedidoPrestacaoServico.horaInicio;
        this.horaFim = pedidoPrestacaoServico.horaFim;
        this.descTarefa = pedidoPrestacaoServico.descTarefa;
        this.valorTotal = pedidoPrestacaoServico.valorTotal;
        this.endPostal = pedidoPrestacaoServico.endPostal;
    }
    /**
     * Constrói uma instância de PedidoPrestacaoServico com os valores por omissão
     */
    public PedidoPrestacaoServico(){
        numeroSequencial++;
        servico = SERVICO_POR_OMISSAO;
        data = DATA_POR_OMISSAO;
        horaInicio = HORA_INICIO_POR_OMISSAO;
        horaFim = HORA_FIM_POR_OMISSAO;
        descTarefa = DESC_TAREFA_POR_OMISSAO;
        valorTotal = VALOR_TOTAL_POR_OMISSAO;
        numeroAtribuido = numeroSequencial;
        endPostal = ENDERECO_POR_OMISSAO;
    }
    /**
     * Devolve o Serviço solicitado no Pedido
     * @return Serviço solicitado no Pedido
     */
    public Servico getServico(){
        return servico;
    }
    /**
     * Devolve a Data solicitada para a execução do Serviço
     * @return Data solicitada para a execução do Serviço
     */
    public Data getData(){
        return data;
    }
    /**
     * Devolve a hora de início do serviço
     * @return hora de início do serviço
     */
    public Tempo getHoraInicio(){
        return horaInicio;
    }
    /**
     * Devolve a hora de fim do serviço
     * @return hora de fim do serviço
     */
    public Tempo getHoraFim(){
        return horaFim;
    }
    /**
     * Devolve a descrição da tarefa a ser executada
     * @return descrição da tarefa a ser executada
     */
    public String getDescTarefa(){
        return descTarefa;
    }
    
    /**
     * Devolve o valor(€) a pagar no total pelo pedido efetuado
     * @return valor(€) a pagar no total pelo pedido efetuado
     */
    public double getValorTotal(){
        return valorTotal;
    }
    /**
     * Devolve o endereço postal onde o pedido é para ser executado
     * @return endereço postal onde o pedido é para ser executado
     */
    public EnderecoPostal getEndereco(){
        return endPostal;
    }
    
    /**
     * Devolve o número sequencial atribuído
     * @return 
     */
    public int getNumeroAtribuido(){
        return numeroAtribuido;
    }
    /**
     * Devolve a Data solicitada para a execução do serviço no formato (DD/MM/AA)
     * @return Data solicitada para a execução do serviço no formato (DD/MM/AA)
     */
    public String getStringData(){
        return data.toAnoMesDiaString();
    }
    /**
     * Modifica o Serviço solicitado
     * @param servico Serviço solicitado
     */
    public void setServico(Servico servico){
        if(servico == null)
            throw new IllegalArgumentException("O argumento 'serviço' não deve ser nulo.");
        this.servico = new Servico(servico);
    }
    /**
     * Modifica a Data solicitada para execução do serviço
     * @param data Data solicitada para execução do serviço
     */
    public void setData(Data data){
        if(data == null)
            throw new IllegalArgumentException("O argumento 'data' não deve ser nulo.");
        this.data.setData(data.getAno(), data.getMes(), data.getDia());
    }
    /**
     * Modifica a Data solicitada para execução do serviço
     * @param ano ano da data
     * @param mes mes do ano
     * @param dia dia do mes
     */
    public void setData(int ano, int mes, int dia){
        this.data.setData(ano,mes,dia);
    }
    /**
     * Modifica a hora de inicio do serviço
     * @param horaInicio hora de inicio do serviço
     */
    public void setHoraInicio(Tempo horaInicio){
        this.horaInicio.setTempo(horaInicio.getHoras());
    }
    /**
     * Modifica a hora de fim do serviço
     * @param horaFim hora de fim do serviço
     */
    public void setHoraFim(Tempo horaFim){
        this.horaFim.setTempo(horaFim.getHoras());
    }
    /**
     * Modifica a descrição da tarefa a ser executada
     * @param descTarefa descrição da tarefa a ser executada
     */
    public void setDescricaoTarefa(String descTarefa){
        if(descTarefa == null || descTarefa.isEmpty())
            throw new IllegalArgumentException("O argumento 'descrição da tarefa' não deve estar vazio ou ser nulo.");
        this.descTarefa = descTarefa;
    }
    
    /**
     * Modifica o número atual do valor sequencial
     * @param numeroSequencial número atual do valor sequencial
     */
    public void setNumeroSequencial(int numeroSequencial){
        this.numeroSequencial = numeroSequencial;
    }
    /**
     * Modifica o endereço postal onde será executado o pedido
     * @param end endereço postal onde será executado o pedido
     */
    public void setEndereco(EnderecoPostal end){
        this.endPostal = end;
    }
    
    /**
     * Permite atualizar o número de pedidos existentes em registo 
     */
    public static void numeroDePedidosEfetuados(){
        numeroSequencial = AplicacaoGPSD.empresa.getListaPedidos().size();
    }
    
    /**
     * Compara dois pedidos de prestação de serviço através do número atribuído, serviço solicitado e endereço
     * sendo os objectos considerados iguais apenas quando estas 3 características forem iguais
     * @param obj objecto que vai ser comparado com o objecto que chama o método
     * @return true, se as referências dos objectos a ser comparados apontam para o mesmo objecto
     *         false, se o objecto comparado for nulo ou as classes dos dois objectos forem diferentes
     *         true, se o numeroAtribuido, servico e endPostal forem iguais
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        PedidoPrestacaoServico other = (PedidoPrestacaoServico) obj;
        if (this.numeroAtribuido != other.numeroAtribuido) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.endPostal, other.endPostal)) {
            return false;
        }
        return true;
    }
    
    /**
     * Devolve as características do pedido (nº do pedido, serviço solicitado, descrição da tarefa e valor a pagar)
     * @return características do pedido (nº do pedido, serviço solicitado, descrição da tarefa e valor a pagar)
     */
    @Override
    public String toString(){
        return String.format("\nPedido nº: %d\nServiço: %s \nLocal a realizar: %s\nTarefa: %s \nValor a pagar : %.2f€", numeroAtribuido, this.getServico().toString(), this.getEndereco().toString(), descTarefa, valorTotal);
    }
}

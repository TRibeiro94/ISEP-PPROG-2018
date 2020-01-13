package model;

import Utils.Data;
import Utils.Tempo;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Disponibilidade {
    
    /**
     * Data de inicio de disponibilidade do Prestador de Serviço
     */
    private Data dataInicio;
    /**
     * Data de fim de disponibilidade do Prestador de Serviço
     */
    private Data dataFim;
    /**
     * Hora de inicio de disponibilidade do Prestador de Serviço
     */
    private Tempo horaInicio;
    /**
     * Hora de fim de disponibilidade do Prestador de Serviço
     */
    private Tempo horaFim;
    /**
     * Data de inicio de disponibilidade do Prestador de Serviço por omissão
     */
    private static final Data DATA_INICIO_POR_OMISSAO = new Data();
    /**
     * Data de fim de disponibilidade do Prestador de Serviço por omissão
     */
    private static final Data DATA_FIM_POR_OMISSAO = new Data();
    /**
     * Hora de inicio de disponibilidade do Prestador de Serviço por omissão
     */
    private static final Tempo TEMPO_INICIO_POR_OMISSAO = new Tempo();
    /**
     * Hora de fim de disponibilidade do Prestador de Serviço por omissão
     */
    private static final Tempo TEMPO_FIM_POR_OMISSAO = new Tempo();
    
    /**
     * Constrói uma instância de Disponibilidade que recebe ano, mes, dia de inicio e de fim, hora inicio e hora de fim
     * @param anoInicio ano de inicio de disponibilidade
     * @param mesInicio mes de ano de inicio de disponibilidade
     * @param diaInicio dia do mes de inicio de disponibilidade
     * @param anoFim ano de fim de disponibilidade
     * @param mesFim mes de ano de fim de disponibilidade
     * @param diaFim dia do mes de fim de disponibilidade
     * @param horaInicio hora de inicio de disponibilidade
     * @param horaFim hora de fim de disponibilidade
     */
    public Disponibilidade(int anoInicio, int mesInicio, int diaInicio, int anoFim, int mesFim, int diaFim, int horaInicio, int horaFim){
        this.dataInicio = new Data(anoInicio, mesInicio, diaInicio);
        this.dataFim = new Data(anoFim, mesFim, diaFim);
        this.horaInicio = new Tempo(horaInicio);
        this.horaFim = new Tempo(horaFim);
    }
    /**
     * Constrói uma instância de Disponibilidade que recebe Data de inicio, de fim, hora de inicio e fim
     * @param dataInicio ano/mes/dia de inicio de disponibilidade
     * @param dataFim ano/mes/dia de fim de disponibilidade
     * @param horaInicio hora de inicio de disponibilidade
     * @param horaFim hora de fim de disponibilidade
     */
    public Disponibilidade(Data dataInicio, Data dataFim, Tempo horaInicio, Tempo horaFim){
        this.dataInicio = new Data(dataInicio);
        this.dataFim = new Data(dataFim);
        this.horaInicio = new Tempo(horaInicio);
        this.horaFim = new Tempo(horaFim);
    }
    /**
     * Constrói uma instância de Disponibilidade que é 'cópia' da instância Disponibilidade que é passada por parâmetro
     * @param outraDisponibilidade Disponibilidade que vai ser 'copiada'
     */
    public Disponibilidade(Disponibilidade outraDisponibilidade){
        this.dataInicio = outraDisponibilidade.dataInicio;
        this.dataFim = outraDisponibilidade.dataFim;
        this.horaInicio = outraDisponibilidade.horaInicio;
        this.horaFim = outraDisponibilidade.horaFim;
    }
    /**
     * Constrói uma instância de Disponibilidade com os valores por omissão
     */
    public Disponibilidade(){
        dataInicio = DATA_INICIO_POR_OMISSAO;
        dataFim = DATA_FIM_POR_OMISSAO;
        horaInicio = TEMPO_INICIO_POR_OMISSAO;
        horaFim = TEMPO_FIM_POR_OMISSAO;
    }
    /**
     * Devolve a Data de inicio de disponibilidade 
     * @return Data de inicio de disponibilidade 
     */
    public Data getDataInicio(){
        return new Data(dataInicio);
    }
    /**
     * Devolve a Data de fim de disponibilidade
     * @return Data de fim de disponibilidade
     */
    public Data getDataFim(){
        return new Data(dataFim);
    }
    /**
     * Devolve a hora de inicio de disponibilidade
     * @return hora de inicio de disponibilidade
     */
    public Tempo getHoraInicio(){
        return new Tempo(horaInicio);
    }
    /**
     * Devolve a hora de fim de disponibilidade
     * @return hora de fim de disponibilidade
     */
    public Tempo getHoraFim(){
        return new Tempo(horaFim);
    }
    /**
     * Modifica a data de inicio de disponibilidade
     * @param dataInicio data de inicio de disponibilidade
     */
    public void setDataInicio(Data dataInicio){
        this.dataInicio.setData(dataInicio.getAno(), dataInicio.getMes(), dataInicio.getDia());
    }
    /**
     * Modifica a data de inicio de disponibilidade
     * @param ano ano de inicio de disponibilidade
     * @param mes mes do ano de inicio de disponibilidade
     * @param dia dia do mes de inicio de disponibilidade
     */
    public void setDataInicio(int ano, int mes, int dia) {
        this.dataInicio.setData(ano, mes, dia);
    }
    /**
     * Modifica a data de fim de disponibilidade
     * @param dataFim data de fim de disponibilidade
     */
    public void setDataFim(Data dataFim){
        this.dataFim.setData(dataFim.getAno(), dataFim.getMes(), dataFim.getDia());
    }
    /**
     * Modifica a data de fim de disponibilidade
     * @param ano ano de fim de disponibilidade
     * @param mes mes do ano de fim de disponibilidade
     * @param dia dia do mes de fim de disponibilidade
     */
    public void setDataFim(int ano, int mes, int dia){
        this.dataFim.setData(ano, mes, dia);
    }
    /**
     * Modifica a hora de inicio de disponibilidade
     * @param horaInicio hora de inicio de disponibilidade
     */
    public void setHoraInicio(Tempo horaInicio){
        this.horaInicio.setTempo(horaInicio.getHoras());
    }
    /**
     * Modifica a hora de inicio de disponibilidade
     * @param horaInicio hora de inicio de disponibilidade
     */
    public void setHoraInicio(int horaInicio){
        this.horaInicio.setTempo(horaInicio);
    }
    /**
     * Modifica a hora de fim de disponibilidade
     * @param horaFim hora de fim de disponibilidade
     */
    public void setHoraFim(Tempo horaFim){
        this.horaInicio.setTempo(horaInicio.getHoras());
    }
    /**
     * Modifica a hora de fim de disponibilidade
     * @param horaFim hora de fim de disponibilidade
     */
    public void setHoraFim(int horaFim){
        this.horaInicio.setTempo(horaFim);
    }  
    /**
     * Devolve as características da Disponibilidade
     * Data(inicio até fim) e horario(inicio ate fim)
     * @return características da Disponibilidade
     */
    @Override
    public String toString(){
        return String.format("Disponibilidade de " + dataInicio + " a " + dataFim + ".\nNo horário: "+horaInicio.getHoras()+":00h até "+horaFim.getHoras()+":00h.");
    }
}

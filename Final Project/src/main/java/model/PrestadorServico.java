package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class PrestadorServico extends Utilizador{
    
    /**
     * E-mail Institucional do Prestador de Serviço
     */
    private String emailInstitucional;
    /**
     * Nome abreviado do Prestador de Serviço
     */
    private String nomeAbreviado;
    /**
     * Número Mecanográfico do Prestador de Serviço
     */
    private String mecanografico;
    /**
     * Contentor que irá armazenar as datas de disponibilidade do Prestador de Serviço
     */
    private List<Disponibilidade> listaDisponibilidade = new ArrayList<Disponibilidade>();
    /**
     * Contentor que irá armazenar as áreas geográficas de atuação do prestador
     */
    private List<AreaGeografica> listaAreasGeo = new ArrayList<AreaGeografica>();
    /**
     * E-mail Institucional do Prestador de Serviço por omissão
     */
    private static final String EMAIL_INSTITUCIONAL_OMISSAO = "sem e-mail institucional";
    /**
     * Nome abreviado do Prestador de Serviço por omissão
     */
    private static final String  NOME_ABREVIADO_POR_OMISSAO = "sem nome abreviado";
    /**
     * Número mecanográfico do Prestador de Serviço por omissão
     */
    private static final String  NUM_MECANOGRAFICO_POR_OMISSAO = "0";
    
    /**
     * Constrói uma instância de PrestadorServiço que recebe nome, email, password, email institucional, nome abreviado, número mecanografico
     * @param nome nome do Prestador de Serviço
     * @param email e-mail do Prestador de Serviço
     * @param password password do Prestador de Serviço
     * @param emailInstitucional E-mail Institucional do Prestador de Serviço
     * @param nomeAbreviado Nome abreviado do Prestador de Serviço
     * @param mecanografico Número mecanográfico do Prestador de Serviço
     */
    public PrestadorServico(String nome, String email, String password, String emailInstitucional, String nomeAbreviado, String mecanografico, AreaGeografica area) {
        super(nome, email, password);
        this.emailInstitucional = emailInstitucional;
        this.nomeAbreviado = nomeAbreviado;
        this.mecanografico = mecanografico;
        this.listaDisponibilidade = new ArrayList<Disponibilidade>();
        listaAreasGeo.add(area);
    }
    /**
     * Constrói uma instância de PrestadorServico que é 'cópia' de uma instância PrestadorServico que é passada por parâmetro
     * @param outroPrestador PrestadorServico que vai ser 'copiado'
     */
    public PrestadorServico(PrestadorServico outroPrestador){
        super(outroPrestador);
        this.emailInstitucional = outroPrestador.emailInstitucional;
        this.nomeAbreviado = outroPrestador.nomeAbreviado;
        this.mecanografico = outroPrestador.mecanografico;
        this.listaDisponibilidade = outroPrestador.listaDisponibilidade;
        this.listaAreasGeo = outroPrestador.listaAreasGeo;
    }
    /**
     * Constrói uma instância de PrestadorServico com os valores por omissão
     */
    public PrestadorServico(){
        super();
        emailInstitucional = EMAIL_INSTITUCIONAL_OMISSAO;
        nomeAbreviado = NOME_ABREVIADO_POR_OMISSAO;
        mecanografico = NUM_MECANOGRAFICO_POR_OMISSAO;
        this.listaDisponibilidade = new ArrayList<Disponibilidade>();
        this.listaAreasGeo = new ArrayList<AreaGeografica>();
    }
    /**
     * Devolve o e-mail institucional do Prestador de Serviço
     * @return e-mail institucional do Prestador de Serviço
     */
    public String getInstitucional(){
        return emailInstitucional;
    }
    /**
     * Devolve o nome abreviado do Prestador de Serviço
     * @return nome abreviado do Prestador de Serviço
     */
    public String getNomeAbrev(){
        return emailInstitucional;
    } 
    /**
     * Devolve o número mecanográfico do Prestador de Serviço
     * @return 
     */
    public String getMecanografico(){
        return mecanografico;
    }
    /**
     * Devolve o contentor de disponibilidades do Prestador de Serviço
     * @return 
     */
    public List<Disponibilidade> getListaDisponibilidade(){
        return listaDisponibilidade;
    }
    /**
     * Devolve a lista de áreas geográficas do prestador
     * @return lista de áreas geográficas do prestador
     */
    public List<AreaGeografica> getListaAreas(){
        return listaAreasGeo;
    }       
    /**
     * Modifica o e-mail institucional do Prestador de Serviço
     * @param emailInstitucional e-mail institucional do Prestador de Serviço
     */
    public void setInstitucional(String emailInstitucional){
        if(emailInstitucional == null || emailInstitucional.isEmpty())
            throw new IllegalArgumentException("O argumento 'endereço' não deve estar vazio ou ser nulo.");
        this.emailInstitucional = emailInstitucional;
    }
    /**
     * Modifica o nome abreviado do Prestador de serviço
     * @param nomeAbreviado nome abreviado do Prestador de serviço
     */
    public void setNomeAbrev(String nomeAbreviado){
        if(nomeAbreviado == null || nomeAbreviado.isEmpty())
            throw new IllegalArgumentException("O argumento 'nome abreviado' do prestador não deve estar vazio ou ser nulo.");
        this.nomeAbreviado = nomeAbreviado;
    }
    /**
     * Modifica o número mecanográfico do Prestador de Serviço
     * @param mecanografico número mecanográfico do Prestador de Serviço
     */
    public void setMecanografico(String mecanografico){
        if(mecanografico == null || mecanografico.isEmpty())
            throw new IllegalArgumentException("O argumento 'nº mecanográfico' do prestador não deve estar vazio ou ser nulo.");
        this.mecanografico = mecanografico;
    }
    /**
     * Modifica o contentor de disponibilidades do Prestador de Serviço
     * @param listaDisponibilidade contentor de disponibilidades do Prestador de Serviço
     */
    public void setListaDisponibilidade(List<Disponibilidade> listaDisponibilidade){
        if(listaDisponibilidade == null || listaDisponibilidade.isEmpty())
            throw new IllegalArgumentException("O argumento 'lista de disponibilidades' não deve estar vazio ou ser nulo.");
        this.listaDisponibilidade = listaDisponibilidade;
    }
    /**
     * Modifica a lista de áreas geográficas do prestador
     * @param listaAreas lista de áreas geográficas do prestador
     */
    public void setListaAreas(List<AreaGeografica> listaAreas){
        this.listaAreasGeo = listaAreas;
    }     
    /**
     * Adiciona uma nova disponibilidade do Prestador de Serviço
     * @param novaDisponibilidade nova disponibilidade do Prestador de Serviço
     */
    public void adicionarDisponibilidade(Disponibilidade novaDisponibilidade){
        if(novaDisponibilidade == null)
            throw new IllegalArgumentException("O argumento 'nova disponibilidade' a adicionar não deve ser nulo.");
        listaDisponibilidade.add(novaDisponibilidade);
    }
    
    /**
     * Adiciona uma área geográfica ao registo de áreas de atuação da empresa
     * @param area área geográfica ao registo de áreas de atuação da empresa
     */
    public void adicionarAreaGeografica(AreaGeografica area) {
        if (area == null) {
            throw new IllegalArgumentException("A área geográfica não pode ser nula.");
        }
        listaAreasGeo.add(area);
    }      
    
    /**
     * Imprime todas as Disponibilidades indicadas pelo Prestador de Serviço
     */
    public void listarDisponibilidades(){
        for(Disponibilidade disponibilidade : listaDisponibilidade){
            if(disponibilidade != null){
                System.out.println(disponibilidade.toString());
            }
        }
    }
    
    /**
     * Compara dois prestadores através do e-mail institucional, nome abreviado, nº mecanográfico
     * sendo os objectos considerados iguais apenas quando estas 3 características forem iguais
     * @param outroObjeto objecto que vai ser comparado com o objecto que chama o método
     * @return true, se as referências dos objectos a ser comparados apontam para o mesmo objecto
     *         false, se o objecto comparado for nulo ou as classes dos dois objectos forem diferentes
     *         true, se o emailInstitucional, nomeAbreviado, mecanografico
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        PrestadorServico outroPrestador = (PrestadorServico) outroObjeto;
        return this.emailInstitucional.equalsIgnoreCase(outroPrestador.emailInstitucional)
            && this.nomeAbreviado.equalsIgnoreCase(outroPrestador.nomeAbreviado)
            && this.mecanografico.equalsIgnoreCase(outroPrestador.mecanografico);
    }
    
    /**
     * Devolve as características do prestador de serviço (nome abreviado e o seu nº mecanográfico)
     * @return características do prestador de serviço (nome abreviado e o seu nº mecanográfico)
     */
    @Override
    public String toString(){
        return String.format("Colaborador: %s , Nº Mecanográfico: %s", nomeAbreviado, mecanografico);
    }
}

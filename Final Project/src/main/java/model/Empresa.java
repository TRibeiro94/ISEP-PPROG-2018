package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Empresa implements Serializable{

    /**
     * NIF da Empresa 
     */
    private String NIF;
    /**
     * Designacao da Empresa
     */
    private String designacao;
    /**
     * contentor que irá armazenar os Clientes da Empresa
     */
    private List<Cliente> registoClientes = new ArrayList<Cliente>();
    /**
     * contentor que irá armazenar as Categorias da Empresa
     */
    private List<Categoria> registoCategorias = new ArrayList<Categoria>();
    /**
     * contentor que irá armazenar os Serviços da Empresa
     */
    private List<Servico> registoServicos = new ArrayList<Servico>();
    /**
     * contentor que irá armazenar os Prestadores de Serviço da Empresa
     */
    private List<PrestadorServico> registoPrestadores = new ArrayList<PrestadorServico>();
    /**
     * contentor que irá armazenar os Administrativos da Empresa
     */
    private List<Administrativo> registoAdmins = new ArrayList<Administrativo>();
    /**
     * Contentor que irá armazenar os Pedidos de prestação de serviço
     */
    private List <PedidoPrestacaoServico> registoPedidos = new ArrayList<PedidoPrestacaoServico>();
    /**
     * Contentor que irá armazenar as afetações de pedidos a prestadores de serviço
     */
    private List <AfetacaoPedidoAPrestador> registoAfetacoes = new ArrayList<AfetacaoPedidoAPrestador>();
    /**
     * Contentor que irá armazenar as áreas de atuação da Empresa
     */
    private List<AreaGeografica> registoAreasGeo = new ArrayList<AreaGeografica>();
    /**
     * NIF da Empresa por omissão
     */
    private static final String NIF_STANDARD = "265123345";
    /**
     * Designação da Empresa por omissão
     */
    private static final String DESIGNACAO_STANDARD = "ISEP Serviços Lda.";

    /**
     * Constrói uma instância de Empresa designados à partida
     */
    public Empresa() {
        this.NIF = NIF_STANDARD;
        this.designacao = DESIGNACAO_STANDARD;
    }

    /**
     * Devolve o NIF da Empresa
     *
     * @return NIF da Empresa
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Devolve a designação da Empresa
     *
     * @return designação da Empresa
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Devolve a lista de Clientes da Empresa
     *
     * @return lista de Clientes da Empresa
     */
    public List<Cliente> getListaClientes() {
        return registoClientes;
    }

    /**
     * Devolve a lista de Categorias da Empresa
     *
     * @return lista de Categorias da Empresa
     */
    public List<Categoria> getListaCategorias() {
        return registoCategorias;
    }

    /**
     * Devolve a lista de Serviços da Empresa
     *
     * @return lista de Serviços da Empresa
     */
    public List<Servico> getListaServicos() {
        return registoServicos;
    }

    /**
     * Devolve a lista de Prestadores da Empresa
     *
     * @return lista de Prestadores da Empresa
     */
    public List<PrestadorServico> getListaPrestadores() {
        return registoPrestadores;
    }

    /**
     * Devolve a lista de Administrativos da Empresa
     *
     * @return lista de Administrativos da Empresa
     */
    public List<Administrativo> getListaAdmins() {
        return registoAdmins;
    }
    /**
     * Devolve a lista de pedidos de prestação de serviços
     * @return lista de pedidos de prestação de serviços
     */
    public List<PedidoPrestacaoServico> getListaPedidos(){
        return registoPedidos;
    }
    /**
     * Devolve a lista de afetações de pedidos a prestadores de serviço
     * @return lista de afetações de pedidos a prestadores de serviço
     */
    public List<AfetacaoPedidoAPrestador> getListaAfetacoes(){
        return registoAfetacoes;
    }

    /**
     * Devolve a lista de áreas geográficas de atuação da empresa
     * @return lista de áreas geográficas de atuação da empresa
     */
    public List<AreaGeografica> getListaAreas(){
        return registoAreasGeo;
    }    
    
    /**
     * Modifica a lista de Clientes da Empresa
     *
     * @param registoClientes lista de Clientes da Empresa
     */
    public void setRegistoClientes(List<Cliente> registoClientes) {
        if(registoClientes == null || registoClientes.isEmpty())
            throw new IllegalArgumentException("O argumento 'lista de Categorias' não deve estar vazio ou ser nulo.");
        this.registoClientes = registoClientes;
    }

    /**
     * Modifica a lista de Categorias da Empresa
     *
     * @param registoCategorias lista de Categorias da Empresa
     */
    public void setRegistoCategorias(List<Categoria> registoCategorias) {
        if(registoCategorias == null || registoCategorias.isEmpty())
            throw new IllegalArgumentException("O argumento 'registo de Categorias' não deve estar vazio ou ser nulo.");
        this.registoCategorias = registoCategorias;
    }

    /**
     * Modifica a lista de Serviços da Empresa
     *
     * @param registoServicos lista de Serviços da Empresa
     */
    public void setRegistoServicos(List<Servico> registoServicos) {
        if(registoServicos == null || registoServicos.isEmpty())
            throw new IllegalArgumentException("O argumento 'registo de Serviços' não deve estar vazio ou ser nulo.");
        this.registoServicos = registoServicos;
    }

    /**
     * Modifica a lista de Prestadores da Empresa
     *
     * @param registoPrestadores lista de Prestadores da Empresa
     */
    public void setRegistoPrestadores(List<PrestadorServico> registoPrestadores) {
        if(registoPrestadores == null || registoPrestadores.isEmpty())
            throw new IllegalArgumentException("O argumento 'registo de Prestadores' não deve estar vazio ou ser nulo.");
        this.registoPrestadores = registoPrestadores;
    }

    /**
     * Modifica a lista de Administrativos da Empresa
     *
     * @param registoAdmins lista de administrativos da Empresa
     */
    public void setRegistoAdmins(List<Administrativo> registoAdmins) {
        if(registoAdmins == null || registoAdmins.isEmpty())
            throw new IllegalArgumentException("O argumento 'registo de administrativos' não deve estar vazio ou ser nulo.");
        this.registoAdmins = registoAdmins;
    }
    /**
     * Modifica a lista de pedidos de prestação de serviço
     * @param registoPedidos lista de pedidos de prestação de serviço
     */
    public void setRegistoPedidos(List<PedidoPrestacaoServico> registoPedidos){
        this.registoPedidos = registoPedidos;
    }
    /**
     * Modifica a lista de afetações de pedidos a prestadores
     * @param afetacao 
     */
    public void setRegistoAfetacoes(List<AfetacaoPedidoAPrestador> afetacao){
        if(afetacao == null || afetacao.isEmpty())
            throw new IllegalArgumentException("O argumento 'afetação de pedidos a prestadores' não deve estar vazio ou ser nulo.");
        this.registoAfetacoes = afetacao;
    }
    
    /**
     * Modifica a lista de áreas geográficas de atuação da empresa
     * @param areas lista de áreas geográficas de atuação da empresa
     */
    public void setRegistoAreas(List<AreaGeografica> areas){
        this.registoAreasGeo = areas;
    }    
    
    /**
     * Adiciona o Utilizador passado por parâmetro à lista referente à sua categoria Se Cliente, é adicionado à lista de Clientes Se Prestador, é adicionado à lista de Prestadores Se Administrativo, é adicionado à lista de Administrativos
     *
     * @param uti Utilizador que vai ser adicionado a uma das listas da Empresa
     */
    public void adicionarUtilizador(Utilizador uti) {
        if (uti instanceof Cliente) {
            Cliente novoCliente = (Cliente) uti;
            registoClientes.add(novoCliente);
        } else if (uti instanceof PrestadorServico) {
            PrestadorServico novoPrestador = (PrestadorServico) uti;
            registoPrestadores.add(novoPrestador);
        } else if (uti instanceof Administrativo) {
            Administrativo novoAdmin = (Administrativo) uti;
            registoAdmins.add(novoAdmin);
        }
    }

    /**
     * Adiciona uma Categoria à lista de Categorias da Empresa
     *
     * @param cat Categoria que vai ser adicionada à lista de Categorias da Empresa
     */
    public void adicionarCategoria(Categoria cat) {
        if (cat == null) {
            throw new IllegalArgumentException("A categoria não pode ser nula.");
        }
        registoCategorias.add(cat);
    }

    /**
     * Adiciona um Serviço à lista de Serviços da Empresa
     *
     * @param serv Serviço que vai ser adicionado à lista de Serviços da Empresa
     */
    public void adicionarServico(Servico serv) {
        if (serv == null) {
            throw new IllegalArgumentException("A categoria não pode ser nula.");
        }
        registoServicos.add(serv);
    }
    
    /**
     * Adiciona um Pedido de Prestação de Serviço à lista de pedidos da Empresa
     * @param pedido Pedido de Prestação de Serviço à lista de pedidos da Empresa
     */
    public void adicionarPedido(PedidoPrestacaoServico pedido){
        if (pedido == null){
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        registoPedidos.add(pedido);
    }
    
    /**
     * Adiciona uma área geográfica ao registo de áreas de atuação da empresa
     * @param area área geográfica ao registo de áreas de atuação da empresa
     */
    public void adicionarAreaGeo(AreaGeografica area) {
        if (area == null) {
            throw new IllegalArgumentException("A área geográfica não pode ser nula.");
        }
        registoAreasGeo.add(area);
    }    
    
    /**
     * Imprime os Clientes da Empresa
     */
    public void listarClientes() {
        for (Cliente cli : this.registoClientes) {
            System.out.println(cli.toString());
        }
    }

    /**
     * Imprime as Categorias da Empresa
     */
    public void listarCategorias() {
        int i = 1;
        for (Categoria cat : this.registoCategorias) {
            if(cat != null){
                System.out.println(i + " - " + cat.toString());
                i++;
            }
        }
    }

    /**
     * Imprime todos os Serviços da Empresa
     */
    public void listarServicos() {
        int i = 1;
        for (Servico s : this.registoServicos) {
            if(s != null){
                System.out.println(i + " - " + s.toString());
                i++;
            }
        }
    }

    /**
     * Imprime os serviços apenas de uma dada Categoria cujo ID é passado por parâmetro
     *
     * @param catID ID da Categoria
     */
    public void listarServicosByCatID(String catID) {
        int i = 1;
        for (Servico s : this.registoServicos) {
            if (catID.equals(s.getCatID())) {
                System.out.println(i + " - " + s.toString());
                i++;
            }
        }
    }

    /**
     * Imprime os Prestadores de Serviço da Empresa
     */
    public void listarPrestadores() {
        for (PrestadorServico ps : this.registoPrestadores) {
            if(ps != null){
                System.out.println(ps.toString());
            }
        }
    }

    /**
     * Imprime os Administrativos da Empresa
     */
    public void listarAdmins() {
        for (Administrativo a : this.registoAdmins) {
            if(a != null){
                System.out.println(a.toString());
            }
        }
    }
    
    /**
     * Imprime os Pedidos de prestação de serviço
     */
    public void listarPedidos(){
        for (PedidoPrestacaoServico pps : this.registoPedidos){
            if(pps != null){
                System.out.println(pps.toString());
            }
        }
    }
    /**
     * Imprime as afetações de pedidos a prestadores de serviço
     */
    public void listarAfetacoes(){
        for(AfetacaoPedidoAPrestador app : this.registoAfetacoes){
            if(app != null){
                System.out.println(app.toString());
            }
        }
    }

    /**
     * Verifica através do e-mail passado por parâmetro, se o mesmo corresponde a um Cliente registado na Empresa
     *
     * @param email e-mail que vai ser comparado com os existentes no contentor de Clientes
     * @return true, se o e-mail passado por parâmetro corresponde a um Cliente da Empresa false, se o e-mail passado por parâmetro não corresponde a um Cliente da Empresa
     */
    public boolean confirmaExistenciaClienteByEmail(String email) {
        for (Cliente cliente : this.registoClientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica através do e-mail passado por parâmetro, se o mesmo corresponde a um Prestador registado na Empresa
     *
     * @param email e-mail que vai ser comparado com os existentes no contentor de Prestadores
     * @return true, se o e-mail passado por parâmetro corresponde a um Prestador da Empresa false, se o e-mail passado por parâmetro não corresponde a um Prestador da Empresa
     */
    public boolean confirmaExistenciaPrestadorByEmail(String email) {
        for (PrestadorServico prestador : this.registoPrestadores) {
            if (prestador.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica através do e-mail passado por parâmetro, se o mesmo corresponde a um Administrativo registado na Empresa
     *
     * @param email e-mail que vai ser comparado com os existentes no contentor de Administrativo
     * @return true, se o e-mail passado por parâmetro corresponde a um Administrativo da Empresa false, se o e-mail passado por parâmetro não corresponde a um Administrativo da Empresa
     */
    public boolean confirmaExistenciaAdminByEmail(String email) {
        for (Administrativo admin : this.registoAdmins) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica através do ID passado por parâmetro, se o mesmo corresponde a uma Categoria definida da Empresa
     *
     * @param catID ID que vai ser comparado com os existentes no contentor de Categorias
     * @return true, se o ID passado por parâmetro corresponde a uma Categoria definida na Empresa false, se o ID passado por parâmetro não corresponde a uma Categoria definida na Empresa
     */
    public boolean confirmaExistenciaCategoriaByID(String catID) {
        for (Categoria cat : this.registoCategorias) {
            if (cat.getCatID().equalsIgnoreCase(catID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica através do ID passado por parâmetro, se o mesmo corresponde a uma Serviço definido da Empresa
     *
     * @param servID ID que vai ser comparado com os existentes no contentor de Serviços
     * @return true, se o ID passado por parâmetro corresponde a um Serviço definido na Empresa false, se o ID passado por parâmetro não corresponde a um Serviço definido na Empresa
     */
    public boolean confirmaExistenciaServicoByID(String servID) {
        for (Servico serv : this.registoServicos) {
            if (serv.getServID().equalsIgnoreCase(servID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve o Cliente que é detentor do e-mail que é passado por parâmetro
     *
     * @param email e-mail que vai ser comparado com os existentes
     * @return Cliente , se o detentor do e-mail que é passado por parâmetro existe null, se não existe um Cliente correspondente ao e-mail
     */
    public Cliente getClienteByEmail(String email) {
        for (Cliente cliente : this.registoClientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Devolve o PrestadorServico que é detentor do e-mail que é passado por parâmetro
     *
     * @param email e-mail que vai ser comparado com os existentes
     * @return PrestadorServico, se o detentor do e-mail que é passado por parâmetro existe 
     *                     null, se não existe um PrestadorServico correspondente ao e-mail
     */
    public PrestadorServico getPrestadorByEmail(String email) {
        for (PrestadorServico prest : this.registoPrestadores) {
            if (prest.getEmail().equalsIgnoreCase(email)) {
                return prest;
            }
        }
        return null;
    }
    
    /**
     * Devolve o PrestadorServico que é detentor do número mecanográfico que é passado por parâmetro
     * @param mecanografico número mecanográfico do Prestador
     * @return PrestadorServico, se o detentor do número que é passado por parâmetro existe
     *                     null, se não existe um PrestadorServico correspondente ao número mecanográfico
     */
    public PrestadorServico getPrestadorByMecanografico(String mecanografico){
        for (PrestadorServico prest : this.registoPrestadores) {
            if (prest.getMecanografico().equals(mecanografico)) {
                return prest;
            }
        }
        return null;
    }

    /**
     * Devolve o Administrativo que é detentor do e-mail que é passado por parâmetro
     *
     * @param email e-mail que vai ser comparado com os existentes
     * @return Administrativo, se o detentor do e-mail que é passado por parâmetro existe null, se não existe um Administrativo correspondente ao e-mail
     */
    public Administrativo getAdminByEmail(String email) {
        for (Administrativo admin : this.registoAdmins) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                return admin;
            }
        }
        return null;
    }

    /**
     * Devolve o Utilizador que é detentor do e-mail que é passado por parâmetro
     *
     * @param email e-mail que vai ser comparado com os existentes
     * @return Cliente, se o detentor do e-mail passado por parâmetro é Cliente PrestadorServico, se o detentor do e-mail passado por parâmetro é PrestadorServico Administrativo, se o detentor do e-mail passado por parâmetro é Administrativo null, se o detentor do e-mail passado por parâmetro não existe
     */
    public Utilizador getUtilizadorByEmail(String email) {
        for (Cliente cliente : this.registoClientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                return (Cliente) cliente;
            }
        }
        for (PrestadorServico prest : this.registoPrestadores) {
            if (prest.getEmail().equalsIgnoreCase(email)) {
                return (PrestadorServico) prest;
            }
        }
        for (Administrativo admin : this.registoAdmins) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                return (Administrativo) admin;
            }
        }
        return null;
    }
    
    /**
     * Devolve o Serviço correspondente a um determinado ID de categoria e ID de serviço
     * @param servID ID de serviço
     * @return Serviço correspondente a um determinado ID de categoria e ID de serviço
     */
    public Servico getServicoByServID(String servID){
        for(Servico servico : this.registoServicos){
            if (servico.getServID().equalsIgnoreCase(servID)){
                return servico;
            }
        }
        return null;
    }
    /**
     * Devolve o Serviço que corresponde à categoria escolhida, e à escolha de serviço feita em "escolha de serviço"
     * @param catID categoria selecionada previamente
     * @param resposta escolha de serviço no case/switch anterior
     * @return Serviço que corresponde à categoria escolhida, e à escolha de serviço feita em "escolha de serviço"
     */
    public Servico getServicoByEscolhaServico(String catID, int resposta){
        switch (catID){
            case "cat01":
                for( Servico servico : this.registoServicos){
                    String [] IDsContabilidade = {"cont1", "cont2", "cont3"};
                    String opcao = IDsContabilidade[resposta - 1];
                    if (opcao.equalsIgnoreCase(servico.getServID())){
                        return servico;
                    }
                }
                break;
            case "cat02":
                for( Servico servico : this.registoServicos){
                    String [] IDsRestauracao = {"rest1", "rest2", "rest3"};
                    String opcao = IDsRestauracao[resposta - 1];
                    if (opcao.equalsIgnoreCase(servico.getServID())){
                        return servico;
                    }
                }
                break;
            case "cat03":
                for( Servico servico : this.registoServicos){
                    String [] IDsManutencao = {"man1", "man2", "man3"};
                    String opcao = IDsManutencao[resposta - 1];
                    if (opcao.equalsIgnoreCase(servico.getServID())){
                        return servico;
                    }
                }
                break;
            case "cat04":
                for( Servico servico : this.registoServicos){
                    String [] IDsConstrucao = {"con1", "con2", "con3"};
                    String opcao = IDsConstrucao[resposta - 1];
                    if (opcao.equalsIgnoreCase(servico.getServID())){
                        return servico;
                    }
                }
                break;
            case "cat05":
                for( Servico servico : this.registoServicos){
                    String [] IDsCriatividade = {"cri1", "cri2", "cri3"};
                    String opcao = IDsCriatividade[resposta - 1];
                    if (opcao.equalsIgnoreCase(servico.getServID())){
                        return servico;
                    }
                }
                break;
        }
        return null;
    }
    
    /**
     * Devolve o pedido de prestação de serviço, através do seu número atribuido
     * @param numero número atribuido
     * @return pedido de prestação de serviço, através do seu número atribuido
     */
    public PedidoPrestacaoServico getPedidoByNumero(int numero){
        for(PedidoPrestacaoServico pps: registoPedidos){
            if(pps.getNumeroAtribuido() == numero){
                return pps;
            }
        }
        return null;
    }
}

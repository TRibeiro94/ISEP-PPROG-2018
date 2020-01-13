package model;


/**
 * @author Tiago Ribeiro (1181444)
 */
public class AfetacaoPedidoAPrestador {
    
    /**
     * Pedido de Prestação de Serviço
     */
    private PedidoPrestacaoServico pedidoPrestacaoServico;
    /**
     * Prestador de Serviço afetado ao Pedido
     */
    private PrestadorServico prestadorServico;
    
    /**
     * Pedido de Prestação de Serviço por omissão
     */
    private static final PedidoPrestacaoServico PEDIDO_POR_OMISSAO = new PedidoPrestacaoServico();
    /**
     * Prestador de Serviço afetado ao Pedido por omissão
     */
    private static final PrestadorServico PRESTADOR_POR_OMISSAO = new PrestadorServico();
    
    /**
     * Constrói uma instância de AfetacaoPedidoAPrestador que recebe um pedido e um prestador
     * @param pedidoPrestacaoServico Pedido de Prestação de Serviço
     * @param prestadorServico Prestador de Serviço afetado ao Pedido
     */
    public AfetacaoPedidoAPrestador(PedidoPrestacaoServico pedidoPrestacaoServico, PrestadorServico prestadorServico){
        this.pedidoPrestacaoServico = pedidoPrestacaoServico;
        this.prestadorServico = prestadorServico;
    }
    /**
     * Constrói uma instância de AfetacaoPedidoAPrestador com valores por omissão
     */
    public AfetacaoPedidoAPrestador(){
        pedidoPrestacaoServico = PEDIDO_POR_OMISSAO;
        prestadorServico = PRESTADOR_POR_OMISSAO;
    }
    /**
     * Devolve o Pedido de Prestação de Serviço
     * @return Pedido de Prestação de Serviço
     */
    public PedidoPrestacaoServico getPedido(){
        return pedidoPrestacaoServico;
    }
    /**
     * Devolve o Prestador de Serviço
     * @return Prestador de Serviço
     */
    public PrestadorServico getPrestador(){
        return prestadorServico;
    }
    /**
     * Modifica o Pedido de Prestação de Serviço
     * @param pedido Pedido de Prestação de Serviço
     */
    public void setPedido(PedidoPrestacaoServico pedido){
        this.pedidoPrestacaoServico = new PedidoPrestacaoServico(pedido);
    }
    /**
     * Modifica o Prestador de Serviço
     * @param prestador Prestador de Serviço
     */
    public void setPrestador(PrestadorServico prestador){
        this.prestadorServico = new PrestadorServico(prestador);
    }
    
    /**
     * Devolve as características da afetação (prestador, pedido)
     * @return características da afetação (prestador, pedido)
     */
    @Override
    public String toString(){
        return String.format("\nAfetação:\nPrestador: (%s) %s\nPedido %d", prestadorServico.getMecanografico(), prestadorServico.getNome(), pedidoPrestacaoServico.getNumeroAtribuido());
    }
}

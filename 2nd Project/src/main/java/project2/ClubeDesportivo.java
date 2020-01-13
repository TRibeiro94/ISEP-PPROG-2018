package project2;

/**
 * Representa um Clube Desportivo
 *
 * @author Tiago Soares (1181444)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.dei.biblioteca.Data;

public class ClubeDesportivo {
    /**
    * Nome do Clube Desportivo
    */
    private String nomeClube;
    /**
    * Data da fundação do Clube Desportivo
    */
    private Data dataFundacao;
    /**
     * Contentor de objetos que irá armazenar os Atletas ("balneário")
     */
    private List<Atleta> listaAtletas = new ArrayList<>();
    /**
     * Nome do Clube Desportivo por omissão
     */
    private static final String NOMECLUBE_POR_OMISSAO = "sem nome";
    /**
     * Constrói uma instância de um Clube Desportivo que recebe nome e data de fundação
     *
     * @param nomeClube Nome do clube
     * @param dataFundacao Data de fundação do clube
     */
    public ClubeDesportivo(String nomeClube, Data dataFundacao) {
        this.nomeClube = nomeClube;
        this.dataFundacao = new Data(dataFundacao);
    }
    /**
     * Constrói uma instância de um Clube Desportivo com valores por omissão
     */
    public ClubeDesportivo() {
        nomeClube = NOMECLUBE_POR_OMISSAO;
        dataFundacao = new Data();
    }
    /**
     * Devolve o nome do clube desportivo
     *
     * @return nome do clube desportivo
     */
    public String getNomeClube() {
        return nomeClube;
    }
    
    /**
     * Modifica o nome do clube
     *
     * @param nome do clube
    */
    public void setNomeClube(String nome) {
        this.nomeClube = nome;
    }
    /**
     * Devolve a data de fundação do clube desportivo
     * 
     * @return data de fundação do clube
     */
    public Data getData(){
        return dataFundacao;
    }
    /**
     * Modifica a data de fundação do clube
     * 
     * @param data data de fundação do clube
     */
    public void setData(Data data){
        this.dataFundacao.setData(data.getAno(), data.getMes(), data.getDia());;
    }
    /**
     * Devolve a lista de atletas do clube desportivo
     * 
     * @return lista de atletas
     */
    public List<Atleta> getListaAtletas(){
        return listaAtletas;
    }

    /**
     * Adiciona um atleta ao contentor de atletas da instância ClubeDesportivo
     *
     * @param atleta atleta que vai ser adicionado ao Clube
     */
    public void adicionarAtleta(Atleta atleta) {
        if (atleta instanceof AtletaPro) {
            AtletaPro novoAtleta = (AtletaPro) atleta;
            listaAtletas.add(novoAtleta);
        } else if (atleta instanceof AtletaSemi) {
            AtletaSemi novoAtleta = (AtletaSemi) atleta;
            listaAtletas.add(novoAtleta);
        } else if (atleta instanceof AtletaAmador) {
            AtletaAmador novoAtleta = (AtletaAmador) atleta;
            listaAtletas.add(novoAtleta);
        }
    }

    /**
     * Imprime a lista com os nomes dos atletas do clube.
     */
    public void listarAtletas() {
        for (Atleta atleta : listaAtletas) {
            System.out.println("Nome: " + atleta.getNome());
        }
    }
    /**
     * Imprime a lista de atletas do clube, com categoria, modalidade e nome
     */
    public void listarAtletasDetalhado() {
        for (Atleta atleta : listaAtletas) {
            System.out.printf("\n%s; %s; %s.", atleta.getClass().getSimpleName(), atleta.getAtividade(), atleta.getNome());
            System.out.println("");
        }
    }
    /**
     * Lista os os nomes e valores em prémios respetivos, de todos os atletas do clube.
     */
    public void listarValorMensalPremios() {
        for (Atleta atleta : listaAtletas) {
            System.out.printf("\nNome: %s ; Valor de Prémios: %.2f€.", atleta.getNome(), atleta.getValorMensal());
        }
    }
    /**
     * Ordena por ordem alfabética o contentor de atletas.
     */
    public void ordenarAtletasNome() {
        Collections.sort(listaAtletas);
    }
    /**
     * Ordena os atletas pela ordem inversa dos seus valores em prémios recebidos.
     * (mais alto em € para o mais baixo)
     */
    public void ordenarValorMensalInverso(){
      Comparator<Atleta> criterioMensal = new Comparator<Atleta>(){
        @Override
        public int compare(Atleta atleta1, Atleta atleta2){
          return (int) (atleta2.getValorMensal() - atleta1.getValorMensal());
        }
      };
      Collections.sort(listaAtletas, criterioMensal);
    };
    /**
     * Ordena os atletas do clube por ordem alfabética, da sua categoria, atividade e o seu nome.
     */
    public void ordenarAlfaCatModalidadeNome() {
        Comparator<Atleta> multiCriterios = new Comparator<Atleta>() {
            @Override
            public int compare(Atleta atleta1, Atleta atleta2) {
                if (atleta1.getClass() == atleta2.getClass()) {
                    if (atleta1.getAtividade() == atleta2.getAtividade()) {
                        return atleta1.getNome().compareToIgnoreCase(atleta2.getNome());
                    } else {
                        return atleta1.getAtividade().compareToIgnoreCase(atleta2.getAtividade());
                    }
                } else {
                    return obterCategoria(atleta1).compareToIgnoreCase(obterCategoria(atleta2));
                }
            }
        };

        Collections.sort(listaAtletas, multiCriterios);
    }
    /**
     * Obtém a categoria do atleta.
     *
     * @param atleta atleta sobre o qual se vai obter a categoria
     * @return categoria do atleta que é passado por parâmetro
     */
    private String obterCategoria(Atleta atleta) {
        return atleta.getClass().getSimpleName();
    }
    /**
     * Obtém o valor total de descontos para todos os atletas profissionais e semi do clube.
     *
     * @return totalIRS valor de desconto
     */
    public double obterTotalDescontos() {
        double totalIRS = 0;
        for (Atleta atleta : listaAtletas) {
            if (atleta instanceof AtletaPro) {
                totalIRS += ((AtletaPro) atleta).valorDoDesconto();
            } else if (atleta instanceof AtletaSemi) {
                totalIRS += ((AtletaSemi) atleta).valorDoDesconto();
            }
        }
        return totalIRS;
    }
}

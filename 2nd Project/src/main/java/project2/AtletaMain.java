package project2;

import java.text.DecimalFormat;
import org.dei.biblioteca.Data;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class AtletaMain {

    private static DecimalFormat round = new DecimalFormat(".##");

    public static void main(String[] args) {


        AtletaPro pro1 = new AtletaPro("Nicky Hayden", 202461123, "masculino", 24, "natação", 50, 1000, 200);
        AtletaPro pro2 = new AtletaPro("Alex Morgan", 444613719, "feminino", 23, "ciclismo", 71, 1500, 275);
        AtletaPro pro3 = new AtletaPro("Marco Simoncelli", 111222333, "masculino", 30, "corrida", 66, 1000, 500);
        AtletaSemi semi1 = new AtletaSemi("Giacomo Agostini", 654677901, "masculino", 29, "corrida", 34, 250, 12);
        AtletaSemi semi2 = new AtletaSemi("Nastia Liukin", 661324970, "feminino", 38, "caminhada", 40, 500, 21);
        AtletaSemi semi3 = new AtletaSemi("Maria Sharapova", 101376549, "feminino", 18, "natação", 66, 100, 6);
        AtletaAmador amador1 = new AtletaAmador("Mary Retton", 100743781, "feminino", 25, "ciclismo", 50, 55, 5);
        AtletaAmador amador2 = new AtletaAmador("Max Biaggi", 946401002, "masculino", 40, "ciclismo", 66, 100, 20);
        AtletaAmador amador3 = new AtletaAmador("Danilo Petrucci", 946987002, "masculino", 43, "corrida", 62, 150, 10);

//a) Criar uma instancia da classe ClubeDesportivo;
        Data d1 = new Data(1904, 2, 28);
        ClubeDesportivo monsterYamaha = new ClubeDesportivo("Monster Yamaha", d1);
        System.out.println("\n");
        
        //b) Armazenar nessa instância 3 objetos de cada uma das categorias (Profissional, Semiprofissional e Amador), associados por composição;
        monsterYamaha.adicionarAtleta(pro1);
        monsterYamaha.adicionarAtleta(pro2);
        monsterYamaha.adicionarAtleta(pro3);
        monsterYamaha.adicionarAtleta(semi1);
        monsterYamaha.adicionarAtleta(semi2);
        monsterYamaha.adicionarAtleta(semi3);
        monsterYamaha.adicionarAtleta(amador1);
        monsterYamaha.adicionarAtleta(amador2);
        monsterYamaha.adicionarAtleta(amador3);

//c) Executar as funcionalidades de 1 a 6 e visualizar o seu resultado.
//1. Retornar o nome do clube;
        System.out.println("\nNome do Clube Desportivo: " + monsterYamaha.getNomeClube() + " fundado em: " + d1.toAnoMesDiaString() + ".");

//2. Inserir um novo atleta no contentor (associado por composição);
        AtletaPro pro4 = new AtletaPro("Valentino Rossi", 123456789, "masculino", 30, "corrida", 68, 1000, 500);

        monsterYamaha.listarAtletas();
        System.out.println("\nDepois da adição do novo atleta:");
        monsterYamaha.adicionarAtleta(pro4);
        monsterYamaha.listarAtletas();

//3. Retornar uma lista de atletas, ordenada alfabeticamente por nome;
        System.out.println("\nDepois da ordenação por Nome:");
        monsterYamaha.ordenarAtletasNome();
        monsterYamaha.listarAtletas();
        System.out.println("\n");

//4. Retornar uma lista de atletas, ordenada inversamente pelo valor dos prémios;
        System.out.println("Listagem do valor mensal não ordenada:");
        monsterYamaha.listarValorMensalPremios();
        System.out.println("\n\n");
        System.out.println("Depois da Ordenação Inversa dos seus prémios mensais:");
        monsterYamaha.ordenarValorMensalInverso();
        monsterYamaha.listarValorMensalPremios();

//5. Retornar o valor total, para efeitos de IRS, da totalidade dos atletas;
        System.out.println("\n");
        System.out.println("Valor total do IRS a pagar pelo clube " + monsterYamaha.getNomeClube() + " é de: " + round.format(monsterYamaha.obterTotalDescontos()) + "€.");

//6. Retornar uma lista de atletas do clube, ordenada alfabeticamente por categoria, modalidade e nome;
        System.out.println("\n");
        monsterYamaha.ordenarAlfaCatModalidadeNome();
        System.out.println("\nLista ordenada pelo Tipo de Atleta, pela Modalidade e pelo Nome:");
        monsterYamaha.listarAtletasDetalhado();

    }
}

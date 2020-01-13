package Project1;

import java.text.DecimalFormat;
/**
 *
 * @author Tiago Ribeiro (1181444)
 * @author Pedro Água (1180809)
 */
public class AtletaMain {

    private static DecimalFormat round = new DecimalFormat(".##");

    public static void main(String[] args) {
        
        double total = 0, totalPro = 0, totalSemi = 0, totalAmador = 0;

        AtletaPro pro1 = new AtletaPro("Michael Phelps", 202461123, "masculino", 24, "natação", 50, 1000, 2000);
        AtletaPro pro2 = new AtletaPro("Margot Robbie", 44461371, "feminino", 23, "ciclismo", 71, 1500, 275);

        AtletaSemi semi1 = new AtletaSemi("Valentino Rossi", 654677901, "masculino", 29, "corrida", 34, 250, 12);
        AtletaSemi semi2 = new AtletaSemi("Serena Williams", 661324970, "feminino", 38, "caminhada", 40, 500, 21);
        AtletaSemi semi3 = new AtletaSemi("Ronda Rousey", 101376549, "feminino", 18, "natação", 66, 100, 6);

        AtletaAmador amador1 = new AtletaAmador("Vanessa Selbst", 100743781, "feminino", 25, "ciclismo", 50, 55, 5);
        AtletaAmador amador2 = new AtletaAmador("Daniel Negreanu", 946401002, "masculino", 40, "ciclismo", 66, 100, 20);

        Atleta[] listaAtletas = new Atleta[pro1.getContador()];

        listaAtletas[0] = pro1;
        listaAtletas[1] = pro2;
        listaAtletas[2] = semi1;
        listaAtletas[3] = semi2;
        listaAtletas[4] = semi3;
        listaAtletas[5] = amador1;
        listaAtletas[6] = amador2;

        System.out.println("\nLista de Atletas Não Profissionais do Clube Desportivo :");
        System.out.println("----------------------------------------------------------------------------------");

        for (int i = 0; i < listaAtletas.length; i++) {
            if (listaAtletas[i] != null && listaAtletas[i] instanceof AtletaSemi || listaAtletas[i] != null && listaAtletas[i] instanceof AtletaAmador) {
                System.out.println("\nAtleta " + listaAtletas[i].getNome() + " apresenta uma FCM de " + round.format(listaAtletas[i].calcularFCM())
                        + ". \nA FCT será de " + round.format(listaAtletas[i].calcularFCTQueima())
                        + " caso o objetivo seja a queima de gordura, e " + round.format(listaAtletas[i].calcularFCTcapCardio())
                        + " caso o objetivo seja trabalhar a capacidade respiratória.");
            }
        }
        System.out.println("\n\nValores a pagar a cada atleta individualmente :");
        System.out.println("----------------------------------------------------------------------------------");

        for (int i = 0; i < listaAtletas.length; i++) {
            if (listaAtletas[i] != null) {
                System.out.println("\n Atleta " + listaAtletas[i].getNome() + " vai auferir neste mês " + listaAtletas[i].calcularPagamento() + "€.");
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\nQuantidade de Atletas Amadores : " + amador1.getContadorAmador());
        System.out.println("\nQuantidade de Atletas Profissionais : " + pro1.getContadorPro());

        System.out.println("\n\nPagamentos :");

        for (int i = 0; i < listaAtletas.length; i++) {
            if (listaAtletas[i] != null && listaAtletas[i] instanceof AtletaPro) {
                totalPro += listaAtletas[i].calcularPagamento();
            } else if (listaAtletas[i] != null && listaAtletas[i] instanceof AtletaSemi) {
                totalSemi += listaAtletas[i].calcularPagamento();
            } else if (listaAtletas[i] != null && listaAtletas[i] instanceof AtletaAmador) {
                totalAmador += listaAtletas[i].calcularPagamento();
            }
            total += listaAtletas[i].calcularPagamento();
        }

        System.out.println("\nValor total a pagar aos atletas profissionais é de " + round.format(totalPro) + "€.");
        System.out.println("\nValor total a pagar aos atletas semi profissionais é de " + round.format(totalSemi) + "€.");
        System.out.println("\nValor total a pagar aos atletas amadores é de " + round.format(totalAmador) + "€.");

        System.out.println("\nO clube desportivo tem de pagar no total : " + total + "€.");

    }

}

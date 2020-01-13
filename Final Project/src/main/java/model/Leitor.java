package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Leitor {
    /**
     * Lê o ficheiro que contêm os clientes e instancia cada um, adicionando-o à lista de Clientes da Empresa
     */
    public void leitorCliente() {
        try {
            Scanner leitorCli = new Scanner(new File("clientes.txt"));
            leitorCli.useDelimiter("/|\n");

            try {
                while (leitorCli.hasNext()) {
                    String nome = leitorCli.next().trim();
                    String email = leitorCli.next().trim();
                    String pass = leitorCli.next().trim();
                    String NIF = leitorCli.next().trim();
                    String telefone = leitorCli.next().trim();
                    String endereco = leitorCli.next().trim();
                    String localidade = leitorCli.next().trim();
                    String codPostal = leitorCli.next().trim();
                    String latitude = leitorCli.next().trim();
                    String longitude = leitorCli.next().trim();

                    AplicacaoGPSD.empresa.adicionarUtilizador(new Cliente(nome, email, pass, NIF, telefone, (new EnderecoPostal(endereco, localidade, (new CodigoPostal(codPostal, latitude, longitude))))));
                }
            } catch (NoSuchElementException e) {
                System.out.println("Erro na leitura do ficheiro Clientes. Por favor verifique o ficheiro '.txt' em causa.");
                e.printStackTrace();
                exit(0);
            }

            leitorCli.close();

        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro de 'Clientes' especificado não existe. Por favor certifique-se se este existe.");
            e.printStackTrace();
            exit(0);
        }
    }
    /**
     * Lê o ficheiro que contêm as categorias e instancia cada uma, adicionando-a à lista de Categorias da Empresa
     */
    public void leitorCategoria() {
        try {
            Scanner leitorCat = new Scanner(new File("categorias.txt"));
            leitorCat.useDelimiter("/|\n");

            try {
                while (leitorCat.hasNext()) {
                    String catID = leitorCat.next().trim();
                    String descricao = leitorCat.next().trim();

                    AplicacaoGPSD.empresa.adicionarCategoria(new Categoria(catID,descricao));
                }
            } catch (NoSuchElementException e) {
                System.out.println("Erro na leitura do ficheiro Categorias. Por favor verifique o ficheiro '.txt' em causa.");
                e.printStackTrace();
                exit(0);
            }

            leitorCat.close();

        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro de 'Categorias' especificado não existe. Por favor certifique-se se este existe.");
            e.printStackTrace();
            exit(0);
        }
    }
    /**
     * Lê o ficheiro que contêm os serviços e instancia cada um, adicionando-o à lista de Servicos da Empresa
     */
    public void leitorServicos(){
        try {
            Scanner leitorServ = new Scanner(new File("servicos.txt"));
            leitorServ.useDelimiter("/|\n");

            try {
                while (leitorServ.hasNext()) {
                    String catID = leitorServ.next().trim();
                    String servID = leitorServ.next().trim();  
                    String descBreve = leitorServ.next().trim();
                    String descComp = leitorServ.next().trim();
                    String custoHora = leitorServ.next().trim();

                    AplicacaoGPSD.empresa.adicionarServico(new Servico(catID, servID, descBreve, descComp, Double.parseDouble(custoHora)));
                }
            } catch (NoSuchElementException e) {
                System.out.println("Erro na leitura do ficheiro Serviços. Por favor verifique o ficheiro '.txt' em causa.");
                e.printStackTrace();
                exit(0);
            }

            leitorServ.close();

        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro de 'Serviços' especificado não existe. Por favor certifique-se se este existe.");
            e.printStackTrace();
            exit(0);
        }
    }
    /**
     * Lê o ficheiro que contem os administrativos e instancia cada, adicionando-o à lista de Administrativos da Empresa
     */
    public void leitorAdmins(){
        try {
            Scanner leitorAdmins = new Scanner(new File("admins.txt"));
            leitorAdmins.useDelimiter("/|\n");

            try {
                while (leitorAdmins.hasNext()) {
                    String nome = leitorAdmins.next().trim();
                    String email = leitorAdmins.next().trim();  
                    String password = leitorAdmins.next().trim();

                    AplicacaoGPSD.empresa.adicionarUtilizador(new Administrativo(nome,email,password));
                }
            } catch (NoSuchElementException e) {
                System.out.println("Erro na leitura do ficheiro Administradores. Por favor verifique o ficheiro '.txt' em causa.");
                e.printStackTrace();
                exit(0);
            }

            leitorAdmins.close();

        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro de 'Administrativos especificado não existe. Por favor certifique-se se este existe.");
            e.printStackTrace();
            exit(0);
        }
    }
    /**
     * Lê o ficheiro que contem as áreas geográficas e instancia cada uma, adicionando-o à lista de áreas geográficas da Empresa
     */
    public void leitorAreas(){
        try {
            Scanner leitorAreas = new Scanner(new File("areas.txt"));
            leitorAreas.useDelimiter("/|\n");

            try {
                while (leitorAreas.hasNext()) {
                    String designacao = leitorAreas.next().trim();
                    String custoDeslocacao = leitorAreas.next().trim();  
                    String codPostal = leitorAreas.next().trim();
                    String latitude = leitorAreas.next().trim();
                    String longitude = leitorAreas.next().trim();
                    

                    AplicacaoGPSD.empresa.adicionarAreaGeo(new AreaGeografica(designacao, Double.parseDouble(custoDeslocacao) , (new CodigoPostal(codPostal, latitude, longitude) )));
                }
            } catch (NoSuchElementException e) {
                System.out.println("Erro na leitura do ficheiro Áreas Geográficas. Por favor verifique o ficheiro '.txt' em causa.");
                e.printStackTrace();
                exit(0);
            }

            leitorAreas.close();

        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro de Áreas Geográficas especificado não existe. Por favor certifique-se se este existe.");
            e.printStackTrace();
            exit(0);
        }        
    }
    /**
     * Lê o ficheiro que contêm os prestadores e instancia cada um, adicionando-o à lista de Clientes da Empresa
     */
    public void leitorPrestadores() {
        try {
            Scanner leitorPrest = new Scanner(new File("prestadores.txt"));
            leitorPrest.useDelimiter("/|\n");

            try {
                while (leitorPrest.hasNext()) {
                    int i = 0;
                    String nome = leitorPrest.next().trim();
                    String email = leitorPrest.next().trim();  
                    String password = leitorPrest.next().trim();
                    String emailInstitucional = leitorPrest.next().trim();
                    String nomeAbreviado = leitorPrest.next().trim();
                    String mecanografico = leitorPrest.next().trim();

                    AplicacaoGPSD.empresa.adicionarUtilizador(new PrestadorServico(nome, email, password, emailInstitucional, nomeAbreviado, mecanografico, AplicacaoGPSD.empresa.getListaAreas().get(i)));
                    i++;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Erro na leitura do ficheiro Prestadores. Por favor verifique o ficheiro '.txt' em causa.");
                e.printStackTrace();
                exit(0);
            }

            leitorPrest.close();

        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro de 'Prestadores' especificado não existe. Por favor certifique-se se este existe.");
            e.printStackTrace();
            exit(0);
        }
    }    
    /**
     * Lê o ficheiro binário onde são serializados os pedidos de prestação de serviço
     * @param nomeFicheiro nome do ficheiro a ler
     * @return true, se o ficheiro foi lido
     *         false, se não foi possível ler o ficheiro
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean lerFicheiroBinario(String nomeFicheiro) throws FileNotFoundException, IOException {
        ArrayList<PedidoPrestacaoServico> listaPrestadores;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFicheiro));
            try {
                listaPrestadores = (ArrayList<PedidoPrestacaoServico>) in.readObject();
                AplicacaoGPSD.empresa.setRegistoPedidos(listaPrestadores);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("Não existem pedidos no registo.\n\n");
            return false;
        }
    }
}

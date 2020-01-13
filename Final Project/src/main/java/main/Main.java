package main;

import UI.MenuLogin;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.AplicacaoGPSD;
import model.Empresa;
import model.Leitor;
import model.PedidoPrestacaoServico;

/** 
 * @author Tiago Ribeiro (1181444)
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Empresa empresa = new Empresa();
        AplicacaoGPSD.empresa = empresa;
        
        Leitor leitor = new Leitor();
        
        String nomeFicheiro = "registoPedidos.ser";
        leitor.lerFicheiroBinario(nomeFicheiro);
        leitor.leitorCliente();
        leitor.leitorCategoria();
        leitor.leitorAreas();
        leitor.leitorServicos();
        leitor.leitorAdmins();
        leitor.leitorPrestadores();
        PedidoPrestacaoServico.numeroDePedidosEfetuados();
        
        MenuLogin login = new MenuLogin();
        login.loop();
    }
}

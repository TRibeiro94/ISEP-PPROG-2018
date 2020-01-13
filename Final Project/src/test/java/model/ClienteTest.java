package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    /**
     * Teste do método adicionarEndereco da classe Cliente.
     */
    @Test
    public void testAdicionarEndereco() {
        System.out.println("Adicionar Endereço");
        
        EnderecoPostal end = new EnderecoPostal("moradaTeste", "localidadeTeste", new CodigoPostal("4433-123", "23.2323", "45.2221"));
        Cliente cli = new Cliente("Ana", "ana@sapo.pt", "pass", "178998571", "913665298", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        
        cli.getListaEnderecos().add(end);
        assertEquals(end, cli.getListaEnderecos().get(1));
    }

    /**
     * Teste do método removerEndereco da classe Cliente.
     */
    @Test
    public void testRemoverEndereco() {
        System.out.println("Remover Endereço");
        EnderecoPostal endereco = new EnderecoPostal("moradaTeste", "localidadeTeste", new CodigoPostal("4433-123", "23.2323", "45.2221"));
        Cliente cli = new Cliente("Ana", "ana@sapo.pt", "pass", "178998571", "913665298", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        cli.getListaEnderecos().add(endereco);
        
        boolean expResult = true;
        boolean result = cli.removerEndereco(endereco);
        
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getEnderecoByNumero da classe Cliente.
     */
    @Test
    public void testGetEnderecoByNumero() {
        System.out.println("Conseguir Endereco pelo Número");
        int numero = 2;
        
        Cliente instance = new Cliente("Ana", "ana@sapo.pt", "pass", "178998571", "913665298", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        EnderecoPostal end1 = new EnderecoPostal();
        instance.getListaEnderecos().add(end1);
        
        EnderecoPostal expResult = end1;
        EnderecoPostal result = instance.getEnderecoByNumero(numero);
        
        assertEquals(expResult, result);
    }

    /**
     * Teste do método equals da classe Cliente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals (dois clientes)");
        Cliente cli1 = new Cliente("Ana", "ana@sapo.pt", "pass", "178998571", "913665298", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        Cliente cli2 = new Cliente("Ana", "ana@sapo.pt", "pass", "178998571", "913665298", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        
        boolean expResult = true;
        boolean result = cli1.equals(cli2);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método equals da classe Cliente.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals (dois clientes)");
        Cliente cl = new Cliente("Ana", "ana@sapo.pt", "pass", "178998571", "913665298", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        Cliente cli = new Cliente("Luis", "lu@sapo.pt", "pasdds", "17896543", "91365498", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        
        boolean expResult = false;
        boolean result = cl.equals(cli);
        
        assertEquals(expResult, result);
    }    
}

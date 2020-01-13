package model;

import Utils.Data;
import Utils.Tempo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class EmpresaTest {
    
    public EmpresaTest() {
    }

    /**
     * Teste do método adicionarUtilizador da classe Empresa.
     */
    @Test
    public void testAdicionarUtilizadorCliente() {
        System.out.println("Adicionar Utilizador Cliente");
        Empresa emp = new Empresa();
        Utilizador uti = new Cliente("Ana", "ana@sapo.pt", "pass", "178998571", "913665298", new EnderecoPostal("Rua Salgueiro Maia", "Aveiro", new CodigoPostal("5622-190", "12.334891", "21.123122")));
        emp.adicionarUtilizador(uti);
        assertEquals(emp.getListaClientes().get(0), uti);
        
    }
    /**
     * Teste do método adicionarUtilizador da classe Empresa.
     */
    @Test
    public void testAdicionarUtilizadorAdmin() {
        System.out.println("Adicionar Utilizador Administrativo");
        Empresa emp = new Empresa();
        Utilizador uti = new Administrativo("Ana", "ana@sapo.pt", "pass");
        emp.adicionarUtilizador(uti);
        assertEquals(emp.getListaAdmins().get(0), uti);
    }
    /**
     * Teste do método adicionarUtilizador da classe Empresa.
     */
    @Test
    public void testAdicionarUtilizadorPrestador() {
        System.out.println("Adicionar Utilizador Prestador");
        Empresa emp = new Empresa();
        Utilizador uti = new PrestadorServico("Ana", "ana@sapo.pt", "pass", "ana@isep", "Ana S", "444", new AreaGeografica());
        emp.adicionarUtilizador(uti);
        assertEquals(emp.getListaPrestadores().get(0), uti);
        
    }

    /**
     * Teste do método adicionarCategoria da classe Empresa.
     */
    @Test
    public void testAdicionarCategoria() {
        System.out.println("Adicionar Categoria");
        Empresa emp = new Empresa();
        Categoria cat = new Categoria("ID1", "Catering");
        emp.adicionarCategoria(cat);
        assertEquals(emp.getListaCategorias().get(0), cat);
    }

    /**
     * Teste do método adicionarServico da classe Empresa.
     */
    @Test
    public void testAdicionarServico() {
        System.out.println("Adicionar Serviço");
        Empresa emp = new Empresa();
        Servico serv = new Servico("IDcat", "IDserv", "contabilidade", "salarios", 45);
        emp.adicionarServico(serv);
        assertEquals(emp.getListaServicos().get(0), serv);
    }

    /**
     * Teste do método adicionarPedido da classe Empresa.
     */
    @Test
    public void testAdicionarPedido() {
        System.out.println("Adicionar Pedido");
        Empresa emp = new Empresa();
        PedidoPrestacaoServico pedido = new PedidoPrestacaoServico(new Servico(),new Data(),new Tempo(),new Tempo(),"descricao1",46.0,new EnderecoPostal());
        emp.adicionarPedido(pedido);
        assertEquals(emp.getListaPedidos().get(0), pedido);
    }

    /**
     * Teste do método adicionarAreaGeo da classe Empresa.
     */
    @Test
    public void testAdicionarAreaGeo() {
        System.out.println("Adicionar Área Geográfica");
        Empresa emp = new Empresa();
        AreaGeografica area = new AreaGeografica("porto", 10, new CodigoPostal("4100-001","43.1","-8.6"));
        emp.adicionarAreaGeo(area);
        assertEquals(emp.getListaAreas().get(0), area);
    }

    /**
     * Teste do método confirmaExistenciaClienteByEmail da classe Empresa.
     */
    @Test
    public void testConfirmaExistenciaClienteByEmail() {
        System.out.println("Confirma Existência de um Cliente pelo E-mail");
        
        String email = "teste";
        Empresa emp = new Empresa();
        Cliente cli = new Cliente();
        cli.setEmail(email);
        emp.getListaClientes().add(cli);
        
        boolean expResult = true;
        boolean result = emp.confirmaExistenciaClienteByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método confirmaExistenciaPrestadorByEmail da classe Empresa.
     */
    @Test
    public void testConfirmaExistenciaPrestadorByEmail() {
        System.out.println("Confirma Existência de um Prestador pelo E-mail");
        
        String email = "teste";
        Empresa emp = new Empresa();
        PrestadorServico ps = new PrestadorServico();
        ps.setEmail(email);
        emp.getListaPrestadores().add(ps);
        
        boolean expResult = true;
        boolean result = emp.confirmaExistenciaPrestadorByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método confirmaExistenciaAdminByEmail da classe Empresa.
     */
    @Test
    public void testConfirmaExistenciaAdminByEmail() {
        System.out.println("Confirma Existência de um Administrativo pelo E-mail");
        
        String email = "teste";
        Empresa emp = new Empresa();
        Administrativo admin = new Administrativo();
        admin.setEmail(email);
        emp.getListaAdmins().add(admin);
        
        boolean expResult = true;
        boolean result = emp.confirmaExistenciaAdminByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método confirmaExistenciaCategoriaByID da class Empresa.
     */
    @Test
    public void testConfirmaExistenciaCategoriaByID() {
        System.out.println("Confirma Existência de uma Categoria pelo ID");
        String catID = "idid";
        
        Empresa emp = new Empresa();
        Categoria catTeste = new Categoria();
        catTeste.setCatID(catID);
        emp.getListaCategorias().add(catTeste);
        
        boolean expResult = true;
        boolean result = emp.confirmaExistenciaCategoriaByID(catID);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método confirmaExistenciaServicoByID da classe Empresa.
     */
    @Test
    public void testConfirmaExistenciaServicoByID() {
        System.out.println("Confirma Existência de Serviço pelo ID");
        String servID = "id";
        
        Empresa emp = new Empresa();
        Servico sv = new Servico();
        sv.setServID(servID);
        emp.getListaServicos().add(sv);
        
        boolean expResult = true;
        boolean result = emp.confirmaExistenciaServicoByID(servID);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getClienteByEmail da classe Empresa.
     */
    @Test
    public void testGetClienteByEmail() {
        System.out.println("Conseguir Cliente pelo E-mail");
        String email = "emailTeste";
        
        Empresa emp= new Empresa();
        Cliente c1 = new Cliente();
        c1.setEmail(email);
        emp.getListaClientes().add(c1);
        
        Cliente expResult = c1;
        Cliente result = emp.getClienteByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getPrestadorByEmail da classe Empresa.
     */
    @Test
    public void testGetPrestadorByEmail() {
        System.out.println("Conseguir Prestador pelo E-mail");
        String email = "emailTeste";
        
        Empresa emp = new Empresa();
        PrestadorServico ps = new PrestadorServico();
        ps.setEmail(email);
        emp.getListaPrestadores().add(ps);
        
        PrestadorServico expResult = ps;
        PrestadorServico result = emp.getPrestadorByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getPrestadorByMecanografico da classe Empresa.
     */
    @Test
    public void testGetPrestadorByMecanografico() {
        System.out.println("Conseguir Prestador pelo nº Mecanográfico");
        String mecanografico = "num";
        
        Empresa emp = new Empresa();
        PrestadorServico ps = new PrestadorServico();
        ps.setMecanografico(mecanografico);
        emp.getListaPrestadores().add(ps);
        
        PrestadorServico expResult = ps;
        PrestadorServico result = emp.getPrestadorByMecanografico(mecanografico);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getAdminByEmail da classe Empresa.
     */
    @Test
    public void testGetAdminByEmail() {
        System.out.println("Conseguir Administrativo pelo E-mail");
        String email = "email";
        Empresa emp = new Empresa();
        Administrativo ad = new Administrativo();
        ad.setEmail(email);
        emp.getListaAdmins().add(ad);
        
        Administrativo expResult = ad;
        Administrativo result = emp.getAdminByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getUtilizadorByEmail da classe Empresa.
     */
    @Test
    public void testGetUtilizadorByEmail() {
        System.out.println("Conseguir Utilizador pelo E-mail");
        String email = "emailTeste";
        
        Empresa emp = new Empresa();
        Administrativo ad = new Administrativo();
        ad.setEmail(email);
        emp.getListaAdmins().add(ad);
        
        Utilizador expResult = ad;
        Utilizador result = emp.getUtilizadorByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getServicoByServID da classe Empresa.
     */
    @Test
    public void testGetServicoByServID() {
        System.out.println("Conseguir Serviço pelo ID");
        String servID = "idTESTE";
        
        Empresa emp = new Empresa();
        Servico sv = new Servico();
        sv.setServID(servID);
        emp.getListaServicos().add(sv);
        
        Servico expResult = sv;
        Servico result = emp.getServicoByServID(servID);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getPedidoByNumero da classe Empresa.
     */
    @Test
    public void testGetPedidoByNumero() {
        System.out.println("Conseguir Pedido pelo Número atríbuido");
        int numero = 3;
        
        Empresa emp = new Empresa();
        PedidoPrestacaoServico pps = new PedidoPrestacaoServico(new Servico(),new Data(), new Tempo(), new Tempo(), "desc", 45.5, new EnderecoPostal("endereco","cidade",new CodigoPostal()));
        PedidoPrestacaoServico pps2 = new PedidoPrestacaoServico();
        emp.adicionarPedido(pps);
        emp.adicionarPedido(pps2);
        
        PedidoPrestacaoServico expResult = pps2;
        PedidoPrestacaoServico result = emp.getPedidoByNumero(numero);
        
        assertEquals(expResult, result);
    }
}

package project2;

import project2.Atleta;
import project2.ClubeDesportivo;
import project2.AtletaPro;
import project2.AtletaSemi;
import java.util.ArrayList;
import java.util.List;
import org.dei.biblioteca.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ClubeDesportivoTest {
    
    public ClubeDesportivoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Teste1 para retornar nome do clube
     */
    @Test
    public void test1GetNomeClube() {
        System.out.println("\nTeste retornar nome clube");
        Data dataTeste1 =  new Data(1994, 7, 01);
        ClubeDesportivo instance = new ClubeDesportivo("Monster Yamaha", dataTeste1);
        String expResult = "Monster Yamaha";
        String result = instance.getNomeClube();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste2 para retornar nome do clube
     */
    @Test
    public void test2GetNomeClube() {
        System.out.println("\nTeste retornar nome clube");
        Data dataTeste2 =  new Data(1934, 10, 20);
        ClubeDesportivo instance = new ClubeDesportivo("Pittsburgh Penguins", dataTeste2);
        String expResult = "Pittsburgh Penguins";
        String result = instance.getNomeClube();
        assertEquals(expResult, result);
    }

    /**
     * Teste1 para adicionar um atleta profissional ao clube
     */
    @Test
    public void testProAdicionarAtleta() {
        System.out.println("\nTeste adicionar atleta");
        AtletaPro proTeste = new AtletaPro("Valentino", 654677901, "masculino", 40, "corrida", 34, 3000, 1500);
        AtletaPro proTeste2 = new AtletaPro("Valente", 654677444, "masculino", 45, "corrida", 39, 3023, 1212);
        ClubeDesportivo instance = new ClubeDesportivo();
        
        List<Atleta> atletas = instance.getListaAtletas();
        atletas.add(proTeste);
        
        instance.adicionarAtleta(proTeste2);
        
        assertEquals(proTeste2, atletas.get(atletas.size() - 1));
    }
    
    /**
     * Teste2 para adicionar um atleta semi profissional ao clube
     */
    @Test
    public void testSemiAdicionarAtleta() {
        System.out.println("\nTeste adicionar atleta");
        AtletaSemi semiTeste = new AtletaSemi("Valentino", 654677901, "masculino", 40, "corrida", 34, 3000, 1500);
        AtletaSemi semiTeste2 = new AtletaSemi("Valente", 654677444, "masculino", 45, "corrida", 39, 3023, 1212);
        ClubeDesportivo instance = new ClubeDesportivo();
        
        List<Atleta> atletas = instance.getListaAtletas();
        atletas.add(semiTeste);
        
        instance.adicionarAtleta(semiTeste2);
        
        assertEquals(semiTeste2, atletas.get(atletas.size() - 1));
    }

    /**
     * Teste para listar os atletas ordenados alfabeticamente
     */
    @Test
    public void testListarAtletas() {
        System.out.println("\nTeste listar alfabeticamente");
        AtletaPro proTeste1 = new AtletaPro("Maria", 654677901, "feminino", 40, "corrida", 34, 3000, 1500);
        AtletaPro proTeste2 = new AtletaPro("Lucia", 109776456, "feminino", 20, "corrida", 34, 2000, 1500);
        AtletaPro proTeste3 = new AtletaPro("Ana", 654677901, "feminino", 40, "corrida", 34, 1000, 1500);
        AtletaPro proTeste4 = new AtletaPro("Tatiana", 109776456, "feminino", 20, "corrida", 34, 500, 1500);
        ClubeDesportivo instance = new ClubeDesportivo();
        
        
        instance.adicionarAtleta(proTeste1);
        instance.adicionarAtleta(proTeste2);
        instance.adicionarAtleta(proTeste3);
        instance.adicionarAtleta(proTeste4);
        
        instance.ordenarAtletasNome();
        
        List<Atleta> atletas = new ArrayList<>();
        
        atletas.add(proTeste3);
        atletas.add(proTeste2);
        atletas.add(proTeste1);
        atletas.add(proTeste4);
        
        assertEquals(instance.getListaAtletas(), atletas);
    }
}

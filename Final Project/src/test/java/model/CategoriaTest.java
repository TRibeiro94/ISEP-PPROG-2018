package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class CategoriaTest {
    
    public CategoriaTest() {
    }

    /**
     * Teste do método equals da classe Categoria.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals (duas categorias");
        Categoria  cat = new Categoria("ID_TESTE", "categoria_limpeza");
        Categoria cat2 = new Categoria("ID_TESTE", "categoria_limpeza");
        
        boolean expResult = true;
        boolean result = cat.equals(cat2);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método equals da classe Categoria.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals (duas categorias");
        Categoria  cat = new Categoria("ID_TESTE", "categoria_limpeza");
        Categoria cat2 = new Categoria("ID_TESTE_DIFERENTE", "categoria_NAOlimpeza");
        
        boolean expResult = false;
        boolean result = cat.equals(cat2);
        
        assertEquals(expResult, result);
    }    
}

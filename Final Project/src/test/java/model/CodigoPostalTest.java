package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class CodigoPostalTest {
    
    public CodigoPostalTest() {
    }

    /**
     * Teste do método equals da classe CodigoPostal.
     */
    @Test
    public void testEquals() {
        System.out.println("equals (dois códigos-postais");
        
        Object outroObjecto = new CodigoPostal("1234-567", "46.1345", "45.65432");
        CodigoPostal cod = new CodigoPostal("1234-567", "46.1345", "45.65432");
        
        boolean expResult = true;
        boolean result = cod.equals(outroObjecto);
        assertEquals(expResult, result);
    }
}

package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class EnderecoPostalTest {
    
    public EnderecoPostalTest() {
    }

    /**
     * Teste do método equals da classe EnderecoPostal.
     */
    @Test
    public void testEquals() {
        System.out.println("equals (dois endereços postais");
        
        Object outroObjecto = new EnderecoPostal("moradaTeste", "localidadeTeste", new CodigoPostal("4433-123", "23.2323", "45.2221"));
        EnderecoPostal end = new EnderecoPostal("moradaTeste", "localidadeTeste", new CodigoPostal("4433-123", "23.2323", "45.2221"));
        
        boolean expResult = true;
        boolean result = end.equals(outroObjecto);
        
        assertEquals(expResult, result);
    }
}

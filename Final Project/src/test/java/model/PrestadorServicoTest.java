package model;

import Utils.Data;
import Utils.Tempo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class PrestadorServicoTest {
    
    public PrestadorServicoTest() {
    }

    /**
     * Teste do método adicionarDisponibilidade da classe PrestadorServico.
     */
    @Test
    public void testAdicionarDisponibilidade() {
        System.out.println("Adicionar Disponibilidade");
        
        Disponibilidade disp = new Disponibilidade(new Data(1994, 7, 1), new Data( 1994, 10, 26), new Tempo(10), new Tempo(12));
        PrestadorServico prestador = new PrestadorServico("Valentino", "vale@", "valePass", "vale@inst", "Valentino R.", "46", new AreaGeografica());
        prestador.adicionarDisponibilidade(disp);
        
        assertEquals(disp, prestador.getListaDisponibilidade().get(0));
    }

    /**
     * Teste do método adicionarAreaGeografica da classe PrestadorServico.
     */
    @Test
    public void testAdicionarAreaGeografica() {
        System.out.println("Adicionar Área Geográfica");
        
        AreaGeografica area = new AreaGeografica("Milano", 94, new CodigoPostal("4100-001","43.144464","-8.612311"));
        PrestadorServico prestador = new PrestadorServico();
        prestador.adicionarAreaGeografica(area);
        
        assertEquals(area, prestador.getListaAreas().get(0));
    }
}

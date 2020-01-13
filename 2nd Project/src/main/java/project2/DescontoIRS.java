package project2;
/**
 *
 * @author Tiago Soares (1181444)
 */
public interface DescontoIRS {
    /**
     * Taxa de IRS a aplicarao salário bruto de um atleta.
     *
     * @return o valor do desconto mensal de um IRS.
     */
    double taxaImutavelIRS = 0.10;
    /**
     * Método que calcula o desconto de IRS de um atleta.
     *
     * @return o valor do desconto mensal de um IRS.
     */    
    public double valorDoDesconto();
}

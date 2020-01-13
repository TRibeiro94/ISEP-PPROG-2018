package Utils;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class Utilitarios {

    /**
     * Verifica se uma String é convertível para um inteiro
     * @param string a ser convertida
     * @return true, se a String for convertível
     *         false, se a String não for convertível
     */
    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Calcula a distância entre dois pontos definidos pelas suas coordenadas
     * (shortest distance over the earth’s surface)
     * https://www.movable-type.co.uk/scripts/latlong.html
     * @param lat1 latitude do primeiro ponto
     * @param lon1 longitude do primeiro ponto
     * @param lat2 latitude do segundo ponto
     * @param lon2 longitude do segundo ponto
     * @return distancia em metros entre dois pontos
     */
    public static double distancia(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371e3;
        double x = lat2 - lat1;
        double y = lon2 - lon1;
        double theta1 = Math.toRadians(lat1);
        double theta2 = Math.toRadians(lat2);
        double deltaTheta = Math.toRadians(x);
        double deltaLambda = Math.toRadians(y);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2) + Math.cos(theta1) * Math.cos(theta2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        return d;
    }
    
    /**
     * Permite calcular o custo de um pedido de prestação de serviço com base no custo do mesmo e total de horas requisitadas pelo Cliente
     * @param hora1 hora de inicio do serviço
     * @param hora2 hora de término do serviço
     * @param custoServico custo p/hora do serviço
     * @return custo de um pedido de prestação de serviço
     */
    public static double calculoDoCusto(int hora1, int hora2, double custoServico){
        
        int diferencaHoras = Math.abs (hora1 - hora2);
        double custo = (diferencaHoras * custoServico);  
        
        return custo;
    }
}

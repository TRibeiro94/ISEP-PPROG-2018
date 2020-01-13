package model;

import java.io.Serializable;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class CodigoPostal implements Serializable{
    /**
     * Código-Postal do endereço
     */
    private String codPostal;
    /**
     * Latitude do Código-Postal
     */
    private String latitude;
    /**
     * Longitude do Código-Postal
     */
    private String longitude;
    /**
     * Código-Postal do endereço por omissão
     */
    private static final String COD_POSTAL_POR_OMISSAO = "sem Código-Postal";
    /**
     * Latitude do Código-postal por omissão
     */
    private static final String LATITUDE_POR_OMISSAO = "0";
    /**
     * Longitude do Código-Postal por omissão
     */
    private static final String LONGITUDE_POR_OMISSAO = "0";
    
    /**
     * Constrói uma instância de CódigoPostal que recebe o código-postal, sua latitude e longitude
     * @param codPostal Código-Postal do endereço
     * @param latitude latitude do código-postal
     * @param longitude longitude do código-postal
     */
    public CodigoPostal(String codPostal, String latitude, String longitude){
        this.codPostal = codPostal;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    /**
     * Constrói uma instância de CodigoPostal que é cópia de uma instância CodigoPostal passada por parâmetro
     * @param outroCodigo CodigoPostal 
     */
    public CodigoPostal(CodigoPostal outroCodigo){
        this.codPostal = outroCodigo.codPostal;
        this.latitude = outroCodigo.latitude;
        this.longitude = outroCodigo.longitude;
    }
    /**
     * Constrói uma instância de CodigoPostal com os valores por omissão
     */
    public CodigoPostal(){
        codPostal = COD_POSTAL_POR_OMISSAO;
        latitude = LATITUDE_POR_OMISSAO;
        longitude = LONGITUDE_POR_OMISSAO;
    }
    /**
     * Devolve o Código-postal do endereço
     * @return código-postal
     */
    public String getCodPostal(){
        return codPostal;
    }
    /**
     * Devolve a Latitude do código-postal
     * @return latitude do código-postal
     */
    public String getLatitude(){
        return latitude;
    }
    /**
     * Devolve a Longitude do código-postal
     * @return longitude do código-postal
     */
    public String getLongitude(){
        return longitude;
    }
    /**
     * Modifica o código-postal do endereço
     * @param codPostal código-postal do endereço
     */
    public void setCodPostal(String codPostal){
        if(codPostal == null || codPostal.isEmpty())
            throw new IllegalArgumentException("O argumento 'código-postal' não deve estar vazio ou ser nulo");
        this.codPostal = codPostal;
    }
    /**
     * Modifica a latitude do código-postal
     * @param latitude latitude do código-postal
     */
    public void setLatitude(String latitude){
        if(latitude == null || latitude.isEmpty())
            throw new IllegalArgumentException("O argumento 'latitude' não deve estar vazio ou ser nulo");
        this.latitude = latitude;
    }
    /**
     * Modifica a longitude do código-postal
     * @param longitude longitude do código-postal
     */
    public void setLongitude(String longitude){
        if(longitude == null || longitude.isEmpty())
            throw new IllegalArgumentException("O argumento 'longitude' não deve estar vazio ou ser nulo");
        this.longitude = longitude;
    }
    /**
     * Modifica os atributos de uma instância de CodigoPostal
     * @param codPostal código-postal do endereço
     * @param latitude latitude do código-postal
     * @param longitude longitude do código-postal
     */
    public void setCodigoPostal(String codPostal, String latitude, String longitude){
        if(codPostal == null || codPostal.isEmpty() || latitude == null || latitude.isEmpty() || longitude == null || longitude.isEmpty())
            throw new IllegalArgumentException("Os argumentos de código-postal(código, latitude e longitude) não deve estar vazio ou ser nulo");
        this.codPostal = codPostal;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Compara dois objectos CodigoPostal através do código-postal, latitude e longitude
     * sendo os objectos considerados iguais apenas quando estas 3 características forem iguais
     * @param outroObjecto objecto que vai ser comparado com o objecto que chama o método
     * @return true, se as referências dos objectos a ser comparados apontam para o mesmo objecto
     *         false, se o objecto comparado for nulo ou as classes dos dois objectos forem diferentes
     *         true, se código-postal, latitude e longitude dos dois objectos forem iguais
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }
        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        CodigoPostal outroCodigo = (CodigoPostal) outroObjecto;
            return this.codPostal.equalsIgnoreCase(outroCodigo.codPostal)
                && this.latitude.equalsIgnoreCase(outroCodigo.latitude)
                && this.longitude.equalsIgnoreCase(outroCodigo.longitude);
    }
    
    /**
     * Devolve as características do CodigoPostal (codigo, latitude e longitude)
     * @return 
     */
    @Override
    public String toString(){
        return String.format("CP:%s Latitude: %s / Longitude: %s",codPostal, latitude, longitude);
    }
}

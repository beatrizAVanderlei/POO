/** Classe para objetos do tipo ConversaoDeUnidadesDeTempo
 * @author ana beatriz
 */
public class ConversaoDeUnidadesDeTempo {

    /** Método para a conversão de unidades de tempo, recebendo um valor em minutos e convertendo para segundos
     * @author ana beatriz
     * @param minutos - tempo em minutos
     * @return - valor da conversão de tempo em segundos
     */

    public double segundos (double minutos){
        return minutos * 60;
    }

    /** Método para a conversão de unidades de tempo, recebendo um valor em horas e convertendo para minutos
     * @author ana beatriz
     * @param horas - tempo em horas
     * @return - valor da conversão de tempo em minutos
     */

    public double minutos (double horas){
        return horas * 60;
    }

    /** Método para a conversão de unidades de tempo, recebendo um valor em dias e convertendo para horas
     * @author ana beatriz
     * @param dias - tempo em dias
     * @return - valor da conversão de tempo em horas
     */

    public double horas (double dias){
        return dias * 24;
    }

    /** Método para a conversão de unidades de tempo, recebendo um valor em semanas e convertendo para quantidade de dias na semana
     * @author ana beatriz
     * @param semanas - tempo em semanas
     * @return - valor da conversão de tempo em dias da semana
     */

    public double diasDaSemana (double semanas){
        return semanas * 7;
    }

    /** Método para a conversão de unidades de tempo, recebendo um valor em meses e convertendo para quantidade de dias nos meses
     * @author ana beatriz
     * @param meses - tempo em meses
     * @return - valor da conversão de tempo em dias do mês
     */

    public double diasDoMes (double meses){
        return meses * 30;
    }

    /** Método para a conversão de unidades de tempo, recebendo um valor em ano(s) e convertendo para dias do(s) ano(s)
     * @author ana beatriz
     * @param anos - tempo em anos
     * @return - valor da conversão de tempo em dias do(s) ano(s)
     */

    public double diasDoAno (double anos){
        return anos * 365.25;
    }
}

import java.util.Map;

public class Moneda {
    private String moneda;
    private Map<String, Double> tasaDeCambio;

    public Moneda(MonedaAPI monedaAPI){
        this.moneda = monedaAPI.base_code();
        this.tasaDeCambio = monedaAPI.conversion_rates();
    }


    public double getTasa(String monedaDeseada){
        return tasaDeCambio.get(monedaDeseada);

    }
}

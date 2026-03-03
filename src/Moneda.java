import java.util.Map;

public class Moneda {
    private String moneda;
    private Map<String, Double> tasaDeCambio;

    public Moneda(MonedaAPI monedaAPI){
        if (monedaAPI.result().equalsIgnoreCase("error")){
            throw new RuntimeException("La moneda base no esta disponible o no existe.");
        }

        this.moneda = monedaAPI.base_code();
        this.tasaDeCambio = monedaAPI.conversion_rates();
    }


    public double getTasa(String monedaDeseada){
        if (!tasaDeCambio.containsKey(monedaDeseada)){
            throw new RuntimeException("la moneda eligida no esta disponible o no es valida");
        }
        return tasaDeCambio.get(monedaDeseada);

    }
}

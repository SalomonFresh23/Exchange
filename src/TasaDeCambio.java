import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TasaDeCambio {

    public static double obtenerTasa(String json, String monedaDeseada) throws IOException, InterruptedException {

        Gson gson = new Gson();
        MonedaAPI monedaAPI = gson.fromJson(json, MonedaAPI.class);
        Moneda moneda = new Moneda(monedaAPI);
        return moneda.getTasa(monedaDeseada);

    }

}

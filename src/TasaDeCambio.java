import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TasaDeCambio {

    public double obtenerTasa(String monedaBase, String monedaDeseada) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/0bbcfab4be3c88be6cc33301/latest/"+monedaBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        MonedaAPI monedaAPI = gson.fromJson(response.body(), MonedaAPI.class);
        Moneda moneda = new Moneda(monedaAPI);
        return moneda.getTasa(monedaDeseada);

    }
}

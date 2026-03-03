import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

    public String obtenerJson(String monedaBase) throws InterruptedException, IOException {

    String apiKey = System.getenv("API_KEY");

            String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/" + monedaBase;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        return response.body();
        }

}

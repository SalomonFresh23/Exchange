import java.sql.Connection;
import java.util.Map;

public record MonedaAPI(String base_code, Map<String,Double> conversion_rates) {


}

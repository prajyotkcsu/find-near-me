package findnearme.findnearme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "restaurants")
public class RestaurantES {
    @Id
    private String id;
    private String name;
    private String category;
    @JsonProperty("full_address")
    private String fullAddress;
    private Pin pin;

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Pin {
    private GeoPoint location;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class GeoPoint {
    private double lat;
    private double lon;
}

package findnearme.findnearme.controllers;

import findnearme.findnearme.model.RestaurantDB;
import findnearme.findnearme.repositories.RestaurantDBRespository;
import findnearme.findnearme.service.CSVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/api/place")
@Slf4j
public class Controller {
    @Autowired
    private RestaurantDBRespository restaurantDBRepository;
    @Autowired
    CSVService csvService;

    @PostMapping("/_upload")
    public void createRestaurant(@RequestBody RestaurantDB restaurant){

        restaurantDBRepository.save(restaurant);
    }
    @PostMapping("/_bulk")
    public void createRestaurants() throws IOException {
        String filename="C:\\beast2023\\projects\\discovery_app\\dataset\\restaurants.csv";
        int recordCount=csvService.csvToDatabase(filename);//this method read csv and write it to a database.
        log.info("{} records saved to DB",recordCount);

    }
    @GetMapping("/_search")
    public void searchRestuarant(){

            String BASE_URL = "http://your-elasticsearch-host:9200";

                RestTemplate restTemplate = new RestTemplate();
                String url = BASE_URL + "/clinic/_search";
                HttpHeaders headers = new HttpHeaders();
                // Add any headers if needed
                HttpEntity<String> requestEntity = new HttpEntity<>(headers);
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, requestEntity);
                String responseBody = responseEntity.getBody();
                // Process the response body
                System.out.println(responseBody);
            }
        }


    /**
     * this api returns top 5 restaurants near you that offers any one of the food within the category
     * input payload-> float lat, float long, List<String>foodMetadata
     * same input-> 12.32, 53.56, [noodles, asian, thai]
     * sample output-> restaurant name: full address
     */


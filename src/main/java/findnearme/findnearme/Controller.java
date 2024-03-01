package findnearme.findnearme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/place")
public class Controller {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/create")
    public void createRestaurant(@RequestBody Restaurant restaurant){
        int zip=94542;
        System.out.println(zip%3);
        restaurantRepository.save(restaurant);
    }
    /**
     * this api returns top 5 restaurants near you that offers any one of the food within the category
     * input payload-> float lat, float long, List<String>foodMetadata
     * same input-> 12.32, 53.56, [noodles, asian, thai]
     * sample output-> restaurant name: full address
     */
//    @GetMapping("/search")
//    public void searchRestaurants(
//            @RequestParam String category,
//            @RequestParam Double lat,
//            @RequestParam Double lon) {
//        GeoPoint location = new GeoPoint(33.00167393830364, -96.70512880312421);
//
//        // Define the search query
//        SearchQuery query = new NativeSearchQueryBuilder()
//                .withFilter(QueryBuilders.geoDistanceQuery("pin.location").point(location).distance("4km"))
//                .build();
//
//        // Execute the search query using the repository
//        return restaurantRepository.search(query);
//        //return restaurantRepository.findByCategoryAndLocation(category, lat, lon);
//    }
}
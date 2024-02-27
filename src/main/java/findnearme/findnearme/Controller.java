package findnearme.findnearme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/place")
public class Controller {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/create")
    public void insertPlace(@RequestBody Restaurant locationDetails){
        restaurantRepository.save(locationDetails);
    }
    /**
     * this api returns top 5 restaurants near you that offers any one of the food within the category
     * input payload-> float lat, float long, List<String>foodMetadata
     * same input-> 12.32, 53.56, [noodles, asian, thai]
     * sample output-> restaurant name: full address
     */
    @GetMapping("/search")
    public void searchRestaurants(
            @RequestParam String category,
            @RequestParam Double lat,
            @RequestParam Double lon) {
        //return restaurantRepository.findByCategoryAndLocation(category, lat, lon);
    }
}
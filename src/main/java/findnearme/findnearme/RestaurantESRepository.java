package findnearme.findnearme;


import findnearme.findnearme.model.RestaurantES;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RestaurantESRepository extends ElasticsearchRepository<RestaurantES, String> {

}

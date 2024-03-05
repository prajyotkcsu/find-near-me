package findnearme.findnearme.repositories;

import findnearme.findnearme.model.RestaurantDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDBRespository extends JpaRepository<RestaurantDB, Long> {

}

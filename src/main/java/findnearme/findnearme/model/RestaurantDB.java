package findnearme.findnearme.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "restaurants")
public class RestaurantDB {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    @SequenceGenerator(name = "restaurant_seq", sequenceName = "restaurant_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    private String name;
    private String[] category;
    private String fullAddress;
    private String city;
    private String state;
    private String pin;
    private String lat;
    private String lon;
}

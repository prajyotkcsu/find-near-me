package findnearme.findnearme.service;

import findnearme.findnearme.model.RestaurantDB;
import findnearme.findnearme.repositories.RestaurantDBRespository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@Slf4j
public class CSVService {
    @Autowired
    private RestaurantDBRespository repository;

    public int csvToDatabase(String filePath) throws IOException {
        log.info("Inside method");
        RestaurantDB restaurantDB=new RestaurantDB();
        File file= new File(filePath);
        int recordCount=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                CSVParser csvParser = CSVFormat.DEFAULT.parse(reader); // Use appropriate CSVFormat based on your CSV file structure
                for (CSVRecord csvRecord : csvParser) {
                    restaurantDB.setName(csvRecord.get(2));
                    restaurantDB.setCategory(csvRecord.get(5).split(","));
                    String[] fullAddress=csvRecord.get(7).split(",");
                    String city="";
                    String state="";
                    if(fullAddress.length>4) {
                        city = fullAddress[fullAddress.length - 3];
                        state = fullAddress[fullAddress.length - 2];
                    }
                    restaurantDB.setCity(city);
                    restaurantDB.setState(state);
                    restaurantDB.setFullAddress(csvRecord.get(7));
                    restaurantDB.setPin(csvRecord.get(8));
                    restaurantDB.setLat(csvRecord.get(9));
                    restaurantDB.setLon(csvRecord.get(10));
                    repository.save(restaurantDB);
                    recordCount++;
                }
            }
        return recordCount;
        }
}

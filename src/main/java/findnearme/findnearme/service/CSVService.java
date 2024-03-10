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
import java.util.UUID;

@Service
@Slf4j
public class CSVService {
    @Autowired
    private RestaurantDBRespository repository;

    public int csvToDatabase(String filePath) throws IOException {
        log.info("Inside method");

        File file= new File(filePath);
        int recordCount=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                CSVParser csvParser = CSVFormat.DEFAULT.parse(reader); // Use appropriate CSVFormat based on your CSV file structure
                for (CSVRecord csvRecord : csvParser) {
                    RestaurantDB restaurantDB=new RestaurantDB();
                    restaurantDB.setName(csvRecord.get(2));
                    restaurantDB.setCategory(csvRecord.get(5).split(","));
                    String[] fullAddress=csvRecord.get(7).split(",");
                    if (fullAddress.length>1){
                        String state = fullAddress[fullAddress.length - 2].trim();
                        if(state.length()==2)
                            restaurantDB.setState(state);
                    }
                    else{continue;}
                    restaurantDB.setFullAddress(csvRecord.get(7));
                    restaurantDB.setPin(csvRecord.get(8));
                    restaurantDB.setLat(csvRecord.get(9));
                    restaurantDB.setLon(csvRecord.get(10));
                    log.info("{} saving to db",restaurantDB);
                    repository.save(restaurantDB);
                    if(recordCount==10)break;
                    recordCount++;

                }
            }
        return recordCount;
        }
}

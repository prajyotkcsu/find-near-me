package findnearme.findnearme;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ElasticsearchService {

    private final String elasticsearchUrl = "https://localhost:9200"; // Adjust the URL based on your Elasticsearch server configuration

    private final RestTemplate restTemplate;

    public ElasticsearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public boolean isElasticsearchUp() {
        try {
            HttpHeaders headers = new HttpHeaders();
//            String username = "elastic";
//            String password = "-uFsO4tlbjOjrBWgWAJR";
//            String credentials = username + ":" + password;
//            String base64Credentials = new String(java.util.Base64.getEncoder().encode(credentials.getBytes()));
//            headers.set("Authorization", "Basic " + base64Credentials);

            //headers.setBasicAuth("elastic","-uFsO4tlbjOjrBWgWAJR");
            String username = "elastic";
            String password = "-uFsO4tlbjOjrBWgWAJR";
            headers.setBasicAuth(username, password);
            ResponseEntity<String> response = restTemplate.exchange(
                    elasticsearchUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    String.class
            );
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            // Handle exception (e.g., log it)
            return false;
        }
    }
}

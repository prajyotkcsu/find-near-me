package findnearme.findnearme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.File;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    private RestTemplate createRestTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setBufferRequestBody(false);

        // Load the certificate file
        String certificateFilePath = "classpath:cert/http_ca.crt";  // Adjust the path as needed

        // Set up SSL context with the certificate
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(new File(certificateFilePath))
                    .build();
            requestFactory.setSSLSocketFactory(sslContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();  // Handle exception appropriately
        }

        return new RestTemplate(requestFactory);
    }

}

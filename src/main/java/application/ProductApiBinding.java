package application;

//this is the class that binds to selected services

import application.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductApiBinding {

    public ApiResponseMessage<Product> delete(Long productID) {
        return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
    }

    public ApiResponseMessage<Product> get(Long productID) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://93fbc6fb-4202-4913-8666-fb7fed1ab335-bluemix.cloudant.com/product/{productID}";
        Product product = restTemplate.getForObject(url, Product.class, productID);

        return new ApiResponseMessage<>(HttpStatus.OK, "", product);
    }

    public ApiResponseMessage<Product> update(Long productID, String productName) {
        return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
    }
}

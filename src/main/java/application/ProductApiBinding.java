package application;

//this is the class that binds to selected services
import application.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductApiBinding {

    @Value("${product.ws.endpoint}")
    private String productEndpoint;

    public ApiResponseMessage<Product> delete(Long productID) {
        return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
    }

    public ApiResponseMessage<Product> get(Long productID) {
        RestTemplate restTemplate = new RestTemplate();

        Product newProduct = restTemplate.getForObject(productEndpoint, Product.class, productID);
        return new ApiResponseMessage<>(HttpStatus.OK, "", newProduct);
    }

    public ApiResponseMessage<Product> update(Long productID, String productName) {
        return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
    }
}

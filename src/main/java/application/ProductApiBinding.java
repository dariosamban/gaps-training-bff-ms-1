package application;

//this is the class that binds to selected services
import application.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ProductApiBinding {

    public ApiResponseMessage<Product> delete(Long productID) {
        return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
    }

    public ApiResponseMessage<Product> get(Long productID) {
        Product product = new Product();
        product.setIdentifier(1L);
        product.setName("Baby Back Ribbs");
        return new ApiResponseMessage<>(HttpStatus.OK, "", product);
    }

    public ApiResponseMessage<Product> update(Long productID, String productName) {
        return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
    }
}

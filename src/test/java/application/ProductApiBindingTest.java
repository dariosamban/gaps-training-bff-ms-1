package application;

import application.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = io.swagger.Swagger2SpringBoot.class)
public class ProductApiBindingTest {

    @Autowired
    private ProductApiController productApiController;

    Long productId = 123L;
    String productName = "producto";

    @Test
    public void delete() {
    }

    @Test
    public void get() throws Exception {
        ResponseEntity<Product> productResponseEntityExpected = new ResponseEntity<Product>(setUpProduct(),
                HttpStatus.OK);
        assertEquals(productResponseEntityExpected, productApiController.get(productId, "application/json"));
    }

    @Test
    public void getShouldFailedWhenProductsAreDifferent() throws Exception {
        ResponseEntity<Product> productResponseEntity = new ResponseEntity<Product>(setUpProduct(), HttpStatus.OK);
        assertNotEquals(productResponseEntity, productApiController.get(1245L, ""));
    }

    @Test
    public void update() {
    }

    public Product setUpProduct() {
        return new Product().name(productName).identifier(productId);
    }
}

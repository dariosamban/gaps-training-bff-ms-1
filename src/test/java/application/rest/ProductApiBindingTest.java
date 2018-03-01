package application.rest;

import application.ApiResponseMessage;
import application.ProductApiBinding;
import application.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = io.swagger.Swagger2SpringBoot.class)
public class ProductApiBindingTest {

    @Autowired
    ProductApiBinding productApiBinding;

    long productId = 1L;

    @Before
    public void setUp() {
    }

    @Test
    public void getShouldNotReturnNull() {
        ApiResponseMessage<Product> product = productApiBinding.get(productId);
        Assert.assertNotNull(product);
    }

    @Test
    public void getProductIdOneShouldReturnChurro() {
        long productId = 1L;

        ApiResponseMessage<Product> product = productApiBinding.get(productId);
        String expectedResult = "churro";
        String actualResult = product.getData().getName();

        Assert.assertEquals(expectedResult,actualResult);
    }
}

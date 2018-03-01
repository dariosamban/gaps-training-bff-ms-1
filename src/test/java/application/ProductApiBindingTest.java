package application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = io.swagger.Swagger2SpringBoot.class)
public class ProductApiBindingTest {

    @Autowired
    private ProductApiBinding productApiBinding;

    @Test
    public void getCallShouldReturnOKStatus() throws Exception {
        assertEquals(HttpStatus.OK, productApiBinding.get(1L).getCode());
    }

    @Test
    public void getCallShouldReturnOneProduct() throws Exception {
        assertNotNull(productApiBinding.get(1L).getData());
    }
}
package application;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class ProductApiBindingTest {
    private ProductApiBinding productApiBinding;

    @Before
    public void setUp() throws Exception {
        productApiBinding = new ProductApiBinding();
    }

    @Test
    public void getCallShouldReturnOKStatus() throws Exception {
        assertEquals(HttpStatus.OK, productApiBinding.get(1L).getCode());
    }

    @Test
    public void getCallShouldReturnOneProduct() throws Exception {
        assertNotNull(productApiBinding.get(1L).getData());
    }
}
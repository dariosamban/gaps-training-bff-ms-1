package application;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

/**
 * Created by croci on 01/03/2018.
 */
public class ProductApiBindingTest {
    private ProductApiBinding productApiBinding;

    @Before
    public void setUp() throws Exception {
        productApiBinding = new ProductApiBinding();
    }

    @Test
    public void getCallShouldReturnOKStatus() throws Exception {
        assertEquals(HttpStatus.OK, productApiBinding.get(001L).getCode());
    }

}
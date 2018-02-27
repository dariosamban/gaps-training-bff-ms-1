package application.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import application.ProductApiController;
import application.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.assertTrue;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by rizzog on 27/2/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes=io.swagger.Swagger2SpringBoot.class)
public class ProductApiControllerTest {

    @Autowired
    private ProductApiController productApiController;

    private MockMvc mockMvc;

    @Before
    public void setUpMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productApiController).build();
    }



    @Test
    public void testControllerMethodGet () throws Exception {
        ResponseEntity responseEntity = productApiController.get((long) 2,"");
        assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);

    }

    @Test
    public void testControllerMethodDelete () throws Exception {
        ResponseEntity responseEntity = productApiController.delete((long) 2,"");
        assertEquals(responseEntity.getStatusCode(),HttpStatus.BAD_REQUEST);

    }

    @Test
    public void testControllerMethodUpdate () throws Exception {
        ResponseEntity responseEntity = productApiController.update((long) 2,"Name","");
        assertEquals(responseEntity.getStatusCode(),HttpStatus.BAD_REQUEST);

    }



}




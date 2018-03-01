package application.rest;

import application.ProductApiController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes=io.swagger.Swagger2SpringBoot.class)
public class ProductApiBindingTests {

    private String endpoint = "https://93fbc6fb-4202-4913-8666-fb7fed1ab335-bluemix.cloudant.com/product/1";

    @Autowired
    private TestRestTemplate server;

    @Autowired
    private ProductApiController productApiController;

    private MockMvc mockMvc;

    @Before
    public void setUpMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productApiController).build();
    }

    @Test
    public void testEndpointResponseStatus() throws Exception {
        mockMvc.perform(get(endpoint).accept("application/json")).andExpect(content().string("{\"identifier\":1,\"name\":\"churro\"}"));
    }

    @Test
    public void testControllerMethodGet() throws Exception {
        ResponseEntity responseEntity = productApiController.get(2L, "");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

}



// https://93fbc6fb-4202-4913-8666-fb7fed1ab335-bluemix.cloudant.com/product/_all_docs?include_docs=true
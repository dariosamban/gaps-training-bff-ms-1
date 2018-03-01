package application.rest;

import application.ProductApiController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = io.swagger.Swagger2SpringBoot.class)
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
    public void testControllerMethodGet() throws Exception {
        ResponseEntity responseEntity = productApiController.get(2L, "");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testControllerMethodDelete() throws Exception {
        ResponseEntity responseEntity = productApiController.delete(2L, "");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testControllerMethodUpdate() throws Exception {
        ResponseEntity responseEntity = productApiController.update(2L, "Name", "");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testEndpointResponseStatus() throws Exception {
        mockMvc.perform(get("/product/1").accept("application/json")).andExpect(status().isOk());
    }

    @Test
    public void testEndpointResponseContent() throws Exception {
        mockMvc.perform(get("/product/1").accept("application/json")).andExpect(
                content().json("{\n" + "   \"identifier\": 1,\n" + "   \"name\": \"Baby Back Ribbs\"\n" + "}"));
    }

}

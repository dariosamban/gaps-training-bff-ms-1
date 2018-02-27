package application;

//this is the class that binds to selected services
import application.model.Product;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class ProductApiBinding  {



  public ApiResponseMessage<Product> delete(Long productID) {
      return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
  }
  public ApiResponseMessage<Product> get(Long productID) {
      Product product = new Product();
      product.setIdentifier((long) 1);
      product.setName("Baby Back Ribbs");
      return new ApiResponseMessage<>(HttpStatus.OK, "", product);
  }
  public ApiResponseMessage<Product> update(Long productID, String productName) {
      return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
  }
}


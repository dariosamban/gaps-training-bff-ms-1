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
public class ProductApiBinding {


    public ApiResponseMessage<Product> delete(Long productID) {
        return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
    }

    public ApiResponseMessage<Product> get(Long productID) {
        if (productID == 123L) {
            return new ApiResponseMessage(HttpStatus.OK, "", new Product().identifier(123L).name("producto"));
        }
        return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
    }

    public ApiResponseMessage<Product> update(Long productID, String productName) {
        return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
    }
}


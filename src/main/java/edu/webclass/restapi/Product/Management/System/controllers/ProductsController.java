package edu.webclass.restapi.Product.Management.System.controllers;

import edu.webclass.restapi.Product.Management.System.models.Product;
import edu.webclass.restapi.Product.Management.System.models.dto.ProductDto;
import edu.webclass.restapi.Product.Management.System.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductDto> listAllProducts() {
        return productService.findAllProducts().stream().map(product -> new ProductDto(product)).toList();
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        boolean isAdded = productService.addProduct(product.getTitle(), product.getBrand(), product.getPrice());
        if (isAdded) {
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        List<ProductDto> productDtos = products.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        Optional<Product> productOpt = productService.findById(id);
        if (!productOpt.isPresent()) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("error!", "Product with ID '" + id + "' not found.");
            return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
        }

        Product product = productOpt.get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}


//    @GetMapping("/{id}")
//    public ResponseEntity<ProductDto> getProductById(@PathVariable String id) {
//        Optional<Product> product = productService.findById(id);
//        return product
//                .map(value -> new ResponseEntity<>(new ProductDto(value), HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }


//    @GetMapping("/test")
//    public ResponseEntity<ProductDto> getTestProduct() {
//        Optional<Product> product = productService.findById("شناسه‌ای-که-وجود-دارد");
//        return product
//                .map(value -> new ResponseEntity<>(new ProductDto(value), HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }



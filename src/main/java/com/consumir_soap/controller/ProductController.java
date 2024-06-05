package com.consumir_soap.controller;

import com.consumir_soap.client.SoapClient;
import com.consumir_soap.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumir")
public class ProductController {
    @Autowired
    private SoapClient soapClient;

    @PostMapping("/agregar")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        PostProductResponse postProductResponse = soapClient.postProduct(product);

        return ResponseEntity.ok().body(postProductResponse);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> deleteProduct(@RequestParam int id){
        DeleteProductResponse deleteProductResponse = soapClient.deleteProduct(id);

        return ResponseEntity.ok().body(deleteProductResponse);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> findProduct(@RequestParam String producto){
        GetProductResponse getProductResponse = soapClient.getProduct(producto);

        return ResponseEntity.ok().body(getProductResponse);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> showProducts(){
        GetProductsResponse getProductsResponse = soapClient.getProducts();

        return ResponseEntity.ok().body(getProductsResponse);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        UpdateProductResponse updateProductResponse = soapClient.updateProduct(product);

        return ResponseEntity.ok().body(updateProductResponse);
    }
}

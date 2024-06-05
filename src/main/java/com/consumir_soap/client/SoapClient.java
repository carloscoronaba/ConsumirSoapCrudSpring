package com.consumir_soap.client;

import com.consumir_soap.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {

    public PostProductResponse postProduct(Product product){
        PostProductRequest postProductRequest = new PostProductRequest();
        postProductRequest.setProduct(product);

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.example.com/demosoap/gen/postProductRequest");

        PostProductResponse postProductResponse =
                (PostProductResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws",postProductRequest,soapActionCallback);

        return postProductResponse;
    }

    public GetProductResponse getProduct(String producto) {
        GetProductRequest getProductRequest = new GetProductRequest();
        getProductRequest.setName(producto);

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.example.com/demosoap/gen/getProductRequest");

        GetProductResponse getProductResponse =
                (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws",getProductRequest,soapActionCallback);

        return  getProductResponse;
    }

    public GetProductsResponse getProducts(){
        GetProductsRequest getProductsRequest = new GetProductsRequest();

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.example.com/demosoap/gen/getProductsRequest");

        GetProductsResponse getProductsResponse =
                (GetProductsResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws", getProductsRequest, soapActionCallback);

        return getProductsResponse;
    }


    public UpdateProductResponse updateProduct(Product product){
        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setProduct(product);

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.example.com/demosoap/gen/updateProductRequest");

        UpdateProductResponse updateProductResponse =
                (UpdateProductResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws",updateProductRequest,soapActionCallback);

        return updateProductResponse;
    }

    public DeleteProductResponse deleteProduct(int id){
        DeleteProductRequest deleteProductRequest = new DeleteProductRequest();
        deleteProductRequest.setId(id);

        SoapActionCallback soapActionCallback =
                new SoapActionCallback("http://www.example.com/demosoap/gen/deleteProductRequest");

        DeleteProductResponse deleteProductResponse =
                (DeleteProductResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws",deleteProductRequest,soapActionCallback);

        return deleteProductResponse;

    }


}

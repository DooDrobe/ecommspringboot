package com.appdev.app.controller;

import com.appdev.app.entity.PrdCategory;
import com.appdev.app.service.EcommService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/rest/api/ecomm")
public class EcommController {
    @Autowired
    private EcommService ecommService;

    //save operation
    @PostMapping(value="/save")
    public ResponseEntity<String> save(@RequestBody PrdCategory prdCategory){
        ResponseEntity<String> responseEntity = null;

        try{
            Integer res = ecommService.saveProduct(prdCategory);
            responseEntity = new ResponseEntity<String>("EcommProduct '"+res+"' Created", HttpStatus.OK);

        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    //update product
    @PutMapping(value="/update")
    public ResponseEntity<String> update(@RequestBody PrdCategory prdCategory){
        ResponseEntity<String> responseEntity = null;
        boolean prdAvail = ecommService.isAvailable(prdCategory.getIdCtgr());

        if(prdAvail){
            ecommService.update(prdCategory);
            responseEntity = new ResponseEntity<String>("Update data succes",HttpStatus.OK);

        }else {
            responseEntity = new ResponseEntity<String>("Product '"+prdCategory.getName()+ "' not exist",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //Delete
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;

        boolean prdAvail = ecommService.isAvailable(id);
        if(prdAvail){
            ecommService.delete(id);
            responseEntity = new ResponseEntity<String>("Delete '"+id+ "' success",HttpStatus.OK);


        }else {
            responseEntity = new ResponseEntity<String>("Product '"+id+ "' not exist",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //Retrive product
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<String> getEcommProductById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        if(ecommService.isAvailable(id)){
           PrdCategory oneProduct = ecommService.getProduct(id);
            responseEntity = new ResponseEntity<PrdCategory>(oneProduct,HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity<String>("Product '"+id+ "' not exist",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //Retrive all product
    @GetMapping(value = "/getAllEcommProduct")
    public ResponseEntity<String> getAllEcommProduct(){
        ResponseEntity responseEntity = null;
        List<PrdCategory> allProduct = ecommService.getAllProduct();
        log.debug("Something show bro");
        if(allProduct.isEmpty()){
            String message = "No Data Found";
            responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity<List<PrdCategory>>(allProduct,HttpStatus.OK);
        }
        return responseEntity;
    }

}

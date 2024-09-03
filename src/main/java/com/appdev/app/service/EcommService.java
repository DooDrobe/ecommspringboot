package com.appdev.app.service;

import com.appdev.app.entity.PrdCategory;
//import io.swagger.models.auth.In;
//import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface EcommService {
    public Integer saveProduct(PrdCategory prdCategory);
    public void update(PrdCategory prdCategory);
    public void delete(Integer id);
    public  PrdCategory getProduct(Integer id);
    public boolean isAvailable(Integer id);

    public List<PrdCategory> getAllProduct();
}

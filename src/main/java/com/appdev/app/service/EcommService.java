package com.appdev.app.service;

import com.appdev.app.entity.PrdCategory;
import io.swagger.models.auth.In;

public interface EcommService {
    public String saveProduct(PrdCategory prdCategory);
    public void update(PrdCategory prdCategory);
    public void delete(Integer id);
    public  PrdCategory getProduct(Integer id);
    public boolean isAvailable(Integer id);
}

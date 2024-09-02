package com.appdev.app.service;

import com.appdev.app.entity.PrdCategory;
import com.appdev.app.repository.DaoPrdCategory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class EcommServiceImpl implements EcommService{

    @Autowired
    private DaoPrdCategory daoPrdCategory;

    @Override
    @Transactional
    public String saveProduct(PrdCategory prdCategory) {
        return daoPrdCategory.save(prdCategory).getIdCtgr();
    }

    @Override
    @Transactional
    public void update(PrdCategory prdCategory) {
        daoPrdCategory.save(prdCategory);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        daoPrdCategory.deleteById(id);
    }

    @Override
    @Transactional
    public PrdCategory getProduct(Integer id) {
        return daoPrdCategory.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return daoPrdCategory.existsById(id);
    }
}

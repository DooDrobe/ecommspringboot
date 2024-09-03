package com.appdev.app.service;

import com.appdev.app.entity.PrdCategory;
import com.appdev.app.repository.DaoPrdCategory;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcommServiceImpl implements EcommService{

    @Autowired
    private DaoPrdCategory daoPrdCategory;

    @Override
    @Transactional
    public Integer saveProduct(PrdCategory prdCategory) {
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

    @Override
    @Transactional
    public List<PrdCategory> getAllProduct() {
        return daoPrdCategory.findAll();
    }
}

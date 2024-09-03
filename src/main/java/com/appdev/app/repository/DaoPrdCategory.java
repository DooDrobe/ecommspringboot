package com.appdev.app.repository;

import com.appdev.app.entity.PrdCategory;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

//@NoRepositoryBean
//@Repository
public interface DaoPrdCategory extends JpaRepository<PrdCategory, Integer> {
}

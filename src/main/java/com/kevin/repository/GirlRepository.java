package com.kevin.repository;

import com.kevin.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kevin on 2018/1/21.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //按照年龄来查询
    public List<Girl> findGirlByAge(Integer age);
}

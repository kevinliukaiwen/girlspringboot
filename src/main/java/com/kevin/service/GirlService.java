package com.kevin.service;

import com.kevin.domain.Girl;
import com.kevin.enums.ResultEnum;
import com.kevin.exception.GirlException;
import com.kevin.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kevin on 2018/1/21.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(19);
        girlA.setCupSize("F");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(100);
        girlB.setCupSize("GGGGG");
        girlRepository.save(girlB);
    }
    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10) {
            //返回你还在上小学
            throw new GirlException(ResultEnum.PRIMARYY_SCHOOL);
        }else if(age >10 && age < 16) {
            //返回你还在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查找一个女生
     * @param id
     * @return
     */
    public  Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}

package com.kevin.controller;

import com.kevin.domain.Girl;
import com.kevin.domain.Result;
import com.kevin.repository.GirlRepository;
import com.kevin.service.GirlService;
import com.kevin.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by kevin on 2018/1/21.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girllist");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            //获取错误信息
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());

        }
        return ResultUtil.success(girl);
    }

    /**
     * 通过id查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age
    ) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 通过Id删除一个女生
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDeleteOne(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindOneByAge(@PathVariable("age") Integer age) {
        return girlRepository.findGirlByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlInsertTwo() {
        girlService.insertTwo();
    }
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception {
        girlService.getAge(id);
    }
}

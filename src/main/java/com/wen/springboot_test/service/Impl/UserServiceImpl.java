package com.wen.springboot_test.service.Impl;

import com.wen.springboot_test.exception.CheckException;
import com.wen.springboot_test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String throwException(Integer id)   {
        if (id==0) {
            throw new CheckException("已知异常啦");
        }else if (id==1){
            /**
             * 这里出个除以0异常 ，当做一个未知异常
             */
            Integer e=id/0;
        }

        return "这里不出异常";
    }
}

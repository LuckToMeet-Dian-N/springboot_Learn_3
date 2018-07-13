package com.wen.springboot_test.HandlerException;

import com.wen.springboot_test.ResultResponse.ResultBean;
import com.wen.springboot_test.exception.CheckException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理器
 */


@ControllerAdvice
@Slf4j
public class HandlerException {
    /**
     * 处理未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResultBean unknowException(Exception e){
        e.printStackTrace();
        ResultBean resultBean =new ResultBean();
        resultBean.setCode(ResultBean.UNKNOWN_EXCEPTION);
        resultBean.setMsg("系统出现未知异常，请于管理员联系");
        /**
         * 未知异常的话，这里写逻辑，发邮件，发短信都可以、、
         */
        return resultBean;
    }

    /**
     * 处理已知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = CheckException.class)
    @ResponseBody
    public ResultBean handlerCheckException(CheckException e){
        log.info("发生了已知错误："+e.getMessage());
        ResultBean resultBean =new ResultBean();
        resultBean.setCode(ResultBean.CHECK_FAIL);
        resultBean.setMsg(e.getMessage());
        return resultBean;
    }




}

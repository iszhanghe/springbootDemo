package com.ssy.restfuluser.exception;

import com.ssy.restfuluser.bean.RespPack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UnifiedExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(UnifiedExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespPack hanle(Exception e) {

        if (e instanceof UnifiedException) {
            UnifiedException exception = (UnifiedException) e;
            logger.error(((UnifiedException) e).getMsgDetail());
            return RespPack.respPackFail(exception.getCode(), exception.getMessage(), exception.getData());
        }
        logger.error("系统异常：" + e);
        return RespPack.respPackFail(99, e + "");
    }

}

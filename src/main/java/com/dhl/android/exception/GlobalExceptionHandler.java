package com.dhl.android.exception;

import com.dhl.android.utils.Result;
import com.dhl.android.utils.ResultEnum;
import com.dhl.android.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        e.printStackTrace();
        if(e instanceof MyException) {
            MyException myException = (MyException)e;
            return ResultUtil.error(myException.getCode(),myException.getMessage());
        }
//        else if (e instanceof UnauthorizedException){
//            return ResultUtil.error(ResultEnum.ERROR.getCode(),"您没有权限进行该操作");
//        }
        else{
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

}

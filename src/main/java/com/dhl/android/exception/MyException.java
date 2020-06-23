package com.dhl.android.exception;

import com.dhl.android.utils.ResultEnum;

public class MyException extends RuntimeException {

    private static final long serialVersionUID = 5720848396842316463L;

    private int code;

    public MyException(int code, String message ) {
        super(message);
        this.code = code;
    }

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}

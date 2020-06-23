package com.dhl.android.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dhl.android.entity.User;
import com.dhl.android.service.IUserService;
import com.dhl.android.utils.GridResultWrapper;
import com.dhl.android.utils.Result;
import com.dhl.android.utils.ResultEnum;
import com.dhl.android.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dhl
 * @since 2020-06-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;
    @GetMapping("/getUser")
    public Result getUser(){    //普通获取数据
        Result result = ResultUtil.success(userService.list());
        return result;
    }
    @GetMapping("/getUserByPage")
    public Result getUserByPage(int pageNum,int size){  //分页获取数据
        IPage<User> page=new Page<User>(pageNum,size);
        IPage<User> resultPage = userService.page(page);
        GridResultWrapper resultWrapper = new GridResultWrapper(resultPage.getTotal(),resultPage.getRecords() );
        Result result = ResultUtil.success(resultWrapper);
        return result;
    }
    @GetMapping("/login")
    public Result getUserByName(String name,String password){
        final User user = userService.getById(name);
        if (user!=null&&user.getPassword().equals(password))
            return ResultUtil.success();
        return ResultUtil.result(ResultEnum.LOGINERROR);
    }

    @GetMapping("/register")
    public Result register(String name,String password){
        final User user = userService.getById(name);
        if (user==null){
            User registerUser=new User();
            registerUser.setUsername(name);
            registerUser.setPassword(password);
            userService.save(registerUser);
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.ERROR.getCode(),"用户名已被注册");
    }
}

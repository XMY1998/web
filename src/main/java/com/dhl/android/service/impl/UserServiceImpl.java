package com.dhl.android.service.impl;

import com.dhl.android.entity.User;
import com.dhl.android.mapper.UserMapper;
import com.dhl.android.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dhl
 * @since 2020-06-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

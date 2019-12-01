package com.nx.service.impl;

import com.nx.bean.MSecUsrDef;
import com.nx.dao.IUserDao;
import com.nx.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao iUserDao;

    public MSecUsrDef getUserInfo(MSecUsrDef user) {
        return iUserDao.selectByPrimaryKey(user.getId());
    }
}

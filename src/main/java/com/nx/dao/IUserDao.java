package com.nx.dao;

import com.nx.bean.MSecUsrDef;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MSecUsrDef record);

    int insertSelective(MSecUsrDef record);

    MSecUsrDef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MSecUsrDef record);

    int updateByPrimaryKey(MSecUsrDef record);
}
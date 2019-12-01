package com;

import com.nx.bean.MSecUsrDef;
import com.nx.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);

    @Resource
    private IUserService userService = null;

    @Test
    public void test1() {
        MSecUsrDef userOld = new MSecUsrDef();
        userOld.setId(1);
        MSecUsrDef user = userService.getUserInfo(userOld);

        System.out.println(user.getUserId());
        logger.info("值："+user.getUserId());
    }
}

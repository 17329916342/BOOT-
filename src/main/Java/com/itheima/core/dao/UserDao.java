package com.itheima.core.dao;

import com.itheima.core.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * �û�DAO��ӿ�
 */
public interface UserDao {
    /**
     * ͨ���˺ź������ѯ�û�
     */
    User findUser(@Param("usercode") String usercode, @Param("password") String password);
}


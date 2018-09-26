package com.friend.spider.service.user.impl;

import com.friend.spider.common.DatabaseEnum;
import com.friend.spider.dao.BaseDao;
import com.friend.spider.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fyc
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Map<String, Object>> getListById(long id) {
        return baseDao.getListByKey(DatabaseEnum.a.name(),"user","*","id",""+id);
    }
}

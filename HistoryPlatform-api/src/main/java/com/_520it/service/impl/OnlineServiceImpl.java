package com._520it.service.impl;

import com._520it.mapper.OnlineMapper;
import com._520it.pojo.KindsUser;
import com._520it.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/25.
 */
@Service
public class OnlineServiceImpl implements OnlineService {

    @Autowired
    private OnlineMapper onlineMapper;

    public List<KindsUser> queryOnlineDoctors() {
        return onlineMapper.queryOnlineDoctors();
    }
}

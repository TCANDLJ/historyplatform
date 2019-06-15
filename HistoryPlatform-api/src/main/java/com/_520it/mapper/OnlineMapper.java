package com._520it.mapper;

import com._520it.pojo.KindsUser;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/25.
 */
public interface OnlineMapper {
    /**
     * 查询在线医生
     * @return
     */
    List<KindsUser> queryOnlineDoctors();
}

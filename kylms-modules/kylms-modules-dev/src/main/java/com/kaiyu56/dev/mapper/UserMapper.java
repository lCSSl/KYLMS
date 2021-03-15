package com.kaiyu56.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaiyu56.dev.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select u.user_id,u.username,d.u_value u_status from t_user u left join t_dict d on u.u_status = d.u_status")
    public List<User> queryUserStatus();
}

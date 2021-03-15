package com.kaiyu56.dev.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: cssly
 * @date: 2021/3/12 23:16
 */
@TableName("t_user")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String uStatus;
    private String username;
    private Integer uAge;
}

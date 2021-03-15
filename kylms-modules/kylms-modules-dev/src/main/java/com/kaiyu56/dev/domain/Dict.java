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
@TableName("t_dict")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dict {
    private Long dictId;
    private String uStatus;
    private String uValue;
}

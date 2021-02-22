package com.kaiyu56.test.domain;

import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.*;

/**
 * 测试对象 test
 *
 * @author css
 * @date 2021-02-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "test")
@EqualsAndHashCode(callSuper = true)
public class Test extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 标题
     */
    @Excel(name = "标题")
    @TableField(value = "title")
    private String title;
    /**
     * 父级ID
     */
    @Excel(name = "父级ID")
    @TableField(value = "parent_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    @TableField(value = "del_flag")
    private String delFlag;
}

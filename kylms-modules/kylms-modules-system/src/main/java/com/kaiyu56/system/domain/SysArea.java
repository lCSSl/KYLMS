package com.kaiyu56.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 行政区对象 sys_area
 *
 * @author css
 * @date 2021-03-20
 */
public class SysArea extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 代码
     */
    @Excel(name = "代码")
    private Long code;

    /**
     * 名
     */
    @Excel(name = "名")
    private String name;

    /**
     * 父级代码
     */
    @Excel(name = "父级代码")
    private Long parentCode;

    /**
     * 等级
     */
    @Excel(name = "等级")
    private Long level;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParentCode(Long parentCode) {
        this.parentCode = parentCode;
    }

    public Long getParentCode() {
        return parentCode;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getLevel() {
        return level;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("code", getCode())
                .append("name", getName())
                .append("parentCode", getParentCode())
                .append("level", getLevel())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("status", getStatus())
                .toString();
    }
}

package com.kaiyu56.wms.api.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;
import lombok.*;

import java.math.BigDecimal;

/**
 * 货物对象 wms_cargo
 *
 * @author css
 * @date 2021-04-01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WmsCargo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID--序号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long cargoId;

    /**
     * 编码
     */
    @Excel(name = "编码")
    private String cargoCode;

    /**
     * 品名
     */
    @Excel(name = "品名")
    private String cargoName;

    /**
     * 包装方式
     */
    @Excel(name = "包装方式")
    private String packageType;

    /**
     * 计价方式
     */
    @Excel(name = "计价方式")
    private String valuationType;

    /**
     * 计价值
     */
    @Excel(name = "计价值")
    private BigDecimal valuationValue;

    /**
     * 贵重货物
     */
    @Excel(name = "贵重货物")
    private String valuable;

    /**
     * 异形货物
     */
    @Excel(name = "异形货物")
    private String irregular;

    /**
     * 货物单据
     */
    @Excel(name = "货物单据")
    private String documents;

    /**
     * 客户ID
     */
    @Excel(name = "客户ID")
    private Long csrId;

    /**
     * 客户公司ID
     */
    @Excel(name = "客户公司ID")
    private Long deptId;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 删除标志
     */
    private String delFlag;

}

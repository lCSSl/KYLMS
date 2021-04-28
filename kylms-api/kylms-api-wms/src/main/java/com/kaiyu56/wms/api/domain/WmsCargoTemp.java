package com.kaiyu56.wms.api.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kaiyu56.common.core.annotation.Excel;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 运单货物临时表对象 wms_cargo_temp
 *
 * @author css
 * @date 2021-04-01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WmsCargoTemp extends WmsCargo {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID--序号
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 品名
     */
    @Excel(name = "品名")
    private String tCargoName;

    /**
     * 件数
     */
    @Excel(name = "件数")
    private Long tCargoCount;

    /**
     * 计量数
     */
    @Excel(name = "计量数")
    private BigDecimal valuationCount;

    /**
     * 基础运费
     */
    @Excel(name = "基础运费")
    private BigDecimal tCargoTotalFee;

    /**
     * 运单ID
     */
    @Excel(name = "运单ID")
    private Long waybillId;
}

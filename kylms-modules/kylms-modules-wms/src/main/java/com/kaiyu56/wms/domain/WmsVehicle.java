package com.kaiyu56.wms.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 运输工具信息主对象 wms_vehicle
 * 
 * @author css
 * @date 2021-03-24
 */
public class WmsVehicle extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long vehicleId;

    /** 编码 */
    @Excel(name = "编码")
    private String vehicleCode;

    /** 牌号 */
    @Excel(name = "牌号")
    private String vehiclePlate;

    /** 类型 */
    @Excel(name = "类型")
    private String vehicleType;

    /** 来源 */
    @Excel(name = "来源")
    private String vehicleSource;

    /** 宽 */
    @Excel(name = "宽")
    private BigDecimal vehicleWidth;

    /** 长 */
    @Excel(name = "长")
    private BigDecimal vehicleLength;

    /** 高 */
    @Excel(name = "高")
    private BigDecimal vehicleHeight;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setVehicleId(Long vehicleId) 
    {
        this.vehicleId = vehicleId;
    }

    public Long getVehicleId() 
    {
        return vehicleId;
    }
    public void setVehicleCode(String vehicleCode) 
    {
        this.vehicleCode = vehicleCode;
    }

    public String getVehicleCode() 
    {
        return vehicleCode;
    }
    public void setVehiclePlate(String vehiclePlate) 
    {
        this.vehiclePlate = vehiclePlate;
    }

    public String getVehiclePlate() 
    {
        return vehiclePlate;
    }
    public void setVehicleType(String vehicleType) 
    {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() 
    {
        return vehicleType;
    }
    public void setVehicleSource(String vehicleSource) 
    {
        this.vehicleSource = vehicleSource;
    }

    public String getVehicleSource() 
    {
        return vehicleSource;
    }
    public void setVehicleWidth(BigDecimal vehicleWidth) 
    {
        this.vehicleWidth = vehicleWidth;
    }

    public BigDecimal getVehicleWidth() 
    {
        return vehicleWidth;
    }
    public void setVehicleLength(BigDecimal vehicleLength) 
    {
        this.vehicleLength = vehicleLength;
    }

    public BigDecimal getVehicleLength() 
    {
        return vehicleLength;
    }
    public void setVehicleHeight(BigDecimal vehicleHeight) 
    {
        this.vehicleHeight = vehicleHeight;
    }

    public BigDecimal getVehicleHeight() 
    {
        return vehicleHeight;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("vehicleId", getVehicleId())
            .append("vehicleCode", getVehicleCode())
            .append("vehiclePlate", getVehiclePlate())
            .append("vehicleType", getVehicleType())
            .append("vehicleSource", getVehicleSource())
            .append("vehicleWidth", getVehicleWidth())
            .append("vehicleLength", getVehicleLength())
            .append("vehicleHeight", getVehicleHeight())
            .append("deptId", getDeptId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

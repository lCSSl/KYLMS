package com.kaiyu56.wms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 运单配载对象 wms_stowage
 * 
 * @author css
 * @date 2021-03-24
 */
public class WmsStowage extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 主键ID--序号 */
    private Long stowageId;

    /** 运单ID */
    @Excel(name = "运单ID")
    private Long waybillId;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 配载编码 */
    @Excel(name = "配载编码")
    private String stowageCode;

    /** 配载站点名 */
    @Excel(name = "配载站点名")
    private Long stowageName;

    /** 配载目的网点 */
    @Excel(name = "配载目的网点")
    private String stowageDestinationNode;

    /** 发车批次 */
    @Excel(name = "发车批次")
    private String departureCode;

    /** 发车司机ID */
    @Excel(name = "发车司机ID")
    private Long departureDriverId;

    /** 发车司机名 */
    @Excel(name = "发车司机名")
    private String departureDriverName;

    /** 发车车ID */
    @Excel(name = "发车车ID")
    private Long departureVehicleId;

    /** 发车车编码 */
    @Excel(name = "发车车编码")
    private String departureVehicleCode;

    /** 发车车牌号 */
    @Excel(name = "发车车牌号")
    private String departureVehiclePlate;

    /** 发车时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发车时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureTime;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setStowageId(Long stowageId) 
    {
        this.stowageId = stowageId;
    }

    public Long getStowageId() 
    {
        return stowageId;
    }
    public void setWaybillId(Long waybillId) 
    {
        this.waybillId = waybillId;
    }

    public Long getWaybillId() 
    {
        return waybillId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setStowageCode(String stowageCode) 
    {
        this.stowageCode = stowageCode;
    }

    public String getStowageCode() 
    {
        return stowageCode;
    }
    public void setStowageName(Long stowageName) 
    {
        this.stowageName = stowageName;
    }

    public Long getStowageName() 
    {
        return stowageName;
    }
    public void setStowageDestinationNode(String stowageDestinationNode) 
    {
        this.stowageDestinationNode = stowageDestinationNode;
    }

    public String getStowageDestinationNode() 
    {
        return stowageDestinationNode;
    }
    public void setDepartureCode(String departureCode) 
    {
        this.departureCode = departureCode;
    }

    public String getDepartureCode() 
    {
        return departureCode;
    }
    public void setDepartureDriverId(Long departureDriverId) 
    {
        this.departureDriverId = departureDriverId;
    }

    public Long getDepartureDriverId() 
    {
        return departureDriverId;
    }
    public void setDepartureDriverName(String departureDriverName) 
    {
        this.departureDriverName = departureDriverName;
    }

    public String getDepartureDriverName() 
    {
        return departureDriverName;
    }
    public void setDepartureVehicleId(Long departureVehicleId) 
    {
        this.departureVehicleId = departureVehicleId;
    }

    public Long getDepartureVehicleId() 
    {
        return departureVehicleId;
    }
    public void setDepartureVehicleCode(String departureVehicleCode) 
    {
        this.departureVehicleCode = departureVehicleCode;
    }

    public String getDepartureVehicleCode() 
    {
        return departureVehicleCode;
    }
    public void setDepartureVehiclePlate(String departureVehiclePlate) 
    {
        this.departureVehiclePlate = departureVehiclePlate;
    }

    public String getDepartureVehiclePlate() 
    {
        return departureVehiclePlate;
    }
    public void setDepartureTime(Date departureTime) 
    {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime() 
    {
        return departureTime;
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
            .append("stowageId", getStowageId())
            .append("waybillId", getWaybillId())
            .append("deptId", getDeptId())
            .append("stowageCode", getStowageCode())
            .append("stowageName", getStowageName())
            .append("stowageDestinationNode", getStowageDestinationNode())
            .append("departureCode", getDepartureCode())
            .append("departureDriverId", getDepartureDriverId())
            .append("departureDriverName", getDepartureDriverName())
            .append("departureVehicleId", getDepartureVehicleId())
            .append("departureVehicleCode", getDepartureVehicleCode())
            .append("departureVehiclePlate", getDepartureVehiclePlate())
            .append("departureTime", getDepartureTime())
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

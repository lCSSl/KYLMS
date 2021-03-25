package com.kaiyu56.wms.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 货物对象 wms_cargo
 * 
 * @author css
 * @date 2021-03-24
 */
public class WmsCargo extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long cargoId;

    /** 编码 */
    @Excel(name = "编码")
    private String cargoCode;

    /** 品名 */
    @Excel(name = "品名")
    private String cargoName;

    /** 单件重量 */
    @Excel(name = "单件重量")
    private BigDecimal cargoWeight;

    /** 单件重量 */
    @Excel(name = "单件重量")
    private BigDecimal cargoVolume;

    /** 贵重货物 */
    @Excel(name = "贵重货物")
    private String valuable;

    /** 异形货物 */
    @Excel(name = "异形货物")
    private String irregular;

    /** 货物单据 */
    @Excel(name = "货物单据")
    private String documents;

    /** 包装方式 */
    @Excel(name = "包装方式")
    private String packageType;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long csrId;

    /** 部门ID-客户公司 */
    @Excel(name = "部门ID-客户公司")
    private Long deptId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 删除标志 */
    private String delFlag;

    public void setCargoId(Long cargoId) 
    {
        this.cargoId = cargoId;
    }

    public Long getCargoId() 
    {
        return cargoId;
    }
    public void setCargoCode(String cargoCode) 
    {
        this.cargoCode = cargoCode;
    }

    public String getCargoCode() 
    {
        return cargoCode;
    }
    public void setCargoName(String cargoName) 
    {
        this.cargoName = cargoName;
    }

    public String getCargoName() 
    {
        return cargoName;
    }
    public void setCargoWeight(BigDecimal cargoWeight) 
    {
        this.cargoWeight = cargoWeight;
    }

    public BigDecimal getCargoWeight() 
    {
        return cargoWeight;
    }
    public void setCargoVolume(BigDecimal cargoVolume) 
    {
        this.cargoVolume = cargoVolume;
    }

    public BigDecimal getCargoVolume() 
    {
        return cargoVolume;
    }
    public void setValuable(String valuable) 
    {
        this.valuable = valuable;
    }

    public String getValuable() 
    {
        return valuable;
    }
    public void setIrregular(String irregular) 
    {
        this.irregular = irregular;
    }

    public String getIrregular() 
    {
        return irregular;
    }
    public void setDocuments(String documents) 
    {
        this.documents = documents;
    }

    public String getDocuments() 
    {
        return documents;
    }
    public void setPackageType(String packageType) 
    {
        this.packageType = packageType;
    }

    public String getPackageType() 
    {
        return packageType;
    }
    public void setCsrId(Long csrId) 
    {
        this.csrId = csrId;
    }

    public Long getCsrId() 
    {
        return csrId;
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
            .append("cargoId", getCargoId())
            .append("cargoCode", getCargoCode())
            .append("cargoName", getCargoName())
            .append("cargoWeight", getCargoWeight())
            .append("cargoVolume", getCargoVolume())
            .append("valuable", getValuable())
            .append("irregular", getIrregular())
            .append("documents", getDocuments())
            .append("packageType", getPackageType())
            .append("csrId", getCsrId())
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

package com.kaiyu56.wms.api.domain;

import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 站点(仓库)信息对象 wms_warehouse
 *
 * @author css
 * @date 2021-03-22
 */
public class WmsWarehouse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 站点ID
     */
    private Long warehouseId;

    /**
     * 站点编码
     */
    @Excel(name = "站点编码")
    private String warehouseCode;

    /**
     * 站点名
     */
    @Excel(name = "站点名")
    private String warehouseName;

    /**
     * 站点主管
     */
    @Excel(name = "站点主管")
    private Long warehouseInCharge;

    /**
     * 站点类型
     */
    @Excel(name = "站点类型")
    private String warehouseType;

    /**
     * 站点面积
     */
    @Excel(name = "站点面积")
    private Long warehouseArea;

    /**
     * 站点面积长
     */
    @Excel(name = "站点面积长")
    private Long warehouseAreaX;

    /**
     * 站点面积宽
     */
    @Excel(name = "站点面积宽")
    private Long warehouseAreaY;

    /**
     * 站点详细地址
     */
    @Excel(name = "站点详细地址")
    private String warehouseAddress;

    /**
     * 省市区街道
     */
    @Excel(name = "省市区街道")
    private String provinceCityDistrictStreet;

    /**
     * 省代码
     */
    @Excel(name = "省代码")
    private Long provinceCode;

    /**
     * 市代码
     */
    @Excel(name = "市代码")
    private Long cityCode;

    /**
     * 区代码
     */
    @Excel(name = "区代码")
    private Long districtCode;

    /**
     * 街道代码
     */
    @Excel(name = "街道代码")
    private Long streetCode;

    /**
     * 部门ID
     */
    @Excel(name = "部门ID")
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

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseInCharge(Long warehouseInCharge) {
        this.warehouseInCharge = warehouseInCharge;
    }

    public Long getWarehouseInCharge() {
        return warehouseInCharge;
    }

    public void setWarehouseType(String warehouseType) {
        this.warehouseType = warehouseType;
    }

    public String getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseArea(Long warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public Long getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseAreaX(Long warehouseAreaX) {
        this.warehouseAreaX = warehouseAreaX;
    }

    public Long getWarehouseAreaX() {
        return warehouseAreaX;
    }

    public void setWarehouseAreaY(Long warehouseAreaY) {
        this.warehouseAreaY = warehouseAreaY;
    }

    public Long getWarehouseAreaY() {
        return warehouseAreaY;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setProvinceCityDistrictStreet(String provinceCityDistrictStreet) {
        this.provinceCityDistrictStreet = provinceCityDistrictStreet;
    }

    public String getProvinceCityDistrictStreet() {
        return provinceCityDistrictStreet;
    }

    public void setProvinceCode(Long provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Long getProvinceCode() {
        return provinceCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }

    public Long getDistrictCode() {
        return districtCode;
    }

    public void setStreetCode(Long streetCode) {
        this.streetCode = streetCode;
    }

    public Long getStreetCode() {
        return streetCode;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("warehouseId", getWarehouseId())
                .append("warehouseCode", getWarehouseCode())
                .append("warehouseName", getWarehouseName())
                .append("warehouseInCharge", getWarehouseInCharge())
                .append("warehouseType", getWarehouseType())
                .append("warehouseArea", getWarehouseArea())
                .append("warehouseAreaX", getWarehouseAreaX())
                .append("warehouseAreaY", getWarehouseAreaY())
                .append("warehouseAddress", getWarehouseAddress())
                .append("provinceCityDistrictStreet", getProvinceCityDistrictStreet())
                .append("provinceCode", getProvinceCode())
                .append("cityCode", getCityCode())
                .append("districtCode", getDistrictCode())
                .append("streetCode", getStreetCode())
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

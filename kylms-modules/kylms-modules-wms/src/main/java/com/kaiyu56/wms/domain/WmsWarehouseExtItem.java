package com.kaiyu56.wms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 仓库拓展-仓库方格信息对象 wms_warehouse_ext_item
 *
 * @author css
 * @date 2021-03-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "wms_waybill")
@EqualsAndHashCode(callSuper = true)
public class WmsWarehouseExtItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 仓库方格ID
     */
    private Long itemId;

    /**
     * 仓库ID
     */
    @Excel(name = "仓库ID")
    private Long warehouseId;

    /**
     * 方格横轴
     */
    @Excel(name = "方格横轴")
    private Long itemX;

    /**
     * 方格纵轴
     */
    @Excel(name = "方格纵轴")
    private Long itemY;

    /**
     * 状态（0正常 1禁用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=禁用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public WmsWarehouseExtItem(Long warehouseId, Long itemX, Long itemY, String status) {
        this.warehouseId = warehouseId;
        this.itemX = itemX;
        this.itemY = itemY;
        this.status = status;
    }
    public WmsWarehouseExtItem(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setItemX(Long itemX) {
        this.itemX = itemX;
    }

    public Long getItemX() {
        return itemX;
    }

    public void setItemY(Long itemY) {
        this.itemY = itemY;
    }

    public Long getItemY() {
        return itemY;
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
                .append("itemId", getItemId())
                .append("warehouseId", getWarehouseId())
                .append("itemX", getItemX())
                .append("itemY", getItemY())
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

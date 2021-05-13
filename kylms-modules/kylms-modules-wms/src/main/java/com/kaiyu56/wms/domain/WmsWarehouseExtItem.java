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

    public WmsWarehouseExtItem(Long itemId,String status) {
        this.itemId = itemId;
        this.status = status;
    }
}

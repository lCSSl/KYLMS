package com.kaiyu56.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 运单-仓库方格中间对象 wms_waybill_md_warehouse_ext_item
 * 
 * @author css
 * @date 2021-03-24
 */
public class WmsWaybillMdWarehouseExtItem extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 仓库方格ID */
    @Excel(name = "仓库方格ID")
    private Long itemId;

    /** 运单ID */
    @Excel(name = "运单ID")
    private Long waybillId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setWaybillId(Long waybillId) 
    {
        this.waybillId = waybillId;
    }

    public Long getWaybillId() 
    {
        return waybillId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("waybillId", getWaybillId())
            .toString();
    }
}

package com.kaiyu56.wms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kaiyu56.wms.api.domain.vo.WmsWarehouseLL;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 运单配载线路对象 wms_stowage_route
 *
 * @author css
 * @date 2021-04-08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WmsStowageRoute extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "route_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long routeId;

    /**
     * 配载ID
     */
    @Excel(name = "配载ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stowageId;

    /**
     * 配载站点ID
     */
    @Excel(name = "配载站点ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stowageWarehouseId;

    private WmsWarehouseLL ll;
    /**
     * 配载站点名
     */
    @Excel(name = "配载站点名")
    private String stowageWarehouseName;
    /**
     * 路线排序
     */
    @Excel(name = "路线排序")
    private int routeSort;

    /**
     * 线路节点状态
     */
    @Excel(name = "线路节点状态")
    private String routeStatus;

    /**
     * Next ID
     */
    @TableField(value = "route_next")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long routeNext;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;


    /**
     * 删除标志
     */
    private String delFlag;

    public WmsStowageRoute(Long stowageId, Long stowageWarehouseId, String stowageWarehouseName, int routeSort, String routeStatus, Long routeNext) {

        this(null, stowageId, stowageWarehouseId,null, stowageWarehouseName, routeSort, routeStatus, routeNext ,null, null);
    }

    public WmsStowageRoute(Long routeId, Long stowageId, Long stowageWarehouseId, String stowageWarehouseName, int routeSort, String routeStatus, Long routeNext) {
        this(routeId, stowageId, stowageWarehouseId,null, stowageWarehouseName, routeSort, routeStatus, routeNext, null, null);
        fillBasicAttributes(0);
    }

    public WmsStowageRoute(Long routeId, int routeSort, String routeStatus, Long routeNext) {
        this(routeId, null, null, null,null, routeSort, routeStatus, routeNext, null, null);

    }
}

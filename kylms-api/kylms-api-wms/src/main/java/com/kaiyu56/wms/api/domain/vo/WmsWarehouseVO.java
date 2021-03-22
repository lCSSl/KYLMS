package com.kaiyu56.wms.api.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaiyu56.wms.api.domain.WmsWarehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: cssly
 * @date: 2021/3/22 17:55
 * @description:
 * @url:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WmsWarehouseVO extends WmsWarehouse {
    private String deptName;
    private String warehouseInChargeName;
}

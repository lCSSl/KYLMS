package com.kaiyu56.wms.api.domain.vo;

import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: cssly
 * @date: 2021/3/23 22:32
 * @description:
 * @url:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WmsWaybillVO extends WmsWaybill {
    /**
     * 到达站名
     */
    @Excel(name = "到达站名")
    private String destinationName;
    /**
     * 始发站名
     */
    @Excel(name = "始发站名")
    private String departureName;
}

package com.kaiyu56.wms.api.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: cssly
 * @date: 2021/4/16 22:31
 * @description:
 * @url:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WmsWarehouseLL {
    private BigDecimal lng;
    private BigDecimal lat;
}

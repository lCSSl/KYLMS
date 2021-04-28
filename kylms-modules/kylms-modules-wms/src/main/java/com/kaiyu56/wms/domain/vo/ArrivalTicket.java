package com.kaiyu56.wms.domain.vo;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author: cssly
 * @date: 2021/4/21 0:39
 * @description:
 * @url:
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalTicket {
    private Long routeId;
    private BigDecimal lng;
    private BigDecimal lat;
}

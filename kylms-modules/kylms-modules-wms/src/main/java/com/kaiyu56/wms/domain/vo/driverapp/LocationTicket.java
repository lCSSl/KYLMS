package com.kaiyu56.wms.domain.vo.driverapp;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author cssly
 * @date 2021/4/23
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LocationTicket {
    private Long id;
    private BigDecimal lng;
    private BigDecimal lat;
}

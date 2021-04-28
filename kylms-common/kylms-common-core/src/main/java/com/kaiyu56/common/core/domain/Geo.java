package com.kaiyu56.common.core.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author: cssly
 * @date: 2021/4/21 10:32
 * @description:
 * @url:
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Geo {
    private BigDecimal lng;
    private BigDecimal lat;

    public Geo(String lng, String lat) {
        this.lng = new BigDecimal(lng);
        this.lat = new BigDecimal(lat);
    }

    public Geo(double lng, double lat) {
        this.lng = new BigDecimal(lng);
        this.lat = new BigDecimal(lat);
    }
}

package com.kaiyu56.wms.domain.vo;

import com.kaiyu56.wms.api.domain.vo.AddressVO;
import com.kaiyu56.wms.domain.WmsStowage;
import lombok.*;

/**
 * @author: cssly
 * @date: 2021/4/22 15:12
 * @description:
 * @url:
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WmsStowageVO extends WmsStowage {
    private int routeCount;
    private AddressVO departureAddress;
    private AddressVO destinationAddress;
}

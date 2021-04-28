package com.kaiyu56.wms.domain.vo;

import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import lombok.*;

/**
 * @author cssly
 * @date 2021/4/28
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WmsWaybillPrintVO extends WmsWaybillVO {
    private String qrcodeUrl;
}

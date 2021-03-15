package com.kaiyu56.test.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kaiyu56.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("wms_waybillCargo")
@EqualsAndHashCode(callSuper = true)
public class WaybillCargo extends BaseEntity {
    private Long waybillCargoId;
    private Long waybillId;
    private String waybillCargoName;
    private int waybillCargoCount;
}

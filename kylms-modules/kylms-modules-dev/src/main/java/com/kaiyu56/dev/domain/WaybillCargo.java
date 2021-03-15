package com.kaiyu56.dev.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("wms_waybillCargo")
public class WaybillCargo {
    private Long waybillCargoId;
    private Long waybillId;
    private String waybillCargoName;
    private int waybillCargoCount;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;
}

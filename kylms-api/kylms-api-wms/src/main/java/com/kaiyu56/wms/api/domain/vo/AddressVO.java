package com.kaiyu56.wms.api.domain.vo;

import com.kaiyu56.common.core.annotation.Excel;
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
public class AddressVO {
    /**
     * 省代码
     */
    @Excel(name = "省代码")
    private Long provinceCode;

    /**
     * 市代码
     */
    @Excel(name = "市代码")
    private Long cityCode;

    /**
     * 区代码
     */
    @Excel(name = "区代码")
    private Long districtCode;

    /**
     * 街道代码
     */
    @Excel(name = "街道代码")
    private Long streetCode;

    /**
     * 省代码
     */
    @Excel(name = "省")
    private String province;

    /**
     * 市代码
     */
    @Excel(name = "市")
    private String city;

    /**
     * 区代码
     */
    @Excel(name = "区")
    private String district;

    /**
     * 街道代码
     */
    @Excel(name = "街")
    private String street;
    /**
     * 站点详细地址
     */
    @Excel(name = "站点详细地址")
    private String warehouseAddress;
}

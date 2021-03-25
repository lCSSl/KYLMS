package com.kaiyu56.wms.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 运单拓展信息-费用对象 wms_waybill_ext_settlement
 * 
 * @author css
 * @date 2021-03-24
 */
public class WmsWaybillExtSettlement extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long wbSettlementId;

    /** 运单ID */
    @Excel(name = "运单ID")
    private Long waybillId;

    /** 结算干线费 */
    @Excel(name = "结算干线费")
    private BigDecimal mainFee;

    /** 开单送货费-客户如需送货(不自提) */
    @Excel(name = "开单送货费-客户如需送货(不自提)")
    private BigDecimal deliveryFee;

    /** 结算中转费 */
    @Excel(name = "结算中转费")
    private BigDecimal transferFee;

    /** 结算类型列表
        是否回单-1 是否控货-2 是否保价-3 是否代收-4 是否包装-5
        是否装卸-6 是否进仓-7 是否仓储-8 是否叉车-9 是否上楼-10
        是否报关-11 是否代打木架-12 是否垫付-13 是否控货-14
        是否收其它费-99 */
    @Excel(name = "结算类型列表")
    private String wbSettlementTypes;

    /** 回单费 */
    @Excel(name = "回单费")
    private BigDecimal receiptFee;

    /** 回单要求 */
    @Excel(name = "回单要求")
    private String receiptRequest;

    /** 垫付费 */
    @Excel(name = "垫付费")
    private BigDecimal advanceFee;

    /** 保价费 */
    @Excel(name = "保价费")
    private BigDecimal insuranceFee;

    /** 保险类型 */
    @Excel(name = "保险类型")
    private String insuranceType;

    /** 声明价值 */
    @Excel(name = "声明价值")
    private BigDecimal insuranceDeclaredValue;

    /** 代收手续费 */
    @Excel(name = "代收手续费")
    private BigDecimal collectionFee;

    /** 代收货款 */
    @Excel(name = "代收货款")
    private BigDecimal collectionMoney;

    /** 包装费 */
    @Excel(name = "包装费")
    private BigDecimal packagingFee;

    /** 其它费 */
    @Excel(name = "其它费")
    private BigDecimal otherFee;

    /** 其它费内容 */
    @Excel(name = "其它费内容")
    private String otherFeeContent;

    /** 装卸费 */
    @Excel(name = "装卸费")
    private BigDecimal loadingFee;

    /** 进仓费-送货到电商仓库 */
    @Excel(name = "进仓费-送货到电商仓库")
    private BigDecimal restockingFee;

    /** 仓储费 */
    @Excel(name = "仓储费")
    private BigDecimal storageFee;

    /** 叉车费 */
    @Excel(name = "叉车费")
    private BigDecimal forkliftFee;

    /** 上楼费 */
    @Excel(name = "上楼费")
    private BigDecimal upstairsFee;

    /** 报关费 */
    @Excel(name = "报关费")
    private BigDecimal customsFees;

    /** 代打木架费 */
    @Excel(name = "代打木架费")
    private BigDecimal woodenFrameFee;

    /** 工本费 */
    @Excel(name = "工本费")
    private BigDecimal productionFee;

    /** 信息费 */
    @Excel(name = "信息费")
    private BigDecimal informationFee;

    /** 接货费 */
    @Excel(name = "接货费")
    private BigDecimal receivingCargoFee;

    /** 燃油费 */
    @Excel(name = "燃油费")
    private BigDecimal fuelCostsFee;

    /** 费率 */
    @Excel(name = "费率")
    private BigDecimal rate;

    /** 税金 */
    @Excel(name = "税金")
    private BigDecimal taxesFee;

    /** 改单费 */
    @Excel(name = "改单费")
    private BigDecimal changeWaybillFee;

    /** 其它费用合计 */
    @Excel(name = "其它费用合计")
    private BigDecimal totalOtherFees;

    /** 费用合计 */
    @Excel(name = "费用合计")
    private BigDecimal totalFees;

    public void setWbSettlementId(Long wbSettlementId) 
    {
        this.wbSettlementId = wbSettlementId;
    }

    public Long getWbSettlementId() 
    {
        return wbSettlementId;
    }
    public void setWaybillId(Long waybillId) 
    {
        this.waybillId = waybillId;
    }

    public Long getWaybillId() 
    {
        return waybillId;
    }
    public void setMainFee(BigDecimal mainFee) 
    {
        this.mainFee = mainFee;
    }

    public BigDecimal getMainFee() 
    {
        return mainFee;
    }
    public void setDeliveryFee(BigDecimal deliveryFee) 
    {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getDeliveryFee() 
    {
        return deliveryFee;
    }
    public void setTransferFee(BigDecimal transferFee) 
    {
        this.transferFee = transferFee;
    }

    public BigDecimal getTransferFee() 
    {
        return transferFee;
    }
    public void setWbSettlementTypes(String wbSettlementTypes) 
    {
        this.wbSettlementTypes = wbSettlementTypes;
    }

    public String getWbSettlementTypes() 
    {
        return wbSettlementTypes;
    }
    public void setReceiptFee(BigDecimal receiptFee) 
    {
        this.receiptFee = receiptFee;
    }

    public BigDecimal getReceiptFee() 
    {
        return receiptFee;
    }
    public void setReceiptRequest(String receiptRequest) 
    {
        this.receiptRequest = receiptRequest;
    }

    public String getReceiptRequest() 
    {
        return receiptRequest;
    }
    public void setAdvanceFee(BigDecimal advanceFee) 
    {
        this.advanceFee = advanceFee;
    }

    public BigDecimal getAdvanceFee() 
    {
        return advanceFee;
    }
    public void setInsuranceFee(BigDecimal insuranceFee) 
    {
        this.insuranceFee = insuranceFee;
    }

    public BigDecimal getInsuranceFee() 
    {
        return insuranceFee;
    }
    public void setInsuranceType(String insuranceType) 
    {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() 
    {
        return insuranceType;
    }
    public void setInsuranceDeclaredValue(BigDecimal insuranceDeclaredValue) 
    {
        this.insuranceDeclaredValue = insuranceDeclaredValue;
    }

    public BigDecimal getInsuranceDeclaredValue() 
    {
        return insuranceDeclaredValue;
    }
    public void setCollectionFee(BigDecimal collectionFee) 
    {
        this.collectionFee = collectionFee;
    }

    public BigDecimal getCollectionFee() 
    {
        return collectionFee;
    }
    public void setCollectionMoney(BigDecimal collectionMoney) 
    {
        this.collectionMoney = collectionMoney;
    }

    public BigDecimal getCollectionMoney() 
    {
        return collectionMoney;
    }
    public void setPackagingFee(BigDecimal packagingFee) 
    {
        this.packagingFee = packagingFee;
    }

    public BigDecimal getPackagingFee() 
    {
        return packagingFee;
    }
    public void setOtherFee(BigDecimal otherFee) 
    {
        this.otherFee = otherFee;
    }

    public BigDecimal getOtherFee() 
    {
        return otherFee;
    }
    public void setOtherFeeContent(String otherFeeContent) 
    {
        this.otherFeeContent = otherFeeContent;
    }

    public String getOtherFeeContent() 
    {
        return otherFeeContent;
    }
    public void setLoadingFee(BigDecimal loadingFee) 
    {
        this.loadingFee = loadingFee;
    }

    public BigDecimal getLoadingFee() 
    {
        return loadingFee;
    }
    public void setRestockingFee(BigDecimal restockingFee) 
    {
        this.restockingFee = restockingFee;
    }

    public BigDecimal getRestockingFee() 
    {
        return restockingFee;
    }
    public void setStorageFee(BigDecimal storageFee) 
    {
        this.storageFee = storageFee;
    }

    public BigDecimal getStorageFee() 
    {
        return storageFee;
    }
    public void setForkliftFee(BigDecimal forkliftFee) 
    {
        this.forkliftFee = forkliftFee;
    }

    public BigDecimal getForkliftFee() 
    {
        return forkliftFee;
    }
    public void setUpstairsFee(BigDecimal upstairsFee) 
    {
        this.upstairsFee = upstairsFee;
    }

    public BigDecimal getUpstairsFee() 
    {
        return upstairsFee;
    }
    public void setCustomsFees(BigDecimal customsFees) 
    {
        this.customsFees = customsFees;
    }

    public BigDecimal getCustomsFees() 
    {
        return customsFees;
    }
    public void setWoodenFrameFee(BigDecimal woodenFrameFee) 
    {
        this.woodenFrameFee = woodenFrameFee;
    }

    public BigDecimal getWoodenFrameFee() 
    {
        return woodenFrameFee;
    }
    public void setProductionFee(BigDecimal productionFee) 
    {
        this.productionFee = productionFee;
    }

    public BigDecimal getProductionFee() 
    {
        return productionFee;
    }
    public void setInformationFee(BigDecimal informationFee) 
    {
        this.informationFee = informationFee;
    }

    public BigDecimal getInformationFee() 
    {
        return informationFee;
    }
    public void setReceivingCargoFee(BigDecimal receivingCargoFee) 
    {
        this.receivingCargoFee = receivingCargoFee;
    }

    public BigDecimal getReceivingCargoFee() 
    {
        return receivingCargoFee;
    }
    public void setFuelCostsFee(BigDecimal fuelCostsFee) 
    {
        this.fuelCostsFee = fuelCostsFee;
    }

    public BigDecimal getFuelCostsFee() 
    {
        return fuelCostsFee;
    }
    public void setRate(BigDecimal rate) 
    {
        this.rate = rate;
    }

    public BigDecimal getRate() 
    {
        return rate;
    }
    public void setTaxesFee(BigDecimal taxesFee) 
    {
        this.taxesFee = taxesFee;
    }

    public BigDecimal getTaxesFee() 
    {
        return taxesFee;
    }
    public void setChangeWaybillFee(BigDecimal changeWaybillFee) 
    {
        this.changeWaybillFee = changeWaybillFee;
    }

    public BigDecimal getChangeWaybillFee() 
    {
        return changeWaybillFee;
    }
    public void setTotalOtherFees(BigDecimal totalOtherFees) 
    {
        this.totalOtherFees = totalOtherFees;
    }

    public BigDecimal getTotalOtherFees() 
    {
        return totalOtherFees;
    }
    public void setTotalFees(BigDecimal totalFees) 
    {
        this.totalFees = totalFees;
    }

    public BigDecimal getTotalFees() 
    {
        return totalFees;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wbSettlementId", getWbSettlementId())
            .append("waybillId", getWaybillId())
            .append("mainFee", getMainFee())
            .append("deliveryFee", getDeliveryFee())
            .append("transferFee", getTransferFee())
            .append("wbSettlementTypes", getWbSettlementTypes())
            .append("receiptFee", getReceiptFee())
            .append("receiptRequest", getReceiptRequest())
            .append("advanceFee", getAdvanceFee())
            .append("insuranceFee", getInsuranceFee())
            .append("insuranceType", getInsuranceType())
            .append("insuranceDeclaredValue", getInsuranceDeclaredValue())
            .append("collectionFee", getCollectionFee())
            .append("collectionMoney", getCollectionMoney())
            .append("packagingFee", getPackagingFee())
            .append("otherFee", getOtherFee())
            .append("otherFeeContent", getOtherFeeContent())
            .append("loadingFee", getLoadingFee())
            .append("restockingFee", getRestockingFee())
            .append("storageFee", getStorageFee())
            .append("forkliftFee", getForkliftFee())
            .append("upstairsFee", getUpstairsFee())
            .append("customsFees", getCustomsFees())
            .append("woodenFrameFee", getWoodenFrameFee())
            .append("productionFee", getProductionFee())
            .append("informationFee", getInformationFee())
            .append("receivingCargoFee", getReceivingCargoFee())
            .append("fuelCostsFee", getFuelCostsFee())
            .append("rate", getRate())
            .append("taxesFee", getTaxesFee())
            .append("changeWaybillFee", getChangeWaybillFee())
            .append("totalOtherFees", getTotalOtherFees())
            .append("totalFees", getTotalFees())
            .toString();
    }
}

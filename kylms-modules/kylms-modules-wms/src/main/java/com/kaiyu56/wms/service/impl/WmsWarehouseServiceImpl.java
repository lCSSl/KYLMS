package com.kaiyu56.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.system.api.RemoteDictService;
import com.kaiyu56.system.api.domain.SysDictData;
import com.kaiyu56.wms.api.domain.WmsWarehouse;
import com.kaiyu56.wms.api.domain.vo.WmsWarehouseVO;
import com.kaiyu56.wms.domain.WmsWarehouseExtItem;
import com.kaiyu56.wms.mapper.WmsWarehouseMapper;
import com.kaiyu56.wms.service.IWmsWarehouseExtItemService;
import com.kaiyu56.wms.service.IWmsWarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 站点(仓库)信息Service业务层处理
 *
 * @author css
 * @date 2021-03-22
 */
@Slf4j
@Service
public class WmsWarehouseServiceImpl extends ServiceImpl<WmsWarehouseMapper, WmsWarehouse> implements IWmsWarehouseService {

    @Autowired
    private RemoteDictService remoteDictService;
    @Autowired
    private IWmsWarehouseExtItemService wmsWarehouseExtItemService;

    /**
     * 查询站点(仓库)信息
     *
     * @param warehouseId 站点(仓库)信息ID
     * @return 站点(仓库)信息
     */
    @Override
    public WmsWarehouse selectWmsWarehouseById(Long warehouseId) {
        return baseMapper.selectWmsWarehouseById(warehouseId);
    }

    /**
     * 查询站点(仓库)信息列表
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 站点(仓库)信息
     */
    @Override
    public List<WmsWarehouse> selectWmsWarehouseList(WmsWarehouse wmsWarehouse) {
        return baseMapper.selectWmsWarehouseList(wmsWarehouse);
    }

    @Override
    public List<WmsWarehouseVO> selectWmsWarehouseVOList(WmsWarehouse wmsWarehouse) {
        return baseMapper.selectWmsWarehouseVOList(wmsWarehouse);
    }

    /**
     * 获取站点(仓库)负责人信息
     *
     * @return 获取站点(仓库)负责人信息
     */
    @Override
    public List<Long> selectAllWmsWarehouseInChargeIdList() {
        return baseMapper.selectAllWmsWarehouseInChargeIdList();
    }

    /**
     * 新增站点(仓库)信息
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 结果
     */
    @Override
    public int insertWmsWarehouse(WmsWarehouse wmsWarehouse) {
        BigDecimal areaX = wmsWarehouse.getWarehouseAreaX();
        BigDecimal areaY = wmsWarehouse.getWarehouseAreaY();
        BigDecimal warehouseArea = wmsWarehouse.getWarehouseArea();
        BigDecimal multiply = areaX.multiply(areaY).setScale(2, RoundingMode.CEILING);
        if (warehouseArea.compareTo(multiply) != 0) {
            log.warn("Inconsistent calculation results:warehouseArea:{}--multiply:{}", warehouseArea, multiply);
            wmsWarehouse.setWarehouseArea(multiply);
        } else {
            log.info("area result:{}", warehouseArea);
        }
        return baseMapper.insertWmsWarehouse(wmsWarehouse);
    }

    /**
     * 修改站点(仓库)信息
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 结果
     */
    @Override
    public int updateWmsWarehouse(WmsWarehouse wmsWarehouse) {
        BigDecimal areaX = wmsWarehouse.getWarehouseAreaX();
        BigDecimal areaY = wmsWarehouse.getWarehouseAreaY();
        BigDecimal warehouseArea = wmsWarehouse.getWarehouseArea();
        BigDecimal multiply = areaX.multiply(areaY).setScale(2, RoundingMode.CEILING);
        if (warehouseArea.compareTo(multiply) != 0) {
            log.warn("Inconsistent calculation results:warehouseArea:{}--multiply:{}", warehouseArea, multiply);
            wmsWarehouse.setWarehouseArea(multiply);
        } else {
            log.info("area result:{}", warehouseArea);
        }
        return baseMapper.updateWmsWarehouse(wmsWarehouse);
    }

    /**
     * 批量删除站点(仓库)信息
     *
     * @param warehouseIds 需要删除的站点(仓库)信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseByIds(Long[] warehouseIds) {
        return baseMapper.deleteWmsWarehouseByIds(warehouseIds);
    }

    /**
     * 删除站点(仓库)信息信息
     *
     * @param warehouseId 站点(仓库)信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseById(Long warehouseId) {
        return baseMapper.deleteWmsWarehouseById(warehouseId);
    }

    /**
     * 初始化站点(仓库)方格
     * MM === 毫米
     *
     * @param warehouseId
     * @param dictCode
     * @param trayType
     * @param trayInterval
     * @return
     */
    @Override
    public int initWmsWarehouseExtItem(Long warehouseId, Long dictCode, String trayType, BigDecimal trayInterval) {
        if (trayInterval.compareTo(new BigDecimal(10)) < 0) {
            trayInterval = new BigDecimal(10);
            log.warn("params['trayInterval'] is violation trayInterval must more than the :{}", trayInterval);
        }
        SysDictData sysDictData = remoteDictService.getInfo(dictCode).getData();
        String dictLabel = sysDictData.getDictLabel();
        String[] split = dictLabel.split("\\*");
        BigDecimal split1 = new BigDecimal(split[1]);
        BigDecimal split0 = new BigDecimal(split[0]);
        boolean lengthChoose = split0.compareTo(split1) > 0;
        BigDecimal trayWidthMM = lengthChoose ? split1 : split0;
        BigDecimal trayLengthMM = lengthChoose ? split0 : split1;
        BigDecimal trayArea = trayLengthMM.multiply(trayWidthMM).setScale(2, RoundingMode.CEILING);
        log.error("trayProps:length{}*width{}=area{}", trayLengthMM, trayWidthMM, trayArea);
        WmsWarehouse wmsWarehouse = selectWmsWarehouseById(warehouseId);
        BigDecimal totalAreaMM = wmsWarehouse.getWarehouseArea().multiply(new BigDecimal(1000).multiply(new BigDecimal(1000))).setScale(2, RoundingMode.CEILING);
        BigDecimal areaXMM = wmsWarehouse.getWarehouseAreaX().multiply(new BigDecimal(1000)).setScale(2, RoundingMode.CEILING);
        BigDecimal areaYMM = wmsWarehouse.getWarehouseAreaY().multiply(new BigDecimal(1000)).setScale(2, RoundingMode.CEILING);
        BigDecimal currentMultiply = areaXMM.multiply(areaYMM).setScale(2, RoundingMode.CEILING);
        if (totalAreaMM.compareTo(currentMultiply) != 0) {
            log.warn("Inconsistent calculation results:warehouseArea:{}--multiply:{}", totalAreaMM, currentMultiply);
            wmsWarehouse.setWarehouseArea(currentMultiply);
        } else {
            log.info("area result:{}", totalAreaMM);
        }
        log.warn("areaXMM*areaYMM=totalAreaMM||currentMultiply:{}*{}={}||{},", areaXMM, areaYMM, totalAreaMM, currentMultiply);
        boolean xyFlag = areaXMM.compareTo(areaYMM) > 0;
        BigInteger itemXTotal = (xyFlag
                ? areaXMM.divide(trayLengthMM, 2, RoundingMode.FLOOR)
                : areaXMM.divide(trayWidthMM, 2, RoundingMode.FLOOR)).toBigInteger();
        BigInteger itemYTotal = (!xyFlag
                ? areaYMM.divide(trayLengthMM, 2, RoundingMode.FLOOR)
                : areaYMM.divide(trayWidthMM, 2, RoundingMode.FLOOR)).toBigInteger();
        log.error("total: Array[Y:{}][X:{}]", itemXTotal, itemYTotal);
        int batchTotals=0;
        for (long i = 0l; i < itemYTotal.longValue(); i++) {
            List<WmsWarehouseExtItem> list = new ArrayList<>();
            for (long j = 0l; j < itemXTotal.longValue(); j++) {
                list.add(new WmsWarehouseExtItem(warehouseId, j, i, "0"));
            }
            batchTotals+=wmsWarehouseExtItemService.batchInsertWmsWarehouseExtItem(list);
        }
        wmsWarehouse.setWarehouseMaxX(itemXTotal.intValue());
        wmsWarehouse.setWarehouseMaxY(itemYTotal.intValue());
        baseMapper.updateWmsWarehouse(wmsWarehouse);
        log.error("batchTotals: {}",batchTotals);
        return batchTotals;
    }
}

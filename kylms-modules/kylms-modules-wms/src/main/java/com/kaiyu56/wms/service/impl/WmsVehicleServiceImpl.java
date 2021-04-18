package com.kaiyu56.wms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.wms.api.domain.vo.WmsVehicleLL;
import com.kaiyu56.wms.domain.WmsVehicle;
import com.kaiyu56.wms.enums.WmsVehicleStatus;
import com.kaiyu56.wms.mapper.WmsVehicleMapper;
import com.kaiyu56.wms.service.IWmsVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 运输工具信息主Service业务层处理
 *
 * @author css
 * @date 2021-03-24
 */
@Service
public class WmsVehicleServiceImpl extends ServiceImpl<WmsVehicleMapper,WmsVehicle> implements IWmsVehicleService {

    /**
     * 查询运输工具信息主
     *
     * @param vehicleId 运输工具信息主ID
     * @return 运输工具信息主
     */
    @Override
    public WmsVehicle selectWmsVehicleById(Long vehicleId) {
        return baseMapper.selectWmsVehicleById(vehicleId);
    }

    /**
     * 查询运输工具信息主列表
     *
     * @param wmsVehicle 运输工具信息主
     * @return 运输工具信息主
     */
    @Override
    public List<WmsVehicle> selectWmsVehicleList(WmsVehicle wmsVehicle) {
        return baseMapper.selectWmsVehicleList(wmsVehicle);
    }

    /**
     * 新增运输工具信息主
     *
     * @param wmsVehicle 运输工具信息主
     * @return 结果
     */
    @Override
    public int insertWmsVehicle(WmsVehicle wmsVehicle) {
        wmsVehicle.setVehicleCode("KY-V-"+ IdWorker.get32UUID().toUpperCase());
        wmsVehicle.setVehicleStatus(WmsVehicleStatus.IDLE.getCode());
        return baseMapper.insertWmsVehicle(wmsVehicle);
    }

    /**
     * 修改运输工具信息主
     *
     * @param wmsVehicle 运输工具信息主
     * @return 结果
     */
    @Override
    public int updateWmsVehicle(WmsVehicle wmsVehicle) {
        wmsVehicle.setVehicleCode(null);
        return baseMapper.updateWmsVehicle(wmsVehicle);
    }

    /**
     * 批量删除运输工具信息主
     *
     * @param vehicleIds 需要删除的运输工具信息主ID
     * @return 结果
     */
    @Override
    public int deleteWmsVehicleByIds(Long[] vehicleIds) {
        return baseMapper.deleteWmsVehicleByIds(vehicleIds);
    }

    /**
     * 删除运输工具信息主信息
     *
     * @param vehicleId 运输工具信息主ID
     * @return 结果
     */
    @Override
    public int deleteWmsVehicleById(Long vehicleId) {
        return baseMapper.deleteWmsVehicleById(vehicleId);
    }
    @Override
    public WmsVehicleLL getLocationById(Long vehicleId){
        return baseMapper.selectLngAndLatById(vehicleId);
    }
}

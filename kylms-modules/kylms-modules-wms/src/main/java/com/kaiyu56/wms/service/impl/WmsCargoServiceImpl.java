package com.kaiyu56.wms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.common.core.utils.SecurityUtils;
import com.kaiyu56.wms.domain.WmsCargo;
import com.kaiyu56.wms.mapper.WmsCargoMapper;
import com.kaiyu56.wms.service.IWmsCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 货物Service业务层处理
 *
 * @author css
 * @date 2021-04-01
 */
@Service
public class WmsCargoServiceImpl implements IWmsCargoService {
    @Autowired
    private WmsCargoMapper wmsCargoMapper;

    /**
     * 查询货物
     *
     * @param cargoId 货物ID
     * @return 货物
     */
    @Override
    public WmsCargo selectWmsCargoById(Long cargoId) {
        return wmsCargoMapper.selectWmsCargoById(cargoId);
    }

    /**
     * 查询货物列表
     *
     * @param wmsCargo 货物
     * @return 货物
     */
    @Override
    public List<WmsCargo> selectWmsCargoList(WmsCargo wmsCargo) {
        return wmsCargoMapper.selectWmsCargoList(wmsCargo);
    }

    /**
     * 新增货物
     *
     * @param wmsCargo 货物
     * @return 结果
     */
    @Override
    public int insertWmsCargo(WmsCargo wmsCargo) {
        Date now = DateUtils.getNowDate();
        String username = SecurityUtils.getUsername();
        wmsCargo.setCargoId(IdWorker.getId());
        wmsCargo.setCargoCode("KY-CG-" + IdWorker.get32UUID().toUpperCase());
        wmsCargo.setCreateTime(now);
        wmsCargo.setCreateBy(username);
        wmsCargo.setUpdateTime(now);
        wmsCargo.setUpdateBy(username);
        return wmsCargoMapper.insertWmsCargo(wmsCargo);
    }

    /**
     * 修改货物
     *
     * @param wmsCargo 货物
     * @return 结果
     */
    @Override
    public int updateWmsCargo(WmsCargo wmsCargo) {
        wmsCargo.setUpdateTime(DateUtils.getNowDate());
        return wmsCargoMapper.updateWmsCargo(wmsCargo);
    }

    /**
     * 批量删除货物
     *
     * @param cargoIds 需要删除的货物ID
     * @return 结果
     */
    @Override
    public int deleteWmsCargoByIds(Long[] cargoIds) {
        return wmsCargoMapper.deleteWmsCargoByIds(cargoIds);
    }

    /**
     * 删除货物信息
     *
     * @param cargoId 货物ID
     * @return 结果
     */
    @Override
    public int deleteWmsCargoById(Long cargoId) {
        return wmsCargoMapper.deleteWmsCargoById(cargoId);
    }
}

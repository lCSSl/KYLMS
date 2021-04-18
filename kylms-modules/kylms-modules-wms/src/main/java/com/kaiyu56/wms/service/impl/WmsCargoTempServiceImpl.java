package com.kaiyu56.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.exception.BaseException;
import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.common.core.utils.SecurityUtils;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.wms.domain.WmsCargo;
import com.kaiyu56.wms.domain.WmsCargoTemp;
import com.kaiyu56.wms.mapper.WmsCargoTempMapper;
import com.kaiyu56.wms.service.IWmsCargoService;
import com.kaiyu56.wms.service.IWmsCargoTempService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 运单货物临时表Service业务层处理
 *
 * @author css
 * @date 2021-04-01
 */
@Slf4j
@Service
public class WmsCargoTempServiceImpl extends ServiceImpl<WmsCargoTempMapper, WmsCargoTemp> implements IWmsCargoTempService {

    @Autowired
    private IWmsCargoService wmsCargoService;

    /**
     * 查询运单货物临时表
     *
     * @param id 运单货物临时表ID
     * @return 运单货物临时表
     */
    @Override
    public WmsCargoTemp selectWmsCargoTempById(Long id) {
        return baseMapper.selectWmsCargoTempById(id);
    }

    /**
     * 查询运单货物临时表列表
     *
     * @param wmsCargoTemp 运单货物临时表
     * @return 运单货物临时表
     */
    @Override
    public List<WmsCargoTemp> selectWmsCargoTempList(WmsCargoTemp wmsCargoTemp) {
        return baseMapper.selectWmsCargoTempList(wmsCargoTemp);
    }

    /**
     * 新增运单货物临时表
     *
     * @param wmsCargoTemp 运单货物临时表
     * @return 结果
     */
    @Override
    public int insertWmsCargoTemp(WmsCargoTemp wmsCargoTemp) {
        wmsCargoTemp.setCreateTime(DateUtils.getNowDate());
        return baseMapper.insertWmsCargoTemp(wmsCargoTemp);
    }

    /**
     * 新增运单货物临时表批量
     *
     * @param wmsCargoTempSet 运单货物临时表
     * @return 结果
     */
    @Override
    public int insertWmsCargoTempBatch(Set<WmsCargoTemp> wmsCargoTempSet) {
        Date now = DateUtils.getNowDate();
        String username = SecurityUtils.getUsername();
        log.error("{}", wmsCargoTempSet);
        List<WmsCargoTemp> insertList = new ArrayList<>();
        if (wmsCargoTempSet.stream().filter(i -> StringUtils.isNotNull(i.getWaybillId())).collect(Collectors.toList()).size() != wmsCargoTempSet.size()) {
            log.error("input violation");
            throw new BaseException();
        }
        wmsCargoTempSet.stream().forEach(item -> {
            Long id = item.getId();
            if (id.compareTo(0l) == 0) {
                throw new BaseException("Error Input");
            } else if (id.compareTo(0l) > 0) {
                log.error("Update Action");
                baseMapper.updateWmsCargoTemp(item);
            } else {
                item.setCreateTime(now);
                item.setCreateBy(username);
                item.setUpdateTime(now);
                item.setUpdateBy(username);
                item.setId(null);
                insertList.add(item);
                log.error("Add Action");
            }
            if (!StringUtils.isNotNull(item.getCargoId())) {
                log.error("货物ID为空,新增货物样本");
                createNewCargo(item);
            }

        });
        log.error("{}", insertList);
        if (insertList.size() > 0)
            baseMapper.batchInsertCargoTemp(insertList);
        return wmsCargoTempSet.size();
    }

    private void createNewCargo(WmsCargoTemp wmsCargoTemp) {
        WmsCargo wmsCargo = wmsCargoTemp;
        wmsCargo.setCargoName(wmsCargoTemp.getTCargoName());
        log.error("createNewCargo:{}", wmsCargo);
        wmsCargoService.insertWmsCargo(wmsCargo);
    }

    /**
     * 修改运单货物临时表
     *
     * @param wmsCargoTemp 运单货物临时表
     * @return 结果
     */
    @Override
    public int updateWmsCargoTemp(WmsCargoTemp wmsCargoTemp) {
        wmsCargoTemp.setUpdateTime(DateUtils.getNowDate());
        wmsCargoTemp.setUpdateBy(SecurityUtils.getUsername());
        return baseMapper.updateWmsCargoTemp(wmsCargoTemp);
    }

    /**
     * 批量删除运单货物临时表
     *
     * @param ids 需要删除的运单货物临时表ID
     * @return 结果
     */
    @Override
    public int deleteWmsCargoTempByIds(Long[] ids) {
        return baseMapper.deleteWmsCargoTempByIds(ids);
    }

    /**
     * 删除运单货物临时表信息
     *
     * @param id 运单货物临时表ID
     * @return 结果
     */
    @Override
    public int deleteWmsCargoTempById(Long id) {
        return baseMapper.deleteWmsCargoTempById(id);
    }
}

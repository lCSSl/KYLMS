package com.kaiyu56.wms.service.impl;

import java.util.List;

import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import org.springframework.stereotype.Service;
import com.kaiyu56.wms.mapper.WmsWaybillMapper;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.service.IWmsWaybillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 运单信息主Service业务层处理
 *
 * @author css
 * @date 2021-03-20
 */
@Service
public class WmsWaybillServiceImpl extends ServiceImpl<WmsWaybillMapper, WmsWaybill> implements IWmsWaybillService {

    /**
     * 查询运单信息主
     *
     * @param waybillId 运单信息主ID
     * @return 运单信息主
     */
    @Override
    public WmsWaybill selectWmsWaybillById(Long waybillId) {
        return baseMapper.selectWmsWaybillById(waybillId);
    }

    /**
     * 查询运单信息主列表
     *
     * @param wmsWaybill 运单信息主
     * @return 运单信息主
     */
    @Override
    public List<WmsWaybill> selectWmsWaybillList(WmsWaybill wmsWaybill) {
        return baseMapper.selectWmsWaybillList(wmsWaybill);
    }

    @Override
    public List<WmsWaybillVO> selectWmsWaybillVOList(WmsWaybill wmsWaybill) {
        return baseMapper.selectWmsWaybillVOList(wmsWaybill);
    }

}

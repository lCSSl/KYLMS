package com.kaiyu56.wms.mapper;

import java.util.List;

import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import org.apache.ibatis.annotations.Param;

/**
 * 运单信息主Mapper接口
 *
 * @author css
 * @date 2021-03-20
 */
public interface WmsWaybillMapper extends BaseMapper<WmsWaybill> {

    /**
     * 查询运单信息主
     *
     * @param waybillId 运单信息主ID
     * @return 运单信息主
     */
    public WmsWaybill selectWmsWaybillById(Long waybillId);

    /**
     * 查询运单信息主列表
     *
     * @param wmsWaybill 运单信息主
     * @return 运单信息主集合
     */
    public List<WmsWaybill> selectWmsWaybillList(WmsWaybill wmsWaybill);

    /**
     * 查询运单信息主列表
     *
     * @param wmsWaybill 运单信息主
     * @return 运单信息主集合
     */
    public List<WmsWaybillVO> selectWmsWaybillVOList(WmsWaybill wmsWaybill);
    public List<WmsWaybillVO> selectWmsWaybillVOListByIds(List<Long> ids);

    int insertWmsWaybill(WmsWaybill wmsWaybill);
}

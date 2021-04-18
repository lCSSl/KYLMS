package com.kaiyu56.wms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.kaiyu56.common.core.utils.SecurityUtils;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.system.api.RemoteUserService;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.model.LoginUser;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import com.kaiyu56.wms.domain.WmsStowageRoute;
import com.kaiyu56.wms.enums.WmsWaybillStatus;
import com.kaiyu56.wms.service.IWmsStowageMdWaybillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@Service
public class WmsWaybillServiceImpl extends ServiceImpl<WmsWaybillMapper, WmsWaybill> implements IWmsWaybillService {
    @Autowired
    private RemoteUserService remoteUserService;
    @Autowired
    private IWmsStowageMdWaybillService wmsStowageMdWaybillService;
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
    public List<WmsWaybillVO> selectWmsWaybillVOList(WmsWaybillVO vo) {
        return baseMapper.selectWmsWaybillVOList(vo);
    }

    @Override
    public List<WmsWaybillVO> selectWmsWaybillVOList(Long routeId) {
        List<Long> waybillIds = wmsStowageMdWaybillService.selectWaybillIdsByRouteId(routeId);
        if (waybillIds.size()<=0){
            return new ArrayList<>();
        }
        return selectWmsWaybillVOListByIds(waybillIds);
    }

    @Override
    public int insertWmsWaybill(WmsWaybill wmsWaybill) {
        LoginUser data = remoteUserService.getUserInfo(SecurityUtils.getUsername()).getData();
        wmsWaybill.setWaybillCode("KY-WB-" + IdWorker.get32UUID().toUpperCase());
        wmsWaybill.setDeptId(data.getSysUser().getDeptId());
        wmsWaybill.setCreationSource("Web");
        wmsWaybill.setDestinationNode(wmsWaybill.getDestination());
        wmsWaybill.setWaybillStatus(WmsWaybillStatus.NEW.getCode());
        return baseMapper.insertWmsWaybill(wmsWaybill);
    }
    @Override
    public WmsWaybill updateWmsWaybill(WmsWaybill wmsWaybill) {
        LoginUser data = remoteUserService.getUserInfo(SecurityUtils.getUsername()).getData();
        SysUser sysUser = data.getSysUser();
        if(!sysUser.getDeptId().equals(wmsWaybill.getDeptId())){
            log.warn("change DeptId {}--->{}",wmsWaybill.getDeptId(), sysUser.getDeptId());
            wmsWaybill.setDeptId(sysUser.getDeptId());
        }
        if (!sysUser.getUserId().equals(wmsWaybill.getDrawerId())){
            log.warn("change DrawerId {}--->{}",wmsWaybill.getDrawerId(), sysUser.getUserId());
            wmsWaybill.setDrawerId(sysUser.getUserId());
            wmsWaybill.setDrawerName(sysUser.getNickName());
        }
        saveOrUpdate(wmsWaybill);
        return wmsWaybill;
    }

    @Override
    public List<WmsWaybillVO> selectWmsWaybillVOListByIds(List<Long> ids) {
        return baseMapper.selectWmsWaybillVOListByIds(ids);
    }

}

package com.kaiyu56.wms.service;

import java.util.List;
import com.kaiyu56.wms.domain.WmsStowage;

/**
 * 运单配载Service接口
 * 
 * @author css
 * @date 2021-03-24
 */
public interface IWmsStowageService 
{
    /**
     * 查询运单配载
     * 
     * @param stowageId 运单配载ID
     * @return 运单配载
     */
    public WmsStowage selectWmsStowageById(Long stowageId);

    /**
     * 查询运单配载列表
     * 
     * @param wmsStowage 运单配载
     * @return 运单配载集合
     */
    public List<WmsStowage> selectWmsStowageList(WmsStowage wmsStowage);

    /**
     * 新增运单配载
     * 
     * @param wmsStowage 运单配载
     * @return 结果
     */
    public int insertWmsStowage(WmsStowage wmsStowage);

    /**
     * 修改运单配载
     * 
     * @param wmsStowage 运单配载
     * @return 结果
     */
    public int updateWmsStowage(WmsStowage wmsStowage);

    /**
     * 批量删除运单配载
     * 
     * @param stowageIds 需要删除的运单配载ID
     * @return 结果
     */
    public int deleteWmsStowageByIds(Long[] stowageIds);

    /**
     * 删除运单配载信息
     * 
     * @param stowageId 运单配载ID
     * @return 结果
     */
    public int deleteWmsStowageById(Long stowageId);
}

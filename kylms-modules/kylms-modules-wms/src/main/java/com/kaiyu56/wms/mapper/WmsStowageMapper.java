package com.kaiyu56.wms.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaiyu56.wms.domain.WmsStowage;
import com.kaiyu56.wms.domain.vo.WmsStowageVO;
import com.kaiyu56.wms.enums.vo.driverapp.MissionStatus;

/**
 * 运单配载Mapper接口
 *
 * @author css
 * @date 2021-04-08
 */
public interface WmsStowageMapper extends BaseMapper<WmsStowage> {
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
     * 删除运单配载
     *
     * @param stowageId 运单配载ID
     * @return 结果
     */
    public int deleteWmsStowageById(Long stowageId);

    /**
     * 批量删除运单配载
     *
     * @param stowageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsStowageByIds(Long[] stowageIds);

    List<WmsStowageVO> selectDriverWmsStowage(Long driverId, List<String> missionStatus);

    WmsStowageVO selectOneDriverWmsStowage(Long driverId, List<String> missionStatus);
}

package com.kaiyu56.wms.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaiyu56.wms.domain.WmsCargoTemp;

/**
 * 运单货物临时表Mapper接口
 * 
 * @author css
 * @date 2021-04-01
 */
public interface WmsCargoTempMapper extends BaseMapper<WmsCargoTemp>
{
    /**
     * 查询运单货物临时表
     * 
     * @param id 运单货物临时表ID
     * @return 运单货物临时表
     */
    public WmsCargoTemp selectWmsCargoTempById(Long id);

    /**
     * 查询运单货物临时表列表
     * 
     * @param wmsCargoTemp 运单货物临时表
     * @return 运单货物临时表集合
     */
    public List<WmsCargoTemp> selectWmsCargoTempList(WmsCargoTemp wmsCargoTemp);

    /**
     * 新增运单货物临时表
     * 
     * @param wmsCargoTemp 运单货物临时表
     * @return 结果
     */
    public int insertWmsCargoTemp(WmsCargoTemp wmsCargoTemp);
    /**
     * 新增运单货物临时表批量
     *
     * @param wmsCargoTempList 运单货物临时表
     * @return 结果
     */
    public int batchInsertCargoTemp(List<WmsCargoTemp> wmsCargoTempList);

    /**
     * 修改运单货物临时表
     * 
     * @param wmsCargoTemp 运单货物临时表
     * @return 结果
     */
    public int updateWmsCargoTemp(WmsCargoTemp wmsCargoTemp);

    /**
     * 删除运单货物临时表
     * 
     * @param id 运单货物临时表ID
     * @return 结果
     */
    public int deleteWmsCargoTempById(Long id);

    /**
     * 批量删除运单货物临时表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsCargoTempByIds(Long[] ids);
}

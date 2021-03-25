package com.kaiyu56.wms.mapper;

import java.util.List;
import com.kaiyu56.wms.domain.WmsCargoTemp;

/**
 * 运单货物临时Mapper接口
 * 
 * @author css
 * @date 2021-03-24
 */
public interface WmsCargoTempMapper 
{
    /**
     * 查询运单货物临时
     * 
     * @param id 运单货物临时ID
     * @return 运单货物临时
     */
    public WmsCargoTemp selectWmsCargoTempById(Long id);

    /**
     * 查询运单货物临时列表
     * 
     * @param wmsCargoTemp 运单货物临时
     * @return 运单货物临时集合
     */
    public List<WmsCargoTemp> selectWmsCargoTempList(WmsCargoTemp wmsCargoTemp);

    /**
     * 新增运单货物临时
     * 
     * @param wmsCargoTemp 运单货物临时
     * @return 结果
     */
    public int insertWmsCargoTemp(WmsCargoTemp wmsCargoTemp);

    /**
     * 修改运单货物临时
     * 
     * @param wmsCargoTemp 运单货物临时
     * @return 结果
     */
    public int updateWmsCargoTemp(WmsCargoTemp wmsCargoTemp);

    /**
     * 删除运单货物临时
     * 
     * @param id 运单货物临时ID
     * @return 结果
     */
    public int deleteWmsCargoTempById(Long id);

    /**
     * 批量删除运单货物临时
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsCargoTempByIds(Long[] ids);
}

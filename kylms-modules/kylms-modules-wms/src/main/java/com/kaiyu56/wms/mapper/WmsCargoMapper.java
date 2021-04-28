package com.kaiyu56.wms.mapper;

import java.util.List;
import com.kaiyu56.wms.api.domain.WmsCargo;

/**
 * 货物Mapper接口
 * 
 * @author css
 * @date 2021-04-01
 */
public interface WmsCargoMapper 
{
    /**
     * 查询货物
     * 
     * @param cargoId 货物ID
     * @return 货物
     */
    public WmsCargo selectWmsCargoById(Long cargoId);

    /**
     * 查询货物列表
     * 
     * @param wmsCargo 货物
     * @return 货物集合
     */
    public List<WmsCargo> selectWmsCargoList(WmsCargo wmsCargo);

    /**
     * 新增货物
     * 
     * @param wmsCargo 货物
     * @return 结果
     */
    public int insertWmsCargo(WmsCargo wmsCargo);

    /**
     * 修改货物
     * 
     * @param wmsCargo 货物
     * @return 结果
     */
    public int updateWmsCargo(WmsCargo wmsCargo);

    /**
     * 删除货物
     * 
     * @param cargoId 货物ID
     * @return 结果
     */
    public int deleteWmsCargoById(Long cargoId);

    /**
     * 批量删除货物
     * 
     * @param cargoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsCargoByIds(Long[] cargoIds);
}

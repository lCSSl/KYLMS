package com.kaiyu56.wms.service;

import java.util.List;
import com.kaiyu56.wms.domain.WmsCargo;

/**
 * 货物Service接口
 * 
 * @author css
 * @date 2021-03-24
 */
public interface IWmsCargoService 
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
     * 批量删除货物
     * 
     * @param cargoIds 需要删除的货物ID
     * @return 结果
     */
    public int deleteWmsCargoByIds(Long[] cargoIds);

    /**
     * 删除货物信息
     * 
     * @param cargoId 货物ID
     * @return 结果
     */
    public int deleteWmsCargoById(Long cargoId);
}

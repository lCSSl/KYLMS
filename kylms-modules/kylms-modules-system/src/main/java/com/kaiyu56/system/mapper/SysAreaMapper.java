package com.kaiyu56.system.mapper;

import java.util.List;

import com.kaiyu56.system.domain.SysArea;
import com.kaiyu56.system.domain.SysAreaTree;

/**
 * 行政区Mapper接口
 *
 * @author css
 * @date 2021-03-20
 */
public interface SysAreaMapper {
    /**
     * 查询行政区
     *
     * @param id 行政区ID
     * @return 行政区
     */
    public SysArea selectSysAreaById(Long id);

    /**
     * 查询行政区单个树
     *
     * @param code 行政区code
     * @return 行政区
     */
    public SysAreaTree selectSysAreaTreeByCode(Long code);

    /**
     * 查询行政区列表
     *
     * @param sysArea 行政区
     * @return 行政区集合
     */
    public List<SysArea> selectSysAreaList(SysArea sysArea);

    /**
     * 新增行政区
     *
     * @param sysArea 行政区
     * @return 结果
     */
    public int insertSysArea(SysArea sysArea);

    /**
     * 修改行政区
     *
     * @param sysArea 行政区
     * @return 结果
     */
    public int updateSysArea(SysArea sysArea);

    /**
     * 删除行政区
     *
     * @param id 行政区ID
     * @return 结果
     */
    public int deleteSysAreaById(Long id);

    /**
     * 批量删除行政区
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysAreaByIds(Long[] ids);

    SysArea selectSysAreaByCode(Long code);

    String selectSysAreaNameByCode(Long code);
}

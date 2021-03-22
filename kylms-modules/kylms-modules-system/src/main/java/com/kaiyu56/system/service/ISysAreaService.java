package com.kaiyu56.system.service;

import java.util.List;

import com.kaiyu56.system.domain.SysArea;
import com.kaiyu56.system.domain.SysAreaTree;

/**
 * 行政区Service接口
 *
 * @author css
 * @date 2021-03-20
 */
public interface ISysAreaService {
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
    public SysAreaTree selectSysAreaTree(Long code);

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
     * 批量删除行政区
     *
     * @param ids 需要删除的行政区ID
     * @return 结果
     */
    public int deleteSysAreaByIds(Long[] ids);

    /**
     * 删除行政区信息
     *
     * @param id 行政区ID
     * @return 结果
     */
    public int deleteSysAreaById(Long id);
}

package com.kaiyu56.system.service.impl;

import java.util.List;

import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.system.domain.SysAreaTree;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiyu56.system.mapper.SysAreaMapper;
import com.kaiyu56.system.domain.SysArea;
import com.kaiyu56.system.service.ISysAreaService;

/**
 * 行政区Service业务层处理
 *
 * @author css
 * @date 2021-03-20
 */
@Service
public class SysAreaServiceImpl implements ISysAreaService {
    @Autowired
    private SysAreaMapper sysAreaMapper;

    /**
     * 查询行政区
     *
     * @param id 行政区ID
     * @return 行政区
     */
    @Override
    public SysArea selectSysAreaById(Long id) {
        return sysAreaMapper.selectSysAreaById(id);
    }
    /**
     * 查询行政区单个树
     *
     * @param code 行政区code
     * @return 行政区
     */
    @Override
    public SysAreaTree selectSysAreaTree(Long code) {
        SysAreaTree sysAreaTree = sysAreaMapper.selectSysAreaTreeByCode(code);
        sysAreaTree = findRoot(sysAreaTree);
        return sysAreaTree;
    }
    private SysAreaTree findRoot(SysAreaTree node){
        if (node!=null){
            SysAreaTree sysAreaTree = sysAreaMapper.selectSysAreaTreeByCode(node.getParentCode());
            if (sysAreaTree==null){
                return node;
            }else {
                SysAreaTree copy = new SysAreaTree();
                BeanUtils.copyProperties(node,copy);
                sysAreaTree.setChild(copy);
                node=sysAreaTree;
                return findRoot(node);
            }
        }
        return null;
    }
    /**
     * 查询行政区列表
     *
     * @param sysArea 行政区
     * @return 行政区
     */
    @Override
    public List<SysArea> selectSysAreaList(SysArea sysArea) {
        return sysAreaMapper.selectSysAreaList(sysArea);
    }

    /**
     * 新增行政区
     *
     * @param sysArea 行政区
     * @return 结果
     */
    @Override
    public int insertSysArea(SysArea sysArea) {
        sysArea.setCreateTime(DateUtils.getNowDate());
        return sysAreaMapper.insertSysArea(sysArea);
    }

    /**
     * 修改行政区
     *
     * @param sysArea 行政区
     * @return 结果
     */
    @Override
    public int updateSysArea(SysArea sysArea) {
        sysArea.setUpdateTime(DateUtils.getNowDate());
        return sysAreaMapper.updateSysArea(sysArea);
    }

    /**
     * 批量删除行政区
     *
     * @param ids 需要删除的行政区ID
     * @return 结果
     */
    @Override
    public int deleteSysAreaByIds(Long[] ids) {
        return sysAreaMapper.deleteSysAreaByIds(ids);
    }

    /**
     * 删除行政区信息
     *
     * @param id 行政区ID
     * @return 结果
     */
    @Override
    public int deleteSysAreaById(Long id) {
        return sysAreaMapper.deleteSysAreaById(id);
    }
}

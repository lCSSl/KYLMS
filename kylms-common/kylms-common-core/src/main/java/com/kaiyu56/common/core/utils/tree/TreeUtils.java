package com.kaiyu56.common.core.utils.tree;


import com.kaiyu56.common.core.exception.UtilException;
import com.kaiyu56.common.core.utils.reflect.ReflectUtils;
import com.kaiyu56.common.core.utils.tree.annotation.TreeChild;
import com.kaiyu56.common.core.utils.tree.annotation.TreeEntity;
import com.kaiyu56.common.core.utils.tree.annotation.TreeId;
import com.kaiyu56.common.core.utils.tree.annotation.TreePid;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Hamser
 */
public final class TreeUtils {
    private final static Logger logger = LoggerFactory.getLogger(TreeUtils.class);
    private final static Integer FIELD_SIZE = 6 >> 1;
    /**
     * Map<Class<?>, String> ---> Map<[注解属性类型,[字段名]>
     * 默认情况下，HashMap容量为16，加载因子为0.75，即当HashMap中的数据量达到 16 X 0.75 = 12 时，将触发扩容操作。
     * 现在是3个进入map 触发条件容量4 所以初始化8 就可以避免触发再次扩容
     */
    private static Map<Class<?>, String> fieldsMap = new HashMap<>(8);

    /**
     * @param list     所有列表
     * @param rootNode 根节点
     * @param clazz    元素类型
     * @param <E>      传入元素
     * @return 树状结构实体
     */
    public static <E> E toTree(List<E> list, E rootNode, Class<E> clazz) {
        if (fieldsMap.size() != FIELD_SIZE) {
            fieldsMap = getFieldsMap(clazz);
            logger.info("The call completes and gets the property name:\n{}", fieldsMap);
        }
        HashMap<Object, E> map = new HashMap<>(2);
        Object id = ReflectUtils.invokeGetter(rootNode, fieldsMap.get(TreeId.class));
        Object pid = ReflectUtils.invokeGetter(rootNode, fieldsMap.get(TreePid.class));
        map.put(id, rootNode);
        for (E childNode : list) {
            Object tId = ReflectUtils.invokeGetter(childNode, fieldsMap.get(TreeId.class));
            map.put(tId, childNode);
            Object tPid = ReflectUtils.invokeGetter(childNode, fieldsMap.get(TreePid.class));
            if (!pid.equals(tPid)) {
                //父节点
                E parentNode = map.get(tPid);
                //给父节点的child属性赋当前节点
                List<E> tChild = ReflectUtils.invokeGetter(parentNode, fieldsMap.get(TreeChild.class));
                if (CollectionUtils.isEmpty(tChild)) {
                    tChild = new ArrayList<>();
                }
                tChild.add(childNode);
                ReflectUtils.invokeSetter(parentNode, fieldsMap.get(TreeChild.class), tChild);
            }
        }
        return map.get(id);
    }


    /**
     * 引用写法 绕过递归
     *
     * @param list  所有列表
     * @param pid   父级id
     * @param clazz 元素类型
     * @param <E>   传入元素
     * @return 树状结构集合
     */
    public static <E> List<E> toTreeList(List<E> list, Object pid, Class<E> clazz) {
        return toTreeList(list, 8, pid, clazz);
    }

    /**
     * @param list      所有列表
     * @param pid       父级id
     * @param parentNum 父级数量减少扩容
     * @param clazz     元素类型
     * @param <E>       传入元素
     * @return 树状结构集合
     */
    public static <E> List<E> toTreeList(List<E> list, int parentNum, Object pid, Class<E> clazz) {
        if (pid instanceof String || pid instanceof Integer || pid instanceof Long) {
            if (fieldsMap.size() != FIELD_SIZE) {
                fieldsMap = getFieldsMap(clazz);
                logger.info("The call completes and gets the property name:\n{}", fieldsMap);
            }
            Map<Object, E> map = new HashMap<>(capacity(parentNum));
            // 用来存放根节点
            List<E> rootNodes = new ArrayList<>();
            for (E o : list) {
                Object tPid = ReflectUtils.invokeGetter(o, fieldsMap.get(TreePid.class));
                // 如果是父
                if (Objects.equals(tPid, pid)) {
                    rootNodes.add(o);
                    Object id = ReflectUtils.invokeGetter(o, fieldsMap.get(TreeId.class));
                    map.put(id, o);
                }
            }
            // ---->时间复杂度: O(n)
            for (E childNode : list) {
                if (childNode != null) {
                    Object tId = ReflectUtils.invokeGetter(childNode, fieldsMap.get(TreeId.class));
                    map.put(tId, childNode);
                    Object tPid = ReflectUtils.invokeGetter(childNode, fieldsMap.get(TreePid.class));
                    if (!Objects.equals(tPid, pid)) {
                        //父节点
                        E parentNode = map.get(tPid);
                        //给父节点的child属性赋当前节点
                        List<E> tChild = ReflectUtils.invokeGetter(parentNode, fieldsMap.get(TreeChild.class));
                        if (CollectionUtils.isEmpty(tChild)) {
                            tChild = new ArrayList<>();
                        }
                        tChild.add(childNode);
                        ReflectUtils.invokeSetter(parentNode, fieldsMap.get(TreeChild.class), tChild);
                    }
                }
            }
            return rootNodes;
        }
        throw new UtilException("The parent Id must be one of [String,Long,Integer]");
    }

    /**
     * 获取 Field Map
     *
     * @param clazz 类名
     * @return Map<Class < ?>, String> ---> Map<[注解类型,[字段名]>
     */
    private static <E> Map<Class<?>, String> getFieldsMap(Class<E> clazz) {
        // 获取树状结构实体
        TreeEntity treeEntity = clazz.getAnnotation(TreeEntity.class);
        // 判断注解是否为空
        if (treeEntity == null) {
            throw new RuntimeException("该实体类不是树状实体");
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(TreeId.class) != null) {
                fieldsMap.put(TreeId.class, field.getName());
            }
            if (field.getAnnotation(TreePid.class) != null) {
                fieldsMap.put(TreePid.class, field.getName());
            }
            if (field.getAnnotation(TreeChild.class) != null) {
                fieldsMap.put(TreeChild.class, field.getName());
            }
        }
        if (fieldsMap.size() < FIELD_SIZE) {
            throw new UtilException("Missing one of the properties FieldType.ID | FieldType.PID | FieldType.CHILD)");
        }
        return fieldsMap;
    }

    /**
     * 获取最小2的n次幂
     *
     * @param min 最小容量
     * @return int
     */
    private static int capacity(int min) {
        if (min <= 0) return 1;
        else {
            int i = 0;
            int t = 4;
            while ((t = (int) Math.pow(2, i)) <= min) i++;
            return t;
        }
    }
}

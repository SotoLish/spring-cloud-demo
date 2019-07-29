package com.hand.area.service;

import java.util.List;

/**
 * 基础服务
 * 定义基本CRUD
 *
 * @author liuqixin
 * @date 2019/7/26 09:31
 */
public interface BasicService<T, ID> {

    /**
     * 获取所有
     *
     * @return 对象列表
     * @author liuqixin
     * @date 2019/07/26 09:35
     */
    List<T> getList();

    /**
     * 根据ID查找
     *
     * @param id ID
     * @return ID对应对象
     * @author liuqixin
     * @date 2019/07/26 09:35
     */
    T queryById(ID id);

    /**
     * 创建对象
     *
     * @param object 对象
     * @return 在数据库中创建的对象
     */
    T create(T object);

    /**
     * 更新对象
     *
     * @param object 需要更新的对象
     * @return 更新后的对象
     */
    T update(T object);

    /**
     * 根据ID删除对象
     *
     * @param id 对象ID
     */
    void delete(ID id);


}

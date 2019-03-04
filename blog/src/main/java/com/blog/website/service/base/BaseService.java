package com.blog.website.service.base;

import java.util.List;

/**
 * @author jiangzehao
 * @date 2019/3/4 15:58
 */
public interface BaseService<T,I> {

    public List<T> queryAll(T t);

    public void update(T t) throws Exception;

    public void delete(I id) throws Exception;

    public T getByKey(I id);

    public void add(T t) throws Exception;

}

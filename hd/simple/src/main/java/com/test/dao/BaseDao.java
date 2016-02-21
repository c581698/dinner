package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.twtr.model.modules.basic.ServItem;

public interface BaseDao {
	public List<ServItem> queryServs(@Param("ids") String ids);
}

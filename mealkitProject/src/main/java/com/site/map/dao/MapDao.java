package com.site.map.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import com.site.store.model.StoreVo;

@Mapper
public interface MapDao {

	ArrayList<StoreVo> storeListSelect();

}

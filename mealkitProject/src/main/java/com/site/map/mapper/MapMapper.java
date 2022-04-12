package com.site.map.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import com.site.store.model.StoreVo;

@Mapper
public interface MapMapper {

	ArrayList<StoreVo> storeListSelect();

}

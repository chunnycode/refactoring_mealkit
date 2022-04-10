package com.site.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import com.site.vo.StoreVo;

@Mapper
public interface MapMapper {

	ArrayList<StoreVo> storeListSelect();

}

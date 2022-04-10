package com.site.service.map;

import java.util.ArrayList;

import com.site.mapper.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.vo.StoreVo;

@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private MapMapper mapMapper;
	
	@Override
	public ArrayList<StoreVo> storeList() {
		ArrayList<StoreVo> list =  mapMapper.storeListSelect();
		return list;
	}

}

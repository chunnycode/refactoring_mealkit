package com.site.map.service.impl;

import java.util.ArrayList;

import com.site.map.service.MapService;
import com.site.map.mapper.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.store.model.StoreVo;

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

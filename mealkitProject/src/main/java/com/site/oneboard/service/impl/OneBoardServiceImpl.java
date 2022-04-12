package com.site.oneboard.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.site.oneboard.mapper.OneBoardMapper;
import com.site.oneboard.service.OneBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.oneboard.model.OneBoardVo;


@Service
public class OneBoardServiceImpl implements OneBoardService {

	@Autowired
	private OneBoardMapper one_boardmapper;

	// 리스트
	@Override
	public Map<String, Object> selectBoardList(String category, String category1, String searchword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		int listCount = one_boardmapper.selectListCount(category, category1, searchword);

		ArrayList<OneBoardVo> list = one_boardmapper.selectBoardList(category, category1, searchword);

		map.put("listCount", listCount);
		map.put("list", list);
		map.put("category", category);
		map.put("category1", category1);
		map.put("searchword", searchword);

		return map;
	}

	// 글쓰기
	@Override
	public void insertBoardWrite(OneBoardVo one_BoardVo) {
		// TODO Auto-generated method stub
		one_boardmapper.insertBoardWrite(one_BoardVo);

	}

	@Override
	public OneBoardVo selectBoardView(int id) {
		// TODO Auto-generated method stub
		one_boardmapper.updateBhitAdd(id);
		OneBoardVo one_BoardVo = one_boardmapper.selectBoardView(id);
	
		return one_BoardVo;
	}

	@Override
	public OneBoardVo selectBoardViewPre(int id) {
		// TODO Auto-generated method stub
		OneBoardVo one_BoardVoPre = one_boardmapper.selectBoardViewPre(id);
		return one_BoardVoPre;
	}

	@Override
	public OneBoardVo selectBoardViewNext(int id) {
		// TODO Auto-generated method stub
		OneBoardVo one_BoardVoNext = one_boardmapper.selectBoardViewNext(id);
		return one_BoardVoNext;
	}

	@Override
	public void deleteBoardDelete(int id) {
		one_boardmapper.deleteBoardDelete(id);

	}

	@Override
	public int updateBoardModify(OneBoardVo one_boardVo) {
		int result = one_boardmapper.updateBoardModify(one_boardVo);
		return result;
	}

	@Override
	public void insertBoardReply(OneBoardVo one_BoardVo) {
		// 같은 bgroup에서 현재bstep보다 큰bstep은 1씩증가
		one_boardmapper.updateBoardReplyStepAdd(one_BoardVo);
		// 답변달기 저장
		one_boardmapper.insertBoardReply(one_BoardVo);

	}
	
	/*_______________________시원________________________*/
	@Override
	public ArrayList<OneBoardVo> MemberBoardList(String id) {
		ArrayList<OneBoardVo> list = one_boardmapper.memberBoardList(id);
		return list;
	}

}

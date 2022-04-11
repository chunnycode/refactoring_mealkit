package com.site.oneboard.service;

import java.util.ArrayList;
import java.util.Map;

import com.site.oneboard.model.OneBoardVo;

public interface OneBoardService {

	Map<String, Object> selectBoardList(String category, String category1, String searchword);

	void insertBoardWrite(OneBoardVo one_boardVo);

	OneBoardVo selectBoardView(int id);

	OneBoardVo selectBoardViewPre(int id);

	OneBoardVo selectBoardViewNext(int id);

	void deleteBoardDelete(int id);

	int updateBoardModify(OneBoardVo one_boardVo);

	void insertBoardReply(OneBoardVo one_BoardVo);
	
	/*_______________________시원________________________*/
	ArrayList<OneBoardVo> MemberBoardList(String id);

}

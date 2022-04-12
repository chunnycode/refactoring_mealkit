package com.site.oneboard.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;


import com.site.oneboard.model.OneBoardVo;

@Mapper
public interface OneBoardMapper {

//count
	int selectListCount(String category, String category1, String searchword);

//list
	ArrayList<OneBoardVo> selectBoardList(String category, String category1, String searchword);

//write
	void insertBoardWrite(OneBoardVo one_boardVo);

//view
	OneBoardVo selectBoardView(int id);

//bhit 조회수 추가
	void updateBhitAdd(int id);

//이전글
	OneBoardVo selectBoardViewPre(int id);

//이후글
	OneBoardVo selectBoardViewNext(int id);

//삭제 
	void deleteBoardDelete(int id);

//수정
	int updateBoardModify(OneBoardVo one_boardVo);

// step 증가
	void updateBoardReplyStepAdd(OneBoardVo one_BoardVo);

//게시판 답변달기
	void insertBoardReply(OneBoardVo one_BoardVo);

/*_______________________시원________________________*/
	ArrayList<OneBoardVo> memberBoardList(String id);
}

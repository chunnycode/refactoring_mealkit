package com.site.noticeboard.service;

import java.util.Map;

import com.site.noticeboard.model.NoticeBoardVo;

public interface NoticeBoardService {

	// 게시판 리스트
	Map<String, Object> selectBoardList(int page, String category, String searchWord, String category1);

	// 게시판 뷰
	NoticeBoardVo selectBoardView(int id);

	// 이전글
	NoticeBoardVo selectBoardViewPre(int id);

	// 다음글
	NoticeBoardVo selectBoardViewNext(int id);

	// 게시판 수정
	int updateBoardModify(NoticeBoardVo notice_boardVo);

	// 게시판 삭제
	void deleteBoardDelete(int id);

	// 게시판 글쓰기
	void insertBoardWrite(NoticeBoardVo notice_boardVo);

	/*
	 * //게시판 답변달기 void insertBoardReply(Notice_BoardVo notice_boardVo);
	 * 
	 * Map<String, Object> selectSearch(int page, String category, String
	 * searchWord);
	 */

}

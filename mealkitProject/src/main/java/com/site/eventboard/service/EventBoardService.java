package com.site.eventboard.service;

import java.util.Map;

import com.site.board.model.BoardVo;

public interface EventBoardService {

	// 게시판 리스트
	Map<String, Object> selectBoardList(int page, String category, String searchWord, String category1);

	// 게시판 뷰
	BoardVo selectBoardView(int id);

	// 이전글
	BoardVo selectBoardViewPre(int id);

	// 다음글
	BoardVo selectBoardViewNext(int id);

	// 게시판 수정
	int updateBoardModify(BoardVo notice_boardVo);

	// 게시판 삭제
	void deleteBoardDelete(int id);

	// 게시판 글쓰기
	void insertBoardWrite(BoardVo notice_boardVo);

	Map<String, Object> selectBoardList2(int page, String category, String category1, String searchWord);

	/*
	 * //게시판 답변달기 void insertBoardReply(Notice_BoardVo notice_boardVo);
	 * 
	 * Map<String, Object> selectSearch(int page, String category, String
	 * searchWord);
	 */

}

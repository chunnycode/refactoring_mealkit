package com.site.noticeboard.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.site.noticeboard.model.NoticeBoardVo;

@Mapper
public interface NoticeBoardDao {

	// 게시판 리스트
	ArrayList<NoticeBoardVo> selectBoardList(int startrow, int endrow, String category, String category1, String searchWord);

	/*
	 * //게시판 검색리스트 ArrayList<Notice_BoardVo> selectBoardSearch(int startrow, int
	 * endrow, String category, String searchWord);
	 */
	// 게시판 총 개수
	int selectListCount(String category,String category1, String searchWord);

	/*
	 * //게시판 btitle검색 총 개수 int selectSearchCount(String category,String searchWord);
	 */
	// 게시판 뷰
	NoticeBoardVo selectBoardView(int id);

	// 게시판 이전글
	NoticeBoardVo selectBoardViewPre(int id);

	// 게시판 다음글
	NoticeBoardVo selectBoardViewNext(int id);

	// 게시판 수정
	int updateBoardModify(NoticeBoardVo notice_boardVo);

	// 게시판 삭제
	void deleteBoardDelete(int id);

	// 게시판 글쓰기
	void insertBoardWrite(NoticeBoardVo notice_boardVo);

	/*
	 * //게시판 답변달기 bstep 1씩 증가 void updateBoardReplyStepAdd(Notice_BoardVo
	 * notice_boardVo);
	 * 
	 * //게시판 답변달기 void insertBoardReply(Notice_BoardVo notice_boardVo);
	 */
	// 조회수 1씩 증가
	void updateBhitAdd(int id);

}

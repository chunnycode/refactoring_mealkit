package com.site.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.site.service.oneboard.One_BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.site.vo.One_BoardVo;

@Controller
public class One_BoardController {

	@Autowired
	private One_BoardService one_boardservice;
	
	// 파일저장위치
	@Value("${fileUrlBoard}")
	private String fileUrl;

	// 리스트
	@RequestMapping("/one_board/one_list")
	public String one_list(@RequestParam(defaultValue = "") String category,
			@RequestParam(defaultValue = "") String category1, @RequestParam @Nullable String searchword, Model model) {
		Map<String, Object> map = one_boardservice.selectBoardList(category, category1, searchword);
		model.addAttribute("map", map);
		return "/one_board/one_list";

	}

	// 게시판 수정
	@GetMapping("/one_board/one_modify")
	public String boardModify(@RequestParam int id, @RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {
		// db에서 게시글 1개 가져옴.
		One_BoardVo one_boardVo = one_boardservice.selectBoardView(id);
		model.addAttribute("page", page);
		model.addAttribute("one_boardVo", one_boardVo);
		return "/one_board/one_modify";
	}

	@PostMapping("/one_board/one_modify")
	public String boardModify(One_BoardVo one_boardVo, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestPart MultipartFile file, @RequestParam String old_bupload, Model model) throws Exception {

		// 파일이 첨부가 되어 있으면
		if (file.getSize() != 0) {
			String originFileName = file.getOriginalFilename(); // 원본파일이름 저장
			long time = System.currentTimeMillis();
			// 파일이름
			String uploadFileName = String.format("%d_%s", time, originFileName);
			// 복사할 파일
			File f = new File(fileUrl + uploadFileName);
			// 파일 업로드
			file.transferTo(f);

			// db에 저장하기 위해 vo에 파일이름을 저장시킴.
			one_boardVo.setBupload(uploadFileName);
		} else {
			// 파일첨부가 없을때 기존의 이름을 등록.
			one_boardVo.setBupload(old_bupload);
		}

		// db에서 게시글 1개 가져옴.
		int result = one_boardservice.updateBoardModify(one_boardVo);
		return "redirect:/one_board/one_list?page=" + page;
	}

	// 쓰기
	@PostMapping("/one_board/one_write")
	public String one_write(One_BoardVo one_boardVo, HttpSession session, @RequestPart MultipartFile file) throws Exception {
		String member_id = (String) session.getAttribute("session_id");
		String member_type = (String) session.getAttribute("session_user");		
		String bname = (String) session.getAttribute("session_nickname");
		
		// 파일이 첨부가 되어 있으면
		if (file.getSize() != 0) {
			String originFileName = file.getOriginalFilename(); // 원본파일이름 저장
			long time = System.currentTimeMillis();
			// 파일이름
			String uploadFileName = String.format("%d_%s", time, originFileName);
			// 복사할 파일
			File f = new File(fileUrl + uploadFileName);
			// 파일 업로드
			file.transferTo(f);

			// db에 저장하기 위해 vo에 파일이름을 저장시킴.
			one_boardVo.setBupload(uploadFileName);
		} else {
			one_boardVo.setBupload(""); // 사진을 널값 처리
		}

		one_boardVo.setMember_id(member_id);
		one_boardVo.setMember_type(member_type);
		
		one_boardservice.insertBoardWrite(one_boardVo);
		
		
		
	
			
		return "redirect:/one_board/one_list";
	}

	@GetMapping("/one_board/one_write")
	public String open_one_write() {

		return "/one_board/one_write";
	}

	// 뷰
	@RequestMapping("/one_board/one_view")
	public String boardView(@RequestParam(defaultValue = "") int id,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		// db에서 게시글 1개 가져옴.
		One_BoardVo one_BoardVo = one_boardservice.selectBoardView(id);
		// 이전글
		One_BoardVo one_BoardVoPre = one_boardservice.selectBoardViewPre(id);
		// 다음글
		One_BoardVo one_BoardVoNext = one_boardservice.selectBoardViewNext(id);
		model.addAttribute("page", page);
		model.addAttribute("one_BoardVo", one_BoardVo);
		model.addAttribute("one_BoardVoPre", one_BoardVoPre);
		model.addAttribute("one_BoardVoNext", one_BoardVoNext);
		return "/one_board/one_view";
	}

	// 게시판 삭제
	@RequestMapping("/one_board/one_delete")
	public String boardDelete(@RequestParam int id, @RequestParam(value = "page", defaultValue = "1") int page) {

		one_boardservice.deleteBoardDelete(id);
		return "redirect:/one_board/one_list?page=" + page;
	}

	// 계시판 답글
	@GetMapping("/one_board/one_reply")
	public String one_reply(@RequestParam(value = "id") int id, Model model) {
		One_BoardVo one_BoardVo = one_boardservice.selectBoardView(id);
		model.addAttribute("one_BoardVo", one_BoardVo);

		return "/one_board/one_reply";
	}

	@PostMapping("/one_board/one_reply")
	public String one_reply(One_BoardVo one_BoardVo, HttpSession session, @RequestPart @Nullable MultipartFile file, Model model,
			@RequestParam("old_bupload") String old_bupload) {
		String member_id = (String) session.getAttribute("session_id");
		// 파일이 첨부가 되어 있으면
		if (file.getSize() != 0) {
			String originFileName = file.getOriginalFilename(); // 원본파일이름 저장
			long time = System.currentTimeMillis();
			// 파일이름
			String uploadFileName = String.format("%d_%s", time, originFileName);
			// 복사할 파일
			File f = new File(fileUrl + uploadFileName);
			// 파일 업로드
			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// db에 저장하기 위해 vo에 파일이름을 저장시킴.
			one_BoardVo.setBupload(uploadFileName);
		} else {
			one_BoardVo.setBupload(old_bupload);
		}
		one_BoardVo.setMember_id(member_id);
		one_boardservice.insertBoardReply(one_BoardVo);
		return "redirect:/one_board/one_list";
	}
	
	

}

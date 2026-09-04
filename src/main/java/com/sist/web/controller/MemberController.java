package com.sist.web.controller;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
/*
 * 	git pull origin main
 * 	git checkout -b develop
 * 	git add .
 * 	git commit -m "commit message"
 * 	git push -u origin 브랜치
 * 	-------------------------------
 * 	git pull origin develop
 * 	git checkout -b feature/login (-b는 브랜치 생성)
 * 	git add .
 * 	git commit -m "commit message"
 * 	git push feature/login
 * 
 * 	main : 배포용
 * 	  | 
 * 	develop : 개발 통합
 * 	  |
 * 	feature/login : 기능 개발
 * 	  |
 * 	 개발
 * 	  |
 * 	commit
 * 	  |
 * 	 push
 * 	  |
 *	 Pull Request
 *	  |
 *	develop
 *	=> git status : 상태 확인
 *
 *	gh pr create --base develop --head feature/login
 *
 *	gh pr create --base develop --head feature/login
 *	   --title "로그인 기능 구현" --body "스프링 보안이용" 
 *
 *	gh pr merge 
 * 	
 */
public class MemberController {
	private final MemberMapper mMapper;
	
	@GetMapping("/list")
	public String member_list(Model model) {
		List<MemberVO> list=mMapper.memberListData();
		for(MemberVO vo:list) {
			System.out.println(vo.getId()+" "
						+vo.getName()+" "
						+vo.getSex());
		}
		model.addAttribute("list", list);
		return "list";
	};
}

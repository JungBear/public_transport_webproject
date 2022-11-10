package com.study.domain.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    
    
    
    // 정보 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openInfoPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostResponse post = postService.findById(id);
            model.addAttribute("post", post);
        }
        
        return "post/write";
    }
        
    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params, HttpSession session) {
//    	int writer = (int) session.getAttribute("no");
    	params.setWriterNo(1);
        postService.savePost(params);
        if (params.getType() == 0) {
        	return "redirect:/post/infolist.do";
        }else {
        	return "redirect:/post/freelist.do";
        }
    }
    
    // 자유 게시글 리스트 페이지
    @GetMapping("/post/freelist.do")
    public String openFreePostList(Model model) {
        List<PostResponse> posts = postService.findFreePost();
        model.addAttribute("posts", posts);
        return "post/list";
    }
    
    // 정보 게시글 리스트 페이지
    @GetMapping("/post/infolist.do")
    public String openInfoPostList(Model model) {
        List<PostResponse> posts = postService.findInfoPost();
        model.addAttribute("posts", posts);
        return "post/list";
    } 
    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findById(id);
        model.addAttribute("post", post);
        return "post/view";
    }
    
    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params) {
    	params.setWriterNo(1);
        postService.savePost(params);
        if (params.getType() == 0) {
        	return "redirect:/post/infolist.do";
        }else {
        	return "redirect:/post/freelist.do";
        }
    }
}
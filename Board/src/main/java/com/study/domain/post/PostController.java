package com.study.domain.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.common.dto.MessageDto;

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
    public String savePost(final PostRequest params, HttpSession session, Model model) {
//    	int writer = (int) session.getAttribute("no");
    	params.setWriterNo(1);
        postService.savePost(params);
        if (params.getType() == 0) {
        	 MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/infolist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }else {
        	 MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/freelist.do", RequestMethod.GET, null);
        	 return showMessageAndRedirect(message, model);
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
    public String updatePost(final PostRequest params, Model model) {
    	params.setWriterNo(1);
        postService.updatePost(params);
        
        if (params.getType() == 0) {
        	MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/infolist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }else {
        	MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/freelist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }
    }
    
    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id, @RequestParam final int type, Model model) {
        postService.deletePost(id);
        if(type == 0) {
        	MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/infolist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }else {
        	MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/freelist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }
    }
    
    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}
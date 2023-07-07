package com.study.board.controller.post;

import com.study.board.domain.common.MessageDto;
import com.study.board.domain.common.SearchDto;
import com.study.board.domain.common.paging.PagingResponse;
import com.study.board.domain.post.PostRequest;
import com.study.board.domain.post.PostResponse;
import com.study.board.service.post.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    @GetMapping("/")
    public String index(){
        return "redirect:/post/list.do";
    }

    @GetMapping("/post/write.do")
    public String writePost(@RequestParam(value = "bno", required = false) final Long bno, Model model) {
        if(bno != null){
            PostResponse post = postService.findByBno(bno);
            model.addAttribute("post",post);
        }
        return "post/write";
    }

    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params, Model model){
        postService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET,null);
        model.addAttribute("message", message);
        return showMessageAndRedirect(message, model);
    }
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params, Model model){
        postService.update(params);
        String uri = "/post/view.do?bno="+params.getBno();
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", uri, RequestMethod.GET,null);
        model.addAttribute("message", message);
        return showMessageAndRedirect(message, model);
    }

    @GetMapping("/post/list.do")
    public String listPost(@ModelAttribute("params") final SearchDto params, Model model){
        // 1 대 1 로 매핑 되는 단일 파라미터는 @RequestParam 으로 전달 받은후 model에 추가하여 직접 뷰에 전달해야된다.
        // @ModelAttribute 을 이용하면 파라미터로 수집한 객체를 자동으로 뷰까지 전달이 가능하다.
        PagingResponse<PostResponse> response = postService.findAll(params);
        model.addAttribute("response",response);
        return "post/list";
    }

    @GetMapping("/post/view.do")
    public String postView(@RequestParam(value = "bno")final Long bno, Model model){
        if(bno == null){
            // 없는 번호다 라고 알림 나오게
            return "post/list";
        }
        PostResponse post = postService.findByBno(bno);
        model.addAttribute("post",post);
        return "post/view";
    }

    @PostMapping("/post/delete.do")
    @ResponseBody
    public String deletePost(@RequestParam(value = "bno")final Long bno){
        postService.deleteByBno(bno);
        return "success";
    }
    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto message, Model model) {
        model.addAttribute("message", message);
        return "common/messageRedirect";
    }
}

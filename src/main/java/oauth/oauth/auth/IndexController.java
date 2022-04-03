package oauth.oauth.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    //private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model)
    {
       // model.addAttribute("posts",postsService.findAllDesc());
        // userName을 사용할 수 있게 model에 저장
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }

        return "home";
    }

 /*   @GetMapping("/") // RESTful post put get delete //boardList
    public ModelAndView home(){ //Model model
        // List<board> b = boardService.getAllboard();
        String username = "login plz";
        // model.addAttribute("list",b); //VO= value object 여러개의 속성들을 묶어서 특정값을 나타내는 객체 , 데이터 추가
        //System.out.println(b); //정상출력
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            username=user.getName();
        }

        System.out.println("what");
        return new ModelAndView("index", "username", username);// 이 방법을 활용하도록 하겠다.
        //return "home.html"; // html 파일 이름
    }*/

}

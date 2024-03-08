package com.nhnacademy.security.explain;




import com.nhnacademy.security.entity.Member; // 사용할 Member 엔티티를 import 합니다.
import com.nhnacademy.security.service.MemberService; // 사용할 MemberService를 import 합니다.
import lombok.RequiredArgsConstructor; // 롬복 어노테이션 중 @RequiredArgsConstructor를 import 합니다.
import org.springframework.stereotype.Controller; // 스프링 컨트롤러를 정의하기 위해 import 합니다.
import org.springframework.web.bind.annotation.GetMapping; // HTTP GET 요청을 처리하기 위한 어노테이션을 import 합니다.
import org.springframework.web.bind.annotation.SessionAttribute; // 세션 속성을 매개변수로 받기 위한 어노테이션을 import 합니다.
import org.springframework.ui.Model; // 모델을 사용하기 위한 import 합니다.

@RequiredArgsConstructor // Lombok을 이용하여 생성자 주입을 위한 어노테이션을 붙입니다.
@Controller // 스프링 MVC 컨트롤러임을 선언합니다.
public class HomeControllerExplain {

    public final MemberService memberService; // MemberService 인스턴스를 생성자 주입을 통해 주입받습니다.

    // HTTP GET 요청을 처리하는 메서드로서, URL 경로가 "/" 일 때 실행됩니다.
    @GetMapping("/")
    public String home(Model model, @SessionAttribute(name = "loginId", required = false) String loginId) {
        // 세션 속성으로부터 loginId를 받아옵니다. 필수가 아니므로(required = false) 세션이 없을 경우 null이 될 수 있습니다.

        // MemberService를 통해 loginId에 해당하는 회원 정보를 가져옵니다.
        Member member = memberService.getMember(loginId);

        // 모델에 "loginName"이라는 속성으로 회원의 이름을 추가합니다.
        model.addAttribute("loginName", member.getName());

        // "home"이라는 뷰를 반환합니다. 이에 대한 실제 렌더링은 ViewResolver가 담당합니다.
        return "home";
    }
}

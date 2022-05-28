package healthmanagementservice2.healthmanagementservice2.controller;

import healthmanagementservice2.healthmanagementservice2.Login.SessionConst;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;
    @GetMapping("/")
    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
                            Member loginmember, Model model){
        if(loginmember==null){
            return "home";
        }
        return "loginHome"; //이따가 수정
    }

}

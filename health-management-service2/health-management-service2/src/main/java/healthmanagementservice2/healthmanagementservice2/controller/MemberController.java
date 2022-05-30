package healthmanagementservice2.healthmanagementservice2.controller;

import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.domain.SignMember;
import healthmanagementservice2.healthmanagementservice2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") SignMember signmember){
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("member") SignMember signMember, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "members/addMemberForm";
        }
        List<Member> findMembers = memberService.findByName(signMember.getName());
        if (!findMembers.isEmpty()) {
            bindingResult.reject("signFail","존재하는 아이디 입니다..");
            return "members/addMemberForm";
        }
        Member member=new Member();
        member.setName(signMember.getName());
        member.setPassword(signMember.getPassword());
        member.setLoginId(signMember.getLoginId());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping
    public String listMember(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "/members/memberList";
    }

}

package gechan.core.controller;

import gechan.core.domain.Member;
import gechan.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // @Component를 포함하고 있어 스프링 빈에 자동 등록
// @Controller는 스프링이 자동적으로 관리해야 하기 때문에 @Autowired를 사용
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        // memberList html의 ${members}를 찾아서 members 를 넣어준다
        return "members/memberList";
    }
}

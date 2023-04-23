package gechan.core.controller;

import gechan.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // @Component를 포함하고 있어 스프링 빈에 자동 등록
// @Controller는 스프링이 자동적으로 관리해야 하기 때문에 @Autowired를 사용
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

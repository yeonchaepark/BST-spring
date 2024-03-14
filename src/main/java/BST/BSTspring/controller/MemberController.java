package BST.BSTspring.controller;

import BST.BSTspring.Service.MailSendService;
import BST.BSTspring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MailSendService mss;


    @RequestMapping("/member/signUp")
    public void signUp(@ModelAttribute MemberDTO memberDTO){
        // DB에 기본정보 insert
        memberService.signUp(memberDTO);

        //임의의 authKey 생성 & 이메일 발송
        String authKey = mss.sendAuthMail(memberDTO.getEmail());
        memberDTO.setAuthKey(authKey);

        Map<String, String> map = new HashMap<String, String>();
        map.put("email", memberDTO.getEmail());
        map.put("authKey", memberDTO.getAuthKey());
        System.out.println(map);

        //DB에 authKey 업데이트
        memberService.updateAuthKey(map);

    }
    @GetMapping("/member/signUpConfirm")
    public ModelAndView signUpConfirm(@RequestParam Map<String, String> map, ModelAndView mav){
        //email, authKey 가 일치할경우 authStatus 업데이트
        memberService.updateAuthStatus(map);

        mav.addObject("display", "/view/member/signUp_confirm.jsp");
        mav.setViewName("/view/index");
        return mav;
    }
}

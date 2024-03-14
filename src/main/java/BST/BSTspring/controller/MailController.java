package BST.BSTspring.controller;

import BST.BSTspring.Service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String mail){
        int number=mailService.sendMail(mail);
        String num=""+number;
        return num;
    }
}

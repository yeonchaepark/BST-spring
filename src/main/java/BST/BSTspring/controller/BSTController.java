package BST.BSTspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BSTController {
    @GetMapping("BST") // "/BST"라고 하면 이 함수를 호출한다.
    public String BST(Model model){
        model.addAttribute("data","BST!!");
        return "BST";
    }
}

package mon.bugTracker.BugTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @RequestMapping("/members")
    public String getMembers(Model model){

        return "members";
    }
}

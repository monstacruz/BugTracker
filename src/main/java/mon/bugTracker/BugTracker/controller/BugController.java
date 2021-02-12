package mon.bugTracker.BugTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BugController {

    @RequestMapping("/bugs")
    public String getBugs(Model model){

        return "bugs";
    }
}

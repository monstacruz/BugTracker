package mon.bugTracker.BugTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @RequestMapping("/projects")
    public String getProjects(Model model){

        return "projects";
    }
}

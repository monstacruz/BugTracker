package mon.bugTracker.BugTracker.controller;

import mon.bugTracker.BugTracker.model.Member;
import mon.bugTracker.BugTracker.model.Project;
import mon.bugTracker.BugTracker.service.MemberService;
import mon.bugTracker.BugTracker.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    private final ProjectService projectService;
    private final MemberService memberService;

    public ProjectController(ProjectService projectService, MemberService memberService) {
        this.projectService = projectService;
        this.memberService = memberService;
    }

    @RequestMapping("/projects")
    public String getProjects(Model model){
        model.addAttribute("projects", projectService.getProjects());
        return "projects";
    }

    @RequestMapping("/projects/{id}")
    public String getProject(@PathVariable String id, Model model){
        model.addAttribute("project", projectService.findById(Long.parseLong(id)));
        model.addAttribute("members", memberService.findByProjectId(Long.parseLong(id)));
        return "project";
    }

    @RequestMapping("/add-project")
    public String addProject(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        model.addAttribute("freeMembers", memberService.getFreeMembers());
        return "add-project";
    }

    @PostMapping("project")
    public String createProject(@ModelAttribute Project project){
        projectService.createProject(project);
        return "redirect:/projects";
    }
}

package mon.bugTracker.BugTracker.controller;

import mon.bugTracker.BugTracker.model.Bug;
import mon.bugTracker.BugTracker.model.Member;
import mon.bugTracker.BugTracker.service.BugService;
import mon.bugTracker.BugTracker.service.MemberService;
import mon.bugTracker.BugTracker.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class BugController {
    private final BugService bugService;
    private final MemberService memberService;
    private final ProjectService projectService;

    public BugController(BugService bugService, MemberService memberService, ProjectService projectService) {
        this.bugService = bugService;
        this.memberService = memberService;
        this.projectService = projectService;
    }

    @RequestMapping("/bugs")
    public String getBugs(Model model){
        model.addAttribute("bugs", bugService.getBugs());
        return "bugs";
    }

    @RequestMapping("/bugs/{id}")
    public String getBug(@PathVariable String id, Model model){
        model.addAttribute("bug", bugService.findById(Long.parseLong(id)));
        return "bug";
    }

    @RequestMapping("/add-bug/{id}")
    public String addBug(@PathVariable String id, Model model){
        Bug bug = new Bug();
        model.addAttribute("bug", bug);
        model.addAttribute("members", memberService.findByProjectId(Long.parseLong(id)));
        model.addAttribute("project", projectService.findById(Long.parseLong(id)));
        return "add-bug";
    }

    @PostMapping("/bugResolve")
    public String resolveBug(@ModelAttribute Bug bug){
        bugService.changeStatus(bug);
        return "redirect:/projects/" + bug.getId();
    }

    @PostMapping("/bug")
    public String createBug(@ModelAttribute Bug bug, @ModelAttribute Member member){
        bugService.createBug(bug);
        return "redirect:/bugs";
    }
}

package mon.bugTracker.BugTracker.controller;

import mon.bugTracker.BugTracker.model.Member;
import mon.bugTracker.BugTracker.service.MemberService;
import mon.bugTracker.BugTracker.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final ProjectService projectService;

    public MemberController(MemberService memberService, ProjectService projectService) {
        this.memberService = memberService;
        this.projectService = projectService;
    }

    @RequestMapping("/members")
    public String getMembers(Model model){
        model.addAttribute("members", memberService.getMembers());
        return "members";
    }

    @RequestMapping("/members/{id}")
    public String getMember(@PathVariable String id,Model model){
        model.addAttribute("member", memberService.findById(Long.parseLong(id)));
        model.addAttribute("projects", projectService.getProjects());
        return "member";
    }

    @RequestMapping("/add-member")
    public String addMember(Model model){
        Member member = new Member();
        model.addAttribute("projects", projectService.getProjects());
        model.addAttribute("member", member);
        return "add-member";
    }

    @PostMapping("member")
    public String createMember(@ModelAttribute Member member){
        memberService.createOrUpdateMember(member);
        return "redirect:/members";
    }

}

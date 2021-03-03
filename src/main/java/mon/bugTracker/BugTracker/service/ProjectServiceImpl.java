package mon.bugTracker.BugTracker.service;

import mon.bugTracker.BugTracker.model.Member;
import mon.bugTracker.BugTracker.model.Project;
import mon.bugTracker.BugTracker.repositories.MemberRepository;
import mon.bugTracker.BugTracker.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    public ProjectServiceImpl(ProjectRepository projectRepository,
                              MemberRepository memberRepository,
                              MemberService memberService) {
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @Override
    public Project findById(Long id) {
       Optional<Project> project = projectRepository.findById(id);

       if(!project.isPresent())
           throw new RuntimeException("project not found");

       return project.get();
    }

    @Override
    public Set<Project> getProjects() {
        Set<Project> projects = new HashSet<>();

        projectRepository.findAll().iterator().forEachRemaining(projects::add);

        return projects;
    }

    @Override
    public Project createProject(Project project) {
        projectRepository.save(project);

        return project;
    }

    @Override
    public void assignProjectLead(Member lead) {
        Project tmpProject = projectRepository.findById(lead.getProject().getId()).get();
        tmpProject.setProjectLead(memberRepository.findById(lead.getId()).get());
        projectRepository.save(tmpProject);
    }

    @Override
    public void assignMember(Project project, Member member) {
        Project tmpProject = projectRepository.findById(project.getId()).get();
        tmpProject.getProjectMembers().add(member);
        projectRepository.save(tmpProject);

        memberService.assignProject(member, project);
    }
}

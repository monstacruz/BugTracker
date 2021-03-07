package mon.bugTracker.BugTracker.service;

import mon.bugTracker.BugTracker.model.Member;
import mon.bugTracker.BugTracker.model.Project;

import java.util.Set;

public interface ProjectService {

    Project findById(Long id);

    Project findByProjectLeadId(Long id);

    Set<Project> getProjects();

    Project createProject(Project project);

    void assignProjectLead(Member lead);

    void assignMember(Project project, Member member);

}

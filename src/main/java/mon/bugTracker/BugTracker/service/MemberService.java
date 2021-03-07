package mon.bugTracker.BugTracker.service;

import mon.bugTracker.BugTracker.model.Member;
import mon.bugTracker.BugTracker.model.Project;

import java.util.Set;

public interface MemberService {

    Member findById(Long id);

    Set<Member> getMembers();

    Set<Member> getFreeMembers();

    Set<Member> findByProjectId(Long id);

    Member createOrUpdateMember(Member member);

    Member updateMember(Member member);

    void assignProject(Member member, Project project);
}

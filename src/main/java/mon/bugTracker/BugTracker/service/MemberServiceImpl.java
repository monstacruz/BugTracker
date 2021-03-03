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
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    public MemberServiceImpl(MemberRepository memberRepository, ProjectRepository projectRepository) {
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Member findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if(!member.isPresent())
            throw new RuntimeException("Member not found");

        return member.get();
    }

    @Override
    public Set<Member> getMembers() {
        Set<Member> members = new HashSet<>();

        memberRepository.findAll().iterator().forEachRemaining(members::add);

        return members;
    }

    @Override
    public Set<Member> findByProjectId(Long id) {
        Set<Member> members = new HashSet<>();

        memberRepository.findByProjectId(id).iterator().forEachRemaining(members::add);

        return members;
    }

    @Override
    public Member createMember(Member member) {
        memberRepository.save(member);

        return member;
    }

    @Override
    public void assignProject(Member member, Project project) {
        member.setProject(projectRepository.findById(project.getId()).get());
        memberRepository.save(member);
    }
}

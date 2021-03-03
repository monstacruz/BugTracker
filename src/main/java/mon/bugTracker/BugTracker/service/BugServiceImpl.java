package mon.bugTracker.BugTracker.service;

import mon.bugTracker.BugTracker.model.Bug;
import mon.bugTracker.BugTracker.model.Member;
import mon.bugTracker.BugTracker.model.Project;
import mon.bugTracker.BugTracker.repositories.BugRepository;
import mon.bugTracker.BugTracker.repositories.MemberRepository;
import mon.bugTracker.BugTracker.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BugServiceImpl implements BugService{

    private final BugRepository bugRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    public BugServiceImpl(BugRepository bugRepository,
                          MemberRepository memberRepository,
                          ProjectRepository projectRepository) {
        this.bugRepository = bugRepository;
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Bug findById(Long id) {
        Optional<Bug> result = bugRepository.findById(id);

        if(!result.isPresent())
            throw new RuntimeException("Bug not found");

        return result.get();
    }

    @Override
    public Set<Bug> getBugs() {
        Set<Bug> bugs = new HashSet<>();
        bugRepository.findAll().iterator().forEachRemaining(bugs::add);

        return bugs;
    }

    @Override
    public Bug createBug(Bug bug, Member member) {
        //add bug to repository
        bugRepository.save(bug);

        //assign bug to the project
        Project tmpProject = projectRepository.findById(member.getProject().getId()).get();
        tmpProject.getBugs().add(bug);
        projectRepository.save(tmpProject);

        return bug;
    }

    @Override
    public Bug changeStatus(Bug bug) {
        return null;
    }
}

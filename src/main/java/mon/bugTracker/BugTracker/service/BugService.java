package mon.bugTracker.BugTracker.service;

import mon.bugTracker.BugTracker.model.Bug;
import mon.bugTracker.BugTracker.model.Member;

import java.util.Set;

public interface BugService {

    Bug findById(Long id);

    Set<Bug> getBugs();

    Bug createBug(Bug bug, Member member);

    Bug changeStatus(Bug bug);
}

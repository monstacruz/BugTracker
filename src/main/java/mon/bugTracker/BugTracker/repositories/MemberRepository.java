package mon.bugTracker.BugTracker.repositories;

import mon.bugTracker.BugTracker.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}

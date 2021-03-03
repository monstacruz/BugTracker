package mon.bugTracker.BugTracker.repositories;

import mon.bugTracker.BugTracker.model.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Set<Member> findByLastName(String lastName);
    Set<Member> findByProjectId(Long id);
}

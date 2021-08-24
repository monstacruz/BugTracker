package mon.bugTracker.BugTracker.repositories;

import mon.bugTracker.BugTracker.model.Bug;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BugRepository extends CrudRepository<Bug, Long> {

    Set<Bug> findByProjectId(Long id);
}

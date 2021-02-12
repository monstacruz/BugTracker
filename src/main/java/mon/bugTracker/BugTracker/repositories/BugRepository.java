package mon.bugTracker.BugTracker.repositories;

import mon.bugTracker.BugTracker.model.Bug;
import org.springframework.data.repository.CrudRepository;

public interface BugRepository extends CrudRepository<Bug, Long> {
}

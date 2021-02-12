package mon.bugTracker.BugTracker.repositories;

import mon.bugTracker.BugTracker.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}

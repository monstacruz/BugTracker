package mon.bugTracker.BugTracker.repositories;

import mon.bugTracker.BugTracker.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findByProjectLeadId(Long id);
}

package mon.bugTracker.BugTracker.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description, severity;
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Bug(){
    }

    public Bug(Long id, String description, String severity, LocalDate startDate, Project project) {
        this.id = id;
        this.description = description;
        this.severity = severity;
        this.startDate = startDate;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

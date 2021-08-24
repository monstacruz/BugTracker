package mon.bugTracker.BugTracker.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.print.attribute.standard.Severity;
import java.time.LocalDate;

@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description, severityString;
    private int severity;
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private LocalDate startDate;


    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @OneToOne
    @JoinColumn(name = "memberId")
    private Member member;

    public Bug(){
    }

    public Bug(Long id, String description, int severity, LocalDate startDate, Project project, Member member) {
        this.id = id;
        this.description = description;
        this.severity = severity;
        this.startDate = startDate;
        this.project = project;
        this.member = member;
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

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getSeverityString() {
        return severityString;
    }

    public void setSeverityString(String severityString) {
        this.severityString = severityString;
    }
}

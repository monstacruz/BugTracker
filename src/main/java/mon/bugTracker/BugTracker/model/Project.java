package mon.bugTracker.BugTracker.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate startDate;
    private String description;

    @OneToOne
    @JoinColumn(name="member_id", unique = true)
    private Member projectLead;

    @OneToMany(mappedBy="project")
    private Set<Member> projectMembers;

    @OneToMany(mappedBy="project")
    private Set<Bug> bugs;

    public Project(){
    }

    public Project(Long id, String name, LocalDate startDate,
                   String description, Member projectLead,
                   Set<Member> projectMembers, Set<Bug> bugs) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.description = description;
        this.projectLead = projectLead;
        this.projectMembers = projectMembers;
        this.bugs = bugs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getProjectLead() {
        return projectLead;
    }

    public void setProjectLead(Member projectLead) {
        this.projectLead = projectLead;
    }

    public Set<Member> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(Set<Member> projectMembers) {
        this.projectMembers = projectMembers;
    }

    public Set<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(Set<Bug> bugs) {
        this.bugs = bugs;
    }
}

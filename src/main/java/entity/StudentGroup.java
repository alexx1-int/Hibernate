package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "formed_at", nullable = false)
    private LocalDate formedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private StudyPlan plan;

    @Column(length = 50)
    private String status;

    @Column(name = "status_date")
    private LocalDate statusDate;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    // ------------ CONSTRUCTORS ------------

    public StudentGroup() {
    }

    public StudentGroup(String name, LocalDate formedAt, StudyPlan plan) {
        this.name = name;
        this.formedAt = formedAt;
        this.plan = plan;
    }

    // ------------ GETTERS & SETTERS ------------

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFormedAt() {
        return formedAt;
    }

    public StudyPlan getPlan() {
        return plan;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStatusDate() {
        return statusDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormedAt(LocalDate formedAt) {
        this.formedAt = formedAt;
    }

    public void setPlan(StudyPlan plan) {
        this.plan = plan;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusDate(LocalDate statusDate) {
        this.statusDate = statusDate;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", formedAt=" + formedAt +
                ", status='" + status + '\'' +
                ", statusDate=" + statusDate +
                '}';
    }
}

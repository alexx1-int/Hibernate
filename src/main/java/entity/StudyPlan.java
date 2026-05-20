package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plans")
public class StudyPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(length = 50)
    private String speciality;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentGroup> groups = new ArrayList<>();

    // ------------ CONSTRUCTORS ------------

    public StudyPlan() {
    }

    public StudyPlan(String code, String speciality, LocalDate createdAt) {
        this.code = code;
        this.speciality = speciality;
        this.createdAt = createdAt;
    }

    // ------------ GETTERS & SETTERS ------------

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getSpeciality() {
        return speciality;
    }

    public List<StudentGroup> getGroups() {
        return groups;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setGroups(List<StudentGroup> groups) {
        this.groups = groups;
    }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "StudyPlan{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", createdAt=" + createdAt +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}

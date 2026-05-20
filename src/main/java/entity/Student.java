package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_book_no")
    private Long recordBook;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;


    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 30)
    private String middleName;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 80)
    private String address;

    @Column(nullable = false, length = 30)
    private String phone;

    @Column(length = 50)
    private String status;

    @Column(name = "status_date")
    private LocalDate statusDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private StudentGroup group;

    // ------------ CONSTRUCTORS ------------

    public Student() {
    }

    public Student(Long recordBook, String lastName, String firstName, String middleName, String city, String address, String phone, String status, LocalDate statusDate, StudentGroup group) {
        this.recordBook = recordBook;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.statusDate = statusDate;
        this.group = group;
    }

    public Student(Long recordBook, String lastName, String firstName, String middleName, String city, String address, String phone, StudentGroup group) {
        this.recordBook = recordBook;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.group = group;
    }

    // ------------ GETTERS & SETTERS ------------

    public Long getRecordBook() {
        return recordBook;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStatusDate() {
        return statusDate;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setRecordBook(Long recordBook) {
        this.recordBook = recordBook;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusDate(LocalDate statusDate) {
        this.statusDate = statusDate;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "Student{" +
                "recordBookNo=" + recordBook +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                ", statusDate=" + statusDate +
                '}';
    }
}

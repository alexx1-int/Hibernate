package app;

import dao.GenericDAO;
import entity.StudyPlan;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {
        GenericDAO<StudyPlan> studyPlanDAO = new GenericDAO<>(StudyPlan.class);

        // CREATE
        StudyPlan plan1 = new StudyPlan("101/1-01",
                "IT",
                LocalDate.of(2020, 1, 10));

        StudyPlan plan2 = new StudyPlan("102/1-02",
                "Math",
                LocalDate.of(2021, 2, 15));

        StudyPlan plan3 = new StudyPlan("103/1-03",
                "Physics",
                LocalDate.of(2022, 3, 20));

        StudyPlan plan4 = new StudyPlan("104/1-04",
                "Economics",
                LocalDate.of(2023, 4, 5));

        StudyPlan plan5 = new StudyPlan("105/1-05",
                "Biology",
                LocalDate.of(2024, 5, 12));

        studyPlanDAO.create(plan1);
        studyPlanDAO.create(plan2);
        studyPlanDAO.create(plan3);
        studyPlanDAO.create(plan4);
        studyPlanDAO.create(plan5);
        System.out.println("5 StudyPlans was added!");

        // READ
        List<StudyPlan> plans = studyPlanDAO.readAll();
        plans.forEach(System.out::println);

        // READ BY ID
        StudyPlan plan = studyPlanDAO.read(plan1.getId());

        System.out.println("Found by id:");
        System.out.println(plan);

        // UPDATE
        plan.setSpeciality("Computer Science");
        studyPlanDAO.update(plan);

        System.out.println("Updated speciality");

        // DELETE
        studyPlanDAO.delete(plan5.getId());

        System.out.println("Deleted plan5");

        // FINAL LIST
        System.out.println("Remaining plans:");

        HibernateUtil.shutdown();
    }

}

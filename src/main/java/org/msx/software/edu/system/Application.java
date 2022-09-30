package org.msx.software.edu.system;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDateTime;
import org.msx.software.edu.system.model.entity.*;
import org.msx.software.edu.system.model.repository.CourseRepository;
import org.msx.software.edu.system.model.repository.EnrolmentRepository;
import org.msx.software.edu.system.model.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository, EnrolmentRepository enrolmentRepository,
            CourseRepository courseRepository) {
        return args -> {
            Faker faker = new Faker();
            String studentCode = "065680";
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@outlook.com", firstName, lastName);
            Timestamp dateOfBirth = new Timestamp(new LocalDateTime().toDate().getTime());
            Student student = new Student(studentCode, firstName, lastName, email, dateOfBirth);
            StudentIdCard studentIdCard = new StudentIdCard("654321", student);
            student.setStudentIdCard(studentIdCard);
            // add book
            String clean_code = "Clean Code";
            String think_and_grow_rich = "Think and Grow Rich";
            String spring_data_jpa = "Spring Data JPA";
            Timestamp now = new Timestamp(LocalDateTime.now().toDate().getTime());
            Timestamp fourDaysBefore = new Timestamp(LocalDateTime.now().minusDays(4).toDate().getTime());
            Timestamp eighteenDaysBefore = new Timestamp(LocalDateTime.now().minusDays(18).toDate().getTime());
            Timestamp oneYearBefore = new Timestamp(LocalDateTime.now().minusYears(1).toDate().getTime());
            Book clean_code_book = new Book(clean_code, fourDaysBefore);
            Book think_and_grow_rich_book = new Book(think_and_grow_rich, now);
            Book spring_data_jpa_book = new Book(spring_data_jpa, oneYearBefore);
            student.addBook(think_and_grow_rich_book);
            student.addBook(spring_data_jpa_book);
            student.addBook(clean_code_book);
            // add book
            //*********************************/
            Student persistedStudent = studentRepository.save(student);
            // add enrolment
            UUID uuid01 = UUID.randomUUID();
            UUID uuid02 = UUID.randomUUID();
            UUID uuid03 = UUID.randomUUID();
            Course computer_science_course = new Course("Computer Science", "IT", uuid01);
            Course math_science_course = new Course("Math Science", "Mathematics", uuid02);
            Course physics_science_course = new Course("physics Science", "IT", uuid03);
            List<Course> courseList = new ArrayList<>();
            courseList.add(computer_science_course);
            courseList.add(math_science_course);
            courseList.add(physics_science_course);
            List<Course> persistedCourseList = courseRepository.saveAll(courseList);
            persistedCourseList.forEach(course -> {
                EnrolmentId enrolmentId = new EnrolmentId(persistedStudent.getId(), course.getId());
                Enrolment enrolment = new Enrolment();
                if (uuid01.equals(course.getUuid())) {
                    enrolment = new Enrolment(enrolmentId, persistedStudent, course, eighteenDaysBefore);
                } else if (uuid02.equals(course.getUuid())) {
                    enrolment = new Enrolment(enrolmentId, persistedStudent, course, oneYearBefore);
                } else if (uuid03.equals(course.getUuid())) {
                    enrolment = new Enrolment(enrolmentId, persistedStudent, course, fourDaysBefore);
                }
                persistedStudent.addEnrolment(enrolment);
            });
            // add enrolment
            Student doublePersistedStudent = studentRepository.save(persistedStudent);
            log.info(String.format("%s %s with %s card number",
                    doublePersistedStudent.getFirstName(),
                    doublePersistedStudent.getLastName(),
                    doublePersistedStudent.getStudentIdCard().getCardNumber()));
            doublePersistedStudent.getEnrolmentList().forEach(enrolment -> {
                log.info(
                        String.format("Enrolment At %s for %s Course in %s department",
                                enrolment.getCreatedAt(),
                                enrolment.getCourse().getName(),
                                enrolment.getCourse().getDepartment()));
            });
            doublePersistedStudent.getBookList().forEach(book -> {
                log.info(
                        String.format("Borrowed At %s The %s Book",
                                book.getCreatedAt(),
                                book.getName()));
            });
//            studentRepository.findById(1L).stream().findFirst().ifPresent(loadedStudent -> {
//                enrolmentRepository.findByStudentId(loadedStudent.getId()).forEach(loadedStudent::removeEnrolment);
//            });
//            studentRepository.findById(1L).stream().findFirst().ifPresent(loadedStudent -> {
//                for (Enrolment enrolment : loadedStudent.getEnrolmentList()) {
//                        loadedStudent.removeEnrolment(enrolment);
//                }
//            });
//            Optional<Student> foundedStudent = studentRepository.findById(1L);
//            if (foundedStudent.isPresent()){
//                List<Enrolment> foundedEnrolmentList = enrolmentRepository.findByStudentId(1L);
//                foundedEnrolmentList.forEach(enrolment -> {
//                    System.out.println(enrolment);
//                });
//            }
//            Optional<Student> foundedStudent = studentRepository.findById(1L);
//            if (foundedStudent.isPresent()){
//                Student student = foundedStudent.get();
//                List<Enrolment> foundedEnrolmentList = enrolmentRepository.findByStudentId(1L);
//                foundedEnrolmentList.forEach(enrolment -> {
//                    student.removeEnrolment(enrolment);
//                    studentRepository.save(student);
//                });
//            }
        };
    }
}
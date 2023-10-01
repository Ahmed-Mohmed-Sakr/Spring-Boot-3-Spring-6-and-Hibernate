package com.springboot.section09jpa_hibernates_advanced;

import com.springboot.section09jpa_hibernates_advanced.entity.Course;
import com.springboot.section09jpa_hibernates_advanced.entity.Instructor;
import com.springboot.section09jpa_hibernates_advanced.entity.InstructorDetail;
import com.springboot.section09jpa_hibernates_advanced.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Section09JpaHibernatesAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section09JpaHibernatesAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository repository) {
		return runner -> {
//			createInstractor(repository);
//			getInstractorByI(repository);
//			deleteInstractorByID(repository);

			createInstractorWithCourses(repository);

		};
	}

	private void createInstractorWithCourses(InstructorRepository repository) {
		InstructorDetail instructorDetail = InstructorDetail.builder()
				.youtubeChannel("youtube.com")
				.hobby("football")
				.build();

		Instructor tempInstructor =
				Instructor.builder()
						.firstName("ahmed")
						.lastName("sakr")
						.email("ahmed@gmail.com")
						.instructorDetail(instructorDetail)
						.build();


		Course theCourse1 =
				Course.builder()
						.title("new course 1")
						.build();

		Course theCourse2 =
				Course.builder()
						.title("new course 2")
						.build();

		tempInstructor.addCourse(theCourse1);
		tempInstructor.addCourse(theCourse2);

		repository.save(tempInstructor);
	}

	private void deleteInstractorByID(InstructorRepository repository) {
		try {
			repository.deleteById(1);
		}catch (Exception ex) {
			System.out.println("not found");
		}
	}

	private void getInstractorByI(InstructorRepository repository) {
		System.out.println(repository.findById(1));
	}

	private void createInstractor(InstructorRepository repository) {
		InstructorDetail instructorDetail = InstructorDetail.builder()
				.youtubeChannel("youtube.com")
				.hobby("football")
				.build();

		Instructor tempInstructor =
				Instructor.builder()
						.firstName("ahmed")
						.lastName("sakr")
						.email("ahmed@gmail.com")
						.instructorDetail(instructorDetail)
						.build();

		repository.save(tempInstructor);
	}

}

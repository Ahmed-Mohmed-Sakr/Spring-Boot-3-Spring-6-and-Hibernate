package com.springboot.section09jpa_hibernates_advanced;

import com.springboot.section09jpa_hibernates_advanced.entity.Course;
import com.springboot.section09jpa_hibernates_advanced.entity.Instructor;
import com.springboot.section09jpa_hibernates_advanced.entity.InstructorDetail;
import com.springboot.section09jpa_hibernates_advanced.repository.CourseRepository;
import com.springboot.section09jpa_hibernates_advanced.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Section09JpaHibernatesAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section09JpaHibernatesAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository repository, CourseRepository courseRepository) {
		return runner -> {
//			createInstractor(repository);
//			getInstractorByI(repository);
//			deleteInstractorByID(repository);

//			createInstractorWithCourses(repository);\

//			findInstractorWithCourses(repository);
//			updateCourse(courseRepository);
			deleteInstractor(repository);
		};
	}

	private void deleteInstractor(InstructorRepository repository) {
		Instructor instructor = repository.findById(1).get();

		List<Course> courses= repository.findCoursesByInstructorId(1);

		for (Course course:courses){
			course.setInstructor(null);
		}

		instructor.setCourses(courses);


		repository.delete(instructor);
	}

	private void updateCourse(CourseRepository courseRepository) {
		Course theCourse = courseRepository.findById(10).get();

		theCourse.setTitle("my first course");

		courseRepository.save(theCourse);

	}

	private void findInstractorWithCourses(InstructorRepository repository) {
//		Optional<Instructor> instructor = repository.findById(1);
//
//		if (instructor.isEmpty()) {
//			System.out.println("nothing here");
//		}
//
////		System.out.println(instructor.get().getCourses().stream().map(Course::getTitle).collect(Collectors.toList()));

		System.out.println(repository.findCoursesByInstructorId(1).stream().map(Course::getTitle).collect(Collectors.toList()));
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

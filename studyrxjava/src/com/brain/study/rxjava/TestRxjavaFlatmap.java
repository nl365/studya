/**
 * 
 */
package com.brain.study.rxjava;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;

// 课程
class Course {
	private String courseName; // 名称
	private int score;// 成绩

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Course(String courseName, int score) {
		super();
		this.courseName = courseName;
		this.score = score;
	}
}

class Student {
	private String name;
	private int age;
	private List<Course> courseList;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.courseList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Course> getCourse() {
		return courseList;
	}

	public void addCourse(Course course) {
		this.courseList.add(course);
	}

	public void setStudentCourse(int yuwen, int shuxue, int waiyu) {
		addCourse(new Course("语文", yuwen));
		addCourse(new Course("数学", shuxue));
		addCourse(new Course("外语", waiyu));
	}
}

/**
 * @author brain
 *
 */
public class TestRxjavaFlatmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 testRxjavaFlatMap();
	}

	public static void testRxjavaFlatMap() {
		List<Student> list = genTestData();
		Observable.from(list)
				.doOnNext(s -> System.out.println(s.getName()+","+s.getAge()+" "))
				.flatMap(s -> Observable.from(s.getCourse()))
				.doOnNext(c -> System.out.println(c.getCourseName() + ":" + c.getScore()))
				.filter(c -> c != null && c.getScore() > 85)
				.flatMap(c -> Observable.just(c.getCourseName() + ":" + c.getScore() + " 优秀"))
				.subscribe(s -> System.out.println(s));
	}

	private static List<Student> genTestData() {
		Student student1 = new Student("zhangsan", 13);

		student1.setStudentCourse(90, 98, 78);
		Student student2 = new Student("lisi", 14);
		student2.setStudentCourse(79, 40, 96);
		Student student3 = new Student("wangwu", 15);
		student3.setStudentCourse(85, 88, 86);

		List<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		return list;
	}

}

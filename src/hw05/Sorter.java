package hw05;

import java.util.Comparator;

public class Sorter {
	/**
	 * Return an instance of a class that realizes the Comparator interface. The
	 * class should be an inner class. You must write the inner class, then
	 * return an instance of it. It should compare students based on student id.
	 * Students with lower student ids should come first.
	 * 
	 * @return an instance of a class that implements Comparator<Student>
	 */
	public static Comparator<Student> getStudentIdComparator() {
		class studentComparator implements Comparator<Student> {
			@Override
			public int compare(Student s1, Student s2) {
				return (int) s1.getId() - s2.getId();
			}
		}
		return new studentComparator();
	}

	/**
	 * Return an instance of a class that realizes the Comparator interface. The
	 * class should be an inner class. You must write the inner class, then
	 * return an instance of it. It should compare courses based on department
	 * code. Compare them based on alphabetical ordering. "cs" comes before
	 * "mus"
	 * 
	 * @return an instance of a class that implements Comparator<Course>
	 */
	public static Comparator<Course> getDepartmentComparator() {
		class departmentComparator implements Comparator<Course> {
			@Override
			public int compare(Course c1, Course c2) {
				return c1.getDepartment().compareTo(c2.getDepartment());
			}
		}
		return new departmentComparator();

	}

	/**
	 * Use selection sort to sort courses based on the number of enrolled
	 * students. Courses with fewer students should come first.
	 * 
	 * @param courses
	 *            the array of courses to sort
	 */
	public static void selectionSortCourses(Course[] courses) {

		for (int i = 0; i < courses.length - 1; i++) {
			int minPos = i;

			for (int j = i + 1; j < courses.length; j++) {
				if (courses[j].size() < courses[minPos].size())
					minPos = j;
			}

			Course temp = courses[minPos];
			courses[minPos] = courses[i];
			courses[i] = temp;
		}
	}

	/**
	 * Use merge sort to sort students based on their last names. Use
	 * alphabetical ordering based on the lastName field. So a student with the
	 * last name "arthur" should come before a student with the last name
	 * "presley".
	 * 
	 * @param students
	 *            the array to sort
	 */
	public static Student[] mergeSortStudents(Student[] students) {
		// base case
		if (students.length <= 1)
			return students;

		// first and second
		Student[] first = new Student[students.length / 2];
		Student[] second = new Student[students.length - first.length];

		// add everything to first and second
		for (int i = 0; i < first.length; i++) {
			first[i] = students[i];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = students[i + first.length];
		}
		// recursion
		mergeSortStudents(first);
		mergeSortStudents(second);

		int firstPos = 0;
		int secondPos = 0;
		int i = 0;

		while (firstPos < first.length && secondPos < second.length) {
			// compare first and second
			if (first[firstPos].getLastName().compareTo(
					second[secondPos].getLastName()) < 0) {

				students[i] = first[firstPos];
				firstPos++;
			} else {
				students[i] = second[secondPos];
				secondPos++;
			}
			i++;
		}

		while (firstPos < first.length) {
			students[i] = first[firstPos];
			firstPos++;
			i++;
		}
		while (secondPos < second.length) {
			students[i] = second[secondPos];
			secondPos++;
			i++;
		}
		return students;
	}

	/**
	 * Use binary search on the lastName field to return the index where the
	 * student is located in the array or -1 if that student isn't in the array.
	 * 
	 * This will require a recursive helper method.
	 * 
	 * @param students
	 *            the array to search
	 * @return the index where the student is found, or -1 if not found
	 */
	public static int binarySearchStudents(String lastName, Student[] students) {

		return search(students, 0, students.length - 1, lastName);
	}

	// helper method
	private static int search(Student[] student, int low, int high,
			String lastName) {

		if (low <= high) {
			int mid = (low + high) / 2;

			if (student[mid].getLastName() == lastName)
				return mid;

			else if (student[mid].getLastName().compareTo(lastName) < 0)
				return search(student, mid + 1, high, lastName);

			else
				return search(student, low, mid - 1, lastName);
		} else

			return -1;
	}
}

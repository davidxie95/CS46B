package hw07;

/**
 * ToDoList. This class encapsulates a task list using a singly-linked list.
 */
public class ToDoList {
	private Task first;

	public ToDoList() {
		first = null;
	}

	public ToDoList(Task first) {
		this.first = first;
	}

	/**
	 * addFirst. Add a Task at the front of the list.
	 * 
	 * @param newTask
	 *            the Task to add
	 */
	public void addFirst(Task newTask) {

		if (first != null)
			newTask.next = first;
		first = newTask;

	}

	/**
	 * addLast. Add a Task at the end of the list.
	 * 
	 * @param newTask
	 *            the Task to add
	 */
	public void addLast(Task newTask) {

		if (first != null) {
			Task temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newTask;
		}

	}

	/**
	 * setComplete. For the task with the given name, mark it as complete. If
	 * the Task doesn't exist, then do nothing.
	 * 
	 * @param name
	 *            the name of the task to mark complete (set complete = true)
	 */
	public void setComplete(String name) {
		if (first != null) {
			Task temp = first;
			do {
				if (temp.getName().equals(name))
					temp.setComplete(true);
				temp = temp.next;
			} while (temp.next != null);
		}
	}

	/**
	 * get. Return the Task at position i, if one exists. Otherwise, return
	 * null. The first item is at index 0.
	 * 
	 * @param i
	 *            the index to check
	 * @return the Task at that index
	 */
	public Task get(int i) {
		int counter = 0;
		if (first != null) {
			Task temp = first;

			while (temp != null) {
				if (counter == i) {
					return temp;
				}
				temp = temp.next;
				counter++;
			}
		}
		return null;
	}

	/**
	 * print. Print ONLY THE INCOMPLETE tasks to console. So print only the
	 * tasks where complete == false. Print a numbered list.
	 * 
	 * 1. name of first incomplete Task 2. name of second incomplete Task 3.
	 * namd of third ... 4. etc
	 */
	public void print() {
		Task temp = first;
		int counter = 1;
		while (temp != null) {
			if (temp.getComplete() == false) {
				System.out.println(counter + ". " + temp.getName());
				counter++;
			}
			temp = temp.next;
		}
	}
}

package myclasses.demos.ds.queue.priorityqueue;

// TODO: Auto-generated Javadoc
/**
 * The Class PriorityQueue.
 */
public class PriorityQueue {

	/** The priority queue array. */
	private final int[] priorityQueueArray;

	/** The front. */
	private int front;

	/** The rear. */
	private int rear;

	/** The n elem. */
	private int nElem;

	/** The max size. */
	private final int maxSize;

	/**
	 * Instantiates a new priority queue.
	 * 
	 * @param size
	 *            the size
	 */
	public PriorityQueue(int size) {
		maxSize = size;
		priorityQueueArray = new int[maxSize];
		front = 0;
		rear = -1;
		nElem = 0;
	}

	/**
	 * Checks if is empty.
	 * 
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return (rear == -1 && front == 0) || (front > rear);
	}

	/**
	 * Checks if is full.
	 * 
	 * @return true, if is full
	 */
	public boolean isFull() {
		return nElem == maxSize - 1;
	}

	/**
	 * Insert.
	 * 
	 * @param iValue
	 *            the i value
	 */
	public void insert(int iValue) {
		if (!isFull()) {
			if (rear == maxSize - 1) {
				rear = -1;
			}
			if (rear == -1) {
				priorityQueueArray[++rear] = iValue;
				System.out.println("Inserted: " + priorityQueueArray[rear]);
			} else if (rear == 0 && iValue > priorityQueueArray[rear]) {
				shift(front, rear);
				priorityQueueArray[front] = iValue;
				System.out.println("Inserted: " + priorityQueueArray[rear]);
			} else if (iValue < priorityQueueArray[rear]) {
				priorityQueueArray[++rear] = iValue;
				System.out.println("Inserted: " + priorityQueueArray[rear]);
			} else {
				for (int iRear = rear; iRear >= front; iRear--) {
					if (iValue < priorityQueueArray[iRear]) {
						shift(iRear, rear);
						priorityQueueArray[iRear + 1] = iValue;
						System.out.println("Inserted: "
								+ priorityQueueArray[iRear + 1]);
						break;
					}
				}

			}
		}
	}

	/**
	 * Shift.
	 * 
	 * @param front2
	 *            the front2
	 * @param rear2
	 *            the rear2
	 */
	private void shift(int front2, int rear2) {
		for (int i = rear2; i >= front2; i--) {
			priorityQueueArray[i + 1] = priorityQueueArray[i];
		}
		rear++;
	}

	/**
	 * Removes the.
	 */
	public void remove() {
		if (!isEmpty()) {
			if (front == maxSize) {
				front = 0;
			}
			System.out.println("Removed elem: " + priorityQueueArray[front++]);
			nElem--;
		}
	}

	/**
	 * Display.
	 */
	public void display() {
		System.out.print("Priority Queue First --> Last: ");
		int i = front;
		do {
			if (i == maxSize) {
				i = 0;
			}
			System.out.print(priorityQueueArray[i] + " ");
			i++;

		} while (i != rear + 1);

		System.out.println("");
	}
}

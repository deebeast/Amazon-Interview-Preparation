import java.util.Random;

/**
 * This version does not deadlock.  A philosopher picks up both chopsticks at the same time.
 * Philosophers might stave.  (Sad day.)
 *
 * @author Barbara Lerner
 * @version Oct 5, 2010
 *
 */
public class DiningPhilosophersUsingMonitor {
	// The number of philosophers
	private static final int NUM_PHILOSOPHERS = 5;

	/**
	 * Test the dining philosophers solution
	 * @param args Not used
	 */
	public static void main (String[] args) {
		Philosopher5[] philosophers = new Philosopher5[NUM_PHILOSOPHERS];

		// Monitor will ensure that a philosopher picks up both chopsticks at the
		// same time
		PhilosopherMonitor monitor = new PhilosopherMonitor(NUM_PHILOSOPHERS);

		for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
			philosophers[i] = new Philosopher5(i, monitor);
			new Thread(philosophers[i]).start();
		}
	}

}

/**
 * A philosopher alternates between thinking and eating.  To eat, the philosopher needs to pick
 * up the left chopstick and then the right chopstick sequentially.  The phillosopher shares
 * chopsticks with its neighbors, so it cannot eat at the same time as either neighbor.
 *
 * @author Barbara Lerner
 * @version Oct 5, 2010
 *
 */
class Philosopher5 implements Runnable {
	// Used to vary how long a philosopher thinks before eating and how long the
	// philosopher eats
	private Random numGenerator = new Random();

	// The philosopher's unique id
	private int id;

	// Controls when a philosopher can pick up chopsticks
	private PhilosopherMonitor monitor;

	/**
	 * Constructs a new philosopher
	 * @param id the unique id
	 * @param monitor the object that controls picking up chopsticks
	 */
	public Philosopher5 (int id, PhilosopherMonitor monitor) {
		this.id = id;
		this.monitor = monitor;
	}

	/**
	 * Repeatedly think, pick up chopsticks, eat and put down chopsticks
	 */
	public void run() {
		try {
			while (true) {
				think();
				monitor.pickUpChopsticks(id);
				eat();
				monitor.putDownChopsticks(id);
			}
		} catch (InterruptedException e) {
			System.out.println("Philosopher " + id + " was interrupted.\n");
		}
	}

	/**
	 * Lets a random amount of time pass to model thinking.
	 * @throws InterruptedException
	 */
	private void think() throws InterruptedException {
		System.out.println("Philosopher " + id + " is thinking.\n");
		System.out.flush();
		Thread.sleep (numGenerator.nextInt(10));
	}

	/**
	 * Lets a random amount of time pass to model eating.
	 * @throws InterruptedException
	 */
	private void eat() throws InterruptedException {
		Thread.sleep (numGenerator.nextInt(10));
	}


}

/**
 * Makes sure a philosopher only picks up chopsticks when neither neighbor
 * is eating.
 *
 * @author Barbara Lerner
 * @version Oct 5, 2010
 *
 */
class PhilosopherMonitor {
	// The states a philosopher can be in
	private enum State {THINKING, HUNGRY, EATING};

	// The state of each philosopher
	private State[] philosopherState;

	/**
	 * Creates a monitor for the right number of philosophers.
	 * Initially all philosophers are thinking.
	 * @param numPhilosophers number of philosophers
	 */
	public PhilosopherMonitor (int numPhilosophers) {
		philosopherState = new State[numPhilosophers];
		for (int i = 0; i < philosopherState.length; i++) {
			philosopherState[i] = State.THINKING;
		}
	}

	/**
	 * A philosopher picks up both chopsticks.  The philosopher waits if either
	 * neighbor is eating
	 *
	 * @param philosopherId the philosopher who wants to eat
	 * @throws InterruptedException the thread was interrupted
	 */
	public synchronized void pickUpChopsticks(int philosopherId) throws InterruptedException {
		// Remember this philosopher wants to eat
		philosopherState[philosopherId] = State.HUNGRY;
		System.out.println("Philosopher " + philosopherId + " is hungry.\n");
		System.out.flush();

		// Wait until neither neighbor is eating
		while (someNeighborIsEating(philosopherId)) {
			wait();
		}

		// Record that this philosopher is now eating
		philosopherState[philosopherId] = State.EATING;
		System.out.println("Philosopher " + philosopherId + " is eating.\n");
		System.out.flush();
	}

	/**
	 * Return true if either neighbor is currently eating
	 * @param philosopherId the philosopher whose neighbors are checked
	 * @return true if either neighbor is currently eating
	 */
	private boolean someNeighborIsEating(int philosopherId) {
		// Check philosopher to the one side
		if (philosopherState[(philosopherId + 1) % philosopherState.length] == State.EATING){
			return true;
		}

		// Check philosopher on the other side
		if (philosopherState[(philosopherId + philosopherState.length - 1) % philosopherState.length] == State.EATING){
			return true;
		}

		// Neither is eating
		return false;
	}

	/**
	 * Put down both chopsticks.  Notify all the waiting philosophers in case one of them
	 * can now eat.
	 *
	 * @param philosopherId the philosopher who is done eating
	 */
	public synchronized void putDownChopsticks(int philosopherId) {
		philosopherState[philosopherId] = State.THINKING;
		notifyAll();
	}

}

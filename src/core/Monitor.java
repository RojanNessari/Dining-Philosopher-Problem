package core;
/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	// States of philosophers
    private enum State { THINKING, HUNGRY, EATING }
    private final State[] philosopherStates;
    private final Object[] chopsticks;
    private boolean someoneTalking = false; // Track if a philosopher is talking

	/**
	 * Constructor
	 */
    public Monitor(int numPhilosophers) {
        philosopherStates = new State[numPhilosophers];
        chopsticks = new Object[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            philosopherStates[i] = State.THINKING;
            chopsticks[i] = new Object(); // Each philosopher has a chopstick
        }
    }

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
    public synchronized void pickUp(int piTID) {
        int id = piTID - 1;
        philosopherStates[id] = State.HUNGRY;
        while (!canEat(id)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        philosopherStates[id] = State.EATING;
        System.out.println("Philosopher " + piTID + " picks up chopsticks.");
    }
	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
    public synchronized void putDown(int piTID) {
        int id = piTID - 1;
        philosopherStates[id] = State.THINKING;
        System.out.println("Philosopher " + piTID + " puts down chopsticks.");
        notifyAll(); // Notify all philosophers waiting
    }

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
    public synchronized void requestTalk() {
        while (someoneTalking) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        someoneTalking = true;
        System.out.println("Philosopher is now talking.");
    }

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
    public synchronized void endTalk() {
        someoneTalking = false;
        System.out.println("Philosopher has finished talking.");
        notifyAll(); // Allow others to talk
    }
	
	/*
	* Check if philosopher can eat (both chopsticks must be available)
    */
    private boolean canEat(int id) {
        int left = (id + philosopherStates.length - 1) % philosopherStates.length;
        int right = (id + 1) % philosopherStates.length;
        return philosopherStates[id] == State.HUNGRY &&
               philosopherStates[left] != State.EATING &&
               philosopherStates[right] != State.EATING;
    }
}

// EOF

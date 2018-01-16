import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Jingnong on 2017/4/20.
 */

public class CircularResource {

    final int capacity = 5; // Queue's capacity
    int counter = 0;
    BlockingQueue<Integer> queue;
    
    int maxNum = 0;
    
    /* constructor */
    public CircularResource(int maxNum) {
        queue = new ArrayBlockingQueue<>(capacity);
        this.maxNum = maxNum;
    }

    /* Produce resource */
    public void increase() throws InterruptedException {

        /* Wait until resource amount == 0 */
        while(queue.size() == capacity) {
            synchronized(queue) {
                System.out.println("Queue is full.");
                queue.wait();
            }
        }

        /* Increase resource amount until reach limit */
        synchronized(queue) {
            queue.offer(counter);
            System.out.println("Producer has produced #" + counter);
            System.out.println("The amount is " + queue.size());
            counter++;
            queue.notifyAll();
        }
    }


    /* Consume resource */
    public void decrease(int consumerNumber) throws InterruptedException {

        /* Wait until resource amount > 0 */
    	synchronized(queue) {
            if(!queue.isEmpty()){
            	System.out.println("Consumer #" + consumerNumber + " has consumed #" + queue.peek());
                queue.poll();
                System.out.println("The amount is " + queue.size());
                queue.notifyAll();
                --maxNum;
            } else{
            	Thread.sleep(50);
            }
        }
    }
}
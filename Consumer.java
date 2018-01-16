import java.util.concurrent.BlockingQueue;

/**
 * Created by Jingnong on 2017/4/20.
 */
public class Consumer implements Runnable {

    CircularResource resource;
    static int consumerNumber = 0; // Counter for consumers
    int num = 0; // Number# for each consumer


    /* Constructor */
    public Consumer(CircularResource r) {
        resource = r;
        consumerNumber++;
        num = consumerNumber;
    }

    @Override
    public void run() {
        /* Consume the resource until queue is empty. */
        while(resource.maxNum > 0) {
            try {
                resource.decrease(num);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer #" + num + " is finished.");
    }
}

import java.util.concurrent.BlockingQueue;

/**
 * Created by Jingnong on 2017/4/20.
 */
public class Producer implements Runnable {
    CircularResource resource;
    int maxProduce; // When producer has produced maxProduced resource, producer finishes.

    /* Constructor */
    public Producer(CircularResource r, int maxProduce) {
        resource = r;
        this.maxProduce = maxProduce;
    }

    @Override
    public void run () {
        for (int i = 0; i < maxProduce; i++) {
            try {
                resource.increase(); // Increase the amount of resource until reach maxProduce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer has produced maximum number of resource. Producer is finished");
    }
}
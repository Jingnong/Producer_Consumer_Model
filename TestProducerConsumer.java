import java.util.concurrent.BlockingQueue;

/**
 * Created by Jingnong on 2017/4/20.
 */
public class TestProducerConsumer {
    public static void main(String[] args) {

        /* Parse input to integer */
        int consumerNumber = Integer.parseInt(args[0]); // Take in number of consumers
        int maxProduced = Integer.parseInt(args[1]); // Take in maximum number of resource can be produced
        CircularResource resource = new CircularResource(maxProduced); // Create resource object

        /* Create producer threads */
        new Thread(new Producer(resource, maxProduced)).start();

        /* Create consumer threads */
        for(int i = 0; i < consumerNumber; i++) {
            new Thread(new Consumer(resource)).start();
        }
    }
}

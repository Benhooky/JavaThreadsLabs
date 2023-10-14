import java.util.Random;

public class BerryPickingSimulation {
  /**
   * The main function that starts the neighbor threads.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    // Create neighbor objects
    Neighbor neighbor1 = new Neighbor("N1");
    Neighbor neighbor2 = new Neighbor("N2");

    // Create thread1 to handle neighbor1
    Thread thread1 = new Thread(() -> {
      while (true) {
        neighbor1.enterField(neighbor2);
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    // Create thread2 to handle neighbor2
    Thread thread2 = new Thread(() -> {
      while (true) {
        neighbor2.enterField(neighbor1);
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    // Start the threads
    thread1.start();
    thread2.start();
  }
}

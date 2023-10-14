import java.util.Random;

class Neighbor {
    private String name;
    private boolean flag = false;

    Neighbor(String name) {
        this.name = name;
    }

    synchronized void raiseFlag() {
        flag = true;
        System.out.println(name + " raises the flag.");
    }

    synchronized void lowerFlag() {
        flag = false;
        System.out.println(name + " lowers the flag.");
    }

    /**
     * Enter the field with a neighbor.
     *
     * @param otherNeighbor the neighbor to enter the field with
     */
    synchronized void enterField(Neighbor otherNeighbor) {
        if (otherNeighbor.flag) {

            System.out.println(name + " raises the flag.");

            System.out.println(name + " sees " + otherNeighbor.name + "'s flag.");

            lowerFlag();

            System.out.println(name + " waits 5 seconds.");
        } else {

            raiseFlag();

            System.out.println(name + " enters the field.");

            // Collect a random number of berries (1 to 10)
            int berriesToCollect = new Random().nextInt(10) + 1;
            collectBerries(berriesToCollect);

            System.out.println(name + " leaves the field.");

            lowerFlag();
        }
    }

    /**
     * Collects berries for a specified amount of time.
     *
     * @param berriesToCollect The number of seconds to collect berries.
     */
    private void collectBerries(int berriesToCollect) {

        System.out.println(name + " is collecting berries for " + berriesToCollect + " seconds.");

        try {
            Thread.sleep(berriesToCollect * 1000);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted while collecting berries.");
        }
    }
}
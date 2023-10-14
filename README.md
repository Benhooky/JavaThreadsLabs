# 1 Lab
# Berry Picking Simulation

**Berry Picking Simulation** is a Java program that simulates a scenario where two neighbors, N1 and N2, share a field of berries. They have agreed to a protocol to ensure that only one of them can be in the field at any given time. The protocol involves raising and lowering flags to signal their presence, and it also keeps track of the number of berries they collect.

## Program Structure

The program comprises two primary classes:

- `BerryPickingSimulation`: The main class that starts the neighbor threads. It creates two `Neighbor` objects, `neighbor1` and `neighbor2`, and two threads to handle each neighbor's actions.

- `Neighbor`: Represents a neighbor and contains methods for raising and lowering flags, entering the field, and collecting berries. The `Neighbor` class is synchronized to ensure thread safety.

## How the Simulation Works

- Each neighbor (a `Neighbor` object) runs in its own thread and continuously attempts to enter the field.

- When a neighbor wants to enter the field, they follow the protocol:
  1. If they see the flag of the other neighbor raised, they raise their own flag, indicating that they are waiting.
  2. If they don't see the other neighbor's flag raised, they raise their flag, enter the field, collect a random number of berries, and then lower their flag.

- Berries are collected for a random amount of time (between 1 and 10 seconds) to simulate the berry-picking process.

- The simulation runs indefinitely, with each neighbor taking turns based on the protocol.

## How to Run the Program

To run the program, follow these steps:

1. Clone the repository to your local machine.

2. Navigate to the "1_lab" directory.

3. Compile and run the project using the following commands:

```bash
javac BerryPickingSimulation.java
java BerryPickingSimulation

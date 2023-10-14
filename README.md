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
```
# 2 Lab
# Parallel Linear System Solver with Tridiagonal Matrices

**Parallel Linear System Solver with Tridiagonal Matrices** is a Java program that focuses on the solution of linear systems with tridiagonal matrices. The project demonstrates the implementation of a highly efficient method known as the Tridiagonal Matrix Algorithm, or "the method of elimination," for solving these systems. It further introduces parallelization to enhance performance.

## Introduction

The solution of linear systems is fundamental to computational mathematics, applicable to a wide range of practical problems, making it one of the most common and vital tasks in the field of computational mathematics. While numerous methods and software packages are available for solving linear systems, understanding the fundamental principles of these methods and their algorithms is essential for effective utilization.

This project deals with the particular case where linear systems feature matrices that are sparsely populated, containing many zero elements. However, these matrices also exhibit a specific structure. In this context, the project focuses on tridiagonal matrices. Tridiagonal matrices have non-zero elements primarily along the main diagonal and the two adjacent diagonals.

## Tridiagonal Matrix Solution Method

The project implements the "Tridiagonal Matrix Algorithm" or "Gaussian Elimination" to solve linear systems with tridiagonal matrices. This algorithm simplifies the process of solving linear systems with tridiagonal matrices, reducing the number of required operations significantly.

## Method Implementation

The implementation of the tridiagonal matrix solver includes the following key steps:

1. **Forward Pass**: In this step, the program calculates the "alpha" and "beta" coefficients, which are essential for solving the tridiagonal system. This step begins with the first equation and iterates forward to calculate coefficients for each equation.

2. **Backward Pass**: The backward pass is where the solution values for the variables are determined. Starting from the last equation, the program iterates backward to compute the variables' values.

3. **Parallelization**: The program leverages multi-threading to parallelize the forward and backward passes, improving the efficiency and performance of the solver. This parallelization enables faster solutions for larger systems.
 
## Program Structure
The program comprises two main Java files:

Main.java: This file is responsible for reading a tridiagonal matrix and a vector b from the "matrix.txt" file. It then uses the SLAUSolver class to solve the linear system and displays the results.

SLAUSolver.java: This class implements the parallel tridiagonal matrix algorithm for solving linear systems with tridiagonal matrices. It utilizes multi-threading to enhance efficiency.

The program also includes a sample data file:

matrix.txt: This file contains a sample tridiagonal matrix and vector b for testing the program. You can replace the data in this file with your own linear system for solving.
This structure outlines the key components of the program and how they work together to solve linear systems with tridiagonal matrices.

## Usage

To use this program, follow these steps:

1. Clone the repository to your local machine.

2. Navigate to the project directory.

3. Compile and run the project using the following commands:

   ```bash
   javac SLAUSolver.java
   java SLAUSolver


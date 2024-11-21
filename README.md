# Mars Rover Project

## Overview
The Mars Rover project simulates rovers navigating a grid-based plateau on Mars. Rovers can move, rotate, and execute commands based on user inputs or predefined examples. The project adheres to **SOLID principles** and follows a modular design for scalability and maintainability.

---

## Features
- Simulates rover navigation on a grid-based plateau.
- Supports multiple rovers with sequential movement.
- User-friendly setup with custom or example inputs.
- Modular and extensible architecture for future enhancements.

---

## The Task: [Mars Rover Brief](https://github.com/JacksonR64/mars-rover-brief)

### The Plateau
The surface of Mars is represented by a Plateau, assumed to be a square/rectangular grid.

### Rover Position
A Rover's position is represented by:
- **X and Y coordinates**: Denoting grid location.
- **Cardinal direction**: `N` (North), `E` (East), `S` (South), or `W` (West).

### Input Format
1. Plateau creation (first line):
    - Example: `5 5` (a 5x5 grid plateau).
2. Rover setup:
    - Position: Example: `1 2 N` (x=1, y=2, facing North).
    - Movement instructions: Example: `LMLMLMLMM`.

### Output
The output shows the final position of each rover after executing all commands:
- Example Input:
  ```
  5 5
  1 2 N
  LMLMLMLMM
  3 3 E
  MMRMMRMRRM
  ```
- Example Output:
  ```
  1 3 N
  5 1 E
  ```

---

## How It Works

### Setup Process
1. **Plateau Setup**: Enter the grid dimensions (e.g., `5 5`).
2. **Rover Setup**: Specify the initial rover position and facing direction (e.g., `1 2 N`).
3. **Instruction Input**: Provide movement commands (`L`, `R`, `M`).

### Execution
- Rovers execute movement sequentially.
- Instructions are logged in `InstructionsLog` and executed via `InstructionExecutor`.

---

## Example Input and Output

### Input:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

### Output:
```
1 3 N
5 1 E
```

---

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/JacksonR64/jv-mars-rover.git
   cd mars-rover
   ```

2. **Compile the Code**:
   ```bash
   mvn compile
   ```

3. **Run the Application**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

---

## Future Enhancements
- Extendable to drones or other movable objects.
- Additional input sources (e.g., file-based input).
- Advanced instruction types (e.g., diagonals, 3D movement).
- Basic graphical user interface

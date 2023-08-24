# MartianRobots-CodingChallenge 🤖

This project has been developed to resolve the Martian Robots coding challenge. Here, you can find information about solution details and how to run the program.

**Martian Robots Coding Challenged designed in Kotlin as an Android Application**.

# Table of contents
1. [General information](#general-information)
   1. [Input](#input)
   2. [Output](#output)
2. [Screenshots](#screenshots)
3. [Technologies](#technologies)
4. [Testing](#testing)


## General information

MartianRobots app comes in handy when you want to control your robots on Mars, using a simple yet efficient Android Application.

### Input

You must provide:
* Grid upper-right coordinates.
* Robot initial position and orientation.
* Robot instructions (a robot can turn left (L), turn right (R) or move forward (F)).

An example would be:
```
5 3 - Grid Coordinates
1 1 E - Robot 1 Initial Coordinates and Orientation
RFRFRFRF - Robot 1 Instructions
3 2 N - Robot 2 Initial Coordinates and Orientation
FRRFLLFFRRFLL - Robot 2 Instructions
```

This input represents:
- A planet of size 6x4, whose:
  - lower-left coordinates are `(0,0)`
  - upper-right coordinates are `(5,3)`
- Robot 1 which is located in `(1,1)`, looking **EAST**.
- Its instructions are `RFRFRFRF`.
- Robot 2 which is locatied in `(3,2)`, looking **NORTH**.

### Output

After the robot has executed all the instructions, the system will save the final position of the robot and display it in a saved memory.

For each robot, there will be information about:
- Robot final coordinates and orientation.
- Information about lost robots.

For example, the output corresponding to the previous input would be:
```
1 1 E 
3 3 N LOST! 

```
## Screenshots
<p float="left">
  <img src="https://github.com/makos000/MartianRobots-RedBadger/assets/107891560/b5b0c840-c208-48a8-a0b8-c820aa987234" width="250">
  <img src="https://github.com/makos000/MartianRobots-RedBadger/assets/107891560/df954a9f-a072-4ff5-bd79-d923e2e5e8f9" width="250">
</p>


## Technologies

- **Kotlin** is used as primary programming language.
- **Jetpack Compose** is the toolkit used for building the UI.

## Testing

**JUnit4** and **Truth** libraries were used for testing.

Test cases
- turnLeft should change orientation to the left correctly.
- turnRight should change orientation to the right correctly.
- moveForward should update robot's position correctly.
- moveForward should mark robot as lost if it goes beyond the grid with no scent.
- moveForward should not mark robot as lost if it goes beyond the grid but there is a scent.
- isPositionWithinGrid should return true for positions within the grid.
- isPositionWithinGrid should return false for positions outside the grid.
- isPositionWithinGrid should return false when grid is null.
- parseGridSize should return the correct position for valid input.
- parseGridSize should return null for invalid input.
- parsePosition should return the correct position for valid input.
- parsePosition should return null for invalid input.
- parseOrientation should return the correct orientation for valid input.
- parseOrientation should return null for invalid input.
- processInstructions should update robot's position and orientation correctly when grid is 1, 1, position 0, 0 and orientation N.
- processInstructions should update robot's position and orientation correctly when grid is 1, 1, position 0, 0 and orientation N and moves out of grid.
- getRobotColor should return the correct color based on orientation.

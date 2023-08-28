# Retro Gaming Console -Testing
 Exam project of the course: Testing and Software Verification

### What I have used ( tools, frameworks, ... ):

## Maven
Maven's primary goal is to allow a developer to comprehend the complete state of a development effort in the shortest period of time. In order to attain this goal, Maven deals with several areas of concern:

- Making the build process easy
- Providing a uniform build system
- Providing quality project information
- Encouraging better development practices

thanks to Maven the connection with Travis CI is easier

Maven: https://maven.apache.org/

## Travis CI

Travis CI is a hosted continuous integration service used to build and test software projects hosted on GitHub.

Travis CI is configured by adding a file named .travis.yml, which is a YAML format text file, to the root directory of the repository.
This file specifies the programming language used, the desired building and testing environment 
(including dependencies which must be installed before the software can be built and tested), and various other parameters.

In the case of this application I had to configure the yml file to be able to test the graphical interface using xvfb (X Virtual Framebuffer) to imitate a display.

Travis CI: https://www.travis-ci.com/

## JUNIT
JUnit is a unit testing framework for the Java programming language. 
JUnit has been important in the development of test-driven development, and is one of a family of unit testing frameworks which is collectively known as xUnit that originated with SUnit.
In this project I have used  JUnit 4 version.

JUnit 4: https://junit.org/junit4/

## JML
The Java Modeling Language (JML) is a specification language for Java programs, using Hoare style pre- and post- conditions and invariants, that follows the design by contract paradigm.
Specifications are written as Java annotation comments to the source files, which hence can be compiled with any Java compiler.

JML: https://www.cs.ucf.edu/~leavens/JML/index.shtml

## ASMETA
Asmeta is a framework for the Abstract State Machines (ASMs) formal method. It is composed of different tools for performing different validation and verification activities.

Asmeta: https://asmeta.github.io/index.html

# The application:
### Login Frame
A Frame that allows the user to authenticate in the system via username and password, it is also possible to access as a guest or create a new account (signUp).


![Screenshot 2023-08-25 162533](https://github.com/Isaacmaffo96/gaming_console-Testing/assets/28917454/5cb166c9-0b79-4597-b54b-c28dc98a19c4)

### Signup Frame
A Frame that allows the user to create a new account by providing name, surname, username, date of birth, email and password.


![Screenshot 2023-08-25 162713](https://github.com/Isaacmaffo96/gaming_console-Testing/assets/28917454/c17d171a-b9c7-4fb4-9a70-f2f8f15907ee)

### Game Frame
Once you have logged in or created a new account, the game frame will open, 
this frame allows the user to see his scores and to select the desired game


![Screenshot 2023-08-25 162738](https://github.com/Isaacmaffo96/gaming_console-Testing/assets/28917454/ab0281f3-dd61-4462-8e68-cb0cf2dcf093)

### Snake Game 
The goal of the game is to eat the apples and avoid the walls or the body of the snake.


![Screenshot 2023-08-25 163025](https://github.com/Isaacmaffo96/gaming_console-Testing/assets/28917454/4b4d9a10-74ce-42b9-ae7d-841df890048b)

### Tic Tac Toe Game
Tic-tac-toe (American English) is a game for two players who take turns marking the spaces in a three-by-three grid with X or O. 
The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner.


![Screenshot 2023-08-25 163102](https://github.com/Isaacmaffo96/gaming_console-Testing/assets/28917454/3baed697-6990-4117-b403-df073d60dc51)

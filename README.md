# Retro Gaming Console -Testing
 Exam project of the course: Testing and Software Verification

## Why I used Maven
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

# DD2480-DECIDE

This is a module that is used in a anti-ballistic missile system used to decide whether to launch, or not launch a missile given certain inputs from its intruments.

Inputs are supplied via the Input class's static variables and then the decide method in the Decide class can be run to print a yes/no to the standard output representing launch/no launch.

## Dependencies
* JDK 17
* Apache Maven 3.8.7

## How to use
If you want to integrate package into your missile system you need to download and compile the code yourself. From there you can import the classes into your program and link when building your program. Make sure to set all relevant variables in the Input class before calling the decide method!

## How to run tests
To run all tests, browse to the project folder and run
```mvn test```
in the command line.

## Contributions

##### Arami
- The entirety of the decide class, including the decide function
- LICs 3,8 and 13
- Minimum enclosing radius function
- Connector enum in inputs
- Corresponding tests
- Created issues, reviewed pull requests, etc

#### Oskar
- Contributed in the code by writing the CMV class shell, LIC 2, 7 & 12 and tests for these functions. 
- Wrote much of the documentation/comments for various classes and fields including the input and cmv class. 
- Reviewed and merged pull requests etc.
- Also generally partook in creation of various issues, discussions and division of work.

#### Jakob
- Wrote LIC 0, 6, 10 & 11.
- Wrote tests for the same LICs.
- Issues, code reveiews and merges.
- Wrote much of the Essence documentation.

#### Felix
- Active in discussions about how we would start with the project  
- Set up the project environment (folders/classes/maven)  
- Wrote the base of the Input class  
- Wrote the doubleCompare function and tests  
- Wrote LIC 1 and 5 and tests for those  
- Wrote a number of small issues that came up on the way  
- Reviewed a number of pull requests and merged  

#### Olivia
- Wrote LIC 4, 9 & 14
- Wrote tests and documentation for the same LICs
- Reviewed & merged pull requests

# Essence: Way of Working
We assess that our current state is in the early stages of **in use**. More specifically at the checkpoint “The practices and tools are being used to do real work”. This is because we use the practices and tools, that we agreed upon, to solve the assignment. The previous two states are in regard to establishing principles, tools, and practices. Some of the checkpoints within these states are rather poorly suited for this assignment, for example, those in regard to stakeholders. Aside from that the team committed and agreed to the principles and constraints for the way of working, which we assess fulfilled the first state. For the second state, **Foundation Established**, the practices and tools were also selected and agreed upon (In the form of git, Java, Maven, Junit, discord). One checkpoint within this state that is probably not fulfilled is “All non-negotiable practices and tools have been identified”. This is not a task that was done and you could therefore argue that we didn’t get past this state. We do however feel that this is another checkpoint that is rather poorly suited for this assignment and assess that we reach the third state. The obstacles that are needed in order to reach the next state is to start to inspect and adapt our tools and practices, as this is something that we haven’t done. We would have to discuss and perform an evaluation to find what suits us and our work the best.



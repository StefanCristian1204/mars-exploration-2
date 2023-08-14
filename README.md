# Mars Exploration (Sprint 2)

## Overview
This project aims to simulate the exploration of Mars using a rover. The goal is to determine whether an area on Mars can be inhabited by a future human colony. The rover will scout the map, collect information about the terrain and resources, and log its findings into a file. The project follows the principles of SOLID, YAGNI, and the MVP approach.

## Simulation Context
The simulation keeps track of important information:
- Current step number
- Number of simulation steps required to reach a timeout
- Map of the area
- Location of the spaceship
- Rover information
- Exploration outcome
- Path to the log file

The rover's state includes:
- ID
- Current position
- Sight range
- Current routine
- Coordinate collections for movement and interesting objects

Data classes are created to hold this information.

## Simulation Steps
The rover follows a loop of simulation steps until an outcome is reached. Each step consists of the following phases:
1. Movement: The rover moves according to its state.
2. Scan: The environment is scanned around the rover's new position, and the context is updated.
3. Analysis: The updated context data is analyzed to determine the outcome.
4. Log: The events of this round are appended to the log file.
5. Step increment: The simulation step counter is incremented.

The phases are implemented using the Phase interface, and the ExplorationSimulator class performs these phases for each step. The class is open for extension to accommodate new phase types.

## Rover Movement Routines
The rover follows different movement routines based on its objective. It has at least two routines:
1. Exploring routine: The rover explores the field to gather information.
2. Returning routine: The rover drives back to the spaceship to report findings.

The routines are implemented using the Routine interface. Additional routines can be added as needed.

## Determining the Outcome
During the Analysis phase, analyzers are used to determine if a simulation outcome has been reached. The following analyzers are implemented:
1. Timeout analyzer: Checks if the current step number has reached the timeout.
2. Success analyzer: Checks if the conditions for colonization have been met.
3. Lack of resources analyzer: Checks if there are too few resources in the explored territories.

The analyzers are implemented using the Analyzer interface.

## Log Events
During the Log phase, the simulation state is written to a log file in the following format:

## Adding Aliens
Aliens are introduced into the simulation. The rover is programmed to run back to the spaceship upon spotting an alien. The simulation outcome is set as "NOT_COLONIZABLE_ALIENS."

## Optional Task: Talk to Aliens
A new strategy is implemented to interact with aliens:
1. Spotting an alien switches the rover into a new routine that drives it directly toward the alien.
2. Upon direct contact, communication takes place. The responsible analyzer randomly selects an outcome: "NOT


# Click To Start Simulation
![clickToStartSimualtions](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/77d93281-c548-4ba4-8f10-da291959460c)
# Rover Coordinate Landing Positions
![coordinate_landingPos](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/e257a857-dbc7-457c-950b-6068949b7ab3)
# End Simulation: number of minerals
![endHowManyMinerals](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/bcc48ab4-19d7-43fe-9273-9357d0df7606)
# End Simulation: number of water pockets
![endSimulationsWterPokets](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/3b69f06e-4f2a-4416-881e-1d36af4b588e)
# Initial Map Display
![initialMap](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/76b5f71d-a513-44cc-9ced-067e67e205b0)
# Outcome Rover Simulation TIMEOUT
![outcomeTimeout](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/b64616b1-7859-4cc6-bfba-d2f8dc902f7a)
# Set Rover Sight Range
![roverSightRange](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/ae475259-19dc-4489-9153-eb9bc6e58ab7)
# Configure number of simulation steps until TIMEOUT
![stepsSimulations](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/f1a17fdb-e8b3-4e47-8e76-f74a9e25170e)










  

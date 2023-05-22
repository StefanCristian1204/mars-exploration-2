Mars Exploration (Sprint 2)
Overview
This project aims to simulate the exploration of Mars using a rover. The goal is to determine whether an area on Mars can be inhabited by a future human colony. The rover will scout the map, collect information about the terrain and resources, and log its findings into a file. The project follows the principles of SOLID, YAGNI, and the MVP approach.

Repository
Open Repository
Team
Reviewer: Silviu Martinescu
Team: Red Planet Colonizers
Ratings
Difficulty: 3.9/5
Usefulness: 3.7/5
Fun: 3.4/5
Materials: 2.8/5
Simulation Context
The simulation keeps track of important information:

Current step number
Number of simulation steps required to reach a timeout
Map of the area
Location of the spaceship
Rover information
Exploration outcome
Path to the log file
The rover's state includes:

ID
Current position
Sight range
Current routine
Coordinate collections for movement and interesting objects
Data classes are created to hold this information.

Simulation Steps
The rover follows a loop of simulation steps until an outcome is reached. Each step consists of the following phases:

Movement: The rover moves according to its state.
Scan: The environment is scanned around the rover's new position, and the context is updated.
Analysis: The updated context data is analyzed to determine the outcome.
Log: The events of this round are appended to the log file.
Step increment: The simulation step counter is incremented.
The phases are implemented using the Phase interface, and the ExplorationSimulator class performs these phases for each step. The class is open for extension to accommodate new phase types.

Rover Movement Routines
The rover follows different movement routines based on its objective. It has at least two routines:

Exploring routine: The rover explores the field to gather information.
Returning routine: The rover drives back to the spaceship to report findings.
The routines are implemented using the Routine interface. Additional routines can be added as needed.

Determining the Outcome
During the Analysis phase, analyzers are used to determine if a simulation outcome has been reached. The following analyzers are implemented:

Timeout analyzer: Checks if the current step number has reached the timeout.
Success analyzer: Checks if the conditions for colonization have been met.
Lack of resources analyzer: Checks if there are too few resources in the explored territories.
The analyzers are implemented using the Analyzer interface.

Log Events
During the Log phase, the simulation state is written to a log file in the following format:

php
Copy code
STEP <step_number>; EVENT position; UNIT <rover_id>; POSITION [<x>,<y>]
If the simulation has an outcome, it is written as the last line in the file in the following format:

php
Copy code
STEP <step_number>; EVENT outcome; OUTCOME <outcome_description>
Adding Aliens
Aliens are introduced into the simulation. The rover is programmed to run back to the spaceship upon spotting an alien. The simulation outcome is set as "NOT_COLONIZABLE_ALIENS."

Optional Task: Talk to Aliens
A new strategy is implemented to interact with aliens:

Spotting an alien switches the rover into a new routine that drives it directly toward the alien.
Upon direct contact, communication takes place. The responsible analyzer randomly selects an outcome: "NOT_COLONIZABLE_ALIENS" or "FRIENDLY_ALIENS."
  ![idea64_zYWCWbwn0Y](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/afad6277-ed11-4db8-8821-e028b101a755)
![LogicChart](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/6d2807ab-33e8-4a3a-bb15-791316d03a68)
![idea64_0cA3ox8bKt](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/615433b6-89e5-4246-bf4c-f9ac558dcb36)
![idea64_8TM9CgzdR6](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/a76c4a92-df8f-4754-bfcb-49950a463e19)
![idea64_bUbDnPSn6n](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/15a6464d-9929-4498-a345-b5c55e8a1030)
![idea64_c9nkvJQ6h3](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/40469484-085b-4a8a-91b6-2d5161c188b6)
![idea64_H7S2VWdXoS](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/94e3aba9-5a47-4b97-907b-e166c75b13fc)
![idea64_hwfINfXoai](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/a4d61570-b6fe-4761-bf5f-87e7f2a7454a)
![idea64_iBnhVbJA34](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/40c3bae0-cf84-4708-884c-ecb629601bb6)
![idea64_MFa90Z6m2g](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/c9c84dcd-970e-45b6-bcc4-c4b073ff3465)
![idea64_yXNpVQYMAl](https://github.com/StefanCristian1204/mars-exploration-2/assets/97633357/fe4acb37-71ed-471f-a7a9-3c6eaaa1fef9)

  

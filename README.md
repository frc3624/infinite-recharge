# Infinite Recharge

[![Open in Visual Studio Code](https://open.vscode.dev/badges/open-in-vscode.svg)](https://open.vscode.dev/frc3624/infinite-recharge) [![Website monip.org](https://img.shields.io/website-up-down-green-red/http/monip.org.svg)](http://www.team3624.org/)

## 2021 Revision

This is being written in mid October prior to our in house invitational at High School West. The current plan according to Mr. Wilson is to revise Infinite Recharge so it's at least able to drive and pick up and shoot balls. That's it. Easier said than done due to PID tuning (and this being our first documented shooter). Updates will merge with the master branch once the code is completed.


Note, this means we are DELETING all other prior subsystems/commands. If you would like to see the state of the code prior to these changes refer to [this](https://github.com/frc3624/infinite-recharge/tree/5bcc2d8100bd28aaf7b11671c074b383199bf72c)

## Latest Changes (As of March 2020)

We are cleaning. Our code is as clean as someone who hasn't had a drink in 50 years and is 49 years old. We have standardized our coding style

Here's what he have so far:

- Basic Drive support with master/slave
- Intake works
- Super basic shooter
- Software Speed Shifting with 3 modes (Low, High, and Defense)
- Framework for Climb
- Cooling for Falcons
- Limelight subsystem
- Ball track and intake work, still need to finish up ball track's 5 limit switches :/

What we still need to do (probably longer than this list lol):

- PID for ball shooter
- Autonomous
- Get Limelight and PathViewer to work
- Use 2 controllers and decide on controls
- Make the robot climb

## Controls

### On the first Xbox Controller

- Left Joystick:    Forward + Backwards
- Right Joystick:   Left + Right
- Left Bumper:      Defense Gear
- Right Bumper:     High Gear
- Right Trigger:    Low Gear
- Y Button:         Climb Up
- X Button:         Climb Down

### On the second Xbox Controller

- Right Joystick:   Move Control Panel Left and Right
- DPad Up:          Intake Up
- DPad Down:        Intake Down
- B Button:         Run Intake Belt
- X Button:         Shoot Ball

Cooling Falcons will eventually become an automatic command, so we do not have a button allocated

To be determined...

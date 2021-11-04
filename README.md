# Infinite Recharge

[![Open in Visual Studio Code](https://open.vscode.dev/badges/open-in-vscode.svg)](https://open.vscode.dev/frc3624/infinite-recharge) [![Website monip.org](https://img.shields.io/website-up-down-green-red/http/monip.org.svg)](http://www.team3624.org/)

## 2021 Revision

This code is following the 2021 revision. If you would like to see the code from the 2020 Build Season, refer to [this](https://github.com/frc3624/infinite-recharge/tree/5bcc2d8100bd28aaf7b11671c074b383199bf72c)

## Required Dependencies

This project uses the standard Pheonix Libraries (add the libraries regularly), alongside the Rev Robotics libraries. Adding these libraries is a bit
different than for our projects. Installing these libraries requires the following:

Navigate to this [link](https://docs.revrobotics.com/sparkmax/software-resources/spark-max-api-information#java-api) and make sure to install the
Java API to your computer.

After doing this, copy the link shown for "Online Installations" (should look like <https://www.revrobotics.com/content/sw/max/sdk/REVRobotics.json>) and return to VS Code.

Press Ctrl + Shift + P, and type in "Manage Vendor Libraries". Click on "Install new libraries (online)" and paste the link.

This is required if you plan to deploy or edit code for this robot.

## Controls

### On the Xbox Controller

- Left Joystick:    Forward + Backwards
- Right Joystick:   Left + Right
- Left Bumper:      Defense Gear
- Right Bumper:     High Gear
- Right Trigger:    Low Gear
- B Button:         Toggle Intake System
- X Button:         Toggle Shooting System

- DPAD UP:          Move BallTrack forwards
- DPAD DOWN:        Move BallTrack backwards
- DPAD LEFT:        Move Intake Arm Up
- DPAD RIGHT:       Move Intake Arm Down

## Notes

We have a few bugs with the code, some of it may be related to the hardware components though.

- Can't move the robot if the intake is going
- Finish PID Tuning
- Set Limelight tuning for determining required velocity
- Consolidate Intake Height to one button (it's been really weird locally, we'll see if it gets fixed)
- This might be more build's fault, but there's a minor bug related to ball detection in the balltrack

# Lab 5

## Task

Install ROS on Ubuntu 16.04

> Robot Operating System (ROS) is a collection of software frameworks for robot software development, (see also Robotics middleware) providing operating system-like functionality on a heterogeneous computer cluster. ROS provides standard operating system services such as hardware abstraction, low-level device control, implementation of commonly used functionality, message-passing between processes, and package management. Running sets of ROS-based processes are represented in a graph architecture where processing takes place in nodes that may receive, post and multiplex sensor, control, state, planning, actuator and other messages.

## Install

### Configure Ubuntu repositories

Configure my Ubuntu repositories to allow "restricted," "universe," and "multiverse".

![](https://help.ubuntu.com/community/Repositories/Ubuntu?action=AttachFile&do=get&target=Software+Sources.png)

### Setup sources.list

`sudo sh -c 'echo "deb http://packages.ros.org/ros/ubuntu $(lsb_release -sc) main" > /etc/apt/sources.list.d/ros-latest.list'`

### Set up keys

`sudo apt-key adv --keyserver hkp://ha.pool.sks-keyservers.net:80 --recv-key 0xB01FA116`

### Instal Desktop-Full Install

```bash
sudo apt-get update
sudo apt-get install ros-kinetic-desktop-full
```

![](https://static.32ph.com/upload-pic/g1mtk.jpg)

### Initialize rosdep

```bash
sudo rosdep init
rosdep update
```

### Environment setup

```bash
echo "source /opt/ros/kinetic/setup.bash" >> ~/.bashrc
source ~/.bashrc
```

### Getting rosinstall

> [rosinstall](http://wiki.ros.org/rosinstall) is a frequently used command-line tool in ROS that is distributed separately. It enables us to easily download many source trees for ROS packages with one command.

`sudo apt-get install python-rosinstall`

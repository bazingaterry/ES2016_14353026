# Lab 5 Ex

## Task

Cartographer ROS Integration

> Cartographer is a system that provides real-time simultaneous localization and mapping (SLAM) in 2D and 3D across multiple platforms and sensor configurations. This project provides Cartographer’s ROS integration.

## Building & Installation

### Bypass the GFW

It's a nightmare if you connect to GitHub and Google directly in Mainland China. [Shadowsocks](https://shadowsocks.org/en/index.html) is a elegant socks5 proxy to bypass it.

### Install wstool and rosdep.

```bash
sudo apt-get update
sudo apt-get install -y python-wstool python-rosdep ninja-build
```

### Create a new workspace in 'catkin_ws'.

```bash
mkdir catkin_ws
cd catkin_ws
wstool init src
```

### Merge the cartographer_ros.rosinstall file and fetch code for dependencies.

```bash
wstool merge -t src https://raw.githubusercontent.com/googlecartographer/cartographer_ros/master/cartographer_ros.rosinstall
wstool update -t src
```

### Install deb dependencies.

```bash
rosdep init
rosdep update
rosdep install --from-paths src --ignore-src --rosdistro=${ROS_DISTRO} -y
```

### Build and install.

```bash
catkin_make_isolated --install --use-ninja
source install_isolated/setup.bash
```

## Running the demos

### Download the 2D backpack example bag.
`wget -P ~/Downloads https://storage.googleapis.com/cartographer-public-data/bags/backpack_2d/cartographer_paper_deutsches_museum.bag`

### Launch the 2D backpack demo.
`roslaunch cartographer_ros demo_backpack_2d.launch bag_filename:=${HOME}/Downloads/cartographer_paper_deutsches_museum.bag`

![](https://static.32ph.com/upload-pic/sfgz5.jpg)

### Download the 3D backpack example bag.
`wget -P ~/Downloads https://storage.googleapis.com/cartographer-public-data/bags/backpack_3d/cartographer_3d_deutsches_museum.bag`

### Launch the 3D backpack demo.
`roslaunch cartographer_ros demo_backpack_3d.launch bag_filename:=${HOME}/Downloads/cartographer_3d_deutsches_museum.bag`

![](https://static.32ph.com/upload-pic/l5o8z.jpg)

### Download the Revo LDS example bag.
`wget -P ~/Downloads https://storage.googleapis.com/cartographer-public-data/bags/revo_lds/cartographer_paper_revo_lds.bag`

### Launch the Revo LDS demo.
`roslaunch cartographer_ros demo_revo_lds.launch bag_filename:=${HOME}/Downloads/cartographer_paper_revo_lds.bag`

![](https://static.32ph.com/upload-pic/80qw7.jpg)

### Download the PR2 example bag.
`wget -P ~/Downloads https://storage.googleapis.com/cartographer-public-data/bags/pr2/2011-09-15-08-32-46.bag`

### Launch the PR2 demo.
`roslaunch cartographer_ros demo_pr2.launch bag_filename:=${HOME}/Downloads/2011-09-15-08-32-46.bag`

![](https://static.32ph.com/upload-pic/ykebk.jpg)

## Experimental experience

Cartographer is really awesome!

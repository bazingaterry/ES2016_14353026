# ES2016_14353026

我的嵌入式系统导论实验笔记

## Description

![](https://static.32ph.com/upload-pic/tiq9k.jpg)

The distributed operation layer (DOL) is a framework that enables the (semi-) automatic mapping of applications onto the multiprocessor SHAPES architecture platform. The DOL consists of basically three parts:
- DOL Application Programming Interface: The DOL defines a set of computation and communication routines that enable the programming of distributed, parallel applications for the SHAPES platform. Using these routines, application programmers can write programs without having detailed knowledge about the underlying architecture. In fact, these routines are subject to further refinement in the hardware dependent software (HdS) layer.
- DOL Functional Simulation: To provide programmers a possibility to test their applications, a functional simulation framework has been developed. Besides functional verification of applications, this framework is used to obtain performance parameters at the application level.
- DOL Mapping Optimization: The goal of the DOL mapping optimization is to compute a set of optimal mappings of an application onto the SHAPES architecture platform. In a first step, XML based specification formats have been defined that allow to describe the application and the architecture at an abstract level. Still, all the information necessary to obtain accurate performance estimates is contained.

## How to install

### Environment

- Ubuntu 14.04 x64
- SystemC 2.3.1
- DOL

### Login as root

```shell
su
```

### Install dependence

```shell
apt-get update
apt-get install ant unzip openjdk-7-jdk vim
```

### Install SystemC and DOL

#### Download and unzip

```shell
cd ~
wget http://www.accellera.org/images/downloads/standards/systemc/systemc-2.3.1.tgz
wget http://www.tik.ee.ethz.ch/~shapes/downloads/dol_ethz.zip
mkdir dol
unzip dol_ethz.zip -d dol
tar -zxvf systemc-2.3.1.tgz
```

#### Complie SystemC

```shell
cd systemc-2.3.1
mkdir objdir
cd objdir
../configure CXX=g++ --disable-async-updates
make install
current_dir=$(pwd)
cd ../dol
vim build_zip.xml
```

Edit xml.

```xml
<property name="systemc.inc" value="$current_dir/include"/>
<property name="systemc.lib" value="$current_dir/lib-linux64/libsystemc.a"/>
```

#### Test

```shell
ant -f build_zip.xml all
cd build/bin/main
ant -f runexample.xml -Dnumber=1
```

## Experimental experience

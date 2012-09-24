driver
======
3D driving game in Java mainly for the RasPi.

Under construction
==================
Use of package local.raspberrypi.jackokring.driver is not within the Java spec, but works, and is unique for every username on the http://raspberrypi.org forum. This saves buying a domain. The class model in use is the 12 element system model. This is of my own design, but it is useful as it expands the MVC way of doing things. The class names are shown below. It may seem odd to have MVC as MCD SMD SCE, and maybe I missed a set of three to have a network of machines, but that is not in the scope of this project. I may add other abstractions in time.

The primary instance classes
============================
Mass (primary model)
Car (primary view)
Driver (primary controller)

The secondary arrayed container classes
=======================================
Script (secondary model of gaming process)
Movie (secondary view)
Director (secondary controller making the game)

The tertiary game option classes
================================
Studio
Catalog
Executive

The OS classes which are not present (as they are hidden)
=========================================================
Distribution
Desktop
UserInterface

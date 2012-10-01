package local.raspberrypi.jackokring.driver;

import local.raspberrypi.jackokring.util.*;

public class Model extends Zero {
	
	//The vector basis for calculation
	Trig pointing = new Trig();//direction
	Trig sliding = new Trig();//velocity
	Trig forces = new Trig();//body forces
	Trig location = new Trig();
	
	//the environment settings
	public static Trig wind = new Trig();
	public static Trig calcTemp = new Trig();
	public static float rotary = (float) 1.0;
	float lastRotary = rotary;
	
	//internals and constants
	long updated = System.currentTimeMillis();
	static long timeCache;
	static float time;
	public final static float halfp = (float) (Math.PI / 2);
	float revWheel = 0;//land speedometer would be proportional
	float torq = 0;//wheel torque
	float dir = 0;//internal steer
	float direct = 0;//steer
	
	//car properties
	public float invMass = 1;
	public float friction = 100;
	public float squirrel = 5;
	public float slip = (float) 0.5;
	public float bounce = (float) 0.00001;
	public float drag = (float) 0.1;
	public float invRadWheel = 1;
	
	public float setControl(float torque, float direction) {
		//sets drive torque and direction angle returns wheel revs 
		torq = torque;
		direct = direction;
		return revWheel;
	}
	
	public void update() {
		//frame time
		timeCache = updated;
		updated = System.currentTimeMillis();
		if(updated == timeCache) return;
		timeCache = updated - timeCache;//got milliseconds
		time = (float) (0.001 * timeCache);
		//applying drive
		float drive = time * invMass;
		pointing.setRadius(torq * drive);//wheel drive
		dir = (float) (direct + (Math.random() * 2 - 1) * bounce);//road jiggle
		addImpulses();
		//do mass
		forces.setRadius(forces.radius * drive);
		revWheel = invRadWheel;
		gripSlip();
		//calculation of steer and tilt
		calcTemp.setAngle(pointing.angle);
		calcTemp.setDot(sliding);
		float a, v;
		a = dir * (v = calcTemp.radius);//angular velocity
		revWheel *= v;
		//steer
		pointing.twist(time * a);
		calcTemp.twist(-halfp);
		a *= v;
		tilt(a / invMass);//m v omega and for override
		forces.setFrom(calcTemp);//tilt
		//move forward
		sliding.add(pointing);
		sliding.add(forces);
		//position
		location.add(sliding);
	}
	
	public void tilt(float centra) {
		calcTemp.setRadius(centra);
	}
	
	public void gripSlip() {
		//check wheel spin
		calcTemp.setFrom(forces);
		calcTemp.setRadius(-calcTemp.radius);
		calcTemp.add(pointing);//resultant effect on wheels
		if(Math.abs(calcTemp.radius) * slip > friction) {
			pointing.setRadius(pointing.radius * (1 - slip));//spin
			dir *= squirrel;//squirrel
			forces.setRadius(forces.radius * slip);//grip left
			inSkid();
			revWheel /= slip; 
		} else {
			calcTemp.setAngle(pointing.angle);
			calcTemp.setDot(forces);
			forces.setFrom(calcTemp);//no skid wheels
		}
	}
	
	void addCoriolis() {
		//calc angular vel into tan
		calcTemp.setFrom(location);
		calcTemp.twist(halfp);
		calcTemp.setDot(sliding);
		float tan = (calcTemp.radius / location.radius) + rotary;
		//calc radial centrafugal
		calcTemp.setFrom(location);
		calcTemp.setRadius(calcTemp.radius * tan * tan);
		forces.add(calcTemp);
		//calc angular acceleration
		float alpha = (rotary - lastRotary) / time;//angular acc
		calcTemp.setFrom(location);
		calcTemp.setRadius(calcTemp.radius * alpha);
		calcTemp.twist(halfp);
		forces.add(calcTemp);
		//calc tangential coriolis
		calcTemp.setFrom(location);
		calcTemp.setDot(sliding);
		calcTemp.twist(halfp);
		calcTemp.setRadius(calcTemp.radius * 2 * tan);
		forces.add(calcTemp);
		lastRotary = rotary;
	}
		
	void addWind() {	
		calcTemp.setFrom(wind);
		calcTemp.add(sliding);
		calcTemp.setRadius(-calcTemp.radius * calcTemp.radius * drag);
		forces.add(calcTemp);
	}
	
	public void addImpulses() {
		addWind();
		addCoriolis();
	}
	
	public void inSkid() {
		
	}
}
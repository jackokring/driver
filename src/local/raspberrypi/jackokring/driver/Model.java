package local.raspberrypi.jackokring.driver;

import local.raspberrypi.jackokring.util.*;

public class Model extends Zero {
	
	public float invMass = 1;
	
	Trig pointing = new Trig();//direction
	Trig sliding = new Trig();//velocity
	Trig forces = new Trig();//body forces
	Trig sheer = new Trig();//perp
	Trig along = new Trig();//para
	Trig location = new Trig();
	
	public static Trig wind = new Trig();
	public static Trig calcTemp = new Trig();
	public static float rotary = (float) 1.0; 
	
	long updated = System.currentTimeMillis();
	public static long timeCache;
	public final static float halfp = (float) (Math.PI / 2);
	
	public float friction = 100;
	public float squirrel = 5;
	public float slip = (float) 0.5;
	public static float bounce = (float) 0.00001;
	
	public float drag = (float) 0.1;
	public float torque = 0;//wheel torque
	public float dir = 0;//steer
	
	public float revWheel = 0;//land speedometer would be proportional
	public float invRadWheel = 1;
	
	public final float gear[] = { (float) 0.5, (float) 1 };
	
	public void update() {
		timeCache = updated;
		updated = System.currentTimeMillis();
		if(updated == timeCache) return;
		timeCache = updated - timeCache;//got milliseconds
		pointing.setRadius(torque * timeCache * invMass);//wheel drive
		dir += (Math.random() * 2 - 1) * bounce;//road jiggle
		along.setAngle(pointing.angle);
		sheer.setAngle((float) (pointing.angle + halfp));
		addImpulses();
		//do mass
		forces.setRadius(forces.radius * invMass);
		//sheer
		sheer.setDot(forces);
		//acceleration
		along.setDot(forces);
		//limiting effect of rubber
		//check wheel spin
		calcTemp.setFrom(along);
		calcTemp.setRadius(-calcTemp.radius);
		calcTemp.add(pointing);
		revWheel = invRadWheel;
		if(Math.abs(calcTemp.radius) > friction) {
			pointing.setRadius(pointing.radius * slip);
			inSkid();
			revWheel /= slip; 
		}
		if(Math.abs(sheer.radius) > friction) {
			dir *= squirrel;
			sheer.setRadius(sheer.radius * (1 - slip));
			inSkid();
		} else {
			sheer.setRadius(0);//no skid wheels
		}
		//calculation of steer and tilt
		calcTemp.setAngle(pointing.angle);
		calcTemp.setDot(sliding);
		float r, v;
		r = dir * (v = calcTemp.radius);//angular velocity
		revWheel *= v;
		calcTemp.twist(-halfp);
		//steer
		pointing.twist(timeCache * r);
		r *= v;
		calcTemp.setRadius(r);
		forces.setFrom(calcTemp);//tilt
		//move forward
		sliding.add(pointing);
		sliding.add(along);
		sliding.add(sheer);
		//position
		location.add(sliding);
	}
	
	void addCoriolis() {
		calcTemp.setFrom(location);
		calcTemp.setRadius(calcTemp.radius * rotary * rotary);
		forces.add(calcTemp);
		calcTemp.setFrom(location);
		calcTemp.setDot(sliding);
		calcTemp.twist(halfp);
		calcTemp.setRadius(calcTemp.radius * 2 * rotary);
		forces.add(calcTemp);
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
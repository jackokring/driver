package local.raspberrypi.jackokring.driver;

import local.raspberrypi.jackokring.util.*;

public class Model extends Zero {
	
	float invMass = 1;
	float x = 0;
	float y = 0;
	
	Trig pointing = new Trig();//direction and wheel force
	Trig sliding = new Trig();//velocity
	Trig forces = new Trig();//body forces
	Trig sheer = new Trig();//perp
	Trig along = new Trig();//para
	
	static Trig wind = new Trig();
	static Trig calcTemp = new Trig();
	
	long updated = System.currentTimeMillis();
	static long timeCache;
	static float angleCache;
	final static float halfp = (float) (Math.PI / 2);
	
	float friction = 100;
	float squirrel = 5;
	float slip = (float) 0.5;
	static float bounce = (float) 0.00001;
	
	float drag = (float) 0.1;
	
	public void update(float acc, float dir) {
		timeCache = updated;
		updated = System.currentTimeMillis();
		if(updated == timeCache) return;
		timeCache = updated - timeCache;//got millis
		pointing.setRadius(acc * timeCache * invMass);//wheel drive
		dir += (Math.random() * 2 - 1) * bounce;//road jiggle
		along.setAngle(pointing.angle);
		sheer.setAngle((float) (pointing.angle + halfp));
		addImpulses();
		//do mass
		forces.setRadius(forces.radius * invMass);
		if(Math.abs(pointing.radius) > friction) {
			pointing.setRadius(pointing.radius * slip);
			inSkid();
		}
		forces.add(pointing);//wheel to body
		//sheer
		sheer.setDot(forces);
		//acceleration
		along.setDot(forces);
		//steer
		calcTemp.setAngle(pointing.angle);
		calcTemp.setDot(sliding);
		if(Math.abs(sheer.radius) > friction) {
			dir *= squirrel;
			sheer.setRadius(sheer.radius * slip);
			sliding.add(sheer);
			inSkid();
		} else {
			sliding.setFrom(calcTemp);//no skid wheels
		}
		calcTemp.twist(-halfp);
		float r, v;
		r = dir * (v = calcTemp.radius);//angular velocity
		pointing.twist(timeCache * r);
		r *= v;
		calcTemp.setRadius(r);
		forces.setFrom(calcTemp);//tilt
		//move forward
		sliding.add(along);
		//position
		x += sliding.x;
		y += sliding.y;
	}
	
	void addCoriolis() {
		
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
package local.raspberrypi.jackokring.util;

public class Trig {
	
	public float angle = 0;
	public float radius = 1;
	public float x = 0;
	public float y = 1;
	
	public void setAngle(float d) {
		angle = d;
		x = (float)(radius * Math.sin(d));
		y = (float)(radius * Math.cos(d));
	}
	
	public void setRadius(float r) {
		if(radius == 0) {
			radius = r;
			setAngle(angle);
			return;
		}
		float mul = r / radius;
		x *= mul;
		y *= mul;
		radius = r;
	}

	public void twist(float a) {
		setAngle(angle + a);
	}
	
	public void add(Trig t) {
		x += t.x;
		y += t.y;
		angle = (float) Math.atan2(y, x);
		radius = (float) Math.sqrt(x * x + y * y);
	}
	
	public void setDot(Trig t) {
		setRadius((float) (t.radius * Math.cos(angle-t.angle)));
	}
	
	public void setFrom(Trig t) {
		angle = t.angle;
		radius = t.radius;
		x = t.x;
		y = t.y;
	}
}
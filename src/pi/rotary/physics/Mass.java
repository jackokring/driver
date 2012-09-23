package pi.rotary.physics;

public class Mass {
	
	float radius;
	float time;
	float frequency; //angular velocity
	long updated; //last updated
	float angle;
	float mass;
	float slide; //radial acceleration
	float pitch, roll; //for effect not accurate inertia
	float pitchLim, rollLim; //limits before onset of slip
	float slip = (float) 1.0; //traction
	float squirrel; //side slip or squirrel
	float baring; //set to PI for non radials (direction)
	float forcetx, forcerx; //for rolling wheels
	
	void updatet(float torque) { //calculate torque update
		float inertia = mass * radius * radius;
		float theta_acc = torque / inertia;
		updated = System.currentTimeMillis() - updated;
		time = (float)(updated / 1000.0);
		frequency += theta_acc * time;
		angle += frequency * time;
		angle = (float)Math.IEEEremainder(angle, 2 * Math.PI);
		slide = frequency * frequency * radius;
	}
	
	void updatep(float forcet, float forcer) { //apply force update
		//tangent and radial
		roll = forcet + forcetx;
		float s = (float)Math.sin(baring);
		float c = (float)Math.cos(baring);
		updatet(roll * c * radius);
		float rad = (forcer + forcerx + slide) / mass;
		float r1 = radius;
		float f1 = frequency * r1;
		radius += rad * c * time * time;
		//cori
		r1 /= radius;
		frequency *= r1 * r1;
		f1 = (frequency * radius - f1) / (mass * time);
		//body tilts
		roll = -(roll * c - rad * s);
		pitch = -(rad * c - roll * s);
		//wheel rolling effect of non lateral
		forcetx = rad * s * c + f1;
		forcerx = roll * s * c;
	}
	
	void updatea(float forcens, float forceew) {
		//apply absolute force directions
		float s = (float)Math.sin(angle);
		float c = (float)Math.cos(angle);
		updatep(-forceew * c - forcens * s, forcens * c - forceew * s);
	}
	
	public float posns() {
		return (float)(radius * Math.cos(angle));
	}
	
	public float posew() {
		return (float)(radius * Math.sin(angle));
	}
	
	public float absYaw() {
		return angle + baring;
	}
	
	public void update(float force, float turn) {
		//update using drive force
		float bearing = angle + baring;
		if(Math.abs(pitch) > pitchLim) {
			force *= slip / pitch;//wheel spin and lock
		}
		float s = (float)Math.sin(bearing);
		float c = (float)Math.cos(bearing);
		updatea(force * c, -force * s);
		baring += turn * time;
		//skids...
		if(Math.abs(roll) > rollLim) {
			baring += roll * squirrel * turn * time;//squirrel 
		}
	}
	
	public void setPos(float ns, float ew, float absYaw) {
		radius = (float)Math.sqrt(ns * ns + ew * ew);
		angle = (float)Math.atan2(ns, ew);
		baring = absYaw - angle;
	}
}
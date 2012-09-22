package pi.rotary.physics;

public class Mass {
	
	float radius;
	float time;
	float frequency; //angular velocity
	long updated; //last updated
	float angle;
	float mass;
	float slide; //radial acceleration
	float tilt; //for effect
	float baring; //set to PI for non radials
	float forcetx; //for rolling
	
	void updatet(float torque) {
		float inertia = mass * radius * radius;
		float theta_acc = torque / inertia;
		updated = System.currentTimeMillis() - updated;
		time = (float)(updated / 1000.0);
		frequency += theta_acc * time;
		angle += frequency * time;
		angle = (float)Math.IEEEremainder(angle, 2 * Math.PI);
		slide = frequency * frequency * radius;
	}
	
	void updatep(float forcet, float forcer) {
		updatet((forcet + forcetx) * radius);
		float s = (float)Math.sin(baring);
		float c = (float)Math.cos(baring);
		float rad = forcer / mass;
		rad += slide;
		tilt = rad * s;
		forcetx = tilt * c;
		rad *= c;
		radius += rad * time;
	}
	
	void updatea(float forcens, float forceew) {
		float s = (float)Math.sin(angle);
		float c = (float)Math.cos(angle);
		updatep(-forceew * c - forcens * s, forcens * c - forceew * s);
	}
	
	float posns() {
		return (float)(radius * Math.cos(angle));
	}
	
	float posew() {
		return (float)(radius * Math.sin(angle));
	}
	
	void update(float force) {
		float bearing = angle + baring;
		float s = (float)Math.sin(bearing);
		float c = (float)Math.cos(bearing);
		updatea(force * c - force * s, -force * s - force * c);
	}
}

package local.raspberrypi.jackokring.driver;

public class Executive extends Director {
	
	static Executive self;
	IOMux io;
	
	Executive(IOMux inputOutput) {
		io = inputOutput;
		view = new Catalog(new Studio());
	}
	
	public static void main(String[] args) {
		self = new Executive(new IOMux());
	}

}

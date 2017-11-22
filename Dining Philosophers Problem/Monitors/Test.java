//Refer OS by Galvin
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Philospher {
	String state;
	boolean self;
	public Philospher () {
		state = "THINKING";
	    self = false;
	}
}

public class Test {
	static Philospher[] p = new Philospher[5];
	static int max = 5;
	static void pickup(int i) {
		if(p[i].self == true){
			System.out.println("p["+i+"] Already in queue !");
			return;
		}
		p[i].state = "HUNGRY";
		test(i);
	}
	static void putsdown(int i) {
		p[i].state = "THINKING";
		p[i].self = false;
		System.out.println("p["+i+"] has put down forks");
		if(p[(i+4)% 5].state == "HUNGRY") test((i+4)% 5);
		if(p[(i+1)% 5].state == "HUNGRY") test((i+1)% 5);
	}
	static void test(int i) {
		if(p[(i+4)%5].state != "EATING" && p[i].state == "HUNGRY" && p[(i+4)%5].state != "EATING") {
			p[i].state = "EATING";
			p[i].self = true;
			System.out.println("p["+i+"] is eating");
		} else System.out.println("p["+i+"] can't eat at the moment");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++) p[i] = new Philospher();
		String command;
	    String[] temp = new String[2];
	    int pid;
	    while(true) {
	    	temp = br.readLine().trim().split(" ");
	    	command = temp[0];
	    	pid = Integer.parseInt(temp[1]);
	    	if(pid < max){
	    		if(command.equals("eat")) pickup(pid);
	    		else if(command.equals("end")) putsdown(pid);
	    	} else System.out.println("Philospher not present");
	    }
	}
}

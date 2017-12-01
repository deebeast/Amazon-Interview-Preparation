package test;

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

class Test {
	static Philospher[] p = new Philospher[5];
	static int max = 5;
	static void pickup(int i) {
		if (p[i].self == true){
			System.out.println("p["+i+"] Already in queue !");
			return;
		}
		p[i].state = "HUNGRY";
		test(i);
	}
	static void putsdown(int i) {
                if (!"EATING".equals(p[i].state)) {
                        System.out.println("p["+i+"] is not Eating.");
                        System.out.println("p["+i+"] is in "+ p[i].state +" state");
                        return;
                }
		p[i].state = "THINKING";
		p[i].self = false;
		System.out.println("p["+i+"] has put down forks");
		if("HUNGRY".equals(p[(i+4)% 5].state)) test((i+4)% 5);
		if("HUNGRY".equals(p[(i+1)% 5].state)) test((i+1)% 5);
	}
	static void test(int i) {
		if(!"EATING".equals(p[(i+4)%5].state) && "HUNGRY".equals(p[i].state) && !"EATING".equals(p[(i+1)%5].state)) {
			p[i].state = "EATING";
			p[i].self = true;
			System.out.println("p["+i+"] is eating");
		} else System.out.println("p["+i+"] can't eat at the moment");
	}

	public static void main(String[] args) throws IOException {
		System.out.println("-------------------------");
		System.out.println("The program has started..");
		System.out.println("-------------------------");
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

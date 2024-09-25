import java.util.Scanner;
public class matrix {
    private static final Scanner sc = new Scanner(System.in);
    private static final String default_pw = "688206";
    private static String alphabet = "";
    private long session_seed;
    private int len;
    private int timeout;
    private int lag; //otherwise known as speed
    static {
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet += c;
        }
        alphabet += alphabet.toUpperCase();
        for (int i = 0; i <= 9; i++) {
            alphabet += i;
        }
        //session_seed = System.currentTimeMillis();
    }
    public matrix(int len, int timeout, int lag) {
        session_seed = System.currentTimeMillis();
        this.len = len;
        this.timeout = timeout;
        this.lag = lag;
    }
    public matrix() {
        session_seed = System.currentTimeMillis();
        System.out.println("Enter the width of the matrix. 160 is close to fullscreen. ");
        len = sc.nextInt();
        System.out.println("Enter the timeout coefficient of the matrix. ");
        timeout = sc.nextInt();
        System.out.println("Enter lag of the timer in terms of miliseconds. ");
        lag = sc.nextInt();
        sc.nextLine(); //flush input buffer;
    }
    private long get_seed() {
        return session_seed;
    }
    public void verify() {
        System.out.println("Enter user verification password. ");
        String input = sc.nextLine();
        if (input.equals(default_pw)) {
            System.out.println("Seed is: " + get_seed());
        } else {
            throw new IllegalArgumentException("Incorrect password. Can't reach data. "); //system.exit(-1);
        }
    }
    private char rand() {
        int x = (int) (Math.random() * alphabet.length());
        return alphabet.charAt(x);
    }
    public void start() { //timer value
        if (timeout == 0 || len == 0) {
            throw new IllegalArgumentException("Timer or length is 0. Cannot start method. ");
        }
        /*try {
            if (timeout == -1) {
                while (true) { 
                    
                }
            } else {
                for (int i = 0; i < timeout; i++) {
                    Thread
                }
            }
        } catch (InterruptedException e) {
            System.err.println("System chrono interrupted, please restart again. ");
        } */
        if (timeout == -1) {
            while (true) { 
                for (int i = 0; i < len; i++) {
                    try {
                        Thread.sleep(lag);
                        System.out.print(rand());
                    } catch (InterruptedException e) {
                        System.err.println("Chrono interrupted. ");
                        return;
                    }
                }                
                System.out.println();
            }
        } else {
            /*for (int i = 0; i < timeout; i++) {
                for (int x = 0; x < len; x++) {
                    System.out.print(rand());
                }
                System.out.println();
            }*/
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= timeout * 1000) { 
                for (int i = 0; i < len; i++) {
                    try {
                        Thread.sleep(lag);
                        System.out.print(rand());
                    } catch (InterruptedException e) {
                        System.err.println("Chrono interrupted. ");
                        return;
                    }
                }
                System.out.println();
            }
            
        }
        System.out.println("Process finished. Exit code 0. ");
    }
    /*public static void main(String[] args) {
        matrix m1 = new matrix();
        m1.start();
        m1.verify();        
    }*/
}

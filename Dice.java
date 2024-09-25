public class Dice {
    private int side;
    public Dice() {
        side = 6;
    }
    public Dice(int side) {
        this.side = side;
    }
    public int roll() {
        return (int) (Math.random() * side + 1);
    }
    public boolean rollAll() {
        int d = side;
        while (d > 0) { 
            int m = roll();
            if (m == d) {
                d--;
                System.out.println("Rolled number is: " + m);
            }
        }
        return true;
    }
}
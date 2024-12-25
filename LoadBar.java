public abstract class LoadBar {
    private int len; 
    protected char cursor;
    protected char background;
    protected char[] bar;
    public LoadBar(int len, char cursor, char background) {
        this.len = len;
        this.cursor = cursor;
        this.background = background;
        bar = new char[len];
        for (int i = 0; i < bar.length; i++) {
            bar[i] = background;
        }
    }
    //protected abstract void printBar(int n); //last position of char
    protected void setDefault() {
        for (int i = 0; i < bar.length; i++) {
            bar[i] = background;
        }
    }   
    public abstract void startDisplay(int... args);
    protected void printBarContent() {
        System.out.println();
        System.out.print("[");
        for (char c : bar) {
            System.out.print(c + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}

class MountainLoader extends LoadBar {
    public MountainLoader(int len, char cursor, char background) {
        super(len, cursor, background);
    }
    protected void printBar(int n) { //0 indexed, where character is at!
        setDefault();
        bar[n] = cursor;
        printBarContent();
    }
    public void startDisplay(int... args) { //timer and delay
        if (args.length < 2) {
            throw new IllegalArgumentException("You must enter 2 parameters. ");   
        }
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            setDefault();
            printBarContent();
            boolean forward = true;
            while ((System.currentTimeMillis() - start) / 1000 < args[0]) { //unter timer limit is hit
                if (i == bar.length - 1) {
                    forward = false;
                }
                if (forward) {
                    i++;
                } else {
                    i--;
                }
                printBar(i);
                if (i == 0) {
                    forward = true;
                }
                Thread.sleep(args[1]);    
            }
        } catch (InterruptedException e) {
            System.err.println("Loading interrupted: " + e.getMessage());
        }
        System.out.println("Finished loading. ");
    }
}

class ProgressLoader extends LoadBar {
    public ProgressLoader(int len, char cursor, char background) {
        super(len, cursor, background);
    }
    public void startDisplay(int... args) { //delay
        if (args.length != 1) {
            throw new IllegalArgumentException("Enter only 1 parameter. ");
        }
        try {
            setDefault();
            printBarContent();
            for (int i = 0; i < bar.length; i++) {
                //System.out.println();
                bar[i] = cursor;
                printBarContent();
                //System.out.println();
                Thread.sleep(args[0]);
            }
        } catch (InterruptedException e) {
            System.err.println("Loading interrupted: " + e.getMessage());
        }
        System.out.println("Finished loading. ");
    }
}
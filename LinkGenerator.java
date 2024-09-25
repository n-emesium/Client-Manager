public class LinkGenerator {
    private static String alphdown;
    private static String alphup;
    private static String numbers;
    private static final String[] domains = {".com",".gov",".org"};
    static {
        alphdown = "";
        for (char c = 'a'; c <= 'z'; c++) {
            alphdown += c;
        }
        alphup = alphdown.toUpperCase();
        for (int i = 0; i <= 9; i++) {
            numbers += i;
        }
    }
    public static String generate(int length) {
        String randomized = "";
        for (int i = 0; i < length; i++) {
            int x = (int) (Math.random() * 3);
            int y;
            switch (x) {
                case 0: //alphabet lower characters
                    y = (int) (Math.random() * alphdown.length());
                    randomized += alphdown.charAt(y);
                    break;
                case 1: //alphabet upper characters
                    y = (int) (Math.random() * alphup.length());
                    randomized += alphup.charAt(y);
                    break;
                case 2: //number characters
                    y = (int) (Math.random() * numbers.length());
                    randomized += numbers.charAt(y);
                    break;
            }
        }
        return "https://" + randomized + domains[(int) (Math.random() * domains.length)];
    }
    /*public static void main(String[] args) {
        
        LinkGenerator lg = new LinkGenerator();
        for (int i = 0; i < 10; i++) {
            int len = (int) (Math.random() * 51 + 50);
            System.out.println("Sample web link: ");
            System.out.println(lg.generate(len));
        }
    }*/
}
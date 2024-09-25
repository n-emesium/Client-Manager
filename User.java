//name of matrix generating java file: matrix.java
//Link generator added
//File manager logic used
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class User {
    private static final Scanner sc = new Scanner(System.in);
    private String name;
    private String birthday;
    private boolean gender; //0 --> female, 1 --> male | false = female; true = male;
    private int age;
    private String country;
    private int zip;
    private String email;
    private String number = ""; //XXX XXX XX XX example
    private String addr;
    private String pw;
    private String createdAt;
    private String lastLogin;
    private String pfpUrl;
    private String status = "active";
    public User(String name, String birthday, boolean gender, int age, String email, String number, String addr, String pw, String country, int zip) {
        this.name = name;
        this.country = country;
        this.birthday = birthday;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.number = number;
        this.addr = addr;
        this.pw = pw;
        this.zip = zip;
        LocalDateTime ld = LocalDateTime.now();
        createdAt = lastLogin = ld.toString();
        //50-75 characters
        int len = (int) (Math.random() * 26 + 50);
        pfpUrl = LinkGenerator.generate(len);
    }
    public User(String name, String country, String addr) {
        this.name = name;
        this.country = country;
        this.addr = addr;
        Dice day = new Dice(31);
        Dice month = new Dice(12);
        Dice year = new Dice(2024);
        int y1 = year.roll();
        int m1 = month.roll();
        birthday = day.roll() + " / " + m1 + " / " + y1;
        gender = m1 <= 6;
        this.age = LocalDateTime.now().getYear() - y1;
        //gmail logic: 
        //use StringUtil split function
        ArrayList<String> nameList = StringUtil.split(name);
        for (int i = 0; i < nameList.size(); i++) {
            nameList.set(i, nameList.get(i).toLowerCase()); //makes sure that all of the name is lowercased
        }
        if (nameList.size() == 0) {
            email = "n/a";
        } else if (nameList.size() == 1) {
            email = nameList.get(0) + year.roll() + "@gmail.com";
        } else {
            email = nameList.get(0) + nameList.get(1) + year.roll() + "@gmail.com";
        }
        //for the number logic: //first of the leading digit cannot be 0
        Dice numbers = new Dice(10); //new dice roll [1,10]
        for (int i = 0; i < 10; i++) {
            int g = numbers.roll();
            if (g != 1) {
                g--;
            }
            number += g;
        }
        //seperate it like 3-3-2-2, asssume the length is 10
        number = number.substring(0,3) + " " + number.substring(3,6) + " " + number.substring(6,8) + " " + number.substring(8);
        Dice zp = new Dice(99999);
        zip = zp.roll();
        pw = StringUtil.genRand(10); //this is the default password length, can be changed
        LocalDateTime ld = LocalDateTime.now();
        createdAt = lastLogin = ld.toString();
        int ulen = (int) (Math.random() * 26 + 50);
        pfpUrl = LinkGenerator.generate(ulen);
    }
    /**Getters: */
    public String getName() {
        return name;
    }
    public String getBirth() {
        return birthday;
    }
    public String getGender() {
        if (gender == false) {
            return "Female";
        } else {
            return "Male";
        }
    }
    public int getAge() {
        return age;
    }
    public String getCountry() {
        return country;
    }
    public int getZip() {
        return zip;
    }
    public String getEmail() {
        return email;
    }
    public String getNum() {
        return number;
    }
    public String getAddress() {
        return addr;
    }
    public String getPw() {
        return pw;
    }
    public String createdWhen() {
        return createdAt;
    }
    public String lastOnline() {
        return lastLogin;
    }
    public String getUrl() {
        return pfpUrl;
    }
    public String getStatus() {
        return status;
    }
    /**End */

    //---------------------

    /**Setters:  */
    public void changeName(String newname) {
        name = newname;
    }
    public void changeCountry(String newcountry) {
        country = newcountry;
    }
    public void changeZip(int newzip) {
        zip = newzip;
    }
    public void changeMail(String newemail) {
        email = newemail;
    }
    public void changeNum(int num) {
        String hold = num + "";
        number = hold.substring(0,3) + " " + hold.substring(3,6) + " " + hold.substring(6,8) + " " + hold.substring(8);
    }
    public void changeAddr(String newaddr) {
        addr = newaddr;
    }
    public void changePw(String str) {
        //Check if user has the authorization first:
        if (uauth()) {
            pw = str;
        }
    }
    private boolean uauth() {
        System.out.println("Enter password. ");
        String uin = sc.nextLine();
        return pw.equals(uin);
    }
    public void changeUrl(String newUrl) {
        pfpUrl = newUrl;
    }
    public void changeUrl() {
        pfpUrl = LinkGenerator.generate((int) (Math.random() * 26 + 50));
    }
    public void changeStatus(String newstatus) {
        status = newstatus;
    }
    /*All instance variables are listed here:
            private String name;
            private String birthday;
            private boolean gender;
            private int age;
            private String country;
            private int zip;
            private String email;
            private String number; 
            private String addr;
            private String pw;
            private String createdAt;
            private String lastLogin;
            private String pfpUrl;
            private String status = "active";
         */

    /**End */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return fieldCheck((User) obj);
    }
    private boolean fieldCheck(User cl) {
         return Objects.equals(cl.name, name) &&
           Objects.equals(cl.birthday, birthday) &&
           cl.gender == gender &&
           cl.age == age &&
           Objects.equals(cl.country, country) &&
           cl.zip == zip &&
           Objects.equals(cl.email, email) &&
           Objects.equals(cl.number, number) &&
           Objects.equals(cl.addr, addr) &&
           Objects.equals(cl.pw, pw) &&
           Objects.equals(cl.createdAt, createdAt) &&
           Objects.equals(cl.lastLogin, lastLogin) &&
           Objects.equals(cl.pfpUrl, pfpUrl);
    }
    public String toString() {
        /*All instance variables are listed here:
            private String name;
            private String birthday;
            private boolean gender;
            private int age;
            private String country;
            private int zip;
            private String email;
            private String number; 
            private String addr;
            private String pw;
            private String createdAt;
            private String lastLogin;
            private String pfpUrl;
            private String status = "active";
         */
        String str = "";
        str += "User name is: " + name + "\n";
        str += "User birthday is: " + birthday + "\n";
        if (gender == false) {
            str += "User gender is: Female \n";
        } else {
            str = "User gender is: Male \n";
        }
        str += "User age is: " + age + "\n";
        str += "User country is: " + country + "\n";
        str += "User zipcode is: " + zip + "\n";
        str += "User email is: " + email + "\n";
        str += "User number is: " + number + "\n";
        str += "User address is: " + addr + "\n";
        str += "User password is: " + pw + "\n";
        str += "User account was created at: " + createdAt + "\n";
        str += "User last login was: " + lastLogin + "\n";
        str += "User profile picture url is: " + pfpUrl + "\n";
        str += "User status is: " + status + "\n";
        return str;
    }
}

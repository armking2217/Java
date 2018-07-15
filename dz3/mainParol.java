package dz3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainParol {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        String task= enter.nextLine();
        Pattern p1=Pattern.compile(".*[A-Z].*"),
                p2=Pattern.compile(".*[a-z].*"),
                p3=Pattern.compile(".*[0-9].*"),
                p4=Pattern.compile(".{8,}?"),
                p5=Pattern.compile("[^\\s]*");
        boolean a1=p1.matcher(task).matches(),
                a2=p2.matcher(task).matches(),
                a3=p3.matcher(task).matches(),
                a4=p4.matcher(task).matches(),
                a5=p5.matcher(task).matches();
        System.out.println(a1 && a2 && a3 && a4 && a5);
    }
}

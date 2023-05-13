package test;

import java.util.Objects;
import java.util.Scanner;

/**
 * @Author: Jaa
 * @Date: 2023/4/7 15:43
 * @Description:
 */
public class DateUtils {

    public static String formatDate(String date) {
        String result = "";
        if (date.contains("-") && date.charAt(2) != '-') {
            result = date.replace("-", "");
        }
        if (date.contains("/") && date.charAt(2) != '/') {
            result = date.replace("/", "");
        }
        if (date.contains("-") && date.charAt(2) == '-') {
            date = date.replace("-", "");
            result = date.substring(4, date.length()) + date.substring(0, 4);
        }
        if (date.contains("/") && date.charAt(2) == '/') {
            date = date.replace("/", "");
            result = date.substring(4, date.length()) + date.substring(0, 4);
        }
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        if (Character.isLetter(date.charAt(2))) {
            if (Objects.equals("Jan", date.substring(2, 5))) {
                result = date.substring(5, date.length()) + "01" + date.substring(0, 2);
            }
            if (Objects.equals("Feb", date.substring(2, 5))) {
                result = date.substring(5, date.length()) + "01" + date.substring(0, 2);
            }
            // todo Mar - Dec
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Scanner sc = new Scanner(System.in);
            String date = sc.next();
            System.out.println(formatDate(date));
        }
    }

}

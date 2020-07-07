package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int oldBase;
        try {
            oldBase = Integer.parseInt(scanner.nextLine());
            if (oldBase < 1 || oldBase > 36) {
                System.out.println("error");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("error");
            return;
        }
        int intPart;
        int floatPart = 0;
        String strNumber = "";
        if (oldBase == 1) {
            int temp = 0;
            String num = scanner.nextLine();
            for (char c : num.toCharArray()) {
                if (c != '1') {
                    System.out.println("error");
                    return;
                }
            }
            for (int i = 0; i < num.length(); i++) {
                temp++;
            }
            intPart = temp;
        } else {
            strNumber = scanner.nextLine();
            try {
                intPart = Integer.parseInt(strNumber.split("[.]")[0], oldBase);
            } catch (NumberFormatException e) {
                System.out.println("error");
                return;
            }
            if (strNumber.contains(".")){
                try {
                    strNumber = "." + strNumber.split("[.]")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("error");
                    return;
                }
            }
        }
        int newBase;
        try {
            newBase = Integer.parseInt(scanner.nextLine());
            if (newBase < 1 || newBase > 36) {
                System.out.println("error");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("error");
            return;
         }
        if (newBase == 1) {
            for (int i = 0; i < intPart; i++) {
                System.out.print("1");
            }
        } else {
            System.out.print(Integer.toString(intPart, newBase));
            double result = 0;
            if (strNumber.contains(".")) {
                for (int i = 1; i < strNumber.length(); i++) {
                    int digit;
                    if (strNumber.charAt(i) >= 'a') {
                        digit = Character.getNumericValue(strNumber.charAt(i));
                    } else {
                        digit = Character.getNumericValue(strNumber.charAt(i));
                    }
                    result +=  digit / Math.pow(oldBase, i);
                }
                System.out.print(".");
                for (int i = 0; i < String.valueOf(result).length() && i < 5; i++) {
                    result *= newBase;
                    int temp = (int) result;
                    System.out.print(Character.forDigit(temp, newBase));
                    result -= temp;
                }
            }
        }
    }
}

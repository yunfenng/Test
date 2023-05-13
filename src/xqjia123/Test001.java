package xqjia123;

public class Test001 {

    public static void main(String[] args) {
        try {
            // do something
            System.exit(1);
        } finally { // not be executed
            System.out.println("Print from finally");
        }
    }

}

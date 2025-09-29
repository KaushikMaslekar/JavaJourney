
public class right_triangle {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) { //this is the outer loop for rows
            for (int j = 1; j <= i; j++) { //this is the inner loop for columns
                System.out.print("* ");
            }
            System.err.println(""); //This is used to print in new line
        }
    }
}

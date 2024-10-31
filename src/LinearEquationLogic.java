import java.util.Scanner;
public class LinearEquationLogic {
    private String point1 = "";
    private String point2 = "";
    private String temp = "";
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean stop = true;
    private String answer = "";
    private double newX;

    Scanner scan = new Scanner(System.in);

    public LinearEquationLogic(){}

    // (-#, +#)
    public void start(){
        System.out.println("Welcome to the Linear Equation Calculator!");
        while (stop) {
            parsePoint1();
            parsePoint2();

            equation();
        }
        System.out.println("Thank you for using the Linear Equation Calculator.\nGoodbye.");
    }

    private void parsePoint1(){
        System.out.print("Enter coordinate one: ");
        point1 = scan.nextLine();
        temp = point1.substring(1, point1.indexOf(","));
        x1 = Integer.parseInt(temp);
        temp = point1.substring(point1.indexOf(",") + 2, point1.length() - 1);
        y1 = Integer.parseInt(temp);
    }

    private void parsePoint2(){
        System.out.print("Enter coordinate two: ");
        point2 = scan.nextLine();
        temp = point2.substring(1, point2.indexOf(","));
        x2 = Integer.parseInt(temp);
        temp = point2.substring(point2.indexOf(",") + 2,  point2.length() - 1);
        y2 = Integer.parseInt(temp);
    }

    private void equation(){
        if (x1 == x2){
            System.out.println("The coordinates entered create a vertical line.\nSlope is not defined.");
            answer = "n";
        }else{
            LinearEquation one = new LinearEquation(x1, y1, x2, y2);
            System.out.println();
            System.out.println(one.lineInfo(point1, point2));

            System.out.print("Enter a x value: ");
            newX = scan.nextDouble();
            System.out.println(one.coordinateForX(newX));

            scan.nextLine();
            System.out.println();
            System.out.print("Do want to enter another set of coordinates? (y/n) ");
            answer = scan.nextLine();
        }
        if (answer.equals("n")) {
            stop = false;
        }
        System.out.println();
    }
}

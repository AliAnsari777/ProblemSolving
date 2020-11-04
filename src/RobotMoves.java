import java.util.*;

/*
 * Create the class Robot. Do not use the public access modifier in your class declaration.
 */

class Robot{
    int currentX;
    int currentY;
    int previousX;
    int previousY;
    char lastMove;

    public Robot(){
        this.currentX = 0;
        this.currentY = 5;
    }

    public Robot(int x, int y){
        this.currentX = x;
        this.currentY = y;
        this.previousX = 0;
        this.previousY = 5;
    }

    public void moveX(int dx){
        this.previousX = this.currentX;
        this.previousY = this.currentY;
        this.currentX += dx;
        lastMove = 'x';
    }

    public void moveY(int dy){
        this.previousY = this.currentY;
        this.previousX = this.currentX;
        this.currentY += dy;
        lastMove = 'y';
    }

    public void printCurrentCoordinates(){
        System.out.println(currentX + "  " + currentY);
    }

    public void printLastCoordinates(){
        System.out.println(previousX + "  " + previousY);
    }

    public void printLastMove(){
        if(lastMove == 'x'){
            System.out.println("x " + (currentX - previousX));
        }else if(lastMove == 'y'){
            System.out.println("y " + (currentY - previousY));
        }else{
            System.out.println("No move yet");
        }
    }


}
public class RobotMoves {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        int dx = scan.nextInt();
        int dy = scan.nextInt();

        Robot firstRobot = new Robot();
        firstRobot.printCurrentCoordinates();

        Robot secondRobot = new Robot(x, y);
        secondRobot.printCurrentCoordinates();

        for (int i = 1; i < 3; i++) {
            secondRobot.moveX(dx);
            secondRobot.printLastMove();
            secondRobot.printCurrentCoordinates();
            secondRobot.moveY(dy);
            secondRobot.printLastCoordinates();

            dx += i * i;
            dy -= i * i;
        }
    }
}
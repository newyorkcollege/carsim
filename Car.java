
import java.util.Random;


public class Car {
    
    private String plate;
    private int x;
    private int y;
    private boolean crashed;
    private int direction;
    
    public Car(String plate) {
        this.plate = plate;
        x = 0;
        y = 0;
        crashed = false;
        direction = 0;
    }
    
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        Random rnd = new Random();
        this.direction = rnd.nextInt(8);
    }
    
    public void translate() {
        switch(direction) {
            case 0:
                y -= 1;
                break;
            case 1:
                y -= 1;
                x += 1;
                break;
            case 2:
                x += 1;
                break;
            case 3:
                y += 1;
                x += x;
                break;
            case 4:
                y += 1;
                break;
            case 5:
                y += 1;
                x -= 1;
                break;
            case 6:
                x -= 1;
                break;
            case 7:
                y -= 1;
                x -= 1;
                break;
        }
    }

    public String getPlate() {
        return plate;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    public String toString() {
        return plate + " at " + x + ", " + y;
    }
    
    public void crash() {
        crashed = true;
    }
    
    public boolean isCrashed() {
        return crashed;
    }
    
    
    public static void main(String[] args) {
        Car a = new Car("AAA6754");
        a.move(100, 120);
        
        System.out.println(a);
    }
}



import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CarImage extends ImageView {
    
    private Car car;
   
    public CarImage(String plate) {
        car = new Car(plate);
        Random rnd = new Random();
        car.move(rnd.nextInt(Config.width), rnd.nextInt(Config.height));
        
        Image carimg = new Image(Simulator.class.getResourceAsStream("car.png"));
        this.setImage(carimg);
        
        this.setX(car.getX());
        this.setY(car.getY());
    }
    
    public String toString() {
        return car.toString();
    }
    
    public void move() {
 
        car.translate();
        this.setX(car.getX());
        this.setY(car.getY());
    }
    
}

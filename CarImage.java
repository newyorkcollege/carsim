
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CarImage extends ImageView {
    
    private Car car;
   
    public CarImage(String plate) {
        Random rnd = new Random();
        int carType = rnd.nextInt(100);
        
        if(carType <= 80) {
            car = new Car(plate);
        }
        else {
            car = new Bus(plate);
        }
        
        car.move(rnd.nextInt(Config.width), rnd.nextInt(Config.height));
        
        Image carimg = new Image(Simulator.class.getResourceAsStream(car.imageFile()));
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
    
    public void crash() {
        car.crash();
        Image carimg = new Image(Simulator.class.getResourceAsStream(car.imageFile()));
        this.setImage(carimg);
    }
    
    public boolean isCrashed() {
        return car.isCrashed();
    }
    
}

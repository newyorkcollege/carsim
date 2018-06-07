
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class CarImageList extends ArrayList<CarImage> {
    
    public CarImageList(int numOfCars) {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String NUMS = "1234567890";
        
        int c = CHARS.length();
        int n = NUMS.length();
        
        Random rnd = new Random();
        for(int i = 0; i < numOfCars; i++) {
            String plate = "";
            for(int j = 0; j < 3; j++) {
                plate = plate + CHARS.charAt(rnd.nextInt(n));
            }
            for(int j = 0; j < 4; j++) {
                plate = plate + NUMS.charAt(rnd.nextInt(n));
            }
            CarImage car = new CarImage(plate);
            
            this.add(car);
        }
    }
    
    public static void main(String[] args) {
        CarImageList list = new CarImageList(10);
        
        Iterator<CarImage> it = list.iterator();
        while(it.hasNext()) {
            CarImage c = it.next();
            System.out.println(c);
        }
    }
    
}

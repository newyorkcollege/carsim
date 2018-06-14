
public class Bus extends Car {
    
    public Bus(String plate) {
        super(plate);
    }
    
    @Override
    public String imageFile() {
        if(isCrashed()) {
            return "crashed.png";
        }
        return "bus.png";
    }
}

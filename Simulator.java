
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Simulator extends Application {
    
    private Stage mainStage;
    private Group group;
    
    private CarImageList list;
    

    @Override
    public void start(Stage primaryStage) {
        list = new CarImageList(1000);
        
        mainStage = primaryStage;
        
        BorderPane root = new BorderPane();
        
        Pane canvas = new Pane();
        group = new Group();
        canvas.getChildren().add(group);
        
        Iterator<CarImage> it = list.iterator();
        while(it.hasNext()) {
            CarImage tmp = it.next();
            
            group.getChildren().add(tmp);
        }
        
        root.setCenter(canvas);
        
        Scene scene = new Scene(root, Config.width, Config.height, Color.GHOSTWHITE);
        mainStage.setScene(scene);
        mainStage.setTitle("Car simulator");
        mainStage.show();
        
        SimulatorThread st = new SimulatorThread();
        st.start();
        
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    class SimulatorThread implements Runnable {
        
        private Thread thread;
        
        public void start() {
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            while(true) {
                Iterator<CarImage> it = list.iterator();
                while(it.hasNext()) {
                    CarImage tmp = it.next();

                    tmp.move();
                }
                
                it = list.iterator();
                while(it.hasNext()) {
                    CarImage a = it.next();
                    
                    Iterator<CarImage> it2 = list.iterator();
                    while(it2.hasNext()) {
                        CarImage b = it2.next();
                        
                        if(a != b) {
                            if(a.getX() == b.getX() && 
                                    a.getY() == b.getY()) {
                                System.out.println(a + " hits " + b);
                            }
                        }
                    }

                }
                
                
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}

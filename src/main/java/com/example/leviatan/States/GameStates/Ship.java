package com.example.leviatan.States.GameStates;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.Utilz.ShipPart;
import com.example.leviatan.Utilz.Type;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class Ship {
    private double scale= 3.0;
    private boolean showBackground = false;
    public Scene ShipScene(Pane gameRoot) {

        Scene editShip = new Scene(gameRoot, WindowConf.WINDOW_BASIC_WIDTH,WindowConf.WINDOW_BASIC_HEIGHT);
        Rectangle EQ = new Rectangle();
        Button showBackgroundButton = new Button("zmień widok");
        showBackgroundButton.setOnAction(e->{
            showBackground=!showBackground;
        });
        EQ.setX(500);
        EQ.setY(0);
        EQ.setWidth(WindowConf.WINDOW_BASIC_WIDTH-EQ.getX());
        EQ.setHeight(WindowConf.WINDOW_BASIC_HEIGHT);
        Image shipImage = new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Mobs\\Graphic\\Ship_2.png");
        Image shipImageBackground = new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Mobs\\Graphic\\Ship_2EditHelp.png");
        // Tworzenie ImageView i ustawianie obrazka
        ImageView shipImageView = new ImageView(shipImage);
        ImageView shipImageViewBackground = new ImageView(shipImageBackground);
        shipImageViewBackground.setFitWidth(shipImage.getWidth()*scale);
        shipImageViewBackground.setFitHeight(shipImage.getHeight()*scale);



        EQ.setFill(Color.YELLOW);
        getShipData();

        editShip.setOnMouseMoved(mouseEvent -> {
            if(mouseEvent.getX()>=EQ.getX()){
                System.out.println("EQ");
            }
            else {
                int x= 10*((int) mouseEvent.getX()/10);
                int y= 10*((int) mouseEvent.getY()/10);
                System.out.println("X : "+x+" | Y :"+y);
            }

        });


        gameRoot.getChildren().addAll(EQ,shipImageView,shipImageViewBackground,showBackgroundButton);
        return editShip;
    }

    private ArrayList<ShipPart> getPlayerShipEQ() {
        ArrayList<ShipPart> shipPartList = new ArrayList<>();
        ArrayList<String> Items = new ArrayList<>();
        Items.add("Item 1");
        Items.add("Item 2");
        shipPartList.add(new ShipPart(1,1,2,1, Type.Reactor,true));
        shipPartList.add(new ShipPart(2,1,2,1, Type.Greenhouse,true));
        shipPartList.add(new ShipPart(3,3,1,1, Type.Elevator,true));
        shipPartList.add(new ShipPart(1,1,1,1, Type.Command_Bridge,true));
        shipPartList.add(new ShipPart(4,1,1,1, Type.Cargo,true,Items));
        return shipPartList;

    }

    public static int[][] getShipData(){
        int[][] shipData= new int[WindowConf.GAME_PIXELS_HEIGHT][WindowConf.GAME_PIXELS_WIDTH];
        Image ship = getShipImg();
        PixelReader pixelReader = ship.getPixelReader();
        for (int i = 0; i < ship.getHeight(); i++) {
            for (int j = 0; j < ship.getWidth(); j++) {
                shipData[i][j]= (pixelReader.getArgb(j,i)>>16 & 0xFF);
//               shipData[i][j]  = (pixelReader.getArgb(j,i) & 0xFF);  blue
//               shipData[i][j]  = (pixelReader.getArgb(j,i)>>8 & 0xFF);  green

            }
        }
        return shipData;
    }

    private static Image getShipImg() {
        Image shipbasic = new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Sprites\\ShipCore\\Ship_2.png");
        return shipbasic;
    }
}

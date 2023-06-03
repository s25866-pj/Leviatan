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
        Image Ship2RoomShape= new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Sprites\\ShipCore\\Ship_2.png");

        Image shipBlueprint = new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Sprites\\ShipCore\\Ship_2.png");
        EQ.setX(500);
        EQ.setY(0);

        EQ.setWidth(WindowConf.WINDOW_BASIC_WIDTH-EQ.getX());
        EQ.setHeight(WindowConf.WINDOW_BASIC_HEIGHT);
        Image shipImage = new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Mobs\\Graphic\\Ship_2.png");
        Image shipImageBackground = new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Mobs\\Graphic\\Ship_2EditHelp.png");
        ImageView shipImageView = new ImageView(shipImage);
        ImageView shipImageViewBackground = new ImageView(shipImageBackground);
        shipImageViewBackground.setFitWidth(shipImage.getWidth()*scale);
        shipImageViewBackground.setFitHeight(shipImage.getHeight()*scale);



        EQ.setFill(Color.YELLOW);
        getShipData(Ship2RoomShape);

        editShip.setOnMouseMoved(mouseEvent -> {
            if(mouseEvent.getX()>=EQ.getX()){
                System.out.println("EQ");
            }
            else {
//                int x= 10*((int) mouseEvent.getX()/10);
//                int y= 10*((int) mouseEvent.getY()/10);
                int x = ((int)mouseEvent.getX());
                int y = ((int)mouseEvent.getY());
                System.out.println("X : "+x+" | Y :"+y);
            }

        });
        gameRoot.getChildren().addAll(EQ,shipImageView,shipImageViewBackground,showBackgroundButton);
        return editShip;
    }

    private ArrayList<java.awt.Rectangle> createShipEectangle(Image shipBlueprint) {

        for (int i = 0; i < shipBlueprint.getWidth(); i++) {
            for (int j = 0; j < shipBlueprint.getHeight(); j++) {


            }
        }
        return null;
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

    public static int[][] getShipData(Image ship){
        ArrayList<ArrayList<Integer>> shipData= new ArrayList<>();
        ArrayList <Integer> row = new ArrayList<>();
        PixelReader pixelReader = ship.getPixelReader();
        for (int i = 0; i < ship.getHeight(); i++) {
            for (int j = 0; j < ship.getWidth(); j++) {
                if(checkColor(pixelReader.getArgb(j,i), 255,255,255)){
                        row.add(1);
                }

                   // (pixelReader.getArgb(j,i)>>16 & 0xFF)
//               shipData[i][j]  = (pixelReader.getArgb(j,i) & 0xFF);  blue
//               shipData[i][j]  = (pixelReader.getArgb(j,i)>>8 & 0xFF);  green
            }
            shipData.add(row);
            row=new ArrayList<>();
        }
        System.out.println(shipData);
        return null;
    }

    private static boolean checkColor(int argb,int r, int g, int b) {
        int pixelRed = (argb >> 16) & 0xFF;
        int pixelGreen = (argb >> 8) & 0xFF;
        int pixelBlue = argb & 0xFF;
        return (pixelRed == r && pixelGreen == g && pixelBlue == b);
    }

    private static Image getShipImg() {
        Image shipbasic = new Image("C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Sprites\\ShipCore\\Ship_2.png");
        return shipbasic;
    }
}

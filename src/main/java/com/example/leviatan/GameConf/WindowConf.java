package com.example.leviatan.GameConf;

import javafx.scene.text.Font;

public class WindowConf {
    public static final float GAME_SCALE = 1.5F;
    public static final double WINDOW_BASIC_WIDTH = 640;
    public static final double WINDOW_BASIC_HEIGHT = (WINDOW_BASIC_WIDTH /16)*9;
    public static final int GAME_PIXELS_WIDTH=(int)WINDOW_BASIC_WIDTH/10;
    public static final int GAME_PIXELS_HEIGHT=(int)WINDOW_BASIC_HEIGHT/10;
    public class GUI{
        public static final int HP_WIDTH=(int) WINDOW_BASIC_WIDTH -35;
        public static final int HP_HEIGHT=20;
        public static final int HP_SIZE=20;
//        public static final Font HP_FONT= Font.font("/main/java/com/example/leawiatan/Sources/Fonts/VT323-Regular.ttf");


    }
    public class GAME_CONF {
        public static final String SAVES_FILE_LINUX = "Lewiatan/src/main/java/com/example/leawiatan/Saves/";
        public static final String SAVES_FILE_Win = "C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Saves\\";
        public static final String LIST_OF_WEAPON_LINUX="Leviatan/src/main/java/com/example/leviatan/Sprites/ListOfWeapon.json";
        public static final String LIST_OF_WEAPON_Win ="C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Sprites\\ListOfWeapon.json";


    }

}

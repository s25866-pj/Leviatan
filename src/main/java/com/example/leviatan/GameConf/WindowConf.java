package com.example.leviatan.GameConf;

import javafx.scene.text.Font;

public class WindowConf {
    public static final double WINDOW_WIDTH = 400;
    public static final double WINDOW_HEIGHT = 300;
    public class GUI{
        public static final int HP_WIDTH=(int)WINDOW_WIDTH-35;
        public static final int HP_HEIGHT=20;
        public static final int HP_SIZE=20;
        public static final Font HP_FONT= Font.font("/main/java/com/example/leawiatan/Sources/Fonts/VT323-Regular.ttf");


    }
    public class GAME_CONF {
        public static final String SAVES_FILE_LINUX = "Lewiatan/src/main/java/com/example/leawiatan/Saves/";
        public static final String SAVES_FILE_Win = "C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Saves\\";
        public enum GAME_STATUS  {
            MENU,
            CREATE_NEW_GAME,
            GAME

        }
    }
}

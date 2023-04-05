package com.example.leviatan.GameConf;

import javafx.scene.text.Font;

public class WindowConf {
    public static final float GAME_SCALE = 1.5F;
    public static final double WINDOW_BASIC_WIDTH = 640;
    public static final double WINDOW_BASIC_HEIGHT = (WINDOW_BASIC_WIDTH /16)*9;
//    public static final double WINDOW_FINAL_WIDTH = WINDOW_BASIC_WIDTH*GAME_SCALE;
//    public static final double WINDOW_FINAL_HEIGHT = WINDOW_BASIC_HEIGHT*GAME_SCALE;
    public class GUI{
        public static final int HP_WIDTH=(int) WINDOW_BASIC_WIDTH -35;
        public static final int HP_HEIGHT=20;
        public static final int HP_SIZE=20;
        public static final Font HP_FONT= Font.font("/main/java/com/example/leawiatan/Sources/Fonts/VT323-Regular.ttf");


    }
    public class GAME_CONF {
        public static final String SAVES_FILE_LINUX = "Lewiatan/src/main/java/com/example/leawiatan/Saves/";
        public static final String SAVES_FILE_Win = "C:\\Users\\damia\\Desktop\\JAVA\\Leviatan\\Leviatan\\src\\main\\java\\com\\example\\leviatan\\Saves\\";
        public enum WINDOW_STATUS{
            MENU,//wiadomo
            CREATE_NEW_GAME,//tworzenie gry
            GAME,//inne miejsca
        }
        public static WINDOW_STATUS gameStatus = WINDOW_STATUS.MENU;
        public enum GAME_STATUS  {
            SHIP,//nasz statek
            DOCK//edycja statku, zupełnianie zaopatrzenia

        }
    }

}

package OmokGame.Model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Model {
    public final int X_START = 75;
    public final int Y_START = 75;
    public final int BLACK = 1;
    public final int WHITE = 2;
    public int b_reverseCount = 1;
    public int w_reverseCount = 1;
    public boolean Wwinstate = false;
    public boolean Bwinstate = false;
    /////////////////////////
    AudioInputStream ais;
    Clip clip;
    boolean state = true;
    /******************My turn*****************/
    private int my_turn;
    /*********************************************/
    private int game_turn;
    /********************************************************************/
    private String playername1;
    private String playername2;
    private final int[][] arr = new int[15][15];
    private int pastblack_x;
    private int pastblack_y;
    private int pastwhite_x;
    private int pastwhite_y;
    private int white_x = -1;
    private int white_y;
    private int black_x = -1;
    private int black_y;

    public int getMy_turn() {
        return my_turn;
    }

    public void setMy_turn(int my_turn) {
        this.my_turn = my_turn;
    }

    public int getGame_turn() {
        return game_turn;
    }

    public void setGame_turn(int game_turn) {
        this.game_turn = game_turn;
    }

    public String getPlayername1() {
        return playername1;
    }

    public void setPlayername1(String playername1) {
        this.playername1 = playername1;
    }

    public String getPlayername2() {
        return playername2;
    }

    public void setPlayername2(String playername2) {
        this.playername2 = playername2;
    }

    public void setArr(int value, int i, int j) {
        this.arr[i][j] = value;
    }

    public int getArr(int i, int j) {
        return arr[i][j];
    }

    public int getWhite_x() {
        return white_x;
    }

    public void setWhite_x(int white_x) {
        this.white_x = white_x;
    }

    public int getWhite_y() {
        return white_y;
    }

    public void setWhite_y(int white_y) {
        this.white_y = white_y;
    }

    public int getBlack_x() {
        return black_x;
    }

    public void setBlack_x(int black_x) {
        this.black_x = black_x;
    }

    public int getBlack_y() {
        return black_y;
    }

    public void setBlack_y(int black_y) {
        this.black_y = black_y;
    }

    public int getPastblack_x() {
        return pastblack_x;
    }

    public void setPastblack_x(int pastblack_x) {
        this.pastblack_x = pastblack_x;
    }

    public int getPastblack_y() {
        return pastblack_y;
    }

    public void setPastblack_y(int pastblack_y) {
        this.pastblack_y = pastblack_y;
    }

    public int getPastwhite_x() {
        return pastwhite_x;
    }

    public void setPastwhite_x(int pastwhite_x) {
        this.pastwhite_x = pastwhite_x;
    }

    public int getPastwhite_y() {
        return pastwhite_y;
    }

    public void setPastwhite_y(int pastwhite_y) {
        this.pastwhite_y = pastwhite_y;
    }

    ///////////
    public void clicksound() {
        try {
            ais = AudioSystem.getAudioInputStream(new File("src/OmokGame/res/click.wav"));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            System.out.println("에러");
        }
    }

    ///////////////////////
    public void stonesound() {
        try {
            ais = AudioSystem.getAudioInputStream(new File("src/OmokGame/res/stonesound.wav"));
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            System.out.println("에러");
        }
    }

    ////////////////////////
    public void playdaeguk() {
        try {
            ais = AudioSystem.getAudioInputStream(new File("src/OmokGame/res/start.wav"));
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            System.out.println("에러");
        }
    }

    /////////////////////////
    public void playstartdarguk() {
        try {
            ais = AudioSystem.getAudioInputStream(new File("src/OmokGame/res/startdaeguk.wav"));
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            System.out.println("에러");
        }
    }

    public void initchess() {
        int i, j;
        for (i = 0; i < 15; i++) {
            for (j = 0; j < 15; j++) {
                arr[i][j] = 0;
            }
        }
    }


    public boolean black_widthcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1) {
            int j = b;

            for (int i = (a - 4); i <= (a + 4); i++) {
                if (i >= 0 && i < 15) {
                    if (arr[i][j] == 1) {
                        count++;
                        if (max_count < count) {
                            max_count = count;
                        }
                    } else {
                        count = 0;
                    }
                }

            }
            if (max_count == 5)
                return true;
            else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //-------------------------------------------------------------------------------------
    public boolean black_heightcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1) {
            int i = a;

            for (int j = (b - 4); j <= (b + 4); j++) {
                if (j >= 0 && j < 15) {
                    if (arr[i][j] == 1) {
                        count++;
                        if (max_count < count) {
                            max_count = count;
                        }
                    } else {
                        count = 0;
                    }
                }

            }
            if (max_count == 5)
                return true;
            else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //--------------------------------------------------------------------------------------------------
    public boolean black_leftdiagcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1) {
            for (int i = -4; i <= 4; i++) {
                if (a + i >= 0 && a + i < 15) {
                    if (b + i >= 0 && b + i < 15) {
                        if (arr[a + i][b + i] == 1) {
                            count++;
                            if (max_count < count) {
                                max_count = count;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
            if (max_count == 5) {
                return true;
            } else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //-------------------------------------------------------------------------------------------------
    public boolean black_rightdiagcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1) {
            for (int i = -4; i <= 4; i++) {
                if (a - i >= 0 && a - i < 15) {
                    if (b + i >= 0 && b + i < 15) {
                        if (arr[a - i][b + i] == 1) {
                            count++;
                            if (max_count < count) {
                                max_count = count;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
            if (max_count == 5) {
                return true;
            } else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //--------------------------------------------------------------------------------------------------
    public boolean white_widthcheck(int a, int b) { //�鵹 ����Ȯ��.
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 2) {
            int j = b;

            for (int i = (a - 4); i <= (a + 4); i++) {
                if (i >= 0 && i < 15) {
                    if (arr[i][j] == 2) {
                        count++;
                        if (max_count < count) {
                            max_count = count;
                        }
                    } else {
                        count = 0;
                    }
                }

            }
            if (max_count == 5)
                return true;
            else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //--------------------------------------------------------------------------------------------------
    public boolean white_heightcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 2) {
            int i = a;

            for (int j = (b - 4); j <= (b + 4); j++) {
                if (j >= 0 && j < 15) {
                    if (arr[i][j] == 2) {
                        count++;
                        if (max_count < count) {
                            max_count = count;
                        }
                    } else {
                        count = 0;
                    }
                }

            }
            if (max_count == 5)
                return true;
            else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------
    public boolean white_leftdiagcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 2) {
            for (int i = -4; i <= 4; i++) {
                if (a + i >= 0 && a + i < 15) {
                    if (b + i >= 0 && b + i < 15) {
                        if (arr[a + i][b + i] == 2) {
                            count++;
                            if (max_count < count) {
                                max_count = count;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
            if (max_count == 5) {
                return true;
            } else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------------------
    public boolean white_rightdiagcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 2) {
            for (int i = -4; i <= 4; i++) {
                if (a - i >= 0 && a - i < 15) {
                    if (b + i >= 0 && b + i < 15) {
                        if (arr[a - i][b + i] == 2) {
                            count++;
                            if (max_count < count) {
                                max_count = count;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
            if (max_count == 5) {
                return true;
            } else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //------------------------------------------------------------------------
    public boolean triple_widthcheck(int a, int b) { //������ ����Ȯ��.
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1 || arr[a][b] == 2) {
            int j = b;

            for (int i = (a - 4); i <= (a + 4); i++) {
                if (i >= 0 && i < 15) {
                    if (arr[i][j] == 1 || arr[i][j] == 2) {
                        count++;
                        System.out.println(count);
                        if (max_count < count) {
                            max_count = count;
                        }
                    } else {
                        count = 0;
                    }
                }

            }

            if (max_count == 3) //
                return true;
            else if (max_count >= 6) { //6�� ����
                return false;
            }
        }
        return false;
    }

    //----------------------------------------------------------------------
    public boolean triple_lengthcheck(int a, int b) { //�鵹 ����Ȯ��
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1 || arr[a][b] == 2) {
            int i = a;

            for (int j = (b - 4); j <= (b + 4); j++) {
                if (j >= 0 && j < 15) {
                    if (arr[i][j] == 1 || arr[i][j] == 2) {
                        count++;
                        if (max_count < count) {
                            max_count = count;
                        }
                    } else {
                        count = 0;
                    }
                }

            }
            //System.out.println("max : " + max_count);
            if (max_count == 3)
                return true;
            else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //----------------------------------------------------------------------
    public boolean triple_rightdiagcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1 || arr[a][b] == 2) {
            for (int i = -4; i <= 4; i++) {
                if (a - i >= 0 && a - i < 15) {
                    if (b + i >= 0 && b + i < 15) {
                        if (arr[a - i][b + i] == 1 || arr[a - i][b + i] == 2) {
                            count++;
                            if (max_count < count) {
                                max_count = count;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
            if (max_count == 3) {
                return true;
            } else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }

    //---------------------------------------------------------
    public boolean triple_leftdiagcheck(int a, int b) {
        int count = 0;
        int max_count = 0;
        if (arr[a][b] == 1 || arr[a][b] == 2) {
            for (int i = -4; i <= 4; i++) {
                if (a + i >= 0 && a + i < 15) {
                    if (b + i >= 0 && b + i < 15) {
                        if (arr[a + i][b + i] == 1 || arr[a + i][b + i] == 2) {
                            count++;
                            if (max_count < count) {
                                max_count = count;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
            if (max_count == 3) {
                return true;
            } else if (max_count >= 6) {
                return false;
            }
        }
        return false;
    }


}

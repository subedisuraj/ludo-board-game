
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board {

    Map<Integer, CoOrdinates> maptable;
    Player p1, p2, p3, p4;
    Dice d;
    public static char[][] boardarray;
    int row = 67, column = 92;
    boolean gameover = false;

    public Board() {
        p1 = new Player(1, 'B', "BLU");
        p2 = new Player(2, 'Y', "YEL");
        p3 = new Player(3, 'G', "GRE");
        p4 = new Player(4, 'R', "RED");
        d = new Dice(p3);
        this.maptable = new HashMap<Integer, CoOrdinates>();
        create_maptable();
    }

    int get_absolute_position(int pid, int position) {
        if (position < 0) {
            return position;
        }
        switch (pid) {
            case 1:
                return position;
            case 2:
                if (0 <= position && position <= 38) {
                    return position + 13;
                } else if (39 <= position && position <= 51) {
                    return position - 39;
                } else if (52 <= position && position <= 57) {
                    return position + 6;
                }
            case 3:
                if (0 <= position && position <= 25) {
                    return position + 26;
                } else if (26 <= position && position <= 51) {
                    return position - 26;
                } else if (52 <= position && position < 57) {
                    return position + 12;
                }
            case 4:
                if (0 <= position && position <= 12) {
                    return position + 39;
                } else if (13 <= position && position <= 51) {
                    return position - 13;
                } else if (52 <= position && position < 57) {
                    return position + 18;
                }
        }
        return 0;
    }

    void create_maptable() {
        maptable.put(-1, new CoOrdinates(45, 10));
        maptable.put(-2, new CoOrdinates(45, 23));
        maptable.put(-3, new CoOrdinates(53, 10));
        maptable.put(-4, new CoOrdinates(53, 23));
        maptable.put(-5, new CoOrdinates(9, 10));
        maptable.put(-6, new CoOrdinates(9, 23));
        maptable.put(-7, new CoOrdinates(17, 10));
        maptable.put(-8, new CoOrdinates(17, 23));
        maptable.put(-9, new CoOrdinates(9, 64));
        maptable.put(-10, new CoOrdinates(9, 78));
        maptable.put(-11, new CoOrdinates(17, 64));
        maptable.put(-12, new CoOrdinates(17, 78));
        maptable.put(-13, new CoOrdinates(45, 64));
        maptable.put(-14, new CoOrdinates(45, 78));
        maptable.put(-15, new CoOrdinates(53, 64));
        maptable.put(-16, new CoOrdinates(53, 78));

        maptable.put(0, new CoOrdinates(58, 38));

        maptable.put(1, new CoOrdinates(54, 38));
        maptable.put(2, new CoOrdinates(50, 38));
        maptable.put(3, new CoOrdinates(46, 38));
        maptable.put(4, new CoOrdinates(42, 38));
        maptable.put(5, new CoOrdinates(38, 38));
        maptable.put(6, new CoOrdinates(34, 32));
        maptable.put(7, new CoOrdinates(34, 26));
        maptable.put(8, new CoOrdinates(34, 20));
        maptable.put(9, new CoOrdinates(34, 14));
        maptable.put(10, new CoOrdinates(34, 8));
        maptable.put(11, new CoOrdinates(34, 2));
        maptable.put(12, new CoOrdinates(30, 2));
        maptable.put(13, new CoOrdinates(26, 2));
        maptable.put(14, new CoOrdinates(26, 8));
        maptable.put(15, new CoOrdinates(26, 14));
        maptable.put(16, new CoOrdinates(26, 20));
        maptable.put(17, new CoOrdinates(26, 26));
        maptable.put(18, new CoOrdinates(26, 32));
        maptable.put(19, new CoOrdinates(22, 38));
        maptable.put(20, new CoOrdinates(18, 38));
        maptable.put(21, new CoOrdinates(14, 38));
        maptable.put(22, new CoOrdinates(10, 38));
        maptable.put(23, new CoOrdinates(6, 38));
        maptable.put(24, new CoOrdinates(2, 38));
        maptable.put(25, new CoOrdinates(2, 44));
        maptable.put(26, new CoOrdinates(2, 50));
        maptable.put(27, new CoOrdinates(6, 50));
        maptable.put(28, new CoOrdinates(10, 50));
        maptable.put(29, new CoOrdinates(14, 50));
        maptable.put(30, new CoOrdinates(18, 50));
        maptable.put(31, new CoOrdinates(22, 50));
        maptable.put(32, new CoOrdinates(26, 56));
        maptable.put(33, new CoOrdinates(26, 62));
        maptable.put(34, new CoOrdinates(26, 68));
        maptable.put(35, new CoOrdinates(26, 74));
        maptable.put(36, new CoOrdinates(26, 80));
        maptable.put(37, new CoOrdinates(26, 86));
        maptable.put(38, new CoOrdinates(30, 86));
        maptable.put(39, new CoOrdinates(34, 86));
        maptable.put(40, new CoOrdinates(34, 80));
        maptable.put(41, new CoOrdinates(34, 74));
        maptable.put(42, new CoOrdinates(34, 68));
        maptable.put(43, new CoOrdinates(34, 62));
        maptable.put(44, new CoOrdinates(34, 56));
        maptable.put(45, new CoOrdinates(38, 50));
        maptable.put(46, new CoOrdinates(42, 50));
        maptable.put(47, new CoOrdinates(46, 50));
        maptable.put(48, new CoOrdinates(50, 50));
        maptable.put(49, new CoOrdinates(54, 50));
        maptable.put(50, new CoOrdinates(58, 50));
        maptable.put(51, new CoOrdinates(58, 44));

        maptable.put(52, new CoOrdinates(54, 44));
        maptable.put(53, new CoOrdinates(50, 44));
        maptable.put(54, new CoOrdinates(46, 44));
        maptable.put(55, new CoOrdinates(42, 44));
        maptable.put(56, new CoOrdinates(38, 44));
        maptable.put(57, new CoOrdinates(34, 44));

        maptable.put(58, new CoOrdinates(30, 8));
        maptable.put(59, new CoOrdinates(30, 14));
        maptable.put(60, new CoOrdinates(30, 20));
        maptable.put(61, new CoOrdinates(30, 26));
        maptable.put(62, new CoOrdinates(30, 32));
        maptable.put(63, new CoOrdinates(30, 38));

        maptable.put(64, new CoOrdinates(6, 44));
        maptable.put(65, new CoOrdinates(10, 44));
        maptable.put(66, new CoOrdinates(14, 44));
        maptable.put(67, new CoOrdinates(18, 44));
        maptable.put(68, new CoOrdinates(22, 44));
        maptable.put(69, new CoOrdinates(26, 44));

        maptable.put(70, new CoOrdinates(30, 80));
        maptable.put(71, new CoOrdinates(30, 74));
        maptable.put(72, new CoOrdinates(30, 68));
        maptable.put(73, new CoOrdinates(30, 62));
        maptable.put(74, new CoOrdinates(30, 56));
        maptable.put(75, new CoOrdinates(30, 50));

    }

    void initialize_board() {
        try {
            readFile("ludoboard.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Could not load board file. File Not Found");
            exit(1);
        }
    }

    void gameplay() {
        Scanner input = new Scanner(System.in);
        Scanner tokenchoice = new Scanner(System.in);
        String s, t = "";
        s = input.next();

        if (s.equalsIgnoreCase("S")) {
            gamestarted();
            displayboard();
            while (!gameover) {
                s = input.next();
                if (s.equalsIgnoreCase("R")) {
                    int dv = d.setdicevalue();
                    write_to_board_array(64, 82, String.valueOf(dv));
                    displayboard();
                    if (d.checkmove()) {
                        int valid_token = 0;
                        boolean start = true;
                        while (valid_token != 1) {
                            write_to_board_array(64, 0, "                             ");
                            displayboard();
                            if (!start) {
                                if (valid_token == 0) {
                                    System.out.println("\"" + t + "\"" + " is not valid token.");
                                }
                            }
                            System.out.println("SELECT YOUR TOKEN TO MOVE (1,2,3,4):");
                            t = tokenchoice.next();
                            int tno;
                            try {
                                tno = Integer.parseInt(t) - 1;
                                valid_token = d.token_movement(tno, p1, p2, p3, p4);

                                if (valid_token == 100) {
                                    write_to_board_array(66, 10, d.current_player.color + "            ");
                                    updateBoard();
                                    displayboard();
                                    System.out.println("GAME OVER");
                                    exit(0);
                                }

                                if (valid_token != 0) {
                                    check_jumped_upon(tno);
                                    if (double_position(d.current_player.tk[tno], d.current_player) == 2) {
                                        int cell = get_absolute_position(d.current_player.id, d.current_player.tk[tno].newposition);
                                        if (cell <= 51) {
                                            d.current_player.block = true;
                                            d.current_player.blockedcell = cell;
                                        }
                                    }
                                }

                            } catch (NumberFormatException e) {
                                valid_token = 0;
                            }

                            start = false;
                        }
                        write_to_board_array(64, 0, "PRESS \"R\" TO ROLL THE DICE.");

                    }
                    set_turn();
                    updateBoard();
                    displayboard();

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    void readFile(String file) throws FileNotFoundException {

        boardarray = new char[row][column];
        Scanner board = new Scanner(new FileReader("ludoboard.txt"));
        String line;
        try {
            line = board.nextLine();
            int lineno = 0;
            while (line != null) {

                line = board.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    boardarray[lineno][i] = line.charAt(i);
                }
                lineno++;
            }
        } catch (NoSuchElementException e) {
        }
        displayboard();

    }

    private void gamestarted() {
        d.current_player = p1;
        write_to_board_array(62, 86, "BLU");
        write_to_board_array(62, 0, "GAME STARTED                ");
    }

    static void write_to_board_array(int r1, int c1, String inputstring) {
        for (int i = c1; i <= c1 + inputstring.length() - 1; i++) {
            boardarray[r1][i] = inputstring.charAt(i - c1);
        }
    }

    private void displayboard() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.printf("%c", boardarray[r][c]);
            }
            System.out.println();
        }
    }

    private void updateBoard() {

        for (int i = 0; i <= 3; i++) {
            CoOrdinates op = map_position_to_coordinate(get_absolute_position(p1.id, p1.tk[i].lastposition), p1.id);
            CoOrdinates np = map_position_to_coordinate(get_absolute_position(p1.id, p1.tk[i].newposition), p1.id);

            if ((double_position(p1.tk[i], p1) != 1) && (double_position(p1.tk[i], p2) != 1) && (double_position(p1.tk[i], p3) != 1) && (double_position(p1.tk[i], p4) != 1)) {
                write_to_board_array(op.x, op.y, "  ");
            }
            write_to_board_array(np.x, np.y, p1.symbol + String.valueOf(i + 1));
        }

        for (int i = 0; i <= 3; i++) {
            CoOrdinates op = map_position_to_coordinate(get_absolute_position(p2.id, p2.tk[i].lastposition), p2.id);
            CoOrdinates np = map_position_to_coordinate(get_absolute_position(p2.id, p2.tk[i].newposition), p2.id);

            if ((double_position(p2.tk[i], p1) != 1) && (double_position(p2.tk[i], p2) != 1) && (double_position(p2.tk[i], p3) != 1) && (double_position(p2.tk[i], p4) != 1)) {

                write_to_board_array(op.x, op.y, "  ");
            }
            write_to_board_array(np.x, np.y, p2.symbol + String.valueOf(i + 1));
        }

        for (int i = 0; i <= 3; i++) {
            CoOrdinates op = map_position_to_coordinate(get_absolute_position(p3.id, p3.tk[i].lastposition), p3.id);
            CoOrdinates np = map_position_to_coordinate(get_absolute_position(p3.id, p3.tk[i].newposition), p3.id);

            if ((double_position(p3.tk[i], p1) != 1) && (double_position(p3.tk[i], p2) != 1) && (double_position(p3.tk[i], p3) != 1) && (double_position(p3.tk[i], p4) != 1)) {
                write_to_board_array(op.x, op.y, "  ");
            }
            write_to_board_array(np.x, np.y, p3.symbol + String.valueOf(i + 1));
        }

        for (int i = 0; i <= 3; i++) {
            CoOrdinates op = map_position_to_coordinate(get_absolute_position(p4.id, p4.tk[i].lastposition), p4.id);
            CoOrdinates np = map_position_to_coordinate(get_absolute_position(p4.id, p4.tk[i].newposition), p4.id);

            if ((double_position(p4.tk[i], p1) != 1) && (double_position(p4.tk[i], p2) != 1) && (double_position(p4.tk[i], p3) != 1) && (double_position(p4.tk[i], p4) != 1)) {
                write_to_board_array(op.x, op.y, "  ");
            }
            write_to_board_array(np.x, np.y, p4.symbol + String.valueOf(i + 1));
        }

        switch (d.current_player.id) {
            case 1:
                write_to_board_array(62, 86, "BLU");
                break;
            case 2:
                write_to_board_array(62, 86, "YEL");
                break;
            case 3:
                write_to_board_array(62, 86, "GRE");
                break;
            case 4:
                write_to_board_array(62, 86, "RED");
                break;
            default:
                System.out.println("");
                break;
        }
    }

    private CoOrdinates map_position_to_coordinate(int position, int pid) {
        return maptable.get(position);
    }

    void set_turn() {

        if (d.dice_value != 6) {
            if (d.current_player == p1) {
                d.current_player = p2;
            } else if (d.current_player == p2) {
                d.current_player = p3;
            } else if (d.current_player == p3) {
                d.current_player = p4;
            } else if (d.current_player == p4) {
                d.current_player = p1;
            }
        }
        
        d.last_value = d.dice_value;
        write_to_board_array(64, 82, String.valueOf(" "));
        write_to_board_array(66, 82, String.valueOf(d.last_value));
    }

    private void check_jumped_upon(int tno) {
        for (int i = 0; i <= 3; i++) {
            if (get_absolute_position(p1.id, p1.tk[i].newposition) == get_absolute_position(d.current_player.id, d.current_player.tk[tno].newposition)) {
                if (p1.id != d.current_player.id) {
                    p1.tk[i].newposition = -1 * 0 * 4 - i - 1;
                    p1.tk[i].onboard = false;
                }
            }

            if (get_absolute_position(p2.id, p2.tk[i].newposition) == get_absolute_position(d.current_player.id, d.current_player.tk[tno].newposition)) {
                if (p2.id != d.current_player.id) {
                    p2.tk[i].newposition = -1 * 1 * 4 - i - 1;
                    p2.tk[i].onboard = false;
                }
            }

            if (get_absolute_position(p3.id, p3.tk[i].newposition) == get_absolute_position(d.current_player.id, d.current_player.tk[tno].newposition)) {
                if (p3.id != d.current_player.id) {
                    p3.tk[i].newposition = -1 * 2 * 4 - i - 1;
                    p3.tk[i].onboard = false;
                }
            }

            if (get_absolute_position(p4.id, p4.tk[i].newposition) == get_absolute_position(d.current_player.id, d.current_player.tk[tno].newposition)) {
                if (p4.id != d.current_player.id) {
                    p4.tk[i].newposition = -1 * 3 * 4 - i - 1;
                    p4.tk[i].onboard = false;
                }
            }
        }

    }

    private int double_position(Token tk, Player p) {

        for (int i = 0; i <= 3; i++) {
            if (tk != p.tk[i]) {
                if ((tk.lastposition == p.tk[i].newposition)) {
                    return 1;
                }
            }
        }

        for (int i = 0; i <= 3; i++) {
            if ((p.tk[i].newposition == tk.newposition) && (tk != p.tk[i])) {
                return 2;
            }
        }
        return 0;
    }
}

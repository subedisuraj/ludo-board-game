

import java.util.Scanner;

public class Dice {

    Player current_player;
    int dice_value;
    int last_value;

    Dice(Player p) {

        current_player = p;
        dice_value = 0;
        last_value = 0;
    }

    private void set_token_onboard(Player cp, int tno) {

        cp.tk[tno].onboard = true;
        cp.tk[tno].newposition = 1;

    }

    int setdicevalue() {
        dice_value = (int) (Math.random() * 6 + 1);
        return dice_value;
    }

    boolean checkmove() {
        if (current_player.tk[0].onboard || current_player.tk[1].onboard || current_player.tk[2].onboard || current_player.tk[3].onboard || (dice_value == 6)) {
            return true;
        } else {
            return false;
        }
    }

    int token_movement(int tno, Player p1, Player p2, Player p3, Player p4) {
        try {
            if (current_player.tk[tno].onboard && !(current_player.tk[tno].game_status)) {

                if (!checkblock(current_player, tno, p1, p2, p3, p4)) {

                    int a = current_player.tk[tno].move_token(dice_value, current_player.symbol, tno);

                    if (gameover()) {
                        return 100;
                    }

                    if (current_player.block && blockbroken(tno)) {
                        current_player.block = false;
                    }

                    if (a == -1) {
                        return -1;
                    }

                } else {
                    return 0;
                }

            } else {
                if (dice_value == 6) {
                    set_token_onboard(current_player, tno);
                } else {
                    return 0;
                }

            }
        } catch (Exception e) {
            return 0;
        }
        return 1;

    }
//
//    private void check_jumped_upon(int tno) {
//        for(int i=0;i<=3;i++)
//        {
//            if current_player.tk[tno].newposition==
//        }
//        return null;
//    }

    private boolean checkblock(Player cp, int tno, Player p1, Player p2, Player p3, Player p4) {
        
        Board b = new Board();
//        int abs_cur_pos=b.get_absolute_position(cp.id,cp.tk[tno].newposition );
        
        

        if (p1.block && cp != p1) {
            for(int i = 1; i<=dice_value;i++)
            {
                if (b.get_absolute_position(cp.id,(cp.tk[tno].newposition+i))==p1.blockedcell)
                    return true;
            }   
        }
        
        if (p2.block && cp != p2) {
            for(int i = 1; i<=dice_value;i++)
            {
                if (b.get_absolute_position(cp.id,(cp.tk[tno].newposition+i))==p2.blockedcell)
                    return true;
            }   
        }
        
        if (p3.block && cp != p3) {
            for(int i = 1; i<=dice_value;i++)
            {
                if (b.get_absolute_position(cp.id,(cp.tk[tno].newposition+i))==p3.blockedcell)
                    return true;
            }   
        }
        
        if (p4.block && cp != p4) {
            for(int i = 1; i<=dice_value;i++)
            {
                if (b.get_absolute_position(cp.id,(cp.tk[tno].newposition+i))==p4.blockedcell)
                    return true;
            }   
        }
        
        return false;

    }

    private boolean blockbroken(int tno) {

        for (int x = 0; x <= 3; x++) {
            for (int y =0;y<=3;y++)
            {
            if (current_player.tk[x].newposition == current_player.tk[y].newposition && y != x) {
                return false;
            }
            }
        }
        return true;
    }

    private boolean gameover() {

        for (int i = 0; i <= 3; i++) {
            if (!current_player.tk[i].game_status) {
                return false;
            }
        }

        return true;

    }

}

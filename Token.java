
class Token {

    int newposition;
    int lastposition;
    boolean game_status;
    boolean onboard;
    boolean hasablock;
    boolean double_pos;
    boolean double_pos_flag;

    Token(int tokenid, int playerno) {
        lastposition = -1 * playerno * 4 - tokenid;
        onboard = false;
        newposition = -1 * playerno * 4 - tokenid;
        game_status = false;
        double_pos = false;
        double_pos_flag = false;
    }

    int move_token(int dice_value, char symbol, int tno) {
        boolean invalid_move = false;
        lastposition = newposition;
        if (newposition < 0) {
            newposition = 1;
        }
        if (newposition > 50) {
            switch (newposition + dice_value) {
                case 57:
                    this.game_status = true;
                    newposition = 57;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                    newposition = newposition + dice_value;
                    break;
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:

                    invalid_move = true;

                default:
                   ;
            }
        } else {
            newposition = newposition + dice_value;
        }

        if (invalid_move) {
            System.out.println("Invalid move for selected token.");
            return -1;
        }
        if (double_pos) {
            double_pos = false;
            double_pos_flag = true;
        }
        return 0;
    }
}



public class Player {
    
    int id;
    
    Token tk[];
    char symbol;
    boolean block;
    int blockedcell;
    String color;

    
    Player(int pid, char c, String clr)         
    {
        id = pid;
        symbol =c;
        color =clr;
        tk = new Token[4];
        for(int i =0; i<=3;i++)
          tk[i]= new Token(i+1,pid-1);   
    }
}

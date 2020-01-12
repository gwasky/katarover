package main;

/**
 * Created by Administrator on 1/12/20.
 */
public class Utilities {


    public boolean validateCommandSeq(String commands){
        boolean valid = false;
        if(commands.matches("[LRFB]+")) valid = true;
        return valid;
    }
}

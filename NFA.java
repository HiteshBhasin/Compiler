
import java.util.Stack;

public class NFA {


   private State start;
   private State accept;

    public NFA(State start, State accept) {
        this.start = start;
        this.accept = accept;
    }

    public void computingNFA(String regex){
        Stack<NFA> newChar = new Stack<>();

        char [] charArray = regex.toCharArray();
        for (char c: charArray) {
             if(Character.isAlphabetic(c)){
                start  = new State();
                accept =  new State();
                accept.isFinal =true;
                start.addTransition(c, accept);
                newChar.push(new NFA(start, accept));

             }
        }
       


    }
   



}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NFA {

    private class state{
        protected Map<Character, List<state>> transitionMap ;
        protected List<state> epsilonTransition ;

        public state() {
            transitionMap =   new HashMap<>();
            epsilonTransition = new ArrayList<>();
        }
        public boolean isFinal = false;
        public void addTransition(char symbol, state to){
            transitionMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(to);
        }

        public void addEpsilon(state to){
            epsilonTransition.add(to);
        }

    }

   private state start;
   private state accept;

    public NFA(state start, state accept) {
        this.start = start;
        this.accept = accept;
    }

    public void computingNFA(String regex){
        Stack<NFA> newChar = new Stack<>();

        char [] charArray = regex.toCharArray();
        for (char c: charArray) {
             if(Character.isAlphabetic(c)){
                start  = new state();
                accept =  new state();
                accept.isFinal =true;
                start.addTransition(c, accept);
                newChar.push(new NFA(start, accept));

             }
        }
       


    }
   



}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {
     protected Map<Character, List<State>> transitionMap ;
        protected List<State> epsilonTransition ;

        public State() {
            transitionMap =   new HashMap<>();
            epsilonTransition = new ArrayList<>();
        }
        public boolean isFinal = false;
        public void addTransition(char symbol, State to){
            transitionMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(to);
        }

        public void addEpsilon(State to){
            epsilonTransition.add(to);
        }
}

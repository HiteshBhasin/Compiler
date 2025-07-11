
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
                State alphaStartState  = new State();
                State alphaAcceptState =  new State();
                alphaAcceptState.isFinal =true;
                alphaStartState.addTransition(c, alphaAcceptState);
                newChar.push(new NFA(alphaStartState, alphaAcceptState));
            
             if (c=='*'){
                State starStartSate =  new State();
                State starAcceptState =  new State();

                starAcceptState.isFinal=true;
                starStartSate.addEpsilon(alphaStartState);//epsilon transition to start
                 starStartSate.addEpsilon(starAcceptState);//epsilon accept (for 0 repition) it goes strait to the accept state.

                alphaAcceptState.addEpsilon(alphaStartState); // loop back to the state q1 or q0
                alphaAcceptState.addEpsilon(starAcceptState); // this is the last state in NFA when like a->b->epsilon hence, nothing after b.
                newChar.push(new NFA(starStartSate, starAcceptState));
            
                /*
                 *       ┌──────────┐
                         ↓          │
                    [start] --ε--> [a] --a--> [b] --ε--> [a]
                    │                             │
                    └------------ε----------------┘
                              ↓
                         [accept]

                 * 
                 * 
                 * 
                 */
            
            }

             if (c=='|'){
                State unionStartState =  new State();// this is to create a new common start
                State unionAccepState =  new State();
                unionAccepState.isFinal = true;
                unionStartState.addEpsilon(alphaStartState);// we connect one common start
                alphaAcceptState.addEpsilon(unionAccepState);// connected the old accept to the new common accept.
                /*
                 * 
                 *          [start] -> common start
                            /     \
                         ε /       \ ε
                        [a]         [b]
                        /             \
                        ε             ε
                    [accept]         [accept]

                 * 
                 */
            }
             }

             }
        
       


    }
   



}
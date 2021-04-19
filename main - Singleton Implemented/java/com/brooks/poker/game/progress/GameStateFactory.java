/**
 * 
 */
package com.brooks.poker.game.progress;

import com.brooks.poker.game.data.GamePhase;
import com.brooks.poker.game.data.GameState;

/**
 * @author Trevor
 * 
 */
public class GameStateFactory{

    private BeginHandState beginHandState;
    private FirstBetState firstBetState;
    private FlopState flopState;
    private FlopBetState flopBetState;
    private TurnState turnState;
    private TurnBetState turnBetState;
    private RiverState riverState;
    private RiverBetState riverBetState;
    private EndHandState endHandState;

    public GameStateFactory(){
        beginHandState = new BeginHandState();
        firstBetState = new FirstBetState();
        flopState = new FlopState();
        flopBetState = new FlopBetState();
        turnState = new TurnState();
        turnBetState = new TurnBetState();
        riverState = new RiverState();
        riverBetState = new RiverBetState();
        endHandState = new EndHandState();
    }

    public GameProgressHandler getStateHandler(GamePhase cs){
        switch (cs) {
            case BEGIN_HAND:
                return beginHandState;
            case FIRST_BET:
                return firstBetState;
            case FLOP:
                return flopState;
            case FLOP_BET:
                return flopBetState;
            case TURN:
                return turnState;
            case TURN_BET:
                return turnBetState;
            case RIVER:
                return riverState;
            case RIVER_BET:
                return riverBetState;
            case END_HAND:
                return endHandState;
            case END_GAME:
                return NullHandState.NULL_HAND_STATE;
        }
        return NullHandState.NULL_HAND_STATE;
    }

}

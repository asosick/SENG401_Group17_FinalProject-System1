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
public class RiverBetState extends TurnBetState {
    public RiverBetState(){
        super();        
    }

    @Override
    public GamePhase getNextPhase(){
        return GamePhase.END_HAND;
    }
}

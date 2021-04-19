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
public class TurnBetState extends FlopBetState {

    public TurnBetState(){
        super();
       
    }

    @Override
    public GamePhase getNextPhase(){
        if(onePlayerInThePot())
            return GamePhase.END_HAND;
        
        return GamePhase.RIVER;
    }
}

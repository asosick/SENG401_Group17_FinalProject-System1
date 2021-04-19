/**
 * 
 */
package com.brooks.poker.game.progress;

import com.brooks.poker.game.GameActions;
import com.brooks.poker.game.data.GamePhase;
import com.brooks.poker.game.data.GameState;

/**
 * @author Trevor
 *
 */
public class FlopState extends GameProgressHandler {

    public FlopState(){
        super();        
    }

    @Override
    public void handleState(){
    	GameActions.burnCard(GameState.getGameStateInstance().getDeck());

    	GameActions.dealCommunityCard();
    	GameActions.dealCommunityCard();
    	GameActions.dealCommunityCard();       
    }

    @Override
    public GamePhase getNextPhase(){        
        return GamePhase.FLOP_BET;
    }

}

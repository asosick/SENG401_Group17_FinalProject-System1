package com.brooks.poker.game.progress;

import com.brooks.poker.game.data.GamePhase;
import com.brooks.poker.game.data.GameState;


/**
 * @author Trevor
 *
 */
public abstract class GameProgressHandler {

    protected GameState gameState;
    
    public GameProgressHandler(){
        this.gameState = GameState.getGameStateInstance();
    }
    
	public abstract void handleState();
	
	public abstract GamePhase getNextPhase();
	

}

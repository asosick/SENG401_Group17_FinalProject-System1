package com.brooks.poker.game.progress;

import com.brooks.poker.game.data.GamePhase;
import com.brooks.poker.game.data.GameState;

/**
 * @author Trevor
 * 
 */
public class NullHandState extends GameProgressHandler{

    public static final NullHandState NULL_HAND_STATE = new NullHandState();

    protected NullHandState(){
        super();
    }

    @Override
    public void handleState(){
    }

    @Override
    public GamePhase getNextPhase(){
        return GamePhase.END_GAME;
    }

}

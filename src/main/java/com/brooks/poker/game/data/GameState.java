package com.brooks.poker.game.data;

import java.util.List;

import com.brooks.poker.cards.Deck;
import com.brooks.poker.game.data.pot.Pots;
import com.brooks.poker.game.handler.GameStateHandler;
import com.brooks.poker.game.handler.GameStateHandlerCollection;
import com.brooks.poker.player.Player;

/**
 * @author Trevor
 */
public class GameState{
	
	private static GameState gameState = new GameState();
	private GameState(){}
	
	private GamePhase gamePhase = GamePhase.BEGIN_GAME;
    private BlindsAnte blindsAnte = BlindsAnte.NO_BLINDS_ANTE;
    private final Table table = new Table();
    private final Deck deck = new Deck();
    private final Pots pots = new Pots();
    private final CommunityCards communityCards = new CommunityCards();
    private final GameStateHandlerCollection gameStateHandlerCollection = new GameStateHandlerCollection(this);

    
//    private GameState(){
//    	this.blindsAnte = BlindsAnte.NO_BLINDS_ANTE;
//    	this.gamePhase = GamePhase.BEGIN_GAME;
//        this.table = new Table();
//        this.deck = new Deck();
//        this.pots = new Pots();
//        this.communityCards = new CommunityCards();
//        this.gameStateHandlerCollection = new GameStateHandlerCollection(this);
//    }
    
    public static GameState getGameStateInstance() {
    	return gameState;
    }

    public static GameState configureTournamentGameState(BlindsAnte blindsAnte, List<Player> players){
        GameState gameState = new GameState();
        gameState.blindsAnte = blindsAnte;

        for(Player player: players){
            gameState.getTable().joinTable(player);
        }
        
        return gameState;
    }
        
    public void addGameStateHandler(GameStateHandler handler){
    	gameStateHandlerCollection.add(handler);
    }

	public void invokeGameStateHandlerFor(GamePhase currentPhase) {
		gameStateHandlerCollection.handlePhase(currentPhase);
	}   
    
    public Table getTable(){
        return table;
    }
   
    public Pots getPots(){
        return pots;
    }

    public CommunityCards getCommunityCards(){
        return communityCards;
    }

    public Deck getDeck(){
    	return deck;
    }
    
	public BlindsAnte getBlindsAnte(){
        return blindsAnte;
    }
    
    public void setBlindsAnte(BlindsAnte blindsAnte) {
		this.blindsAnte = blindsAnte;
	}

    public GamePhase getGamePhase() {
        return gamePhase;
    }

    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }
}

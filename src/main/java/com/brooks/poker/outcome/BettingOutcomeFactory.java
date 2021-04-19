package com.brooks.poker.outcome;



/**
 * @author Trevor
 *
 */
 public class BettingOutcomeFactory{

 	private static final HashMap<String, BettingOutcome> outcomesMap = new HashMap<>();

     public static BettingOutcome createCallOutcome(){
     	String key = "call";

     	BettingOutcome outcome = outcomesMap.get(key);

     	if(outcome != null) {
     		return outcome;
     	}
     	else {
     		outcome = new CallOutcome();
     		outcomesMap.put(key, outcome);
     	}

     	return outcome;
     }

     public static BettingOutcome createFoldOutcome(){
     	String key = "fold";

     	BettingOutcome outcome = outcomesMap.get(key);

     	if(outcome != null) {
     		return outcome;
     	}
     	else {
     		outcome = new FoldOutcome();
     		outcomesMap.put(key, outcome);
     	}

     	return outcome;
     }

     public static BettingOutcome createRaiseOutcome(int fixedBet){
     	String key = "raise" + Integer.toString(fixedBet);

     	BettingOutcome outcome = outcomesMap.get(key);

     	if(outcome != null) {
     		return outcome;
     	}
     	else {
     		outcome = new RaiseOutcome(fixedBet);
     		outcomesMap.put(key, outcome);
     	}

     	return outcome;
     }

     public static BettingOutcome createBlindsOutcome(int fixedBet){
     	String key = "blind" + Integer.toString(fixedBet);

     	BettingOutcome outcome = outcomesMap.get(key);

     	if(outcome != null) {
     		return outcome;
     	}
     	else {
     		outcome = new BlindsOutcome(fixedBet);
     		outcomesMap.put(key, outcome);
     	}

     	return outcome;
     }
 }

package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.Optional;

public class Analysis implements Phase {

 @Override
    public void perform(Context context){
     for(Analyzer analyzer : context.getRover().getAnalyzers()){
         Optional<Outcome> analyzerOutcome = analyzer.analyze(context);
         analyzerOutcome.ifPresent(context :: setOutcome);
     }
 }
}

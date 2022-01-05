package code.Controllers;

import code.Models.ScoreFile;
import code.Views.GameFrame;
import code.Views.NameEntry;

public class NameEntryControl {

    private static final String noName = "They gave no name...";

    private final GameFrame myGameFrame;
    private final NameEntry myOwner;


    private final ScoreFile scoreFile;

    private String name;

    public NameEntryControl(GameFrame gameFrame, NameEntry nameEntry){
        myGameFrame = gameFrame;
        myOwner = nameEntry;
        scoreFile = gameFrame.getJfxPanelScoreView().getScoreList();
    }

    public void submitName(int score){
        name = String.valueOf(myOwner.getTextField().getText());
        if (name.equals("")){
            name = noName;
        }

        String nameAndScore = name + " " + score;

        scoreFile.writeScore(nameAndScore);
        scoreFile.setHighScores();
        myGameFrame.getJfxPanelScoreView().resetScreen();
        myGameFrame.getJfxPanelScoreView().drawScores();

        returnToMain();

    }

    public void returnToMain(){
        myGameFrame.getCardLayout().show(myGameFrame.getContentPane(),"fxMenu");
    }

}

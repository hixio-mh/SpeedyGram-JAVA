/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speedygram;
import java.awt.Color;
import java.awt.event.*;

/**
 *
 * @author lnewby
 */
public class GameTimer {
    public final static int DEFAULT_TIME_PER_SENTENCE = 1;
    public final static int MAX_SECONDS = 59;
    public int seconds = 0;
    public int minutes = 1;
    private Sentence[] sentence;
    private Player player;
    public javax.swing.Timer t;
    public String st = new String();
    public String time = new String();
    public javax.swing.JLabel timerLbl = new javax.swing.JLabel();
    public javax.swing.JButton continueBtn = new javax.swing.JButton();
    public javax.swing.JLabel scoreLbl = new javax.swing.JLabel();
    public javax.swing.JLabel largeBonusLbl = new javax.swing.JLabel();
    private javax.swing.JLabel wordLbl = new javax.swing.JLabel();
    private boolean bonusRound = false;
    private javax.swing.JLabel[] posPlaceHolders = new javax.swing.JLabel[17];
    private String[] partOfSpeech = new String[9];
    public String currentPOSOnScreen = new String();
    //public String currentWordPOSOnScreen = new String();
    public boolean currentBonusWordDone;
    private int randomPlaceHolder;
    private int randomPartOfSpeech;
    private int randomWord;
    private int randomSentence;
    private java.util.Random randomGenerator;
    public Word currentWordOnScreen;
    public int numOfWordsCompleted;


    public GameTimer(String[] pos, 
            javax.swing.JLabel[] p,
            javax.swing.JLabel b,
            Sentence[] s,
            javax.swing.JLabel w,
            boolean bw,
            Word cw){
        this.partOfSpeech = pos;
        this.bonusRound = true;
        this.posPlaceHolders = p;
        this.largeBonusLbl= b;
        this.sentence = s;
        this.wordLbl = w;
        this.currentWordOnScreen = cw;
        this.currentBonusWordDone = bw;
        this.numOfWordsCompleted = 0;
        //this.currentPOSOnScreen = cPOS;
        //this.currentWordPOSOnScreen = cwPOS;
        randomGenerator = new java.util.Random();
        // Create timer which calls action listener every second..
        t = new javax.swing.Timer(1000, new ClockListener());
        t.start();
    }

    public GameTimer(javax.swing.JLabel l, javax.swing.JButton b, javax.swing.JLabel sl, Player p) {
        // Store text label used for displaying the timer countdown
        this.bonusRound = false;
        this.timerLbl = l;
        this.continueBtn = b;
        this.scoreLbl = sl;
        this.timerLbl.setText(""+minutes+":0"+seconds);
        this.player = p;
        // Create timer which calls action listener every second..
        t = new javax.swing.Timer(1000, new ClockListener());
        t.start();
    }

    /////////////////////////////////////////////// inner class ClockListener
    class ClockListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
            if(bonusRound){
                if(largeBonusLbl.isVisible()){
                    pauseGame(2);
                    numOfWordsCompleted += 1;
                    randomSentence = randomGenerator.nextInt(sentence.length);
                    randomWord = randomGenerator.nextInt(sentence[randomSentence].word.length);
                    wordLbl.setText(sentence[randomSentence].word[randomWord].getWord());
                    largeBonusLbl.setVisible(false);
                    currentBonusWordDone = false;
                    currentWordOnScreen = sentence[randomSentence].word[randomWord];
                    //currentWordPOSOnScreen = sentence[randomSentence].word[randomWord].getPos();
                }
                for ( javax.swing.JLabel p : posPlaceHolders){
                    p.setVisible(false);
                }

                randomPartOfSpeech = randomGenerator.nextInt(partOfSpeech.length);
                randomPlaceHolder = randomGenerator.nextInt(posPlaceHolders.length);
                posPlaceHolders[randomPlaceHolder].setText(partOfSpeech[randomPartOfSpeech]);
                posPlaceHolders[randomPlaceHolder].setVisible(true);
                currentPOSOnScreen = partOfSpeech[randomPartOfSpeech];
                
            } else {
                if (seconds <= 0 && minutes <=0 ){
                    for (Sentence s : sentence){
                        if (s.sentenceLP.isVisible()){
                            s.gradeSentence(scoreLbl, player);
                            continueBtn.setVisible(true);
                            break;
                        }
                    }
                    t.stop();
                } else if (seconds <= 0){
                    seconds = 59;

                    minutes-=1;
                    timerLbl.setText((minutes<=0)? (""+seconds): (""+ minutes +":"+ seconds));
                } else {
                    seconds-=1;

                    st = (seconds<10) ? ("0"+seconds+"") : (""+seconds);
                    timerLbl.setText((minutes<=0) ? (""+st) : (""+ minutes +":"+ st));
                }

                // If sentence time + player bonus time is > 1 minute change text color to Green (You doing well >.<)
                // If sentence time is < 10 seconds change text color to Red (time is running out >.<)
                // else change to normal Gray
                if( minutes >=1) {
                    timerLbl.setForeground(Color.GREEN);
                } else if (seconds <= 10){
                    timerLbl.setForeground(Color.RED);
                } else
                    timerLbl.setForeground(Color.GRAY);
            }
            //System.out.println(currentPOSOnScreen +" "+currentWordPOSOnScreen+"\n");
    	}
    }

    // Call to pause the game for a give number of seconds
    public void pauseGame(int seconds){
        try
        {
            int millseconds = seconds * 1000;
            Thread.sleep(millseconds);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void setSentence(Sentence[] s){
        this.sentence = s;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BonusStage.java
 *
 * Created on Dec 14, 2009, 8:36:30 PM
 */

package speedygram;

import java.awt.*;
import java.awt.Color;
import java.awt.Font.*;
import java.awt.event.*;
import java.io.*;
import java.io.File.*;
import java.io.IOException.*;



/**
 *
 * @author lnewby
 */
public class BonusStage extends javax.swing.JFrame implements KeyListener {

    public BonusStage(){

    }
    /** Creates new form BonusStage */
    public BonusStage(Player p,
                      Sentence[] s) {

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/speedygram/fonts/dakota__.ttf").openStream()));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/speedygram/fonts/gillsansultrabold.ttf").openStream()));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/speedygram/fonts/gillsans.ttf").openStream()));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/speedygram/fonts/gillsansbold.ttf").openStream()));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/speedygram/fonts/lucidagrande.ttf").openStream()));
        } catch (IOException e) {
        } catch (FontFormatException ffe){
        }

        initComponents();
        setLocationRelativeTo(null);

        // Add Key Listener
        this.addKeyListener ( this ) ;
        this.setFocusable(true);
        player = p;
        sentence = s;
        bonusLbl.setText("0");
        scoreLbl.setText("Score: "+ player.score);
        bonusStageLP.setVisible(false);
        bonusIntroLP.setVisible(true);
        gameOverLP.setVisible(false);
        instructionLP.setVisible(false);
        partOfSpeech[0] = "article";
        partOfSpeech[1] = "adjective";
        partOfSpeech[2] = "adverb";
        partOfSpeech[3] = "verb";
        partOfSpeech[4] = "noun";
        partOfSpeech[5] = "pronoun";
        partOfSpeech[6] = "conjunction";
        partOfSpeech[7] = "preposition";
        partOfSpeech[8] = "interjection";
        // Store all place holders for part of speech
        posPlaceHolders[0] = posLbl;
        posPlaceHolders[1] = posLbl1;
        posPlaceHolders[2] = posLbl2;
        posPlaceHolders[3] = posLbl3;
        posPlaceHolders[4] = posLbl4;
        posPlaceHolders[5] = posLbl5;
        posPlaceHolders[6] = posLbl6;
        posPlaceHolders[7] = posLbl7;
        posPlaceHolders[8] = posLbl8;
        posPlaceHolders[9] = posLbl9;
        posPlaceHolders[10] = posLbl10;
        posPlaceHolders[11] = posLbl11;
        posPlaceHolders[12] = posLbl12;
        posPlaceHolders[13] = posLbl13;
        posPlaceHolders[14] = posLbl14;
        posPlaceHolders[15] = posLbl15;
        posPlaceHolders[16] = posLbl16;
        for (javax.swing.JLabel l : posPlaceHolders){
            l.setVisible(false);
        }
        randomPartOfSpeech = randomGenerator.nextInt(partOfSpeech.length);
        randomSentence = randomGenerator.nextInt(sentence.length);
        randomWord = randomGenerator.nextInt(sentence[randomSentence].word.length);
        wordLbl.setText(sentence[randomSentence].word[randomWord].getWord());
        posLbl.setText(partOfSpeech[randomPartOfSpeech]);
        posLbl.setVisible(true);
        currentBonusWordDone = false;
        currentPOSOnScreen = posLbl.getText();
        currentWordOnScreen = sentence[randomSentence].word[randomWord];

        largeBonusLbl.setFont(new java.awt.Font("Dakota", 1, 100));

        // Now time to listen for phidget
/*        try {
            ik = new InterfaceKitPhidget();
            ik.openAny();
            ik.waitForAttachment();
            
            ik.addSensorChangeListener(new SensorChangeListener()
            {
                public void sensorChanged(SensorChangeEvent se)
                {
                    //Insert your code here
                    if ( se.getValue()>200 && se.getValue()<400 && bonusStageLP.isVisible()){

                        //System.out.println(se.getValue());
                        if(bonusStageLP.isVisible()){

                                //System.out.println("pos: "+ gameTimer.currentPOSOnScreen +"  wPos: "+gameTimer.currentWordOnScreen.getPos()+"\n");
                                //System.out.println(gameTimer.currentWordOnScreen.getPos().equals(gameTimer.currentPOSOnScreen)+"\n");
                                //System.out.println("CBWD: "+gameTimer.currentBonusWordDone);
                               
                            if(!gameTimer.currentBonusWordDone) {
                                
                                
                                if ( gameTimer.currentWordOnScreen.getPos().equals(gameTimer.currentPOSOnScreen)){
                                    largeBonusLbl.setText("+100");
                                    largeBonusLbl.setForeground(Color.GREEN);
                                    player.updateBonus(100);
                                } else {
                                    largeBonusLbl.setText("-50");
                                    largeBonusLbl.setForeground(Color.RED);
                                    player.updateBonus(-50);
                                }
                                gameTimer.currentBonusWordDone = true;
                                bonusLbl.setText(""+ player.getBonus());
                                largeBonusLbl.setVisible(true);
                            }

                            if(gameTimer.numOfWordsCompleted>5){
                                gameTimer.pauseGame(2);
                                gameTimer.t.stop();
                                bonusStageLP.setVisible(false);
                                gameOverLP.setVisible(true);

                                // Close the InterfaceKit gracefully
                                try{
                                    ik.close();
                                    ik = null;
                                } catch (PhidgetException ex) {
                                    System.out.println(ex.getDescription() + " Phidget Error: " + ex.getErrorNumber());
                                }
                            }
                            

                        }

                    }
                }
            });
        } catch (PhidgetException ex) {
            System.out.println(ex.getDescription() + " Phidget Error: " + ex.getErrorNumber());
        }
 */
    }

    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        // Nothing to do :(
    }

    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 32){
            //System.out.println(se.getValue());
            if(bonusStageLP.isVisible()){

                if(!gameTimer.currentBonusWordDone) {


                    if ( gameTimer.currentWordOnScreen.getPos().equals(gameTimer.currentPOSOnScreen)){
                        largeBonusLbl.setText("+100");
                        largeBonusLbl.setForeground(Color.GREEN);
                        player.updateBonus(100);
                    } else {
                        largeBonusLbl.setText("-50");
                        largeBonusLbl.setForeground(Color.RED);
                        player.updateBonus(-50);
                    }
                    gameTimer.currentBonusWordDone = true;
                    bonusLbl.setText(""+ player.getBonus());
                    largeBonusLbl.setVisible(true);
                }

                if(gameTimer.numOfWordsCompleted>5){
                    gameTimer.pauseGame(2);
                    gameTimer.t.stop();
                    bonusStageLP.setVisible(false);
                    gameOverLP.setVisible(true);
                }
            }
        }
    }

    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        containerLP = new javax.swing.JLayeredPane();
        bonusStageLP = new javax.swing.JLayeredPane();
        posLbl = new javax.swing.JLabel();
        scoreLbl = new javax.swing.JLabel();
        bonusLbl = new javax.swing.JLabel();
        bonusTxt = new javax.swing.JLabel();
        posLbl1 = new javax.swing.JLabel();
        posLbl2 = new javax.swing.JLabel();
        posLbl3 = new javax.swing.JLabel();
        posLbl4 = new javax.swing.JLabel();
        posLbl5 = new javax.swing.JLabel();
        posLbl6 = new javax.swing.JLabel();
        posLbl7 = new javax.swing.JLabel();
        posLbl8 = new javax.swing.JLabel();
        posLbl9 = new javax.swing.JLabel();
        posLbl10 = new javax.swing.JLabel();
        posLbl11 = new javax.swing.JLabel();
        posLbl12 = new javax.swing.JLabel();
        posLbl13 = new javax.swing.JLabel();
        posLbl14 = new javax.swing.JLabel();
        posLbl15 = new javax.swing.JLabel();
        posLbl16 = new javax.swing.JLabel();
        largeBonusLbl = new javax.swing.JLabel();
        wordLbl = new javax.swing.JLabel();
        gameOverLP = new javax.swing.JLayeredPane();
        gameOverLbl = new javax.swing.JLabel();
        resultsBtn = new javax.swing.JButton();
        instructionLP = new javax.swing.JLayeredPane();
        SpeedLbl1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AttackLbl1 = new javax.swing.JLabel();
        bonusRoundLbl1 = new javax.swing.JLabel();
        letsPlayBtn1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bonusIntroLP = new javax.swing.JLayeredPane();
        SpeedLbl = new javax.swing.JLabel();
        AttackLbl = new javax.swing.JLabel();
        bonusRoundLbl = new javax.swing.JLabel();
        howToPlayBtn = new javax.swing.JButton();
        letsPlayBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(828, 568));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setSize(new java.awt.Dimension(828, 568));

        containerLP.setForeground(new java.awt.Color(255, 255, 255));

        posLbl.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl.setForeground(new java.awt.Color(0, 51, 255));
        posLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl.setText("preposition");
        posLbl.setBounds(510, 420, 270, 80);
        bonusStageLP.add(posLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        scoreLbl.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        scoreLbl.setForeground(new java.awt.Color(153, 153, 153));
        scoreLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLbl.setText("Score: 0");
        scoreLbl.setBounds(340, 0, 110, 30);
        bonusStageLP.add(scoreLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bonusLbl.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        bonusLbl.setForeground(new java.awt.Color(51, 153, 0));
        bonusLbl.setText("+100000000pts");
        bonusLbl.setBounds(620, 0, 160, 30);
        bonusStageLP.add(bonusLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bonusTxt.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        bonusTxt.setForeground(new java.awt.Color(153, 153, 153));
        bonusTxt.setText("Bonus:");
        bonusTxt.setBounds(560, 0, 50, 30);
        bonusStageLP.add(bonusTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl1.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl1.setForeground(new java.awt.Color(0, 51, 255));
        posLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl1.setText("preposition");
        posLbl1.setBounds(80, 90, 270, 80);
        bonusStageLP.add(posLbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl2.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl2.setForeground(new java.awt.Color(0, 51, 255));
        posLbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl2.setText("preposition");
        posLbl2.setBounds(300, 10, 270, 80);
        bonusStageLP.add(posLbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl3.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl3.setForeground(new java.awt.Color(0, 51, 255));
        posLbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl3.setText("preposition");
        posLbl3.setBounds(470, 120, 270, 80);
        bonusStageLP.add(posLbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl4.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl4.setForeground(new java.awt.Color(0, 51, 255));
        posLbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl4.setText("preposition");
        posLbl4.setBounds(370, 40, 270, 80);
        bonusStageLP.add(posLbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl5.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl5.setForeground(new java.awt.Color(0, 51, 255));
        posLbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl5.setText("preposition");
        posLbl5.setBounds(520, 190, 270, 80);
        bonusStageLP.add(posLbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl6.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl6.setForeground(new java.awt.Color(0, 51, 255));
        posLbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl6.setText("preposition");
        posLbl6.setBounds(530, 280, 270, 80);
        bonusStageLP.add(posLbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl7.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl7.setForeground(new java.awt.Color(0, 51, 255));
        posLbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl7.setText("preposition");
        posLbl7.setBounds(260, 290, 270, 80);
        bonusStageLP.add(posLbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl8.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl8.setForeground(new java.awt.Color(0, 51, 255));
        posLbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl8.setText("preposition");
        posLbl8.setBounds(400, 350, 270, 80);
        bonusStageLP.add(posLbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl9.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl9.setForeground(new java.awt.Color(0, 51, 255));
        posLbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl9.setText("preposition");
        posLbl9.setBounds(140, 360, 270, 80);
        bonusStageLP.add(posLbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl10.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl10.setForeground(new java.awt.Color(0, 51, 255));
        posLbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl10.setText("preposition");
        posLbl10.setBounds(0, 260, 270, 80);
        bonusStageLP.add(posLbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl11.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl11.setForeground(new java.awt.Color(0, 51, 255));
        posLbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl11.setText("preposition");
        posLbl11.setBounds(250, 430, 270, 80);
        bonusStageLP.add(posLbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl12.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl12.setForeground(new java.awt.Color(0, 51, 255));
        posLbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl12.setText("preposition");
        posLbl12.setBounds(50, 180, 270, 80);
        bonusStageLP.add(posLbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl13.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl13.setForeground(new java.awt.Color(0, 51, 255));
        posLbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl13.setText("preposition");
        posLbl13.setBounds(240, 120, 270, 80);
        bonusStageLP.add(posLbl13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl14.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl14.setForeground(new java.awt.Color(0, 51, 255));
        posLbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl14.setText("preposition");
        posLbl14.setBounds(20, 20, 270, 80);
        bonusStageLP.add(posLbl14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl15.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl15.setForeground(new java.awt.Color(0, 51, 255));
        posLbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl15.setText("preposition");
        posLbl15.setBounds(510, 60, 270, 80);
        bonusStageLP.add(posLbl15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        posLbl16.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        posLbl16.setForeground(new java.awt.Color(0, 51, 255));
        posLbl16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLbl16.setText("preposition");
        posLbl16.setBounds(10, 410, 270, 80);
        bonusStageLP.add(posLbl16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        largeBonusLbl.setFont(new java.awt.Font("Handwriting - Dakota", 1, 100)); // NOI18N
        largeBonusLbl.setForeground(new java.awt.Color(204, 204, 204));
        largeBonusLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        largeBonusLbl.setText("+100");
        largeBonusLbl.setBounds(210, 170, 360, 150);
        bonusStageLP.add(largeBonusLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        wordLbl.setFont(new java.awt.Font("Gill Sans MT", 1, 50)); // NOI18N
        wordLbl.setForeground(new java.awt.Color(255, 255, 255));
        wordLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wordLbl.setText("random word");
        wordLbl.setBounds(30, 190, 730, 140);
        bonusStageLP.add(wordLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bonusStageLP.setBounds(0, 0, 790, 530);
        containerLP.add(bonusStageLP, javax.swing.JLayeredPane.DEFAULT_LAYER);

        gameOverLP.setDoubleBuffered(true);

        gameOverLbl.setFont(new java.awt.Font("Gill Sans MT", 1, 70)); // NOI18N
        gameOverLbl.setForeground(new java.awt.Color(255, 255, 255));
        gameOverLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameOverLbl.setText("And That's the Game");
        gameOverLbl.setBounds(0, 140, 790, 110);
        gameOverLP.add(gameOverLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        resultsBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        resultsBtn.setForeground(new java.awt.Color(51, 51, 51));
        resultsBtn.setText("How'd you do?");
        resultsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsBtnActionPerformed(evt);
            }
        });
        resultsBtn.setBounds(180, 330, 440, 70);
        gameOverLP.add(resultsBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        gameOverLP.setBounds(0, 0, 790, 530);
        containerLP.add(gameOverLP, javax.swing.JLayeredPane.DEFAULT_LAYER);

        instructionLP.setDoubleBuffered(true);

        SpeedLbl1.setFont(new java.awt.Font("Gill Sans Bold", 1, 90)); // NOI18N
        SpeedLbl1.setForeground(new java.awt.Color(0, 51, 153));
        SpeedLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SpeedLbl1.setText("Speed");
        SpeedLbl1.setBounds(150, 40, 490, 110);
        instructionLP.add(SpeedLbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Gill Sans Bold", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("It's");
        jLabel3.setBounds(140, 220, 90, 60);
        instructionLP.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Gill Sans Bold", 1, 55)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Easy!");
        jLabel2.setBounds(160, 230, 180, 90);
        instructionLP.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        AttackLbl1.setFont(new java.awt.Font("Gill Sans Bold", 1, 90)); // NOI18N
        AttackLbl1.setForeground(new java.awt.Color(0, 51, 204));
        AttackLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AttackLbl1.setText("Attack!");
        AttackLbl1.setBounds(150, 90, 510, 170);
        instructionLP.add(AttackLbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bonusRoundLbl1.setFont(new java.awt.Font("Lucida Grande", 1, 28)); // NOI18N
        bonusRoundLbl1.setForeground(new java.awt.Color(204, 204, 204));
        bonusRoundLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bonusRoundLbl1.setText("BONUS ROUND");
        bonusRoundLbl1.setBounds(250, 200, 310, 50);
        instructionLP.add(bonusRoundLbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        letsPlayBtn1.setText("Let's Play");
        letsPlayBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letsPlayBtn1ActionPerformed(evt);
            }
        });
        letsPlayBtn1.setBounds(350, 470, 120, 29);
        instructionLP.add(letsPlayBtn1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("* Each Wrong Answer = -50pts");
        jLabel4.setBounds(290, 410, 330, 16);
        instructionLP.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("* One (1) word will be on screen");
        jLabel5.setBounds(290, 310, 230, 16);
        instructionLP.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("* One part-of-speech will randomly show on screen");
        jLabel6.setBounds(290, 330, 350, 16);
        instructionLP.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("* When you see a matching (word::part-of-speech)");
        jLabel7.setBounds(290, 350, 340, 16);
        instructionLP.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("   pair on screen press your Space Bar to buzz in!");
        jLabel8.setBounds(290, 370, 350, 16);
        instructionLP.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("* Right Anwers = +100pts");
        jLabel9.setBounds(290, 390, 330, 16);
        instructionLP.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel1.setBounds(170, 260, 470, 190);
        instructionLP.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        instructionLP.setBounds(0, 0, 790, 530);
        containerLP.add(instructionLP, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bonusIntroLP.setDoubleBuffered(true);

        SpeedLbl.setFont(new java.awt.Font("Gill Sans Bold", 1, 90)); // NOI18N
        SpeedLbl.setForeground(new java.awt.Color(0, 51, 153));
        SpeedLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SpeedLbl.setText("Speed");
        SpeedLbl.setBounds(150, 110, 490, 110);
        bonusIntroLP.add(SpeedLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        AttackLbl.setFont(new java.awt.Font("Gill Sans Bold", 1, 90)); // NOI18N
        AttackLbl.setForeground(new java.awt.Color(0, 51, 204));
        AttackLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AttackLbl.setText("Attack!");
        AttackLbl.setBounds(150, 160, 510, 170);
        bonusIntroLP.add(AttackLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bonusRoundLbl.setFont(new java.awt.Font("Lucida Grande", 1, 28));
        bonusRoundLbl.setForeground(new java.awt.Color(204, 204, 204));
        bonusRoundLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bonusRoundLbl.setText("BONUS ROUND");
        bonusRoundLbl.setBounds(250, 270, 310, 50);
        bonusIntroLP.add(bonusRoundLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        howToPlayBtn.setText("How to Play");
        howToPlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToPlayBtnActionPerformed(evt);
            }
        });
        howToPlayBtn.setBounds(270, 360, 120, 29);
        bonusIntroLP.add(howToPlayBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        letsPlayBtn.setText("Let's Play");
        letsPlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letsPlayBtnActionPerformed(evt);
            }
        });
        letsPlayBtn.setBounds(410, 360, 120, 29);
        bonusIntroLP.add(letsPlayBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bonusIntroLP, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(containerLP, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bonusIntroLP, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(containerLP, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void letsPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letsPlayBtnActionPerformed
        // TODO add your handling code here:
        largeBonusLbl.setVisible(false);
        bonusIntroLP.setVisible(false);
        bonusStageLP.setVisible(true);
        gameTimer = new GameTimer(partOfSpeech, posPlaceHolders, largeBonusLbl, sentence, wordLbl, currentBonusWordDone, currentWordOnScreen );
    }//GEN-LAST:event_letsPlayBtnActionPerformed

    private void resultsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsBtnActionPerformed
        // TODO add your handling code here:
        Results myResults = new Results(this.player, this.sentence);
        //myResults.setLocationRelativeTo(null);
        myResults.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_resultsBtnActionPerformed

    private void letsPlayBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letsPlayBtn1ActionPerformed
        // TODO add your handling code here:
        largeBonusLbl.setVisible(false);
        bonusIntroLP.setVisible(false);
        instructionLP.setVisible(false);
        bonusStageLP.setVisible(true);
        gameTimer = new GameTimer(partOfSpeech, posPlaceHolders, largeBonusLbl, sentence, wordLbl, currentBonusWordDone, currentWordOnScreen );
    }//GEN-LAST:event_letsPlayBtn1ActionPerformed

    private void howToPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToPlayBtnActionPerformed
        // TODO add your handling code here:
        bonusIntroLP.setVisible(false);
        instructionLP.setVisible(true);
    }//GEN-LAST:event_howToPlayBtnActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BonusStage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AttackLbl;
    private javax.swing.JLabel AttackLbl1;
    private javax.swing.JLabel SpeedLbl;
    private javax.swing.JLabel SpeedLbl1;
    private javax.swing.JLayeredPane bonusIntroLP;
    private javax.swing.JLabel bonusLbl;
    private javax.swing.JLabel bonusRoundLbl;
    private javax.swing.JLabel bonusRoundLbl1;
    private javax.swing.JLayeredPane bonusStageLP;
    private javax.swing.JLabel bonusTxt;
    private javax.swing.JLayeredPane containerLP;
    private javax.swing.JLayeredPane gameOverLP;
    private javax.swing.JLabel gameOverLbl;
    private javax.swing.JButton howToPlayBtn;
    private javax.swing.JLayeredPane instructionLP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel largeBonusLbl;
    private javax.swing.JButton letsPlayBtn;
    private javax.swing.JButton letsPlayBtn1;
    private javax.swing.JLabel posLbl;
    private javax.swing.JLabel posLbl1;
    private javax.swing.JLabel posLbl10;
    private javax.swing.JLabel posLbl11;
    private javax.swing.JLabel posLbl12;
    private javax.swing.JLabel posLbl13;
    private javax.swing.JLabel posLbl14;
    private javax.swing.JLabel posLbl15;
    private javax.swing.JLabel posLbl16;
    private javax.swing.JLabel posLbl2;
    private javax.swing.JLabel posLbl3;
    private javax.swing.JLabel posLbl4;
    private javax.swing.JLabel posLbl5;
    private javax.swing.JLabel posLbl6;
    private javax.swing.JLabel posLbl7;
    private javax.swing.JLabel posLbl8;
    private javax.swing.JLabel posLbl9;
    private javax.swing.JButton resultsBtn;
    private javax.swing.JLabel scoreLbl;
    private javax.swing.JLabel wordLbl;
    // End of variables declaration//GEN-END:variables

    private Player player;
    private Sentence[] sentence = new Sentence [4];
    private String[] partOfSpeech = new String[9];
    private int randomPartOfSpeech;
    private int randomSentence;
    private int randomWord;
    private java.util.Random randomGenerator = new java.util.Random();
    private GameTimer gameTimer;
    private javax.swing.JLabel[] posPlaceHolders = new javax.swing.JLabel[17];
    private boolean currentBonusWordDone;
    private Word currentWordOnScreen;
    private String currentPOSOnScreen;

}

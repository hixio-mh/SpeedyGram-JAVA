/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * gameBoard.java
 *
 * Created on Dec 9, 2009, 2:48:54 PM
 */

package speedygram;

import java.awt.*;
import java.awt.Font.*;
import java.io.*;
import java.io.File.*;
import java.io.IOException.*;
//import bsh.EvalError;
//import java.util.Vector;
//import bsh.Interpreter;
/**
 *
 * @author lnewby
 */
public class gameBoard extends javax.swing.JFrame {

    /** Creates new form gameBoard */
    public gameBoard(){
        //initComponents();
    }
    public gameBoard(String playerName,
                     Level playerLevel,
                     String playerReadingLevel,
                     char gender,
                     String race,
                     boolean spEd,
                     boolean esl,
                     boolean reduceLunch) {
/*
        word.add(new javax.swing.JLabel("God is Good. Life is Good!", javax.swing.SwingConstants.CENTER));
        word.get(0).setPreferredSize(new java.awt.Dimension(100, 16));
        word.get(0).setForeground(Color.BLACK);
        System.out.println(word.get(0).getText());
        //getContentPane().add(myProfile.word.get(0), java.awt.BorderLayout.CENTER);
        add(word.get(0), java.awt.BorderLayout.CENTER);
*/
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
        // Create New Player
        player = new Player(playerName,
                            playerLevel,
                            playerReadingLevel,
                            gender,
                            race,
                            spEd,
                            esl,
                            reduceLunch);

        gameTimer = new GameTimer(timerLbl, continueBtn, scoreLbl, player);
        // Hide all Level sentences
        sentence1Elementary.setVisible(false);
        sentence2Elementary.setVisible(false);
        sentence3Elementary.setVisible(false);
        sentence4Elementary.setVisible(false);
        sentence5Middle.setVisible(false);
        sentence6Middle.setVisible(false);
        sentence7Middle.setVisible(false);
        sentence8Middle.setVisible(false);
        sentence9High.setVisible(false);
        sentence10High.setVisible(false);
        sentence11High.setVisible(false);
        sentence12High.setVisible(false);
        continueBtn.setVisible(false);
        waitingLbl.setVisible(false);

        switch (player.gradeLevel){
            case ELEMENTARY:
                
                //w1Lbl1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 1, true));
                //w1Lbl1.setForeground(new java.awt.Color(51, 0, 255));


                // Create School Levels, Store sentences & word

                Elementary.sentence = new Sentence[4];
                Elementary.sentence[0] = new Sentence("The man sat on the bench and read the interesting book.",
                                                   "article noun verb preposition article noun conjunction verb article adjective noun");
                Elementary.sentence[1] = new Sentence("Melissa and Sheila went to the beach and swam in the ocean.",
                                                   "noun conjunction noun verb preposition article noun conjunction verb preposition article noun");
                Elementary.sentence[2] = new Sentence("Dragon ran into his house and hid under the bed.",
                                                   "noun verb preposition pronoun noun conjunction verb preposition article noun");
                Elementary.sentence[3] = new Sentence("The fox and the crocodile stopped laughing.",
                                                   "article noun conjunction article noun verb verb");
                /*for (Sentence s: Elementary.sentence){
                    System.out.println(s.text);
                    for (Word w: s.word)
                        System.out.println(w.text);
                }*/

                Elementary.sentence[0].sentenceLP = sentence1Elementary;
                Elementary.sentence[1].sentenceLP = sentence2Elementary;
                Elementary.sentence[2].sentenceLP = sentence3Elementary;
                Elementary.sentence[3].sentenceLP = sentence4Elementary;
                Elementary.sentence[0].word[0].wordLbl = w1Lbl1;
                Elementary.sentence[0].word[1].wordLbl = w2Lbl1;
                Elementary.sentence[0].word[2].wordLbl = w3Lbl1;
                Elementary.sentence[0].word[3].wordLbl = w4Lbl1;
                Elementary.sentence[0].word[4].wordLbl = w5Lbl1;
                Elementary.sentence[0].word[5].wordLbl = w6Lbl1;
                Elementary.sentence[0].word[6].wordLbl = w7Lbl1;
                Elementary.sentence[0].word[7].wordLbl = w8Lbl1;
                Elementary.sentence[0].word[8].wordLbl = w9Lbl1;
                Elementary.sentence[0].word[9].wordLbl = w10Lbl1;
                Elementary.sentence[0].word[10].wordLbl = w11Lbl1;
                Elementary.sentence[1].word[0].wordLbl = w1Lbl2;
                Elementary.sentence[1].word[1].wordLbl = w2Lbl2;
                Elementary.sentence[1].word[2].wordLbl = w3Lbl2;
                Elementary.sentence[1].word[3].wordLbl = w4Lbl2;
                Elementary.sentence[1].word[4].wordLbl = w5Lbl2;
                Elementary.sentence[1].word[5].wordLbl = w6Lbl2;
                Elementary.sentence[1].word[6].wordLbl = w7Lbl2;
                Elementary.sentence[1].word[7].wordLbl = w8Lbl2;
                Elementary.sentence[1].word[8].wordLbl = w9Lbl2;
                Elementary.sentence[1].word[9].wordLbl = w10Lbl2;
                Elementary.sentence[1].word[10].wordLbl = w11Lbl2;
                Elementary.sentence[1].word[11].wordLbl = w12Lbl2;
                Elementary.sentence[2].word[0].wordLbl = w1Lbl3;
                Elementary.sentence[2].word[1].wordLbl = w2Lbl3;
                Elementary.sentence[2].word[2].wordLbl = w3Lbl3;
                Elementary.sentence[2].word[3].wordLbl = w4Lbl3;
                Elementary.sentence[2].word[4].wordLbl = w5Lbl3;
                Elementary.sentence[2].word[5].wordLbl = w6Lbl3;
                Elementary.sentence[2].word[6].wordLbl = w7Lbl3;
                Elementary.sentence[2].word[7].wordLbl = w8Lbl3;
                Elementary.sentence[2].word[8].wordLbl = w9Lbl3;
                Elementary.sentence[2].word[9].wordLbl = w10Lbl3;
                Elementary.sentence[3].word[0].wordLbl = w1Lbl4;
                Elementary.sentence[3].word[1].wordLbl = w2Lbl4;
                Elementary.sentence[3].word[2].wordLbl = w3Lbl4;
                Elementary.sentence[3].word[3].wordLbl = w4Lbl4;
                Elementary.sentence[3].word[4].wordLbl = w5Lbl4;
                Elementary.sentence[3].word[5].wordLbl = w6Lbl4;
                Elementary.sentence[3].word[6].wordLbl = w7Lbl4;
                //Pointer to a Answer POS label to display the players choice
                Elementary.sentence[0].word[0].posLbl = w1pos1;
                Elementary.sentence[0].word[1].posLbl = w2pos1;
                Elementary.sentence[0].word[2].posLbl = w3pos1;
                Elementary.sentence[0].word[3].posLbl = w4pos1;
                Elementary.sentence[0].word[4].posLbl = w5pos1;
                Elementary.sentence[0].word[5].posLbl = w6pos1;
                Elementary.sentence[0].word[6].posLbl = w7pos1;
                Elementary.sentence[0].word[7].posLbl = w8pos1;
                Elementary.sentence[0].word[8].posLbl = w9pos1;
                Elementary.sentence[0].word[9].posLbl = w10pos1;
                Elementary.sentence[0].word[10].posLbl = w11pos1;
                Elementary.sentence[1].word[0].posLbl = w1pos2;
                Elementary.sentence[1].word[1].posLbl = w2pos2;
                Elementary.sentence[1].word[2].posLbl = w3pos2;
                Elementary.sentence[1].word[3].posLbl = w4pos2;
                Elementary.sentence[1].word[4].posLbl = w5pos2;
                Elementary.sentence[1].word[5].posLbl = w6pos2;
                Elementary.sentence[1].word[6].posLbl = w7pos2;
                Elementary.sentence[1].word[7].posLbl = w8pos2;
                Elementary.sentence[1].word[8].posLbl = w9pos2;
                Elementary.sentence[1].word[9].posLbl = w10pos2;
                Elementary.sentence[1].word[10].posLbl = w11pos2;
                Elementary.sentence[1].word[11].posLbl = w12pos2;
                Elementary.sentence[2].word[0].posLbl = w1pos3;
                Elementary.sentence[2].word[1].posLbl = w2pos3;
                Elementary.sentence[2].word[2].posLbl = w3pos3;
                Elementary.sentence[2].word[3].posLbl = w4pos3;
                Elementary.sentence[2].word[4].posLbl = w5pos3;
                Elementary.sentence[2].word[5].posLbl = w6pos3;
                Elementary.sentence[2].word[6].posLbl = w7pos3;
                Elementary.sentence[2].word[7].posLbl = w8pos3;
                Elementary.sentence[2].word[8].posLbl = w9pos3;
                Elementary.sentence[2].word[9].posLbl = w10pos3;
                Elementary.sentence[3].word[0].posLbl = w1pos4;
                Elementary.sentence[3].word[1].posLbl = w2pos4;
                Elementary.sentence[3].word[2].posLbl = w3pos4;
                Elementary.sentence[3].word[3].posLbl = w4pos4;
                Elementary.sentence[3].word[4].posLbl = w5pos4;
                Elementary.sentence[3].word[5].posLbl = w6pos4;
                Elementary.sentence[3].word[6].posLbl = w7pos4;
                //sentence1Elementary.setVisible(true);
                Elementary.sentence[currentSentence].sentenceLP.setVisible(true);
                Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);

                gameTimer.setSentence(Elementary.sentence);

                break;

            case MIDDLE:
                // Create School Levels, Store sentences & word
                Middle.sentence = new Sentence[4];
                Middle.sentence[0] = new Sentence("Harry and I crept to Sam's knees, in the glow of the bright evening firelight.",
                                                  "noun conjunction pronoun verb preposition noun noun preposition article noun preposition article adjective noun noun");
                Middle.sentence[1] = new Sentence("In those days we had no magazines and daily papers, each reeling off a serial story.",
                                                  "preposition adjective noun pronoun verb adjective noun conjunction adjective noun pronoun verb adverb article adjective noun");
                Middle.sentence[2] = new Sentence("The Columbian Sentinel came from Boston with its slender stock of news.",
                                                  "article noun noun verb preposition noun preposition pronoun adjective noun preposition noun");
                Middle.sentence[3] = new Sentence("Society then was full of traditions and narratives which had all the uncertain glow of the fire-lit hearth.",
                                                  "noun adverb verb adjective preposition noun conjunction noun pronoun verb pronoun article adjective noun preposition article adjective noun");

                Middle.sentence[0].sentenceLP = sentence5Middle;
                Middle.sentence[1].sentenceLP = sentence6Middle;
                Middle.sentence[2].sentenceLP = sentence7Middle;
                Middle.sentence[3].sentenceLP = sentence8Middle;
                Middle.sentence[0].word[0].wordLbl = w1Lbl5;
                Middle.sentence[0].word[1].wordLbl = w2Lbl5;
                Middle.sentence[0].word[2].wordLbl = w3Lbl5;
                Middle.sentence[0].word[3].wordLbl = w4Lbl5;
                Middle.sentence[0].word[4].wordLbl = w5Lbl5;
                Middle.sentence[0].word[5].wordLbl = w6Lbl5;
                Middle.sentence[0].word[6].wordLbl = w7Lbl5;
                Middle.sentence[0].word[7].wordLbl = w8Lbl5;
                Middle.sentence[0].word[8].wordLbl = w9Lbl5;
                Middle.sentence[0].word[9].wordLbl = w10Lbl5;
                Middle.sentence[0].word[10].wordLbl = w11Lbl5;
                Middle.sentence[0].word[11].wordLbl = w12Lbl5;
                Middle.sentence[0].word[12].wordLbl = w13Lbl5;
                Middle.sentence[0].word[13].wordLbl = w14Lbl5;
                Middle.sentence[0].word[14].wordLbl = w15Lbl5;

                Middle.sentence[1].word[0].wordLbl = w1Lbl6;
                Middle.sentence[1].word[1].wordLbl = w2Lbl6;
                Middle.sentence[1].word[2].wordLbl = w3Lbl6;
                Middle.sentence[1].word[3].wordLbl = w4Lbl6;
                Middle.sentence[1].word[4].wordLbl = w5Lbl6;
                Middle.sentence[1].word[5].wordLbl = w6Lbl6;
                Middle.sentence[1].word[6].wordLbl = w7Lbl6;
                Middle.sentence[1].word[7].wordLbl = w8Lbl6;
                Middle.sentence[1].word[8].wordLbl = w9Lbl6;
                Middle.sentence[1].word[9].wordLbl = w10Lbl6;
                Middle.sentence[1].word[10].wordLbl = w11Lbl6;
                Middle.sentence[1].word[11].wordLbl = w12Lbl6;
                Middle.sentence[1].word[12].wordLbl = w13Lbl6;
                Middle.sentence[1].word[13].wordLbl = w14Lbl6;
                Middle.sentence[1].word[14].wordLbl = w15Lbl6;
                Middle.sentence[1].word[15].wordLbl = w16Lbl6;

                Middle.sentence[2].word[0].wordLbl = w1Lbl7;
                Middle.sentence[2].word[1].wordLbl = w2Lbl7;
                Middle.sentence[2].word[2].wordLbl = w3Lbl7;
                Middle.sentence[2].word[3].wordLbl = w4Lbl7;
                Middle.sentence[2].word[4].wordLbl = w5Lbl7;
                Middle.sentence[2].word[5].wordLbl = w6Lbl7;
                Middle.sentence[2].word[6].wordLbl = w7Lbl7;
                Middle.sentence[2].word[7].wordLbl = w8Lbl7;
                Middle.sentence[2].word[8].wordLbl = w9Lbl7;
                Middle.sentence[2].word[9].wordLbl = w10Lbl7;
                Middle.sentence[2].word[10].wordLbl = w11Lbl7;
                Middle.sentence[2].word[11].wordLbl = w12Lbl7;

                Middle.sentence[3].word[0].wordLbl = w1Lbl8;
                Middle.sentence[3].word[1].wordLbl = w2Lbl8;
                Middle.sentence[3].word[2].wordLbl = w3Lbl8;
                Middle.sentence[3].word[3].wordLbl = w4Lbl8;
                Middle.sentence[3].word[4].wordLbl = w5Lbl8;
                Middle.sentence[3].word[5].wordLbl = w6Lbl8;
                Middle.sentence[3].word[6].wordLbl = w7Lbl8;
                Middle.sentence[3].word[7].wordLbl = w8Lbl8;
                Middle.sentence[3].word[8].wordLbl = w9Lbl8;
                Middle.sentence[3].word[9].wordLbl = w10Lbl8;
                Middle.sentence[3].word[10].wordLbl = w11Lbl8;
                Middle.sentence[3].word[11].wordLbl = w12Lbl8;
                Middle.sentence[3].word[12].wordLbl = w13Lbl8;
                Middle.sentence[3].word[13].wordLbl = w14Lbl8;
                Middle.sentence[3].word[14].wordLbl = w15Lbl8;
                Middle.sentence[3].word[15].wordLbl = w16Lbl8;
                Middle.sentence[3].word[16].wordLbl = w17Lbl8;
                Middle.sentence[3].word[17].wordLbl = w18Lbl8;

                //Pointer to a Answer POS label to display the players choice
                Middle.sentence[0].word[0].posLbl = w1pos5;
                Middle.sentence[0].word[1].posLbl = w2pos5;
                Middle.sentence[0].word[2].posLbl = w3pos5;
                Middle.sentence[0].word[3].posLbl = w4pos5;
                Middle.sentence[0].word[4].posLbl = w5pos5;
                Middle.sentence[0].word[5].posLbl = w6pos5;
                Middle.sentence[0].word[6].posLbl = w7pos5;
                Middle.sentence[0].word[7].posLbl = w8pos5;
                Middle.sentence[0].word[8].posLbl = w9pos5;
                Middle.sentence[0].word[9].posLbl = w10pos5;
                Middle.sentence[0].word[10].posLbl = w11pos5;
                Middle.sentence[0].word[11].posLbl = w12pos5;
                Middle.sentence[0].word[12].posLbl = w13pos5;
                Middle.sentence[0].word[13].posLbl = w14pos5;
                Middle.sentence[0].word[14].posLbl = w15pos5;

                Middle.sentence[1].word[0].posLbl = w1pos6;
                Middle.sentence[1].word[1].posLbl = w2pos6;
                Middle.sentence[1].word[2].posLbl = w3pos6;
                Middle.sentence[1].word[3].posLbl = w4pos6;
                Middle.sentence[1].word[4].posLbl = w5pos6;
                Middle.sentence[1].word[5].posLbl = w6pos6;
                Middle.sentence[1].word[6].posLbl = w7pos6;
                Middle.sentence[1].word[7].posLbl = w8pos6;
                Middle.sentence[1].word[8].posLbl = w9pos6;
                Middle.sentence[1].word[9].posLbl = w10pos6;
                Middle.sentence[1].word[10].posLbl = w11pos6;
                Middle.sentence[1].word[11].posLbl = w12pos6;
                Middle.sentence[1].word[12].posLbl = w13pos6;
                Middle.sentence[1].word[13].posLbl = w14pos6;
                Middle.sentence[1].word[14].posLbl = w15pos6;
                Middle.sentence[1].word[15].posLbl = w16pos6;

                Middle.sentence[2].word[0].posLbl = w1pos7;
                Middle.sentence[2].word[1].posLbl = w2pos7;
                Middle.sentence[2].word[2].posLbl = w3pos7;
                Middle.sentence[2].word[3].posLbl = w4pos7;
                Middle.sentence[2].word[4].posLbl = w5pos7;
                Middle.sentence[2].word[5].posLbl = w6pos7;
                Middle.sentence[2].word[6].posLbl = w7pos7;
                Middle.sentence[2].word[7].posLbl = w8pos7;
                Middle.sentence[2].word[8].posLbl = w9pos7;
                Middle.sentence[2].word[9].posLbl = w10pos7;
                Middle.sentence[2].word[10].posLbl = w11pos7;
                Middle.sentence[2].word[11].posLbl = w12pos7;

                Middle.sentence[3].word[0].posLbl = w1pos8;
                Middle.sentence[3].word[1].posLbl = w2pos8;
                Middle.sentence[3].word[2].posLbl = w3pos8;
                Middle.sentence[3].word[3].posLbl = w4pos8;
                Middle.sentence[3].word[4].posLbl = w5pos8;
                Middle.sentence[3].word[5].posLbl = w6pos8;
                Middle.sentence[3].word[6].posLbl = w7pos8;
                Middle.sentence[3].word[7].posLbl = w8pos8;
                Middle.sentence[3].word[8].posLbl = w9pos8;
                Middle.sentence[3].word[9].posLbl = w10pos8;
                Middle.sentence[3].word[10].posLbl = w11pos8;
                Middle.sentence[3].word[11].posLbl = w12pos8;
                Middle.sentence[3].word[12].posLbl = w13pos8;
                Middle.sentence[3].word[13].posLbl = w14pos8;
                Middle.sentence[3].word[14].posLbl = w15pos8;
                Middle.sentence[3].word[15].posLbl = w16pos8;
                Middle.sentence[3].word[16].posLbl = w17pos8;
                Middle.sentence[3].word[17].posLbl = w18pos8;
                //sentence1Elementary.setVisible(true);
                Middle.sentence[currentSentence].sentenceLP.setVisible(true);
                Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);

                gameTimer.setSentence(Middle.sentence);

                break;

            case HIGH:
                High.sentence = new Sentence[4];
                High.sentence[0] = new Sentence("This trouble pleased her, and later she made use of it as an intrinsic part of her atmosphere.",
                                                  "adjective noun verb noun conjunction adverb pronoun verb verb preposition pronoun preposition article adjective noun preposition pronoun noun");
                High.sentence[1] = new Sentence("Frank, a bell-boy in Waldorf, was outgrowing a natural repugnance to chamber music and symphonies.",
                                                  "noun article noun preposition noun verb verb article adjective noun preposition noun noun conjunction noun");
                High.sentence[2] = new Sentence("At age eleven he could talk glibly, if rather reminiscently, of Brahms and Mozart and Beethoven.",
                                                  "preposition noun noun pronoun verb verb adjective conjunction adverb adverb preposition noun conjunction noun conjunction noun");
                High.sentence[3] = new Sentence("This was fun for a while, but he essayed a cigarette in his exaltation, and succumbed to a vulgar reply,",
                                                  "adjective verb noun preposition article noun conjunction pronoun verb article noun preposition pronoun noun conjunction verb preposition article noun noun");

                High.sentence[0].sentenceLP = sentence9High;
                High.sentence[1].sentenceLP = sentence10High;
                High.sentence[2].sentenceLP = sentence11High;
                High.sentence[3].sentenceLP = sentence12High;
                High.sentence[0].word[0].wordLbl = w1Lbl9;
                High.sentence[0].word[1].wordLbl = w2Lbl9;
                High.sentence[0].word[2].wordLbl = w3Lbl9;
                High.sentence[0].word[3].wordLbl = w4Lbl9;
                High.sentence[0].word[4].wordLbl = w5Lbl9;
                High.sentence[0].word[5].wordLbl = w6Lbl9;
                High.sentence[0].word[6].wordLbl = w7Lbl9;
                High.sentence[0].word[7].wordLbl = w8Lbl9;
                High.sentence[0].word[8].wordLbl = w9Lbl9;
                High.sentence[0].word[9].wordLbl = w10Lbl9;
                High.sentence[0].word[10].wordLbl = w11Lbl9;
                High.sentence[0].word[11].wordLbl = w12Lbl9;
                High.sentence[0].word[12].wordLbl = w13Lbl9;
                High.sentence[0].word[13].wordLbl = w14Lbl9;
                High.sentence[0].word[14].wordLbl = w15Lbl9;
                High.sentence[0].word[15].wordLbl = w16Lbl9;
                High.sentence[0].word[16].wordLbl = w17Lbl9;
                High.sentence[0].word[17].wordLbl = w18Lbl9;

                High.sentence[1].word[0].wordLbl = w1Lbl10;
                High.sentence[1].word[1].wordLbl = w2Lbl10;
                High.sentence[1].word[2].wordLbl = w3Lbl10;
                High.sentence[1].word[3].wordLbl = w4Lbl10;
                High.sentence[1].word[4].wordLbl = w5Lbl10;
                High.sentence[1].word[5].wordLbl = w6Lbl10;
                High.sentence[1].word[6].wordLbl = w7Lbl10;
                High.sentence[1].word[7].wordLbl = w8Lbl10;
                High.sentence[1].word[8].wordLbl = w9Lbl10;
                High.sentence[1].word[9].wordLbl = w10Lbl10;
                High.sentence[1].word[10].wordLbl = w11Lbl10;
                High.sentence[1].word[11].wordLbl = w12Lbl10;
                High.sentence[1].word[12].wordLbl = w13Lbl10;
                High.sentence[1].word[13].wordLbl = w14Lbl10;
                High.sentence[1].word[14].wordLbl = w15Lbl10;

                High.sentence[2].word[0].wordLbl = w1Lbl11;
                High.sentence[2].word[1].wordLbl = w2Lbl11;
                High.sentence[2].word[2].wordLbl = w3Lbl11;
                High.sentence[2].word[3].wordLbl = w4Lbl11;
                High.sentence[2].word[4].wordLbl = w5Lbl11;
                High.sentence[2].word[5].wordLbl = w6Lbl11;
                High.sentence[2].word[6].wordLbl = w7Lbl11;
                High.sentence[2].word[7].wordLbl = w8Lbl11;
                High.sentence[2].word[8].wordLbl = w9Lbl11;
                High.sentence[2].word[9].wordLbl = w10Lbl11;
                High.sentence[2].word[10].wordLbl = w11Lbl11;
                High.sentence[2].word[11].wordLbl = w12Lbl11;
                High.sentence[2].word[12].wordLbl = w13Lbl11;
                High.sentence[2].word[13].wordLbl = w14Lbl11;
                High.sentence[2].word[14].wordLbl = w15Lbl11;
                High.sentence[2].word[15].wordLbl = w16Lbl11;

                High.sentence[3].word[0].wordLbl = w1Lbl12;
                High.sentence[3].word[1].wordLbl = w2Lbl12;
                High.sentence[3].word[2].wordLbl = w3Lbl12;
                High.sentence[3].word[3].wordLbl = w4Lbl12;
                High.sentence[3].word[4].wordLbl = w5Lbl12;
                High.sentence[3].word[5].wordLbl = w6Lbl12;
                High.sentence[3].word[6].wordLbl = w7Lbl12;
                High.sentence[3].word[7].wordLbl = w8Lbl12;
                High.sentence[3].word[8].wordLbl = w9Lbl12;
                High.sentence[3].word[9].wordLbl = w10Lbl12;
                High.sentence[3].word[10].wordLbl = w11Lbl12;
                High.sentence[3].word[11].wordLbl = w12Lbl12;
                High.sentence[3].word[12].wordLbl = w13Lbl12;
                High.sentence[3].word[13].wordLbl = w14Lbl12;
                High.sentence[3].word[14].wordLbl = w15Lbl12;
                High.sentence[3].word[15].wordLbl = w16Lbl12;
                High.sentence[3].word[16].wordLbl = w17Lbl12;
                High.sentence[3].word[17].wordLbl = w18Lbl12;
                High.sentence[3].word[18].wordLbl = w19Lbl12;
                High.sentence[3].word[19].wordLbl = w20Lbl12;

                //Pointer to a Answer POS label to display the players choice
                High.sentence[0].word[0].posLbl = w1pos9;
                High.sentence[0].word[1].posLbl = w2pos9;
                High.sentence[0].word[2].posLbl = w3pos9;
                High.sentence[0].word[3].posLbl = w4pos9;
                High.sentence[0].word[4].posLbl = w5pos9;
                High.sentence[0].word[5].posLbl = w6pos9;
                High.sentence[0].word[6].posLbl = w7pos9;
                High.sentence[0].word[7].posLbl = w8pos9;
                High.sentence[0].word[8].posLbl = w9pos9;
                High.sentence[0].word[9].posLbl = w10pos9;
                High.sentence[0].word[10].posLbl = w11pos9;
                High.sentence[0].word[11].posLbl = w12pos9;
                High.sentence[0].word[12].posLbl = w13pos9;
                High.sentence[0].word[13].posLbl = w14pos9;
                High.sentence[0].word[14].posLbl = w15pos9;
                High.sentence[0].word[15].posLbl = w16pos9;
                High.sentence[0].word[16].posLbl = w17pos9;
                High.sentence[0].word[17].posLbl = w18pos9;

                High.sentence[1].word[0].posLbl = w1pos10;
                High.sentence[1].word[1].posLbl = w2pos10;
                High.sentence[1].word[2].posLbl = w3pos10;
                High.sentence[1].word[3].posLbl = w4pos10;
                High.sentence[1].word[4].posLbl = w5pos10;
                High.sentence[1].word[5].posLbl = w6pos10;
                High.sentence[1].word[6].posLbl = w7pos10;
                High.sentence[1].word[7].posLbl = w8pos10;
                High.sentence[1].word[8].posLbl = w9pos10;
                High.sentence[1].word[9].posLbl = w10pos10;
                High.sentence[1].word[10].posLbl = w11pos10;
                High.sentence[1].word[11].posLbl = w12pos10;
                High.sentence[1].word[12].posLbl = w13pos10;
                High.sentence[1].word[13].posLbl = w14pos10;
                High.sentence[1].word[14].posLbl = w15pos10;

                High.sentence[2].word[0].posLbl = w1pos11;
                High.sentence[2].word[1].posLbl = w2pos11;
                High.sentence[2].word[2].posLbl = w3pos11;
                High.sentence[2].word[3].posLbl = w4pos11;
                High.sentence[2].word[4].posLbl = w5pos11;
                High.sentence[2].word[5].posLbl = w6pos11;
                High.sentence[2].word[6].posLbl = w7pos11;
                High.sentence[2].word[7].posLbl = w8pos11;
                High.sentence[2].word[8].posLbl = w9pos11;
                High.sentence[2].word[9].posLbl = w10pos11;
                High.sentence[2].word[10].posLbl = w11pos11;
                High.sentence[2].word[11].posLbl = w12pos11;
                High.sentence[2].word[12].posLbl = w13pos11;
                High.sentence[2].word[13].posLbl = w14pos11;
                High.sentence[2].word[14].posLbl = w15pos11;
                High.sentence[2].word[15].posLbl = w16pos11;

                High.sentence[3].word[0].posLbl = w1pos12;
                High.sentence[3].word[1].posLbl = w2pos12;
                High.sentence[3].word[2].posLbl = w3pos12;
                High.sentence[3].word[3].posLbl = w4pos12;
                High.sentence[3].word[4].posLbl = w5pos12;
                High.sentence[3].word[5].posLbl = w6pos12;
                High.sentence[3].word[6].posLbl = w7pos12;
                High.sentence[3].word[7].posLbl = w8pos12;
                High.sentence[3].word[8].posLbl = w9pos12;
                High.sentence[3].word[9].posLbl = w10pos12;
                High.sentence[3].word[10].posLbl = w11pos12;
                High.sentence[3].word[11].posLbl = w12pos12;
                High.sentence[3].word[12].posLbl = w13pos12;
                High.sentence[3].word[13].posLbl = w14pos12;
                High.sentence[3].word[14].posLbl = w15pos12;
                High.sentence[3].word[15].posLbl = w16pos12;
                High.sentence[3].word[16].posLbl = w17pos12;
                High.sentence[3].word[17].posLbl = w18pos12;
                High.sentence[3].word[18].posLbl = w19pos12;
                High.sentence[3].word[19].posLbl = w20pos12;

                High.sentence[currentSentence].sentenceLP.setVisible(true);
                High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);

                gameTimer.setSentence(High.sentence);

                break;
        }
        //setLocationRelativeTo(null);
        


        //Interpreter i = new Interpreter();
        /*int a = 2;
        int b = 1;
        */
        //javax.swing.JLabel s = ("w"+a+"Lbl"+b);
        //System.out.println(s);
        //javax.swing.JLabel l = new javax.swing.JLabel();
        /*try{
            i.eval("k=w"+a+"Lbl"+b);
            
        } catch ( bsh.EvalError e ) {
            // The script threw an exception

            System.out.println( "Script threw exception: " + e.getErrorText());
        }
        try{
            i.eval("ab=k");
        } catch (bsh.EvalError e) {
            System.out.println(e.getErrorText());
        }
        try{
            this.l = (javax.swing.JLabel)i.get("w2Lbl1");
        } catch (bsh.EvalError e) {
            System.out.println("Script threw exception: Line# " + e.getErrorLineNumber());
        }
        System.out.println(this.l.getText());
        */
        //Elementary.sentence[0].word[1].wordLbl = i.get("word_label");
        //Elementary.sentence[0].word[1].wordLbl.setForeground(new java.awt.Color(51, 0, 255));

        //System.out.println(Elementary.sentence[0].getText() + "\n" + Elementary.sentence[0].word[0].getWord() + "\n" + Elementary.sentence[0].word[0].getPos());
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
        gameboardLP = new javax.swing.JLayeredPane();
        timerLbl = new javax.swing.JLabel();
        verbBtn = new javax.swing.JButton();
        adjectiveBtn = new javax.swing.JButton();
        adverbBtn = new javax.swing.JButton();
        articleBtn = new javax.swing.JButton();
        conjunctionBtn = new javax.swing.JButton();
        interjectionBtn = new javax.swing.JButton();
        nounBtn = new javax.swing.JButton();
        prepositionBtn = new javax.swing.JButton();
        pronounBtn = new javax.swing.JButton();
        continueBtn = new javax.swing.JButton();
        SpeedGramBtn = new javax.swing.JButton();
        toolBarLbl = new javax.swing.JLabel();
        sentence1Elementary = new javax.swing.JLayeredPane();
        w1Lbl1 = new javax.swing.JLabel();
        w2Lbl1 = new javax.swing.JLabel();
        w3Lbl1 = new javax.swing.JLabel();
        w4Lbl1 = new javax.swing.JLabel();
        w5Lbl1 = new javax.swing.JLabel();
        w6Lbl1 = new javax.swing.JLabel();
        w7Lbl1 = new javax.swing.JLabel();
        w8Lbl1 = new javax.swing.JLabel();
        w9Lbl1 = new javax.swing.JLabel();
        w10Lbl1 = new javax.swing.JLabel();
        w11Lbl1 = new javax.swing.JLabel();
        w1pos1 = new javax.swing.JLabel();
        w2pos1 = new javax.swing.JLabel();
        w3pos1 = new javax.swing.JLabel();
        w4pos1 = new javax.swing.JLabel();
        w5pos1 = new javax.swing.JLabel();
        w6pos1 = new javax.swing.JLabel();
        w7pos1 = new javax.swing.JLabel();
        w8pos1 = new javax.swing.JLabel();
        w9pos1 = new javax.swing.JLabel();
        w10pos1 = new javax.swing.JLabel();
        w11pos1 = new javax.swing.JLabel();
        waitingLbl = new javax.swing.JLabel();
        sentence2Elementary = new javax.swing.JLayeredPane();
        w1Lbl2 = new javax.swing.JLabel();
        w2Lbl2 = new javax.swing.JLabel();
        w3Lbl2 = new javax.swing.JLabel();
        w4Lbl2 = new javax.swing.JLabel();
        w5Lbl2 = new javax.swing.JLabel();
        w6Lbl2 = new javax.swing.JLabel();
        w7Lbl2 = new javax.swing.JLabel();
        w8Lbl2 = new javax.swing.JLabel();
        w9Lbl2 = new javax.swing.JLabel();
        w10Lbl2 = new javax.swing.JLabel();
        w11Lbl2 = new javax.swing.JLabel();
        w12Lbl2 = new javax.swing.JLabel();
        w1pos2 = new javax.swing.JLabel();
        w2pos2 = new javax.swing.JLabel();
        w3pos2 = new javax.swing.JLabel();
        w4pos2 = new javax.swing.JLabel();
        w5pos2 = new javax.swing.JLabel();
        w6pos2 = new javax.swing.JLabel();
        w7pos2 = new javax.swing.JLabel();
        w8pos2 = new javax.swing.JLabel();
        w9pos2 = new javax.swing.JLabel();
        w10pos2 = new javax.swing.JLabel();
        w11pos2 = new javax.swing.JLabel();
        w12pos2 = new javax.swing.JLabel();
        sentence3Elementary = new javax.swing.JLayeredPane();
        w1Lbl3 = new javax.swing.JLabel();
        w2Lbl3 = new javax.swing.JLabel();
        w3Lbl3 = new javax.swing.JLabel();
        w4Lbl3 = new javax.swing.JLabel();
        w5Lbl3 = new javax.swing.JLabel();
        w6Lbl3 = new javax.swing.JLabel();
        w7Lbl3 = new javax.swing.JLabel();
        w8Lbl3 = new javax.swing.JLabel();
        w9Lbl3 = new javax.swing.JLabel();
        w10Lbl3 = new javax.swing.JLabel();
        w1pos3 = new javax.swing.JLabel();
        w2pos3 = new javax.swing.JLabel();
        w3pos3 = new javax.swing.JLabel();
        w4pos3 = new javax.swing.JLabel();
        w5pos3 = new javax.swing.JLabel();
        w6pos3 = new javax.swing.JLabel();
        w7pos3 = new javax.swing.JLabel();
        w8pos3 = new javax.swing.JLabel();
        w9pos3 = new javax.swing.JLabel();
        w10pos3 = new javax.swing.JLabel();
        sentence4Elementary = new javax.swing.JLayeredPane();
        w1Lbl4 = new javax.swing.JLabel();
        w2Lbl4 = new javax.swing.JLabel();
        w3Lbl4 = new javax.swing.JLabel();
        w4Lbl4 = new javax.swing.JLabel();
        w5Lbl4 = new javax.swing.JLabel();
        w6Lbl4 = new javax.swing.JLabel();
        w7Lbl4 = new javax.swing.JLabel();
        w1pos4 = new javax.swing.JLabel();
        w2pos4 = new javax.swing.JLabel();
        w3pos4 = new javax.swing.JLabel();
        w4pos4 = new javax.swing.JLabel();
        w5pos4 = new javax.swing.JLabel();
        w6pos4 = new javax.swing.JLabel();
        w7pos4 = new javax.swing.JLabel();
        sentence5Middle = new javax.swing.JLayeredPane();
        w1Lbl5 = new javax.swing.JLabel();
        w2Lbl5 = new javax.swing.JLabel();
        w3Lbl5 = new javax.swing.JLabel();
        w4Lbl5 = new javax.swing.JLabel();
        w5Lbl5 = new javax.swing.JLabel();
        w6Lbl5 = new javax.swing.JLabel();
        w7Lbl5 = new javax.swing.JLabel();
        w8Lbl5 = new javax.swing.JLabel();
        w9Lbl5 = new javax.swing.JLabel();
        w10Lbl5 = new javax.swing.JLabel();
        w11Lbl5 = new javax.swing.JLabel();
        w12Lbl5 = new javax.swing.JLabel();
        w13Lbl5 = new javax.swing.JLabel();
        w14Lbl5 = new javax.swing.JLabel();
        w15Lbl5 = new javax.swing.JLabel();
        w1pos5 = new javax.swing.JLabel();
        w2pos5 = new javax.swing.JLabel();
        w3pos5 = new javax.swing.JLabel();
        w4pos5 = new javax.swing.JLabel();
        w5pos5 = new javax.swing.JLabel();
        w6pos5 = new javax.swing.JLabel();
        w7pos5 = new javax.swing.JLabel();
        w8pos5 = new javax.swing.JLabel();
        w9pos5 = new javax.swing.JLabel();
        w10pos5 = new javax.swing.JLabel();
        w11pos5 = new javax.swing.JLabel();
        w12pos5 = new javax.swing.JLabel();
        w13pos5 = new javax.swing.JLabel();
        w14pos5 = new javax.swing.JLabel();
        w15pos5 = new javax.swing.JLabel();
        sentence6Middle = new javax.swing.JLayeredPane();
        w1Lbl6 = new javax.swing.JLabel();
        w2Lbl6 = new javax.swing.JLabel();
        w3Lbl6 = new javax.swing.JLabel();
        w4Lbl6 = new javax.swing.JLabel();
        w5Lbl6 = new javax.swing.JLabel();
        w6Lbl6 = new javax.swing.JLabel();
        w7Lbl6 = new javax.swing.JLabel();
        w8Lbl6 = new javax.swing.JLabel();
        w9Lbl6 = new javax.swing.JLabel();
        w10Lbl6 = new javax.swing.JLabel();
        w11Lbl6 = new javax.swing.JLabel();
        w12Lbl6 = new javax.swing.JLabel();
        w13Lbl6 = new javax.swing.JLabel();
        w14Lbl6 = new javax.swing.JLabel();
        w15Lbl6 = new javax.swing.JLabel();
        w16Lbl6 = new javax.swing.JLabel();
        w1pos6 = new javax.swing.JLabel();
        w2pos6 = new javax.swing.JLabel();
        w3pos6 = new javax.swing.JLabel();
        w4pos6 = new javax.swing.JLabel();
        w5pos6 = new javax.swing.JLabel();
        w6pos6 = new javax.swing.JLabel();
        w7pos6 = new javax.swing.JLabel();
        w8pos6 = new javax.swing.JLabel();
        w9pos6 = new javax.swing.JLabel();
        w10pos6 = new javax.swing.JLabel();
        w11pos6 = new javax.swing.JLabel();
        w12pos6 = new javax.swing.JLabel();
        w13pos6 = new javax.swing.JLabel();
        w14pos6 = new javax.swing.JLabel();
        w15pos6 = new javax.swing.JLabel();
        w16pos6 = new javax.swing.JLabel();
        sentence7Middle = new javax.swing.JLayeredPane();
        w1Lbl7 = new javax.swing.JLabel();
        w2Lbl7 = new javax.swing.JLabel();
        w3Lbl7 = new javax.swing.JLabel();
        w4Lbl7 = new javax.swing.JLabel();
        w5Lbl7 = new javax.swing.JLabel();
        w6Lbl7 = new javax.swing.JLabel();
        w7Lbl7 = new javax.swing.JLabel();
        w8Lbl7 = new javax.swing.JLabel();
        w9Lbl7 = new javax.swing.JLabel();
        w10Lbl7 = new javax.swing.JLabel();
        w11Lbl7 = new javax.swing.JLabel();
        w12Lbl7 = new javax.swing.JLabel();
        w1pos7 = new javax.swing.JLabel();
        w2pos7 = new javax.swing.JLabel();
        w3pos7 = new javax.swing.JLabel();
        w4pos7 = new javax.swing.JLabel();
        w5pos7 = new javax.swing.JLabel();
        w6pos7 = new javax.swing.JLabel();
        w7pos7 = new javax.swing.JLabel();
        w8pos7 = new javax.swing.JLabel();
        w9pos7 = new javax.swing.JLabel();
        w10pos7 = new javax.swing.JLabel();
        w11pos7 = new javax.swing.JLabel();
        w12pos7 = new javax.swing.JLabel();
        sentence8Middle = new javax.swing.JLayeredPane();
        w1Lbl8 = new javax.swing.JLabel();
        w2Lbl8 = new javax.swing.JLabel();
        w3Lbl8 = new javax.swing.JLabel();
        w4Lbl8 = new javax.swing.JLabel();
        w5Lbl8 = new javax.swing.JLabel();
        w6Lbl8 = new javax.swing.JLabel();
        w7Lbl8 = new javax.swing.JLabel();
        w8Lbl8 = new javax.swing.JLabel();
        w9Lbl8 = new javax.swing.JLabel();
        w10Lbl8 = new javax.swing.JLabel();
        w11Lbl8 = new javax.swing.JLabel();
        w12Lbl8 = new javax.swing.JLabel();
        w13Lbl8 = new javax.swing.JLabel();
        w14Lbl8 = new javax.swing.JLabel();
        w15Lbl8 = new javax.swing.JLabel();
        w16Lbl8 = new javax.swing.JLabel();
        w17Lbl8 = new javax.swing.JLabel();
        w18Lbl8 = new javax.swing.JLabel();
        w1pos8 = new javax.swing.JLabel();
        w2pos8 = new javax.swing.JLabel();
        w3pos8 = new javax.swing.JLabel();
        w4pos8 = new javax.swing.JLabel();
        w5pos8 = new javax.swing.JLabel();
        w6pos8 = new javax.swing.JLabel();
        w18pos8 = new javax.swing.JLabel();
        w7pos8 = new javax.swing.JLabel();
        w8pos8 = new javax.swing.JLabel();
        w9pos8 = new javax.swing.JLabel();
        w10pos8 = new javax.swing.JLabel();
        w11pos8 = new javax.swing.JLabel();
        w12pos8 = new javax.swing.JLabel();
        w13pos8 = new javax.swing.JLabel();
        w14pos8 = new javax.swing.JLabel();
        w15pos8 = new javax.swing.JLabel();
        w16pos8 = new javax.swing.JLabel();
        w17pos8 = new javax.swing.JLabel();
        sentence9High = new javax.swing.JLayeredPane();
        w1Lbl9 = new javax.swing.JLabel();
        w2Lbl9 = new javax.swing.JLabel();
        w3Lbl9 = new javax.swing.JLabel();
        w4Lbl9 = new javax.swing.JLabel();
        w5Lbl9 = new javax.swing.JLabel();
        w6Lbl9 = new javax.swing.JLabel();
        w7Lbl9 = new javax.swing.JLabel();
        w8Lbl9 = new javax.swing.JLabel();
        w9Lbl9 = new javax.swing.JLabel();
        w10Lbl9 = new javax.swing.JLabel();
        w11Lbl9 = new javax.swing.JLabel();
        w12Lbl9 = new javax.swing.JLabel();
        w13Lbl9 = new javax.swing.JLabel();
        w14Lbl9 = new javax.swing.JLabel();
        w15Lbl9 = new javax.swing.JLabel();
        w16Lbl9 = new javax.swing.JLabel();
        w17Lbl9 = new javax.swing.JLabel();
        w18Lbl9 = new javax.swing.JLabel();
        w1pos9 = new javax.swing.JLabel();
        w2pos9 = new javax.swing.JLabel();
        w3pos9 = new javax.swing.JLabel();
        w4pos9 = new javax.swing.JLabel();
        w5pos9 = new javax.swing.JLabel();
        w6pos9 = new javax.swing.JLabel();
        w7pos9 = new javax.swing.JLabel();
        w8pos9 = new javax.swing.JLabel();
        w9pos9 = new javax.swing.JLabel();
        w10pos9 = new javax.swing.JLabel();
        w11pos9 = new javax.swing.JLabel();
        w12pos9 = new javax.swing.JLabel();
        w13pos9 = new javax.swing.JLabel();
        w14pos9 = new javax.swing.JLabel();
        w15pos9 = new javax.swing.JLabel();
        w16pos9 = new javax.swing.JLabel();
        w17pos9 = new javax.swing.JLabel();
        w18pos9 = new javax.swing.JLabel();
        sentence10High = new javax.swing.JLayeredPane();
        w1Lbl10 = new javax.swing.JLabel();
        w2Lbl10 = new javax.swing.JLabel();
        w3Lbl10 = new javax.swing.JLabel();
        w4Lbl10 = new javax.swing.JLabel();
        w5Lbl10 = new javax.swing.JLabel();
        w6Lbl10 = new javax.swing.JLabel();
        w7Lbl10 = new javax.swing.JLabel();
        w8Lbl10 = new javax.swing.JLabel();
        w9Lbl10 = new javax.swing.JLabel();
        w10Lbl10 = new javax.swing.JLabel();
        w11Lbl10 = new javax.swing.JLabel();
        w12Lbl10 = new javax.swing.JLabel();
        w13Lbl10 = new javax.swing.JLabel();
        w14Lbl10 = new javax.swing.JLabel();
        w15Lbl10 = new javax.swing.JLabel();
        w1pos10 = new javax.swing.JLabel();
        w2pos10 = new javax.swing.JLabel();
        w3pos10 = new javax.swing.JLabel();
        w4pos10 = new javax.swing.JLabel();
        w5pos10 = new javax.swing.JLabel();
        w6pos10 = new javax.swing.JLabel();
        w7pos10 = new javax.swing.JLabel();
        w8pos10 = new javax.swing.JLabel();
        w9pos10 = new javax.swing.JLabel();
        w10pos10 = new javax.swing.JLabel();
        w11pos10 = new javax.swing.JLabel();
        w12pos10 = new javax.swing.JLabel();
        w13pos10 = new javax.swing.JLabel();
        w14pos10 = new javax.swing.JLabel();
        w15pos10 = new javax.swing.JLabel();
        sentence11High = new javax.swing.JLayeredPane();
        w1Lbl11 = new javax.swing.JLabel();
        w2Lbl11 = new javax.swing.JLabel();
        w3Lbl11 = new javax.swing.JLabel();
        w4Lbl11 = new javax.swing.JLabel();
        w5Lbl11 = new javax.swing.JLabel();
        w6Lbl11 = new javax.swing.JLabel();
        w7Lbl11 = new javax.swing.JLabel();
        w8Lbl11 = new javax.swing.JLabel();
        w9Lbl11 = new javax.swing.JLabel();
        w10Lbl11 = new javax.swing.JLabel();
        w11Lbl11 = new javax.swing.JLabel();
        w12Lbl11 = new javax.swing.JLabel();
        w13Lbl11 = new javax.swing.JLabel();
        w14Lbl11 = new javax.swing.JLabel();
        w15Lbl11 = new javax.swing.JLabel();
        w16Lbl11 = new javax.swing.JLabel();
        w1pos11 = new javax.swing.JLabel();
        w2pos11 = new javax.swing.JLabel();
        w3pos11 = new javax.swing.JLabel();
        w4pos11 = new javax.swing.JLabel();
        w5pos11 = new javax.swing.JLabel();
        w6pos11 = new javax.swing.JLabel();
        w7pos11 = new javax.swing.JLabel();
        w8pos11 = new javax.swing.JLabel();
        w9pos11 = new javax.swing.JLabel();
        w10pos11 = new javax.swing.JLabel();
        w11pos11 = new javax.swing.JLabel();
        w12pos11 = new javax.swing.JLabel();
        w13pos11 = new javax.swing.JLabel();
        w14pos11 = new javax.swing.JLabel();
        w15pos11 = new javax.swing.JLabel();
        w16pos11 = new javax.swing.JLabel();
        sentence12High = new javax.swing.JLayeredPane();
        w1Lbl12 = new javax.swing.JLabel();
        w2Lbl12 = new javax.swing.JLabel();
        w3Lbl12 = new javax.swing.JLabel();
        w4Lbl12 = new javax.swing.JLabel();
        w5Lbl12 = new javax.swing.JLabel();
        w6Lbl12 = new javax.swing.JLabel();
        w7Lbl12 = new javax.swing.JLabel();
        w8Lbl12 = new javax.swing.JLabel();
        w9Lbl12 = new javax.swing.JLabel();
        w10Lbl12 = new javax.swing.JLabel();
        w11Lbl12 = new javax.swing.JLabel();
        w12Lbl12 = new javax.swing.JLabel();
        w13Lbl12 = new javax.swing.JLabel();
        w14Lbl12 = new javax.swing.JLabel();
        w15Lbl12 = new javax.swing.JLabel();
        w16Lbl12 = new javax.swing.JLabel();
        w17Lbl12 = new javax.swing.JLabel();
        w18Lbl12 = new javax.swing.JLabel();
        w19Lbl12 = new javax.swing.JLabel();
        w20Lbl12 = new javax.swing.JLabel();
        w1pos12 = new javax.swing.JLabel();
        w2pos12 = new javax.swing.JLabel();
        w3pos12 = new javax.swing.JLabel();
        w4pos12 = new javax.swing.JLabel();
        w5pos12 = new javax.swing.JLabel();
        w6pos12 = new javax.swing.JLabel();
        w7pos12 = new javax.swing.JLabel();
        w8pos12 = new javax.swing.JLabel();
        w9pos12 = new javax.swing.JLabel();
        w10pos12 = new javax.swing.JLabel();
        w11pos12 = new javax.swing.JLabel();
        w12pos12 = new javax.swing.JLabel();
        w13pos12 = new javax.swing.JLabel();
        w14pos12 = new javax.swing.JLabel();
        w15pos12 = new javax.swing.JLabel();
        w16pos12 = new javax.swing.JLabel();
        w17pos12 = new javax.swing.JLabel();
        w18pos12 = new javax.swing.JLabel();
        w19pos12 = new javax.swing.JLabel();
        w20pos12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        scoreLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(840, 603));
        jPanel1.setSize(new java.awt.Dimension(840, 603));

        timerLbl.setFont(new java.awt.Font("Gill Sans Bold", 1, 24)); // NOI18N
        timerLbl.setText("Timer");
        timerLbl.setBounds(400, 70, 130, 40);
        gameboardLP.add(timerLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        verbBtn.setBackground(new java.awt.Color(255, 255, 255));
        verbBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/verb.png"))); // NOI18N
        verbBtn.setBorderPainted(false);
        verbBtn.setFocusPainted(false);
        verbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verbBtnActionPerformed(evt);
            }
        });
        verbBtn.setBounds(430, 470, 90, 100);
        gameboardLP.add(verbBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        adjectiveBtn.setBackground(new java.awt.Color(255, 255, 255));
        adjectiveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/adjective.png"))); // NOI18N
        adjectiveBtn.setBorderPainted(false);
        adjectiveBtn.setFocusPainted(false);
        adjectiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjectiveBtnActionPerformed(evt);
            }
        });
        adjectiveBtn.setBounds(110, 470, 80, 100);
        gameboardLP.add(adjectiveBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        adverbBtn.setBackground(new java.awt.Color(255, 255, 255));
        adverbBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/adverb.png"))); // NOI18N
        adverbBtn.setBorderPainted(false);
        adverbBtn.setFocusPainted(false);
        adverbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adverbBtnActionPerformed(evt);
            }
        });
        adverbBtn.setBounds(360, 470, 70, 100);
        gameboardLP.add(adverbBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        articleBtn.setBackground(new java.awt.Color(255, 255, 255));
        articleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/article.png"))); // NOI18N
        articleBtn.setBorderPainted(false);
        articleBtn.setFocusPainted(false);
        articleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articleBtnActionPerformed(evt);
            }
        });
        articleBtn.setBounds(30, 470, 80, 100);
        gameboardLP.add(articleBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        conjunctionBtn.setBackground(new java.awt.Color(255, 255, 255));
        conjunctionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/conjunction.png"))); // NOI18N
        conjunctionBtn.setBorderPainted(false);
        conjunctionBtn.setFocusPainted(false);
        conjunctionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conjunctionBtnActionPerformed(evt);
            }
        });
        conjunctionBtn.setBounds(630, 470, 100, 100);
        gameboardLP.add(conjunctionBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        interjectionBtn.setBackground(new java.awt.Color(255, 255, 255));
        interjectionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/interjection.png"))); // NOI18N
        interjectionBtn.setBorderPainted(false);
        interjectionBtn.setFocusPainted(false);
        interjectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interjectionBtnActionPerformed(evt);
            }
        });
        interjectionBtn.setBounds(740, 470, 80, 100);
        gameboardLP.add(interjectionBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nounBtn.setBackground(new java.awt.Color(255, 255, 255));
        nounBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/noun.png"))); // NOI18N
        nounBtn.setBorderPainted(false);
        nounBtn.setFocusPainted(false);
        nounBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nounBtnActionPerformed(evt);
            }
        });
        nounBtn.setBounds(190, 470, 90, 100);
        gameboardLP.add(nounBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        prepositionBtn.setBackground(new java.awt.Color(255, 255, 255));
        prepositionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/preposition.png"))); // NOI18N
        prepositionBtn.setBorderPainted(false);
        prepositionBtn.setFocusPainted(false);
        prepositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prepositionBtnActionPerformed(evt);
            }
        });
        prepositionBtn.setBounds(530, 470, 100, 100);
        gameboardLP.add(prepositionBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pronounBtn.setBackground(new java.awt.Color(255, 255, 255));
        pronounBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/pronoun.png"))); // NOI18N
        pronounBtn.setBorderPainted(false);
        pronounBtn.setFocusPainted(false);
        pronounBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pronounBtnActionPerformed(evt);
            }
        });
        pronounBtn.setBounds(280, 470, 80, 100);
        gameboardLP.add(pronounBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        continueBtn.setBackground(new java.awt.Color(255, 255, 255));
        continueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/arrow.png"))); // NOI18N
        continueBtn.setBorderPainted(false);
        continueBtn.setFocusPainted(false);
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });
        continueBtn.setBounds(780, 210, 50, 150);
        gameboardLP.add(continueBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        SpeedGramBtn.setBackground(new java.awt.Color(255, 255, 255));
        SpeedGramBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/speedy_gram_logo_4.png"))); // NOI18N
        SpeedGramBtn.setBorderPainted(false);
        SpeedGramBtn.setFocusPainted(false);
        SpeedGramBtn.setBounds(0, 0, 200, 40);
        gameboardLP.add(SpeedGramBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        toolBarLbl.setBackground(new java.awt.Color(255, 255, 255));
        toolBarLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/toolsBG.png"))); // NOI18N
        toolBarLbl.setBounds(10, 460, 830, 120);
        gameboardLP.add(toolBarLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        w1Lbl1.setText("The");
        w1Lbl1.setBounds(20, 80, 70, 50);
        sentence1Elementary.add(w1Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        w2Lbl1.setText("man");
        w2Lbl1.setBounds(100, 80, 80, 50);
        sentence1Elementary.add(w2Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl1.setText("sat");
        w3Lbl1.setBounds(190, 80, 60, 50);
        sentence1Elementary.add(w3Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl1.setText("on");
        w4Lbl1.setBounds(250, 80, 50, 50);
        sentence1Elementary.add(w4Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl1.setText("the");
        w5Lbl1.setBounds(310, 80, 60, 50);
        sentence1Elementary.add(w5Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl1.setText("bench");
        w6Lbl1.setBounds(380, 80, 110, 50);
        sentence1Elementary.add(w6Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl1.setText("and");
        w7Lbl1.setBounds(500, 80, 70, 50);
        sentence1Elementary.add(w7Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl1.setText("read");
        w8Lbl1.setBounds(580, 80, 80, 50);
        sentence1Elementary.add(w8Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl1.setText("the");
        w9Lbl1.setBounds(20, 170, 60, 50);
        sentence1Elementary.add(w9Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        w10Lbl1.setText("interesting");
        w10Lbl1.setBounds(90, 170, 200, 50);
        sentence1Elementary.add(w10Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl1.setText("book.");
        w11Lbl1.setBounds(290, 170, 110, 50);
        sentence1Elementary.add(w11Lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos1.setBounds(20, 126, 60, 50);
        sentence1Elementary.add(w1pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos1.setBounds(110, 130, 60, 50);
        sentence1Elementary.add(w2pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos1.setBounds(180, 130, 60, 50);
        sentence1Elementary.add(w3pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos1.setBounds(240, 130, 60, 50);
        sentence1Elementary.add(w4pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos1.setBounds(310, 130, 60, 50);
        sentence1Elementary.add(w5pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos1.setBounds(400, 130, 60, 50);
        sentence1Elementary.add(w6pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos1.setBounds(500, 130, 60, 50);
        sentence1Elementary.add(w7pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos1.setBounds(590, 130, 60, 50);
        sentence1Elementary.add(w8pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos1.setBounds(20, 220, 60, 50);
        sentence1Elementary.add(w9pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos1.setBounds(150, 220, 60, 50);
        sentence1Elementary.add(w10pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos1.setBounds(310, 220, 60, 50);
        sentence1Elementary.add(w11pos1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        waitingLbl.setFont(new java.awt.Font("Gill Sans Bold", 1, 18)); // NOI18N
        waitingLbl.setForeground(new java.awt.Color(255, 0, 0));
        waitingLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        waitingLbl.setText("waiting for interface ....");
        waitingLbl.setBounds(30, 300, 640, 30);
        sentence1Elementary.add(waitingLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence1Elementary.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence1Elementary, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl2.setText("Melissa");
        w1Lbl2.setBounds(20, 80, 130, 50);
        sentence2Elementary.add(w1Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl2.setText("and");
        w2Lbl2.setBounds(160, 80, 80, 50);
        sentence2Elementary.add(w2Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl2.setText("Shelia");
        w3Lbl2.setBounds(240, 80, 110, 50);
        sentence2Elementary.add(w3Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl2.setText("went");
        w4Lbl2.setBounds(360, 80, 90, 50);
        sentence2Elementary.add(w4Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl2.setText("to");
        w5Lbl2.setBounds(460, 80, 40, 50);
        sentence2Elementary.add(w5Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl2.setText("the");
        w6Lbl2.setBounds(510, 80, 60, 50);
        sentence2Elementary.add(w6Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl2.setText("beach");
        w7Lbl2.setBounds(580, 80, 120, 50);
        sentence2Elementary.add(w7Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl2.setText("and");
        w8Lbl2.setBounds(20, 170, 80, 50);
        sentence2Elementary.add(w8Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl2.setText("swam");
        w9Lbl2.setBounds(110, 170, 110, 50);
        sentence2Elementary.add(w9Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl2.setText("in");
        w10Lbl2.setBounds(230, 170, 40, 50);
        sentence2Elementary.add(w10Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl2.setText("the");
        w11Lbl2.setBounds(280, 170, 60, 50);
        sentence2Elementary.add(w11Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl2.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl2.setText("ocean.");
        w12Lbl2.setBounds(350, 170, 120, 50);
        sentence2Elementary.add(w12Lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos2.setBounds(60, 130, 60, 50);
        sentence2Elementary.add(w1pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos2.setBounds(170, 130, 60, 50);
        sentence2Elementary.add(w2pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos2.setBounds(260, 130, 60, 50);
        sentence2Elementary.add(w3pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos2.setBounds(370, 130, 60, 50);
        sentence2Elementary.add(w4pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos2.setBounds(450, 130, 60, 50);
        sentence2Elementary.add(w5pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos2.setBounds(510, 130, 60, 50);
        sentence2Elementary.add(w6pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos2.setBounds(600, 130, 60, 50);
        sentence2Elementary.add(w7pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos2.setBounds(20, 220, 60, 50);
        sentence2Elementary.add(w8pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos2.setBounds(130, 220, 60, 50);
        sentence2Elementary.add(w9pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos2.setBounds(220, 220, 60, 50);
        sentence2Elementary.add(w10pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos2.setBounds(280, 220, 60, 50);
        sentence2Elementary.add(w11pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos2.setBounds(370, 220, 60, 50);
        sentence2Elementary.add(w12pos2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence2Elementary.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence2Elementary, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl3.setText("Dragon");
        w1Lbl3.setBounds(20, 80, 140, 50);
        sentence3Elementary.add(w1Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl3.setText("ran");
        w2Lbl3.setBounds(170, 80, 70, 50);
        sentence3Elementary.add(w2Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl3.setText("into");
        w3Lbl3.setBounds(240, 80, 70, 50);
        sentence3Elementary.add(w3Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl3.setText("his");
        w4Lbl3.setBounds(320, 80, 50, 50);
        sentence3Elementary.add(w4Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl3.setText("house");
        w5Lbl3.setBounds(390, 80, 110, 50);
        sentence3Elementary.add(w5Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl3.setText("and");
        w6Lbl3.setBounds(510, 80, 70, 50);
        sentence3Elementary.add(w6Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl3.setText("hid");
        w7Lbl3.setBounds(600, 80, 60, 50);
        sentence3Elementary.add(w7Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl3.setText("under");
        w8Lbl3.setBounds(20, 170, 110, 50);
        sentence3Elementary.add(w8Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl3.setText("the");
        w9Lbl3.setBounds(140, 170, 60, 50);
        sentence3Elementary.add(w9Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl3.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl3.setText("bed.");
        w10Lbl3.setBounds(210, 170, 80, 50);
        sentence3Elementary.add(w10Lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos3.setBounds(60, 130, 60, 50);
        sentence3Elementary.add(w1pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos3.setBounds(170, 130, 60, 50);
        sentence3Elementary.add(w2pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos3.setBounds(240, 130, 60, 50);
        sentence3Elementary.add(w3pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos3.setBounds(320, 130, 60, 50);
        sentence3Elementary.add(w4pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos3.setBounds(410, 130, 60, 50);
        sentence3Elementary.add(w5pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos3.setBounds(510, 130, 60, 50);
        sentence3Elementary.add(w6pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos3.setBounds(600, 130, 60, 50);
        sentence3Elementary.add(w7pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos3.setBounds(40, 220, 60, 50);
        sentence3Elementary.add(w8pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos3.setBounds(140, 220, 60, 50);
        sentence3Elementary.add(w9pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos3.setBounds(210, 220, 60, 50);
        sentence3Elementary.add(w10pos3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence3Elementary.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence3Elementary, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl4.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl4.setText("The");
        w1Lbl4.setBounds(20, 80, 70, 50);
        sentence4Elementary.add(w1Lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl4.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl4.setText("fox");
        w2Lbl4.setBounds(100, 80, 80, 50);
        sentence4Elementary.add(w2Lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl4.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl4.setText("and");
        w3Lbl4.setBounds(180, 80, 70, 50);
        sentence4Elementary.add(w3Lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl4.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl4.setText("the");
        w4Lbl4.setBounds(260, 80, 60, 50);
        sentence4Elementary.add(w4Lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl4.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl4.setText("crocodile");
        w5Lbl4.setBounds(330, 80, 170, 50);
        sentence4Elementary.add(w5Lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl4.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl4.setText("stopped");
        w6Lbl4.setBounds(510, 80, 150, 50);
        sentence4Elementary.add(w6Lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl4.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl4.setText("laughing.");
        w7Lbl4.setBounds(20, 180, 170, 50);
        sentence4Elementary.add(w7Lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos4.setBounds(20, 130, 60, 50);
        sentence4Elementary.add(w1pos4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos4.setBounds(100, 130, 60, 50);
        sentence4Elementary.add(w2pos4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos4.setBounds(180, 130, 60, 50);
        sentence4Elementary.add(w3pos4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos4.setBounds(260, 130, 60, 50);
        sentence4Elementary.add(w4pos4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos4.setBounds(370, 130, 60, 50);
        sentence4Elementary.add(w5pos4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos4.setBounds(560, 130, 60, 50);
        sentence4Elementary.add(w6pos4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos4.setBounds(60, 240, 60, 50);
        sentence4Elementary.add(w7pos4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence4Elementary.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence4Elementary, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl5.setText("Harry");
        w1Lbl5.setBounds(10, 60, 100, 50);
        sentence5Middle.add(w1Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl5.setText("and");
        w2Lbl5.setBounds(120, 60, 80, 50);
        sentence5Middle.add(w2Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl5.setText("I");
        w3Lbl5.setBounds(210, 60, 20, 50);
        sentence5Middle.add(w3Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl5.setText("crept");
        w4Lbl5.setBounds(240, 60, 100, 50);
        sentence5Middle.add(w4Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl5.setText("to");
        w5Lbl5.setBounds(350, 60, 40, 50);
        sentence5Middle.add(w5Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl5.setText("Sam's");
        w6Lbl5.setBounds(400, 60, 110, 50);
        sentence5Middle.add(w6Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl5.setText("knees,");
        w7Lbl5.setBounds(520, 60, 120, 50);
        sentence5Middle.add(w7Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl5.setText("in");
        w8Lbl5.setBounds(640, 60, 40, 50);
        sentence5Middle.add(w8Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl5.setText("the");
        w9Lbl5.setBounds(10, 150, 60, 50);
        sentence5Middle.add(w9Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl5.setText("glow");
        w10Lbl5.setBounds(80, 150, 90, 50);
        sentence5Middle.add(w10Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl5.setText("of");
        w11Lbl5.setBounds(180, 150, 50, 50);
        sentence5Middle.add(w11Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl5.setText("the");
        w12Lbl5.setBounds(230, 150, 60, 50);
        sentence5Middle.add(w12Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w13Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w13Lbl5.setText("bright");
        w13Lbl5.setBounds(300, 150, 110, 50);
        sentence5Middle.add(w13Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w14Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w14Lbl5.setText("evening");
        w14Lbl5.setBounds(420, 150, 140, 50);
        sentence5Middle.add(w14Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w15Lbl5.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w15Lbl5.setText("firelight.");
        w15Lbl5.setBounds(10, 240, 160, 50);
        sentence5Middle.add(w15Lbl5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos5.setBounds(30, 110, 60, 50);
        sentence5Middle.add(w1pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos5.setBounds(120, 110, 60, 50);
        sentence5Middle.add(w2pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos5.setBounds(190, 110, 60, 50);
        sentence5Middle.add(w3pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos5.setBounds(260, 110, 60, 50);
        sentence5Middle.add(w4pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos5.setBounds(340, 110, 60, 50);
        sentence5Middle.add(w5pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos5.setBounds(420, 110, 60, 50);
        sentence5Middle.add(w6pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos5.setBounds(540, 110, 60, 50);
        sentence5Middle.add(w7pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos5.setBounds(630, 110, 60, 50);
        sentence5Middle.add(w8pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos5.setBounds(10, 200, 60, 50);
        sentence5Middle.add(w9pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos5.setBounds(90, 200, 60, 50);
        sentence5Middle.add(w10pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos5.setBounds(170, 200, 60, 50);
        sentence5Middle.add(w11pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos5.setBounds(230, 200, 60, 50);
        sentence5Middle.add(w12pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w13pos5.setBounds(320, 200, 60, 50);
        sentence5Middle.add(w13pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w14pos5.setBounds(460, 200, 60, 50);
        sentence5Middle.add(w14pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w15pos5.setBounds(40, 290, 60, 50);
        sentence5Middle.add(w15pos5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence5Middle.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence5Middle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl6.setText("In");
        w1Lbl6.setBounds(20, 60, 40, 50);
        sentence6Middle.add(w1Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl6.setText("those");
        w2Lbl6.setBounds(70, 60, 110, 50);
        sentence6Middle.add(w2Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl6.setText("days");
        w3Lbl6.setBounds(180, 60, 90, 50);
        sentence6Middle.add(w3Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl6.setText("we");
        w4Lbl6.setBounds(280, 60, 50, 50);
        sentence6Middle.add(w4Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl6.setText("had");
        w5Lbl6.setBounds(350, 60, 70, 50);
        sentence6Middle.add(w5Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl6.setText("no");
        w6Lbl6.setBounds(430, 60, 50, 50);
        sentence6Middle.add(w6Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl6.setText("magazines");
        w7Lbl6.setBounds(490, 60, 200, 50);
        sentence6Middle.add(w7Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl6.setText("and");
        w8Lbl6.setBounds(20, 150, 80, 50);
        sentence6Middle.add(w8Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl6.setText("daily");
        w9Lbl6.setBounds(100, 150, 110, 50);
        sentence6Middle.add(w9Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl6.setText("papers,");
        w10Lbl6.setBounds(200, 150, 140, 50);
        sentence6Middle.add(w10Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl6.setText("each");
        w11Lbl6.setBounds(340, 150, 90, 50);
        sentence6Middle.add(w11Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl6.setText("reeling");
        w12Lbl6.setBounds(440, 150, 120, 50);
        sentence6Middle.add(w12Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w13Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w13Lbl6.setText("off");
        w13Lbl6.setBounds(580, 150, 60, 50);
        sentence6Middle.add(w13Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w14Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w14Lbl6.setText("a");
        w14Lbl6.setBounds(650, 150, 40, 50);
        sentence6Middle.add(w14Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w15Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w15Lbl6.setText("serial");
        w15Lbl6.setBounds(20, 240, 100, 50);
        sentence6Middle.add(w15Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w16Lbl6.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w16Lbl6.setText("story.");
        w16Lbl6.setBounds(130, 240, 110, 50);
        sentence6Middle.add(w16Lbl6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos6.setBounds(10, 110, 60, 50);
        sentence6Middle.add(w1pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos6.setBounds(90, 110, 60, 50);
        sentence6Middle.add(w2pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos6.setBounds(190, 110, 60, 50);
        sentence6Middle.add(w3pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos6.setBounds(280, 110, 60, 50);
        sentence6Middle.add(w4pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos6.setBounds(350, 110, 60, 50);
        sentence6Middle.add(w5pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos6.setBounds(420, 110, 60, 50);
        sentence6Middle.add(w6pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos6.setBounds(550, 110, 60, 50);
        sentence6Middle.add(w7pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos6.setBounds(20, 200, 60, 50);
        sentence6Middle.add(w8pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos6.setBounds(110, 200, 60, 50);
        sentence6Middle.add(w9pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos6.setBounds(230, 200, 60, 50);
        sentence6Middle.add(w10pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos6.setBounds(350, 200, 60, 50);
        sentence6Middle.add(w11pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos6.setBounds(470, 200, 60, 50);
        sentence6Middle.add(w12pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w13pos6.setBounds(570, 200, 60, 50);
        sentence6Middle.add(w13pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w14pos6.setBounds(630, 200, 60, 50);
        sentence6Middle.add(w14pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w15pos6.setBounds(40, 290, 60, 50);
        sentence6Middle.add(w15pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w16pos6.setBounds(140, 290, 60, 50);
        sentence6Middle.add(w16pos6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence6Middle.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence6Middle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl7.setText("The");
        w1Lbl7.setBounds(20, 60, 80, 50);
        sentence7Middle.add(w1Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl7.setText("Columbian");
        w2Lbl7.setBounds(110, 60, 200, 50);
        sentence7Middle.add(w2Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl7.setText("Sentinel");
        w3Lbl7.setBounds(320, 60, 150, 50);
        sentence7Middle.add(w3Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl7.setText("came");
        w4Lbl7.setBounds(480, 60, 100, 50);
        sentence7Middle.add(w4Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl7.setText("from");
        w5Lbl7.setBounds(590, 60, 90, 50);
        sentence7Middle.add(w5Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl7.setText("Boston");
        w6Lbl7.setBounds(20, 150, 130, 50);
        sentence7Middle.add(w6Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl7.setText("with");
        w7Lbl7.setBounds(160, 150, 80, 50);
        sentence7Middle.add(w7Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl7.setText("its");
        w8Lbl7.setBounds(250, 150, 50, 50);
        sentence7Middle.add(w8Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl7.setText("slender");
        w9Lbl7.setBounds(310, 150, 140, 50);
        sentence7Middle.add(w9Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl7.setText("stock");
        w10Lbl7.setBounds(460, 150, 100, 50);
        sentence7Middle.add(w10Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl7.setText("of");
        w11Lbl7.setBounds(570, 150, 50, 50);
        sentence7Middle.add(w11Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl7.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl7.setText("news.");
        w12Lbl7.setBounds(20, 240, 110, 50);
        sentence7Middle.add(w12Lbl7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos7.setBounds(30, 110, 60, 50);
        sentence7Middle.add(w1pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos7.setBounds(140, 110, 60, 50);
        sentence7Middle.add(w2pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos7.setBounds(360, 110, 60, 50);
        sentence7Middle.add(w3pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos7.setBounds(500, 110, 60, 50);
        sentence7Middle.add(w4pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos7.setBounds(600, 110, 60, 50);
        sentence7Middle.add(w5pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos7.setBounds(50, 200, 60, 50);
        sentence7Middle.add(w6pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos7.setBounds(170, 200, 60, 50);
        sentence7Middle.add(w7pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos7.setBounds(240, 200, 60, 50);
        sentence7Middle.add(w8pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos7.setBounds(340, 200, 60, 50);
        sentence7Middle.add(w9pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos7.setBounds(480, 200, 60, 50);
        sentence7Middle.add(w10pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos7.setBounds(560, 200, 60, 50);
        sentence7Middle.add(w11pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos7.setBounds(30, 290, 60, 50);
        sentence7Middle.add(w12pos7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence7Middle.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence7Middle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl8.setText("Society");
        w1Lbl8.setBounds(20, 50, 130, 50);
        sentence8Middle.add(w1Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl8.setText("then");
        w2Lbl8.setBounds(160, 50, 80, 50);
        sentence8Middle.add(w2Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl8.setText("was");
        w3Lbl8.setBounds(260, 50, 70, 50);
        sentence8Middle.add(w3Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl8.setText("full");
        w4Lbl8.setBounds(340, 50, 60, 50);
        sentence8Middle.add(w4Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl8.setText("of");
        w5Lbl8.setBounds(420, 50, 50, 50);
        sentence8Middle.add(w5Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl8.setText("traditions");
        w6Lbl8.setBounds(480, 50, 180, 50);
        sentence8Middle.add(w6Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl8.setText("and");
        w7Lbl8.setBounds(20, 150, 80, 50);
        sentence8Middle.add(w7Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl8.setText("narratives");
        w8Lbl8.setBounds(110, 150, 180, 50);
        sentence8Middle.add(w8Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl8.setText("which");
        w9Lbl8.setBounds(300, 150, 110, 50);
        sentence8Middle.add(w9Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl8.setText("had");
        w10Lbl8.setBounds(420, 150, 70, 50);
        sentence8Middle.add(w10Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl8.setText("all");
        w11Lbl8.setBounds(510, 150, 50, 50);
        sentence8Middle.add(w11Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl8.setText("the");
        w12Lbl8.setBounds(570, 150, 70, 50);
        sentence8Middle.add(w12Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w13Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w13Lbl8.setText("uncertain");
        w13Lbl8.setBounds(20, 240, 170, 50);
        sentence8Middle.add(w13Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w14Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w14Lbl8.setText("glow");
        w14Lbl8.setBounds(200, 240, 90, 50);
        sentence8Middle.add(w14Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w15Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w15Lbl8.setText("of");
        w15Lbl8.setBounds(310, 240, 50, 50);
        sentence8Middle.add(w15Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w16Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w16Lbl8.setText("the");
        w16Lbl8.setBounds(370, 240, 70, 50);
        sentence8Middle.add(w16Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w17Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w17Lbl8.setText("fire-lit");
        w17Lbl8.setBounds(440, 240, 120, 50);
        sentence8Middle.add(w17Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w18Lbl8.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w18Lbl8.setText("hearth.");
        w18Lbl8.setBounds(570, 240, 130, 50);
        sentence8Middle.add(w18Lbl8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos8.setBounds(50, 100, 60, 50);
        sentence8Middle.add(w1pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos8.setBounds(170, 100, 60, 50);
        sentence8Middle.add(w2pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos8.setBounds(260, 100, 60, 50);
        sentence8Middle.add(w3pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos8.setBounds(340, 100, 60, 50);
        sentence8Middle.add(w4pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos8.setBounds(410, 100, 60, 50);
        sentence8Middle.add(w5pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos8.setBounds(520, 100, 60, 50);
        sentence8Middle.add(w6pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w18pos8.setBounds(600, 290, 60, 50);
        sentence8Middle.add(w18pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos8.setBounds(20, 200, 60, 50);
        sentence8Middle.add(w7pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos8.setBounds(160, 200, 60, 50);
        sentence8Middle.add(w8pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos8.setBounds(320, 200, 60, 50);
        sentence8Middle.add(w9pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos8.setBounds(420, 200, 60, 50);
        sentence8Middle.add(w10pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos8.setBounds(500, 200, 60, 50);
        sentence8Middle.add(w11pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos8.setBounds(570, 200, 60, 50);
        sentence8Middle.add(w12pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w13pos8.setBounds(70, 290, 60, 50);
        sentence8Middle.add(w13pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w14pos8.setBounds(210, 290, 60, 50);
        sentence8Middle.add(w14pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w15pos8.setBounds(300, 290, 60, 50);
        sentence8Middle.add(w15pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w16pos8.setBounds(370, 290, 60, 50);
        sentence8Middle.add(w16pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w17pos8.setBounds(470, 290, 60, 50);
        sentence8Middle.add(w17pos8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence8Middle.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence8Middle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl9.setText("This");
        w1Lbl9.setBounds(20, 60, 80, 50);
        sentence9High.add(w1Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl9.setText("trouble");
        w2Lbl9.setBounds(120, 60, 140, 50);
        sentence9High.add(w2Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl9.setText("pleased");
        w3Lbl9.setBounds(270, 60, 140, 50);
        sentence9High.add(w3Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl9.setText("her,");
        w4Lbl9.setBounds(420, 60, 70, 50);
        sentence9High.add(w4Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl9.setText("and");
        w5Lbl9.setBounds(500, 60, 80, 50);
        sentence9High.add(w5Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl9.setText("later");
        w6Lbl9.setBounds(580, 60, 90, 50);
        sentence9High.add(w6Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl9.setText("she");
        w7Lbl9.setBounds(20, 150, 70, 50);
        sentence9High.add(w7Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl9.setText("made");
        w8Lbl9.setBounds(110, 150, 110, 50);
        sentence9High.add(w8Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl9.setText("use");
        w9Lbl9.setBounds(230, 150, 60, 50);
        sentence9High.add(w9Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl9.setText("of");
        w10Lbl9.setBounds(310, 150, 40, 50);
        sentence9High.add(w10Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl9.setText("it");
        w11Lbl9.setBounds(380, 150, 30, 50);
        sentence9High.add(w11Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl9.setText("as");
        w12Lbl9.setBounds(430, 150, 40, 50);
        sentence9High.add(w12Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w13Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w13Lbl9.setText("an");
        w13Lbl9.setBounds(490, 150, 50, 50);
        sentence9High.add(w13Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w14Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w14Lbl9.setText("intrinsic");
        w14Lbl9.setBounds(550, 150, 150, 50);
        sentence9High.add(w14Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w15Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w15Lbl9.setText("part");
        w15Lbl9.setBounds(20, 240, 80, 50);
        sentence9High.add(w15Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w16Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w16Lbl9.setText("of");
        w16Lbl9.setBounds(120, 240, 50, 50);
        sentence9High.add(w16Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w17Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w17Lbl9.setText("her");
        w17Lbl9.setBounds(180, 240, 70, 50);
        sentence9High.add(w17Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w18Lbl9.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w18Lbl9.setText("atmosphere.");
        w18Lbl9.setBounds(260, 240, 230, 50);
        sentence9High.add(w18Lbl9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos9.setBounds(30, 110, 60, 50);
        sentence9High.add(w1pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos9.setBounds(150, 110, 60, 50);
        sentence9High.add(w2pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos9.setBounds(310, 110, 60, 50);
        sentence9High.add(w3pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos9.setBounds(420, 110, 60, 50);
        sentence9High.add(w4pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos9.setBounds(500, 110, 60, 50);
        sentence9High.add(w5pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos9.setBounds(590, 110, 60, 50);
        sentence9High.add(w6pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos9.setBounds(20, 200, 60, 50);
        sentence9High.add(w7pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos9.setBounds(130, 200, 60, 50);
        sentence9High.add(w8pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos9.setBounds(230, 200, 60, 50);
        sentence9High.add(w9pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos9.setBounds(300, 200, 60, 50);
        sentence9High.add(w10pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos9.setBounds(360, 200, 60, 50);
        sentence9High.add(w11pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos9.setBounds(420, 200, 60, 50);
        sentence9High.add(w12pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w13pos9.setBounds(480, 200, 60, 50);
        sentence9High.add(w13pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w14pos9.setBounds(590, 200, 60, 50);
        sentence9High.add(w14pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w15pos9.setBounds(30, 290, 60, 50);
        sentence9High.add(w15pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w16pos9.setBounds(110, 290, 60, 50);
        sentence9High.add(w16pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w17pos9.setBounds(180, 290, 60, 50);
        sentence9High.add(w17pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w18pos9.setBounds(330, 290, 60, 50);
        sentence9High.add(w18pos9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence9High.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence9High, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl10.setText("Frank,");
        w1Lbl10.setBounds(20, 60, 110, 50);
        sentence10High.add(w1Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl10.setText("a");
        w2Lbl10.setBounds(140, 60, 30, 50);
        sentence10High.add(w2Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl10.setText("bell-boy");
        w3Lbl10.setBounds(180, 60, 160, 50);
        sentence10High.add(w3Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl10.setText("in");
        w4Lbl10.setBounds(350, 60, 40, 50);
        sentence10High.add(w4Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl10.setText("Waldorf,");
        w5Lbl10.setBounds(400, 60, 150, 50);
        sentence10High.add(w5Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl10.setText("was");
        w6Lbl10.setBounds(570, 60, 80, 50);
        sentence10High.add(w6Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl10.setText("outgrowing");
        w7Lbl10.setBounds(20, 150, 210, 50);
        sentence10High.add(w7Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl10.setText("a");
        w8Lbl10.setBounds(240, 150, 30, 50);
        sentence10High.add(w8Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl10.setText("natural");
        w9Lbl10.setBounds(280, 150, 130, 50);
        sentence10High.add(w9Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl10.setText("repugnance");
        w10Lbl10.setBounds(430, 150, 210, 50);
        sentence10High.add(w10Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl10.setText("to");
        w11Lbl10.setBounds(20, 240, 50, 50);
        sentence10High.add(w11Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl10.setText("chamber");
        w12Lbl10.setBounds(80, 240, 160, 50);
        sentence10High.add(w12Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w13Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w13Lbl10.setText("music");
        w13Lbl10.setBounds(250, 240, 110, 50);
        sentence10High.add(w13Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w14Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w14Lbl10.setText("and");
        w14Lbl10.setBounds(370, 240, 70, 50);
        sentence10High.add(w14Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w15Lbl10.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w15Lbl10.setText("symphonies.");
        w15Lbl10.setBounds(450, 240, 230, 50);
        sentence10High.add(w15Lbl10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos10.setBounds(40, 110, 60, 50);
        sentence10High.add(w1pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos10.setBounds(120, 110, 60, 50);
        sentence10High.add(w2pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos10.setBounds(220, 110, 60, 50);
        sentence10High.add(w3pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos10.setBounds(340, 110, 60, 50);
        sentence10High.add(w4pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos10.setBounds(440, 110, 60, 50);
        sentence10High.add(w5pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos10.setBounds(570, 110, 60, 50);
        sentence10High.add(w6pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos10.setBounds(90, 200, 60, 50);
        sentence10High.add(w7pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos10.setBounds(220, 200, 60, 50);
        sentence10High.add(w8pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos10.setBounds(310, 200, 60, 50);
        sentence10High.add(w9pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos10.setBounds(500, 200, 60, 50);
        sentence10High.add(w10pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos10.setBounds(10, 290, 60, 50);
        sentence10High.add(w11pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos10.setBounds(120, 290, 60, 50);
        sentence10High.add(w12pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w13pos10.setBounds(270, 290, 60, 50);
        sentence10High.add(w13pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w14pos10.setBounds(370, 290, 60, 50);
        sentence10High.add(w14pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w15pos10.setBounds(520, 290, 60, 50);
        sentence10High.add(w15pos10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence10High.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence10High, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl11.setText("At");
        w1Lbl11.setBounds(20, 60, 50, 50);
        sentence11High.add(w1Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl11.setText("age");
        w2Lbl11.setBounds(80, 60, 70, 50);
        sentence11High.add(w2Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl11.setText("eleven");
        w3Lbl11.setBounds(160, 60, 120, 50);
        sentence11High.add(w3Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl11.setText("he");
        w4Lbl11.setBounds(290, 60, 50, 50);
        sentence11High.add(w4Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl11.setText("could");
        w5Lbl11.setBounds(350, 60, 110, 50);
        sentence11High.add(w5Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl11.setText("talk");
        w6Lbl11.setBounds(460, 60, 70, 50);
        sentence11High.add(w6Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl11.setText("glibly,");
        w7Lbl11.setBounds(540, 60, 110, 50);
        sentence11High.add(w7Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl11.setText("if");
        w8Lbl11.setBounds(30, 150, 40, 50);
        sentence11High.add(w8Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl11.setText("rather");
        w9Lbl11.setBounds(70, 150, 110, 50);
        sentence11High.add(w9Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl11.setText("reminiscently,");
        w10Lbl11.setBounds(200, 150, 250, 50);
        sentence11High.add(w10Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl11.setText("of");
        w11Lbl11.setBounds(450, 150, 50, 50);
        sentence11High.add(w11Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl11.setText("Brahms");
        w12Lbl11.setBounds(500, 150, 140, 50);
        sentence11High.add(w12Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w13Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w13Lbl11.setText("and");
        w13Lbl11.setBounds(20, 240, 70, 50);
        sentence11High.add(w13Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w14Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w14Lbl11.setText("Mozart");
        w14Lbl11.setBounds(100, 240, 130, 50);
        sentence11High.add(w14Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w15Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w15Lbl11.setText("and");
        w15Lbl11.setBounds(250, 240, 70, 50);
        sentence11High.add(w15Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w16Lbl11.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w16Lbl11.setText("Beethoven.");
        w16Lbl11.setBounds(340, 240, 200, 50);
        sentence11High.add(w16Lbl11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos11.setBounds(10, 110, 60, 50);
        sentence11High.add(w1pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos11.setBounds(80, 110, 60, 50);
        sentence11High.add(w2pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos11.setBounds(190, 110, 60, 50);
        sentence11High.add(w3pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos11.setBounds(280, 110, 60, 50);
        sentence11High.add(w4pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos11.setBounds(370, 110, 60, 50);
        sentence11High.add(w5pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos11.setBounds(460, 110, 60, 50);
        sentence11High.add(w6pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos11.setBounds(560, 110, 60, 50);
        sentence11High.add(w7pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos11.setBounds(10, 200, 60, 50);
        sentence11High.add(w8pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos11.setBounds(90, 200, 60, 50);
        sentence11High.add(w9pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos11.setBounds(280, 200, 60, 50);
        sentence11High.add(w10pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos11.setBounds(440, 200, 60, 50);
        sentence11High.add(w11pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos11.setBounds(530, 200, 60, 50);
        sentence11High.add(w12pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w13pos11.setBounds(20, 290, 60, 50);
        sentence11High.add(w13pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w14pos11.setBounds(130, 290, 60, 50);
        sentence11High.add(w14pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w15pos11.setBounds(250, 290, 60, 50);
        sentence11High.add(w15pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w16pos11.setBounds(400, 290, 60, 50);
        sentence11High.add(w16pos11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence11High.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence11High, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w1Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w1Lbl12.setText("This");
        w1Lbl12.setBounds(20, 50, 80, 50);
        sentence12High.add(w1Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w2Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w2Lbl12.setText("was");
        w2Lbl12.setBounds(110, 50, 70, 50);
        sentence12High.add(w2Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w3Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w3Lbl12.setText("fun");
        w3Lbl12.setBounds(200, 50, 60, 50);
        sentence12High.add(w3Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w4Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w4Lbl12.setText("for");
        w4Lbl12.setBounds(280, 50, 60, 50);
        sentence12High.add(w4Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w5Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w5Lbl12.setText("a");
        w5Lbl12.setBounds(350, 50, 30, 50);
        sentence12High.add(w5Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w6Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w6Lbl12.setText("while,");
        w6Lbl12.setBounds(390, 50, 110, 50);
        sentence12High.add(w6Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w7Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w7Lbl12.setText("but");
        w7Lbl12.setBounds(510, 50, 60, 50);
        sentence12High.add(w7Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w8Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w8Lbl12.setText("he");
        w8Lbl12.setBounds(590, 50, 50, 50);
        sentence12High.add(w8Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w9Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w9Lbl12.setText("essayed");
        w9Lbl12.setBounds(20, 150, 150, 50);
        sentence12High.add(w9Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w10Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w10Lbl12.setText("a");
        w10Lbl12.setBounds(180, 150, 40, 50);
        sentence12High.add(w10Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w11Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w11Lbl12.setText("cigarette");
        w11Lbl12.setBounds(220, 150, 160, 50);
        sentence12High.add(w11Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w12Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w12Lbl12.setText("in");
        w12Lbl12.setBounds(390, 150, 40, 50);
        sentence12High.add(w12Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w13Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w13Lbl12.setText("his");
        w13Lbl12.setBounds(440, 150, 60, 50);
        sentence12High.add(w13Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w14Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w14Lbl12.setText("exaltation,");
        w14Lbl12.setBounds(510, 150, 190, 50);
        sentence12High.add(w14Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w15Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w15Lbl12.setText("and");
        w15Lbl12.setBounds(20, 240, 70, 50);
        sentence12High.add(w15Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w16Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w16Lbl12.setText("succumbed");
        w16Lbl12.setBounds(100, 240, 200, 50);
        sentence12High.add(w16Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w17Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w17Lbl12.setText("to");
        w17Lbl12.setBounds(320, 240, 40, 50);
        sentence12High.add(w17Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w18Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w18Lbl12.setText("a");
        w18Lbl12.setBounds(390, 240, 30, 50);
        sentence12High.add(w18Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w19Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w19Lbl12.setText("vulgar");
        w19Lbl12.setBounds(430, 240, 120, 50);
        sentence12High.add(w19Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        w20Lbl12.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        w20Lbl12.setText("reply.");
        w20Lbl12.setBounds(570, 240, 100, 50);
        sentence12High.add(w20Lbl12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w1pos12.setBounds(30, 100, 60, 50);
        sentence12High.add(w1pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w2pos12.setBounds(110, 100, 60, 50);
        sentence12High.add(w2pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w3pos12.setBounds(200, 100, 60, 50);
        sentence12High.add(w3pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w4pos12.setBounds(270, 100, 60, 50);
        sentence12High.add(w4pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w5pos12.setBounds(330, 100, 60, 50);
        sentence12High.add(w5pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w6pos12.setBounds(410, 100, 60, 50);
        sentence12High.add(w6pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w7pos12.setBounds(510, 100, 60, 50);
        sentence12High.add(w7pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w8pos12.setBounds(580, 100, 60, 50);
        sentence12High.add(w8pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w9pos12.setBounds(60, 200, 60, 50);
        sentence12High.add(w9pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w10pos12.setBounds(160, 200, 60, 50);
        sentence12High.add(w10pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w11pos12.setBounds(260, 200, 60, 50);
        sentence12High.add(w11pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w12pos12.setBounds(380, 200, 60, 50);
        sentence12High.add(w12pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w13pos12.setBounds(440, 200, 60, 50);
        sentence12High.add(w13pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w14pos12.setBounds(560, 200, 60, 50);
        sentence12High.add(w14pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w15pos12.setBounds(20, 290, 60, 50);
        sentence12High.add(w15pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w16pos12.setBounds(170, 290, 60, 50);
        sentence12High.add(w16pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w17pos12.setBounds(310, 290, 60, 50);
        sentence12High.add(w17pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w18pos12.setBounds(370, 290, 60, 50);
        sentence12High.add(w18pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w19pos12.setBounds(450, 290, 60, 50);
        sentence12High.add(w19pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        w20pos12.setBounds(590, 290, 60, 50);
        sentence12High.add(w20pos12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sentence12High.setBounds(70, 120, 700, 340);
        gameboardLP.add(sentence12High, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/clock.jpg"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setBounds(360, 70, 30, 30);
        gameboardLP.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        scoreLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scoreLbl.setText("Score: 0");
        scoreLbl.setBounds(675, 10, 150, 30);
        gameboardLP.add(scoreLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(gameboardLP, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(gameboardLP, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adverbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adverbBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("adverb");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("adverb");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("adverb");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
            }
        }
    }//GEN-LAST:event_adverbBtnActionPerformed

    private void verbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verbBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("verb");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("verb");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("verb");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
            }
        }

    }//GEN-LAST:event_verbBtnActionPerformed

    private void pronounBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pronounBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("pronoun");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("pronoun");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("pronoun");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }

                    break;
            }
        }
    }//GEN-LAST:event_pronounBtnActionPerformed

    private void adjectiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjectiveBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("adjective");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("adjective");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("adjective");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
            }
        }
    }//GEN-LAST:event_adjectiveBtnActionPerformed

    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed
        // TODO add your handling code here:
        //sentence1Elementary.setVisible(false);
        //sentence2Elementary.setVisible(true);

        switch (this.player.gradeLevel){
            case ELEMENTARY:
                if(currentSentence < Elementary.sentence.length-1){
                    Elementary.sentence[currentSentence].sentenceLP.setVisible(false);
                    currentSentence++;
                    currentWord = 0;
                    Elementary.sentence[currentSentence].sentenceLP.setVisible(true);
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    continueBtn.setVisible(false);
                    //gameTimer.t.stop();
                    //gameTimer.pauseGame(5); // pauseGame(x) - Pause the game for x seconds

                    gameTimer.minutes+=gameTimer.DEFAULT_TIME_PER_SENTENCE;
                    gameTimer.t.restart();

                } else {
                    gameTimer.t.stop();
                    if(player.bonusPoints>=3){
                       //loadBonusStage();
                        BonusStage myBonusStage = new BonusStage(player, Elementary.sentence);
                        myBonusStage.setLocationRelativeTo(null);
                        myBonusStage.setVisible(true);

                        this.dispose();
                    } else {
                        // Game Over
                        Results myResults = new Results(player, Elementary.sentence);
                        myResults.setLocationRelativeTo(null);
                        myResults.setVisible(true);

                        this.dispose();
                    }
                }
                break;

            case MIDDLE:
                if(currentSentence < Middle.sentence.length-1){
                    Middle.sentence[currentSentence].sentenceLP.setVisible(false);
                    currentSentence++;
                    currentWord = 0;
                    Middle.sentence[currentSentence].sentenceLP.setVisible(true);
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    continueBtn.setVisible(false);

                    //gameTimer.pauseGame(5); // pauseGame(x) - Pause the game for x seconds

                    gameTimer.minutes+=gameTimer.DEFAULT_TIME_PER_SENTENCE;
                    gameTimer.t.restart();
                } else {
                    gameTimer.t.stop();
                    if(player.bonusPoints>=3){
                       //loadBonusStage();
                        BonusStage myBonusStage = new BonusStage(player, Middle.sentence);
                        myBonusStage.setLocationRelativeTo(null);
                        myBonusStage.setVisible(true);

                        this.dispose();
                    } else {
                        //Game Over
                        Results myResults = new Results(player, Middle.sentence);
                        myResults.setLocationRelativeTo(null);
                        myResults.setVisible(true);

                        this.dispose();
                    }
                }
                break;

            case HIGH:
                if(currentSentence < High.sentence.length-1){
                    gameTimer.t.stop();
                    //gameTimer.pauseGame(5); // pauseGame(x) - Pause the game for x seconds

                    gameTimer.minutes+=gameTimer.DEFAULT_TIME_PER_SENTENCE;
                    gameTimer.t.start();

                    High.sentence[currentSentence].sentenceLP.setVisible(false);
                    currentSentence++;
                    currentWord = 0;
                    High.sentence[currentSentence].sentenceLP.setVisible(true);
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    continueBtn.setVisible(false);
                } else {
                    gameTimer.t.stop();
                    if(player.bonusPoints>=3){
                       //loadBonusStage();
                        BonusStage myBonusStage = new BonusStage(player, High.sentence);
                        myBonusStage.setLocationRelativeTo(null);
                        myBonusStage.setVisible(true);

                        this.dispose();
                    } else {
                        // Game Over
                        Results myResults = new Results(player, High.sentence);
                        myResults.setLocationRelativeTo(null);
                        myResults.setVisible(true);

                        this.dispose();
                    }
                }
                break;
        }

    }//GEN-LAST:event_continueBtnActionPerformed

    private void articleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articleBtnActionPerformed
        // TODO add your handling code here:
        //if(gameTimer.)
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("article");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("article");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:

                    High.sentence[currentSentence].word[currentWord].setPlayerAns("article");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {

                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }

                        //gameTimer.pauseGame(5); // pauseGame(x) - Pause the game for x seconds
                    break;
            }
        }

    }//GEN-LAST:event_articleBtnActionPerformed

    private void nounBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nounBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("noun");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("noun");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("noun");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
            }
        }
    }//GEN-LAST:event_nounBtnActionPerformed

    private void prepositionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prepositionBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("preposition");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("preposition");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("preposition");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
            }
        }

    }//GEN-LAST:event_prepositionBtnActionPerformed

    private void conjunctionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conjunctionBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("conjunction");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("conjunction");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("conjunction");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
            }
        }
    }//GEN-LAST:event_conjunctionBtnActionPerformed

    private void interjectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interjectionBtnActionPerformed
        // TODO add your handling code here:
        // Set current word answer to pos selected
        if ((gameTimer.minutes > 0 || gameTimer.seconds > 0) && gameTimer.t.isRunning()) {
            switch (player.gradeLevel){
                case ELEMENTARY:
                    Elementary.sentence[currentSentence].word[currentWord].setPlayerAns("interjection");

                    // Remove word highlight
                    Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Elementary.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Elementary.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case MIDDLE:
                    Middle.sentence[currentSentence].word[currentWord].setPlayerAns("interjection");

                    // Remove word highlight
                    Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        Middle.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        Middle.sentence[currentSentence].gradeSentence(scoreLbl, player);
                        gameTimer.t.stop();
                    }
                    break;
                case HIGH:
                    High.sentence[currentSentence].word[currentWord].setPlayerAns("interjection");

                    // Remove word highlight
                    High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(java.awt.Color.BLACK);
                    // Check for next word to highlight. If all words answers make continue
                    // button visible
                    if(this.nextUnansweredWordFound(player)){
                        High.sentence[currentSentence].word[currentWord].wordLbl.setForeground(BLUE);
                    } else {
                        this.continueBtn.setVisible(true);
                        High.sentence[currentSentence].gradeSentence(scoreLbl, player);

                        gameTimer.t.stop();
                    }
                    break;
            }
        }
    }//GEN-LAST:event_interjectionBtnActionPerformed

    private boolean nextUnansweredWordFound(Player p){
        boolean newWordFound = false;
        switch (p.gradeLevel){
            case ELEMENTARY:
                for(int i=0; i<Elementary.sentence[currentSentence].word.length; i++){
                   if(Elementary.sentence[currentSentence].word[i].players_ans==null){
                       currentWord = i;
                       newWordFound = true;
                       break;
                   }
                }
                break;

            case MIDDLE:
                for(int i=0; i<Middle.sentence[currentSentence].word.length; i++){
                   if(Middle.sentence[currentSentence].word[i].players_ans==null){
                       currentWord = i;
                       newWordFound = true;
                       break;
                   }
                }
                break;

            case HIGH:
                for(int i=0; i<High.sentence[currentSentence].word.length; i++){
                   if(High.sentence[currentSentence].word[i].players_ans==null){
                       currentWord = i;
                       newWordFound = true;
                       break;
                   }
                }
                break;

        }
        return newWordFound;
    }

    /*
     * Bonus Stage Loader
     */
    public void loadBonusStage(){
        switch (player.gradeLevel){
            case ELEMENTARY:
                BonusStage myBonusStage = new BonusStage(player, Elementary.sentence);
                myBonusStage.setLocationRelativeTo(null);
                myBonusStage.setVisible(true);
                break;
            case MIDDLE:
                BonusStage myBonusStage1 = new BonusStage(player, Middle.sentence);
                myBonusStage1.setLocationRelativeTo(null);
                myBonusStage1.setVisible(true);
                break;
            case HIGH:
                BonusStage myBonusStage2 = new BonusStage(player, High.sentence);
                myBonusStage2.setLocationRelativeTo(null);
                myBonusStage2.setVisible(true);
                break;
        }

        this.dispose();
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameBoard().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SpeedGramBtn;
    private javax.swing.JButton adjectiveBtn;
    private javax.swing.JButton adverbBtn;
    private javax.swing.JButton articleBtn;
    private javax.swing.JButton conjunctionBtn;
    private javax.swing.JButton continueBtn;
    private javax.swing.JLayeredPane gameboardLP;
    private javax.swing.JButton interjectionBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nounBtn;
    private javax.swing.JButton prepositionBtn;
    private javax.swing.JButton pronounBtn;
    private javax.swing.JLabel scoreLbl;
    private javax.swing.JLayeredPane sentence10High;
    private javax.swing.JLayeredPane sentence11High;
    private javax.swing.JLayeredPane sentence12High;
    private javax.swing.JLayeredPane sentence1Elementary;
    private javax.swing.JLayeredPane sentence2Elementary;
    private javax.swing.JLayeredPane sentence3Elementary;
    private javax.swing.JLayeredPane sentence4Elementary;
    private javax.swing.JLayeredPane sentence5Middle;
    private javax.swing.JLayeredPane sentence6Middle;
    private javax.swing.JLayeredPane sentence7Middle;
    private javax.swing.JLayeredPane sentence8Middle;
    private javax.swing.JLayeredPane sentence9High;
    private javax.swing.JLabel timerLbl;
    private javax.swing.JLabel toolBarLbl;
    private javax.swing.JButton verbBtn;
    private javax.swing.JLabel w10Lbl1;
    private javax.swing.JLabel w10Lbl10;
    private javax.swing.JLabel w10Lbl11;
    private javax.swing.JLabel w10Lbl12;
    private javax.swing.JLabel w10Lbl2;
    private javax.swing.JLabel w10Lbl3;
    private javax.swing.JLabel w10Lbl5;
    private javax.swing.JLabel w10Lbl6;
    private javax.swing.JLabel w10Lbl7;
    private javax.swing.JLabel w10Lbl8;
    private javax.swing.JLabel w10Lbl9;
    private javax.swing.JLabel w10pos1;
    private javax.swing.JLabel w10pos10;
    private javax.swing.JLabel w10pos11;
    private javax.swing.JLabel w10pos12;
    private javax.swing.JLabel w10pos2;
    private javax.swing.JLabel w10pos3;
    private javax.swing.JLabel w10pos5;
    private javax.swing.JLabel w10pos6;
    private javax.swing.JLabel w10pos7;
    private javax.swing.JLabel w10pos8;
    private javax.swing.JLabel w10pos9;
    private javax.swing.JLabel w11Lbl1;
    private javax.swing.JLabel w11Lbl10;
    private javax.swing.JLabel w11Lbl11;
    private javax.swing.JLabel w11Lbl12;
    private javax.swing.JLabel w11Lbl2;
    private javax.swing.JLabel w11Lbl5;
    private javax.swing.JLabel w11Lbl6;
    private javax.swing.JLabel w11Lbl7;
    private javax.swing.JLabel w11Lbl8;
    private javax.swing.JLabel w11Lbl9;
    private javax.swing.JLabel w11pos1;
    private javax.swing.JLabel w11pos10;
    private javax.swing.JLabel w11pos11;
    private javax.swing.JLabel w11pos12;
    private javax.swing.JLabel w11pos2;
    private javax.swing.JLabel w11pos5;
    private javax.swing.JLabel w11pos6;
    private javax.swing.JLabel w11pos7;
    private javax.swing.JLabel w11pos8;
    private javax.swing.JLabel w11pos9;
    private javax.swing.JLabel w12Lbl10;
    private javax.swing.JLabel w12Lbl11;
    private javax.swing.JLabel w12Lbl12;
    private javax.swing.JLabel w12Lbl2;
    private javax.swing.JLabel w12Lbl5;
    private javax.swing.JLabel w12Lbl6;
    private javax.swing.JLabel w12Lbl7;
    private javax.swing.JLabel w12Lbl8;
    private javax.swing.JLabel w12Lbl9;
    private javax.swing.JLabel w12pos10;
    private javax.swing.JLabel w12pos11;
    private javax.swing.JLabel w12pos12;
    private javax.swing.JLabel w12pos2;
    private javax.swing.JLabel w12pos5;
    private javax.swing.JLabel w12pos6;
    private javax.swing.JLabel w12pos7;
    private javax.swing.JLabel w12pos8;
    private javax.swing.JLabel w12pos9;
    private javax.swing.JLabel w13Lbl10;
    private javax.swing.JLabel w13Lbl11;
    private javax.swing.JLabel w13Lbl12;
    private javax.swing.JLabel w13Lbl5;
    private javax.swing.JLabel w13Lbl6;
    private javax.swing.JLabel w13Lbl8;
    private javax.swing.JLabel w13Lbl9;
    private javax.swing.JLabel w13pos10;
    private javax.swing.JLabel w13pos11;
    private javax.swing.JLabel w13pos12;
    private javax.swing.JLabel w13pos5;
    private javax.swing.JLabel w13pos6;
    private javax.swing.JLabel w13pos8;
    private javax.swing.JLabel w13pos9;
    private javax.swing.JLabel w14Lbl10;
    private javax.swing.JLabel w14Lbl11;
    private javax.swing.JLabel w14Lbl12;
    private javax.swing.JLabel w14Lbl5;
    private javax.swing.JLabel w14Lbl6;
    private javax.swing.JLabel w14Lbl8;
    private javax.swing.JLabel w14Lbl9;
    private javax.swing.JLabel w14pos10;
    private javax.swing.JLabel w14pos11;
    private javax.swing.JLabel w14pos12;
    private javax.swing.JLabel w14pos5;
    private javax.swing.JLabel w14pos6;
    private javax.swing.JLabel w14pos8;
    private javax.swing.JLabel w14pos9;
    private javax.swing.JLabel w15Lbl10;
    private javax.swing.JLabel w15Lbl11;
    private javax.swing.JLabel w15Lbl12;
    private javax.swing.JLabel w15Lbl5;
    private javax.swing.JLabel w15Lbl6;
    private javax.swing.JLabel w15Lbl8;
    private javax.swing.JLabel w15Lbl9;
    private javax.swing.JLabel w15pos10;
    private javax.swing.JLabel w15pos11;
    private javax.swing.JLabel w15pos12;
    private javax.swing.JLabel w15pos5;
    private javax.swing.JLabel w15pos6;
    private javax.swing.JLabel w15pos8;
    private javax.swing.JLabel w15pos9;
    private javax.swing.JLabel w16Lbl11;
    private javax.swing.JLabel w16Lbl12;
    private javax.swing.JLabel w16Lbl6;
    private javax.swing.JLabel w16Lbl8;
    private javax.swing.JLabel w16Lbl9;
    private javax.swing.JLabel w16pos11;
    private javax.swing.JLabel w16pos12;
    private javax.swing.JLabel w16pos6;
    private javax.swing.JLabel w16pos8;
    private javax.swing.JLabel w16pos9;
    private javax.swing.JLabel w17Lbl12;
    private javax.swing.JLabel w17Lbl8;
    private javax.swing.JLabel w17Lbl9;
    private javax.swing.JLabel w17pos12;
    private javax.swing.JLabel w17pos8;
    private javax.swing.JLabel w17pos9;
    private javax.swing.JLabel w18Lbl12;
    private javax.swing.JLabel w18Lbl8;
    private javax.swing.JLabel w18Lbl9;
    private javax.swing.JLabel w18pos12;
    private javax.swing.JLabel w18pos8;
    private javax.swing.JLabel w18pos9;
    private javax.swing.JLabel w19Lbl12;
    private javax.swing.JLabel w19pos12;
    private javax.swing.JLabel w1Lbl1;
    private javax.swing.JLabel w1Lbl10;
    private javax.swing.JLabel w1Lbl11;
    private javax.swing.JLabel w1Lbl12;
    private javax.swing.JLabel w1Lbl2;
    private javax.swing.JLabel w1Lbl3;
    private javax.swing.JLabel w1Lbl4;
    private javax.swing.JLabel w1Lbl5;
    private javax.swing.JLabel w1Lbl6;
    private javax.swing.JLabel w1Lbl7;
    private javax.swing.JLabel w1Lbl8;
    private javax.swing.JLabel w1Lbl9;
    private javax.swing.JLabel w1pos1;
    private javax.swing.JLabel w1pos10;
    private javax.swing.JLabel w1pos11;
    private javax.swing.JLabel w1pos12;
    private javax.swing.JLabel w1pos2;
    private javax.swing.JLabel w1pos3;
    private javax.swing.JLabel w1pos4;
    private javax.swing.JLabel w1pos5;
    private javax.swing.JLabel w1pos6;
    private javax.swing.JLabel w1pos7;
    private javax.swing.JLabel w1pos8;
    private javax.swing.JLabel w1pos9;
    private javax.swing.JLabel w20Lbl12;
    private javax.swing.JLabel w20pos12;
    private javax.swing.JLabel w2Lbl1;
    private javax.swing.JLabel w2Lbl10;
    private javax.swing.JLabel w2Lbl11;
    private javax.swing.JLabel w2Lbl12;
    private javax.swing.JLabel w2Lbl2;
    private javax.swing.JLabel w2Lbl3;
    private javax.swing.JLabel w2Lbl4;
    private javax.swing.JLabel w2Lbl5;
    private javax.swing.JLabel w2Lbl6;
    private javax.swing.JLabel w2Lbl7;
    private javax.swing.JLabel w2Lbl8;
    private javax.swing.JLabel w2Lbl9;
    private javax.swing.JLabel w2pos1;
    private javax.swing.JLabel w2pos10;
    private javax.swing.JLabel w2pos11;
    private javax.swing.JLabel w2pos12;
    private javax.swing.JLabel w2pos2;
    private javax.swing.JLabel w2pos3;
    private javax.swing.JLabel w2pos4;
    private javax.swing.JLabel w2pos5;
    private javax.swing.JLabel w2pos6;
    private javax.swing.JLabel w2pos7;
    private javax.swing.JLabel w2pos8;
    private javax.swing.JLabel w2pos9;
    private javax.swing.JLabel w3Lbl1;
    private javax.swing.JLabel w3Lbl10;
    private javax.swing.JLabel w3Lbl11;
    private javax.swing.JLabel w3Lbl12;
    private javax.swing.JLabel w3Lbl2;
    private javax.swing.JLabel w3Lbl3;
    private javax.swing.JLabel w3Lbl4;
    private javax.swing.JLabel w3Lbl5;
    private javax.swing.JLabel w3Lbl6;
    private javax.swing.JLabel w3Lbl7;
    private javax.swing.JLabel w3Lbl8;
    private javax.swing.JLabel w3Lbl9;
    private javax.swing.JLabel w3pos1;
    private javax.swing.JLabel w3pos10;
    private javax.swing.JLabel w3pos11;
    private javax.swing.JLabel w3pos12;
    private javax.swing.JLabel w3pos2;
    private javax.swing.JLabel w3pos3;
    private javax.swing.JLabel w3pos4;
    private javax.swing.JLabel w3pos5;
    private javax.swing.JLabel w3pos6;
    private javax.swing.JLabel w3pos7;
    private javax.swing.JLabel w3pos8;
    private javax.swing.JLabel w3pos9;
    private javax.swing.JLabel w4Lbl1;
    private javax.swing.JLabel w4Lbl10;
    private javax.swing.JLabel w4Lbl11;
    private javax.swing.JLabel w4Lbl12;
    private javax.swing.JLabel w4Lbl2;
    private javax.swing.JLabel w4Lbl3;
    private javax.swing.JLabel w4Lbl4;
    private javax.swing.JLabel w4Lbl5;
    private javax.swing.JLabel w4Lbl6;
    private javax.swing.JLabel w4Lbl7;
    private javax.swing.JLabel w4Lbl8;
    private javax.swing.JLabel w4Lbl9;
    private javax.swing.JLabel w4pos1;
    private javax.swing.JLabel w4pos10;
    private javax.swing.JLabel w4pos11;
    private javax.swing.JLabel w4pos12;
    private javax.swing.JLabel w4pos2;
    private javax.swing.JLabel w4pos3;
    private javax.swing.JLabel w4pos4;
    private javax.swing.JLabel w4pos5;
    private javax.swing.JLabel w4pos6;
    private javax.swing.JLabel w4pos7;
    private javax.swing.JLabel w4pos8;
    private javax.swing.JLabel w4pos9;
    private javax.swing.JLabel w5Lbl1;
    private javax.swing.JLabel w5Lbl10;
    private javax.swing.JLabel w5Lbl11;
    private javax.swing.JLabel w5Lbl12;
    private javax.swing.JLabel w5Lbl2;
    private javax.swing.JLabel w5Lbl3;
    private javax.swing.JLabel w5Lbl4;
    private javax.swing.JLabel w5Lbl5;
    private javax.swing.JLabel w5Lbl6;
    private javax.swing.JLabel w5Lbl7;
    private javax.swing.JLabel w5Lbl8;
    private javax.swing.JLabel w5Lbl9;
    private javax.swing.JLabel w5pos1;
    private javax.swing.JLabel w5pos10;
    private javax.swing.JLabel w5pos11;
    private javax.swing.JLabel w5pos12;
    private javax.swing.JLabel w5pos2;
    private javax.swing.JLabel w5pos3;
    private javax.swing.JLabel w5pos4;
    private javax.swing.JLabel w5pos5;
    private javax.swing.JLabel w5pos6;
    private javax.swing.JLabel w5pos7;
    private javax.swing.JLabel w5pos8;
    private javax.swing.JLabel w5pos9;
    private javax.swing.JLabel w6Lbl1;
    private javax.swing.JLabel w6Lbl10;
    private javax.swing.JLabel w6Lbl11;
    private javax.swing.JLabel w6Lbl12;
    private javax.swing.JLabel w6Lbl2;
    private javax.swing.JLabel w6Lbl3;
    private javax.swing.JLabel w6Lbl4;
    private javax.swing.JLabel w6Lbl5;
    private javax.swing.JLabel w6Lbl6;
    private javax.swing.JLabel w6Lbl7;
    private javax.swing.JLabel w6Lbl8;
    private javax.swing.JLabel w6Lbl9;
    private javax.swing.JLabel w6pos1;
    private javax.swing.JLabel w6pos10;
    private javax.swing.JLabel w6pos11;
    private javax.swing.JLabel w6pos12;
    private javax.swing.JLabel w6pos2;
    private javax.swing.JLabel w6pos3;
    private javax.swing.JLabel w6pos4;
    private javax.swing.JLabel w6pos5;
    private javax.swing.JLabel w6pos6;
    private javax.swing.JLabel w6pos7;
    private javax.swing.JLabel w6pos8;
    private javax.swing.JLabel w6pos9;
    private javax.swing.JLabel w7Lbl1;
    private javax.swing.JLabel w7Lbl10;
    private javax.swing.JLabel w7Lbl11;
    private javax.swing.JLabel w7Lbl12;
    private javax.swing.JLabel w7Lbl2;
    private javax.swing.JLabel w7Lbl3;
    private javax.swing.JLabel w7Lbl4;
    private javax.swing.JLabel w7Lbl5;
    private javax.swing.JLabel w7Lbl6;
    private javax.swing.JLabel w7Lbl7;
    private javax.swing.JLabel w7Lbl8;
    private javax.swing.JLabel w7Lbl9;
    private javax.swing.JLabel w7pos1;
    private javax.swing.JLabel w7pos10;
    private javax.swing.JLabel w7pos11;
    private javax.swing.JLabel w7pos12;
    private javax.swing.JLabel w7pos2;
    private javax.swing.JLabel w7pos3;
    private javax.swing.JLabel w7pos4;
    private javax.swing.JLabel w7pos5;
    private javax.swing.JLabel w7pos6;
    private javax.swing.JLabel w7pos7;
    private javax.swing.JLabel w7pos8;
    private javax.swing.JLabel w7pos9;
    private javax.swing.JLabel w8Lbl1;
    private javax.swing.JLabel w8Lbl10;
    private javax.swing.JLabel w8Lbl11;
    private javax.swing.JLabel w8Lbl12;
    private javax.swing.JLabel w8Lbl2;
    private javax.swing.JLabel w8Lbl3;
    private javax.swing.JLabel w8Lbl5;
    private javax.swing.JLabel w8Lbl6;
    private javax.swing.JLabel w8Lbl7;
    private javax.swing.JLabel w8Lbl8;
    private javax.swing.JLabel w8Lbl9;
    private javax.swing.JLabel w8pos1;
    private javax.swing.JLabel w8pos10;
    private javax.swing.JLabel w8pos11;
    private javax.swing.JLabel w8pos12;
    private javax.swing.JLabel w8pos2;
    private javax.swing.JLabel w8pos3;
    private javax.swing.JLabel w8pos5;
    private javax.swing.JLabel w8pos6;
    private javax.swing.JLabel w8pos7;
    private javax.swing.JLabel w8pos8;
    private javax.swing.JLabel w8pos9;
    private javax.swing.JLabel w9Lbl1;
    private javax.swing.JLabel w9Lbl10;
    private javax.swing.JLabel w9Lbl11;
    private javax.swing.JLabel w9Lbl12;
    private javax.swing.JLabel w9Lbl2;
    private javax.swing.JLabel w9Lbl3;
    private javax.swing.JLabel w9Lbl5;
    private javax.swing.JLabel w9Lbl6;
    private javax.swing.JLabel w9Lbl7;
    private javax.swing.JLabel w9Lbl8;
    private javax.swing.JLabel w9Lbl9;
    private javax.swing.JLabel w9pos1;
    private javax.swing.JLabel w9pos10;
    private javax.swing.JLabel w9pos11;
    private javax.swing.JLabel w9pos12;
    private javax.swing.JLabel w9pos2;
    private javax.swing.JLabel w9pos3;
    private javax.swing.JLabel w9pos5;
    private javax.swing.JLabel w9pos6;
    private javax.swing.JLabel w9pos7;
    private javax.swing.JLabel w9pos8;
    private javax.swing.JLabel w9pos9;
    private javax.swing.JLabel waitingLbl;
    // End of variables declaration//GEN-END:variables
    //Create Player Object
    private GameTimer gameTimer;
    public Player player; /* = new Player("Lance Newby",
                                      Level.ELEMENTARY,
                                      "1st-4th",
                                      'M',
                                      "Other",
                                      true,
                                      true,
                                      true);*/
    private javax.swing.JLabel l;
    //public Vector<javax.swing.JLabel> word = new Vector<javax.swing.JLabel>(5);
    private SchoolLevel Elementary = new SchoolLevel();
    private SchoolLevel Middle = new SchoolLevel();
    private SchoolLevel High = new SchoolLevel();
    private int currentSentence = 0;
    private int currentWord = 0;
    private Sentence[] sentence;
    private java.awt.Color BLUE = new java.awt.Color(51, 0, 255);
    //Interpreter i = new Interpreter();
}

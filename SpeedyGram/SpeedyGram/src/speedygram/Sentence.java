/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speedygram;

/**
 *
 * @author lnewby
 */
public class Sentence {
    public String text;
    public Word word[];
    public int timeToAnswer;
    public javax.swing.JLayeredPane sentenceLP;
    public boolean errorFound = false;
    public int numCorrectlyAnswered;
    public Word wordWrong;
    public int numberCorrect;
    public int numOfBonusPoints;
    private boolean allWordsCorrect;
    private boolean sentenceGraded;

    public Sentence(String sentence, String pos){
        this.text = sentence;
        this.parseSentence(pos);
        this.numCorrectlyAnswered = 0;
        this.numOfBonusPoints = 0;
        this.sentenceGraded = false;
        this.numberCorrect = 0;
        this.wordWrong = new Word("","");
    }

    public void parseSentence(String word_pos){
        String delims = "[ ]+";
        String[] wordTokens = this.text.split(delims);
        String[] posTokens = word_pos.split(delims);
        this.word = new Word[wordTokens.length];
        for (int i = 0; i < wordTokens.length; i++){
            this.word[i] = new Word(wordTokens[i], posTokens[i]);
        }

    }

    public String getText(){
        return this.text;
    }

    public void gradeSentence(javax.swing.JLabel scoreLbl, Player player){
        if (!sentenceGraded){
            for (Word w: this.word){
                if(!w.pos.equals(w.players_ans)){
                    w.wordLbl.setForeground(java.awt.Color.RED);
                    this.errorFound = true;
                    wordWrong = w;
                } else {
                    this.numCorrectlyAnswered+=10;
                    this.numberCorrect+=1;
                }
            }
            if(!errorFound) {
                for (Word w: this.word){
                    w.wordLbl.setForeground(java.awt.Color.GREEN);
                    allWordsCorrect = true;
                }
                numCorrectlyAnswered+=word.length*10;
                player.bonusPoints+=1;
            }
            player.score+=numCorrectlyAnswered;
            
            scoreLbl.setText("Score: "+ player.score);
            this.sentenceGraded = true;
        }

    }
   /* public static void main(String args[]) {
        Sentence a = new Sentence("Hello God", "L O R D");
    }*/
}

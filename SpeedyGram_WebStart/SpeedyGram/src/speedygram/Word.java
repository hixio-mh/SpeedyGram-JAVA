/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speedygram;

/**
 *
 * @author lnewby
 */
public class Word {
    public String text = new String();
    public String pos = new String();
    public String players_ans = null; // players answer
    public int bonusValue = 100;
    public javax.swing.JLabel wordLbl;
    public javax.swing.JLabel posLbl;
    //public javax.swing.JButton wordBtn;
    
    public Word(String word, String pos ){
        this.text = word;
        this.pos = pos;
        //this.wordLbl = wordLabel;
        //this.wordLbl.setPreferredSize(new java.awt.Dimension(200, 16));

        //this.wordLbl.setSize(this.wordLbl.getPreferredSize());
        //this.wordLbl.setVisible(true);
        //this.wordLbl.setLocation(new java.awt.Point(200,16));

    }

    public String getWord(){
        return this.text;
    }
    public int getBonus(){
        return this.bonusValue;
    }
    public String getPos(){
        return this.pos;
    }
    // Setters
    public void setWord(String word){
        this.text = word;
    }
    public void setBonusValue(int bonusValue){
        this.bonusValue = bonusValue;
    }
    public void setPlayerAns(String pos){
        this.players_ans = pos;
        if(pos.equals("article")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/article_thumb.png")));
        } else if(pos.equals("adverb")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/adverb_thumb.png")));
        } else if(pos.equals("adjective")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/adjective_thumb.png")));
        } else if(pos.equals("pronoun")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/pronoun_thumb.png")));
        } else if(pos.equals("noun")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/noun_thumb.png")));
        } else if(pos.equals("conjunction")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/conjunction_thumb.png")));
        } else if(pos.equals("interjection")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/interjection_thumb.png")));
        } else if(pos.equals("preposition")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/preposition_thumb.png")));
        } else if(pos.equals("verb")){
            this.posLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speedygram/images/verb_thumb.png")));
        }
    }
}

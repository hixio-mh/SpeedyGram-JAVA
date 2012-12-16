/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speedygram;

/**
 *
 * @author lnewby
 */
public class Player {
    public String name;
    public int score;
    public Level gradeLevel;
    public char gender;
    public String race;
    public boolean spEd;
    public boolean esl;
    public boolean reduceLunch;
    public String readingLevel;
    public String comments;
    public int bonusPoints;
    public int bonus;

    public Player(String name, Level gradeLevel, String readingLevel, char gender, String race, boolean spEd, boolean esl, boolean reduceLunch){
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.esl = esl;
        this.gender = gender;
        this.readingLevel = readingLevel;
        this.reduceLunch = reduceLunch;
        this.race = race;
        this.spEd = spEd;
        this.score = 0;
        this.comments = null;
        this.bonusPoints = 0;
    }

    public int getBonus(){
        return bonus;
    }

    public void updateBonus(int b){
        this.bonus += b;
    }
}

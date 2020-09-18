/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author maciejcirka
 */
public class Player {
    
    private Mark mark;
    private boolean win;

    public Player(Mark mark) {
        this.mark = mark;
        this.win = false;
    }
    
    public String getMark() {
        return "" + this.mark;
    }

    public boolean isWin() {
        return win;
    }
    
    public void won() {
    this.win = true;
    }
    
    public String putMark() {
        return "" + this.mark;
    }
    
    public void switchPlayer() {
        if (this.mark == Mark.X) {
           this.mark = Mark.O;
        } else {
            this.mark = Mark.X;
        }
        
    }

}

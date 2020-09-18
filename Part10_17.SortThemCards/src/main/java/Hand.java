
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> cards;

    
    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        cards.stream().forEach(card -> System.out.println(card));
    }
    
    public void sort() {
        
        
        Comparator<Card> comparator = Comparator
                                    .comparing(Card::getValue)
                                    .thenComparing(Card::getSuit);
        
        Collections.sort(cards, comparator);
    }

    @Override
    public int compareTo(Hand o) {
        return this.cards.stream()
                         .mapToInt(cards -> cards.getValue())
                         .sum()
             -    o.cards.stream()
                         .mapToInt(cards -> cards.getValue())
                         .sum();
    }
    
    public void sortBySuit() {
        Comparator<Card> comparator = Comparator
                                    .comparing(Card::getSuit)
                                    .thenComparing(Card::getValue);
        
        Collections.sort(cards, comparator);
    }
    
    
    
    
}

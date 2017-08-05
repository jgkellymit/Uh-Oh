package gameplay;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DeckTest {

    @Test
    public void getCardTest() {
        Deck testDeck = new Deck();
        List<Card> testList = new ArrayList<>();
        for (int ii = 0;ii < 52; ii++){
            Card currentCard = testDeck.getCard();
            assertFalse(testList.contains(currentCard));
            testList.add(currentCard);
        }
        try{
            testDeck.getCard();
            assertTrue(false); //should never get here
        }
        catch (IndexOutOfBoundsException e){}        
    }
    
    @Test
    public void makeHandTest(){
        Deck testDeck = new Deck();
        Hand hand1 = testDeck.makeHand(4);
        assertTrue(hand1.getHandSize() == 4);
        Hand hand2 = testDeck.makeHand(5);
        assertTrue(hand2 != hand1);
        assertTrue(hand2.getHandSize() == 5);
    }

}

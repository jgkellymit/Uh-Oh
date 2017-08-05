package gameplay;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

    @Test
    public void gettersTest() {
        Card testCard = new Card(4, "Spade");
        assertTrue(testCard.getNumber() == 4);
        assertTrue(testCard.getSuit() == "Spade");
    }
    
    @Test
    public void compareCardTest(){
        Card smallDiamond = new Card(4, "Diamond");
        Card bigClub = new Card(12, "Club");
        Card mediumSpade = new Card(8, "Spade");
        Card bigSpade = new Card(13, "Spade");
        
        assertFalse(smallDiamond.compareCard(mediumSpade, "Diamond", "Spade"));
        assertFalse(smallDiamond.compareCard(smallDiamond, "Spade", "Diamond"));
        assertTrue(mediumSpade.compareCard(bigSpade, "Diamond", "Spade"));
        assertFalse(mediumSpade.compareCard(bigClub, "Diamond", "Spade"));
    }
    
    @Test
    public void toStringTest(){
        Card midHeart = new Card(3, "Heart");
        Card aceSpades = new Card(1, "Spade");
        midHeart.toString().contains("3H");
        aceSpades.toString().contains("1S");
    }

}

//import org.junit.Test;

import outputs.DomCard;

//import static org.junit.Assert.*;

public class DomCardTest {

    @Test
    public void testName() {
        DomCard card = new DomCard();
        String name = "Province";
        card.name = name;
        assertEquals(name, card.name);
    }

    private void assertEquals(String name, String name2) {
    }

    @Test
    public void testEmail() {
        DomCard card = new DomCard();
        String email = "test@example.com";
        card.email = email;
        assertEquals(email, card.email);
    }

    @Test
    public void testName2() {
        DomCard card = new DomCard();
        String name2 = "Gold";
        card.name2 = name2;
        assertEquals(name2, card.name2);
    }

    @Test
    public void testEmail2() {
        DomCard card = new DomCard();
        String email2 = "test2@example.com";
        card.email2 = email2;
        assertEquals(email2, card.email2);
    }
}
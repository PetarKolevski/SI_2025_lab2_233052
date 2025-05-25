package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class SILab2Test {

    @Test
    void checkCart() {
        RuntimeException nullItem = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1111111111111111"));
        assertTrue(nullItem.getMessage().contains("allItems list can't be null"));


        RuntimeException invalidItem = assertThrows(RuntimeException.class, () -> {
            List<Item> item = List.of(new Item(null, 2, 50, 0));
            SILab2.checkCart(item, "1111111111111111");
        });
        assertTrue(invalidItem.getMessage().contains("Invalid item!"));


        List<Item> item1 = List.of(new Item("Item", 10, 150, 0));
        double price1 = SILab2.checkCart(item1, "1111111111111111");
        assertEquals(1500, price1);


        List<Item> item2 = List.of(new Item("Item", 4, 100, 0.4));
        double price2 = SILab2.checkCart(item2, "1111111111111111");
        assertEquals(240, price2);


        RuntimeException invalidCardNumber = assertThrows(RuntimeException.class, () -> {
            List<Item> item = List.of(new Item("Item", 3, 60, 0));
            SILab2.checkCart(item, "1111");
        });
        assertTrue(invalidCardNumber.getMessage().contains("Invalid card number!"));


        RuntimeException invalidCharacter = assertThrows(RuntimeException.class, () -> {
            List<Item> item = List.of(new Item("Item", 3, 60, 0));
            SILab2.checkCart(item, "111111111111A11F");
        });
        assertTrue(invalidCharacter.getMessage().contains("Invalid character in card number!"));
    }

    @Test
    void priceTest(){
        List<Item> item1= List.of(new Item("item1", 5, 500, 0));
        double price1 = SILab2.checkCart(item1, "1111111111111111");
        assertEquals(2470, price1);

        List<Item> item2 = List.of(new Item("item2", 5, 500, 0.4));
        double price2 = SILab2.checkCart(item2,"1111111111111111");
        assertEquals(1470, price2);

        List<Item> item3 = List.of(new Item("item3", 20, 200, 0));
        double price3 = SILab2.checkCart(item3,"1111111111111111");
        assertEquals(3970, price3);

        List<Item> item4 = List.of(new Item("item4", 5, 200, 0));
        double price4 = SILab2.checkCart(item4,"1111111111111111");
        assertEquals(1000, price4);
    }
}


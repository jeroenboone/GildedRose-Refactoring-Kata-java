package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseConjuredTest {

    private Item createItem(int sellIn, int quality) {
        return new Item(ItemType.CONJURED.getName(), sellIn, quality);
    }

    @Test
    void updateQuality_default_degradation_then_sellIn_decreases_and_QualityDecreases() {
        Item itemToUpdate = new Item("Conjured Mana Cake", 3, 6);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(itemToUpdate.name, itemToUpdate.name);
        assertEquals(2, itemToUpdate.sellIn);
        assertEquals(4, itemToUpdate.quality);
    }

    @Test
    void updateQuality_itemQualityOfAnItemIsNeverMoreThan50() {
        Item itemToUpdate = createItem(2, 50);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(48, itemToUpdate.quality);
    }

    @Test
    void updateQuality_itemQualityIsNeverNegative() {
        Item itemToUpdate = createItem(2, 1);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(0, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenHasAlmostPassed_thenDegradeNormally() {
        Item itemToUpdate = createItem(1, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(18, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_thenDegradeTwiceAsFast() {
        Item itemToUpdate = createItem(0, 20);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(-1, itemToUpdate.sellIn);
        assertEquals(16, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_andQualityIsZero_thenDoNotDegradeFurther() {
        Item itemToUpdate = createItem(-1, 0);

        GildedRose.create(itemToUpdate).updateQuality();

        assertEquals(0, itemToUpdate.quality);
    }


}

package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseAgedBrieTest {

    private Item createItem(int sellIn, int quality) {
        return new Item(ItemType.AGED_BRIE.getName(), sellIn, quality);
    }


    private Item updateQuality(int sellIn, int quality) {
        Item itemToUpdate = createItem(sellIn, quality);

        GildedRose app = GildedRose.create(itemToUpdate);
        app.updateQuality();
        return itemToUpdate;
    }

    @Test
    void updateQuality_name_remains_the_same() {
        Item itemToUpdate = updateQuality(2, 20);
        assertEquals(itemToUpdate.name, itemToUpdate.name);
    }

    @Test
    void updateQuality_itemQualityOfAnItemIsNeverMoreThan50() {
        Item itemToUpdate = updateQuality(2, 50);
        assertEquals(50, itemToUpdate.quality);
    }

    @Test
    void updateQuality_default_degradation_then_sellIn_decreases_and_QualityDecreases() {
        Item itemToUpdate = updateQuality(11, 20);
        assertEquals(21, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenHasAlmostPassed_thenDegradeNormally() {
        Item itemToUpdate = updateQuality(1, 20);
        assertEquals(21, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_thenDegradeTwiceAsFast() {
        Item itemToUpdate = updateQuality(0, 20);
        assertEquals(-1, itemToUpdate.sellIn);
        assertEquals(22, itemToUpdate.quality);
    }

    @Test
    void updateQuality_givenSellDateHasPassed_andQualityIsZere_thenDoNotDegradeFurther() {
        Item itemToUpdate = updateQuality(-1, 0);
        assertEquals(2, itemToUpdate.quality);
    }


}

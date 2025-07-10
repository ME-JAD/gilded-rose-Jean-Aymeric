package com.gildedrose;

public class ItemAdapter implements IItem {

    private final Item item;

    public ItemAdapter(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    @Override
    public int getQuality() {
        return this.item.quality;
    }

    @Override
    public void incrementQuality() {
        this.item.quality++;
    }

    @Override
    public void incrementQuality(final int amount) {
        this.item.quality += amount;
    }

    @Override
    public void decrementQuality() {
        this.item.quality--;
    }

    @Override
    public void decrementQuality(final int amount) {
        this.item.quality -= amount;
    }

    @Override
    public int getSellIn() {
        return this.item.sellIn;
    }

    @Override
    public void decrementSellIn() {
        this.item.sellIn--;
    }

    @Override
    public String getName() {
        return this.item.name;
    }

    @Override
    public void resetQualityToZero() {
        this.item.quality = 0;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}

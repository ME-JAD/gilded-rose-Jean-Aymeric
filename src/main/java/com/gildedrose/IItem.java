package com.gildedrose;

public interface IItem {
    int getQuality();

    void incrementQuality();

    void incrementQuality(final int amount);

    void decrementQuality();

    void decrementQuality(final int amount);

    int getSellIn();

    void decrementSellIn();

    String getName();

    String toString();

    void resetQualityToZero();
}

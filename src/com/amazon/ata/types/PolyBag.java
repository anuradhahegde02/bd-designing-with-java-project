package com.amazon.ata.types;

import java.math.BigDecimal;

public class PolyBag extends Packaging {
    private BigDecimal volume;

    public PolyBag(Material material, BigDecimal volume) {
        super(material);
        this.volume = volume;
    }

    /**
     * Returns whether the given item will fit in this packaging.
     *
     * @param item the item to test fit for
     * @return whether the item will fit in this packaging
     */
    public boolean canFitItem(Item item) {
        throw new UnsupportedOperationException("PolyBag is not supported for now");
    }

    /**
     * Returns the mass of the packaging in grams. The packaging weighs 1 gram per square centimeter.
     *
     * @return the mass of the packaging
     */
    public BigDecimal getMass() {

        System.out.println("PolyBag : getMass() ,not supported for now");
        // mass = Math.ceil(Math.sqrt(volume) x 0.6);
        return new BigDecimal(Math.ceil(Math.sqrt(volume.doubleValue()) * 0.6));
    }

    public BigDecimal getVolume() {
        return volume;
    }
}

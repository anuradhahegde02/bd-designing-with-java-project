package com.amazon.ata.types;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a packaging option.
 * <p>
 * This packaging supports standard boxes, having a length, width, and height.
 * Items can fit in the packaging so long as their dimensions are all smaller than
 * the packaging's dimensions.
 */
public class Packaging {
    /**
     * The material this packaging is made of.
     */
    private Material material;


    /**
     * Instantiates a new Packaging object.
     *
     * @param material - the Material of the package
     */
    public Packaging(Material material) {
        this.material = material;

    }

    public Material getMaterial() {
        return material;
    }

    /**
     * Returns whether the given item will fit in this packaging.
     *
     * @param item the item to test fit for
     * @return whether the item will fit in this packaging
     */
    public boolean canFitItem(Item item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the mass of the packaging in grams. The packaging weighs 1 gram per square centimeter.
     *
     * @return the mass of the packaging
     */
    public BigDecimal getMass() {
        System.out.println("Packaging : getMass() called, returning zero");
        return new BigDecimal(0);
    }

    @Override
    public boolean equals(Object o) {
        // Can't be equal to null

        if (o == null) {
            return false;
        }

        // Referentially equal
        if (this == o) {
            return true;
        }

        // Check if it's a different type
        if (getClass() != o.getClass()) {
            return false;
        }

        Packaging packaging = (Packaging) o;
        return getMaterial() == packaging.getMaterial();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial());
    }
}

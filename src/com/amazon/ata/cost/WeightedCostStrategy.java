package com.amazon.ata.cost;

import com.amazon.ata.types.ShipmentCost;
import com.amazon.ata.types.ShipmentOption;

import java.math.BigDecimal;

public class WeightedCostStrategy implements CostStrategy {
    MonetaryCostStrategy monetaryStrategy;
    CarbonCostStrategy carbonStrategy;
    ShipmentCost moneytaryPrice, carbonPrice;

    public WeightedCostStrategy(MonetaryCostStrategy monetaryCostStrategy, CarbonCostStrategy carbonCostStrategy) {
        monetaryStrategy = monetaryCostStrategy;
        carbonStrategy = carbonCostStrategy;


    }



    /**
     * Get the cost of the shipment option using Weighted cost strategy.
     *
     * @param shipmentOption a shipment option with packaging
     * @return total cost of the shipment option
     */
    @Override
    public ShipmentCost getCost(ShipmentOption shipmentOption) {
        moneytaryPrice = monetaryStrategy.getCost(shipmentOption);
        carbonPrice = carbonStrategy.getCost(shipmentOption);
        BigDecimal newPrice = (moneytaryPrice.getCost().multiply(new BigDecimal(0.8))).add(carbonPrice.getCost().multiply(new BigDecimal(0.2)));

        return new ShipmentCost(moneytaryPrice.getShipmentOption(),newPrice);
    }
}

package com.amazon.ata.cost;

import com.amazon.ata.types.Material;
import com.amazon.ata.types.Packaging;
import com.amazon.ata.types.ShipmentCost;
import com.amazon.ata.types.ShipmentOption;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CarbonCostStrategy implements CostStrategy {

    private final Map<Material, BigDecimal> sustainabilityIndexPerGram;


    public CarbonCostStrategy() {

        sustainabilityIndexPerGram = new HashMap<>();

        sustainabilityIndexPerGram.put(Material.CORRUGATE, BigDecimal.valueOf(0.017));
        sustainabilityIndexPerGram.put(Material.LAMINATED_PLASTIC, BigDecimal.valueOf(0.012));
    }

    /**
     * Get the cost of the shipment option.
     *
     * @param shipmentOption a shipment option with packaging
     * @return total cost of the shipment option
     */
    @Override
    public ShipmentCost getCost(ShipmentOption shipmentOption) {
        Packaging packaging = shipmentOption.getPackaging();
        BigDecimal carbonCost = this.sustainabilityIndexPerGram.get(packaging.getMaterial());
        BigDecimal cost = packaging.getMass().multiply(carbonCost);
        return new ShipmentCost(shipmentOption, cost);
    }
}

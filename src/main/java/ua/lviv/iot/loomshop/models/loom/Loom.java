package ua.lviv.iot.loomshop.models.loom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loom {

    protected Country originCountry;
    protected double price;
    protected double powerInWatts;
    protected int widthOfTheFormedTissue;
    protected String materialOfTheProducedFabric;
}

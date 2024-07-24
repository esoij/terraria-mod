package esoij.terrariamod.world.level.biome;

import net.minecraft.world.level.biome.Climate;

import java.util.List;

public class ModOverworldBiomeBuilder {
    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
    public List<Climate.ParameterPoint> spawnTarget() {
        Climate.Parameter parameter = Climate.Parameter.point(0.0F);
        float f = 0.16F;
        return List.of(
                new Climate.ParameterPoint(
                        this.FULL_RANGE,
                        this.FULL_RANGE,
                        Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE),
                        this.FULL_RANGE,
                        parameter,
                        Climate.Parameter.span(-1.0F, -0.16F),
                        0L
                ),
                new Climate.ParameterPoint(
                        this.FULL_RANGE,
                        this.FULL_RANGE,
                        Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE),
                        this.FULL_RANGE,
                        parameter,
                        Climate.Parameter.span(0.16F, 1.0F),
                        0L
                )
        );
    }
}

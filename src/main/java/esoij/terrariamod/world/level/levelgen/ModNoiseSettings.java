package esoij.terrariamod.world.level.levelgen;

import com.mojang.serialization.DataResult;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.NoiseSettings;

public class ModNoiseSettings {
    protected static final NoiseSettings TERRARIA_NOISE_SETTINGS = create(-64, 384, 1, 2);
    private static DataResult<NoiseSettings> guardY(NoiseSettings settings) {
        if (settings.minY() + settings.height() > DimensionType.MAX_Y + 1) {
            return DataResult.error(() -> "min_y + height cannot be higher than: " + (DimensionType.MAX_Y + 1));
        } else if (settings.height() % 16 != 0) {
            return DataResult.error(() -> "height has to be a multiple of 16");
        } else {
            return settings.minY() % 16 != 0 ? DataResult.error(() -> "min_y has to be a multiple of 16") : DataResult.success(settings);
        }
    }
    public static NoiseSettings create(int minY, int height, int noiseSizeHorizontal, int noiseSizeVertical) {
        NoiseSettings noiseSettings = new NoiseSettings(minY, height, noiseSizeHorizontal, noiseSizeVertical);
        guardY(noiseSettings).error().ifPresent(error -> {
            throw new IllegalStateException(error.message());
        });
        return noiseSettings;
    }
}

package ac.grim.grimac.manager.player.features.types;

import ac.grim.grimac.api.config.ConfigManager;
import ac.grim.grimac.api.feature.FeatureState;
import ac.grim.grimac.player.GrimPlayer;

public class ExperimentalChecksFeature extends GrimFeature {

    public ExperimentalChecksFeature() {
        super("ExperimentalChecks");
    }

    @Override
    public void setState(GrimPlayer player, ConfigManager config, FeatureState state) {
        if (state == FeatureState.ENABLED) {
            player.setExperimentalChecks(true);
        } else if (state == FeatureState.DISABLED) {
            player.setExperimentalChecks(false);
        } else {
            player.setExperimentalChecks(isEnabledInConfig(player, config));
        }
    }

    @Override
    public boolean isEnabled(GrimPlayer player) {
        return player.isExperimentalChecks();
    }

    @Override
    public boolean isEnabledInConfig(GrimPlayer player, ConfigManager config) {
        return config.getBooleanElse("experimental-checks", false);
    }

}

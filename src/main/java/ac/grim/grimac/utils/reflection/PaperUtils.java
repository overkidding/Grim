package ac.grim.grimac.utils.reflection;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.concurrent.CompletableFuture;

public class PaperUtils {

    public static final boolean PAPER;
    public static final boolean TICK_END_EVENT;
    public static final boolean ASYNC_TELEPORT;

    static {
        PAPER = ReflectionUtils.hasClass("com.destroystokyo.paper.PaperConfig") || ReflectionUtils.hasClass("io.papermc.paper.configuration.Configuration");
        TICK_END_EVENT = ReflectionUtils.hasClass("com.destroystokyo.paper.event.server.ServerTickEndEvent");
        ASYNC_TELEPORT = ReflectionUtils.hasMethod(Entity.class, "teleportAsync", Location.class);
    }

    public static CompletableFuture<Boolean> teleportAsync(final Entity entity, final Location location) {
        if (PAPER) {
            return entity.teleportAsync(location);
        } else {
            return CompletableFuture.completedFuture(entity.teleport(location));
        }
    }

}

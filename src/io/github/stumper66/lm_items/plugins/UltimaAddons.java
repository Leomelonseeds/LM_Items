package io.github.stumper66.lm_items.plugins;

import java.util.Collection;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import io.github.stumper66.lm_items.ExternalItemRequest;
import io.github.stumper66.lm_items.GetItemResult;
import io.github.stumper66.lm_items.ItemsAPI;

public class UltimaAddons implements ItemsAPI {

    @Override
    public boolean getIsInstalled() {
        return Bukkit.getPluginManager().getPlugin(getName()) != null;
    }

    @Override
    public @NotNull String getName(){
        return "UltimaAddons";
    }

    @Override
    public @NotNull GetItemResult getItem(@NotNull ExternalItemRequest itemRequest) {
        final GetItemResult result = new GetItemResult(getIsInstalled());
        if (!result.pluginIsInstalled) return result;
        
        com.leomelonseeds.ultimaaddons.UltimaAddons ua = com.leomelonseeds.ultimaaddons.UltimaAddons.getPlugin();
        result.itemStack = ua.getItems().getItem(itemRequest.itemId);
        return result;
    }

    @Override
    public @NotNull Collection<String> getItemTypes() {
        return Collections.emptyList();
    }

}

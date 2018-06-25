package AT.MSev.DropAndEnchant;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class DropAndEnchant extends JavaPlugin {
    public static NamespacedKey key;
    @Override
    public void onEnable() {
        key = new NamespacedKey(this, this.getDescription().getName());


        getServer().getPluginManager().registerEvents(new Handler(), this);
    }
    @Override
    public void onDisable() {

    }
}

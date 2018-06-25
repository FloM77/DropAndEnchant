package AT.MSev.DropAndEnchant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

import static org.bukkit.Bukkit.getLogger;

public class Handler implements Listener {

    @EventHandler
    public void OnInventoryDropBook(InventoryClickEvent e)
    {
        if((e.getCursor()!=null && e.getCurrentItem()!=null) && e.getCursor().getType().equals(Material.ENCHANTED_BOOK) && !e.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK) && !e.getCurrentItem().getType().equals(Material.AIR))
        {
            if(!((Player)e.getWhoClicked()).hasPermission("dropenchant.allowenchant"))
            {
                ((Player)e.getWhoClicked()).sendMessage(ChatColor.RED + "You don't have permissions to do that");
                return;
            }
            ItemMeta im = e.getCurrentItem().getItemMeta();
            if(!im.hasEnchants())
            {
                for(Map.Entry<Enchantment, Integer> enchant : e.getCursor().getEnchantments().entrySet())
                {
                    im.addEnchant(enchant.getKey(), enchant.getValue(), true);
                }
            }
            e.getCurrentItem().setItemMeta(im);
            e.getCursor().setAmount(0);
            ((Player)e.getWhoClicked()).updateInventory();
        }
    }
}

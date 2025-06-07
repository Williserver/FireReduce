package net.williserver.firereduce

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockSpreadEvent

/**
 * Listen for fire spread events and cancel them proportionally to the provided cancellation percent.
 *
 * @author Willmo3
 */
class FireSpreadListener: Listener {
    @EventHandler
    fun onFireSpread(event: BlockSpreadEvent) {
        if (event.source.type == Material.FIRE) {
            if ((1..100).random() <= 90) {
                event.isCancelled = true
            }
        }
    }
}
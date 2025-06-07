package net.williserver.firereduce

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockSpreadEvent

/**
 * Listen for fire spread events and cancel them proportionally to the provided cancellation percent.
 * @param cancelPercent Percent of fire spreads to cancel.
 *
 * @author Willmo3
 */
class FireSpreadListener(private val cancelPercent: Int): Listener {
    init {
        if (cancelPercent !in (0..100)) {
            throw IllegalArgumentException("cancelPercent must be in range 0..100")
        }
    }

    @EventHandler
    fun onFireSpread(event: BlockSpreadEvent) {
        if (event.source.type == Material.FIRE) {
            // Note: never true for percent = 0, by design. Allows turning off cancellation entirely.
            if ((1..100).random() <= cancelPercent) {
                event.isCancelled = true
            }
        }
    }
}
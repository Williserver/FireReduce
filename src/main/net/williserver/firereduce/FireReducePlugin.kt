package net.williserver.firereduce

import org.bukkit.plugin.java.JavaPlugin

/**
 * Fire Reduce, a plugin to reduce firespread.
 *
 * @author Willmo3
 */
class FireReducePlugin: JavaPlugin() {
    private val logHandler = LogHandler(logger)

    override fun onEnable() {
        logHandler.info("Fire reduce plugin enabled")
    }

    override fun onDisable() {
        logHandler.info("Fire reduce plugin disabled")
    }

    companion object {
        const val PLUGIN_PREFIX = "[FireReduce]"
    }
}
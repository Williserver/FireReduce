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
        server.pluginManager.registerEvents(FireSpreadListener(), this)
        logHandler.info("Server event listeners registered.")

        logHandler.info("FireReduce enabled!")
    }

    override fun onDisable() {
        logHandler.info("FireReduce disabled!")
    }

    companion object {
        const val PLUGIN_PREFIX = "[FireReduce]"
    }
}
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
        saveDefaultConfig()
        val percentCancelled = loadConfigPercentage()
        logHandler.info("Loaded cancellation percentage: $percentCancelled")

        server.pluginManager.registerEvents(FireSpreadListener(percentCancelled), this)
        logHandler.info("Server event listeners registered.")

        logHandler.info("FireReduce enabled!")
    }

    override fun onDisable() {
        logHandler.info("FireReduce disabled!")
    }

    /**
     * Acceptable range of fire cancellation: 0-100%.
     * @return the loaded percent if within the acceptable range, otherwise DEFAULT_CANCEL_PERCENT (50)
     */
    private fun loadConfigPercentage() =
        config.getInt("percentCancelled").let {
            if (it in 0..100) {
                it
            } else {
                logHandler.err("Fire cancellation percent must be between 0 and 100, inclusive. Loaded: $it. Using percent $DEFAULT_CANCEL_PERCENT.")
                DEFAULT_CANCEL_PERCENT
            }
        }

    companion object {
        const val PLUGIN_PREFIX = "[FireReduce]"

        /**
         * Default percent of fires to cancel, if option not loaded.
         */
        const val DEFAULT_CANCEL_PERCENT = 50
    }
}
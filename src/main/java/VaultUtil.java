import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Logger;

public class VaultUtil {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    public VaultUtil() {
        setupEconomy();
    }

    public static Economy getEconomy() {
        return econ;
    }

    public Server getServer() {
        return Bukkit.getServer();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

}

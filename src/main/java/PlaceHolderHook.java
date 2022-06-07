import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PlaceHolderHook extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "ks";
    }

    @Override
    public String getAuthor() {
        return "Cericx_";
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin("Vault") != null;
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean register() {
        if (!canRegister()) {
            return false;
        }
        new VaultUtil();
        PlaceholderAPI.registerPlaceholderHook("ks", this);
        return super.register();
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        if (params.equalsIgnoreCase("balance")) {
            Locale locale = Locale.GERMANY;
            String pattern = "#,##0.00";
            DecimalFormat format = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMAN);
            format.applyPattern(pattern);
            return format.format(VaultUtil.getEconomy().getBalance(p));
        }
        return null;
    }

}

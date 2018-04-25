package us._donut_.bitcoin;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;

public class RegisterMVdWPlaceholderAPI {

    RegisterMVdWPlaceholderAPI(Bitcoin pluginInstance) {
        BitcoinManager bitcoinManager = pluginInstance.getBitcoinManager();
        Util util = pluginInstance.getUtil();

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_value", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                return bitcoinManager.getExchangeCurrencySymbol() + util.formatNumber(bitcoinManager.getBitcoinValue());
            }
        });

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_bank", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                return util.formatNumber(bitcoinManager.getAmountInBank());
            }
        });

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_tax", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                return bitcoinManager.getPurchaseTaxPercentage() + "%";
            }
        });

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_circulation", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                return util.formatNumber(bitcoinManager.getBitcoinsInCirculation());
            }
        });

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_circulation_limit", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                return util.formatNumber(bitcoinManager.getCirculationLimit());
            }
        });

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_balance", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                if (placeholderReplaceEvent.getOfflinePlayer() == null) {
                    return "";
                } else {
                    return util.formatNumber(bitcoinManager.getBalance(placeholderReplaceEvent.getOfflinePlayer().getUniqueId()));
                }
            }
        });

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_amount_mined", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                if (placeholderReplaceEvent.getOfflinePlayer() == null) {
                    return "";
                } else {
                    return util.formatNumber(bitcoinManager.getBitcoinsMined(placeholderReplaceEvent.getOfflinePlayer().getUniqueId()));
                }
            }
        });

        PlaceholderAPI.registerPlaceholder(pluginInstance, "bitcoin_puzzles_solved", new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {
                if (placeholderReplaceEvent.getOfflinePlayer() == null) {
                    return "";
                } else {
                    return util.formatNumber(bitcoinManager.getPuzzlesSolved(placeholderReplaceEvent.getOfflinePlayer().getUniqueId()));
                }
            }
        });
    }
}
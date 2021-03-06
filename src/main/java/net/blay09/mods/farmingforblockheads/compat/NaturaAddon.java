package net.blay09.mods.farmingforblockheads.compat;

import net.blay09.mods.farmingforblockheads.api.FarmingForBlockheadsAPI;
import net.blay09.mods.farmingforblockheads.api.MarketRegistryDefaultHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class NaturaAddon {

    private static final String KEY_SAPLINGS = "Natura Saplings";
    private static final String KEY_BUSHES = "Natura Bushes";
    private static final String KEY_NETHER_BUSHES = "Natura Nether Bushes";
    private static final String KEY_SEEDS = "Natura Seeds";

    public NaturaAddon() {
        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_SEEDS, new MarketRegistryDefaultHandler() {
            @Override
            public void apply(ItemStack defaultPayment) {
                apply(defaultPayment, 1);
            }

            @Override
            public void apply(ItemStack defaultPayment, int defaultAmount) {
                final String[] SEEDS = new String[]{"overworld_seeds"};

                for (String SEED : SEEDS) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, SEED);
                    if (Item.REGISTRY.containsKey(location)) {
                        Item itemSeed = Item.REGISTRY.getObject(location);
                        for (int j = 0; j <= 1; j++) {
                            ItemStack seedStack = new ItemStack(itemSeed, defaultAmount, j);
                            FarmingForBlockheadsAPI.registerMarketEntry(seedStack, defaultPayment, FarmingForBlockheadsAPI.getMarketCategorySeeds());
                        }
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD);
            }
        });

        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_SAPLINGS, new MarketRegistryDefaultHandler() {
            @Override
            public void apply(ItemStack defaultPayment) {
                apply(defaultPayment, 1);
            }

            @Override
            public void apply(ItemStack defaultPayment, int defaultAmount) {
                final String[] SAPLINGS = new String[]{"overworld_sapling", "overworld_sapling2", "redwood_sapling"};

                for (int i = 0; i < SAPLINGS.length; i++) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, SAPLINGS[i]);
                    if (Block.REGISTRY.containsKey(location)) {
                        Block blockSapling = Block.REGISTRY.getObject(location);
                        for (int j = 0; j < (i == 2 ? 1 : 4); j++) {
                            ItemStack saplingStack = new ItemStack(blockSapling, defaultAmount, j);
                            FarmingForBlockheadsAPI.registerMarketEntry(saplingStack, defaultPayment, FarmingForBlockheadsAPI.getMarketCategorySaplings());
                        }
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD);
            }
        });

        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_BUSHES, new MarketRegistryDefaultHandler() {
            @Override
            public void apply(ItemStack defaultPayment) {
                apply(defaultPayment, 1);
            }

            @Override
            public void apply(ItemStack defaultPayment, int defaultAmount) {
                final String[] BUSHES = new String[]{"overworld_berrybush_raspberry", "overworld_berrybush_blueberry", "overworld_berrybush_blackberry", "overworld_berrybush_maloberry"};

                for (String BUSH : BUSHES) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, BUSH);
                    if (Block.REGISTRY.containsKey(location)) {
                        Block blockBush = Block.REGISTRY.getObject(location);
                        ItemStack bushStack = new ItemStack(blockBush, defaultAmount);
                        FarmingForBlockheadsAPI.registerMarketEntry(bushStack, defaultPayment, FarmingForBlockheadsAPI.getMarketCategorySaplings());
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD, 2);
            }
        });

        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_NETHER_BUSHES, new MarketRegistryDefaultHandler() {
            @Override
            public void apply(ItemStack defaultPayment) {
                apply(defaultPayment, 1);
            }

            @Override
            public void apply(ItemStack defaultPayment, int defaultAmount) {
                final String[] BUSHES = new String[]{"nether_berrybush_blightberry", "nether_berrybush_duskberry", "nether_berrybush_skyberry", "nether_berrybush_stingberry"};

                for (String BUSH : BUSHES) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, BUSH);
                    if (Block.REGISTRY.containsKey(location)) {
                        Block blockBush = Block.REGISTRY.getObject(location);
                        ItemStack bushStack = new ItemStack(blockBush, defaultAmount);
                        FarmingForBlockheadsAPI.registerMarketEntry(bushStack, defaultPayment, FarmingForBlockheadsAPI.getMarketCategorySaplings());
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD, 3);
            }
        });
    }

}

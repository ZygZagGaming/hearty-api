package io.github.zygzaggaming.hearty.api;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(ApiMain.MODID)
public class ApiMain {
    public static final String MODID = "heartyapi";
    public static final Logger LOGGER = LogUtils.getLogger();
    public ApiMain(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}
}

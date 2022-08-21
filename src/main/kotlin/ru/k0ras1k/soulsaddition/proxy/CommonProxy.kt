package ru.k0ras1k.soulsaddition.proxy

import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.network.NetworkRegistry
import ru.k0ras1k.soulsaddition.SoulsAddition
import ru.k0ras1k.soulsaddition.handlers.GuiHandler
import ru.k0ras1k.soulsaddition.register.BlockReg
import ru.k0ras1k.soulsaddition.register.ItemReg

open class CommonProxy {
    fun pre(e: FMLPreInitializationEvent) {
        ItemReg().register()
        BlockReg().register()
    }

    fun init(e: FMLInitializationEvent) {
        NetworkRegistry.INSTANCE.registerGuiHandler(SoulsAddition.instance(), GuiHandler())
    }

    fun post(e: FMLPostInitializationEvent) {

    }
}
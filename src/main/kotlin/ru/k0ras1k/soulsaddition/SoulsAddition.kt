package ru.k0ras1k.soulsaddition

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraft.creativetab.CreativeTabs
import ru.k0ras1k.soulsaddition.proxy.CommonProxy
import ru.k0ras1k.soulsaddition.utils.SoulsAdditionTab

@Mod(modid = "soulsaddition", name = "soulsaddition", version = "0.1")
object SoulsAddition {

    init {
        SoulsAdditionTab
    }

    @JvmStatic
    @SidedProxy(clientSide = "ru.k0ras1k.soulsaddition.proxy.ClientProxy", serverSide = "ru.k0ras1k.soulsaddition.proxy.CommonProxy")
    lateinit var proxy: CommonProxy

    @JvmStatic
    @Mod.InstanceFactory
    fun instance() = SoulsAddition

    @Mod.EventHandler
    fun pre(e: FMLPreInitializationEvent) {
        proxy.pre(e)
    }

    @Mod.EventHandler
    fun init(e: FMLInitializationEvent) {
        proxy.init(e)
    }

    @Mod.EventHandler
    fun post(e: FMLPostInitializationEvent) {
        proxy.post(e)
    }



}
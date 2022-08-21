package ru.k0ras1k.soulsaddition.handlers

import cpw.mods.fml.common.network.IGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import ru.k0ras1k.soulsaddition.machines.container.ContainerSoulImporter
import ru.k0ras1k.soulsaddition.machines.gui.GuiSoulImporter
import ru.k0ras1k.soulsaddition.machines.tiles.TileEntitySoulImporter

class GuiHandler: IGuiHandler {
    override fun getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        val tileEntity: TileEntity? = world.getTileEntity(x, y, z)
        if (tileEntity != null) {
            when (ID) {
                1 ->
                    if (tileEntity is TileEntitySoulImporter) {
                        return ContainerSoulImporter(player.inventory, tileEntity)
                    }
            }
        }
        return null
    }

    override fun getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        val tileEntity: TileEntity? = world.getTileEntity(x, y, z)
        if (tileEntity != null) {
            when (ID) {
                1 ->
                    if (tileEntity is TileEntitySoulImporter) {
                        return GuiSoulImporter(player.inventory, tileEntity)
                    }
            }
        }
        return null
    }
}
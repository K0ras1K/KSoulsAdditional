package ru.k0ras1k.soulsaddition.blocks

import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import ru.k0ras1k.soulsaddition.SoulsAddition
import ru.k0ras1k.soulsaddition.machines.tiles.TileEntitySoulImporter
import ru.k0ras1k.soulsaddition.utils.SoulsAdditionTab

class BlockSoulImporter: BlockContainer(Material.iron) {

    init {
        setBlockName("block_soul_importer")
        setCreativeTab(SoulsAdditionTab)
        setLightLevel(1F)
    }

    override fun createNewTileEntity(p_149915_1_: World?, p_149915_2_: Int): TileEntity {
        return TileEntitySoulImporter()
    }

    override fun onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, par6: Int, par7: Float, par8: Float, par9: Float): Boolean {
        val tileEntity: TileEntity? = world.getTileEntity(x, y, z)
        if (tileEntity == null || player.isSneaking) {
            return false
        }
        if (world.isRemote) {
            player.openGui(SoulsAddition.instance(), 1, world, x, y, z)
        }
        return true
    }
}
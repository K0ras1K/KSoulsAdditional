package ru.k0ras1k.soulsaddition.register

import cpw.mods.fml.common.registry.GameRegistry
import ru.k0ras1k.soulsaddition.machines.tiles.TileEntitySoulImporter

class BlockReg {
    fun register() {
        GameRegistry.registerBlock(BlockList().BLOCK_SOUL_IMPORTER, "block_soul_importer")
        GameRegistry.registerTileEntity(TileEntitySoulImporter::class.java, "tile_entity_soul_importer")
    }
}
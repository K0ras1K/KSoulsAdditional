package ru.k0ras1k.soulsaddition.machines.gui

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import net.minecraft.util.StatCollector
import org.lwjgl.opengl.GL11
import ru.k0ras1k.soulsaddition.machines.container.ContainerSoulImporter
import ru.k0ras1k.soulsaddition.machines.tiles.TileEntitySoulImporter

class GuiSoulImporter(player: InventoryPlayer, tileEntitySoulImporter: TileEntitySoulImporter): GuiContainer(ContainerSoulImporter(player, tileEntitySoulImporter)) {

    val guiTexture: ResourceLocation = ResourceLocation("soulsaddition", "textures/gui/gui_soul_importer.png")

    init {
        val tileEntity: TileEntitySoulImporter = tileEntitySoulImporter
    }

    override fun drawGuiContainerBackgroundLayer(p_146976_1_: Float, p_146976_2_: Int, p_146976_3_: Int) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.textureManager.bindTexture(guiTexture)
        var k: Int = (width - xSize) / 2
        var l: Int = (height - ySize) / 2
        drawTexturedModalRect(k, l, 0, 0, xSize, ySize)
    }

    override fun drawGuiContainerForegroundLayer(p_146979_1_: Int, p_146979_2_: Int) {
        var s: String = StatCollector.translateToLocal("container.soul_importer")
        fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 13487565)
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 13487565);
    }

}
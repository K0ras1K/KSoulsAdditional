package ru.k0ras1k.soulsaddition.machines.container

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.inventory.Container
import net.minecraft.inventory.Slot
import net.minecraft.item.ItemStack
import ru.k0ras1k.soulsaddition.machines.tiles.TileEntitySoulImporter

class ContainerSoulImporter(player: InventoryPlayer, tileEntity: TileEntitySoulImporter): Container() {

    init {
        val tileEntitySoulImporter: TileEntitySoulImporter = tileEntity
        addSlotToContainer(Slot(tileEntitySoulImporter, 0, 80, 35))
        for (i in 0..2) {
            for (j in 0..8) {
                addSlotToContainer(Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + j * 18))
            }
        }
        for (i in 0..8) {
            addSlotToContainer(Slot(player, i, 8 + i * 18, 142))
        }
    }

    override fun canInteractWith(entityPlayer: EntityPlayer): Boolean {
        return true
    }

    override fun transferStackInSlot(entityPlayer: EntityPlayer, id: Int): ItemStack? {
        var stack: ItemStack? = null
        val mySlotsCount = 1
        val mainInventorySlotsEnd = 27 + mySlotsCount
        val hotBarslotsEnd = inventorySlots.size
        val slotObject = inventorySlots[id] as Slot?
        if (slotObject != null && slotObject.hasStack) {
            val stackInSlot = slotObject.stack
            stack = stackInSlot.copy()
            if (id <= 1) {
                if (!mergeItemStack(stackInSlot, mainInventorySlotsEnd, hotBarslotsEnd, false) && !mergeItemStack(
                        stackInSlot,
                        mySlotsCount,
                        mainInventorySlotsEnd,
                        false
                    )
                ) {
                    return null
                }
            } else if (id >= mySlotsCount && id < mainInventorySlotsEnd) {
                if (!mergeItemStack(stackInSlot, 0, 1, false) && !mergeItemStack(
                        stackInSlot,
                        mainInventorySlotsEnd,
                        hotBarslotsEnd,
                        false
                    )
                ) {
                    return null
                }
            } else if (id >= mainInventorySlotsEnd && id < hotBarslotsEnd && !mergeItemStack(
                    stackInSlot,
                    0,
                    1,
                    false
                ) && !mergeItemStack(stackInSlot, mySlotsCount, mainInventorySlotsEnd, false)
            ) {
                return null
            }
            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null as ItemStack?)
            } else {
                slotObject.onSlotChanged()
            }
            if (stack.stackSize == stackInSlot.stackSize) {
                return null
            }
            slotObject.onPickupFromSlot(entityPlayer, stackInSlot)
        }

        return stack
    }
}
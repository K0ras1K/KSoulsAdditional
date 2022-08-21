package ru.k0ras1k.soulsaddition.machines.tiles

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity

class TileEntitySoulImporter: TileEntity(), IInventory {

    var storage_slot: ItemStack? = null
    var progress: Int = 0


    override fun readFromNBT(nbtTagCompound: NBTTagCompound) {
        super.readFromNBT(nbtTagCompound)
        storage_slot = ItemStack.loadItemStackFromNBT(nbtTagCompound.getCompoundTag("storage_slot"))
        progress = nbtTagCompound.getInteger("progress")
    }

    override fun writeToNBT(nbtTagCompound: NBTTagCompound) {
        super.writeToNBT(nbtTagCompound)
        nbtTagCompound.setInteger("progress", progress)
        if (storage_slot != null) {
            var nbtTagCompound1: NBTTagCompound = NBTTagCompound()
            storage_slot!!.writeToNBT(nbtTagCompound1)
            nbtTagCompound.setTag("storage_slot", nbtTagCompound1)
        }
    }

    override fun getSizeInventory(): Int {
        return 1
    }

    override fun getStackInSlot(id: Int): ItemStack? {
        if (storage_slot != null) {
            return storage_slot!!
        }
        return null
    }

    override fun decrStackSize(index: Int, amount: Int): ItemStack? {
        val itemStack = getStackInSlot(index)
        return if (itemStack == null) {
            null
        } else if (amount >= itemStack.stackSize) {
            setInventorySlotContents(index, (null as ItemStack?)!!)
            itemStack
        } else {
            itemStack.stackSize -= amount
            val ret = itemStack.copy()
            ret.stackSize = amount
            ret
        }
    }

    override fun getStackInSlotOnClosing(id: Int): ItemStack? {
        return storage_slot
    }

    override fun setInventorySlotContents(slot: Int, itemStack: ItemStack) {
        storage_slot = itemStack
        if (itemStack != null && itemStack.stackSize > inventoryStackLimit) {
            itemStack.stackSize = inventoryStackLimit
        }
    }

    override fun getInventoryName(): String {
        return "container.soul_importer"
    }

    override fun hasCustomInventoryName(): Boolean {
        return false
    }

    override fun getInventoryStackLimit(): Int {
        return 64
    }

    override fun isUseableByPlayer(p_70300_1_: EntityPlayer?): Boolean {
        return true
    }

    override fun openInventory() {

    }

    override fun closeInventory() {

    }

    override fun isItemValidForSlot(p_94041_1_: Int, p_94041_2_: ItemStack?): Boolean {
        return true
    }
}
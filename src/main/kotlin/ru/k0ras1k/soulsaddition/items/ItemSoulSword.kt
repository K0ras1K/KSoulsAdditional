package ru.k0ras1k.soulsaddition.items

import net.minecraft.client.Minecraft
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemSword
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World
import ru.k0ras1k.soulsaddition.utils.SoulsAdditionTab

class ItemSoulSword : ItemSword(ToolMaterial.EMERALD) {

    init {
        setCreativeTab(SoulsAdditionTab)
        setUnlocalizedName("item_soul_sword")
        setTextureName("soulsaddition:item_soul_sword")
    }

    override fun hitEntity(itemStack: ItemStack, entityLivingBase: EntityLivingBase, entityLivingBase1: EntityLivingBase): Boolean {
        var nbtTagCompound: NBTTagCompound? = itemStack.tagCompound
        if (nbtTagCompound == null) {
            nbtTagCompound = NBTTagCompound()
            itemStack.tagCompound = nbtTagCompound
            nbtTagCompound.setInteger("souls", 0)
        }
        addSoulsToItem(nbtTagCompound, entityLivingBase)
        entityLivingBase.health = 0F
        return super.hitEntity(itemStack, entityLivingBase, entityLivingBase1)
    }


    fun addSoulsToItem(nbtTagCompound: NBTTagCompound, entityLivingBase: EntityLivingBase) {
        nbtTagCompound.setInteger(
            "souls",
            (nbtTagCompound.getInteger("souls").plus(entityLivingBase.maxHealth.toInt()))
        )
    }

    override fun addInformation(itemStack: ItemStack, entityPlayer: EntityPlayer, list: MutableList<Any?>, bool1: Boolean) {
        val nbtTagCompound: NBTTagCompound? = itemStack.tagCompound
        if (nbtTagCompound != null) {
            list.add("Количество душ - ${nbtTagCompound.getInteger("souls")}")
        }
        else {
            list.add("Количество душ - 0")
        }
    }

}
package ru.k0ras1k.soulsaddition.utils

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import ru.k0ras1k.soulsaddition.register.ItemList

object SoulsAdditionTab: CreativeTabs("SoulsAdditionTab") {

    override fun getTabIconItem(): Item {
        return ItemList().ITEM_SOUL_SWORD
    }
}
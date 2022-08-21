package ru.k0ras1k.soulsaddition.register

import cpw.mods.fml.common.registry.GameRegistry

class ItemReg {


    fun register() {
        GameRegistry.registerItem(ItemList().ITEM_SOUL_SWORD, "item_soul_sword")
    }

}
package org.example.exmod.items

import com.github.puzzle.core.Identifier
import com.github.puzzle.core.resources.ResourceLocation
import com.github.puzzle.game.items.IModItem
import com.github.puzzle.game.items.data.DataTagManifest
import finalforeach.cosmicreach.blocks.BlockState
import finalforeach.cosmicreach.items.ItemStack
import org.example.exmod.Constants

class ExamplePickaxe : IModItem {

    var tagManifest: DataTagManifest = DataTagManifest()
    var id: Identifier = Identifier(Constants.MOD_ID, "example_pickaxe")

    fun ExamplePickaxe() {
        tagManifest.addTag(
            IModItem.TEXTURE_LOCATION_PRESET.createTag(
                ResourceLocation(
                    Constants.MOD_ID,
                    "textures/items/example_pickaxe.png"
                )
            )
        )
        tagManifest.addTag(IModItem.MODEL_ID_PRESET.createTag(IModItem.MODEL_2_5D_ITEM))
    }

    override fun isTool(): Boolean {
        return true
    }

    override fun getEffectiveBreakingSpeed(stack: ItemStack): Float {
        return if (stack.item == this) 2.0f else 1.0f
    }

    override fun isEffectiveBreaking(itemStack: ItemStack?, blockState: BlockState): Boolean {
        return blockState.blockId == "base:aluminium_panel" || blockState.blockId == "base:asphalt" || blockState.blockId == "base:boombox" || blockState.blockId == "base:c4" || blockState.blockId == "base:hazard" || blockState.blockId == "base:light" || blockState.blockId == "base:magma" || blockState.blockId == "base:metal_panel" || blockState.blockId == "base:stone_basalt" || blockState.blockId == "base:stone_gabbro" || blockState.blockId == "base:stone_limestone" || blockState.blockId == "base:lunar_soil_packed"
    }

    override fun getIdentifier(): Identifier {
        return id
    }

    override fun getTagManifest(): DataTagManifest {
        return tagManifest
    }

    override fun isCatalogHidden(): Boolean {
        return false
    }
}
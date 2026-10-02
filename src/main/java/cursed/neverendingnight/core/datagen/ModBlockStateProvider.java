package cursed.neverendingnight.core.datagen;

import cursed.neverendingnight.Neverendingnight;
import cursed.neverendingnight.core.util.UniversalCommon;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.block;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Neverendingnight.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    private void blockWithItem(Block block) {
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockFloor(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeBottomTop("block/" + blockRegistryObject.getId().getPath(),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_side"),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_bottom"),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_top")));
    }

    private void slabFloor(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeBottomTop("block/" + blockRegistryObject.getId().getPath(),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_side"),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_bottom"),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_top")));
    }

    private void blockColumn(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeColumn("block/" + blockRegistryObject.getId().getPath(),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath()),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_top")));
    }

    private void blockColumnHorizontal(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeColumnHorizontal("block/" + blockRegistryObject.getId().getPath() + "_horizontal",
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath()),
                UniversalCommon.modRL(
                        "block/" + blockRegistryObject.getId().getPath() + "_top")));
    }
}


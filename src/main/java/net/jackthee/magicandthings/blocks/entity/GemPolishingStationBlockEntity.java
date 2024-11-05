package net.jackthee.magicandthings.blocks.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jackthee.magicandthings.item.ModItems;
import net.jackthee.magicandthings.recipe.GemPolishingRecipe;
import net.jackthee.magicandthings.screen.GemPolishingScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GemPolishingStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> Inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate PropertyDelegate;
    private int Progress = 0;
    private int MaxProgress = 72;


    public GemPolishingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEM_POLISHING_STATION_BLOCK_ENTITY, pos, state);
        this.PropertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0-> GemPolishingStationBlockEntity.this.Progress;
                    case 1-> GemPolishingStationBlockEntity.this.MaxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0-> GemPolishingStationBlockEntity.this.Progress = value;
                    case 1-> GemPolishingStationBlockEntity.this.MaxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(this.pos);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return Inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,Inventory);
        nbt.putInt("gem_polishing_station.progress",Progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,Inventory);
        Progress = nbt.getInt("gem_polishing_station.progress");
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("displayname.magicandthings.gem_polishing_station");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GemPolishingScreenHandler(syncId,playerInventory,this,this.PropertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient){
            return;
        }
        if (isOutputSlotEmptyOrRecievable()){
            if (this.hasRecipe()){
                this.increaseCraftProgress();
                markDirty(world,pos,state);
                if (hasCraftingFinished()){
                    this.craftItem();
                    this.resetProgress();
                }
            }else {
                this.resetProgress();
            }
        }else {
            this.resetProgress();
            markDirty(world,pos,state);
        }
    }

    private void resetProgress() {
        this.Progress=0;
    }

    private void craftItem() {
        Optional<GemPolishingRecipe> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT,1);

        this.setStack(OUTPUT_SLOT,new ItemStack(recipe.get().getOutput(null).getItem()
                ,getStack(OUTPUT_SLOT).getCount()+recipe.get().getOutput(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return Progress >= MaxProgress;
    }

    private void increaseCraftProgress() {
        Progress++;
    }

    private boolean hasRecipe() {

        Optional<GemPolishingRecipe> recipe = getCurrentRecipe();



        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().getOutput(null))
                && canInsertItemIntoOutputSlot(recipe.get().getOutput(null).getItem());
    }

    private Optional<GemPolishingRecipe> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i= 0;i<this.size();i++){
            inv.setStack(i,this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(GemPolishingRecipe.Type.INSTANCE,inv,getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrRecievable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() <this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}

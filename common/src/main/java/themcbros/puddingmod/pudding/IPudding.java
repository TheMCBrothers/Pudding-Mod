package themcbros.puddingmod.pudding;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import themcbros.puddingmod.PuddingMod;

public interface IPudding {

    /**
     * @return Name of pudding sort
     */
    String getName();

    /**
     * This is used for {@link net.minecraft.client.color.item.ItemColors}
     * @return Color of the pudding
     */
    default int getColor() {
        return -1;
    }

    /**
     * Used for {@link FoodProperties} creation
     * @return Nutrition (default 6)
     */
    default int getNutrition() {
        return 6;
    }

    /**
     * Used for {@link FoodProperties} creation
     * @return Food saturation as float (default 0.6F)
     */
    default float getSaturationModifier() {
        return 0.6F;
    }

    /**
     * @param pudding The Pudding
     * @return {@link BowlFoodItem} with {@link FoodProperties} and creative tab
     */
    static BowlFoodItem getPuddingItem(IPudding pudding) {
        FoodProperties foodProperties = new FoodProperties.Builder()
                .nutrition(pudding.getNutrition())
                .saturationMod(pudding.getSaturationModifier())
                .build();
        return new BowlFoodItem(new Item.Properties().food(foodProperties).craftRemainder(Items.BOWL).stacksTo(16).tab(PuddingMod.PUDDING_TAB));
    }

}

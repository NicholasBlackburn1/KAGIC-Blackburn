package mod.kagic.advancements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mod.kagic.init.KAGIC;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.client.gui.toasts.AdvancementToast;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ModTriggers


    {
       
        public static final CustomTrigger MOD_START = new CustomTrigger("mod_start");
        //Location advancdements 
        public static final CustomTrigger BATTLE_FIELD = new CustomTrigger("straw_berry");
        public static final CustomTrigger GALAXY_WARP = new CustomTrigger("galaxy_warp");
        public static final CustomTrigger DESERT_TEMPLE = new CustomTrigger("desert_temple");
        public static final CustomTrigger COMMUNICATION_HUB = new CustomTrigger("communication_hub");
        public static final CustomTrigger KINDERGARDEN = new CustomTrigger("kindergarden");
        public static final CustomTrigger MOON_GODAS = new CustomTrigger("moon_godas");
        public static final CustomTrigger HEAVEN_BEATLE = new CustomTrigger("heaven_beatle");
        
        //Fusion Advancements
        public static final CustomTrigger STRONGER_TOGETHER = new CustomTrigger("stronger_together");
        public static final CustomTrigger GIANT_WOMEN = new CustomTrigger("giant_women");
        public static final CustomTrigger OFF_COLORS = new CustomTrigger("off_colors");

        //Gem  Advacements
        public static final CustomTrigger YOU_CLOD = new CustomTrigger("you_clod");
        public static final CustomTrigger ARE_YOU_MY_DAD = new CustomTrigger("my_dad");

        //Gem Drill Advancements 
        public static final CustomTrigger REACTIVATE_KINDERGARED = new CustomTrigger("reactivate_kindergarden");

        //aristocrat Advancements
        public static final CustomTrigger ARISTORCA_BULLY = new CustomTrigger("aristocrat_bully");
        public static final CustomTrigger BLUE_DIAMOND_AUTHORITY = new CustomTrigger("blue_diamond_authority");
        public static final CustomTrigger YELLOW_DIAMOND_AUTHORTY= new CustomTrigger("yellow_diamond_authority");
        public static final CustomTrigger WHITE_DIAMOND_AUTHORTY= new CustomTrigger("white_diamond_authority");

        //Warp pad Advancemets
        public static final CustomTrigger EXPLORE_WARPS = new CustomTrigger("explore_warp");
        public static final CustomTrigger WARP_MASTER = new CustomTrigger("warp_master");
        public static final CustomTrigger FROM_HERE_T0_HOMEWORLD = new CustomTrigger("from_here_to_home_world");

        // Player Dies Advancements 
        public static final CustomTrigger GETTING_PRICKED = new CustomTrigger("getting_pricked");
        /*
         * This array just makes it convenient to register all the criteria.
         */
        public static final CustomTrigger[] TRIGGER_ARRAY = new CustomTrigger[] {
            MOD_START,BATTLE_FIELD,GALAXY_WARP,DESERT_TEMPLE,COMMUNICATION_HUB,KINDERGARDEN,MOON_GODAS, HEAVEN_BEATLE,STRONGER_TOGETHER,GIANT_WOMEN, OFF_COLORS, YOU_CLOD,ARE_YOU_MY_DAD,
            REACTIVATE_KINDERGARED,ARISTORCA_BULLY, BLUE_DIAMOND_AUTHORITY,YELLOW_DIAMOND_AUTHORTY,WHITE_DIAMOND_AUTHORTY,EXPLORE_WARPS,WARP_MASTER,FROM_HERE_T0_HOMEWORLD,GETTING_PRICKED

                };
    
    
        /**
         * This method is part of my simple custom advancement triggering tutorial.
         * See: http://jabelarminecraft.blogspot.com/p/minecraft-modding-custom-triggers-aka.html
         */
        public static void registerTriggers()
        {
            // DEBUG
            KAGIC.logger.debug("Registering custom triggers");
            
            Method method;
    
            method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a", ICriterionTrigger.class);
    
            method.setAccessible(true);
            
    
            for (int i=0; i < TRIGGER_ARRAY.length; i++)
            {
                 try
                {
                    method.invoke(null, TRIGGER_ARRAY[i]);
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    // TODO Auto-generated catch block
                    KAGIC.logger.debug(e);
                }
            } 
        }
    }
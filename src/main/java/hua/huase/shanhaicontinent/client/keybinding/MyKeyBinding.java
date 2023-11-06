package hua.huase.shanhaicontinent.client.keybinding;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;
public class MyKeyBinding extends KeyBinding {
    public static final KeyBinding MYKEY_P = new KeyBinding("key.shanhaicontinent.mykey_p", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, Keyboard.KEY_P, "key.shanhai");
    public static final KeyBinding MYKEY_O = new KeyBinding("key.shanhaicontinent.mykey_o", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, Keyboard.KEY_O, "key.shanhai");
    public static final KeyBinding MYKEY_K = new KeyBinding("key.shanhaicontinent.mykey_K", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, Keyboard.KEY_K, "key.shanhai");
    public static final KeyBinding MYKEY_R = new KeyBinding("key.shanhaicontinent.mykey_R", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, Keyboard.KEY_R, "key.shanhai");
//    public static final KeyBinding MYKEY_L = new KeyBinding("key.shanhaicontinent.mykey_L", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, Keyboard.KEY_L, "key.category_L.mymod");
    //    public static final KeyBinding MYKEY_U = new KeyBinding("key.shanhaicontinent.mykey_u", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, Keyboard.KEY_U, "key.category_u.mymod");
    public static void init() {
        ClientRegistry.registerKeyBinding(MYKEY_P);
        ClientRegistry.registerKeyBinding(MYKEY_O);
        ClientRegistry.registerKeyBinding(MYKEY_K);
        ClientRegistry.registerKeyBinding(MYKEY_R);
//        ClientRegistry.registerKeyBinding(MYKEY_L);
//        ClientRegistry.registerKeyBinding(MYKEY_U);
    }
    public MyKeyBinding(String description, int keyCode, String category) {
        super(description, keyCode, category);
    }

    public MyKeyBinding(String description, IKeyConflictContext keyConflictContext, int keyCode, String category) {
        super(description, keyConflictContext, keyCode, category);
    }

    public MyKeyBinding(String description, IKeyConflictContext keyConflictContext, KeyModifier keyModifier, int keyCode, String category) {
        super(description, keyConflictContext, keyModifier, keyCode, category);
    }
}

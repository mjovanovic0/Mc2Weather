package hr.tvz.mc2.custom;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mjovanovic on 13.03.14..
 */
public final class FontCache {

    private static Map<String, Typeface> cacheMap = new HashMap<String, Typeface>();

    public static Typeface getFont(Context ctx, String key){
        if(!cacheMap.containsKey(key)){
            Typeface font = null;
            try {
                font = Typeface.createFromAsset(ctx.getAssets(), "fonts/" + key + ".ttf");
                cacheMap.put(key, font);
            }catch (Exception e){
            }
            return font;
        }
        return cacheMap.get(key);
    }

}

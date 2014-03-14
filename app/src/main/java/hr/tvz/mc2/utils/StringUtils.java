package hr.tvz.mc2.utils;

import android.content.Context;

/**
 * Created by mjovanovic on 13.03.14..
 */
public final class StringUtils {

    public static final String build(Object...objs){
        StringBuffer sb = new StringBuffer();
        for(Object obj : objs){ sb.append(obj); }
        return sb.toString();
    }


    public static String getStringByName(Context ctx, Object...names) {
        String value = ctx.getString(ctx.getResources().getIdentifier(build(names), "string", ctx.getPackageName()));
        if(value == null){
            value = build("??? ", build(names), " ???");
        }
        return value;
    }
}

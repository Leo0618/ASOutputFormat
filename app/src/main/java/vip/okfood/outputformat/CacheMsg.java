package vip.okfood.outputformat;

import java.util.ArrayList;
import java.util.List;

/**
 * function:
 *
 * <p>
 * Created by Leo on 2018/9/21.
 */
public class CacheMsg {

    private static List<String> datas = new ArrayList<>();

    static {
        datas.add("static-Init静态初始化数据");
    }

    public static void add(String msg) {
        datas.add(msg);
    }

    public static void clean() {
        datas.clear();
    }

    public static String msgList() {
        StringBuilder result = new StringBuilder();
        for(String data : datas) {
            result.append(data).append("\n");
        }
        return result.toString();
    }
}

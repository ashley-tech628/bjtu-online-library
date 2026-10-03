package com.framework.common.tools.uuid;

/**
 * ID生成器工具类
 * @author bjtuwh
 * @date 2021年07月30日
 */
public class IdUtils {
    private static SnowFlake snowFlake = null;
    static {
        snowFlake = new SnowFlake(0, 0);
    }
    /**
     * 获取随机UUID
     * @return 随机UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID() {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     * @return 随机UUID
     */
    public static String fastUUID() {
        return UUID.fastUUID().toString();
    }
    public static String getSnowFlakeId(){
        long id = snowFlake.nextId();
        String snowId = String.valueOf(id);
        return snowId;
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID() {
        return UUID.fastUUID().toString(true);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String s = IdUtils.fastSimpleUUID();
            System.out.println("s="+s);
        }

    }
}

///**
// */
//package com.bjtuwh.common.cache;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
///***
// * Date:2021/6/26
// * Title: 分布式锁
// * Description：对本文件的详细描述，原则上不能少于30字
// * @author Admin
// * @mender：（文件的修改者，文件创建者之外的人）
// * @version 1.0
// * Remark：认为有必要的其他信息
// */
//@Slf4j
//@Component
//public class DistributedLockHandler {
//    /**TODO:modi by zbr on 20210726 暂时屏蔽redis*/
//    /**单个业务持有锁的时间30s，防止死锁*/
//    private final static long LOCK_EXPIRE = 30 * 1000L;
//    /**默认30ms尝试一次*/
//    private final static long LOCK_TRY_INTERVAL = 30L;
//    /**默认尝试20s*/
//    private final static long LOCK_TRY_TIMEOUT = 20 * 1000L;
//
//    /**系统名称*/
//    @Value("${spring.application.name}")
//    private String applicationName;
//
//    @Autowired
//    private StringRedisTemplate template;
//
//
//    /***
//     * Date:2021/6/26
//     * Title: 全局锁，包括锁的名称
//     * Description：对本文件的详细描述，原则上不能少于30字
//     * @author Admin
//     * @mender：（文件的修改者，文件创建者之外的人）
//     * @version 1.0
//     * Remark：认为有必要的其他信息
//     */
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public class LockEntity {
//        private String name;
//        private String value;
//    }
//
//
//
//
//    /**
//     * 尝试获取全局锁
//     *
//     * @param lock 锁的名称
//     * @return true 获取成功，false获取失败
//     */
//    public boolean tryLock(LockEntity lock) {
//        return getLock(lock, LOCK_TRY_TIMEOUT, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
//    }
//
//    /**
//     * 尝试获取全局锁
//     *
//     * @param lock    锁的名称
//     * @param timeout 获取超时时间 单位ms
//     * @return true 获取成功，false获取失败
//     */
//    public boolean tryLock(LockEntity lock, long timeout) {
//        return getLock(lock, timeout, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
//    }
//
//    /**
//     * 尝试获取全局锁
//     *
//     * @param lock        锁的名称
//     * @param timeout     获取锁的超时时间
//     * @param tryInterval 多少毫秒尝试获取一次
//     * @return true 获取成功，false获取失败
//     */
//    public boolean tryLock(LockEntity lock, long timeout, long tryInterval) {
//        return getLock(lock, timeout, tryInterval, LOCK_EXPIRE);
//    }
//
//    /**
//     * 尝试获取全局锁
//     *
//     * @param lock           锁的名称
//     * @param timeout        获取锁的超时时间
//     * @param tryInterval    多少毫秒尝试获取一次
//     * @param lockExpireTime 锁的过期
//     * @return true 获取成功，false获取失败
//     */
//    public boolean tryLock(LockEntity lock, long timeout, long tryInterval, long lockExpireTime) {
//        return getLock(lock, timeout, tryInterval, lockExpireTime);
//    }
//
//
//    /**
//     * 操作redis获取全局锁
//     * @param lock           锁的名称
//     * @param timeout        获取的超时时间
//     * @param tryInterval    多少ms尝试一次
//     * @param lockExpireTime 获取成功后锁的过期时间
//     * @return true 获取成功，false获取失败
//     */
//    public boolean getLock(LockEntity lock, long timeout, long tryInterval, long lockExpireTime) {
//        try {
//            if (StringUtils.isEmpty(lock.getName()) || StringUtils.isEmpty(lock.getValue())) {
//                return false;
//            }
//            String lockName = applicationName + lock.getName();
//
//            long startTime = System.currentTimeMillis();
//            do{
//                if (!template.hasKey(lockName)) {
//                    log.info("getLock.lock is not exist then setvalue to cache!！！");
//                    ValueOperations<String, String> ops = template.opsForValue();
//                    ops.set(lockName, lock.getValue(), lockExpireTime, TimeUnit.MILLISECONDS);
//                    return true;
//                } else {//存在锁
//                    log.info("getLock.lock is exist!！！");
//                }
//                //尝试超过了设定值之后直接跳出循环
//                if (System.currentTimeMillis() - startTime > timeout){
//                    return false;
//                }
//                Thread.sleep(tryInterval);
//            }
//            while (template.hasKey(lockName)) ;
//        } catch (InterruptedException e) {
//            log.info("DistributedLockHandler.getLock failed! ", e);
//            return false;
//        }
//        return false;
//    }
//
//
//    /**
//     * 释放锁
//     */
//    public void releaseLock(LockEntity lock) {
//        if (!StringUtils.isEmpty(lock.getName())) {
//            String lockName = applicationName + lock.getName();
//
//            template.delete(lockName);
//        }
//    }
//
//
//}

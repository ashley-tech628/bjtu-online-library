/**
 */
package com.framework.common.tools.server;

import com.framework.common.tools.Arith;
import com.framework.common.tools.server.domain.*;
import lombok.Data;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/***
 * Date:2021/6/26
 * Title: 服务器相关信息
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
public class Server {
    /**
     * 阻塞时长
     */
    private static final int WAIT_SECOND = 500;

    /**
     * CPU相关信息
     */
    private Cpu cpu = new Cpu();

    /**
     * 內存相关信息
     */
    private Mem mem = new Mem();

    /**
     * JVM相关信息
     */
    private Jvm jvm = new Jvm();

    /**
     * 服务器相关信息
     */
    private Sys sys = new Sys();

    /**
     * 磁盘相关信息
     */
    private List<Disk> disk = new LinkedList<Disk>();


    /**
     * Function:服务器运行状况
     * Author: Admin
     * Date:2021/6/27
     *
     * @param
     * @return void
     * @throws Exception
     */
    public void copyTo() throws Exception {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        setCpuInfo(hal.getProcessor());
        setMemInfo(hal.getMemory());
        setDisk(si.getOperatingSystem());
        setSysInfo();
        setJvmInfo();
    }


    /**
     * 设置CPU信息
     */
    private void setCpuInfo(CentralProcessor processor) {
        // CPU信息
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(WAIT_SECOND);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[TickType.NICE.getIndex()] - prevTicks[TickType.NICE.getIndex()];
        long irq = ticks[TickType.IRQ.getIndex()] - prevTicks[TickType.IRQ.getIndex()];
        long softirq = ticks[TickType.SOFTIRQ.getIndex()] - prevTicks[TickType.SOFTIRQ.getIndex()];
        long steal = ticks[TickType.STEAL.getIndex()] - prevTicks[TickType.STEAL.getIndex()];
        long cSys = ticks[TickType.SYSTEM.getIndex()] - prevTicks[TickType.SYSTEM.getIndex()];
        long user = ticks[TickType.USER.getIndex()] - prevTicks[TickType.USER.getIndex()];
        long iowait = ticks[TickType.IOWAIT.getIndex()] - prevTicks[TickType.IOWAIT.getIndex()];
        long idle = ticks[TickType.IDLE.getIndex()] - prevTicks[TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        cpu.setCpuNum(processor.getLogicalProcessorCount());
        cpu.setTotal(totalCpu);
        cpu.setSys(cSys);
        cpu.setUsed(user);
        cpu.setWait(iowait);
        cpu.setFree(idle);
    }

    /**
     * 设置内存信息
     */
    private void setMemInfo(GlobalMemory memory) {
        mem.setTotal(convertFileSize(memory.getTotal()));
        mem.setUsed(convertFileSize(memory.getTotal() - memory.getAvailable()));
        mem.setFree(convertFileSize(memory.getAvailable()));
    }

    /**
     * 设置服务器信息
     */
    private void setSysInfo() {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            String computerIp = ia.getHostAddress();
            String computerName = ia.getHostName();

            Properties props = System.getProperties();
            sys.setComputerName(computerName);
            sys.setComputerIp(computerIp);
            sys.setOsName(props.getProperty("os.name"));
            sys.setOsArch(props.getProperty("os.arch"));
            sys.setUserDir(props.getProperty("user.dir"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置Java虚拟机
     */
    private void setJvmInfo() throws UnknownHostException {
        Properties props = System.getProperties();
        jvm.setTotal(convertFileSize(Runtime.getRuntime().totalMemory()));
        jvm.setMax(convertFileSize(Runtime.getRuntime().maxMemory()));
        jvm.setFree(convertFileSize(Runtime.getRuntime().freeMemory()));
        jvm.setVersion(props.getProperty("java.version"));
        jvm.setHome(props.getProperty("java.home"));
    }

    /**
     * 设置磁盘信息
     */
    private void setDisk(OperatingSystem os) {
        FileSystem fileSystem = os.getFileSystem();
        List<OSFileStore> fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            long free = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            long used = total - free;
            Disk sysFile = new Disk();
            sysFile.setDirName(fs.getMount());
            sysFile.setSysTypeName(fs.getType());
            sysFile.setTypeName(fs.getName());
            sysFile.setTotal(convertFileSize(total));
            sysFile.setFree(convertFileSize(free));
            sysFile.setUsed(convertFileSize(used));
            sysFile.setUseDescribe(String.valueOf(Arith.round(Arith.mul(Arith.div(used, total, 4), 100),2)));
            disk.add(sysFile);
        }
    }

    /**
     * 字节转换
     * @param size 字节大小
     * @return 转换后值
     */
    private String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else {
            return String.format("%d B", size);
        }
    }
}

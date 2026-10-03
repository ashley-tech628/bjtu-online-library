package com.framework.common.tools;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/***
 * 创建日期:2022/1/10
 * Title: 图片工具，对图片进行压缩
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author willz
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Slf4j
public class ImageUtil {
    //根据系统的不同，或许相应的分隔符
    private static String fileSeparator = System.getProperty("file.separator");
    //原图片存放的文件夹
    private static String targetOriginAddr = "originImages";
    //经过压缩后的图片存放的文件夹
    private static String targetCompressAddr = "compressImages";


    /**
     * 等比例压缩图片
     * @param imagePath 原图的绝对路径
     * @param targetAddr 压缩图片存放的文件夹
     * @return
     */
    public static boolean compressImage (String imagePath, String targetAddr) {
        try {
            File image = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(image));
            //获取图片的宽度，以计算压缩系数
            int width = bufferedImage.getWidth();
            double ratio = 100.0f / width;

            //获取图片名
            String originalImageName = image.getName();
            //获取后缀名
            String ext = FilenameUtils.getExtension(originalImageName);
            //生成目标目录
            String targetFolder = getImgFolder() + targetAddr +
                    File.separator + DateUtil.formatDate(new Date());
            if(!makeDir(targetFolder)){
                log.error("创建目录失败");
                return false;
            }
            //生成图片名
            String fileId = IdUtil.simpleUUID();
            String savedPath = targetFolder + File.separator + fileId + "." + ext;
            Thumbnails.of(imagePath).scale(ratio).outputQuality(1.0f).toFile(savedPath);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("图片压缩出错");
            return false;
        }
        return true;
    }

    /**
     * 上传图片，然后对图片进行压缩
     * @param file 上传的文件
     * @return
     */
    public static boolean uploadImage (MultipartFile file) {
        try {
            //1.先保存原图
            // 文件名称
            String originalFilename = file.getOriginalFilename().replaceAll(",", "，");
            // 后缀名
            String ext = FilenameUtils.getExtension(originalFilename);
            // 自动生成主键id，即文件名
            String fileId = IdUtil.simpleUUID();
            String savedPath = getImgFolder() + targetOriginAddr  + File.separator
                    + DateUtil.formatDate(new Date()) + File.separator + fileId + "." + ext;
            try {
                //写入磁盘
                FileUtils.writeByteArrayToFile(new File(savedPath), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            //2.然后进行图片压缩
            boolean res = compressImage(savedPath,targetCompressAddr);
            if (res) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 生成目录
     * @param absolutePath 目录的绝对路径
     */
    private static boolean makeDir(String absolutePath){
        File targetFile=new File(absolutePath);
        if (!targetFile.exists()){
            return targetFile.mkdirs();
        }
        return true;
    }

    /**
     * 返回项目图片存放根目录
     */
    public static String getImgFolder() {
        String imgFolder = "";
        if (System.getProperty("os.name").toLowerCase().startsWith("win"))
            imgFolder = "d:/imagestest/";
        imgFolder = imgFolder.replace("/", fileSeparator);            //根据不同系统替换文件分割符
        return imgFolder;
    }

}

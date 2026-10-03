package com.foundation.tools.file;

import cn.hutool.core.date.DateUtil;
import com.foundation.FoundationConstant;
import com.foundation.springcontext.configure.FileConfig;
import com.framework.common.constant.GlobalConstants;
import com.framework.common.tools.file.MimeTypeUtils;
import com.framework.common.tools.uuid.IdUtils;
import com.framework.web.enums.FileFromTypeEnum;
import com.framework.web.enums.FileTypeEnum;
import com.framework.web.exception.base.BusinessException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 文件上传工具类
 * @author bjtuwh
 * @date 2021年07月30日
 */
public class FileUploadUtils {
    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;

    /**
     * 默认的文件名最大长度 50
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 50;

    /**
     * 默认上传的地址
     */
    private static String defaultBaseDir = FileConfig.getFileRootDirectory();

    public static void setDefaultBaseDir(String defaultBaseDir) {
        FileUploadUtils.defaultBaseDir = defaultBaseDir;
    }

    public static String getDefaultBaseDir() {
        return defaultBaseDir;
    }
    public static String getRealPath(String filePath) {
        String realPath = FileConfig.getFileRootDirectory();
        String savedPath = realPath + File.separator + filePath;
        return savedPath;
    }
    public static String getUrlPath(String path) {
        path.replaceAll("\\\\", "/");
        String urlPath = FoundationConstant.RESOURCE_URL_PREFIX + path;
        return urlPath;
    }

    /**
     * 以默认配置进行文件上传
     * @param file 上传的文件
     * @return 文件名称
     */
    public static String upload(MultipartFile file) throws IOException {
        try {
            return upload(getDefaultBaseDir(), file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    /**
     * 根据文件路径上传
     * @param baseDir 相对应用的基目录
     * @param file    上传的文件
     * @return 文件名称
     */
    public static String upload(String baseDir, MultipartFile file) throws IOException {
        try {
            return upload(baseDir, file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    /**
     * 文件上传
     * @param baseDir          相对应用的基目录
     * @param file             上传的文件
     * @param allowedExtension 上传文件类型
     * @return 返回上传成功的文件名
     * @throws BusinessException 文件过大，文件名过长，文件类型不匹配
     * @throws IOException       I/O异常
     */
    public static String upload(String baseDir, MultipartFile file, String[] allowedExtension)
            throws BusinessException, IOException {
        int fileNamelength = file.getOriginalFilename().length();
        // 文件名过长
        if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new BusinessException("文件名过长");
        }

        assertAllowed(file, allowedExtension);

        String fileName = extractFilename(file);

        File desc = getAbsoluteFile(baseDir, fileName);
        // 上传文件
        file.transferTo(desc);
        String pathFileName = getPathFileName(baseDir, fileName);
        return pathFileName;
    }

    /**
     * 编码文件名
     */
    public static String extractFilename(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String extension = getExtension(file);
        fileName = DateFormatUtils.format(new Date(), "yyyy/MM/dd") + "/" + IdUtils.fastUUID() + "." + extension;
        return fileName;
    }

    /**
     * 文件路径：上传路径/年/月/日/文件名
     * @param uploadDir 上传路径
     * @param fileName  年/月/日/文件名
     * @return 根据绝对路径构建的File对象
     */
    private static File getAbsoluteFile(String uploadDir, String fileName) {
        File desc = new File(uploadDir + File.separator + fileName);

        if (!desc.exists()) {
            if (!desc.getParentFile().exists()) {
                desc.getParentFile().mkdirs();
            }
        }
        return desc;
    }

    /**
     * 获取文件的映射路径
     * @param uploadDir 上传路径
     * @param fileName  年/月/日/文件名
     * @return 上传成功的文件的相对路径
     */
    private static String getPathFileName(String uploadDir, String fileName) {
        int dirLastIndex = FileConfig.getFileRootDirectory().length() + 1;
        String currentDir = StringUtils.substring(uploadDir, dirLastIndex);
        String pathFileName = GlobalConstants.RESOURCE_PREFIX + "/" + currentDir + "/" + fileName;
        return pathFileName;
    }

    /**
     * 文件大小校验
     * @param file 上传的文件
     * @throws BusinessException 文件上传异常(超出大小，类型不符合)
     */
    public static void assertAllowed(MultipartFile file, String[] allowedExtension)
            throws BusinessException {
        long size = file.getSize();
        if (DEFAULT_MAX_SIZE != -1 && size > DEFAULT_MAX_SIZE) {
            throw new BusinessException("文件超出最大大小" + DEFAULT_MAX_SIZE);
        }
        // 出现异常的话应该将文件名也写到日志中
        /// String fileName = file.getOriginalFilename();
        String extension = getExtension(file);
        if (allowedExtension != null && !isAllowedExtension(extension, allowedExtension)) {
            if (allowedExtension == MimeTypeUtils.IMAGE_EXTENSION) {
                throw new BusinessException("不支持该类型的图片");
            } else if (allowedExtension == MimeTypeUtils.FLASH_EXTENSION) {
                throw new BusinessException("不支持该类型的flash");
            } else if (allowedExtension == MimeTypeUtils.MEDIA_EXTENSION) {
                throw new BusinessException("不支持该类型的媒体");
            } else if (allowedExtension == MimeTypeUtils.VIDEO_EXTENSION) {
                throw new BusinessException("不支持该类型的视频");
            } else {
                throw new BusinessException("不支持该类型的文件");
            }
        }

    }

    /**
     * 判断MIME类型是否是允许的MIME类型
     * @param extension        文件后缀
     * @param allowedExtension 支持的文件类型数组
     * @return true允许该类型文件，false不允许该类型的文件
     */
    public static boolean isAllowedExtension(String extension, String[] allowedExtension) {
        for (String str : allowedExtension) {
            if (str.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取文件名的后缀
     * @param file 表单文件
     * @return 后缀名
     */
    public static String getExtension(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (StringUtils.isEmpty(extension) && StringUtils.isNotEmpty(file.getContentType())) {
            extension = MimeTypeUtils.getExtension(file.getContentType());
        }
        return extension;
    }
    /**
     * 判断上传文件类型，并返回对应的常量值
     * @param file 上传的文件
     * @return 文件类型：0 未知类型，1、图片；2、word；3、EXCEL；4、PDF；5、视频
     */
    public static String getUploadFileType(MultipartFile file) {
        // 获取后缀
        String extension = FileUploadUtils.getExtension(file);
        // 判断文件类型
        if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.IMAGE_EXTENSION)) {
            return FileTypeEnum.IMAGE.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.WORD_EXTENSION)) {
            return FileTypeEnum.WORD.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.EXCEL_EXTENSION)) {
            return FileTypeEnum.EXCEL.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.PDF_EXTENSION)) {
            return FileTypeEnum.PDF.getCode();
        } else if (FileUploadUtils.isAllowedExtension(extension, MimeTypeUtils.VIDEO_EXTENSION)) {
            return FileTypeEnum.VIDEO.getCode();
        } else {
            return FileTypeEnum.UNKNOWN.getCode();
        }
    }
}

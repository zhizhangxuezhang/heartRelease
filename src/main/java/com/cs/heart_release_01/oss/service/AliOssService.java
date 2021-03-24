package com.cs.heart_release_01.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2021/2/3 19:44
 */
public interface AliOssService {
    /**
     * 创建存储空间bucket
     */
    void createBucket();

    /**
     * 上传文件
     */
    String upload(MultipartFile file);

    /**
     * 下载文件
     */
    void download(String fileName) throws IOException;

    /**
     * 列举文件
     */
    void listFile();

    /**
     * 删除文件
     */
    void deleteFile(String fileName);
}

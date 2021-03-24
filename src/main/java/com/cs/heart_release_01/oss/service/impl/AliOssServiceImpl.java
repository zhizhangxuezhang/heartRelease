package com.cs.heart_release_01.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.cs.heart_release_01.oss.entity.OssEntity;
import com.cs.heart_release_01.oss.service.AliOssService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2021/2/3 19:45
 */
@Service
public class AliOssServiceImpl implements AliOssService, InitializingBean {
    @Autowired
    private OssEntity ossEntity;

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    /**
     * 初始化Bean之后需要进行的操作
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        endpoint = ossEntity.getEndpoint();
        accessKeyId = ossEntity.getAccessKeyId();
        accessKeySecret = ossEntity.getAccessKeySecret();
        bucketName = ossEntity.getBucketName();
    }

    @Override
    public void createBucket() {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);
        if(ossClient.doesBucketExist(bucketName)) {
            throw new RuntimeException(bucketName+ "在对象存储的Bucket列表中已经存在");
        } else {
            ossClient.createBucket(bucketName);
        }
        ossClient.shutdown();
    }

    @Override
    public String upload(MultipartFile file) {
        String uploadUrl = null;
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            if(!ossClient.doesBucketExist(bucketName)){
                //创建Bucket
                ossClient.createBucket(bucketName);
                //设置bucket的属性为公共读
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            //获取上传的文件流
            InputStream inputStream = file.getInputStream();
            //构建日期的文件夹路径    avator/2020/10/14/文件名
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //获取上传文件的全名称
            String originalFilename = file.getOriginalFilename();
            //获取UUID,并去除横杠    a98059d4-633c-4b55-b310-93c997cf8038
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            //获取上传文件的扩展名
            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接文件名称
            String newName = fileName + fileType;
            //生成文件夹+文件名    avator/2020/10/14/a98059d4633c4b55b31093c997cf8038.jpg
            fileName = datePath + "/" + newName;
            //如果想要实现图片预览的效果，一定要设置以下几点：
            //1.设置文件的ACL（权限）为公共读或公共读写
            //2.设置文本类型（image/jpg）
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
            objectMetadata.setContentType(getContentType(fileType));
            //上传文件
            ossClient.putObject(bucketName,fileName,inputStream,objectMetadata);
            //关闭ossClient
            ossClient.shutdown();
            //默认十年不过期
            Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
            uploadUrl = ossClient.generatePresignedUrl(bucketName, fileName, expiration).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadUrl.substring(0,uploadUrl.indexOf("?"));
    }

    @Override
    public void download(String fileName) throws IOException {

    }

    @Override
    public void listFile() {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        for (OSSObjectSummary ossObjectSummary : objectListing.getObjectSummaries()) {
            System.out.println("-"+ossObjectSummary.getKey()+" "+"(size = "+ ossObjectSummary.getSize() + ")");
        }
        //关闭ossClient
        ossClient.shutdown();
    }

    @Override
    public void deleteFile(String fileName) {
        String objectName = fileName;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteObject(bucketName,objectName);
        ossClient.shutdown();
    }

    public static String getContentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpg")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/png";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        return "text/plain";
    }
}

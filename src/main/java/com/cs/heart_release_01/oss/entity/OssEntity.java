package com.cs.heart_release_01.oss.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2021/2/3 19:43
 */
@Data
@Component
@ConfigurationProperties(prefix = "alioss")
public class OssEntity {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}

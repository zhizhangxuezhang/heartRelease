package com.cs.heart_release_01.result;

import lombok.Data;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2020/10/3 12:42
 */
@Data
public class FileUploadResult {
    // 文件唯一标识
    private String uid;
    // 文件名
    private String name;
    // 状态有：uploading done error removed
    private String status;
    // 服务端响应内容，如：'{"status": "success"}'
    private String response;
}

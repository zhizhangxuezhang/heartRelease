package com.cs.heart_release_01.wx;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2020/10/4 22:58
 */
public class WXSessionModel {
    private  String session_key;
    private  String openid;
    public String getSession_key() {
        return session_key;
    }
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenID(String openid) {
        this.openid = openid;
    }
}

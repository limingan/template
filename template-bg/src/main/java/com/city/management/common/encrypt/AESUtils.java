package com.city.management.common.encrypt;

import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by cp on 2019-03-24.
 * AES对称加密工具类
 */
public class AESUtils {
    private static String aeskey = "QWSDCV872IOPKLJU"; //16位，随意定义
    /**
     * 加密
     * @param target 待加密明文, key秘钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String target, String key) throws Exception {
        if(StringUtils.isEmpty(target)){
            return "";
        }
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(target.getBytes("utf-8"));
        return Base64Utils.encodeToString(encrypted);//BASE64转码，避免出现中文乱码
    }

    /**
     * AES解密
     * @param src AES后又base64的密文, key 秘钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String src, String key) throws Exception {
        try {
            byte[] raw = key.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypt = Base64Utils.decodeFromString(src);//先用base64解密
            byte[] original = cipher.doFinal(encrypt);
            String originalStr = new String(original,"utf-8");
            return originalStr;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 加密
     * @param target 待加密明文
     * @return
     */
    public static String encrypt(String target) {
        try{
            return encrypt(target, aeskey);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 解密
     * @param src 待解密密文
     * @return
     */
    public static String decrypt(String src){
        try{
            return decrypt(src, aeskey);
        }catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        // 需要加密的字串
        String cSrc = "智慧城管";
        System.out.println(cSrc);
        // 加密
        String enString = AESUtils.encrypt(cSrc);
        System.out.println("加密后：" + enString);
        // 解密
        String DeString = AESUtils.decrypt(enString);
        System.out.println("解密后：" + DeString);
    }
}

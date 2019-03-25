package com.city.management.common.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加签工具类
 */
public class RSASignUtils {
	static Logger logger = LoggerFactory.getLogger(RSASignUtils.class);
	// 签名算法 
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA"; 
	/** 
    * RSA签名 
    * @param content 待签名数据 
    * @param privateKey 商户私钥 
    * @return 签名值 
    */ 
    public static String sign(String content, String privateKey){  
        try{  
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Utils.decodeFromString(privateKey) );   
            PrivateKey priKey = KeyFactory.getInstance("RSA").generatePrivate(priPKCS8);  
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);  
            signature.initSign(priKey);  
            signature.update( content.getBytes("UTF-8"));  
            byte[] signed = signature.sign();  
            return Base64Utils.encodeToString(signed);  
        }catch (Exception e){  
        	logger.error("加签失败，", e);
        }  
        return null;  
    }  
    
    /** 
     * RSA验签名检查 
     * @param content 待签名数据 
     * @param sign 签名值 
     * @param publicKey 公钥 
     * @return 布尔值 
     */ 
     public static boolean doCheck(String content, String sign, String publicKey) {  
         try{
             KeyFactory keyFactory = KeyFactory.getInstance("RSA");
             byte[] encodedKey = Base64Utils.decodeFromString(publicKey);  
             PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));  
             Signature signature = Signature.getInstance(SIGN_ALGORITHMS);  
             signature.initVerify(pubKey);  
             signature.update(content.getBytes("UTF-8"));  
             boolean bverify = signature.verify(Base64Utils.decodeFromString(sign) );  
             return bverify;  
         }catch (Exception e){  
        	 logger.error("验签失败，", e);
         }  
         return false;  
     }  
}

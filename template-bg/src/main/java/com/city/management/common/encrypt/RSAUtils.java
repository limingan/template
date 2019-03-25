package com.city.management.common.encrypt;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加解密工具类
 */
public class RSAUtils {
	//生产环境，可以先 生成公私钥，存到配置文件中或静态常量，加解密时直接读取
	private static Map<String,String> keyPairMap = new HashMap<String,String>();
	private static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIF9Wj52OHO9KCoE3aiPAIrNMj4+7qZ2zLKXyVJCaBPJqXxMimCF3YL1IjbwNEcwMlNrUvRsEctnl0ergHtoEU0CAwEAAQ==";
	private static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAgX1aPnY4c70oKgTdqI8Ais0yPj7upnbMspfJUkJoE8mpfEyKYIXdgvUiNvA0RzAyU2tS9GwRy2eXR6uAe2gRTQIDAQABAkAmcZHWU4DlE7aV6wXn4jTWAJ+3DTYLI+AX8apqip6dqOgdRb7h7wquvjZQLyDy8EY7weVgvnsgiVyK/qe3RVy9AiEAwhFSFdVGO9lLTkPsvNL7Y9CxAsoS7935CNB9RustyWcCIQCq0DmYPmKVBYCNkOuwlOmE0RBs5HIbS8ad4ZE13f+7KwIhALeBTU8b1ketVsnw7KA4GEHwChELJxDtohg1nOA8bZUtAiEAgvxKLkUos74UZnrLQg3vRLpNLjPAjM3+8PMYt4YVpSECIHwQXOe04yOidp8RF/f4SFazz+4Qn8hlAkk67nLnCRfk";
	private static void createKeyPair(){
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象 
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			// 初始化密钥对生成器，密钥大小为96-1024位 ，必须是64的倍数
			keyPairGenerator.initialize(512, new SecureRandom());
			// 生成一个密钥对
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			//私钥
			PrivateKey privateKey = keyPair.getPrivate();
			String base64PrivateKey = Base64Utils.encodeToString(privateKey.getEncoded());
			//公钥
			PublicKey publicKey  = keyPair.getPublic();
			String base64PublicKey = Base64Utils.encodeToString(publicKey.getEncoded());
			keyPairMap.put("privateKey", base64PrivateKey);
			keyPairMap.put("publicKey", base64PublicKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	//公钥加密
	public static String encryptByPublicKey(String target, String publicKey){
		byte[] bytes = Base64Utils.decodeFromString(publicKey);
		String result = "";
		try{
			RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			result = Base64Utils.encodeToString(cipher.doFinal(target.getBytes("UTF-8")));
		}catch(Exception e){
			return null;
		}
		return result;
	}
	//私钥解密
	public static String decryptByPrivateKey(String src, String privateKey){
		String result = "";
		byte[] decode = Base64Utils.decodeFromString(src);
		byte[] decodeKey  = Base64Utils.decodeFromString(privateKey);
		try {
			RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decodeKey));
			//RSA解密
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			result = new String(cipher.doFinal(decode));
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	//公钥加密
	public static String encryptByPublicKey(String target){
		return encryptByPublicKey(target, publicKey);
	}
	//私钥解密
	public static String decryptByPrivateKey(String src){
		return decryptByPrivateKey(src, privateKey);
	}
	public static void main(String[] args){
		createKeyPair();
		String publicKey = keyPairMap.get("publicKey");
		String privateKey = keyPairMap.get("privateKey");
		System.out.println("公钥："+ publicKey);
		System.out.println("私钥："+ privateKey);
		String str = "{name=cp,age=1}";
		String encode = encryptByPublicKey(str);
		System.out.println("加密："+encode);
		String decode = decryptByPrivateKey(encode);
		System.out.println("解密"+decode);
	}
}

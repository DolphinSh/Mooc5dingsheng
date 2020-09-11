package com.bilibili.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * RSA加密解密工具
 */
public class RSAUtil {
    private static Map<Integer,String> keyMap = new HashMap<Integer, String>();

    public static Map<Integer,String> genKeyPair() throws NoSuchAlgorithmException {
        //KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen =KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024,new SecureRandom());
        KeyPair keyPair =keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();// 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();// 得到公钥
        // 得到公钥字符串
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64(privateKey.getEncoded()));
        // 将公钥和私钥保存到Map
        keyMap.put(0,publicKeyString);
        keyMap.put(1,privateKeyString);
        return keyMap;
    }

    /**
     * RSA 公钥加密
     * @param str  欲加密的字符串
     * @param publicKey 公钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String str,String publicKey) throws Exception {
        //1.拿Base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        //2.拿到公钥
        RSAPublicKey pubkey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //3.RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pubkey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * 私钥加密
     * @param str 欲加密的内容
     * @param privateKey  私钥
     * @return 私钥加密后的内容
     * @throws Exception
     */
    public static String priEncrypt(String str,String privateKey) throws Exception{
        //1.拿Base64编码的私钥
        byte [] decode = Base64.decodeBase64(privateKey);
        //2.拿到私钥
        RSAPrivateKey prikey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decode));
        //3.RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,prikey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密公钥加密的内容
     * @param str 公钥加密的字符串
     * @param privateKey 私钥
     * @return 解密后的内容
     * @throws Exception
     */
    public static String decrypt(String str,String privateKey)throws Exception{
        //1.Base64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //2.base64编码的私钥
        byte[] decoded =Base64.decodeBase64(privateKey);
        RSAPrivateKey prikey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //3. RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, prikey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    /**
     * 公钥解密私钥加密的内容
     * @param str  欲加密的内容
     * @param publicKey 公钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String pubDecrypt(String str,String publicKey) throws Exception{
        //1.Base64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //2.base64编码的公钥
        byte[] decoded =Base64.decodeBase64(publicKey);
        RSAPublicKey pubkey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //3.RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,pubkey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}

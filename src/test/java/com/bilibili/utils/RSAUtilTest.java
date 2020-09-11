package com.bilibili.utils;
import org.junit.jupiter.api.Test;
import java.util.Map;
import com.bilibili.utils.RSAUtil;


class RSAUtilTest {
    @Test
    public void testRSA() throws Exception {
        RSAUtil rsaUtil = new RSAUtil();
        Map<Integer,String> keyMap =RSAUtil.genKeyPair();
        System.out.printf("公钥--> %S \n",keyMap.get(0));
        System.out.printf("私钥--> %S \n",keyMap.get(1));
        String pubEncryptStr =  RSAUtil.encrypt("123456",keyMap.get(0));
        System.out.println("公钥加密--->");
        System.out.println(pubEncryptStr);
        String priDecryptStr = RSAUtil.decrypt(pubEncryptStr,keyMap.get(1));
        System.out.println("私钥解密--->");
        System.out.println(priDecryptStr);
        System.out.println("私钥加密--->");
        String priEncryptStr = RSAUtil.priEncrypt("654321",keyMap.get(1));
        System.out.println(priEncryptStr);
        String pubDecryptStr = RSAUtil.pubDecrypt(priEncryptStr,keyMap.get(0));
        System.out.println("公钥解密--->");
        System.out.println(pubDecryptStr);
    }
}
package com.boredream.key;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Main {

    public static void main(String[] args) throws Exception {
        // 1.[Server]生成一对密钥：公钥和私钥，我们称之为“publicKey”，“privateKey”
        KeyPair keyPair = RSAUtil.generateRSAKeyPair();
        System.out.println("[Service] gen publicKey and privateKey");

        // 2.[Server]服务端将公钥（KeyPub）发送到客户端
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("[Service] send publicKey to Client");

        // 3.[Client]生成一个对称密钥 AES_KEY
        final String AES_KEY = "boredream-aes-key";
        System.out.println("[Client] gen AES_KEY ...... AES_KEY = " + AES_KEY);

        // 4.[Client]使用公钥加密 AES_KEY 这时，AES_KEY 是安全的，因为只有服务端有私钥
        byte[] aesKeyEncrypted = RSAUtil.encryptData(AES_KEY.getBytes(), publicKey);
        System.out.println("[Client] encrypt AES_KEY by publicKey");

        // 5.[Client]发送用key2加密后的信息及用KeyPub加密过的key2到服务端
        System.out.println("[Client] send AES_KEY(encrypted by publicKey) to Service");

        // 6.[Server]服务端使用KeyPri解密得到加密过的key2，得到真正的key2
        PrivateKey privateKey = keyPair.getPrivate();
        String aesKeyDecrypted = new String(RSAUtil.decryptData(aesKeyEncrypted, privateKey));
        System.out.println("[Service] decrypt AES_KEY by privateKey ...... AES_KEY = " + aesKeyDecrypted);

        System.out.println("======================================================");

        // Client发送数据
        final String dataFromClient = "i am client data";
        final String encryptByClient = AESUtil.encrypt(dataFromClient, AES_KEY);
        System.out.println("data from client = " + dataFromClient);

        // Service接收数据
        String decryptDataByService = AESUtil.decrypt(encryptByClient, aesKeyDecrypted);
        System.out.println("service decrypt data = " + decryptDataByService);
    }

}

package com.codeWithB;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class SymmetricKeyEncryptionUtil {


    //MODES: ECB/CBC/CFB/OFB
    //Paddings: NoPadding,  PKCS5Padding
    private final String ALGO = "DES";
    private final String MODE = "CBC";
    private final String PADDING_SCHEME = "PKCS5Padding";
    private Key key;
    String transformation;
    SecureRandom secureRandom;
    byte[] ivBytes = new byte[8];

    public SymmetricKeyEncryptionUtil(String key) {
        //DES/ECB/NoPadding
        this.key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGO);
        transformation = String.format("%s/%s/%s", ALGO, MODE, PADDING_SCHEME);
        secureRandom = new SecureRandom();
    }

    public String encrypt(String valueToEncrypt) throws Exception {
        Cipher instance = Cipher.getInstance(transformation);
        secureRandom.nextBytes(ivBytes);
        System.out.println(new String(ivBytes));
        instance.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(getRandomBytes(8)));
        byte[] bytes = instance.doFinal(String.format("12345678%s", valueToEncrypt).getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String decrypt(String encryptedValue) throws Exception {
        Cipher instance = Cipher.getInstance(transformation);
        secureRandom.nextBytes(ivBytes);
        System.out.println(new String(ivBytes));
        instance.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(getRandomBytes(8)));
        byte[] bytes = instance.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(bytes, StandardCharsets.UTF_8).substring(8);
    }

    private byte[] getRandomBytes(int length) {
        String charSets = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_+-#$%^&*!";
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(charSets.charAt(random.nextInt(charSets.length())));
        }
        return sb.toString().getBytes();
    }
}
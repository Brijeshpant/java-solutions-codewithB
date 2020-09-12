package com.codeWithB;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SymmetricKeyEncryptionUtilTest {
    @Test
    public void shouldEncryptAndDecrypt() throws Exception {

        String valueToEncrypt = "brijeshpant";
        SymmetricKeyEncryptionUtil symmetricKeyEncryptionUtil = new SymmetricKeyEncryptionUtil("12345678");
        String encryptedValue = symmetricKeyEncryptionUtil.encrypt(valueToEncrypt);
        assertNotEquals(encryptedValue, symmetricKeyEncryptionUtil.encrypt(valueToEncrypt));
        assertEquals(valueToEncrypt, symmetricKeyEncryptionUtil.decrypt(encryptedValue));
    }

}
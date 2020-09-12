# java-solutions-codewithB

Encryption

Symmetric

Same key for encryption and decryption

AES encryption:

    Same key for encryption and decryption
       AES/ECB/PKCS5Padding
       type /mode of operation/ padding scheme
       
       Type:
       
Advanced Encryption Standard
Data Encryption Standard 
       
       
       Mode:
       
       Electronic codebook	(ECB)	Yi = F(PlainTexti, Key)	Yi
       Cipher block chaining	(CBC)	Yi = PlainTexti XOR Ciphertexti−1	F(Y, Key); Ciphertext0=IV
       Propagating CBC	(PCBC)	Yi = PlainTexti XOR (Ciphertexti−1 XOR PlainTexti−1)	F(Y, Key); Ciphertext0 = IV
       Cipher feedback	(CFB)	Yi = Ciphertexti−1	Plaintext XOR F(Y, Key); Ciphertext0 = IV
       Output feedback	(OFB)	Yi = F(Yi−1, Key); Y0 = F(IV, Key)	Plaintext XOR Yi
       Counter	(CTR)	Yi = F(IV + g(i), Key); IV = token()	Plaintext XOR Yi

Padding:
  Byte padding
  ANSI X9.23
 ISO 10126
 	PKCS#5 and PKCS#7
	ISO/IEC 7816-4

Asymmetric

different key(public/private key) for encryption and decryption
DES  == 8 byte key

NoPadding  => input length has to be multiple of 8 bytes
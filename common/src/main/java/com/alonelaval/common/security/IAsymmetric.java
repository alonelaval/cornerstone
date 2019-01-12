package com.alonelaval.common.security;

import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;

/***
* huawei
***/
public interface IAsymmetric {
	
	/***
	 * 生成秘钥对
	 * @return
	 * @throws Exception
	 */
	KeyPair createKeyPair()throws Exception;
	/**
	 * 根据秘钥对生成证书
	 * @param keyPair
	 * @return
	 * @throws Exception
	 */
	Certificate createCertificate(KeyPair keyPair, String issuerName, BigInteger serialNumber, Date notBefore, Date notAfter, String subject)throws Exception;
	/**
	 * 根据秘钥对x.509生成证书
	 * @param keyPair
	 * @return
	 * @throws Exception
	 */
	Certificate createCertificate(PublicKey publicKey, PrivateKey privateKey, String issuerName,
                                  BigInteger serialNumber, Date notBefore, Date notAfter, String subject)throws Exception;
	
	/**
	 * 根据字base64符串，转换成公钥
	 * @param b64String
	 * @return
	 * @throws Exception
	 */
	PublicKey getPulicKey(String b64String)throws Exception;
	/**
	 * 根据字base64符串，转换成公钥
	 * @param b64String
	 * @return
	 * @throws Exception
	 */
	PrivateKey getPrivateKey(String b64String)throws Exception;
	/**
	 * 根据字base64符串，转换成 X509Certificate
	 * @param b64String
	 * @return
	 * @throws Exception
	 */
	Certificate getCertificate(String b64String)throws Exception;
	/***
	 * 从pkcs#7中提取第一个证书
	 * @param b64StrSignature
	 * @return
	 * @throws Exception
	 */
	Certificate getCertificateFromPkcs7(String b64StrSignature)throws Exception;
	/***
	 * 从PKCS7签名中提取数据
	 * @param b64StrSignature
	 * @return
	 * @throws Exception
	 */
	byte [] getDataFromPkcs7(String b64StrSignature)throws Exception;
	/***
	 * 用私钥解密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	byte[] decryptByPrivateKey(byte[] data, PrivateKey key)throws Exception;
	/***
	 * 用公钥解密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	byte[] decryptByPublicKey(byte[] data, PublicKey key)  throws Exception;
	/***
	 * 用公钥加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	byte[] encryptByPublicKey(byte[] data, PublicKey key) throws Exception;
	
	/***
	 * 用私钥加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	byte[] encryptByPrivateKey(byte[] data, PrivateKey key) throws Exception;
	/***
	 * 采用pkcs#7进行数据签名
	 * @param cert 公钥证书
	 * @param privateKey
	 * @param data
	 * @return
	 * @throws Exception
	 */
	byte[] signWithPkcs7(Certificate cert, PrivateKey privateKey, byte data[])throws Exception;
	/***
	 * 对pkcs#7签名的数据进行验证
	 * @param signData
	 * @return
	 * @throws Exception
	 */
	boolean verifySignPkcs7(byte[] contentBytes, byte[] signData)throws Exception;
	/***
	 * 对pkcs#7签名的数据进行验证
	 * @param signData
	 * @return
	 * @throws Exception
	 */
	boolean verifySignPkcs7(byte[] signData)throws Exception;
	/**
	 * 用私钥对数据进行签名
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	byte[] sign(byte[] data, PrivateKey privateKey) throws Exception;
	/***
	 * 对私钥的签名进行验证
	 * @param data
	 * @param publicKey
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	boolean verify(byte[] data, PublicKey publicKey, byte[] signData)throws Exception;
	
	/**
	 * 生成 pkcs7 格式的数字信封，采取 DES_EDE3_CBC 算法加密
	 * @param recipientCert 收信人证书
	 * @param signerCert 发信人证书
	 * @param signerPriKey 发信人私钥-需要与 signerCert 中的 PublicKey 对应
	 * @param clearText 明文
	 * @return pkcs7
	 * @throws IOException
	 * @throws Exception
	 */
	byte[] envelopeWithPkcs7(X509Certificate recipientCert, Certificate signerCert, PrivateKey signerPriKey,
                             String clearText) throws IOException, Exception;
	
	/**
	 * 解析 pkcs7 格式的数字信封
	 * @param pkcs7WithB64
	 * @param recipientPriKey 与生成数字信封时加密用的 PublicKey 对应
	 * @return 明文文本
	 * @throws Exception
	 */
	String openEnvelopeWithPkcs7(String pkcs7WithB64, PrivateKey recipientPriKey) throws Exception;
	
	/**
	 * 生成证书签名请求
	 * @param subjectName 证书的 DN，形如："CN=xcredit member master, O=xx company, C=CN"
	 * @param pair 公私密钥对
	 * @throws Exception 
	 */
	String generateCSR(KeyPair pair, String subjectName) throws Exception;
	
	/**
	 * 对证书请求签名
	 * @param CSR
	 * @param issuerCert
	 * @param privateKey
	 * @param validityInDays
	 * @return
	 * @throws Exception
	 */
    Certificate signCSR(String CSR, X509Certificate issuerCert, PrivateKey privateKey, Integer validityInDays)
            throws Exception;
}

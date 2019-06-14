package com.alonelaval.common.security;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.cms.*;
import org.bouncycastle.cms.jcajce.*;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.bouncycastle.util.io.pem.PemWriter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.x500.X500Principal;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;


/***
* huawei
***/
public class RSAAsymmetric implements IAsymmetric{
	
	public static final String X509 = "X.509";
	public static final String KEY_ALGORITHM = "RSA";  
	public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";  
	public static final Integer KEY_LEN=2048;
	public static final String PROVIDER_NAME = BouncyCastleProvider.PROVIDER_NAME;
	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final ASN1ObjectIdentifier ENVELOPE_ENCRYPTION_ALGORITHM = CMSAlgorithm.DES_EDE3_CBC;
	public static final String CERT_SIGNING_REQUEST_TYPE = "CERTIFICATE REQUEST";
	public static final Integer DEFAULT_VALIDATY_DAYS = 365 * 10;
	
	private Integer keyLength=KEY_LEN;
	
	
	public Integer getKeyLength() {
		return keyLength;
	}
	public void setKeyLength(Integer keyLength) {
		this.keyLength = keyLength;
	}
	public  RSAAsymmetric(){
		Security.addProvider(new BouncyCastleProvider());
	}

	@Override
	public KeyPair createKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(getKeyLength());
		KeyPair keyPair = keyPairGen.generateKeyPair();
		return keyPair;
	}

	@Override
	public Certificate createCertificate(KeyPair keyPair,String issuerName,BigInteger serialNumber, Date notBefore, Date notAfter, String subject) throws Exception {
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		return createCertificate(publicKey,privateKey,issuerName,serialNumber,notBefore,notAfter,subject);
	}

	@Override
	public Certificate createCertificate(PublicKey publicKey, PrivateKey privateKey,String issuerName,BigInteger serialNumber, Date notBefore, Date notAfter, String subject) throws Exception {
		X500Name issuer = new X500Name(issuerName);
		X500Name subjectName = new X500Name(subject);
		
		return this.createCertificate(publicKey, privateKey, issuer, serialNumber, notBefore, notAfter, subjectName, null, null);
	}
	
    private Certificate createCertificate(PublicKey publicKey, PrivateKey privateKey, X500Name issuerName,
            BigInteger serialNumber, Date from, Date to, X500Name subject, PKCS10CertificationRequest csr, X509Certificate issuerCert) throws OperatorCreationException, CertificateException, IOException, NoSuchAlgorithmException
    {
        X509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(issuerName, serialNumber, from, to,
                subject, publicKey);
        
        //证书扩展
        // v3CertGen.addExtension(
        // X509Extension.subjectKeyIdentifier,
        // X509Extension.subjectKeyIdentifier,
        // false,
        // createSubjectKeyId(subPub));
        //
        // v3CertGen.addExtension(
        // X509Extension.authorityKeyIdentifier,
        // false,
        // createAuthorityKeyId(issPub));
        
        JcaX509ExtensionUtils extUtils = new JcaX509ExtensionUtils();
        
        builder.addExtension(Extension.basicConstraints, false, new BasicConstraints(true));
        if(csr!=null)
        {
            builder.addExtension(Extension.subjectKeyIdentifier, false, extUtils.createSubjectKeyIdentifier(csr.getSubjectPublicKeyInfo()));
        }
        if(issuerCert != null)
        {
            builder.addExtension(Extension.authorityKeyIdentifier, false, new AuthorityKeyIdentifier(new GeneralNames(new GeneralName(new X500Name(issuerCert.getSubjectX500Principal().getName()))), issuerCert.getSerialNumber()));
        }

        X509CertificateHolder cert = builder
                .build(new JcaContentSignerBuilder(SIGNATURE_ALGORITHM).setProvider(PROVIDER_NAME).build(privateKey));
        return new JcaX509CertificateConverter().setProvider(PROVIDER_NAME).getCertificate(cert);
        
    }

	@Override
	public byte[] decryptByPrivateKey(byte[] data, PrivateKey key) throws Exception {
		return decryptByKey(data, key);
	}

	@Override
	public byte[] decryptByPublicKey(byte[] data, PublicKey key) throws Exception {
		return decryptByKey(data, key);
	}
	
	private byte[] decryptByKey(byte[] data, Key key) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
	{
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, key);  
  
        return cipher.doFinal(data);  
	}

	@Override
	public byte[] encryptByPublicKey(byte[] data, PublicKey key) throws Exception {
		return encryptByKey(data, key); 
	}

	@Override
	public byte[] encryptByPrivateKey(byte[] data, PrivateKey key) throws Exception {
		return encryptByKey(data, key); 
	}

	private byte[] encryptByKey(byte[] data, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, key);  
  
        return cipher.doFinal(data);  
	}
	
	@Override
	public byte[] signWithPkcs7(Certificate cert, PrivateKey privateKey, byte[] data) throws Exception {
		X509Certificate cert509 = (X509Certificate) cert;
		CMSSignedDataGenerator generator = new CMSSignedDataGenerator();

		ContentSigner signer = new JcaContentSignerBuilder(SIGNATURE_ALGORITHM).setProvider(PROVIDER_NAME).build(privateKey);

		generator.addSignerInfoGenerator(
				new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider(PROVIDER_NAME).build())
						.build(signer, cert509));
		generator.addCertificate(new X509CertificateHolder(cert509.getEncoded()));
		
		CMSTypedData cmsdata = new CMSProcessableByteArray(data);
		CMSSignedData signeddata = generator.generate(cmsdata, true);
		
		return signeddata.getEncoded();
	}

	@Override
	public boolean verifySignPkcs7(byte[] contentBytes, byte[] signData) throws Exception {
		
		CMSSignedData sp = contentBytes != null ? new CMSSignedData(new CMSProcessableByteArray(contentBytes),signData):new CMSSignedData(signData);
		Store certStore = sp.getCertificates();
		SignerInformationStore signers = sp.getSignerInfos();
		Collection c = signers.getSigners();
		Iterator it = c.iterator();
		while (it.hasNext()) {
			boolean verifResult = verify((SignerInformation) it.next(), certStore);
			if (!verifResult)
				return false;
		}
		return true;
	}
	
	@Override
	public boolean verifySignPkcs7(byte[] signData) throws Exception {
		return verifySignPkcs7(null,signData);
	}
	/**
	 * 验证签名信息
	 * @param signer
	 * @param certStore
	 * @return
	 * @throws Exception
	 */
	boolean verify(SignerInformation signer, Store certStore)throws Exception{
		Collection certCollection = certStore.getMatches(signer.getSID());
		Iterator certIt = certCollection.iterator();
		X509CertificateHolder cert = (X509CertificateHolder) certIt.next();
		Certificate x509Cert = CertificateFactory.getInstance(X509)
				.generateCertificate(new ByteArrayInputStream(cert.getEncoded()));

		JcaSimpleSignerInfoVerifierBuilder sigVerifBuilder = new JcaSimpleSignerInfoVerifierBuilder();
		SignerInformationVerifier signerInfoVerif = sigVerifBuilder.setProvider(PROVIDER_NAME)
				.build(x509Cert.getPublicKey());

		return signer.verify(signerInfoVerif);
	}

	@Override
	public byte[] sign(byte[] data, PrivateKey privateKey) throws Exception {
		  // 取私钥匙对象  
//        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        // 用私钥对信息生成数字签名  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initSign(privateKey);  
        signature.update(data);  
  
        return signature.sign();  
	}

	@Override
	public boolean verify(byte[] data, PublicKey publicKey, byte [] signData) throws Exception {

        // 构造X509EncodedKeySpec对象  
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(data);  
//  
//        // KEY_ALGORITHM 指定的加密算法  
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
//  
//        // 取公钥匙对象  
//        PublicKey pubKey = keyFactory.generatePublic(keySpec);  
  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initVerify(publicKey);  
        signature.update(data);  
  
        // 验证签名是否正常  
        return signature.verify(signData);  
	}

	@Override
	public Certificate getCertificate(String b64String) throws Exception {
		InputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(b64String.getBytes()));
		Certificate certificate = null;
		CertificateFactory cf = CertificateFactory.getInstance(X509);
		while (byteArrayInputStream.available() > 0) {
			Certificate cert = cf.generateCertificate(byteArrayInputStream);
			if (cert != null) {
				certificate = cert;
			}
		}
		byteArrayInputStream.close();
		if (certificate == null) {
			throw new Exception("Could not parse certificate");
		}
		return certificate;
	}

	@Override
	public PublicKey getPulicKey(String b64String) throws Exception {
		X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(b64String.getBytes()));
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey key = keyFactory.generatePublic(spec);
		return key;
	}

	@Override
	public PrivateKey getPrivateKey(String b64String) throws Exception {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(b64String.getBytes()));
		KeyFactory fact = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey key = fact.generatePrivate(keySpec);
		return key;
	}

	@Override
	public Certificate getCertificateFromPkcs7(String b64StrSignature) throws Exception {
		CMSSignedData sp = new CMSSignedData(Base64.getDecoder().decode(b64StrSignature.getBytes()));
		Store certStore = sp.getCertificates();
		SignerInformationStore signers = sp.getSignerInfos();
		Collection c = signers.getSigners();
		Iterator it = c.iterator();
		while (it.hasNext()) {
			SignerInformation signerInformation = (SignerInformation) it.next();
			boolean verifResult = verify(signerInformation, certStore);
			if (verifResult)
			{
				Collection certCollection = certStore.getMatches(signerInformation.getSID());
				Iterator certIt = certCollection.iterator();
				X509CertificateHolder cert = (X509CertificateHolder) certIt.next();
				Certificate x509Cert = CertificateFactory.getInstance(X509)
						.generateCertificate(new ByteArrayInputStream(cert.getEncoded()));
				return x509Cert;
			}
		}
		return null;
	}

	@Override
	public byte[] getDataFromPkcs7(String b64StrSignature) throws Exception {
		CMSSignedData sp = new CMSSignedData(Base64.getDecoder().decode(b64StrSignature.getBytes()));
		return (byte[]) sp.getSignedContent().getContent();
	}
	
	private CMSEnvelopedData envelope(X509Certificate recipientCert, Certificate signerCert, PrivateKey signerPriKey, String clearText) throws IOException, Exception
	{
		PublicKey publicKey = signerCert.getPublicKey();
		if(!isAPair(publicKey, signerPriKey))
		{
			throw new Exception("传入的 signerCert 和 signerPriKey 不匹配");
		}
		CMSTypedData msg = new CMSProcessableByteArray(clearText.getBytes(DEFAULT_ENCODING));
		CMSEnvelopedDataGenerator edGen = new CMSEnvelopedDataGenerator();
		edGen.addRecipientInfoGenerator(new JceKeyTransRecipientInfoGenerator(recipientCert).setProvider(PROVIDER_NAME));
		CMSEnvelopedData ed = edGen.generate(
                 msg,
                 new JceCMSContentEncryptorBuilder(ENVELOPE_ENCRYPTION_ALGORITHM)
                        .setProvider(PROVIDER_NAME).build());
		
		return ed;
		
	}
	
	private String openEnvelope(CMSEnvelopedData envelopedData, PrivateKey recipientPrikey) throws Exception
	{
		RecipientInformationStore  recipients = envelopedData.getRecipientInfos();
	
        Collection  c = recipients.getRecipients();
        Iterator    it = c.iterator();

        if (it.hasNext())
        {
            RecipientInformation   recipient = (RecipientInformation)it.next();

            byte[] recData = recipient.getContent(new JceKeyTransEnvelopedRecipient(recipientPrikey).setProvider(PROVIDER_NAME));

            //clearText
            return new String(recData, DEFAULT_ENCODING);
        }
        else
        {
        	throw new Exception("数据包结构有误，不含 recipient 信息");
        }
        
	  
	}
	
	@Override
	public byte[] envelopeWithPkcs7(X509Certificate recipientCert, Certificate signerCert, PrivateKey signerPriKey, String clearText) throws IOException, Exception
	{

		CMSEnvelopedData envelope = envelope(recipientCert, signerCert, signerPriKey, clearText);
		
		return signWithPkcs7(signerCert, signerPriKey, envelope.getEncoded());
	}
	
	@Override
	public String openEnvelopeWithPkcs7(String pkcs7WithB64, PrivateKey recipientPriKey) throws Exception
	{
		byte[] contentData = getDataFromPkcs7(pkcs7WithB64);
		CMSEnvelopedData cmsEnvelopedData = new CMSEnvelopedData(contentData);
		return openEnvelope(cmsEnvelopedData, recipientPriKey);
	}
	
	private boolean isAPair(PublicKey pubKey, PrivateKey priKey)
	{
		if(pubKey == null || priKey == null)
		{
			return false;
		}
		
		String arbitaryText = "arbitaryText";
		try{
			byte[] encryptByKey = encryptByKey(arbitaryText.getBytes(DEFAULT_ENCODING), priKey);
			byte[] decryptByKey = decryptByKey(encryptByKey, pubKey);
			
			String clearText = new String(decryptByKey, DEFAULT_ENCODING);
			
			return arbitaryText.equals(clearText);
		}catch(Exception ex)
		{
			System.out.println("比较 PublicKey 和 PrivateKey 出错："+ex.getMessage());
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		//数字信封 pkcs7 包测试
/*	    final String issuerName = "CN=www.mockserver.com, O=xxxxxx, L=xxxxxx, ST=xxxxxx, C=xxxxxx";
	    final Date notBefore = TimeUtil.parse("2016-02-28 12:12:12", TimeUtil.FORMAT_NORMAL);
	    final Date notAfter = TimeUtil.parse("2038-01-01 12:12:12", TimeUtil.FORMAT_NORMAL);
	    final String subjectName = issuerName;
	    final BigInteger serialNumber = BigInteger.valueOf(new SecureRandom().nextInt());
	    
		RSAAsymmetric rsaAsymmetric = new RSAAsymmetric();
		KeyPair recipientKeyPair = rsaAsymmetric.createKeyPair();
		KeyPair senderKeyPair = rsaAsymmetric.createKeyPair();
		
		Certificate recipientCert = rsaAsymmetric.createCertificate(recipientKeyPair, issuerName, serialNumber, notBefore, notAfter, subjectName);
		Certificate senderCert = rsaAsymmetric.createCertificate(senderKeyPair, issuerName, serialNumber, notBefore, notAfter, subjectName);
		
		CMSEnvelopedData envelopedData = rsaAsymmetric.envelope((X509Certificate) recipientCert, senderCert, senderKeyPair.getPrivate(), "This is a secret");
		
		String openEnvelope = rsaAsymmetric.openEnvelope(envelopedData, recipientKeyPair.getPrivate());
		
		byte[] envelopeWithPkcs7 = rsaAsymmetric.envelopeWithPkcs7((X509Certificate) recipientCert, senderCert, senderKeyPair.getPrivate(), "This is another secret");
		
		String pkcs7 = Base64.encodeToStr(envelopeWithPkcs7);
		System.out.println("b64:");
		System.out.println(pkcs7);
		String openEnvelopeWithPkcs7 = rsaAsymmetric.openEnvelopeWithPkcs7(pkcs7, recipientKeyPair.getPrivate());
		if(rsaAsymmetric.verifySignPkcs7(envelopeWithPkcs7))
		{
			//clearText
			System.out.println(openEnvelopeWithPkcs7);
		}*/
		
		//CSR 测试
/*	    RSAAsymmetric rsaAsymmetric = new RSAAsymmetric();
	    String generateCSR = rsaAsymmetric.generateCSR(rsaAsymmetric.createKeyPair(),"me");
	    
	    String privateKeyStr = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCj+dgf4iRBkWAMVCEy45KJVy73EChENrNtWPZbLV+vMpxeA8SOn9IXnDJEqdZWXhCQm0S5LhY7fcnW5hKPdxH1SKk+fg3FB7Puv4bJTa7rNptRqgm4Ic3QzSFDRMgI3Ut/gmkzSQ7iRgBhKIyiFs9HOTKseiO7F9o3xfsMzONmlEdMaJ4yZgo5Gw5/FdtJlhlXC9KqMiLWDkCl7j8jxGcsevmv7G5wMNkhnOxCo8ZXiJQ45SN6og0/P81w+dMRzgJ7d/4osa7t6mhLv58Yaikgfxknwtj+5f34FhStjL7MtqV1V/BsE/8Plmbh1ShpRqSWIcRI9wxjX/HLU7B8chAgMBAAECggEARz40EpY0XnCFJJYg3nVVo2pHs3xHomuJxYaTcsXh/sKkgYxth/IUW8G3bXHE+D1iQRHU6AgIDMz4NvA7PC3llYZ+UfJ+lQ5ltONt8mRYDUXqca7JDkFRpNibDRkDOCa9uKa2glvJpbH4VD5D6+Cso0wwMs6xceExmn6/eOvd7/Gsvcp2OtP9mRldGXnCxY+YdcOsl59yGO5azPs8LRLtovrKOUNByH2eSbWYUQnEtVH0HB3N8VbxvA9R0KEiNVaj/Qzg/Evv3sBFslJ3JCdEj/Z15NiifOQgNp8dhf9ckb7RxT35nbil7B8tawd6Z38m1J15lCj1Tdv4qh5mAD8SAQKBgQDmooZYZ8Os14qu9BnCajDAwOQIy1S5/LWQk6Ld+v920WX3KrvS1JC5RBwRHWkacwnZFhzT0qqXGHp58g4m7X72DUSMYEXIiTOtkX6RDNd5/2ZoLdLLSbmmeyY19FpDT6rCimDHdCzz1j6syjXL4SCnv7wR5BoaZNG36X7zUj+r8QKBgQC2Ao1ZUTtlWcebvV+BlNuqsPJnwNF0MUcWNqMC5OSBeH+mfwhSTZRjgZvZMs1s1IAYFfkOMOSP0F08ZxMJ0laYysm5fS3HIV1cdzf2eBf5nrzg4ZfQfMfU99gPMjRwuLwPa2R8Ir7enTP8Ee+EUkIst79fIRKw08UbZvRDteu+MQKBgC/1g/JGQY5jk9cls2WWJ2Uttz2M6qVyQ185FBkM5KqUiJuJK12ADkg4PY3hi8WQPnACBSSXHholYPKSvxahNFF+GM8IBfrZbQGey67l+LjJv0XSoY7cWdqgqSV3Fn4AxwWFOPLA2cgquQW9Vsp6mgvH9xfRUwxCAso3p8p5Q/xBAoGAZDAVdIP1iP2Zlc3xQ5gYLuZGGPyXjzkM41ph8tbiPa6BvbmRcBSKSRfwHOgNEgoLFLcLqFcbiVpt6DDo1vA0gNinn/Ya+9EO3jY11PMYZ2yMldE4SyhUq5NeGEdPfHkD9AzufDJ4FHw+QFPzH0hUat8edZP0AOghSMssTBVY1hECgYBCS2632u1IzLsCb5xU/Ao4P3GUZdE7v+5myHZBbKHxjjj59GW8VixvkyFd84rGwG/PNxuyUfEKKb47MqkjGDRYH5f8vPPeF2ABkpUKXzvpftGL3Ss5YqQMsWHxRFI9opnG3fa4EZRhDktjzHoF828JoKeixCF4uBRyluo5eZWvsQ==";
	    String certificateStr = "MIIDRDCCAiygAwIBAgIElRjq0DANBgkqhkiG9w0BAQsFADBkMRUwEwYDVQQDDAzlh63lronnp5HmioAxGTAXBgNVBAoMEHd3dy54LWNyZWRpdC5jb20xDzANBgNVBAcMBuS4iua1tzEPMA0GA1UECAwG5LiK5rW3MQ4wDAYDVQQGEwVjaGluYTAeFw0xNjAyMjgwNDEyMTJaFw0zODAxMDEwNDEyMTJaMGQxFTATBgNVBAMMDOWHreWuieenkeaKgDEZMBcGA1UECgwQd3d3LngtY3JlZGl0LmNvbTEPMA0GA1UEBwwG5LiK5rW3MQ8wDQYDVQQIDAbkuIrmtbcxDjAMBgNVBAYTBWNoaW5hMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo/nYH+IkQZFgDFQhMuOSiVcu9xAoRDazbVj2Wy1frzKcXgPEjp/SF5wyRKnWVl4QkJtEuS4WO33J1uYSj3cR9UipPn4NxQez7r+GyU2u6zabUaoJuCHN0M0hQ0TICN1Lf4JpM0kO4kYAYSiMohbE2/RzkyrHojuxfaN8X7DMzjZpRHTGieMmYKORsOfxXbSZYZVwvSqjIi1g5Ape4/I8RnLHr5r+xucDDZIZzsQqPGV4iUOOUjeqINPz/NcPnTEc4Ce3f+KLGu7epoS7+fGGopIH8ZJ8LY/uX9+BYUrYy+zLaldVfwbBP/D5Zm4dUoaUakliHESPcMY1/xy1OwfHIQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQAdhA7YwdkLZ70QddOZA02TO6TWPSXh86vuFZQnl9F8Wk41dqwRj8zDxqfooiRULbeOUs1HgR3sUU+TcDsXfPxP3arFHWqG8WxVWnIE5lKXXwAwkyHNgZlkhPGC460HNM+PAlNPmSLCZAuGDALQ8B8EX/ZAx0X3nLtsYD7Mq3DCf9U9OG2mInxaBecwzMMgb/vHQdnRxw7wm1uMvkU/uMFKhdW8Wjpe1UxsCYRoLxruwTxA4/7hnZ9pB64b/IMopukcRCuxp7Dt24TzuP6/aCkh/TpylxWBl98mPm37AcV2vT3HjeLqGvo62MkHUYxxFiItNnp06V5XIa7NpxgYx5qX";
	    
	    
	    Certificate signCSR = rsaAsymmetric.signCSR(generateCSR, (X509Certificate)rsaAsymmetric.getCertificate(certificateStr), rsaAsymmetric.getPrivateKey(privateKeyStr), null);
	    System.out.println(Base64.encodeToStr(signCSR.getEncoded()));*/
	}
	
	static class DNBuilder
	{
	    public DNBuilder setOrg(String orgName)
	    {
	        return this;
	    }
	    
	    public String build()
	    {
	        return null;
	    }
	}
	
    @Override
    public String generateCSR(KeyPair pair, String subjectName) throws Exception
    {
        PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder(
            new X500Principal(subjectName), pair.getPublic());
        JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder(SIGNATURE_ALGORITHM);
        ContentSigner signer = csBuilder.build(pair.getPrivate());
        PKCS10CertificationRequest csr = p10Builder.build(signer);
        //String b64 = Base64.encodeToStr(csr.getEncoded());
        
        //获得格式化字符串
        StringWriter stringWriter = new StringWriter();
        PemWriter pm = new JcaPEMWriter(stringWriter);
        
        PemObject pemObject = new PemObject(CERT_SIGNING_REQUEST_TYPE, csr.getEncoded());
        pm.writeObject(pemObject);
        
        pm.close();
        stringWriter.close();
        
        return stringWriter.toString();
    }
    
    @Override
    public Certificate signCSR(String CSR, X509Certificate issuerCert, PrivateKey privateKey, Integer validityInDays) throws Exception
    {
        if(validityInDays == null)
        {
            validityInDays = DEFAULT_VALIDATY_DAYS;
        }
        
/*        //去掉格式
        String ber = PEMFormat.certReqPEM2BER(CSR);
        ber = ber.replaceAll(System.getProperty("line.separator"), "");*/
        
        PemReader pemReader = new PemReader(new StringReader(CSR));
        PemObject pemObject = pemReader.readPemObject();
        
        PKCS10CertificationRequest csr = new PKCS10CertificationRequest(pemObject.getContent());
        
        if(this.validateCSR(csr) == false)
        {
            throw new Exception("收到的 CSR 签名无效");
        }
        
        BigInteger serialNumber = BigInteger.valueOf(new SecureRandom().nextInt());
        Date from = new Date();
        Date to = new Date(System.currentTimeMillis() + (validityInDays * 86400000L));
        X500Name issuerName = new X500Name(issuerCert.getSubjectX500Principal().getName());
        PublicKey publicKey = extractPublicKey(csr);
        
        Certificate certificate = this.createCertificate(publicKey, privateKey, issuerName, serialNumber, from, to, csr.getSubject(), csr, issuerCert);
        
        return certificate;

    }
    

    private PublicKey extractPublicKey(PKCS10CertificationRequest csr ) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException
    {
        SubjectPublicKeyInfo pkInfo = csr.getSubjectPublicKeyInfo();
        RSAKeyParameters rsa = (RSAKeyParameters) PublicKeyFactory.createKey(pkInfo);
        RSAPublicKeySpec rsaSpec = new RSAPublicKeySpec(rsa.getModulus(), rsa.getExponent());
        KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey rsaPub = kf.generatePublic(rsaSpec);
        
        return rsaPub;
    }
    
    public boolean validateCSR(PKCS10CertificationRequest csr) throws OperatorCreationException, PKCSException, InvalidKeySpecException, NoSuchAlgorithmException, IOException
    {
        PublicKey publicKey = extractPublicKey(csr);
        return csr.isSignatureValid(new JcaContentVerifierProviderBuilder().setProvider("BC").build(publicKey));
    }
    

	
}

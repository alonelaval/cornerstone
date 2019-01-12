/**
 * @(#)DigestUtils.java
 *
 * @author xuji
 * @version 1.0 2014-7-9
 *
 * Copyright (C) 2012,2014 , PING' AN, Inc.
 */
package com.alonelaval.common.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;
import java.util.Base64;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class DigestUtils
{
	static
	{
		Security.addProvider(new BouncyCastleProvider());
	}
    public static byte[] hash(byte[] message, String alg) throws Exception
    {
        MessageDigest md = MessageDigest.getInstance(alg);
        md.update(message);
        return md.digest();
    }

    public static String md5(byte[] message, boolean b64Encoded) throws Exception
    {
        byte[] data = hash(message, "MD5");
        
        if (b64Encoded)
        {
            return new String(Base64.getEncoder().encode(data));
        }
        else
        {
            return HexUtils.byte2Hex(data);
        }
    }
    
    public static String sha1(byte[] message, boolean b64Encoded) throws Exception
    {
        byte[] data = hash(message, "SHA1");
        
        if (b64Encoded)
        {
            return new String(Base64.getEncoder().encode(data));
        }
        else
        {
            return HexUtils.byte2Hex(data);
        }
    }
    
    public static String sha256(byte[] message, boolean b64Encoded) throws Exception
    {
        byte[] data = hash(message, "SHA256");
        
        if (b64Encoded)
        {
            return new String(Base64.getEncoder().encode(data));
        }
        else
        {
            return HexUtils.byte2Hex(data);
        }
    }
    
    public static String md5(byte[] message) throws Exception
    {
        return md5(message, false);
    }
    
    public static String sha1(byte[] message) throws Exception
    {
        return sha1(message, false);
    }
    
    public static void main(String[] args) throws Exception
    {
    	Security.addProvider(new BouncyCastleProvider());
    	System.out.println(sha256("test".getBytes(), true));
    }
}



/**
 * $Log: DigestUtils.java,v $
 * 
 * @version 1.0 2014-7-9 
 *
 */
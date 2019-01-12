/**
 * @(#)HexUtils.java
 *
 * @author xuji
 * @version 1.0 2014-7-9
 *
 * Copyright (C) 2012,2014 , PING' AN, Inc.
 */
package com.alonelaval.common.security;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class HexUtils
{
    private static final String HEX = "0123456789abcdef";
    
    public static String byte2Hex(byte[] bytes)
    {
        String result = "";
        
        if (null != bytes)
        {
            for(int i=0; i< bytes.length; i++)
            {
                result += HEX.charAt(bytes[i] >> 4 & 0x0F);
                result += HEX.charAt(bytes[i] & 0x0F);
            }
        }
        
        return result;
    }
    
    public static byte[] hex2Byte(String text) throws Exception
    {
        String hexText = text;
        if (text.length() % 2 == 1)
        {
            hexText = "0" + text;
        }
        hexText = hexText.toLowerCase();
        
        int     len     = hexText.length() / 2;
        byte[]  result  = new byte[len];
        for (int i = 0; i < len; i++)
        {
            String s = hexText.substring(2 * i, 2 * i + 2);
            result[i] = (byte)(Integer.parseInt(s, 16) & 0xFF);
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
        try
        {
            String s =  "10000000";
            byte[] data = hex2Byte(s);
            
            
            String s1 = byte2Hex(data);
            
            System.out.println(s1);
            
            if (s.equals(s1))
            {
                System.out.println("ok");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


/**
 * $Log: HexUtils.java,v $
 * 
 * @version 1.0 2014-7-9 
 *
 */
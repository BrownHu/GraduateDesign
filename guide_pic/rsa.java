


/**RSA算法*/ 

        /** 使用私钥字节数组解密 */
    public static final String RSA = data.getStringExtra(DECODE_CONTENT_KEY); //获取扫描信息码的string 序列
    /**加密方式，android的*/
    // public static final String TRANSFORMATION = "RSA/None/NoPadding";
    
    public static byte[] decryptByPrivateKey(byte[] encrypted, byte[] privateKey) throws Exception {
        // 得到私钥对象
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PrivateKey keyPrivate = kf.generatePrivate(keySpec);
        // 解密数据
        Cipher cp = Cipher.getInstance(TRANSFORMATION);
        cp.init(Cipher.DECRYPT_MODE, keyPrivate);
        byte[] arr = cp.doFinal(encrypted);
        return arr;
    }



    /*读取私钥文件解密*/


    //获取加密后的扫描结果

    enctypt=data.getStringExtra(DECODE_CONTENT_KEY)
        
        try {
          //读取私钥文件
         String privateKeyString = IOUtils.readAssetsFile(this, "rsa_private_key.pem");
         //base64解码
         byte[] privateKey = Base64Utils.decodeToBytes(privateKeyString);
         //解密
         byte[] decrypt = RSAUtils.decryptByPrivateKey(encrypt, privateKey);
         Log.d("TAG", "解密后的数据：" + new String(decrypt, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }


       



    



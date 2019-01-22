package zc.neu.com.securitystorage;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 封装了RSA基本操作的类
 * 单例模式，保持全局唯一性，为了保证秘钥的稳定性
 */
public class RSA {

  private final static SecureRandom random = new SecureRandom();
  private final static BigInteger one = new BigInteger("1");
  private final static int bitLength = 1024;//加密长度

  private BigInteger modulus;// p * q的值
  private BigInteger publicKey;// 公钥
  private BigInteger privateKey;// 私钥

  private static RSA rsa;

  public static RSA getInstance(){
    if(rsa == null){
      rsa = new RSA();
      return rsa;
    }
    return rsa;
  }

  private RSA(){

  }

  /**
   * 实例化加解密的参数
   * public key , private key , modulus(N)
   * 这种方法生成的参数一定要保存下来
   */
  public void initParams(){
    BigInteger p = BigInteger.probablePrime(bitLength / 2, new Random());
    BigInteger q = BigInteger.probablePrime(bitLength / 2, new Random());
    BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
    this.modulus = p.multiply(q);
    this.publicKey = BigInteger.probablePrime(bitLength / 4 * 3,new Random());
    this.privateKey = publicKey.modInverse(phi);
  }

  /**
   * 设置加密时的参数
   * @param modulus
   * @param publicKey
   */
  public void setEncrypParams(BigInteger modulus,BigInteger publicKey){
    this.modulus = modulus;
    this.publicKey = publicKey;
  }

  /**
   * 设置解密时的参数
   * @param modulus
   * @param publicKey
   */
  public void setDecrypParams(BigInteger modulus,BigInteger privateKey){
    this.modulus = modulus;
    this.privateKey = privateKey;
  }

  /**
   * 加密过程
   * @param plainInt 明文数据
   * @return 密文数据
   */
  public BigInteger encrypt(BigInteger plainInt){
    return plainInt.modPow(publicKey, modulus);
  }

  /**
   * 解密过程
   * @param cipherInt 密文数据
   * @return 明文数据
   */
  public BigInteger decrypt(BigInteger cipherInt){
    return cipherInt.modPow(privateKey, modulus);
  }


  //return N
  public BigInteger getModulus(){
    return this.modulus;
  }

  //return public key
  public String getPublicKey(){
    return this.publicKey.toString();
  }

  //return private key
  public String getPrivateKey(){
    return this.privateKey.toString();
  }

}
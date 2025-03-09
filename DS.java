
 import java.security.*;
 import java.util.Base64;
 import java.util.Scanner;
 public class DS {
 public static void main(String[] args) {
 try {
 // Generate key pair
 KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
 keyPairGen.initialize(2048);
 KeyPair keyPair = keyPairGen.generateKeyPair();
 PrivateKey privateKey = keyPair.getPrivate();
 PublicKey publicKey = keyPair.getPublic();
 try (Scanner sc = new Scanner(System.in)) {
 System.out.println("Enter the secret message:");
 String message = sc.nextLine();
 // Sign the message
 Signature signature = Signature.getInstance("SHA256withDSA");
 signature.initSign(privateKey);
 signature.update(message.getBytes());
 byte[] digitalSignature = signature.sign();
 String signatureBase64 = Base64.getEncoder().encodeToString(digitalSignature);
 System.out.println("Digital Signature: " + signatureBase64);
 // Verify the signature
 signature.initVerify(publicKey);
 signature.update(message.getBytes());
 boolean isVerified = signature.verify(digitalSignature);
 System.out.println("Signature verification result: " + isVerified);
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 }

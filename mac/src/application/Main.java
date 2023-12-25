package application;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Main {

	public static void main(String[] args) {
		// gerar o Salt
		byte[] saltBytes = Base64.getDecoder().decode("zD/lYvAi6FcChUylpBqmqQ==");//mudar
				
		// gerar a chave
		String password = "H&ti&11&Vit0ri@d&M@t0s";//mudar
		int iterations = 65536;//conferir se é igual
		int keySize = 512;// conferir
		KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, keySize);
		SecretKeyFactory factory;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");//conferir 
			byte[] key = factory.generateSecret(spec).getEncoded();
			String keyB64 = Base64.getEncoder().encodeToString(key);
			System.out.print(keyB64);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

}

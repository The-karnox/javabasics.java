import java.util.*;

public class App {
    public static final int ALPHABET_SIZE = 26;
    public static final int A = 7; // multiplication key
    public static final int B = 2; // addition key
    public static int aInverse; // modular multiplicative inverse of A


     // Encrypts the plaintext using the Affine Cipher
     public static String encrypt(String plaintext) {
        char[] chars = plaintext.toUpperCase().toCharArray();
        StringBuilder ciphertext = new StringBuilder();

        for (char c : chars) {
            int x = (A * (c - 'A') + B) % ALPHABET_SIZE;
            ciphertext.append((char) (x + 'A'));
        }

        return ciphertext.toString();
    }


    
    // Decrypts the ciphertext using the Affine Cipher
    public static String decrypt(String ciphertext) {
        char[] chars = ciphertext.toLowerCase().toCharArray();
        StringBuilder plaintext = new StringBuilder();

        for (char c : chars) {
            int x = aInverse * ((c - 'a') - B + ALPHABET_SIZE) % ALPHABET_SIZE;
            plaintext.append((char) (x + 'a'));
        }

        return plaintext.toString();
    }


    
    // Returns the modular multiplicative inverse of a number using the extended Euclidean algorithm
    public static int getModInverse(int a, int m) {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;

        if (m == 1) {
            return 0;
        }

        while (a > 1) {
            q = a / m;
            t = m;
            m = a % m;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }

        if (x1 < 0) {
            x1 += m0;
        }

        return x1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plaintext, ciphertext;

        // Compute the modular multiplicative inverse of A
        aInverse = getModInverse(A, ALPHABET_SIZE);

        System.out.print("Enter plaintext: ");
        plaintext = sc.nextLine();
        ciphertext = encrypt(plaintext);
        System.out.println("Encrypted text: " + ciphertext);

        System.out.print("Enter encrypted text: ");
        ciphertext = sc.nextLine();
        plaintext = decrypt(ciphertext);
        System.out.println("Decrypted text: " + plaintext);

        sc.close();
    }
}

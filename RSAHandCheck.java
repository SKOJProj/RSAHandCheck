/*
Author: Kyle Rozendaal M.S. Information Assurance: May 2020 St. Cloud State University.
Date: 10/3/2019
Purpose: At St. Cloud State University IA 606 students are required to learn basic RSA encryption by hand.
This program runs the basic maths behind the RSA method and allows you to check any set of numbers to determine whether
your hand-encryption is correct.

Basics of this method of RSA Encryption:

Prime1,Prime2: Prime numbers are selected by the user and used to determine values later in the encryption algorithm.
N: Value derived from two selected prime numbers: N = Prime1 * Prime2
Totient of N: Derived from two selected prime numbers: Totient N = (Prime1 - 1) * (Prime2 - 1)
E: Selected value used to encrypt the message. E must be relatively prime with the totient of N such that the greatest common divisor is 1.
D: Derived value used to decrypt the cyphertext. E * D = TotientN + 1 mod TotientN = 1
    Therefore: (E * D) mod Totient N = 1 (This is the method used in this program to derive the value of D.)

Cyphertext = Message(any integer)^e mod N

Decryption Algorithm: C^D mod N == Message ^ (E*D) mod N

*/

import java.util.Scanner;
import java.lang.Math;

public class RSACreation {

    public static void main(String[] args)
    {
        int prime1;
        int prime2;
        int TN;
        Double E;
        int D = 0;

       /*
       These two prime numbers are used to determine the value of N=(P1 * P2) and the totient of N (P1-1)*(P2-1)
       These are always selected by the user.

       */

       Scanner keyboard = new Scanner(System.in);
       System.out.println("Please enter two prime numbers with a return key between them");
       prime1 = keyboard.nextInt();
       prime2 = keyboard.nextInt();

       /* This block assigns vales to N and the Totient of N. ( N=(P1 * P2), Totient of N=(P1-1)*(P2-1) )*/

        int N = prime1 * prime2;
        TN = ((prime1 - 1) * (prime2 - 1));

       System.out.println("Please enter a number that is relativly prime with " + TN + " . Common examples are 3, 17, and 65537. This will be your encryption value: E.");

       //E is the value used for encryption and must be relatively prime with the totient of N, such that the largest common denominator is 1.

       E = keyboard.nextDouble();

       /*The following loop determines the decryption value. D increases by one until E*D mod TN != 1
       D = e^-1(mod totient N),
       E*D = totient N + 1 mod totient N = 1
       AND E*D mod totient N = 1

       To Solve for D with a provided E, simply take all values for D, multiplied by E, mod them with Totient of N until it equals 1
       This will always provide the lowest possible value for the Decryption Value.

       Feel free to comment out the System.out.println(D) if you don't want to see the flow out output.
       */

       do {
       D++;
       System.out.println(D);
       }
       while ((E * D) % TN != 1);

       /* This block encrpyts the messaage. (message^e % N = cyphertext)*/

       System.out.println("Please enter an integer to be encrypted");
       Double message = keyboard.nextDouble();
       Double cyphertext = ((Math.pow(message, E)) % N);

       //Next block simply returns all data in an easy-to-read format.

       System.out.println("Your results:");
       System.out.println("Prime1 (P) = " + prime1);
       System.out.println("Prime2 (Q) = " + prime2 + "\n");
       System.out.println("N = " + N);
       System.out.println("Totient N = " + TN + "\n");
       System.out.println("Encrption Value (E) = " + E);
       System.out.println("Decryption Value (D) = " + D);
       System.out.println("Encrypted Message (Cyphertext) = " + cyphertext);
       System.out.println("Message = " + message + "\n");

       // Proof of concept block that decrypts the encrpyted message and returns the plaintext.
       double reversed = ((Math.pow(cyphertext, D)) % N);

       System.out.println("Proof of concept that decrypts the encrypted message: " + reversed);

    }
}

# RSAHandCheck

Author: Kyle Rozendaal M.S. Information Assurance: May 2020 St. Cloud State University.
Date: 10/3/2019
Purpose: At St. Cloud State University IA 606 students are required to learn basic RSA encryption by hand.
This program runs the basic maths behind the RSA method and allows you to check any set of numbers to determine whether
your hand-encryption is correct.

Basics of this method of RSA Encryption:

Prime1,Prime2: Prime numbers are selected by the user and used to determine values later in the encryption algorithm.

N: Value derived from two selected prime numbers: N = Prime1 * Prime2

Totient of N (TN in the code): Derived from two selected prime numbers: Totient N = (Prime1 - 1) * (Prime2 - 1)

E: Selected value used to encrypt the message. E must be relatively prime with the totient of N such that the greatest common divisor is 1.

D: Derived value used to decrypt the cyphertext. E * D = TotientN + 1 mod TotientN = 1
    Therefore: (E * D) mod Totient N = 1 (This is the method used in this program to derive the value of D.)

Message: In this case, the message is represented by an integer value., selected by the sender

Cyphertext = Message^e mod N

Decryption Algorithm: C^D mod N == Message ^ (E*D) mod N



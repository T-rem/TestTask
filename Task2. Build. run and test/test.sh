#!/bin/sh
cd ../src/
echo " Input: -h"
echo " Expected output:
blach-blach"
echo "Actual output:"
java -jar Task2.jar -h

echo " Input: -login admin -pass admin"
echo " Expected output:
0"
echo "Actual output:"
java -jar Task2.jar -login admin -pass admin


echo " Input: -login user@ -pass user1"
echo " Expected output:
2"
echo "Actual output:"
java -jar Task2.jar -login user@ -pass user1

echo " Input: -pass user1 -login user1"
echo " Expected output:
0"
echo "Actual output:"
java -jar Task2.jar -pass user1 -login user1

echo " Input: -login user1"
echo " Expected output:
blach-blach"
echo "Actual output:"
java -jar Task2.jar -login user1

echo " Input: -login user3 -pass user1"
echo " Expected output:
3"
echo "Actual output:"
java -jar Task2.jar -login user3 -pass user1

echo " Input: -login user1 -pass 123"
echo " Expected output:
4"
echo "Actual output:"
java -jar Task2.jar -login user1 -pass 123




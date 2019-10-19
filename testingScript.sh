#!/bin/sh
arg=$(head -n 1 ./Test.txt)
expect=$(sed -n '3,$p' ./Test.txt)
echo " Input: $arg \n"
echo " Expected output:
$expect"
cd ./src
echo "Application output:"
java -jar application.jar $arg

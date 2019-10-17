#!/bin/sh
string=$(head -n 1 ./Test.txt)
echo " Input: $string \n"
echo "Expected output:"
string1=$(sed -n '3,$p' ./Test.txt) 
echo "$string1"
cd ./out/artifacts/TestTaskJar
echo "Application output:"
java -jar TestTask.jar $string


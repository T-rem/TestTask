#!/bin/sh
arg=$(head -n 1 ./Test.txt)
expect=$(sed -n '3,$p' ./Test.txt)
echo " Input: $arg \n"
echo " Expected output:
$expect"
cd ./out/artifacts/TestTask_jar
echo " Application output:"
java -jar TestTask.jar $arg

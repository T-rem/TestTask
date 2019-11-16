#!/bin/sh
echo starting comil
kotlinc -cp kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com/ -include-runtime -d application.jar
echo finish compil

echo " Input: -login admin -pass admin -res AB.C.D -role EXECUTE"
echo " Expected output:
0"
echo "Actual output:"
./run.sh -login admin -pass admin -res AB.C.D -role EXECUTE
echo "$?"

echo " Input: -login user1 -pass user1 -res AB.C -role READ"
echo " Expected output:
0"
echo "Actual output:"
./run.sh -login user1 -pass user1 -res AB.C -role READ
echo "$?"

echo " Input: -login admin -pass admin -role EXECUTE -res AB.C.D"
echo " Expected output:
0"
echo "Actual output:"
./run.sh -login admin -pass admin -role EXECUTE -res AB.C.D
echo "$?"

echo " Input: -pass admin -login admin -role EXECUTE -res AB.C.D"
echo " Expected output:
0"
echo "Actual output:"
./run.sh -pass admin -login admin -role EXECUTE -res AB.C.D
echo "$?"

echo " Input: -login user1 -pass user1 -res AB.C"
echo " Expected output:
0"
echo "Actual output:"
./run.sh -login user1 -pass user1 -res AB.C

echo "$?"

echo " Input: -login user1 –pass user -res АВ.C"
echo " Expected output:
0"
echo "Actual output:"
./run.sh -login user1 -pass user1 -res АВ.C
echo "$?"

echo " Input: -login admin –pass admin -res АВ –role FULLACCESS "
echo " Expected output:
5"
echo "Actual output:"
./run.sh -login admin -pass admin -res АВ -role FULLACCESS
echo "$?"

echo " Input: -login user1 –pass user1 -res АВ –role READ "
echo " Expected output:
6"
echo "Actual output:"
./run.sh -login user1 -pass user1 -res АВ -role READ
echo "$?"

echo " Input: xxx"
echo " Expected output:
1"
echo "Actual output:"
./run.sh xxx
echo "$?"


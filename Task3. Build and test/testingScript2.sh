#!/bin/sh
cd ../src/com/remnev/tasks
echo " Input: -login admin -pass admin -res AB.C.D -role EXECUTE"
echo " Expected output:
0"
echo "Actual output:"
java -jar Task3.jar -login admin -pass admin -res AB.C.D -role EXECUTE
echo "$?"

echo " Input: -login user1 -pass user1 -res AB.C -role READ"
echo " Expected output:
0"
echo "Actual output:"
java -jar Task3.jar -login user1 -pass user1 -res AB.C -role READ
echo "$?"

echo " Input: -login admin -pass admin -role EXECUTE -res AB.C.D"
echo " Expected output:
0"
echo "Actual output:"
java -jar Task3.jar -login admin -pass admin -role EXECUTE -res AB.C.D
echo "$?"

echo " Input: -pass admin -login admin -role EXECUTE -res AB.C.D"
echo " Expected output:
0"
echo "Actual output:"
java -jar Task3.jar -pass admin -login admin -role EXECUTE -res AB.C.D
echo "$?"

echo " Input: -login user1 -pass user1 -res AB.C"
echo " Expected output:
0"
echo "Actual output:"
java -jar Task3.jar -login user1 -pass user1 -res AB.C
echo "$?"

echo " Input: -login user1 –pass user -res АВ.C"
echo " Expected output:
6"
echo "Actual output:"
java -jar Task3.jar -login user1 –pass user -res АВ.C
echo "$?"

echo " Input: "
echo " Expected output:
5"
echo "Actual output: -login admin –pass admin -res АВ –role FULLACCESS"
java -jar Task2.jar -login admin –pass admin -res АВ –role FULLACCESS
echo "$?"

echo " Input: xxx"
echo " Expected output:
1"
echo "Actual output:"
java -jar Task2.jar xxx
echo "$?"


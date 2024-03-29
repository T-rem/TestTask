#!/bin/bash
echo starting compil
kotlinc -cp kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com/ -include-runtime -d application.jar
echo finish compil
let fail=0
fn()
{
  echo Input: "$1"
  echo Expected output: "$2"
  ./run.sh $1
  res=$?
  echo Actual output: $res
  if [ $res -eq $2 ]; then
    echo -e "\e[32mSuccess\e[0m"
  else
    echo -e "\e[31mFailed\e[0m"
    let "fail=fail+1"
  fi
}
fn "-login admin -pass admin -res A.BC.D -role EXECUTE" "0"
fn "-login admin -pass admin -res AB.C.D -role EXECUTE" "0"
fn "-login user1 -pass user1 -res AB.C -role READ" "0"
fn "-login admin -pass admin -role EXECUTE -res AB.C.D" "0"
fn "-pass admin -login admin -role EXECUTE -res AB.C.D" "0"
fn "-login user1 -pass user1 -res AB.C" "0"
fn "-login admin -pass admin -res АВ -role FULLACCESS" "5"
fn "-login user1 -pass user1 -res АВ -role READ" "6"
fn "bla-bla-bla" "1"
fn "-login admin -pass admin -res AB.C -role EXECUTE -ds 2019-11-01 -de 2019-11-02 -vol 7" "0"
fn "-login admin -pass admin -res AB.C -role EXECUTE -ds 2019-11-03 -de 2019-11-01 -vol 7" "0"
fn "-login admin -pass admin -res AB.C -role EXECUTE -ds 2019 -de 2019 -vol 15" "7"
fn "-login admin -pass admin -res AB.C -role EXECUTE -ds 2019-11-01 -de 2019-11-02 -vol -1" "7"
fn "-login admin -pass admin -res AB -role WRITE -ds 2019-11-01 -de 2019-11-02 -vol bla-bla" "7"

if [ $fail -gt 0 ]; then
  echo Number of failed tests: "$fail"
  exit 9
fi
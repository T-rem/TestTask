#!/bin/sh
cd ../src
kotlinc Test.kt -include-runtime -d Task1.jar

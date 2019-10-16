#!/bin/sh
echo "Input: the quick brown fox jumps over the lazy dog\n"
echo "Canonical output:
brown 1
dog 1
fox 1
jumps 1
lazy 1
over 1
quick 1
the 2\n"
cd ./out/artifacts/TestTaskJar
echo "Application output:"
java -jar TestTask.jar the quick brown fox jumps over the lazy dog


#! /bin/bash
javac Deadlock.java
for (( i = 0; i < 10000; i++ )); do
    echo "$i times"
    java Deadlock
done

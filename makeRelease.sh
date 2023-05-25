#!/bin/sh
clear

java -jar lib/jtb/jtb132.jar CGOL3.jj
java -cp lib/javacc/javacc-7.0.10.jar javacc -NOSTATIC jtb.out.jj

javac -d build JavaParser.java

cd build

jar cfvm cgol.jar ../META-INF/MANIFEST.MF *.class */*.class ../lib/javafx/*
mkdir -p ../release
mv cgol.jar ../release/cgol.jar




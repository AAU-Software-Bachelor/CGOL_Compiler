#bin/bash
clear

java -jar lib/jtb/jtb132.jar CGOL3.jj
java -cp lib/javacc/javacc-7.0.10.jar javacc jtb.out.jj

javac -d build JavaParser.java

java -cp build JavaParser $1
clear

java -jar ~/code/jtb.jar CGOL3.jj
java -cp /home/blueorc/Desktop/Programs/javacc/target/javacc.jar javacc jtb.out.jj

javac JavaParser.java

java JavaParser inputfile.cgol3


#java -cp /home/blueorc/Desktop/Programs/javacc/target/javacc.jar javacc CGOL3.jj

java -jar ~/code/jtb.jar CGOL3.jj
java -cp /home/blueorc/Desktop/Programs/javacc/target/javacc.jar javacc jtb.out.jj

#javac visitor/DepthFirstVisitor.java
javac JavaParser.java

#java visitor/DepthFirstVisitor inputfile.cgol3S
java JavaParser inputfile.cgol3

#clear ; java -cp /home/blueorc/Desktop/Programs/javacc/target/javacc.jar javacc CGOL3experiment.jj ; javac JavaParser.java ; java JavaParser DomCard.txt
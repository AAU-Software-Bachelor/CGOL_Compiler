// Generated by JTB 1.3.2
//

import syntaxtree.ClassBodyDeclaration;
import syntaxtree.ClassDeclaration;
import syntaxtree.NodeChoice;
import syntaxtree.field_modifier;
import visitor.DepthFirstVisitor;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MyVisitor extends DepthFirstVisitor {
   private String output;
   private String fileName;

   public MyVisitor() {
      output = "";
   }

   public void visit(ClassDeclaration n) {
      fileName = n.f2.toString() + ".java";

      output += "package outputs;\n\n";

      output += ((NodeChoice) n.f0.nodes.get(0)).choice.toString() + " ";
      output += n.f1.toString() + " ";
      output += n.f2.toString() + " ";
      output += n.f5.toString() + "\n";
      n.f6.accept(this);
      output += n.f7.toString();
      System.out.println(output);
   }

   public void visit(ClassBodyDeclaration n) {
      String classBodyoutput = "";
      classBodyoutput= ((field_modifier) n.f0.f0.nodes.get(0)).f0.choice + " ";
      output += classBodyoutput;
   }

//   public void visit(TypeDeclaration n) {
//      n.f0.accept(this);
//   }


   public void writeOutputToFile() throws IOException {
      Files.write( Paths.get("outputs/" + fileName), output.getBytes());
   }

}
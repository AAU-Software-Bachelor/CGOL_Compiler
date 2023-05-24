// Generated by JTB 1.3.2
// modified in cooporation with ChatGPT



import syntaxtree.*;
import visitor.DepthFirstVisitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

public class MyVisitor extends DepthFirstVisitor {
   public static String firstClassName = "";
   public static int order = 0;
   public String output;
   private String fileName;
   private boolean methodOptional = false;
   private List<String> requiredParams = new ArrayList<String>();
   private List<CustomOptionalParam> optionalParams = new ArrayList<CustomOptionalParam>();
   private List<CustomOptionalParam> leftOutOptional = new ArrayList<CustomOptionalParam>();

   private List<List<CustomOptionalParam>> paramDublicateChecker = new ArrayList<List<CustomOptionalParam>>();

   private FieldDecoration currentField = null;
   //String[] spaces = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27"};
   String[] spaces = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
   private boolean unary = false;

   private static class FieldDecoration {
      public String name;
      public String type;
      public String defaultAccess;
      public FieldDecoration(String name, String type, String defaultAccess) {
         this.name = name;
         this.type = type;
         this.defaultAccess = defaultAccess;
      }

      public FieldDecoration() {}
   }

   public void visit(Block n) {
      output += " {\n";
      addOptional();
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      output += "}\n";
   }

   private void addOptional() {
      for(int i = 0; i < leftOutOptional.size(); i++) {
         output += leftOutOptional.get(i).toString() + ";\n";
      }
      leftOutOptional.clear();
   }

   public void visit(ReturnStatement n) {
      n.f0.accept(this);
      output += " ";
      n.f1.accept(this);
      n.f2.accept(this);
   }

   public void visit(BlockStatement n) {
      n.f0.accept(this);
      if(!output.endsWith("\n")) output += ";\n";
   }


   public MyVisitor() {
      output = "";
   }

   private String capitalizeFirstLetter(String input) {
      return input.substring(0, 1).toUpperCase() + input.substring(1);
   }

   public void visit(PrimitiveType n) {
      output += n.f0.choice.toString();
   }

   public void visit(TypeDeclaration n) {
      n.f0.choice.accept(this);
   }

   public void visit(InterfaceDeclaration n) {
      n.f0.accept(this);
   }

   public void visit(NodeOptional n) {
      if(n.node != null) {
         n.node.accept(this);
      }
   }

   public void visit(NodeListOptional n) {
      for (Node node: n.nodes) {
         if(methodOptional && (!output.endsWith(" ") && !output.endsWith("\n"))) output += spaces[22];
         node.accept(this);
      }
      methodOptional = false;
   }

   public void visit(PackageDeclaration n) {

   }

   public void visit(ClassDeclaration n) {
      if(order == 0) {
         firstClassName = n.f2.toString();
      }

      fileName = n.f2.toString() + ".java";

      output = "package outputs;\n\n" + output;
      n.f0.accept(this);
      if(n.f0.present()) output += " ";
      n.f1.accept(this);
      output += " ";
      n.f2.accept(this);
      output += " ";
      n.f3.accept(this);
      if(n.f3.present()) output += " ";
      n.f4.accept(this);
      if(n.f4.present()) output += " ";
      output += "{\n";
      n.f6.accept(this);
      output += "\n}\n";
      try {
         output = helpers.autoTab(output);
         writeOutputToFile();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void visit(ImportDeclaration n) {
      order++;
      try {
         JavaParser parser = new JavaParser(new java.io.FileInputStream(n.f1.f0.toString() + ".cgol3"));
         Node newDocRoot = parser.CompilationUnit();
         MyVisitor v = new MyVisitor();
         newDocRoot.accept(v);
      } catch (Exception e) {
         System.out.println(e.toString());
      }

      n.f0.accept(this);
      output += " outputs.";
      n.f1.accept(this);
      n.f3.accept(this);
      output += ".*;\n";
   }
   
   public void visit(ClassBodyDeclaration n) {
      n.f0.choice.accept(this);
   }
   public void visit(SwitchStatement n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      output += " {\n";
      n.f5.accept(this);
      output += "}\n";
   }

   public void visit(IfStatement n) {
      int i = 0;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
   }

   public void visit(ForStatement n) {
      int i = 0;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      output += "; ";
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
   }

   public void visit(ForInit n) {
      int i = 0;
      n.f0.accept(this);
      output += "; ";
   }



   public void visit(BreakStatement n) {
      n.f0.accept(this);
      output += ";\n";
   }

   public void visit(SwitchLabel n) {
      n.f0.accept(this);
      output += "\n";
   }
   public void visit(MethodDeclaration n) {
      int k = 0;
      requiredParams.clear();
      if(n.f2.f1.f1.node instanceof NodeSequence) {
         Vector<Node> params = ((NodeSequence)n.f2.f1.f1.node).nodes;
         if(params.get(0) instanceof FormalParameter && ((FormalParameter)params.get(0)).f0.choice instanceof NodeSequence) {
            Vector<Node> firstArgument = ((NodeSequence)((FormalParameter)params.get(0)).f0.choice).nodes;

            String param;

            if(((Type)firstArgument.get(0)).f0.choice instanceof PrimitiveType) {
               param = ((NodeToken)((PrimitiveType)((Type)firstArgument.get(0)).f0.choice).f0.choice).toString();
            } else {
               param = ((Name)((Type)firstArgument.get(0)).f0.choice).f0.toString();
            }

            Type typeParam = ((Type)firstArgument.get(0));
            if(typeParam.f1.present() && typeParam.f1.nodes.get(0) instanceof NodeSequence) param += "[]";

            param += " " + firstArgument.get(1).toString();
            requiredParams.add(param);
         }
         if(((NodeListOptional)params.get(1)).present()) {
            for (Node node: ((NodeListOptional)params.get(1)).nodes) {
               Node temp = node;
               Vector<Node> argument = ((NodeSequence)((FormalParameter)((NodeSequence)node).nodes.get(1)).f0.choice).nodes;
               if(!(argument.get(1) instanceof OptionalParameter)) {
                  String param = ((Name)((Type)argument.get(0)).f0.choice).f0.toString();
                  Type typeParam = ((Type)argument.get(0));
                  if(typeParam.f1.present() && typeParam.f1.nodes.get(0) instanceof NodeSequence) param += "[]";
                  param += " " + argument.get(1).toString();
                  requiredParams.add(param);
               } else {
                  String Type;
                  String Name;
                  if(((OptionalParameter) argument.get(1)).f0.f0.choice instanceof PrimitiveType) {
                     int i = 0;
                     Type = ((NodeToken)((PrimitiveType)((OptionalParameter) argument.get(1)).f0.f0.choice).f0.choice).toString();
                     Name = ((OptionalParameter) argument.get(1)).f1.toString();
                  } else {
                     int i = 0;
                     Type = ((Name) ((OptionalParameter) argument.get(1)).f0.f0.choice).f0.toString();
                     Name = ((OptionalParameter) argument.get(1)).f1.toString();
                  }
                  //This is so effing dumb and should not be used, but oh well, no time
                  String outputSave = output;
                  ((OptionalParameter)argument.get(1)).f3.accept(this);
                  String Expression = output.substring(outputSave.length()).trim();
                  output = outputSave;

                  optionalParams.add(new CustomOptionalParam(Type, Name, Expression));
               }
            }
         }

         String finalParams = concatParams(requiredParams);

         for(int i = 0; i < (optionalParams.size()*optionalParams.size() - 1); i++) {
            String bin = Integer.toBinaryString(i);
            bin = String.format("%1$" + 16 + "s", bin).replace(' ', '0');
            //System.out.println(bin);
            List<CustomOptionalParam> optinalParamsString = new ArrayList<CustomOptionalParam>();


            for(int p = 0; p < 16; p++) {
               if(bin.charAt(p) == '1') {
                  optinalParamsString.add(optionalParams.get(15 - p));
               } else {
                  if(16 - p <= optionalParams.size()) {
                     leftOutOptional.add(optionalParams.get(15 - p));
                  }
               }
            }

            if(!isDublicate(optinalParamsString)) {
               paramDublicateChecker.add(optinalParamsString);
               if(n.f0.present() && n.f0.nodes.size() > 1) methodOptional = true;
               n.f0.accept(this);
               if(n.f0.present()) {
                  output += spaces[24];
               }
               n.f1.accept(this);

               String finalestParams = concatParams(requiredParams);



               if(!finalParams.isEmpty() && !optinalParamsString.isEmpty()) finalestParams += ", ";
               finalestParams += concatOptionalParams(optinalParamsString);

               output += " " + n.f2.f0.toString() + "(" + finalestParams + ") ";

               n.f3.accept(this);
               if(n.f3.present()) output += spaces[25];
               n.f4.accept(this);
               //System.out.println(concatOptionalParams(optinalParamsString));
            } else {
               leftOutOptional.clear();
            }
         }
      }
   }

   private boolean isDublicate(List<CustomOptionalParam> params) {
      //System.out.println("Start");
      for(int i = 0; i < paramDublicateChecker.size(); i++) {
         boolean same = true;
         if(paramDublicateChecker.get(i).size() == 0 ||
            paramDublicateChecker.get(i).size() != params.size()) {
            same = false;
         } else {
            for(int p = 0; p < paramDublicateChecker.get(i).size(); p++) {
               //System.out.println(paramDublicateChecker.get(i).get(p).Type + " : " + params.get(p).Type);
               if(!paramDublicateChecker.get(i).get(p).Type.equals(params.get(p).Type)) {
                  same = false;
               }
            }
         }

         if(same) {
            //System.out.println("Same");
            return true;
         }
      }
      //System.out.println("Not Same");
      return false;
   }

   private String concatOptionalParams(List<CustomOptionalParam> params) {
      if(params.size() > 0) {
         String output = params.get(params.size() - 1).toParamString();
         for(int i = (params.size() - 2); i >= 0; i--) {
            output += ", " + params.get(i).toParamString();
         }
         return output;
      }
      return "";
   }
   private String concatOptional(List<CustomOptionalParam> params) {
      if(params.size() > 0) {
         String output = params.get(0).toString();
         for(int i = 1; i < params.size(); i++) {
            output += "\n" + params.get(i).toString();
         }
         return output;
      }
      return "";
   }

   private String concatParams(List<String> params) {
      if(params.size() > 0) {
         String output = params.get(0);
         for (int i = 1; i < params.size(); i++) {
            output += ", " + params.get(i);
         }
         return output;
      }
      return "";
   }
   public void visit(MethodDeclarator n) {
      int i = 0;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   public void visit(LocalVariableDeclaration n) {
      n.f0.accept(this);
      output += " ";
      n.f1.accept(this);
      if(n.f2.present()) output += spaces[18];
      n.f2.accept(this);
   }

   public void visit(VariableInitializer n) {
      output += " ";
      n.f0.accept(this);
   }

   public void visit(VariableDeclarator n) {
      int i = 0;
      n.f0.accept(this);
      if(n.f1.present()) output += spaces[17];
      n.f1.accept(this);

   }

   public void visit(FormalParameters n) {
      int i = 0;
      n.f0.accept(this);
      /*
      if(n.f1.present()) {
         Vector<Node> a = ((NodeSequence)n.f1.node).nodes;
         a.get(0).accept(this);
         output += " ";
         a.get(1).accept(this);
      }*/

   }
/*
   public void visit(FormalParameter n) {
      n.f0.accept(this);
      output += " ";
   }*/



   public void visit(FieldDeclaration n) {
      n.f0.accept(this);
      if(n.f0.present()) output += spaces[16];
      n.f1.accept(this);
      output += spaces[26];
      initCurrentField();
      currentField.name = n.f2.toString();

      output += n.f2.toString();

      if(n.f3.f0.choice instanceof NodeSequence) {
         String next = ((NodeSequence)n.f3.f0.choice).nodes.get(0).toString();
         if(!next.equals("{")) {
            output += spaces[15];
         }
      } else if (!n.f3.f0.choice.toString().equals(";")) {
         output += spaces[14];
      }

      n.f3.accept(this);
      if(!output.endsWith("}")) {
         output += ";";
      }
      output += "\n";
   }

   public void visit(Name n) {
      initCurrentField();
      currentField.type = n.f0.toString();
      output += n.f0.toString();
      if(n.f1.present() && ((n.f1.nodes.get(0) instanceof NodeSequence && ((NodeSequence) n.f1.nodes.get(0)).nodes.get(0) instanceof NodeToken) && ((NodeSequence) n.f1.nodes.get(0)).nodes.get(0).toString() != ".")) output += spaces[27];
      n.f1.accept(this);
   }

   public void visit(Type n) {
      initCurrentField();
      if(n.f0.choice instanceof PrimitiveType) {
         currentField.type = ((PrimitiveType)n.f0.choice).f0.choice.toString();
      }
      n.f0.accept(this);
      n.f1.accept(this);
   }

   public void visit(field_modifier n) {
      initCurrentField();
      currentField.defaultAccess = n.f0.choice.toString();
      output += n.f0.choice;
   }

   private void initCurrentField() {
      if(currentField == null) currentField = new FieldDecoration();
   }

   public void visit(accessor_declarations n) {
      output += ";\n";
      checkemptyCurrentField();
      Vector<Node> nodes = ((NodeSequence)n.f0.choice).nodes;
      for (Node node: nodes) {
         if(node instanceof NodeOptional && ((NodeOptional)node).node != null) {
            ((NodeOptional)node).node.accept(this);
         } else {
            node.accept(this);
         }
      }
      currentField = null;
   }

   private void checkemptyCurrentField() {
      if(currentField == null) {
         throw new Error("CurrentField Null");
      } else if(currentField.name == null) {
         throw new Error("CurrentField.name Null");
      } else if(currentField.type == null) {
         throw new Error("CurrentField.type Null");
      }
   }
   public void visit(accessor_get_declaration n) {
      String access = currentField.defaultAccess;
      if(n.f0.node != null) {
         access = ((NodeChoice)n.f0.node).choice.toString();
      }
      output += access +  " " + currentField.type  + " get" + capitalizeFirstLetter(currentField.name) + "() { return this." + currentField.name + "; }";
   }

   public void visit(NodeSequence n) {
      for (Node node: n.nodes) {
         node.accept(this);
      }
   }

   public void visit(accessor_set_declaration n) {
      String access = currentField.defaultAccess;
      if(n.f0.node != null) {
         access = ((NodeChoice)n.f0.node).choice.toString();
      }
      output += access + " void set" + capitalizeFirstLetter(currentField.name) + "(" + currentField.type + " input) { this." + currentField.name + " = input; }";
   }

   public void visit(NodeChoice n) {
      n.choice.accept(this);
   }

   public void visit(Literal n) {
      if(!output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(") && !output.endsWith("[")) output += spaces[13];
      n.f0.accept(this);
   }

   public void visit(NodeToken n) {
      String nString = n.toString();

      if(nString.equals("-") && !output.endsWith(" ")) {
         unary = true;
      }
      if(nString.equals("+") && !output.endsWith(" ")) {
         output += " " + nString;
      } else if(nString.equals(",") || nString.equals("throws") || nString.equals("new")) {
         output += nString + spaces[12];
      } else if ((!nString.equals("{") && !nString.equals("}") && !nString.equals(";"))) {
         output += nString;
      }
   }

   public void visit(ConditionalOrExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[11];
      n.f1.accept(this);
   }

   public void visit(ConditionalExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[10];
      n.f1.accept(this);
   }

   public void visit(ConditionalAndExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[9];
      n.f1.accept(this);
   }

   public void visit(InclusiveOrExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[8];
      n.f1.accept(this);
   }
   public void visit(ExclusiveOrExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[7];
      n.f1.accept(this);
   }
   public void visit(AndExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[6];
      n.f1.accept(this);
   }
   public void visit(EqualityExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[5];
      n.f1.accept(this);
   }
   public void visit(InstanceOfExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[4];
      n.f1.accept(this);
   }
   public void visit(RelationalExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[3];
      n.f1.accept(this);
   }
   public void visit(ShiftExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[2];
      n.f1.accept(this);
   }
   public void visit(AdditiveExpression n) {

      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[1];
      n.f1.accept(this);
   }
   public void visit(MultiplicativeExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(")) output += spaces[0];
      n.f1.accept(this);
   }
   public void visit(UnaryExpression n) {
      //System.out.println(output);
      //if(output.endsWith(" ")) output = output.substring(0, output.length() - 1);
      //System.out.println(output);
      n.f0.accept(this);
   }

   public void visit(PrimaryExpression n) {
      n.f0.accept(this);
      if(n.f1.present() && !unary && (output.endsWith("+") || output.endsWith("-") || output.endsWith("*") || output.endsWith("/"))) output += spaces[21];
      n.f1.accept(this);
   }

   public void visit(PrimaryPrefix n) {

      if(!unary && !output.endsWith(" ") && !output.endsWith("\n") && !output.endsWith("(") && !output.endsWith("[")) output += spaces[19];
      unary = false;
      n.f0.accept(this);
   }

   public void visit(PrimarySuffix n) {
      //if(output.endsWith("+") || output.endsWith("-") || output.endsWith("*") || output.endsWith("/")) output += spaces[20];
      n.f0.choice.accept(this);
   }

   public void visit(field_body n) {
      n.f0.choice.accept(this);
   }

   public void visit(Expression n) {
      n.f0.choice.accept(this);
   }

   public void visit(ConstructorDeclaration n) {
      int h = 0;
      /*
      n.f0.accept(this);
      if(n.f0.present() && !output.endsWith(" ")) output += spaces[23];
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      if(n.f4.toString().equals("{") && !output.equals(" ")) output += " ";
      if(n.f4.toString().equals("{")) output += "{\n";
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      if(n.f7.toString().equals("}")) output += "}\n";*/


         if (n.f2.f1.node instanceof NodeSequence) {
            Vector<Node> params = ((NodeSequence) n.f2.f1.node).nodes;
            if (params.get(0) instanceof FormalParameter && ((FormalParameter) params.get(0)).f0.choice instanceof NodeSequence) {
               Vector<Node> firstArgument = ((NodeSequence) ((FormalParameter) params.get(0)).f0.choice).nodes;

               String param;

               if(((Type)firstArgument.get(0)).f0.choice instanceof PrimitiveType) {
                  param = ((NodeToken)((PrimitiveType)((Type)firstArgument.get(0)).f0.choice).f0.choice).toString();
               } else {
                  param = ((Name)((Type)firstArgument.get(0)).f0.choice).f0.toString();
               }

               Type typeParam = ((Type)firstArgument.get(0));
               if(typeParam.f1.present() && typeParam.f1.nodes.get(0) instanceof NodeSequence) param += "[]";

               param += " " + firstArgument.get(1).toString();
               requiredParams.add(param);
            }
            if (((NodeListOptional) params.get(1)).present()) {
               for (Node node : ((NodeListOptional) params.get(1)).nodes) {
                  Node temp = node;
                  Vector<Node> argument = ((NodeSequence) ((FormalParameter) ((NodeSequence) node).nodes.get(1)).f0.choice).nodes;
                  if (!(argument.get(1) instanceof OptionalParameter)) {
                     String param = ((Name) ((Type) argument.get(0)).f0.choice).f0.toString();
                     param += " " + argument.get(1).toString();
                     requiredParams.add(param);
                  } else {
                     String Type;
                     String Name;
                     if (((OptionalParameter) argument.get(1)).f0.f0.choice instanceof PrimitiveType) {
                        int i = 0;
                        Type = ((NodeToken) ((PrimitiveType) ((OptionalParameter) argument.get(1)).f0.f0.choice).f0.choice).toString();
                        Name = ((OptionalParameter) argument.get(1)).f1.toString();
                     } else {
                        int i = 0;
                        Type = ((Name) ((OptionalParameter) argument.get(1)).f0.f0.choice).f0.toString();
                        Name = ((OptionalParameter) argument.get(1)).f1.toString();
                     }
                     //This is so effing dumb and should not be used, but oh well, no time
                     String outputSave = output;
                     ((OptionalParameter) argument.get(1)).f3.accept(this);
                     String Expression = output.substring(outputSave.length()).trim();
                     output = outputSave;

                     optionalParams.add(new CustomOptionalParam(Type, Name, Expression));
                  }
               }
            }

            String finalParams = concatParams(requiredParams);

            for (int i = 0; i < (optionalParams.size() * optionalParams.size() - 1); i++) {
               String bin = Integer.toBinaryString(i);
               bin = String.format("%1$" + 16 + "s", bin).replace(' ', '0');
               //System.out.println(bin);
               List<CustomOptionalParam> optinalParamsString = new ArrayList<CustomOptionalParam>();


               for (int p = 0; p < 16; p++) {
                  if (bin.charAt(p) == '1') {
                     optinalParamsString.add(optionalParams.get(15 - p));
                  } else {
                     if (16 - p <= optionalParams.size()) {
                        leftOutOptional.add(optionalParams.get(15 - p));
                     }
                  }
               }

               if (!isDublicate(optinalParamsString)) {
                  paramDublicateChecker.add(optinalParamsString);
                  //if (n.f0.present() && n.f0.nodes.size() > 1) methodOptional = true;
                  n.f0.accept(this);
                  if (n.f0.present()) {
                     output += spaces[24];
                  }
                  n.f1.accept(this);

                  String finalestParams = concatParams(requiredParams);


                  if (!finalParams.isEmpty() && !optinalParamsString.isEmpty()) finalestParams += ", ";
                  finalestParams += concatOptionalParams(optinalParamsString);

                  output += " " + "(" + finalestParams + ") ";

                  n.f3.accept(this);
                  if (n.f3.present()) output += spaces[25];

                  n.f5.accept(this);


                  output += " {\n";
                  addOptional();
                  n.f6.accept(this);
                  output += "}\n";

               } else {
                  leftOutOptional.clear();
               }
            }
         }
   }

   public void writeOutputToFile() throws IOException {
      Files.createDirectories(Paths.get("outputs"));
      Files.write(Paths.get("outputs/" + fileName), output.getBytes());
      if (order == 0) {
         try {

            ProcessBuilder builder = new ProcessBuilder(
                    "javac", "outputs/" + firstClassName + ".java");
            builder.redirectErrorStream(true);
            Process p = builder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder Sbuilder = new StringBuilder();
            String line = null;
            while ( (line = reader.readLine()) != null) {
               Sbuilder.append(line);
               Sbuilder.append(System.getProperty("line.separator"));
            }
            String result = Sbuilder.toString();
            System.out.println(result);


         } catch (Exception e) {
            System.out.println("There were errors in the Java code and Javac could not compile it. Error:");
            System.out.println(e.toString());
         }

      } else {
         order--;
      }
   }

}
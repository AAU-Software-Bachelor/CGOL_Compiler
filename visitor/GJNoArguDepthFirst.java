//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJNoArguDepthFirst<R> implements GJNoArguVisitor<R> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return null;
   }

   public R visit(NodeSequence n) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( TypeDeclaration() )*
    * f1 -> <EOF>
    */
   public R visit(CompilationUnit n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ";"
    */
   public R visit(TypeDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "abstract" | "final" | "public" )*
    * f1 -> "class"
    * f2 -> <IDENTIFIER>
    * f3 -> [ "extends" Name() ]
    * f4 -> [ "implements" NameList() ]
    * f5 -> "{"
    * f6 -> ( ClassBodyDeclaration() )*
    * f7 -> "}"
    */
   public R visit(ClassDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      return _ret;
   }

   /**
    * f0 -> FieldDeclaration()
    */
   public R visit(ClassBodyDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( field_modifier() )*
    * f1 -> Type()
    * f2 -> <IDENTIFIER>
    * f3 -> field_body()
    */
   public R visit(FieldDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> "new"
    *       | "public"
    *       | "protected"
    *       | "private"
    *       | "static"
    *       | "abstract"
    */
   public R visit(field_modifier n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "=" Expression() ( "{" accessor_declarations() "}" | ";" ) | "{" accessor_declarations() "}" | ";" )
    */
   public R visit(field_body n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( accessor_get_declaration() ( accessor_set_declaration() )? | accessor_set_declaration() ( accessor_get_declaration() )? )
    */
   public R visit(accessor_declarations n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <GET>
    * f2 -> ";"
    */
   public R visit(accessor_get_declaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <SET>
    * f2 -> ";"
    */
   public R visit(accessor_set_declaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> VariableDeclaratorId()
    * f1 -> [ "=" VariableInitializer() ]
    */
   public R visit(VariableDeclarator n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "[" "]" )*
    */
   public R visit(VariableDeclaratorId n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{" [ VariableInitializer() ( "," VariableInitializer() )* ] [ "," ] "}"
    *       | Expression()
    */
   public R visit(VariableInitializer n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( PrimitiveType() | Name() )
    * f1 -> ( "[" "]" )*
    */
   public R visit(Type n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "boolean"
    *       | "char"
    *       | "byte"
    *       | "short"
    *       | "int"
    *       | "long"
    *       | "float"
    *       | "double"
    */
   public R visit(PrimitiveType n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "." <IDENTIFIER> )*
    */
   public R visit(Name n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Name()
    * f1 -> ( "," Name() )*
    */
   public R visit(NameList n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
Assignment()
    */
   public R visit(Expression n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> AssignmentOperator()
    * f2 -> Expression()
    */
   public R visit(Assignment n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "="
    *       | "*="
    *       | "/="
    *       | "%="
    *       | "+="
    *       | "-="
    *       | "<<="
    *       | ">>="
    *       | ">>>="
    *       | "&="
    *       | "^="
    *       | "|="
    */
   public R visit(AssignmentOperator n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryPrefix()
    * f1 -> ( PrimarySuffix() )*
    */
   public R visit(PrimaryExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Literal()
    *       | Name()
    *       | "this"
    *       | "super" "." <IDENTIFIER>
    *       | "(" Expression() ")"
    *       | AllocationExpression()
    */
   public R visit(PrimaryPrefix n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "[" Expression() "]"
    *       | "." <IDENTIFIER>
    *       | Arguments()
    */
   public R visit(PrimarySuffix n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <CHARACTER_LITERAL>
    *       | <STRING_LITERAL>
    *       | BooleanLiteral()
    *       | NullLiteral()
    */
   public R visit(Literal n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "true"
    *       | "false"
    */
   public R visit(BooleanLiteral n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "null"
    */
   public R visit(NullLiteral n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "("
    * f1 -> [ ArgumentList() ]
    * f2 -> ")"
    */
   public R visit(Arguments n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Expression()
    * f1 -> ( "," Expression() )*
    */
   public R visit(ArgumentList n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "new" PrimitiveType() ArrayDimensions()
    *       | "new" Name() ( Arguments() | ArrayDimensions() )
    */
   public R visit(AllocationExpression n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "[" Expression() "]" )+
    * f1 -> ( "[" "]" )*
    */
   public R visit(ArrayDimensions n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

}

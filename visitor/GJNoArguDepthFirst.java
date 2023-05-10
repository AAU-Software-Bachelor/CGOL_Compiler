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
    * f0 -> [ PackageDeclaration() ]
    * f1 -> ( ImportDeclaration() )*
    * f2 -> ( TypeDeclaration() )*
    * f3 -> <EOF>
    */
   public R visit(CompilationUnit n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> "package"
    * f1 -> Name()
    * f2 -> ";"
    */
   public R visit(PackageDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "import"
    * f1 -> Name()
    * f2 -> [ "." "*" ]
    * f3 -> ";"
    */
   public R visit(ImportDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | InterfaceDeclaration()
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
    * f0 -> StaticInitializer()
    *       | ConstructorDeclaration()
    *       | MethodDeclaration()
    *       | FieldDeclaration()
    */
   public R visit(ClassBodyDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> <IDENTIFIER>
    * f3 -> "("
    */
   public R visit(MethodDeclarationLookahead n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "abstract" | "public" )*
    * f1 -> "interface"
    * f2 -> <IDENTIFIER>
    * f3 -> [ "extends" NameList() ]
    * f4 -> "{"
    * f5 -> ( InterfaceMemberDeclaration() )*
    * f6 -> "}"
    */
   public R visit(InterfaceDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> MethodDeclaration()
    *       | FieldDeclaration()
    */
   public R visit(InterfaceMemberDeclaration n) {
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
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> MethodDeclarator()
    * f3 -> [ "throws" NameList() ]
    * f4 -> ( Block() | ";" )
    */
   public R visit(MethodDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> FormalParameters()
    * f2 -> ( "[" "]" )*
    */
   public R visit(MethodDeclarator n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "("
    * f1 -> [ FormalParameter() ( "," FormalParameter() )* ]
    * f2 -> ")"
    */
   public R visit(FormalParameters n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> VariableDeclaratorId()
    */
   public R visit(FormalParameter n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> [ "public" | "protected" | "private" ]
    * f1 -> <IDENTIFIER>
    * f2 -> FormalParameters()
    * f3 -> [ "throws" NameList() ]
    * f4 -> "{"
    * f5 -> [ ExplicitConstructorInvocation() ]
    * f6 -> ( BlockStatement() )*
    * f7 -> "}"
    */
   public R visit(ConstructorDeclaration n) {
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
    * f0 -> "this" Arguments() ";"
    *       | "super" Arguments() ";"
    */
   public R visit(ExplicitConstructorInvocation n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "static"
    * f1 -> Block()
    */
   public R visit(StaticInitializer n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
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
    * f0 -> "void"
    *       | Type()
    */
   public R visit(ResultType n) {
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
    * f0 -> Assignment()
    *       | ConditionalExpression()
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
    * f0 -> ConditionalOrExpression()
    * f1 -> [ "?" Expression() ":" ConditionalExpression() ]
    */
   public R visit(ConditionalExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ConditionalAndExpression()
    * f1 -> ( "||" ConditionalAndExpression() )*
    */
   public R visit(ConditionalOrExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> InclusiveOrExpression()
    * f1 -> ( "&&" InclusiveOrExpression() )*
    */
   public R visit(ConditionalAndExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ExclusiveOrExpression()
    * f1 -> ( "|" ExclusiveOrExpression() )*
    */
   public R visit(InclusiveOrExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> AndExpression()
    * f1 -> ( "^" AndExpression() )*
    */
   public R visit(ExclusiveOrExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> EqualityExpression()
    * f1 -> ( "&" EqualityExpression() )*
    */
   public R visit(AndExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> InstanceOfExpression()
    * f1 -> ( ( "==" | "!=" ) InstanceOfExpression() )*
    */
   public R visit(EqualityExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> RelationalExpression()
    * f1 -> [ "instanceof" Type() ]
    */
   public R visit(InstanceOfExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ShiftExpression()
    * f1 -> ( ( "<" | ">" | "<=" | ">=" ) ShiftExpression() )*
    */
   public R visit(RelationalExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> AdditiveExpression()
    * f1 -> ( ( "<<" | ">>" | ">>>" ) AdditiveExpression() )*
    */
   public R visit(ShiftExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> ( ( "+" | "-" ) MultiplicativeExpression() )*
    */
   public R visit(AdditiveExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> UnaryExpression()
    * f1 -> ( ( "*" | "/" | "%" ) UnaryExpression() )*
    */
   public R visit(MultiplicativeExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "+" | "-" ) UnaryExpression()
    *       | PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | UnaryExpressionNotPlusMinus()
    */
   public R visit(UnaryExpression n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "++"
    * f1 -> PrimaryExpression()
    */
   public R visit(PreIncrementExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "--"
    * f1 -> PrimaryExpression()
    */
   public R visit(PreDecrementExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "~" | "!" ) UnaryExpression()
    *       | CastExpression()
    *       | PostfixExpression()
    */
   public R visit(UnaryExpressionNotPlusMinus n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "(" PrimitiveType()
    *       | "(" Name() "[" "]"
    *       | "(" Name() ")" ( "~" | "!" | "(" | <IDENTIFIER> | "this" | "super" | "new" | Literal() )
    */
   public R visit(CastLookahead n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> [ "++" | "--" ]
    */
   public R visit(PostfixExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "(" PrimitiveType() ( "[" "]" )* ")" UnaryExpression()
    *       | "(" Name() ( "[" "]" )* ")" UnaryExpressionNotPlusMinus()
    */
   public R visit(CastExpression n) {
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

   /**
    * f0 -> LabeledStatement()
    *       | Block()
    *       | EmptyStatement()
    *       | StatementExpression() ";"
    *       | SwitchStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | DoStatement()
    *       | ForStatement()
    *       | BreakStatement()
    *       | ContinueStatement()
    *       | ReturnStatement()
    *       | ThrowStatement()
    *       | SynchronizedStatement()
    *       | TryStatement()
    */
   public R visit(Statement n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ":"
    * f2 -> Statement()
    */
   public R visit(LabeledStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( BlockStatement() )*
    * f2 -> "}"
    */
   public R visit(Block n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> LocalVariableDeclaration() ";"
    *       | Statement()
    */
   public R visit(BlockStatement n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> VariableDeclarator()
    * f2 -> ( "," VariableDeclarator() )*
    */
   public R visit(LocalVariableDeclaration n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> ";"
    */
   public R visit(EmptyStatement n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | Assignment()
    *       | PostfixExpression()
    */
   public R visit(StatementExpression n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "switch"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( SwitchLabel() ( BlockStatement() )* )*
    * f6 -> "}"
    */
   public R visit(SwitchStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> "case" Expression() ":"
    *       | "default" ":"
    */
   public R visit(SwitchLabel n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> [ "else" Statement() ]
    */
   public R visit(IfStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(WhileStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> "do"
    * f1 -> Statement()
    * f2 -> "while"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public R visit(DoStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> "for"
    * f1 -> "("
    * f2 -> [ ForInit() ]
    * f3 -> ";"
    * f4 -> [ Expression() ]
    * f5 -> ";"
    * f6 -> [ ForUpdate() ]
    * f7 -> ")"
    * f8 -> Statement()
    */
   public R visit(ForStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      return _ret;
   }

   /**
    * f0 -> LocalVariableDeclaration()
    *       | StatementExpressionList()
    */
   public R visit(ForInit n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> StatementExpression()
    * f1 -> ( "," StatementExpression() )*
    */
   public R visit(StatementExpressionList n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> StatementExpressionList()
    */
   public R visit(ForUpdate n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "break"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public R visit(BreakStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "continue"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public R visit(ContinueStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "return"
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public R visit(ReturnStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "throw"
    * f1 -> Expression()
    * f2 -> ";"
    */
   public R visit(ThrowStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "synchronized"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Block()
    */
   public R visit(SynchronizedStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> "try"
    * f1 -> Block()
    * f2 -> ( "catch" "(" FormalParameter() ")" Block() )*
    * f3 -> [ "finally" Block() ]
    */
   public R visit(TryStatement n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

}

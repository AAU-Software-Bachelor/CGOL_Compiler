//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> [ PackageDeclaration() ]
    * f1 -> ( ImportDeclaration() )*
    * f2 -> ( TypeDeclaration() )*
    * f3 -> <EOF>
    */
   public R visit(CompilationUnit n, A argu);

   /**
    * f0 -> "package"
    * f1 -> Name()
    * f2 -> ";"
    */
   public R visit(PackageDeclaration n, A argu);

   /**
    * f0 -> "import"
    * f1 -> Name()
    * f2 -> [ "." "*" ]
    * f3 -> ";"
    */
   public R visit(ImportDeclaration n, A argu);

   /**
    * f0 -> ClassDeclaration()
    *       | InterfaceDeclaration()
    *       | ";"
    */
   public R visit(TypeDeclaration n, A argu);

   /**
    * f0 -> ( "abstract" | "final" | "public" )*
    * f1 -> "class"
    * f2 -> <IDENTIFIER>
    * f3 -> [ "extends" Name() ]
    * f4 -> [ "implements" NameList() ]
    * f5 -> "{"
    * f6 -> ( ClassBodyDeclaration() )+
    * f7 -> "}"
    */
   public R visit(ClassDeclaration n, A argu);

   /**
    * f0 -> StaticInitializer()
    *       | ConstructorDeclaration()
    *       | MethodDeclaration()
    *       | FieldDeclaration()
    *       | EmptyStatement()
    */
   public R visit(ClassBodyDeclaration n, A argu);

   /**
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> <IDENTIFIER>
    * f3 -> "("
    */
   public R visit(MethodDeclarationLookahead n, A argu);

   /**
    * f0 -> ( "abstract" | "public" )*
    * f1 -> "interface"
    * f2 -> <IDENTIFIER>
    * f3 -> [ "extends" NameList() ]
    * f4 -> "{"
    * f5 -> ( InterfaceMemberDeclaration() )*
    * f6 -> "}"
    */
   public R visit(InterfaceDeclaration n, A argu);

   /**
    * f0 -> MethodDeclaration()
    *       | FieldDeclaration()
    */
   public R visit(InterfaceMemberDeclaration n, A argu);

   /**
    * f0 -> ( field_modifier() )*
    * f1 -> Type()
    * f2 -> <IDENTIFIER>
    * f3 -> field_body()
    */
   public R visit(FieldDeclaration n, A argu);

   /**
    * f0 -> "new"
    *       | "public"
    *       | "protected"
    *       | "private"
    *       | "static"
    *       | "abstract"
    */
   public R visit(field_modifier n, A argu);

   /**
    * f0 -> "=" Expression() ( "{" accessor_declarations() "}" | ";" )
    *       | "{" accessor_declarations() "}"
    *       | ";"
    */
   public R visit(field_body n, A argu);

   /**
    * f0 -> accessor_get_declaration() ( accessor_set_declaration() )?
    *       | accessor_set_declaration() ( accessor_get_declaration() )?
    */
   public R visit(accessor_declarations n, A argu);

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <GET>
    * f2 -> ";"
    */
   public R visit(accessor_get_declaration n, A argu);

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <SET>
    * f2 -> ";"
    */
   public R visit(accessor_set_declaration n, A argu);

   /**
    * f0 -> VariableDeclaratorId()
    * f1 -> [ "=" VariableInitializer() ]
    */
   public R visit(VariableDeclarator n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "[" "]" )*
    */
   public R visit(VariableDeclaratorId n, A argu);

   /**
    * f0 -> "{" [ VariableInitializer() ( "," VariableInitializer() )* ] [ "," ] "}"
    *       | Expression()
    */
   public R visit(VariableInitializer n, A argu);

   /**
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> MethodDeclarator()
    * f3 -> [ "throws" NameList() ]
    * f4 -> ( Block() | ";" )
    */
   public R visit(MethodDeclaration n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> FormalParameters()
    * f2 -> ( "[" "]" )*
    */
   public R visit(MethodDeclarator n, A argu);

   /**
    * f0 -> "("
    * f1 -> [ FormalParameter() ( "," FormalParameter() )* ]
    * f2 -> ")"
    */
   public R visit(FormalParameters n, A argu);

   /**
    * f0 -> Type() <IDENTIFIER>
    *       | "?" OptionalParameter()
    */
   public R visit(FormalParameter n, A argu);

   /**
    * f0 -> Type()
    * f1 -> <IDENTIFIER>
    */
   public R visit(RequiredParameter n, A argu);

   /**
    * f0 -> Type()
    * f1 -> <IDENTIFIER>
    * f2 -> "="
    * f3 -> Expression()
    */
   public R visit(OptionalParameter n, A argu);

   /**
    * f0 -> Literal()
    */
   public R visit(DefaultValue n, A argu);

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
   public R visit(ConstructorDeclaration n, A argu);

   /**
    * f0 -> "this" Arguments() ";"
    *       | "super" Arguments() ";"
    */
   public R visit(ExplicitConstructorInvocation n, A argu);

   /**
    * f0 -> "static"
    * f1 -> Block()
    */
   public R visit(StaticInitializer n, A argu);

   /**
    * f0 -> ( PrimitiveType() | Name() )
    * f1 -> ( "[" "]" )*
    */
   public R visit(Type n, A argu);

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
   public R visit(PrimitiveType n, A argu);

   /**
    * f0 -> "void"
    *       | Type()
    */
   public R visit(ResultType n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "." <IDENTIFIER> )*
    */
   public R visit(Name n, A argu);

   /**
    * f0 -> Name()
    * f1 -> ( "," Name() )*
    */
   public R visit(NameList n, A argu);

   /**
    * f0 -> Assignment()
    *       | ConditionalExpression()
    */
   public R visit(Expression n, A argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> AssignmentOperator()
    * f2 -> Expression()
    */
   public R visit(Assignment n, A argu);

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
   public R visit(AssignmentOperator n, A argu);

   /**
    * f0 -> ConditionalOrExpression()
    * f1 -> [ "?" Expression() ":" ConditionalExpression() ]
    */
   public R visit(ConditionalExpression n, A argu);

   /**
    * f0 -> ConditionalAndExpression()
    * f1 -> ( "||" ConditionalAndExpression() )*
    */
   public R visit(ConditionalOrExpression n, A argu);

   /**
    * f0 -> InclusiveOrExpression()
    * f1 -> ( "&&" InclusiveOrExpression() )*
    */
   public R visit(ConditionalAndExpression n, A argu);

   /**
    * f0 -> ExclusiveOrExpression()
    * f1 -> ( "|" ExclusiveOrExpression() )*
    */
   public R visit(InclusiveOrExpression n, A argu);

   /**
    * f0 -> AndExpression()
    * f1 -> ( "^" AndExpression() )*
    */
   public R visit(ExclusiveOrExpression n, A argu);

   /**
    * f0 -> EqualityExpression()
    * f1 -> ( "&" EqualityExpression() )*
    */
   public R visit(AndExpression n, A argu);

   /**
    * f0 -> InstanceOfExpression()
    * f1 -> ( ( "==" | "!=" ) InstanceOfExpression() )*
    */
   public R visit(EqualityExpression n, A argu);

   /**
    * f0 -> RelationalExpression()
    * f1 -> [ "instanceof" Type() ]
    */
   public R visit(InstanceOfExpression n, A argu);

   /**
    * f0 -> ShiftExpression()
    * f1 -> ( ( "<" | ">" | "<=" | ">=" ) ShiftExpression() )*
    */
   public R visit(RelationalExpression n, A argu);

   /**
    * f0 -> AdditiveExpression()
    * f1 -> ( ( "<<" | ">>" | ">>>" ) AdditiveExpression() )*
    */
   public R visit(ShiftExpression n, A argu);

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> ( ( "+" | "-" ) MultiplicativeExpression() )*
    */
   public R visit(AdditiveExpression n, A argu);

   /**
    * f0 -> UnaryExpression()
    * f1 -> ( ( "*" | "/" | "%" ) UnaryExpression() )*
    */
   public R visit(MultiplicativeExpression n, A argu);

   /**
    * f0 -> ( "+" | "-" ) UnaryExpression()
    *       | PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | UnaryExpressionNotPlusMinus()
    */
   public R visit(UnaryExpression n, A argu);

   /**
    * f0 -> "++"
    * f1 -> PrimaryExpression()
    */
   public R visit(PreIncrementExpression n, A argu);

   /**
    * f0 -> "--"
    * f1 -> PrimaryExpression()
    */
   public R visit(PreDecrementExpression n, A argu);

   /**
    * f0 -> ( "~" | "!" ) UnaryExpression()
    *       | CastExpression()
    *       | PostfixExpression()
    */
   public R visit(UnaryExpressionNotPlusMinus n, A argu);

   /**
    * f0 -> "(" PrimitiveType()
    *       | "(" Name() "[" "]"
    *       | "(" Name() ")" ( "~" | "!" | "(" | <IDENTIFIER> | "this" | "super" | "new" | Literal() )
    */
   public R visit(CastLookahead n, A argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> [ "++" | "--" ]
    */
   public R visit(PostfixExpression n, A argu);

   /**
    * f0 -> "(" PrimitiveType() ( "[" "]" )* ")" UnaryExpression()
    *       | "(" Name() ( "[" "]" )* ")" UnaryExpressionNotPlusMinus()
    */
   public R visit(CastExpression n, A argu);

   /**
    * f0 -> PrimaryPrefix()
    * f1 -> ( PrimarySuffix() )*
    */
   public R visit(PrimaryExpression n, A argu);

   /**
    * f0 -> Literal()
    *       | Name()
    *       | "this"
    *       | "super" "." <IDENTIFIER>
    *       | "(" Expression() ")"
    *       | AllocationExpression()
    */
   public R visit(PrimaryPrefix n, A argu);

   /**
    * f0 -> "[" Expression() "]"
    *       | "." <IDENTIFIER>
    *       | Arguments()
    */
   public R visit(PrimarySuffix n, A argu);

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <CHARACTER_LITERAL>
    *       | <STRING_LITERAL>
    *       | BooleanLiteral()
    *       | NullLiteral()
    */
   public R visit(Literal n, A argu);

   /**
    * f0 -> "true"
    *       | "false"
    */
   public R visit(BooleanLiteral n, A argu);

   /**
    * f0 -> "null"
    */
   public R visit(NullLiteral n, A argu);

   /**
    * f0 -> "("
    * f1 -> [ ArgumentList() ]
    * f2 -> ")"
    */
   public R visit(Arguments n, A argu);

   /**
    * f0 -> Expression()
    * f1 -> ( "," Expression() )*
    */
   public R visit(ArgumentList n, A argu);

   /**
    * f0 -> "new" PrimitiveType() ArrayDimensions()
    *       | "new" Name() ( Arguments() | ArrayDimensions() )
    */
   public R visit(AllocationExpression n, A argu);

   /**
    * f0 -> ( "[" Expression() "]" )+
    * f1 -> ( "[" "]" )*
    */
   public R visit(ArrayDimensions n, A argu);

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
   public R visit(Statement n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ":"
    * f2 -> Statement()
    */
   public R visit(LabeledStatement n, A argu);

   /**
    * f0 -> "{"
    * f1 -> ( BlockStatement() )*
    * f2 -> "}"
    */
   public R visit(Block n, A argu);

   /**
    * f0 -> LocalVariableDeclaration() ";"
    *       | Statement()
    */
   public R visit(BlockStatement n, A argu);

   /**
    * f0 -> Type()
    * f1 -> VariableDeclarator()
    * f2 -> ( "," VariableDeclarator() )*
    */
   public R visit(LocalVariableDeclaration n, A argu);

   /**
    * f0 -> ";"
    */
   public R visit(EmptyStatement n, A argu);

   /**
    * f0 -> PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | Assignment()
    *       | PostfixExpression()
    */
   public R visit(StatementExpression n, A argu);

   /**
    * f0 -> "switch"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( SwitchLabel() ( BlockStatement() )* )*
    * f6 -> "}"
    */
   public R visit(SwitchStatement n, A argu);

   /**
    * f0 -> "case" Expression() ":"
    *       | "default" ":"
    */
   public R visit(SwitchLabel n, A argu);

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> [ "else" Statement() ]
    */
   public R visit(IfStatement n, A argu);

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(WhileStatement n, A argu);

   /**
    * f0 -> "do"
    * f1 -> Statement()
    * f2 -> "while"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public R visit(DoStatement n, A argu);

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
   public R visit(ForStatement n, A argu);

   /**
    * f0 -> LocalVariableDeclaration()
    *       | StatementExpressionList()
    */
   public R visit(ForInit n, A argu);

   /**
    * f0 -> StatementExpression()
    * f1 -> ( "," StatementExpression() )*
    */
   public R visit(StatementExpressionList n, A argu);

   /**
    * f0 -> StatementExpressionList()
    */
   public R visit(ForUpdate n, A argu);

   /**
    * f0 -> "break"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public R visit(BreakStatement n, A argu);

   /**
    * f0 -> "continue"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public R visit(ContinueStatement n, A argu);

   /**
    * f0 -> "return"
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public R visit(ReturnStatement n, A argu);

   /**
    * f0 -> "throw"
    * f1 -> Expression()
    * f2 -> ";"
    */
   public R visit(ThrowStatement n, A argu);

   /**
    * f0 -> "synchronized"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Block()
    */
   public R visit(SynchronizedStatement n, A argu);

   /**
    * f0 -> "try"
    * f1 -> Block()
    * f2 -> ( "catch" "(" RequiredParameter() ")" Block() )*
    * f3 -> [ "finally" Block() ]
    */
   public R visit(TryStatement n, A argu);

}

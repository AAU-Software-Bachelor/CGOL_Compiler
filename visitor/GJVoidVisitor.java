//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ void visitors must implement this interface.
 */

public interface GJVoidVisitor<A> {

   //
   // GJ void Auto class visitors
   //

   public void visit(NodeList n, A argu);
   public void visit(NodeListOptional n, A argu);
   public void visit(NodeOptional n, A argu);
   public void visit(NodeSequence n, A argu);
   public void visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> [ PackageDeclaration() ]
    * f1 -> ( ImportDeclaration() )*
    * f2 -> ( TypeDeclaration() )*
    * f3 -> <EOF>
    */
   public void visit(CompilationUnit n, A argu);

   /**
    * f0 -> "package"
    * f1 -> Name()
    * f2 -> ";"
    */
   public void visit(PackageDeclaration n, A argu);

   /**
    * f0 -> "import"
    * f1 -> Name()
    * f2 -> [ "." "*" ]
    * f3 -> ";"
    */
   public void visit(ImportDeclaration n, A argu);

   /**
    * f0 -> ClassDeclaration()
    *       | InterfaceDeclaration()
    *       | ";"
    */
   public void visit(TypeDeclaration n, A argu);

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
   public void visit(ClassDeclaration n, A argu);

   /**
    * f0 -> StaticInitializer()
    *       | ConstructorDeclaration()
    *       | MethodDeclaration()
    *       | FieldDeclaration()
    *       | EmptyStatement()
    */
   public void visit(ClassBodyDeclaration n, A argu);

   /**
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> <IDENTIFIER>
    * f3 -> "("
    */
   public void visit(MethodDeclarationLookahead n, A argu);

   /**
    * f0 -> ( "abstract" | "public" )*
    * f1 -> "interface"
    * f2 -> <IDENTIFIER>
    * f3 -> [ "extends" NameList() ]
    * f4 -> "{"
    * f5 -> ( InterfaceMemberDeclaration() )*
    * f6 -> "}"
    */
   public void visit(InterfaceDeclaration n, A argu);

   /**
    * f0 -> MethodDeclaration()
    *       | FieldDeclaration()
    */
   public void visit(InterfaceMemberDeclaration n, A argu);

   /**
    * f0 -> ( field_modifier() )*
    * f1 -> Type()
    * f2 -> <IDENTIFIER>
    * f3 -> field_body()
    */
   public void visit(FieldDeclaration n, A argu);

   /**
    * f0 -> "new"
    *       | "public"
    *       | "protected"
    *       | "private"
    *       | "static"
    *       | "abstract"
    */
   public void visit(field_modifier n, A argu);

   /**
    * f0 -> "=" Expression() ( "{" accessor_declarations() "}" | ";" )
    *       | "{" accessor_declarations() "}"
    *       | ";"
    */
   public void visit(field_body n, A argu);

   /**
    * f0 -> accessor_get_declaration() ( accessor_set_declaration() )?
    *       | accessor_set_declaration() ( accessor_get_declaration() )?
    */
   public void visit(accessor_declarations n, A argu);

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <GET>
    * f2 -> ";"
    */
   public void visit(accessor_get_declaration n, A argu);

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <SET>
    * f2 -> ";"
    */
   public void visit(accessor_set_declaration n, A argu);

   /**
    * f0 -> VariableDeclaratorId()
    * f1 -> [ "=" VariableInitializer() ]
    */
   public void visit(VariableDeclarator n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "[" "]" )*
    */
   public void visit(VariableDeclaratorId n, A argu);

   /**
    * f0 -> "{" [ VariableInitializer() ( "," VariableInitializer() )* ] [ "," ] "}"
    *       | Expression()
    */
   public void visit(VariableInitializer n, A argu);

   /**
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> MethodDeclarator()
    * f3 -> [ "throws" NameList() ]
    * f4 -> ( Block() | ";" )
    */
   public void visit(MethodDeclaration n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> FormalParameters()
    * f2 -> ( "[" "]" )*
    */
   public void visit(MethodDeclarator n, A argu);

   /**
    * f0 -> "("
    * f1 -> [ FormalParameter() ( "," FormalParameter() )* ]
    * f2 -> ")"
    */
   public void visit(FormalParameters n, A argu);

   /**
    * f0 -> Type() <IDENTIFIER>
    *       | "?" OptionalParameter()
    */
   public void visit(FormalParameter n, A argu);

   /**
    * f0 -> Type()
    * f1 -> <IDENTIFIER>
    */
   public void visit(RequiredParameter n, A argu);

   /**
    * f0 -> Type()
    * f1 -> <IDENTIFIER>
    * f2 -> "="
    * f3 -> Expression()
    */
   public void visit(OptionalParameter n, A argu);

   /**
    * f0 -> Literal()
    */
   public void visit(DefaultValue n, A argu);

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
   public void visit(ConstructorDeclaration n, A argu);

   /**
    * f0 -> "this" Arguments() ";"
    *       | "super" Arguments() ";"
    */
   public void visit(ExplicitConstructorInvocation n, A argu);

   /**
    * f0 -> "static"
    * f1 -> Block()
    */
   public void visit(StaticInitializer n, A argu);

   /**
    * f0 -> ( PrimitiveType() | Name() )
    * f1 -> ( "[" "]" )*
    */
   public void visit(Type n, A argu);

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
   public void visit(PrimitiveType n, A argu);

   /**
    * f0 -> "void"
    *       | Type()
    */
   public void visit(ResultType n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "." <IDENTIFIER> )*
    */
   public void visit(Name n, A argu);

   /**
    * f0 -> Name()
    * f1 -> ( "," Name() )*
    */
   public void visit(NameList n, A argu);

   /**
    * f0 -> Assignment()
    *       | ConditionalExpression()
    */
   public void visit(Expression n, A argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> AssignmentOperator()
    * f2 -> Expression()
    */
   public void visit(Assignment n, A argu);

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
   public void visit(AssignmentOperator n, A argu);

   /**
    * f0 -> ConditionalOrExpression()
    * f1 -> [ "?" Expression() ":" ConditionalExpression() ]
    */
   public void visit(ConditionalExpression n, A argu);

   /**
    * f0 -> ConditionalAndExpression()
    * f1 -> ( "||" ConditionalAndExpression() )*
    */
   public void visit(ConditionalOrExpression n, A argu);

   /**
    * f0 -> InclusiveOrExpression()
    * f1 -> ( "&&" InclusiveOrExpression() )*
    */
   public void visit(ConditionalAndExpression n, A argu);

   /**
    * f0 -> ExclusiveOrExpression()
    * f1 -> ( "|" ExclusiveOrExpression() )*
    */
   public void visit(InclusiveOrExpression n, A argu);

   /**
    * f0 -> AndExpression()
    * f1 -> ( "^" AndExpression() )*
    */
   public void visit(ExclusiveOrExpression n, A argu);

   /**
    * f0 -> EqualityExpression()
    * f1 -> ( "&" EqualityExpression() )*
    */
   public void visit(AndExpression n, A argu);

   /**
    * f0 -> InstanceOfExpression()
    * f1 -> ( ( "==" | "!=" ) InstanceOfExpression() )*
    */
   public void visit(EqualityExpression n, A argu);

   /**
    * f0 -> RelationalExpression()
    * f1 -> [ "instanceof" Type() ]
    */
   public void visit(InstanceOfExpression n, A argu);

   /**
    * f0 -> ShiftExpression()
    * f1 -> ( ( "<" | ">" | "<=" | ">=" ) ShiftExpression() )*
    */
   public void visit(RelationalExpression n, A argu);

   /**
    * f0 -> AdditiveExpression()
    * f1 -> ( ( "<<" | ">>" | ">>>" ) AdditiveExpression() )*
    */
   public void visit(ShiftExpression n, A argu);

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> ( ( "+" | "-" ) MultiplicativeExpression() )*
    */
   public void visit(AdditiveExpression n, A argu);

   /**
    * f0 -> UnaryExpression()
    * f1 -> ( ( "*" | "/" | "%" ) UnaryExpression() )*
    */
   public void visit(MultiplicativeExpression n, A argu);

   /**
    * f0 -> ( "+" | "-" ) UnaryExpression()
    *       | PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | UnaryExpressionNotPlusMinus()
    */
   public void visit(UnaryExpression n, A argu);

   /**
    * f0 -> "++"
    * f1 -> PrimaryExpression()
    */
   public void visit(PreIncrementExpression n, A argu);

   /**
    * f0 -> "--"
    * f1 -> PrimaryExpression()
    */
   public void visit(PreDecrementExpression n, A argu);

   /**
    * f0 -> ( "~" | "!" ) UnaryExpression()
    *       | CastExpression()
    *       | PostfixExpression()
    */
   public void visit(UnaryExpressionNotPlusMinus n, A argu);

   /**
    * f0 -> "(" PrimitiveType()
    *       | "(" Name() "[" "]"
    *       | "(" Name() ")" ( "~" | "!" | "(" | <IDENTIFIER> | "this" | "super" | "new" | Literal() )
    */
   public void visit(CastLookahead n, A argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> [ "++" | "--" ]
    */
   public void visit(PostfixExpression n, A argu);

   /**
    * f0 -> "(" PrimitiveType() ( "[" "]" )* ")" UnaryExpression()
    *       | "(" Name() ( "[" "]" )* ")" UnaryExpressionNotPlusMinus()
    */
   public void visit(CastExpression n, A argu);

   /**
    * f0 -> PrimaryPrefix()
    * f1 -> ( PrimarySuffix() )*
    */
   public void visit(PrimaryExpression n, A argu);

   /**
    * f0 -> Literal()
    *       | Name()
    *       | "this"
    *       | "super" "." <IDENTIFIER>
    *       | "(" Expression() ")"
    *       | AllocationExpression()
    */
   public void visit(PrimaryPrefix n, A argu);

   /**
    * f0 -> "[" Expression() "]"
    *       | "." <IDENTIFIER>
    *       | Arguments()
    */
   public void visit(PrimarySuffix n, A argu);

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <CHARACTER_LITERAL>
    *       | <STRING_LITERAL>
    *       | BooleanLiteral()
    *       | NullLiteral()
    */
   public void visit(Literal n, A argu);

   /**
    * f0 -> "true"
    *       | "false"
    */
   public void visit(BooleanLiteral n, A argu);

   /**
    * f0 -> "null"
    */
   public void visit(NullLiteral n, A argu);

   /**
    * f0 -> "("
    * f1 -> [ ArgumentList() ]
    * f2 -> ")"
    */
   public void visit(Arguments n, A argu);

   /**
    * f0 -> Expression()
    * f1 -> ( "," Expression() )*
    */
   public void visit(ArgumentList n, A argu);

   /**
    * f0 -> "new" PrimitiveType() ArrayDimensions()
    *       | "new" Name() AllocationArguments()
    */
   public void visit(AllocationExpression n, A argu);

   /**
    * f0 -> ( Arguments() | ArrayDimensions() )
    *       | "<" <IDENTIFIER> ">()" Block()
    */
   public void visit(AllocationArguments n, A argu);

   /**
    * f0 -> ( "[" Expression() "]" )+
    * f1 -> ( "[" "]" )*
    */
   public void visit(ArrayDimensions n, A argu);

   /**
    * f0 -> MethodDeclaration()
    *       | LabeledStatement()
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
   public void visit(Statement n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ":"
    * f2 -> Statement()
    */
   public void visit(LabeledStatement n, A argu);

   /**
    * f0 -> "{"
    * f1 -> ( BlockStatement() )*
    * f2 -> "}"
    */
   public void visit(Block n, A argu);

   /**
    * f0 -> LocalVariableDeclaration() ";"
    *       | Statement()
    */
   public void visit(BlockStatement n, A argu);

   /**
    * f0 -> Type()
    * f1 -> VariableDeclarator()
    * f2 -> ( "," VariableDeclarator() )*
    */
   public void visit(LocalVariableDeclaration n, A argu);

   /**
    * f0 -> ";"
    */
   public void visit(EmptyStatement n, A argu);

   /**
    * f0 -> PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | Assignment()
    *       | PostfixExpression()
    */
   public void visit(StatementExpression n, A argu);

   /**
    * f0 -> "switch"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( SwitchLabel() ( BlockStatement() )* )*
    * f6 -> "}"
    */
   public void visit(SwitchStatement n, A argu);

   /**
    * f0 -> "case" Expression() ":"
    *       | "default" ":"
    */
   public void visit(SwitchLabel n, A argu);

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> [ "else" Statement() ]
    */
   public void visit(IfStatement n, A argu);

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(WhileStatement n, A argu);

   /**
    * f0 -> "do"
    * f1 -> Statement()
    * f2 -> "while"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public void visit(DoStatement n, A argu);

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
   public void visit(ForStatement n, A argu);

   /**
    * f0 -> LocalVariableDeclaration()
    *       | StatementExpressionList()
    */
   public void visit(ForInit n, A argu);

   /**
    * f0 -> StatementExpression()
    * f1 -> ( "," StatementExpression() )*
    */
   public void visit(StatementExpressionList n, A argu);

   /**
    * f0 -> StatementExpressionList()
    */
   public void visit(ForUpdate n, A argu);

   /**
    * f0 -> "break"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public void visit(BreakStatement n, A argu);

   /**
    * f0 -> "continue"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public void visit(ContinueStatement n, A argu);

   /**
    * f0 -> "return"
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public void visit(ReturnStatement n, A argu);

   /**
    * f0 -> "throw"
    * f1 -> Expression()
    * f2 -> ";"
    */
   public void visit(ThrowStatement n, A argu);

   /**
    * f0 -> "synchronized"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Block()
    */
   public void visit(SynchronizedStatement n, A argu);

   /**
    * f0 -> "try"
    * f1 -> Block()
    * f2 -> ( "catch" "(" RequiredParameter() ")" Block() )*
    * f3 -> [ "finally" Block() ]
    */
   public void visit(TryStatement n, A argu);

}


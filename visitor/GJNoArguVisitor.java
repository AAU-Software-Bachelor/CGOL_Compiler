//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> [ PackageDeclaration() ]
    * f1 -> ( ImportDeclaration() )*
    * f2 -> ( TypeDeclaration() )*
    * f3 -> <EOF>
    */
   public R visit(CompilationUnit n);

   /**
    * f0 -> "package"
    * f1 -> Name()
    * f2 -> ";"
    */
   public R visit(PackageDeclaration n);

   /**
    * f0 -> "import"
    * f1 -> Name()
    * f2 -> [ "." "*" ]
    * f3 -> ";"
    */
   public R visit(ImportDeclaration n);

   /**
    * f0 -> ClassDeclaration()
    *       | InterfaceDeclaration()
    *       | ";"
    */
   public R visit(TypeDeclaration n);

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
   public R visit(ClassDeclaration n);

   /**
    * f0 -> StaticInitializer()
    *       | ConstructorDeclaration()
    *       | MethodDeclaration()
    *       | FieldDeclaration()
    *       | EmptyStatement()
    */
   public R visit(ClassBodyDeclaration n);

   /**
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> <IDENTIFIER>
    * f3 -> "("
    */
   public R visit(MethodDeclarationLookahead n);

   /**
    * f0 -> ( "abstract" | "public" )*
    * f1 -> "interface"
    * f2 -> <IDENTIFIER>
    * f3 -> [ "extends" NameList() ]
    * f4 -> "{"
    * f5 -> ( InterfaceMemberDeclaration() )*
    * f6 -> "}"
    */
   public R visit(InterfaceDeclaration n);

   /**
    * f0 -> MethodDeclaration()
    *       | FieldDeclaration()
    */
   public R visit(InterfaceMemberDeclaration n);

   /**
    * f0 -> ( field_modifier() )*
    * f1 -> Type()
    * f2 -> <IDENTIFIER>
    * f3 -> field_body()
    */
   public R visit(FieldDeclaration n);

   /**
    * f0 -> "new"
    *       | "public"
    *       | "protected"
    *       | "private"
    *       | "static"
    *       | "abstract"
    */
   public R visit(field_modifier n);

   /**
    * f0 -> "=" Expression() ( "{" accessor_declarations() "}" | ";" )
    *       | "{" accessor_declarations() "}"
    *       | ";"
    */
   public R visit(field_body n);

   /**
    * f0 -> accessor_get_declaration() ( accessor_set_declaration() )?
    *       | accessor_set_declaration() ( accessor_get_declaration() )?
    */
   public R visit(accessor_declarations n);

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <GET>
    * f2 -> ";"
    */
   public R visit(accessor_get_declaration n);

   /**
    * f0 -> ( "private" | "public" )?
    * f1 -> <SET>
    * f2 -> ";"
    */
   public R visit(accessor_set_declaration n);

   /**
    * f0 -> VariableDeclaratorId()
    * f1 -> [ "=" VariableInitializer() ]
    */
   public R visit(VariableDeclarator n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "[" "]" )*
    */
   public R visit(VariableDeclaratorId n);

   /**
    * f0 -> "{" [ VariableInitializer() ( "," VariableInitializer() )* ] [ "," ] "}"
    *       | Expression()
    */
   public R visit(VariableInitializer n);

   /**
    * f0 -> ( "public" | "protected" | "private" | "static" | "abstract" | "final" | "native" | "synchronized" )*
    * f1 -> ResultType()
    * f2 -> MethodDeclarator()
    * f3 -> [ "throws" NameList() ]
    * f4 -> ( Block() | ";" )
    */
   public R visit(MethodDeclaration n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> FormalParameters()
    * f2 -> ( "[" "]" )*
    */
   public R visit(MethodDeclarator n);

   /**
    * f0 -> "("
    * f1 -> [ FormalParameter() ( "," FormalParameter() )* ]
    * f2 -> ")"
    */
   public R visit(FormalParameters n);

   /**
    * f0 -> OptionalParameter()
    *       | RequiredParameter()
    */
   public R visit(FormalParameter n);

   /**
    * f0 -> Type()
    * f1 -> <IDENTIFIER>
    */
   public R visit(RequiredParameter n);

   /**
    * f0 -> Type()
    * f1 -> <IDENTIFIER>
    * f2 -> "="
    * f3 -> Literal()
    */
   public R visit(OptionalParameter n);

   /**
    * f0 -> Literal()
    */
   public R visit(DefaultValue n);

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
   public R visit(ConstructorDeclaration n);

   /**
    * f0 -> "this" Arguments() ";"
    *       | "super" Arguments() ";"
    */
   public R visit(ExplicitConstructorInvocation n);

   /**
    * f0 -> "static"
    * f1 -> Block()
    */
   public R visit(StaticInitializer n);

   /**
    * f0 -> ( PrimitiveType() | Name() )
    * f1 -> ( "[" "]" )*
    */
   public R visit(Type n);

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
   public R visit(PrimitiveType n);

   /**
    * f0 -> "void"
    *       | Type()
    */
   public R visit(ResultType n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "." <IDENTIFIER> )*
    */
   public R visit(Name n);

   /**
    * f0 -> Name()
    * f1 -> ( "," Name() )*
    */
   public R visit(NameList n);

   /**
    * f0 -> Assignment()
    *       | ConditionalExpression()
    */
   public R visit(Expression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> AssignmentOperator()
    * f2 -> Expression()
    */
   public R visit(Assignment n);

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
   public R visit(AssignmentOperator n);

   /**
    * f0 -> ConditionalOrExpression()
    * f1 -> [ "?" Expression() ":" ConditionalExpression() ]
    */
   public R visit(ConditionalExpression n);

   /**
    * f0 -> ConditionalAndExpression()
    * f1 -> ( "||" ConditionalAndExpression() )*
    */
   public R visit(ConditionalOrExpression n);

   /**
    * f0 -> InclusiveOrExpression()
    * f1 -> ( "&&" InclusiveOrExpression() )*
    */
   public R visit(ConditionalAndExpression n);

   /**
    * f0 -> ExclusiveOrExpression()
    * f1 -> ( "|" ExclusiveOrExpression() )*
    */
   public R visit(InclusiveOrExpression n);

   /**
    * f0 -> AndExpression()
    * f1 -> ( "^" AndExpression() )*
    */
   public R visit(ExclusiveOrExpression n);

   /**
    * f0 -> EqualityExpression()
    * f1 -> ( "&" EqualityExpression() )*
    */
   public R visit(AndExpression n);

   /**
    * f0 -> InstanceOfExpression()
    * f1 -> ( ( "==" | "!=" ) InstanceOfExpression() )*
    */
   public R visit(EqualityExpression n);

   /**
    * f0 -> RelationalExpression()
    * f1 -> [ "instanceof" Type() ]
    */
   public R visit(InstanceOfExpression n);

   /**
    * f0 -> ShiftExpression()
    * f1 -> ( ( "<" | ">" | "<=" | ">=" ) ShiftExpression() )*
    */
   public R visit(RelationalExpression n);

   /**
    * f0 -> AdditiveExpression()
    * f1 -> ( ( "<<" | ">>" | ">>>" ) AdditiveExpression() )*
    */
   public R visit(ShiftExpression n);

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> ( ( "+" | "-" ) MultiplicativeExpression() )*
    */
   public R visit(AdditiveExpression n);

   /**
    * f0 -> UnaryExpression()
    * f1 -> ( ( "*" | "/" | "%" ) UnaryExpression() )*
    */
   public R visit(MultiplicativeExpression n);

   /**
    * f0 -> ( "+" | "-" ) UnaryExpression()
    *       | PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | UnaryExpressionNotPlusMinus()
    */
   public R visit(UnaryExpression n);

   /**
    * f0 -> "++"
    * f1 -> PrimaryExpression()
    */
   public R visit(PreIncrementExpression n);

   /**
    * f0 -> "--"
    * f1 -> PrimaryExpression()
    */
   public R visit(PreDecrementExpression n);

   /**
    * f0 -> ( "~" | "!" ) UnaryExpression()
    *       | CastExpression()
    *       | PostfixExpression()
    */
   public R visit(UnaryExpressionNotPlusMinus n);

   /**
    * f0 -> "(" PrimitiveType()
    *       | "(" Name() "[" "]"
    *       | "(" Name() ")" ( "~" | "!" | "(" | <IDENTIFIER> | "this" | "super" | "new" | Literal() )
    */
   public R visit(CastLookahead n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> [ "++" | "--" ]
    */
   public R visit(PostfixExpression n);

   /**
    * f0 -> "(" PrimitiveType() ( "[" "]" )* ")" UnaryExpression()
    *       | "(" Name() ( "[" "]" )* ")" UnaryExpressionNotPlusMinus()
    */
   public R visit(CastExpression n);

   /**
    * f0 -> PrimaryPrefix()
    * f1 -> ( PrimarySuffix() )*
    */
   public R visit(PrimaryExpression n);

   /**
    * f0 -> Literal()
    *       | Name()
    *       | "this"
    *       | "super" "." <IDENTIFIER>
    *       | "(" Expression() ")"
    *       | AllocationExpression()
    */
   public R visit(PrimaryPrefix n);

   /**
    * f0 -> "[" Expression() "]"
    *       | "." <IDENTIFIER>
    *       | Arguments()
    */
   public R visit(PrimarySuffix n);

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <CHARACTER_LITERAL>
    *       | <STRING_LITERAL>
    *       | BooleanLiteral()
    *       | NullLiteral()
    */
   public R visit(Literal n);

   /**
    * f0 -> "true"
    *       | "false"
    */
   public R visit(BooleanLiteral n);

   /**
    * f0 -> "null"
    */
   public R visit(NullLiteral n);

   /**
    * f0 -> "("
    * f1 -> [ ArgumentList() ]
    * f2 -> ")"
    */
   public R visit(Arguments n);

   /**
    * f0 -> Expression()
    * f1 -> ( "," Expression() )*
    */
   public R visit(ArgumentList n);

   /**
    * f0 -> "new" PrimitiveType() ArrayDimensions()
    *       | "new" Name() ( Arguments() | ArrayDimensions() )
    */
   public R visit(AllocationExpression n);

   /**
    * f0 -> ( "[" Expression() "]" )+
    * f1 -> ( "[" "]" )*
    */
   public R visit(ArrayDimensions n);

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
   public R visit(Statement n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ":"
    * f2 -> Statement()
    */
   public R visit(LabeledStatement n);

   /**
    * f0 -> "{"
    * f1 -> ( BlockStatement() )*
    * f2 -> "}"
    */
   public R visit(Block n);

   /**
    * f0 -> LocalVariableDeclaration() ";"
    *       | Statement()
    */
   public R visit(BlockStatement n);

   /**
    * f0 -> Type()
    * f1 -> VariableDeclarator()
    * f2 -> ( "," VariableDeclarator() )*
    */
   public R visit(LocalVariableDeclaration n);

   /**
    * f0 -> ";"
    */
   public R visit(EmptyStatement n);

   /**
    * f0 -> PreIncrementExpression()
    *       | PreDecrementExpression()
    *       | Assignment()
    *       | PostfixExpression()
    */
   public R visit(StatementExpression n);

   /**
    * f0 -> "switch"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( SwitchLabel() ( BlockStatement() )* )*
    * f6 -> "}"
    */
   public R visit(SwitchStatement n);

   /**
    * f0 -> "case" Expression() ":"
    *       | "default" ":"
    */
   public R visit(SwitchLabel n);

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> [ "else" Statement() ]
    */
   public R visit(IfStatement n);

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(WhileStatement n);

   /**
    * f0 -> "do"
    * f1 -> Statement()
    * f2 -> "while"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public R visit(DoStatement n);

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
   public R visit(ForStatement n);

   /**
    * f0 -> LocalVariableDeclaration()
    *       | StatementExpressionList()
    */
   public R visit(ForInit n);

   /**
    * f0 -> StatementExpression()
    * f1 -> ( "," StatementExpression() )*
    */
   public R visit(StatementExpressionList n);

   /**
    * f0 -> StatementExpressionList()
    */
   public R visit(ForUpdate n);

   /**
    * f0 -> "break"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public R visit(BreakStatement n);

   /**
    * f0 -> "continue"
    * f1 -> [ <IDENTIFIER> ]
    * f2 -> ";"
    */
   public R visit(ContinueStatement n);

   /**
    * f0 -> "return"
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public R visit(ReturnStatement n);

   /**
    * f0 -> "throw"
    * f1 -> Expression()
    * f2 -> ";"
    */
   public R visit(ThrowStatement n);

   /**
    * f0 -> "synchronized"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Block()
    */
   public R visit(SynchronizedStatement n);

   /**
    * f0 -> "try"
    * f1 -> Block()
    * f2 -> ( "catch" "(" FormalParameter() ")" Block() )*
    * f3 -> [ "finally" Block() ]
    */
   public R visit(TryStatement n);

}


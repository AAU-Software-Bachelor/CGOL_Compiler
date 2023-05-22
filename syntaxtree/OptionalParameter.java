//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> Type()
 * f1 -> <IDENTIFIER>
 * f2 -> "="
 * f3 -> Literal()
 */
public class OptionalParameter implements Node {
   public Type f0;
   public NodeToken f1;
   public NodeToken f2;
   public Literal f3;

   public OptionalParameter(Type n0, NodeToken n1, NodeToken n2, Literal n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public OptionalParameter(Type n0, NodeToken n1, Literal n2) {
      f0 = n0;
      f1 = n1;
      f2 = new NodeToken("=");
      f3 = n2;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

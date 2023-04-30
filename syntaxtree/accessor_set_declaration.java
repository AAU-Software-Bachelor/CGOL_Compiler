//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> ( "private" | "public" )?
 * f1 -> <SET>
 * f2 -> ";"
 */
public class accessor_set_declaration implements Node {
   public NodeOptional f0;
   public NodeToken f1;
   public NodeToken f2;

   public accessor_set_declaration(NodeOptional n0, NodeToken n1, NodeToken n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public accessor_set_declaration(NodeOptional n0) {
      f0 = n0;
      f1 = new NodeToken("set");
      f2 = new NodeToken(";");
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


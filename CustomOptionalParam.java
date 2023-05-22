public class CustomOptionalParam {
    public String Type;
    private String Name;
    private String Expression;
    public CustomOptionalParam(String Type, String Name, String Expression) {
        this.Type = Type;
        this.Name = Name;
        this.Expression = Expression;
    }
    public String toString() {
        return Type + " " + Name + " = " + Expression;
    }
    public String toParamString() {
        return Type + " " + Name;
    }
 }

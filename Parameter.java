public class Parameter {
    public String type;
    public String name;
    public String defaultValue;

    public Parameter() {}

    public Parameter(String type, String name, String defaultValue) {
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public boolean isOptional() {
        return defaultValue != null;
    }

    public void setDefaultValue(Object value) {
        if(value instanceof Integer) {
            defaultValue = Integer.toString((Integer) value);
        } else if(value instanceof Double) {
            defaultValue = Double.toString((Double) value);
        } else if(value instanceof Boolean) {
            defaultValue = Boolean.toString((Boolean) value);
        } else if(value instanceof String) {
            defaultValue = (String) value;
        } else {
            throw new IllegalArgumentException("Unsupported type for default value in Parameter class.");
        }
    }
}

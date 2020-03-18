package elasticUtils;

public class SearchDto {
  
    private String fieldKey;
    private String fieldValue;
    private SearchPriority fieldPriority;
    private Equality equality;
    
    public SearchDto() {
      
    }
    
    public SearchDto(String fieldKey, String fieldValue, SearchPriority fieldPriority) {
        this.fieldKey = fieldKey;
        this.fieldValue = fieldValue;
        this.fieldPriority = fieldPriority;
    }
    
    public SearchDto(String fieldKey, String fieldValue, SearchPriority fieldPriority, Equality equality) {
        this.fieldKey = fieldKey;
        this.fieldValue = fieldValue;
        this.fieldPriority = fieldPriority;
        this.equality = equality;
    }
    
    public String getFieldKey() {
        return fieldKey;
    }
    
    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }
    
    public String getFieldValue() {
        return fieldValue;
    }
    
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
    
    public SearchPriority getFieldPriority() {
        return fieldPriority;
    }
    
    public void setFieldPriority(SearchPriority fieldPriority) {
        this.fieldPriority = fieldPriority;
    }
    
    public Equality getEquality() {
        return equality;
    }

    public void setEquality(Equality equality) {
        this.equality = equality;
    }
    
    public enum SearchPriority {
        MUST, SHOULD
    }
    
    public enum Equality {
        LT, LTE, GT, GTE
    }
    
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SearchDto : [ ");
        buffer.append("fieldKey : "+fieldKey+" ,");
        buffer.append("fieldValue : "+fieldValue+" ,");
        buffer.append("fieldPriority : "+fieldPriority+" ,");
        buffer.append("equality : "+equality);
        buffer.append(" ]");
        return buffer.toString();
    }
    
}

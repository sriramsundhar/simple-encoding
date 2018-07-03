package pojo;

public class InputText {
    Integer offset;

    public String getInputString() {
        return inputString;
    }

    String inputString;

    public Integer getOffset() {
        return offset;
    }

    private InputText(Integer offset, String inputString) {
        this.inputString = inputString;
        this.offset = offset;
    }

    public static InputText getInstance(Integer offset, String inputString) {
        return new InputText(offset,inputString);
    }
    public static InputText getInstance(String inputString) {
        return getInstance(null, inputString);
    }
}

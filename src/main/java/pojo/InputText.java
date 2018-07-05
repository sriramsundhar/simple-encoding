package pojo;

public class InputText {
    private Integer offset;

    private String inputString;


    public Integer getOffset() {
        return offset;
    }

    public String getInputString() {
        return inputString;
    }

    private InputText(String inputString, Integer offset) {
        this.inputString = inputString;
        this.offset = offset;
    }

    public static InputText getInstance(String inputString, Integer offset) {
        return new InputText(inputString, offset);
    }
    public static InputText getInstance(String inputString) {
        return getInstance(inputString, null);
    }

}

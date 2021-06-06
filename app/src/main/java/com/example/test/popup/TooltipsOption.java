package com.example.test.popup;

public class TooltipsOption {

    private String type;
    private String displayName;
    private boolean isChecked;

    public TooltipsOption() {

    }

    public TooltipsOption(String type, String displayName, boolean isChecked) {
        this.type = type;
        this.displayName = displayName;
        this.isChecked = isChecked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

}
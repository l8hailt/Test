package com.example.test.builder;

public class TestBuilder {

    private String testField1;
    private String testField2;
    private String testField3;
    private String testField4;

    private TestBuilder(Builder builder) {
        this.testField1 = builder.testField1;
        this.testField2 = builder.testField2;
        this.testField3 = builder.testField3;
        this.testField4 = builder.testField4;
    }

    static class Builder {

        private String testField1;
        private String testField2;
        private String testField3;
        private String testField4;

        public Builder setField1(String testField1) {
            this.testField1 = testField1;
            return this;
        }

        public Builder setField2(String testField2) {
            this.testField2 = testField2;
            return this;
        }

        public Builder setField3(String testField3) {
            this.testField3 = testField3;
            return this;
        }

        public Builder setField4(String testField4) {
            this.testField4 = testField4;
            return this;
        }

        public TestBuilder create() {
            return new TestBuilder(this);
        }

    }

    @Override
    public String toString() {
        return "TestBuilder{" +
                "testField1='" + testField1 + '\'' +
                ", testField2='" + testField2 + '\'' +
                ", testField3='" + testField3 + '\'' +
                ", testField4='" + testField4 + '\'' +
                '}';
    }
}

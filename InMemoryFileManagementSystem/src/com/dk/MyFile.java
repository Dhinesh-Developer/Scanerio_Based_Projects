package com.dk;

class MyFile {
    private String name;
    private String content;

    public MyFile(String name) {
        this.name = name;
        this.content = "";
    }

    public String getName() {
        return name;
    }

    public void writeContent(String data) {
        this.content = data;
    }

    public String readContent() {
        return content;
    }

    public int getSize() {
        return content.length();
    }

    @Override
    public String toString() {
        return name + " (size=" + getSize() + ")";
    }
}
package com.dk;

class FileSystem {
    private Folder root;

    public FileSystem() {
        root = new Folder("root");
    }

    public Folder getRoot() {
        return root;
    }

    public void listAll() {
        root.listContents("");
    }
}
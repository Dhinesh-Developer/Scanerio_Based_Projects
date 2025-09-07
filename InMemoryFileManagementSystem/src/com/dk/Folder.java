package com.dk;

import java.util.HashMap;
import java.util.Map;

class Folder {
    private String name;
    private Map<String, MyFile> files = new HashMap<>();
    private Map<String, Folder> subFolders = new HashMap<>();

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addFile(String fileName) {
        if (files.containsKey(fileName)) return false;
        files.put(fileName, new MyFile(fileName));
        return true;
    }

    public boolean addFolder(String folderName) {
        if (subFolders.containsKey(folderName)) return false;
        subFolders.put(folderName, new Folder(folderName));
        return true;
    }

    public MyFile getFile(String fileName) {
        return files.get(fileName);
    }

    public Folder getSubFolder(String folderName) {
        return subFolders.get(folderName);
    }

    public boolean deleteFile(String fileName) {
        return files.remove(fileName) != null;
    }

    public boolean deleteFolder(String folderName) {
        return subFolders.remove(folderName) != null;
    }

    public void listContents(String indent) {
        System.out.println(indent + name + "/");
        for (MyFile f : files.values()) {
            System.out.println(indent + "   " + f);
        }
        for (Folder sub : subFolders.values()) {
            sub.listContents(indent + "   ");
        }
    }
}
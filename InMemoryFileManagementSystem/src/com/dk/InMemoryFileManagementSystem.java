package com.dk;

import java.util.Scanner;

public class InMemoryFileManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileSystem fs = new FileSystem();
        Folder root = fs.getRoot();

        while (true) {
            System.out.println("\n--- File Management System ---");
            System.out.println("1. Create Folder");
            System.out.println("2. Create File");
            System.out.println("3. Write Content to File");
            System.out.println("4. Read File Content");
            System.out.println("5. List All Files and Folders");
            System.out.println("6. Delete File");
            System.out.println("7. Delete Folder");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter folder name: ");
                    String fname = sc.nextLine();
                    if (root.addFolder(fname))
                        System.out.println("Folder '" + fname + "' created.");
                    else
                        System.out.println(" Folder already exists.");
                    break;

                case 2:
                    System.out.print("Enter folder name to create file in: ");
                    String folderName = sc.nextLine();
                    Folder f = root.getSubFolder(folderName);
                    if (f == null) {
                        System.out.println("Folder not found.");
                        break;
                    }
                    System.out.print("Enter file name: ");
                    String fileName = sc.nextLine();
                    if (f.addFile(fileName))
                        System.out.println(" File '" + fileName + "' created.");
                    else
                        System.out.println(" File already exists.");
                    break;

                case 3:
                    System.out.print("Enter folder name of file: ");
                    folderName = sc.nextLine();
                    f = root.getSubFolder(folderName);
                    if (f == null) {
                        System.out.println(" Folder not found.");
                        break;
                    }
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    MyFile file = f.getFile(fileName);
                    if (file == null) {
                        System.out.println(" File not found.");
                        break;
                    }
                    System.out.print("Enter content: ");
                    String content = sc.nextLine();
                    file.writeContent(content);
                    System.out.println(" Content written.");
                    break;

                case 4:
                    System.out.print("Enter folder name of file: ");
                    folderName = sc.nextLine();
                    f = root.getSubFolder(folderName);
                    if (f == null) {
                        System.out.println(" Folder not found.");
                        break;
                    }
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    file = f.getFile(fileName);
                    if (file == null) {
                        System.out.println(" File not found.");
                        break;
                    }
                    System.out.println("📄 Content: " + file.readContent());
                    break;

                case 5:
                    fs.listAll();
                    break;

                case 6:
                    System.out.print("Enter folder name of file: ");
                    folderName = sc.nextLine();
                    f = root.getSubFolder(folderName);
                    if (f == null) {
                        System.out.println(" Folder not found.");
                        break;
                    }
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    if (f.deleteFile(fileName))
                        System.out.println(" File deleted.");
                    else
                        System.out.println(" File not found.");
                    break;

                case 7:
                    System.out.print("Enter folder name: ");
                    folderName = sc.nextLine();
                    if (root.deleteFolder(folderName))
                        System.out.println(" Folder deleted.");
                    else
                        System.out.println(" Folder not found.");
                    break;

                case 8:
                    System.out.println(" Exiting File Management System.");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice.");
            }
        }
    }
}

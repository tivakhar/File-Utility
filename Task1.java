import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;
class Task1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String fn="hello.txt";
        System.out.println("Enter text to write file:");
        String content=sc.nextLine();
        writetofile(fn,content);
         readfromfile(fn);
         System.out.println();
         System.out.print("Enter word to replace:");
         String old=sc.nextLine();
         System.out.print("Enter new word:");
         String newtext=sc.nextLine();
         modifyfile(fn,old,newtext);
         System.out.println();
         System.out.println("Modified file content:");
         readfromfile(fn);
    }
    public static void writetofile(String fn,String content){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fn))){
            bw.write(content);
            System.out.println("File successfully.");
        }
        catch(IOException e){
            System.out.println("Error write file: "+e.getMessage());
        }
    }
    public static void readfromfile(String fn){
        try(BufferedReader bw = new BufferedReader(new FileReader(fn))){
            String line=bw.readLine();
            System.out.println("File content:");
            while(line!=null){
                System.out.println(line);
                line = bw.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error read file:"+e.getMessage());
        }
       }
    public static void modifyfile(String fn,String old,String newtext){
       try{
        Path p=Paths.get(fn);
        String content=new String(Files.readAllBytes(p));
        content=content.replaceAll(old,newtext);
        Files.write(p,content.getBytes());
        System.out.println("File successfully");
       }
       catch(IOException e){
        System.out.println("Error file:"+e.getMessage());
       }
    }
    }

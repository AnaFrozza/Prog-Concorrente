package Tarefa08.Framework.ex04;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

public class Tarefa_CheckInte implements Runnable {

    String local;
    MessageDigest md;
    FileReader file;
    Monitora monitora;


    public Tarefa_CheckInte(String local, Monitora monitora) {
        this.monitora = monitora;
        this.local = local;
        try {
            this.md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Tarefa_CheckInte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        String dados;

        try {
            dados = new String(Files.readAllBytes(Paths.get(this.local)));
        } catch (IOException ex) {
            dados = " ";
            Logger.getLogger(Tarefa_CheckInte.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Lendo Arquivo....");
        this.md.update(dados.getBytes());
        byte[] digest = this.md.digest();


        this.monitora.setMd5_Check_New(DatatypeConverter.printHexBinary(digest).toUpperCase());
        System.out.println("MD5: "+DatatypeConverter.printHexBinary(digest).toUpperCase());


        if(this.monitora.getMd5_Check_New().equals(this.monitora.getMd5_Check_Old())){
            System.out.println("Nada Mudou....");
        }
        else{
            System.out.println("Houve Mudança!");
            this.monitora.setMd5_Check_Old(DatatypeConverter.printHexBinary(digest).toUpperCase());
        }
    }
}

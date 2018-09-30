package revert.myNio.demo.channel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {

    static final String filePath = "E:\\1me\\git\\basic\\myNio\\src\\main\\resources\\com\\1.txt";

    public static void main(String[] args) {
        readFile_IO();
    }


    public static void readFile_IO(){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream(filePath));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1){
                for(int i=0;i<bytesRead;i++)
                    System.out.print((char)buf[i]);
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}

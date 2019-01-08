import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionclass {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://github.com/prnv28/prnv28.github.io/blob/master/index.html");
            URLConnection urlcon = url.openConnection();

            InputStream stream=urlcon.getInputStream();
            int i;
            while((i=stream.read())!=-1){
                System.out.print((char)i);
            }
            stream.close();
            System.out.println("AllowUserInteraction : "+urlcon.getAllowUserInteraction());
            System.out.println("DoInput : "+urlcon.getDoInput());
            System.out.println("IfModifiedSince : "+urlcon.getIfModifiedSince());
            System.out.println("UseCaches : "+urlcon.getUseCaches());
            System.out.println("URL : "+urlcon.getURL());
            System.out.println("ContentEncoding : "+urlcon.getContentEncoding());
            System.out.println("LastModified : "+urlcon.getLastModified());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


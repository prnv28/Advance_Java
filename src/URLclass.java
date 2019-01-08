import java.net.*;

public class URLclass {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://github.com/prnv28/prnv28.github.io/blob/master/index.html");
            URL url1=new URL(url,"index.html");
            System.out.println("URL : "+url);
            System.out.println("Authority : "+url.getAuthority());
            System.out.println("Port : "+url.getPort());
            System.out.println("Default port :"+url.getDefaultPort());
            System.out.println("Protocol : "+url.getProtocol());
            System.out.println("Host :"+url.getHost());
            System.out.println("Path : "+url.getPath());
            System.out.println("Query : "+url.getQuery());
            System.out.println("File : "+url.getFile());
            System.out.println("Reference : "+url.getRef());
            System.out.println(url.equals(url1));
            System.out.println("URI : "+url.toURI());
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

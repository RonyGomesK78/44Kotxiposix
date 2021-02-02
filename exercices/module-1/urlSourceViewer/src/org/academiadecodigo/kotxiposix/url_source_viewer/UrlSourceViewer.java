package org.academiadecodigo.kotxiposix.url_source_viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlSourceViewer {

    private URL url;

    private void initConnection(String spec) throws IOException {

        url = new URL(spec);
    }

    private void receiveResponse() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line = "";

        while ((line = bufferedReader.readLine()) != null) {

            System.out.println(line);
        }
    }

    public static void main(String[] args) {

        UrlSourceViewer url = new UrlSourceViewer();

        try {

            url.initConnection("https://abola.pt");
            url.receiveResponse();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws;

import android.os.AsyncTask;
import android.util.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//import com.magna.sistemas.timesheetv2.utils.Constants;
import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.Constants.Constants;

public class AsyncCallBasicAuthentication extends AsyncTask<String, Void, String> {

    public interface AsyncResponse {
        void processFinish(String result);
    }

    public AsyncResponse delegate = null;

    private static String servidor = Constants.SERVER;
//    private static String servidor = "mgappr9";

    public AsyncCallBasicAuthentication(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    protected String doInBackground(String... params) {

        String Erro = "true";

        if (params.length > 0)
            try {
                String webPage = "http://"+servidor+".magnasistemas.com.br/magna/Portal.nsf";

                //String webPage = "http://connections.magnasistemas.com.br/profiles/login";

                //http://connections.magnasistemas.com.br/communities/service/atom/community/instance?communityUuid=2f6fbe56-e52a-4b3c-bdff-c8189534fadd


                String name = params[0];
                String password = params[1];

                URL url = new URL(webPage);
                URLConnection urlConnection = url.openConnection();
                final String userpass = name + ":" + password;

                final String basicAuth = "Basic " + Base64.encodeToString(userpass.getBytes(), Base64.NO_WRAP);

                urlConnection.setRequestProperty("Authorization", basicAuth);

                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);

                int numCharsRead;
                char[] charArray = new char[1024];
                StringBuffer sb = new StringBuffer();
                while ((numCharsRead = isr.read(charArray)) > 0) {
                    sb.append(charArray, 0, numCharsRead);
                }

                String result = sb.toString();

                if (result.contains("_Inicio")) {
                    return Erro = "false";

                } else {
                    return Erro = "true";
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return Erro;
    }

    protected void onPostExecute(String result) {

        delegate.processFinish(result);

    }



}

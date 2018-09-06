package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.webservices;

/**
 * Created by --Luan- on 30/11/2015.
 */

import android.util.Base64;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.Constants.Constants;

//import com.magna.sistemas.timesheetv2.utils.Constants;

public class WebServiceRetornaListaApontamentos {

    private static String servidor = Constants.SERVER;
    private static String NAMESPACE = "http://" + servidor + ".magnasistemas.com.br:80/magna/timesheet.nsf/";
    private static String URL = "http://" + servidor + ".magnasistemas.com.br:80/magna/timesheet.nsf/ListaApontamentos?OpenWebService";
    private static int Timeout = 100000;
    static SoapObject obj;
    static Object objErro;
    static Object objBranco;

    public static ArrayList chamarWebserviceApontamentos(String name, String senha, String webMethName, String soapAction) {

        String SOAP_ACTION = soapAction;  //"LISTADOCAGUARDANDO?WSDL";

        ArrayList<SoapObject> listaDeApontamentos = new ArrayList<SoapObject>();
        listaDeApontamentos.clear();
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        PropertyInfo parametroEntrada = new PropertyInfo();
        parametroEntrada.setName("PARAMETRO");
        parametroEntrada.setValue(name);
        parametroEntrada.setType(String.class);
        request.addProperty(parametroEntrada);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL, Timeout);
        envelope.setOutputSoapObject(request);

        try {
            String webPage = "http://" + servidor + ".magnasistemas.com.br/magna/Portal.nsf";

            java.net.URL url = new URL(webPage);
            URLConnection urlConnection = url.openConnection();
            final String userpass = name + ":" + senha;
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

            List<HeaderProperty> headers = new ArrayList<HeaderProperty>();
            headers.add(new HeaderProperty("Authorization", basicAuth)); // "Basic V1M6"));


            if (result.contains("_Inicio")) {


                androidHttpTransport.getServiceConnection().disconnect();
                androidHttpTransport.getServiceConnection().connect();
                androidHttpTransport.call(SOAP_ACTION + webMethName, envelope, headers);
                androidHttpTransport.getServiceConnection().disconnect();
                SoapObject response = (SoapObject) envelope.getResponse();

                if (response.getPropertyCount() > 0 && !response.equals("anyType{}")) {

                    for (int i = 0; i < response.getPropertyCount(); i++) {
                        obj = (SoapObject) response.getProperty(i);

                        listaDeApontamentos.add(obj);
                        //listaDeApontamentos.add((SoapObject) objErro);

                    }
                } else {
                    objBranco = (SoapObject) response;
                    listaDeApontamentos.add((SoapObject) objBranco);
                }

            }
        } catch (Exception e) {
            listaDeApontamentos.add((SoapObject) objErro);
        }
        return listaDeApontamentos;
    }
}

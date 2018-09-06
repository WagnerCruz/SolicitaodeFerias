package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by --Luan- on 18/05/2016.
 */
public class SaveSharedPreference {

    static final String PREF_USER_NAME = "username";
    static final String PREF_SENHA = "senha";
    static final String AREA_COLAB = "area";
    static final String COLABORADOR = "colab";
    static final String IMAGEM = "imagem";
    static final String CLIENTE = "cliente";
    static final String PROJETO = "projeto";
    static final String ATIVIDADE = "atividade";
    static final String OS = "os";
    static final String SUBATIVIDADE = "subatividade";
    static final String AUSENCIA = "ausencia";
    static final String OPORTUNIDADE = "oportunidade";

    static final String CHECK_CLIENTE = "check_cliente";
    static final String CHECK_PROJETO = "check_projeto";
    static final String CHECK_ATIVIDADE = "check_atividade";
    static final String CHECK_SUB_ATIVIDADE = "check_sub_atividade";
    static final String CHECK_OS = "check_os ";

    static final String SALVA_CLIENTE = "salva_cliente";
    static final String SALVA_PROJETO = "salva_projeto";
    static final String SALVA_ATIVIDADE = "salva_atividade";
    static final String SALVA_OS = "salva_os";
    static final String SALVA_SUBATIVIDADE = "salva_subatividade";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }

    public static String getUserName(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    public static void setSenha(Context ctx, String senha) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_SENHA, senha);
        editor.commit();
    }

    public static String getSenha(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_SENHA, "");
    }

    public static void setColab(Context ctx, String colab) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(AREA_COLAB, colab);
        editor.commit();
    }

    public static String getColab(Context ctx) {
        return getSharedPreferences(ctx).getString(AREA_COLAB, "");
    }

    public static void setArea(Context ctx, String area) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(COLABORADOR, area);
        editor.commit();
    }

    public static String getArea(Context ctx) {
        return getSharedPreferences(ctx).getString(COLABORADOR, "");
    }


    public static void clearUserName(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear(); //clear all stored data
        editor.commit();
    }


    public static void setCliente(Context ctx, String cliente)

    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CLIENTE, cliente);
        editor.commit();

        SaveSharedPreference.clearProjeto(ctx);
        SaveSharedPreference.clearAtividade(ctx);
        SaveSharedPreference.clearSubAtividade(ctx);
        SaveSharedPreference.clearOs(ctx);
        SaveSharedPreference.clearOportunidade(ctx);

    }

    public static String getCliente(Context ctx) {
        return getSharedPreferences(ctx).getString(CLIENTE, "");
    }

    public static void clearCliente(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(CLIENTE).commit();
    }


    public static void setProjeto(Context ctx, String projeto) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PROJETO, projeto);
        editor.commit();

        SaveSharedPreference.clearAtividade(ctx);
        SaveSharedPreference.clearSubAtividade(ctx);
        SaveSharedPreference.clearOs(ctx);
        SaveSharedPreference.clearAusencia(ctx);
        SaveSharedPreference.clearOportunidade(ctx);

    }

    public static String getProjeto(Context ctx) {
        return getSharedPreferences(ctx).getString(PROJETO, "");
    }

    public static void clearProjeto(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(PROJETO).commit();
    }


    public static void setAtividade(Context ctx, String atividade) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(ATIVIDADE, atividade);
        editor.commit();
    }

    public static String getAtividade(Context ctx) {
        return getSharedPreferences(ctx).getString(ATIVIDADE, "");
    }

    public static void clearAtividade(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(ATIVIDADE).commit();
    }


    public static void setOS(Context ctx, String os) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(OS, os);
        editor.commit();
    }

    public static String getOs(Context ctx) {
        return getSharedPreferences(ctx).getString(OS, "");
    }

    public static void clearOs(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(OS).commit();
    }


    public static void setSubatividade(Context ctx, String subatividade) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(SUBATIVIDADE, subatividade);
        editor.commit();
    }

    public static String getSubAtividade(Context ctx) {
        return getSharedPreferences(ctx).getString(SUBATIVIDADE, "");
    }

    public static void clearSubAtividade(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(SUBATIVIDADE).commit();
    }

    public static void setOportunidade(Context ctx, String oportunidade) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(OPORTUNIDADE, oportunidade);
        editor.commit();

    }

    public static String getOportunidade(Context ctx) {
        return getSharedPreferences(ctx).getString(OPORTUNIDADE, "");
    }

    public static void clearOportunidade(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(OPORTUNIDADE).commit();
    }

    public static void setAusencia(Context ctx, String ausencia) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(AUSENCIA, ausencia);
        editor.commit();
    }

    public static String getAusencia(Context ctx) {
        return getSharedPreferences(ctx).getString(AUSENCIA, "");
    }

    public static void clearAusencia(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(AUSENCIA).commit();
    }


































    public static void setCheckCliente(Context ctx, String checkCliente) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CHECK_CLIENTE, checkCliente);
        editor.commit();
    }

    public static String getCheckCliente(Context ctx) {
        return getSharedPreferences(ctx).getString(CHECK_CLIENTE, "");
    }

    public static void clearCheckCliente(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(CHECK_CLIENTE).commit();
    }

    public static void setCheckProjeto(Context ctx, String checkProjeto) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CHECK_PROJETO, checkProjeto);
        editor.commit();
    }

    public static String getCheckProjeto(Context ctx) {
        return getSharedPreferences(ctx).getString(CHECK_PROJETO, "");
    }

    public static void clearCheckProjeto(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(CHECK_PROJETO).commit();
    }

    public static void setCheckAtividade(Context ctx, String checkAtividade) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CHECK_ATIVIDADE, checkAtividade);
        editor.commit();
    }

    public static String getCheckAtividade(Context ctx) {
        return getSharedPreferences(ctx).getString(CHECK_ATIVIDADE, "");
    }

    public static void clearCheckAtividade(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(CHECK_ATIVIDADE).commit();
    }

    public static void setCheckOs(Context ctx, String checkOs) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CHECK_OS, checkOs);
        editor.commit();
    }

    public static String getCheckOs(Context ctx) {
        return getSharedPreferences(ctx).getString(CHECK_OS, "");
    }

    public static void clearCheckOs(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(CHECK_OS).commit();
    }

    public static void setCheckSubAtividade(Context ctx, String checkSubAtividade) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CHECK_SUB_ATIVIDADE, checkSubAtividade);
        editor.commit();
    }

    public static String getCheckSubAtividade(Context ctx) {
        return getSharedPreferences(ctx).getString(CHECK_SUB_ATIVIDADE, "");
    }

    public static void clearCheckSubAtividade(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        SharedPreferences preferences = getSharedPreferences(ctx);
        preferences.edit().remove(CHECK_SUB_ATIVIDADE).commit();
    }















}

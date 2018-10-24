package com.liuz.bplan;

import org.springframework.util.StreamUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;

public class JavaScriptInvoker {
    private ScriptEngine engine;
    private Invocable invocable;

    public void init(InputStream inputStream) {
        engine = new ScriptEngineManager().getEngineByName("nashorn");//1.得到脚本引擎
        try {
            //2.引擎读取 脚本字符串
            engine.eval(new InputStreamReader(inputStream));
            //3.将引擎转换为Invocable，这样才可以掉用js的方法
            invocable = (Invocable) engine;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            init(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(String ...scripts) {
        String str = new String();
        for(String s : scripts) {
            str += s;
        }
        init(new StringBufferInputStream(str));
    }

    public Object call(String functionName, Object args) {
        //4.使用 invocable.invokeFunction掉用js脚本里的方法，第一個参数为方法名，后面的参数为被调用的js方法的入参
        try {
            Object scriptResult = invocable.invokeFunction(functionName, args);
            return scriptResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        JavaScriptInvoker invoker = new JavaScriptInvoker();
        InputStream is = invoker.getClass().getClassLoader().getResourceAsStream("static/js/cryto-js.js");
        String function = " function aesDecrypt(message) {" +
                "var keyHex = CryptoJS.enc.Utf8.parse(\"5QTtRO3vQMaYnPajQqc4d7eaF6BNS2dG\");" +
                "var ivHex = CryptoJS.enc.Utf8.parse(\"5QTtRO3vQMaYnPajQqc4d7eaF6BNS2dG\");" +
                "var decrypted = CryptoJS.DES.decrypt({" +
                "ciphertext: CryptoJS.enc.Hex.parse(message)" +
                "}, keyHex, {" +
                "iv:ivHex," +
                "mode: CryptoJS.mode.CBC," +
                "padding: CryptoJS.pad.Pkcs7" +
                "});" +
                "return decrypted.toString(CryptoJS.enc.Utf8); " +
                "}";
        BufferedReader bi = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        while((tmp = bi.readLine()) != null){
            if(sb.length()>0){
                sb.append("\r\n");
            }
            sb.append(tmp);
        }
        invoker.init(sb.toString(),function);
        for (int i = 0; i < 1000; i++) {
        String val = (String) invoker.call("aesDecrypt", "0b40704191f9f2bdb42f44493c57e6647f50bacb6ba76088d98485e751de78fdc35b3d3b34502a11bd1ec26dae1e9f40");

        System.out.println(val);
        }
    }
}

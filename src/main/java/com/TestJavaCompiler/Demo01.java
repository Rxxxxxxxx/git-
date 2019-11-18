package com.TestJavaCompiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        int result=compiler.run(null,null,null,"F:/MyJava/HelloWorld.java");
        System.out.println(result == 0 ? "变异成功": "变异失败");

        Runtime run=Runtime.getRuntime();
        Process process=run.exec("java -cp f:/MyJava       HelloWorld");

        InputStream in=process.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String info="";
        while ((info=reader.readLine())!=null){
            System.out.println(info);
        }
    }
}

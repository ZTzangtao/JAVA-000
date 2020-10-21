package work;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

/**
 * @author Tommy
 */
public class JvmClassloader extends ClassLoader {

    public static void main(String[] args) {
        try{
           Object obj = new JvmClassloader().findClass("Hello").newInstance();
           Class clazz = obj.getClass();
           Method method = clazz.getMethod("hello",null);
           method.invoke(obj,null);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        String targetPath = "/Users/zangtao/Documents/geektime/Hello/Hello.xlass";
        File file = new File(targetPath);
        String helloBase64 = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            InputStream inputStream = new FileInputStream(targetPath);
            int temp;
            while((temp = inputStream.read())!= -1){
                System.out.println(temp);
                outputStream.write(255-temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
//        byte[] bytes = decode(outputStream.toString());
        return defineClass(name,outputStream.toByteArray(),0,outputStream.toByteArray().length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }

}


/**
 *
 * //        String targetPath = "/Users/zangtao/Documents/geektime/Hello";
 * //        URLClassLoader urlClassLoader = (URLClassLoader) JvmClassloader.class.getClassLoader();
 * //        try{
 * //            Method addURL = URLClassLoader.class.getDeclaredMethod("addURL",URL.class);
 * //            addURL.setAccessible(true);
 * //            URL url = new URL(targetPath);
 * //            addURL.invoke(urlClassLoader,url);
 * //            Class.forName("Hello.hello");
 * //        }catch (Exception e){
 * //            e.printStackTrace();
 * //        }
 *
 * //        String helloBase64 = "yv66vgAAADQAHwoABgARCQASABMIABQKABUAFgcAFwcAGAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2N" +
 * //                "hbFZhcmlhYmxlVGFibGUBAAR0aGlzAQALTGp2bS9IZWxsbzsBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABkMABoAGwEAGEhlb"+
 * //         "GxvIENsYXNzIEluaXRpYWxpemVkIQcAHAwAHQAeAQAJanZtL0hlbGxvAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2" +
 * //                "YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACA" +
 * //                "ABAAkAAAAvAAEAAQAAAAUqtwABsQAAAAIACgAAAAYAAQAAAAMACwAAAAwAAQAAAAUADAANAAAACAAOAAgAAQAJAAAAJQACAAAAAAAJsgACEgO2AASxAAAAAQAK" +
 * //                "AAAACgACAAAABgAIAAcAAQAPAAAAAgAQ";
 */
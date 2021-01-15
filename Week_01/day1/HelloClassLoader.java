package test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            Class<?> helloClass= new HelloClassLoader().findClass("Hello");
            Object obj = helloClass.newInstance();
            Method helloMethod = helloClass.getMethod("hello");
            helloMethod.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = getClassFile("/Users/lvxy/Documents/java/homework/week1/Hello/Hello.xlass");
        try
        {
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private File getClassFile(String name) {
        File file = new File(name);
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.xclass的字节，因此要使用字节
        FileInputStream fis = new FileInputStream(file);
        byte[] data = toByteArray(fis);
        for(int i=0; i<data.length;i++){
            data[i] = (byte)((byte)255 -  data[i]);
        }
        return data;
    }
    private byte[] toByteArray(InputStream inputStream) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = inputStream.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}

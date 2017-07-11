package question;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class objectLocation {

 private static int apple = 10;
 private int orange = 10;
// private static final Unsafe unsafe = Unsafe.getUnsafe();
 
 public static void main(String[] args) throws Exception {
  
   Unsafe unsafe = getUnsafeInstance();
  
  Field appleField = objectLocation.class.getDeclaredField("apple");
  System.out.println("Location of Apple: "
    + unsafe.staticFieldOffset(appleField));

  Field orangeField = objectLocation.class.getDeclaredField("orange");
  System.out.println("Location of Orange: "
    + unsafe.objectFieldOffset(orangeField));
 }

 private static Unsafe getUnsafeInstance() throws SecurityException,
   NoSuchFieldException, IllegalArgumentException,
   IllegalAccessException {
  Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
  theUnsafeInstance.setAccessible(true);
  return (Unsafe) theUnsafeInstance.get(Unsafe.class);
 }
}
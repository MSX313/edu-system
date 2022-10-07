package org.msx.software.edu.system.business.util;

public class Util {

    public static long generateSerialVersionUID(Class classs) {
        return (long) generateEntityClassIdentifier(classs.getName());
    }

    public static int generateEntityClassIdentifier(String name) {
        String plaintext = name;
        int hash = name.hashCode();
        //TODO
//        MessageDigest m;
//        try {
//            m = MessageDigest.getInstance("MD5");
//            m.reset();
//            m.update(plaintext.getBytes());
//            byte[] digest = m.digest();
//            BigInteger bigInt = new BigInteger(1,digest);
//            String hashtext = bigInt.toString(10);
//            while(hashtext.length() < 32 ){
//                hashtext = "0"+hashtext;
//            }
//            int temp = 0;
//
//            for(int i =0; i<hashtext.length();i++){
//                char c = hashtext.charAt(i);
//                temp+=(int)c;
//            }
//            return hash+temp;
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        //TODO
        return hash;
    }
}

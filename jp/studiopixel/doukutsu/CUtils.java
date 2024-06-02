/*
 * Decompiled with CFR 0.152.
 */
package jp.studiopixel.doukutsu;

public class CUtils {
    public static int strlen(char[] str) {
        int i = 0;
        while (str[i] != '\u0000') {
            ++i;
        }
        return i;
    }

    public static void strcat(char[] dest, char[] src) {
        int dest_len = CUtils.strlen(dest);
        int src_len = CUtils.strlen(src);
        if (src_len >= 0) {
            System.arraycopy(src, 0, dest, dest_len, src_len);
        }
        dest[dest_len + src_len] = '\u0000';
    }

    public static void strcpy(char[] dest, char[] src) {
        int src_len = CUtils.strlen(src);
        if (src_len >= 0) {
            System.arraycopy(src, 0, dest, 0, src_len);
        }
        dest[src_len] = '\u0000';
    }

    public static void memcpy(char[] dest, char[] src, int len) {
        if (len >= 0) {
            System.arraycopy(src, 0, dest, 0, len);
        }
    }

    public static String nullTermToString(char[] str) {
        int len = CUtils.strlen(str);
        return new String(str, 0, len);
    }
}

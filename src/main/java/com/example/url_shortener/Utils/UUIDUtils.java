package com.example.url_shortener.Utils;

import java.util.Base64;
import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDUtils {

    public static String uuidToBase64(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return Base64.getUrlEncoder().encodeToString(bb.array());
    }

}

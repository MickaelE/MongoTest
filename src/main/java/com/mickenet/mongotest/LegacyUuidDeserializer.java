package com.mickenet.mongotest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class LegacyUuidDeserializer extends StdDeserializer<UUID> {
    public LegacyUuidDeserializer() {
        super(UUID.class);
    }

    @Override
    public UUID deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        parser.nextToken(); // $binary
        parser.nextToken(); // Base64 encoded UUID.
        String base64EncodedUuid = parser.getText();
        parser.nextToken(); // $type
        parser.nextToken(); // $type value, e.g. 03
        byte[] bytes = Base64.getDecoder().decode(base64EncodedUuid);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long mostSigBits = byteBuffer.getLong();
        long leastSigBits = byteBuffer.getLong();
        return new UUID(mostSigBits, leastSigBits);
    }
}

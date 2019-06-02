package pl.edu.agh.soa;
import io.jsonwebtoken.Jwts;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TokenGenerator {

    public static Key getKey()
    {
        String key = "oqwudnbseifuybae8f7gb23elrj3bf9sdbf3brf93fubqkfdlfkl";
        return new SecretKeySpec(key.getBytes(), 0, key.getBytes().length, "HMACSHA256");
    }

    public static String generateToken(String username)
    {
        return Jwts.builder().
                setSubject(username)
                .signWith(getKey())
                .setExpiration(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
                .compact();
    }
}

package main.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseLogin {

    // parse string json kedalam class menggunakan library jackson

    public final boolean auth;
    public final String message;
    public final String token;

    public ResponseLogin(@JsonProperty("auth") boolean auth, @JsonProperty("message") String message, @JsonProperty("token") String token) {
        this.auth = auth;
        this.message = message;
        this.token = token;
    }
}

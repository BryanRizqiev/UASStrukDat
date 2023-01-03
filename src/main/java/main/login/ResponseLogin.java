package main.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseLogin {

    public static boolean auth;
    public String message;
    public String token;

    public static boolean getAuth() {
        return auth;
    }

    public ResponseLogin(@JsonProperty("auth") boolean auth, @JsonProperty("message") String message, @JsonProperty("token") String token) {
        this.auth = auth;
        this.message = message;
        this.token = token;
    }
}

package main.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseLogin {

    public boolean auth;
    public String message;
    public String token;

    public ResponseLogin(@JsonProperty("auth") boolean auth, @JsonProperty("message") String message, @JsonProperty("token") String token) {
        this.auth = auth;
        this.message = message;
        this.token = token;
    }
}

package eurogeo.pl.linear.linearservice.payloads.response;

import lombok.Data;

@Data
public class MessageResponse {
    public String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}

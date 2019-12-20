package io.github.mayaul.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HelloResponse<T> {
    private int status;
    private String message;
    private T data;

    private HelloResponse(int status,
                          String message,
                          T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> HelloResponse<T> of(int status,
                                          String message,
                                          T data) {

        return new HelloResponse<>(status, message, data);
    }
}

package zishuo.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class RPCResponse {
    private int code;
    private String message;
    private Object data;

    public static RPCResponse success(Object data) {
        return RPCResponse.builder().code(200).data(data).build();
    }
    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).message("Server error").build();
    }
}

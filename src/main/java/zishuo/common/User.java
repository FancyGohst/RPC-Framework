package zishuo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

// store a copy of object, send them to another process which runs on the same system or over the network
public class User implements Serializable {
    private Integer id;
    private String userName;
    private Boolean sex;
}

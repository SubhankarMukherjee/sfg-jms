package guru.springframework.sfgjms.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorld implements Serializable {

    private static final long serialVersionUID = -8213889536111792539L;

    private UUID uuid;
    private String message;
}

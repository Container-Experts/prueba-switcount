package co.com.swiftcount.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Pair <T, G> {

    private T first;
    private G second;
    
}

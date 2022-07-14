package gql.util;

import java.util.UUID;

/**
 * UUIDUtils
 *
 * @author yakir on 2022/07/14 11:04.
 */
public class UUIDUtils {

    public static String get() {
        return UUID.randomUUID()
                .toString()
                .replaceAll("-", "");
    }
}

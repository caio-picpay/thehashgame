package domain.config;

import java.util.List;

/**
 * 0 | 1 | 2
 * ---------
 * 3 | 4 | 5
 * ---------
 * 6 | 7 | 8
 */
public class Config {
    private Config(){}
    public static final List<Integer> VALID_POSITIONS = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
    public static final List<List<Integer>> WIN_POSITIONS = List.of(
            // horizontal
            List.of(0, 1, 2),
            List.of(3, 4, 5),
            List.of(6, 7, 8),

            // vertical
            List.of(0, 3, 6),
            List.of(1, 4, 7),
            List.of(2, 5, 8),

            // diagonal
            List.of(0, 4, 8),
            List.of(2, 4, 6)
    );
}

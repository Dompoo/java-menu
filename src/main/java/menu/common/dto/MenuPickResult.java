package menu.common.dto;

import java.util.List;

public record MenuPickResult(
		String coachName,
		List<String> menuName
) {
}

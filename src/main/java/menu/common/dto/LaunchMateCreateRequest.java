package menu.common.dto;

import java.util.List;

public record LaunchMateCreateRequest(
		String name,
		List<String> noEatMenus
) {
}

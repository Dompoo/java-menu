package menu.common.dto;

import java.util.List;

public record MenuPickResults(
		List<String> menuPickingDayNames,
		List<MenuPickResult> menuPickResults
) {
}

package menu.common.dto;

import java.util.List;

public record LaunchMatesCreateRequest(
		List<LaunchMateCreateRequest> launchMateCreateRequests
) {
}

package menu;

public enum CustomExceptions {
	
	ILLEGAL_LAUNCH_MATES_SIZE(
			"점심 메이트들은 %d~%d명 사이여야 합니다.",
			IllegalArgumentException.class
	),
	LAUNCH_MATES_NAME_DUPLICATED(
			"점심 메이트들의 이름은 중복될 수 없습니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_LAUNCH_MATE_NAME_LENGTH(
			"코치 이름은 %d~%d자 사이여야 합니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_NO_EAT_MENU_SIZE(
			"못 먹는 메뉴는 최대 %d개 까지만 가능합니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_MENU_TYPE_PICK_SIZE(
			"메뉴 종류 뽑기는 최대 %d개 까지만 가능합니다.",
			IllegalArgumentException.class
	),
	MENU_NAME_NOT_FOUND(
			"존재하지 않는 메뉴명 입니다.",
			IllegalArgumentException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	CustomExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get(Object... args) {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message.formatted(args));
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}

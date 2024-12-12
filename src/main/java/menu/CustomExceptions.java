package menu;

public enum CustomExceptions {
	
	ILLEGAL_COACH_NAME_LENGTH(
			"코치 이름은 %d~%d자 사이여야 합니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_MENU_TYPE_PICK_SIZE(
			"메뉴 종류 뽑기는 최대 %d개 까지만 가능합니다.",
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

package menu.domain;

import menu.common.exceptin.CustomExceptions;
import menu.service.objectPicker.StringShuffler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
	
	규동(MenuType.일식),
	우동(MenuType.일식),
	미소시루(MenuType.일식),
	스시(MenuType.일식),
	가츠동(MenuType.일식),
	오니기리(MenuType.일식),
	하이라이스(MenuType.일식),
	라멘(MenuType.일식),
	오코노미야끼(MenuType.일식),
	
	김밥(MenuType.한식),
	김치찌개(MenuType.한식),
	쌈밥(MenuType.한식),
	된장찌개(MenuType.한식),
	비빔밥(MenuType.한식),
	칼국수(MenuType.한식),
	불고기(MenuType.한식),
	떡볶이(MenuType.한식),
	제육볶음(MenuType.한식),
	
	깐풍기(MenuType.중식),
	볶음면(MenuType.중식),
	동파육(MenuType.중식),
	짜장면(MenuType.중식),
	짬뽕(MenuType.중식),
	마파두부(MenuType.중식),
	탕수육(MenuType.중식),
	토마토_달걀볶음(MenuType.중식),
	고추잡채(MenuType.중식),
	
	팟타이(MenuType.아시안),
	카오_팟(MenuType.아시안),
	나시고렝(MenuType.아시안),
	파인애플_볶음밥(MenuType.아시안),
	쌀국수(MenuType.아시안),
	똠얌꿍(MenuType.아시안),
	반미(MenuType.아시안),
	월남쌈(MenuType.아시안),
	분짜(MenuType.아시안),
	
	라자냐(MenuType.양식),
	그라탱(MenuType.양식),
	뇨끼(MenuType.양식),
	끼슈(MenuType.양식),
	프렌치_토스트(MenuType.양식),
	바게트(MenuType.양식),
	스파게티(MenuType.양식),
	피자(MenuType.양식),
	파니니(MenuType.양식),
	;
	
	private final MenuType menuType;
	
	Menu(MenuType menuType) {
		this.menuType = menuType;
	}
	
	public static Menu from(String menuName) {
		return Arrays.stream(Menu.values())
				.filter(menu -> menu.getFormatedMenuName().equals(menuName))
				.findFirst()
				.orElseThrow(CustomExceptions.MENU_NAME_NOT_FOUND::get);
	}
	
	public static Menu pickMenu(MenuType menuType, List<Menu> ignoredMenuType, StringShuffler stringShuffler) {
		List<String> validMenuNames = Arrays.stream(Menu.values())
				.filter(menu -> menu.menuType == menuType)
				.filter(menu -> !ignoredMenuType.contains(menu))
				.map(Menu::getFormatedMenuName)
				.collect(Collectors.toList());
		
		String pickMenuName = stringShuffler.pick(validMenuNames);
		return from(pickMenuName);
	}
	
	public String getFormatedMenuName() {
		return this.name().replaceAll("_", " ");
	}
}

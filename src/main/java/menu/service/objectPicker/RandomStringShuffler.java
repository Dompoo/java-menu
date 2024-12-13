package menu.service.objectPicker;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomStringShuffler implements StringShuffler {
	
	@Override
	public String pick(List<String> strings) {
		return Randoms.shuffle(strings).getFirst();
	}
}

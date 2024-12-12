package menu.service.objectPicker;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomObjectPicker <T> implements ObjectPicker<T> {
	
	@Override
	public T pick(List<T> objects) {
		return Randoms.shuffle(objects).getFirst();
	}
}

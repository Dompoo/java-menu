package menu.service.objectPicker;

import java.util.List;

public interface ObjectPicker <T> {
	
	T pick(List<T> objects);
}

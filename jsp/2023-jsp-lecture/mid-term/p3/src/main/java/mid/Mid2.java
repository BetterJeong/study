package mid;
import java.util.*;

public class Mid2 {
	List<Mid1> list = new ArrayList<>();
	
	public void add(Mid1 m) {
		list.add(m);
	}
	public void delete(Mid1 m) {
		list.remove(m);
	}
	public List<Mid1> getList() {
		return list;
	}
	public Mid1 getUser(String username) {
		for(Mid1 user : list) {
			if(user.getUsername().equals(username))
				return user;
		}
		return null;
	}

}

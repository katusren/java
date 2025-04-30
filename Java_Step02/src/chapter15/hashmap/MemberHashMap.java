package chapter15.hashmap;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {

    private HashMap<Integer, String> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<Integer, String>();
    }

    // addMember
    public void addMember(Member member) {
        hashMap.put(member.memberId(), member.memberName());
    }

    // removeMember
    public boolean removeMember(int memberId) {
        while (hashMap.containsKey(memberId)) {
            hashMap.remove(memberId);
            return true;
        }
        System.err.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    // showAllMember
    public void showAllMember() {
        Iterator<Integer> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            String name = hashMap.get(key);
            System.out.println(name + ": " + key);
        }
        System.out.println();
    }
}

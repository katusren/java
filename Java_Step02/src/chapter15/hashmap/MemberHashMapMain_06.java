package chapter15.hashmap;

import java.util.HashMap;

public class MemberHashMapMain_06 {

    public static void main(String[] args) {
        MemberHashMap memeberHashMap = new MemberHashMap();

        memeberHashMap.addMember(new Member(1001, "이수정"));
        memeberHashMap.addMember(new Member(1002, "박진영"));
        memeberHashMap.addMember(new Member(1003, "김우진"));

        Member memberJung = new Member(1004, "정하나");
        memeberHashMap.addMember(memberJung);

        memeberHashMap.showAllMember();

        memeberHashMap.removeMember(1002);
        memeberHashMap.addMember(new Member(1003, "김우진"));
        memeberHashMap.showAllMember();
    }

}

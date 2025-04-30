package chapter15.hashmap;

public record Member(int memberId, String memberName) {

    public static final int sno = 0;

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
    }
}

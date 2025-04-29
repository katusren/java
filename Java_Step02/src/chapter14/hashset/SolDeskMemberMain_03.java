package chapter14.hashset;

public class SolDeskMemberMain_03 {

    public static void main(String[] args) {

        SolDeskMemberManager manager = new SolDeskMemberManager();

        // 회원가입시 필요한 정보를 저장하는 클래스
        SolDeskMember member1 = new SolDeskMember(1001, "이민정");
        SolDeskMember member2 = new SolDeskMember(1002, "박진영");
        SolDeskMember member3 = new SolDeskMember(1003, "정하나");
        SolDeskMember member4 = new SolDeskMember(1004, "김우진");
        // manager.addMember(new SolDeskMember(0, null));

        manager.addMember(member1);
        manager.addMember(member2);
        manager.addMember(member3);
        manager.addMember(member4);
        System.out.println();

        manager.showAllMember();

        // 중복 회원 추가 시도
        SolDeskMember duplicateMember = new SolDeskMember(1003, "정하나");
        manager.addMember(duplicateMember);

        // 전체 회원 목록
        System.out.println("================================");
        manager.showAllMember();

    }
}
